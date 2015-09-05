/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTUbicacion;
import com.tprog.logica.interfaces.ICtrlProductos;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class AltaDeServicio5 extends javax.swing.JInternalFrame {

	private ICtrlProductos ctrlProductos;
	private AltaDeServicio4 padre;

	/**
	 * Creates new form AltaDeServicio5
	 *
	 * @param padre
	 * @param ctrlProductos
	 */
	public AltaDeServicio5(AltaDeServicio4 padre, ICtrlProductos ctrlProductos) {
		initComponents();
		this.padre = padre;
		this.ctrlProductos = ctrlProductos;
		cargarCiudades();
	}

	private void cargarCiudades() {
		setCiudades = ctrlProductos.listarCiudades();
		Enumeration e = setCiudades.breadthFirstEnumeration();
		/*
		 El árbol tiene la siguiente estructura de tres niveles:
		 Root que engloba a todos los subárboles
		 Nivel de países
		 Nivel de ciudades
		 Teniendo una ciudad, se puede hacer getParent() y obtener a su
		 país correspondiente
		 */
		while (e.hasMoreElements()) {
			TreeNode nodo = (TreeNode) e.nextElement();
			if (nodo.getChildCount() == 0) { //es hoja, o sea ciudad
				listaCiudades.add(nodo.toString());
//                System.out.println(nodo.toString());
			}
		}
		listaCiudadesOrigenInterfaz.updateUI();
		listaCiudadesDestinoInterfaz.updateUI();
	}

	private boolean isWhiteSpace(String s) {
		return (s.matches("^\\s*$") || s.matches("^\\s.*"));
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        listaCiudadesOrigenInterfaz = new javax.swing.JComboBox();
        listaCiudadesDestinoInterfaz = new javax.swing.JComboBox();
        buttonConfirmar = new javax.swing.JButton();
        buttonAtras = new javax.swing.JButton();
        checkBoxCiudadDestino = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPaneDescripcion = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textPanePrecio = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        buttonImagen2 = new javax.swing.JButton();
        buttonImagen3 = new javax.swing.JButton();
        labelImagen1 = new javax.swing.JLabel();
        labelImagen2 = new javax.swing.JLabel();
        labelImagen3 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setTitle("Alta de Servicio");
        setPreferredSize(new java.awt.Dimension(640, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Ingrese los datos del servicio y haga click en \"Confirmar\".");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 11, 480, -1));

        jLabel2.setText("Ciudad de Origen");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 147, -1));

        listaCiudadesOrigenInterfaz.setModel(new javax.swing.DefaultComboBoxModel(listaCiudades));
        listaCiudadesOrigenInterfaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaCiudadesOrigenInterfazActionPerformed(evt);
            }
        });
        getContentPane().add(listaCiudadesOrigenInterfaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 166, -1));

        listaCiudadesDestinoInterfaz.setVisible(false);
        listaCiudadesDestinoInterfaz.setModel(new javax.swing.DefaultComboBoxModel(listaCiudades));
        listaCiudadesDestinoInterfaz.setFocusable(false);
        listaCiudadesDestinoInterfaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaCiudadesDestinoInterfazActionPerformed(evt);
            }
        });
        getContentPane().add(listaCiudadesDestinoInterfaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 168, -1));

        buttonConfirmar.setText("Confirmar");
        buttonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, -1, -1));

        buttonAtras.setText("< Atras");
        buttonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, -1, -1));

        checkBoxCiudadDestino.setSelected(false);
        checkBoxCiudadDestino.setText("Ciudad de Destino");
        checkBoxCiudadDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxCiudadDestinoActionPerformed(evt);
            }
        });
        getContentPane().add(checkBoxCiudadDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel3.setText("Descripción");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 43, -1, -1));

        jScrollPane1.setViewportView(textPaneDescripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 75, 169, -1));

        jLabel4.setText("Precio");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jScrollPane2.setViewportView(textPanePrecio);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 168, -1));

        jLabel5.setText("Imágenes");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 43, -1, -1));

        jButton1.setText("Imágen 1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        buttonImagen2.setText("Imágen 2");
        buttonImagen2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImagen2ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonImagen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, -1, -1));

        buttonImagen3.setText("Imágen 3");
        buttonImagen3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImagen3ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonImagen3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, -1));

        labelImagen1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(labelImagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 90, 90));

        labelImagen2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(labelImagen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 90, 90));

        labelImagen3.setAutoscrolls(true);
        labelImagen3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(labelImagen3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 90, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmarActionPerformed
		String descripcion = textPaneDescripcion.getText();
		String precioString = textPanePrecio.getText();

		// Verifico precio
		boolean okPrecio;
		float precio = 0.0F;
		try {
			precio = Float.parseFloat(precioString);
			okPrecio = true;
		} catch (Exception e) {
			okPrecio = false;
		}

		// Verifico descripción
		boolean okDescripcion = !isWhiteSpace(descripcion);

		// Verifico origen
		boolean okOrigen = (ciudadOrigen != null);

		// Verifico destino
		boolean okDestino = false;
		boolean tieneDestino = checkBoxCiudadDestino.isSelected();
		if (tieneDestino) {
			okDestino = (ciudadDestino != null);
		}

		boolean okCrear = false;
		// Si todo ok, creo el servico
		if (okPrecio && okDescripcion && okOrigen) {
			// Guardo las imágenes que se hayan cargado
			Set<String> imagenes = new HashSet<>();

			if (ruta1 != null) {
				imagenes.add(ruta1);
			}
			if (ruta2 != null) {
				imagenes.add(ruta2);
			}
			if (ruta3 != null) {
				imagenes.add(ruta3);
			}

			//busco pais origen en el arbol
			String paisOrigen = null;
			Enumeration arbolCiudades = setCiudades.breadthFirstEnumeration();
			while (arbolCiudades.hasMoreElements()) {
				TreeNode nodo = (TreeNode) arbolCiudades.nextElement();
				if (nodo.toString().equals(ciudadOrigen)) {
					//obtengo a su padre para asociarlo a pais
					paisOrigen = nodo.getParent().toString();
				}
			}

			// Construyo el DTUbicacion
			DTUbicacion origen = new DTUbicacion(ciudadOrigen, paisOrigen);

			// Lo paso al Crtl
			ctrlProductos.seleccionarOrigen(origen);

			// Chequeo si tiene destino
			if (tieneDestino) {
				if (okDestino) {
					//busco pais destino en el arbol
					String paisDestino = null;
					arbolCiudades = setCiudades.breadthFirstEnumeration();
					while (arbolCiudades.hasMoreElements()) {
						TreeNode nodo = (TreeNode) arbolCiudades.nextElement();
						if (nodo.toString().equals(ciudadDestino)) {
							//obtengo a su padre para asociarlo a pais
							paisDestino = nodo.getParent().toString();
						}
					}

					// Construyo el DTUbicacion
					DTUbicacion destino = new DTUbicacion(ciudadDestino, paisDestino);

					// Lo paso al Crtl
					ctrlProductos.seleccionarDestino(destino);
				} else {
					JOptionPane.showMessageDialog(this, "Por favor seleccione una ciudad destino, o desmarque la casilla", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			
			// Creo el servicio
			ctrlProductos.altaServicio(descripcion, precio, imagenes);
			JOptionPane.showMessageDialog(this, "Servicio creado con éxito", "Exito", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			
		} else if (!okDescripcion) {
			JOptionPane.showMessageDialog(this, "Por favor ingrese una descripción", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (!okPrecio) {
			JOptionPane.showMessageDialog(this, "El precio ingresado no es correcto", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (!okOrigen) {
			JOptionPane.showMessageDialog(this, "Por favor seleccione una ciudad de origen", "Error", JOptionPane.ERROR_MESSAGE);
		}
    }//GEN-LAST:event_buttonConfirmarActionPerformed

    private void checkBoxCiudadDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxCiudadDestinoActionPerformed
		if (checkBoxCiudadDestino.isSelected()) {
			listaCiudadesDestinoInterfaz.setVisible(true);
		} else {
			listaCiudadesDestinoInterfaz.setVisible(false);
		}
    }//GEN-LAST:event_checkBoxCiudadDestinoActionPerformed

	@Override
	public void dispose() {
		padre.dispose();
		super.dispose();
	}

    private void buttonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtrasActionPerformed
		this.setVisible(false);
		this.padre.setVisible(true);
    }//GEN-LAST:event_buttonAtrasActionPerformed

	private void mostrarImagen(String ruta, JLabel label) throws IOException {
		//obtengo archivo desde ruta
		File f = new File(ruta);
		//creo imagen
		Image img = ImageIO.read(f);
		//redimensiono para que entre en la JLabel
		Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		//armo el ImageIcon
		ImageIcon imageIcon = new ImageIcon(dimg);
		//lo asocio a la JLabel
		label.setIcon(imageIcon);
	}

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Imágenes JPG & PNG ", "jpg", "png");
		fc.setFileFilter(filter);
		int seleccion = fc.showDialog(this, "Adjuntar");
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			// Para guardar la imagen
			File file = fc.getSelectedFile();
			ruta1 = file.getPath();
			try {
				mostrarImagen(ruta1, labelImagen1);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonImagen2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImagen2ActionPerformed
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Imágenes JPG & PNG ", "jpg", "png");
		fc.setFileFilter(filter);
		int seleccion = fc.showDialog(this, "Adjuntar");
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			// Para guardar la imagen
			File file = fc.getSelectedFile();
			ruta2 = file.getPath();
			try {
				mostrarImagen(ruta2, labelImagen2);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
    }//GEN-LAST:event_buttonImagen2ActionPerformed

    private void buttonImagen3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImagen3ActionPerformed
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Imágenes JPG & PNG ", "jpg", "png");
		fc.setFileFilter(filter);
		int seleccion = fc.showDialog(this, "Adjuntar");
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			// Para guardar la imagen
			File file = fc.getSelectedFile();
			ruta3 = file.getPath();
			try {
				mostrarImagen(ruta3, labelImagen3);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
    }//GEN-LAST:event_buttonImagen3ActionPerformed

    private void listaCiudadesOrigenInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaCiudadesOrigenInterfazActionPerformed
		ciudadOrigen = (String) listaCiudadesOrigenInterfaz.getSelectedItem();
    }//GEN-LAST:event_listaCiudadesOrigenInterfazActionPerformed

    private void listaCiudadesDestinoInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaCiudadesDestinoInterfazActionPerformed
		ciudadDestino = (String) listaCiudadesDestinoInterfaz.getSelectedItem();
    }//GEN-LAST:event_listaCiudadesDestinoInterfazActionPerformed

	String ciudadOrigen = null;
	String ciudadDestino = null;
	DefaultMutableTreeNode setCiudades;
	String ruta1;
	String ruta2;
	String ruta3;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAtras;
    private javax.swing.JButton buttonConfirmar;
    private javax.swing.JButton buttonImagen2;
    private javax.swing.JButton buttonImagen3;
    private javax.swing.JCheckBox checkBoxCiudadDestino;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelImagen1;
    private javax.swing.JLabel labelImagen2;
    private javax.swing.JLabel labelImagen3;
    private javax.swing.JComboBox listaCiudadesDestinoInterfaz;
    private Vector<String> listaCiudades = new Vector<>();
    private javax.swing.JComboBox listaCiudadesOrigenInterfaz;
    private javax.swing.JTextPane textPaneDescripcion;
    private javax.swing.JTextPane textPanePrecio;
    // End of variables declaration//GEN-END:variables
}
