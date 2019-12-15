package controlador;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Actividad;
import modelo.Tupla;
import vista.GestionActividades;

public class CtrListaGestionActividades implements ListSelectionListener {
	private GestionActividades vista;
	private JList<Tupla> lista;

	public CtrListaGestionActividades(GestionActividades vista, JList<Tupla> listaActividades) {
		this.vista = vista;
		this.lista = listaActividades;
	}
	
	
	public void valueChanged(ListSelectionEvent e) {
		if(!lista.isSelectionEmpty()) {
			vista.establecerConsultado(new Actividad(Integer.parseInt(lista.getSelectedValue().elemento1)));
		}
		
	}
}
