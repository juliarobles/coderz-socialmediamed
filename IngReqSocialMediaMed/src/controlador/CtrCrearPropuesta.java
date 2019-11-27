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
import vista.ErrorVista;
import vista.MenuPrincipal;
import vista.MenuPrincipalONG;

public class CtrCrearPropuesta implements MouseListener, ItemListener{
	private CrearPropuesta panel;
	private Fecha Inicio;
	private Fecha Fin;
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
					
					new Propuesta( panel.getCampoTitulo(), panel.getCampoExplicacion(),Inicio.toString() , Fin.toString(), ong);
					System.out.println("propuesta creada correctamente");
				}else {
					JFrame error = new ErrorVista(todoCorrecto());
					error.setVisible(true);
				}
			
			}
		}
	}

	private String todoCorrecto() {
		String res = " ";
		
	
		if(panel.getAnyoFin().getText().trim().isEmpty()) res += "El campo a�o final est� vac�o" + "\n";
		if(panel.getAnyoInicio().getText().trim().isEmpty())res+= "El campo a�o inicio est� vac�o\n";
		if(res.equals(" ")) {
			Inicio = new Fecha ((Integer)panel.getdIni().getSelectedItem(), (Meses)panel.getmIni().getSelectedItem(), Integer.valueOf(panel.getAnyoInicio().getText()));
			Fin = new Fecha ((Integer)panel.getdFin().getSelectedItem(), (Meses)panel.getmFin().getSelectedItem(), Integer.valueOf(panel.getAnyoFin().getText()));
			if(! Inicio.igualOAnterior(Fin))res+= "La fecha de inicio es posterior a la fecha de finalizaci�n.";
		}
		
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
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		Object o = e.getSource();
		System.out.println("Holaaaa?");
		if(o instanceof JComboBox) {
			System.out.println("El objeto es instancia de combobox");
			if(((JComboBox) o).equals(panel.getmFin())) {
				System.out.println("Meses final");
				JComboBox cbm = (JComboBox)o;
				JComboBox <Integer>cbd = panel.getdFin();
				cbd.removeAllItems();
				a�adirDias(cbd,(Fecha.comprobarDias((Meses)cbm.getSelectedItem())));
				System.out.println("Tengo que poner " + Fecha.comprobarDias((Meses)cbm.getSelectedItem()) + "dias");
				panel.setdFin(cbd);
			}else if(((JComboBox) o).equals(panel.getmIni())) {
				System.out.println("Meses inicio");
				JComboBox cbm = (JComboBox)o;
				JComboBox <Integer>cbd = panel.getdIni();
				cbd.removeAllItems();
				a�adirDias(cbd,(Fecha.comprobarDias((Meses)cbm.getSelectedItem())));
				System.out.println("Tengo que poner " + Fecha.comprobarDias((Meses)cbm.getSelectedItem()) + "dias");
				panel.setdIni(cbd);
			}
		}
	}
	private void a�adirDias(JComboBox<Integer> cbd, int i) {
		for(int cont = 1; cont <= i; cont++) {
			cbd.addItem(cont);
		}
		
	}
	
		
	
}
