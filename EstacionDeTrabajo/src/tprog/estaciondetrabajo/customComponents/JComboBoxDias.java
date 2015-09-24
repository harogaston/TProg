package tprog.estaciondetrabajo.customComponents;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class JComboBoxDias extends JComboBox<Integer> {

	public JComboBoxDias() {
		super();
		List<Integer> lista = new ArrayList<>();
		for (int i = 1; i < 32; i++) {
			lista.add(i);
		}
		Integer[] dias = lista.toArray(new Integer[lista.size()]);
		DefaultComboBoxModel<Integer> temp = new DefaultComboBoxModel<>(dias);
		this.setModel(temp);
	}
}
