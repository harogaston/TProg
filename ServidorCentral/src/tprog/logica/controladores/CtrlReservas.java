package tprog.logica.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import persistencia.FacturaF;
import persistencia.PromocionF;
import persistencia.ServicioF;
import tprog.logica.clases.Cliente;
import tprog.logica.clases.Proveedor;
import tprog.logica.dt.DTCliente;
import tprog.logica.dt.DTFacturaF;
import tprog.logica.dt.DTLineaReserva;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinReserva;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.EstadoReserva;
import tprog.logica.interfaces.ICtrlReservas;
import tprog.logica.manejadores.ManejadorProductos;
import tprog.logica.manejadores.ManejadorReservas;
import tprog.logica.manejadores.ManejadorUsuarios;

public class CtrlReservas implements ICtrlReservas {

	private String nickname;
	private String nicknameP;
	private DTMinPromocion dtP;
	private DTMinServicio dtS;
	private DTReserva dtR;
	private int idReserva;
	private Set<DTLineaReserva> lineasReserva;
	private float precioTotal;

	public CtrlReservas() {
		this.nickname = null;
		this.nicknameP = null;
		this.dtP = null;
		this.dtS = null;
		this.dtR = null;
		this.idReserva = -1;
		this.precioTotal = 0;
		this.lineasReserva = new HashSet();
	}

	@Override
	public void seleccionarCliente(String Nickname) {
		this.nickname = Nickname;
	}

	@Override
	public void seleccionarProveedor(String NicknameP) {
		this.nicknameP = NicknameP;
	}

	@Override
	public Set<DTMinPromocion> listarPromociones() throws Exception {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.listarPromociones();
	}

	@Override
	public Set<DTMinServicio> listarServicios() throws Exception {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.listarServicios();
	}

	@Override
	public void seleccionarPromocion(DTMinPromocion DTP) {
		this.dtP = DTP;
	}

	@Override
	public void seleccionarServicio(DTMinServicio DTS) {
		this.dtS = DTS;
	}

	@Override
	public void ingresarLineaReserva(int cant, Date fInicial, Date fFinal) {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		if (dtS == null) {
			float precio = manejadorP.getPrecioPromocion(dtP);
			DTLineaReserva dtLR = new DTLineaReserva(cant, fInicial, fFinal, null, dtP.getIdPromocion(), dtP.getNicknameP(), precio);
			lineasReserva.add(dtLR);
			precioTotal += precio * cant;
		} else {
			float precio = manejadorP.getPrecioServicio(dtS);
			DTLineaReserva dtLR = new DTLineaReserva(cant, fInicial, fFinal, dtS.getIdServicio(), null, dtS.getNicknameP(), precio);
			lineasReserva.add(dtLR);
			precioTotal += precio * cant;
		}
	}
        
        @Override
	public void quitarLineaReserva(int idLineaReserva) {
            Iterator<DTLineaReserva> iter = lineasReserva.iterator();
            while (iter.hasNext()){
                DTLineaReserva linea = iter.next();
                if (linea.getIdLineaReserva() == idLineaReserva){
                    precioTotal =- linea.getPrecio() * linea.getCantidad();
                    iter.remove();
                }
            }
        }

	@Override
	public Set<DTMinServicio> listarServiciosProveedor() {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.listarServiciosProveedor(nicknameP);
	}

	@Override
	public Set<DTMinPromocion> listarPromocionesProveedor() {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.listarPromocionesProveedor(nicknameP);
	}

	@Override
	public DTReserva mostrarReservaTemporal() {
                
                    Date fechaTemp = new Date();
                    int anio = fechaTemp.getYear() + 1900;
                    int mes = fechaTemp.getMonth();
                    int dia = fechaTemp.getDate();
                    Date fecha = new Date(anio, mes, dia);
                    EstadoReserva estado = EstadoReserva.Registrada;
                    if (!lineasReserva.isEmpty())
                        return new DTReserva(-1, fecha, estado, precioTotal, lineasReserva);
                    else
                        // -2 bandera para saber que la reserva no tiene lineas de reserva sin pasar null
                        return new DTReserva(-2, fecha, estado, precioTotal, lineasReserva);
                
		
	}

	@Override
	public void altaReserva(DTReserva DTR) throws Exception {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		Cliente cliente = manejadorU.getCliente(nickname);
		ManejadorReservas manejadorR = ManejadorReservas.getInstance();
		manejadorR.agregarReserva(cliente, DTR);
	}

