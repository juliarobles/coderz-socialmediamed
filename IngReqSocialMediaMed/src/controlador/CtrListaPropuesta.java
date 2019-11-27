package controlador;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Propuesta;
import modelo.Tupla;
import vista.GestionPropuestas;

public class CtrListaPropuesta implements ListSelectionListener {

	private JPanel panel;
	private JList<Tupla> lista; 
	private JLabel titulo;
	private JLabel descripcion;
	private JLabel fechaini;
	private JLabel fechafin;
	private JLabel ong;
	private GestionPropuestas vista;
	
	public CtrListaPropuesta(JPanel panel, JList<Tupla> lista, JLabel titulo, JLabel descripcion, JLabel fechaini,
			JLabel fechafin, JLabel ong, GestionPropuestas vista) {
		this.panel = panel;
		this.lista = lista;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaini = fechaini;
		this.fechafin = fechafin;
		this.ong = ong;
		this.vista = vista;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(!lista.isSelectionEmpty()) {
			Propuesta p = new Propuesta(Integer.parseInt(lista.getSelectedValue().elemento1));
			titulo.setText("<html>" + p.getTitulo() + "<html>");
			descripcion.setText("<html>" + p.getDescripcion()+ "<html>");
			fechaini.setText(p.getFechainicial());
			fechafin.setText(p.getFechafinal());
			ong.setText(p.getOng().getNombre());
			vista.setPropuesta(p);
			for(Component c : panel.getComponents()) {
				c.setVisible(true);
			}
		} else {
			titulo.setText("");
			descripcion.setText("");
			fechaini.setText("");
			fechafin.setText("");
			ong.setText("");
			vista.setPropuesta(null);
			for(Component c : panel.getComponents()) {
				c.setVisible(false);
			}
		}
	}

}
