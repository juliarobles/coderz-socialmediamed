package controlador;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.*;
import vista.CrearPropuesta;
import vista.Toast;
import vista.MenuPrincipal;
import vista.MenuPrincipalONG;

public class CtrCrearPropuesta implements MouseListener{
	private CrearPropuesta panel;
	//private Fecha Inicio;
	//private Fecha Fin;
	private ONG ong;
	private MenuPrincipal padre;
	public  CtrCrearPropuesta (CrearPropuesta panel, ONG ong, MenuPrincipal padre) {
		this.panel = panel;
		this.ong = ong;
		this.padre = padre;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(((JButton) o ) instanceof JButton) {
			JButton a = (JButton) o;
			if(a.equals(panel.getBtnCancelar())) {
				 JPanel menuONG = new MenuPrincipalONG(padre, ong);
				 padre.cambiardePropuestaAONG(ong);
				
			}else if(a.equals(panel.getBtnCrear())) {
				System.out.println(panel.getCampoExplicacion());
				if(todoCorrecto().equals(" ")) {
					//( String titulo, String descripcion, String fechainicial, String fechafinal, ZonaAccion zonaaccion, TipoOferta tipooferta, Ambito ambito, 
					//Asignatura asignatura, Proyecto proyecto, ONG ong, PDI pdi, int aceptadogestor, int aceptadopdi)
					new Propuesta( panel.getCampoTitulo(), panel.getCampoExplicacion(), panel.getFechaIni(), panel.getFechaFin(), 
							(ZonaAccion)panel.zonaaccion.getSelectedItem(), (TipoOferta)panel.tipooferta.getSelectedItem(), (Ambito)panel.ambito.getSelectedItem(),
							null, null, ong, null, 0, 0);
					System.out.println("propuesta creada correctamente");
				}else {
					JFrame error = new Toast(todoCorrecto());
					error.setVisible(true);
				}
			
			}
		}
	}

	private String todoCorrecto() {
		String res = " ";
		
		//Comprobar que no se pueda poner una fecha en el pasado
		/*
		 * if(panel.getAnyoFin().getText().trim().isEmpty()) res +=
		 * "El campo año final está vacío<br>"; else
		 * if(Integer.parseInt(panel.getAnyoFin().getText())> 2099) res +=
		 * "No te pases de gracioso<br>";
		 * if(panel.getAnyoInicio().getText().trim().isEmpty())res+=
		 * "El campo año inicio está vacío<br>"; else
		 * if(Integer.parseInt(panel.getAnyoInicio().getText())> 2099) res +=
		 * "No te pases de gracioso 2<br>";
		 */
		if(panel.getCampoExplicacion().trim().isEmpty()) res += "La descripción está vacía<br>";
		if(panel.getCampoTitulo().trim().isEmpty()) res += "El título está vacío<br>";
		/*
		 * if(res.equals(" ")) { Inicio = new Fecha
		 * ((Integer)panel.getdIni().getSelectedItem(),
		 * (Meses)panel.getmIni().getSelectedItem(),
		 * Integer.valueOf(panel.getAnyoInicio().getText())); Fin = new Fecha
		 * ((Integer)panel.getdFin().getSelectedItem(),
		 * (Meses)panel.getmFin().getSelectedItem(),
		 * Integer.valueOf(panel.getAnyoFin().getText())); if(!
		 * Inicio.igualOAnterior(Fin))res+=
		 * "La fecha de inicio es posterior a la fecha de finalización.<br>"; }
		 */
		
		System.out.println(res);
		return res;
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * public void itemStateChanged(ItemEvent e) { // TODO Auto-generated method
	 * stub
	 * 
	 * Object o = e.getSource(); System.out.println("Holaaaa?"); if(o instanceof
	 * JComboBox) { System.out.println("El objeto es instancia de combobox");
	 * if(((JComboBox) o).equals(panel.getmFin())) {
	 * System.out.println("Meses final"); JComboBox cbm = (JComboBox)o; JComboBox
	 * <Integer>cbd = panel.getdFin(); cbd.removeAllItems();
	 * añadirDias(cbd,(Fecha.comprobarDias((Meses)cbm.getSelectedItem())));
	 * System.out.println("Tengo que poner " +
	 * Fecha.comprobarDias((Meses)cbm.getSelectedItem()) + "dias");
	 * panel.setdFin(cbd); }else if(((JComboBox) o).equals(panel.getmIni())) {
	 * System.out.println("Meses inicio"); JComboBox cbm = (JComboBox)o; JComboBox
	 * <Integer>cbd = panel.getdIni(); cbd.removeAllItems();
	 * añadirDias(cbd,(Fecha.comprobarDias((Meses)cbm.getSelectedItem())));
	 * System.out.println("Tengo que poner " +
	 * Fecha.comprobarDias((Meses)cbm.getSelectedItem()) + "dias");
	 * panel.setdIni(cbd); } } } private void añadirDias(JComboBox<Integer> cbd, int
	 * i) { for(int cont = 1; cont <= i; cont++) { cbd.addItem(cont); }
	 * 
	 * }
	 */
	
		
	
}
