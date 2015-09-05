/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo.customComponents;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class JComboBoxAnios extends JComboBox<Integer> {

	public JComboBoxAnios() {
		super();
		List<Integer> lista = new ArrayList<>();
		for (int i = 1900; i < 2016; i++) {
			lista.add(i);
		}
		Integer[] anios = lista.toArray(new Integer[lista.size()]);
		DefaultComboBoxModel<Integer> temp = new DefaultComboBoxModel<>(anios);
		this.setModel(temp);
	}
}