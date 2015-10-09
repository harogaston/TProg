package tprog.logica.dt;

public class DTMinPromocion {

	private final String nicknameP;
	private final String idPromocion;

	public DTMinPromocion(String NicknameP, String IdPromocion) {
		this.nicknameP = NicknameP;
		this.idPromocion = IdPromocion;
	}

	public String getNicknameP() {
		return this.nicknameP;
	}

	public String getIdPromocion() {
		return this.idPromocion;
	}

	@Override
	public String toString() {
		return "Nickname del proveedor: " + nicknameP
				+ "\n" + "ID de servicio: " + idPromocion + "\n";
	}
}