	@Override
	public Set<DTMinReserva> listarReservas() throws Exception {
		ManejadorReservas manejadorR = ManejadorReservas.getInstance();
		return manejadorR.listarReservas();
	}

	@Override
	public Set<DTReserva> listarReservasProveedor() {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.getProveedor(nicknameP).listarReservasParciales();
	}

	@Override
	public Set<String> listarNotificacionesProveedor() {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		Proveedor proveedor = manejadorU.getProveedor(nicknameP);
		Set<String> notificaciones = proveedor.getNotificaciones();
		return notificaciones;
	}

	@Override
	public void limpiarNotificacionesProveedor() {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		Proveedor proveedor = manejadorU.getProveedor(nicknameP);
		//limpio las notificaciones del proveedor
		proveedor.limpiarNotificaciones();
	}

	@Override
	public void seleccionarReserva(int IdReserva) {
		this.idReserva = IdReserva;
	}

	/**
	 * Devuelve un DTCliente correspondiente al cliente que realizó la reserva
	 * seleccionada con seleccionarReserva
	 *
	 * @return
	 */
	@Override
	public DTCliente getClienteAsociado() {
		ManejadorReservas manejadorR = ManejadorReservas.getInstance();
		return manejadorR.getReservas().get(idReserva).getCliente().crearDT();
	}

	@Override
	public DTReserva infoReserva() {
		ManejadorReservas manejadorR = ManejadorReservas.getInstance();
		dtR = manejadorR.infoReserva(idReserva);
		return dtR;
	}

	@Override
	public boolean cambiarEstadoReserva(EstadoReserva nuevoEstado) {
		ManejadorReservas manejadorR = ManejadorReservas.getInstance();
		return manejadorR.cambiarEstadoReserva(idReserva, nuevoEstado);
	}

	@Override
	public void facturarReserva(String idProveedor, String nickCliente, int idReserva) {
		//se tendria que seleccionar la reserva y no pasar el parametro
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		Proveedor proveedor = manejadorU.getProveedor(idProveedor);
		if (proveedor.facturarReserva(idReserva)){
                    seleccionarCliente(nickCliente);
                    confirmarFactura(idReserva);
                }
        
	}
    @Override
    public void confirmarFactura(int idReserva){
        //persistir la wea
        EntityManagerFactory entityMF = Persistence.createEntityManagerFactory("ServidorCentralPU");
        EntityManager entityM = entityMF.createEntityManager();
        
        //verifico que la factura no esté en la bd
        //obtengo el id de la factura asociada al idReserva
        Query query = entityM.createQuery("Select f from FacturaF f where f.idReserva = ?1");
        query.setParameter(1, idReserva);
          //asumimos que hay una sola factura por reserva
        if (query.getResultList().isEmpty()){
            seleccionarReserva(idReserva);
            DTReserva dtReserva = infoReserva();
            Set<DTLineaReserva> lineasR = dtReserva.getLineasReserva();
            Iterator<DTLineaReserva> iter = lineasR.iterator();
            //agrego todas las lineas a la base y la factura en la misma transaccion
            try{
                entityM.getTransaction().begin();
                ArrayList<ServicioF> serviciosF = new ArrayList<ServicioF>();
                ArrayList<PromocionF> promocionesF = new ArrayList<PromocionF>();
                while (iter.hasNext()){
                    DTLineaReserva linea = iter.next();
                    if (linea.getServicio() != null){
                        ServicioF servicio = new ServicioF();
                        servicio.setCantidad(linea.getCantidad());
                        servicio.setNicknameProveedor(linea.getNicknameProveedor());
                        servicio.setNombre(linea.getServicio());
                        servicio.setPrecio(linea.getPrecio());
                        serviciosF.add(servicio);
                        entityM.persist(servicio);
                    }else if (linea.getPromocion() != null){
                        PromocionF promocion = new PromocionF();
                        promocion.setCantidad(linea.getCantidad());
                        promocion.setNicknameProveedor(linea.getNicknameProveedor());
                        promocion.setNombre(linea.getPromocion());
                        promocion.setPrecio(linea.getPrecio());
                        promocionesF.add(promocion);
                        entityM.persist(promocion);
                    }
                }
                // agrego la factura asociada a las lineas que ya persisti
                FacturaF factura = new FacturaF();
               // factura.setFecha(dtReserva.getFCreacion()); //es la fecha de la reserva o la fecha del momento en que se factura??
                factura.setIdReserva(idReserva);
                factura.setFecha(new Date());
                factura.setMonto(dtReserva.getPrecioTotal());
                factura.setNicknameCliente(nickname); // y el cliente en la reserva??? suponemos que esta marcado en nickname
                factura.setServicios(serviciosF);
                factura.setPromociones(promocionesF);
                entityM.persist(factura);
                entityM.flush();
                entityM.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                entityM.getTransaction().rollback();
            } finally {
                entityM.close();
                entityMF.close();
            }
        }
        else{
            System.out.println("la factura ya se encuentra persistida");
        }
    }
    
