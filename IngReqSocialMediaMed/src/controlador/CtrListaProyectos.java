package controlador;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Proyecto;
import modelo.Tupla;
import vista.GestionProyectos;

public class CtrListaProyectos  implements ListSelectionListener  {

	private GestionProyectos vista;
	private JList<Tupla> lista;

	public CtrListaProyectos(GestionProyectos vista, JList<Tupla> listaProyectos) {
		this.vista = vista;
		this.lista = listaProyectos;
	}
	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(!lista.isSelectionEmpty()) {
			vista.establecerConsultado(new Proyecto(Integer.parseInt(lista.getSelectedValue().elemento1)));
		}
		
	}

}
