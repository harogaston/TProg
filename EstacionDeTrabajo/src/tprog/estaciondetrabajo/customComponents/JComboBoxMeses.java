/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.estaciondetrabajo.customComponents;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class JComboBoxMeses extends JComboBox<String> {

	public JComboBoxMeses() {
		super();
		String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre",
		"Octubre", "Noviembre", "Diciembre"};
		DefaultComboBoxModel<String> temp = new DefaultComboBoxModel<>(meses);
		this.setModel(temp);
	}
}
