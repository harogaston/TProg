/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.estaciondetrabajo.ui;

import tprog.logica.dt.DTMinReserva;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.interfaces.ICtrlProductos;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class ModificacionCategorias extends javax.swing.JInternalFrame {

    /**
     * Creates new form VerInformacionDeCliente
     *
     * @param padre
     * @param ctrlProductos
     */
    public ModificacionCategorias(ModificacionServicio padre, ICtrlProductos ctrlProductos) {
        initComponents();
        this.padre = padre;
        this.ctrlProductos = ctrlProductos;
        arbolCategorias.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        seleccionCategoriasInterfaz.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultMutableTreeNode raiz = ctrlProductos.listarCategorias();
        arbolCategorias.removeAll();
        arbolCategorias.setModel(new DefaultTreeModel(raiz));
        arbolCategorias.updateUI();
        seleccionCategorias.clear();
        categoriasServicio = ctrlProductos.listarCategoriasServicio();
        for (String s : categoriasServicio) {
            seleccionCategorias.add(s);
        }
        seleccionCategorias.sort(null);
        if (seleccionCategorias.size() == 0) {
            botonQuitar.setEnabled(false);
        }
		getRootPane().setDefaultButton(botonConfirmar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();
        botonConfirmar = new javax.swing.JButton();
        buttonAtras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        arbolCategorias = new javax.swing.JTree();
        botonAgregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        seleccionCategoriasInterfaz = new javax.swing.JList(seleccionCategorias);
        botonQuitar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setTitle("Actualizar Servicio - Categorías");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(640, 480));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Seleccione la Categoría \"hoja\" a la que pertenece el nuevo Servicio.");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 486, 30));
        label.getAccessibleContext().setAccessibleDescription("");

        botonConfirmar.setText("Confirmar");
        botonConfirmar.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                botonConfirmarComponentShown(evt);
            }
        });
        botonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(botonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, -1, -1));

        buttonAtras.setText("< Atras");
        buttonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, -1, -1));

        arbolCategorias.setModel(null);
        arbolCategorias.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                arbolCategoriasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(arbolCategorias);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 190, 280));

        botonAgregar.setText("<html><div align=\"center\">Agregar<br>Categoría</html>");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 110, 50));

        jScrollPane2.setViewportView(seleccionCategoriasInterfaz);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 170, 280));

        botonQuitar.setText("<html><div align=\"center\">Quitar<br>Categoría</html>");
        botonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarActionPerformed(evt);
            }
        });
        getContentPane().add(botonQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 110, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    }//GEN-LAST:event_formComponentShown

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        reservas = null;
    }//GEN-LAST:event_formComponentHidden

    private void arbolCategoriasValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_arbolCategoriasValueChanged
    }//GEN-LAST:event_arbolCategoriasValueChanged

    private void buttonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtrasActionPerformed
        // TODO add your handling code here:
        seleccionCategorias.clear();
        seleccionCategoriasInterfaz.updateUI();
        arbolCategorias.removeAll();
        arbolCategorias.updateUI();
        this.dispose();
        padre.setVisible(true);
    }//GEN-LAST:event_buttonAtrasActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) arbolCategorias.getLastSelectedPathComponent();
        if (nodo != null) {
            String categoriaActual = nodo.toString();
            //me fijo si la categoría ya no está en la selección actual
            if (!seleccionCategorias.contains(categoriaActual)) {
                //si la categoria seleccionada es simple, la agrego
                if (nodo.isLeaf()) {
                    seleccionCategorias.add(categoriaActual);
                    if (seleccionCategorias.size() > 0) {
                        botonQuitar.setEnabled(true);
                    }
                    seleccionCategorias.sort(null);
                } else {
                    JOptionPane.showMessageDialog(this, "Por favor seleccione una categoria hoja", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Esa categoría ya fue agregada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor escoja una categoría antes de intentar agregar una.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        seleccionCategoriasInterfaz.updateUI();
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarActionPerformed
        String categoria = (String) seleccionCategoriasInterfaz.getSelectedValue();
        if (categoria != null) {
            seleccionCategorias.remove(seleccionCategoriasInterfaz.getSelectedIndex());
            seleccionCategorias.sort(null);
            if (seleccionCategorias.size() == 0) {
                botonQuitar.setEnabled(false);
            }
            seleccionCategoriasInterfaz.clearSelection();
            seleccionCategoriasInterfaz.updateUI();
        } else {
            JOptionPane.showMessageDialog(this, "Tiene que seleccionar una categoría para intentar quitarla.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonQuitarActionPerformed

    private void botonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfirmarActionPerformed
        if (!seleccionCategorias.isEmpty()) {
            try {
                //primero recorro el set de categorias original, y a aquellas
                //categorias que no esten en mi lista nueva, les aplico quitar
                for (String s : categoriasServicio) {
                    Iterator it = seleccionCategorias.iterator();
                    boolean found = false;
                    //mientras no encuentre la categoria sigo buscandola
                    while (it.hasNext() && !found) {
                        if (it.next().toString().equals(s)) //si la encuentro no la quito
                        {
                            found = true;
                        }
                    }
                    //si no la encontré, la saco
                    if (!found) {
                        ctrlProductos.quitarCategoria(s);
                    }
                }

                //ahora recorro la lista nueva, y cada elemento que no esté en mi
                //set de categorías original, lo agrego a las categorias del servicio
                Iterator it = seleccionCategorias.iterator();
                while (it.hasNext()) {
                    //si la categoria actual no esta dentro de las originales
                    //del servicio, la agrego
                    String categoria = it.next().toString();
                    if (!categoriasServicio.contains(categoria)) {
                        ctrlProductos.agregarCategoria(categoria);
                    }
                }
                JOptionPane.showMessageDialog(this, "Categorías modificadas con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                padre.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage().toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor escoja al menos una categoría antes de avanzar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonConfirmarActionPerformed

    private void botonConfirmarComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_botonConfirmarComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_botonConfirmarComponentShown

    private ModificacionServicio padre;
    Set<String> categoriasServicio; //categorias originales del servicio
    Vector<String> seleccionCategorias = new Vector<>();
    Set<DTMinServicio> listaServicios;
    Set<DTMinReserva> reservas;
    ICtrlProductos ctrlProductos;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbolCategorias;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonConfirmar;
    private javax.swing.JButton botonQuitar;
    private javax.swing.JButton buttonAtras;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label;
    private javax.swing.JList seleccionCategoriasInterfaz;
    // End of variables declaration//GEN-END:variables
}