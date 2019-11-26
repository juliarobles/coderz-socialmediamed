package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.ONG;
import modelo.Propuesta;

public class CtrListaONG implements ListSelectionListener {

	private JList<ONG> ong;
	private JList<Propuesta> p;

	public CtrListaONG(JList<ONG> ong, JList<Propuesta> propuesta) {
		this.ong = ong;
		p = propuesta;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		DefaultListModel<Propuesta> lista = new DefaultListModel<Propuesta>();
		for(ONG o : ong.getSelectedValuesList()) {
			for(Propuesta pr : Propuesta.getPropuestasFiltrado(o)) {
				lista.addElement(pr);
			}
		}
	}

}