    @Override
    public void limpiarBD(){
        EntityManagerFactory entityMF = Persistence.createEntityManagerFactory("ServidorCentralPU");
        EntityManager entityM = entityMF.createEntityManager();
        try{
            entityM.getTransaction().begin();
            Query qu = entityM.createQuery("DELETE FROM ServicioF");
            Query que = entityM.createQuery("DELETE FROM PromocionF");
            Query qude = entityM.createQuery("DELETE FROM FacturaF");
            qu.executeUpdate();
            que.executeUpdate();
            qude.executeUpdate();
            entityM.getTransaction().commit();
            System.out.println("Se borraron todas las facturas de la base");
        } catch (Exception e) {
            e.printStackTrace();
            entityM.getTransaction().rollback();
        } finally {
            entityM.close();
            entityMF.close();
        }
    }
    
    @Override
    public DTFacturaF verFactura(int idReserva){
        //si se llamó a esta operación es porque la factura de ese idReserva está en la base
        EntityManagerFactory entityMF = Persistence.createEntityManagerFactory("ServidorCentralPU");
        EntityManager entityM = entityMF.createEntityManager();
        seleccionarReserva(idReserva);
        String idR = Integer.toString(idReserva);
        //System.out.println("uosa");
        DTFacturaF dtF = null;
        try{
            entityM.getTransaction().begin();
            
            //obtengo el id de la factura asociada al idReserva
            Query query = entityM.createQuery("Select f from FacturaF f where f.idReserva = ?1");
            query.setParameter(1, idReserva);
            //long idFactura = (long) query.getSingleResult();
            FacturaF factura = (FacturaF) query.getSingleResult(); //asumimos que hay una sola factura por reserva
              
            long idFactura = factura.getId();
            System.out.println("factura " + idFactura);
            System.out.println("reserva "+factura.getIdReserva());
            System.out.println("monto "+factura.getMonto());
            System.out.println("cliente "+factura.getNicknameCliente());
            
            //obtengo los id's de los servicios asociados al id de la factura
            Collection<ServicioF> servis =  factura.getServicios();
            Set<ServicioF> servicios = new HashSet();
            Iterator<ServicioF> iter = servis.iterator();
            while(iter.hasNext()){
                ServicioF servi = iter.next();
                servicios.add(servi);
                System.out.println("servi " + servi.getNombre());
            }
            //obtengo los id's de las promociones asociadas al id de la factura 
            Collection<PromocionF> promos =  factura.getPromociones();
            Set<PromocionF> promociones = new HashSet();
            Iterator<PromocionF> iter2 = promos.iterator();
            while(iter2.hasNext()){
                PromocionF promo = iter2.next();
                promociones.add(promo);
                System.out.println("promo " + promo.getNombre());
            }
            //armo el DTFacturaF
            dtF = factura.crearDTFacturaF();
            entityM.getTransaction().commit();
            
            
        } catch (Exception e) {
            e.printStackTrace();
            entityM.getTransaction().rollback();
        } finally {
            entityM.close();
            entityMF.close();
        }
        return dtF;
    }
    
	@Override
	public boolean eliminarReserva() {
		ManejadorReservas manejadorR = ManejadorReservas.getInstance();
		return manejadorR.eliminarReserva(idReserva);
	}

	@Override
	public EstadoReserva getEstadoReserva() {
		ManejadorReservas manejadorR = ManejadorReservas.getInstance();
		return manejadorR.getEstadoReserva(this.idReserva);
	}

	@Override
	public void liberarMemoriaControlador() {
		this.nickname = null;
		this.nicknameP = null;
		this.dtP = null;
		this.dtS = null;
		this.dtR = null;
		this.idReserva = -1;
		this.precioTotal = 0;
		this.lineasReserva = new HashSet();
	}

	public String getNickname() {
		return nickname;
	}

	public String getNicknameP() {
		return nicknameP;
	}

	public DTMinPromocion getDtP() {
		return dtP;
	}

	public DTMinServicio getDtS() {
		return dtS;
	}

	public DTReserva getDtR() {
		return dtR;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public Set<DTLineaReserva> getLineasReserva() {
		return lineasReserva;
	}

}
