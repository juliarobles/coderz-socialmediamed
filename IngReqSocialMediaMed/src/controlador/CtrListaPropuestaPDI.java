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
import vista.GestionPropuestasPDI;

public class CtrListaPropuestaPDI implements ListSelectionListener {

	private JPanel panel;
	private JList<Tupla> lista; 
	private JLabel titulo;
	private JLabel descripcion;
	private JLabel fechaini;
	private JLabel fechafin;
	private JLabel ong;
	private GestionPropuestasPDI vista;
	
	public CtrListaPropuestaPDI(JPanel panel, JList<Tupla> lista, JLabel titulo, JLabel descripcion, JLabel fechaini,
			JLabel fechafin, JLabel ong, GestionPropuestasPDI vista) {
		this.panel = panel;
		this.lista = lista;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaini = fechaini;
		this.fechafin = fechafin;
		this.ong = ong;
		this.vista = vista;
	}
	//Importante para controlar el tama�o de los campos que escribimos
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(!lista.isSelectionEmpty()) {
			Propuesta p = new Propuesta(Integer.parseInt(lista.getSelectedValue().elemento1));
			titulo.setText("<html>" + p.getTitulo() + "<html>");
			descripcion.setText("<html>" + p.getDescripcion()+ "<html>");
			fechaini.setText(p.getFechainicial());
			fechafin.setText(p.getFechafinal());
			ong.setText(p.getOng().getNombre());
			vista.ambito.setText(p.getAmbito().toString());
			vista.zonaaccion.setText(p.getZonaaccion().toString());
			vista.tipooferta.setText(p.getTipooferta().toString());
			String proy = (p.getProyecto() == null) ? "No incluido en ning�n proyecto" : p.getProyecto().getNombre();
			vista.proyecto.setText(proy);
			vista.setPropuesta(p);
			if(p.getAsignatura() == null) {
				vista.tipo.setText("Investigaci�n");
			} else {
				vista.tipo.setText("Aprendizaje - " + p.getAsignatura().getNombre());
			}
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
			vista.ambito.setText("");
			vista.zonaaccion.setText("");
			vista.tipooferta.setText("");
			vista.proyecto.setText("");
			vista.tipo.setText("");
			for(Component c : panel.getComponents()) {
				c.setVisible(false);
			}
		}
	}

}
