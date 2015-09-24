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
