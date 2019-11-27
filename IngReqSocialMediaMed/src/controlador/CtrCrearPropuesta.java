package controlador;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import modelo.*;
import vista.CrearPropuesta;

public class CtrCrearPropuesta implements MouseListener, ItemListener{
	private CrearPropuesta panel;
	private Fecha Inicio;
	private Fecha Fin;
	private ONG ong;

	public  CtrCrearPropuesta (CrearPropuesta panel, ONG ong) {
		this.panel = panel;
		this.ong = ong;
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(((JButton) o ) instanceof JButton) {
			JButton a = (JButton) o;
			if(a.equals(panel.getBtnCancelar())) {
				 
				
			}else if(a.equals(panel.getBtnCrear())) {
				Fecha inicio = new Fecha ((Integer)panel.getdIni().getSelectedItem(), (Meses)panel.getmIni().getSelectedItem(), panel.getAnyoInicio());
				Fecha fin = new Fecha ((Integer)panel.getdFin().getSelectedItem(), (Meses)panel.getmFin().getSelectedItem(), panel.getAnyoFin());
				new Propuesta( panel.getCampoTitulo(), panel.getCampoExplicacion(),inicio.toString() , fin.toString(), ong);
				System.out.println("propuesta creada correctamente");
			}
		}
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
				añadirDias(cbd,(Fecha.comprobarDias((Meses)cbm.getSelectedItem())));
				System.out.println("Tengo que poner " + Fecha.comprobarDias((Meses)cbm.getSelectedItem()) + "dias");
				panel.setdFin(cbd);
			}else if(((JComboBox) o).equals(panel.getmIni())) {
				System.out.println("Meses inicio");
				JComboBox cbm = (JComboBox)o;
				JComboBox <Integer>cbd = panel.getdIni();
				cbd.removeAllItems();
				añadirDias(cbd,(Fecha.comprobarDias((Meses)cbm.getSelectedItem())));
				System.out.println("Tengo que poner " + Fecha.comprobarDias((Meses)cbm.getSelectedItem()) + "dias");
				panel.setdIni(cbd);
			}
		}
	}
	private void añadirDias(JComboBox<Integer> cbd, int i) {
		for(int cont = 1; cont <= i; cont++) {
			cbd.addItem(cont);
		}
		
	}
}
