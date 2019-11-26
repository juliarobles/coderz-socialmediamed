package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.ONG;
import modelo.Propuesta;
import modelo.Tupla;

public class CtrListaONG implements ListSelectionListener {

	private JList<String> ong;
	private DefaultListModel<Tupla> lista;
	private Map<String, String> mapa;

	public CtrListaONG(JList<String> ong2, DefaultListModel<Tupla> listapropuestas, Map<String, String> mapa) {
		this.ong = ong2;
		lista = listapropuestas;
		this.mapa = mapa;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(!ong.isSelectionEmpty()) {
			lista.clear();
			for(Tupla pr : Propuesta.getPropuestasFiltradoSimple(mapa.get(ong.getSelectedValue()))) {
				lista.addElement(pr);
			}
		}
			
	}

}
