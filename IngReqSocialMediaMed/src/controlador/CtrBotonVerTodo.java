package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

import modelo.ONG;
import modelo.Propuesta;
import modelo.Tupla;

public class CtrBotonVerTodo implements MouseListener{

	//private  JList<Propuesta> p;
	private JLabel boton;
	private DefaultListModel<Tupla> lista;
	private JList<String> ong;
	
	public CtrBotonVerTodo(JLabel vertodo, DefaultListModel<Tupla> listapropuestas, JList<String> ong) {
		// TODO Auto-generated constructor stub
		boton = vertodo;
		lista = listapropuestas;
		this.ong = ong;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(!ong.isSelectionEmpty()) {
			ong.clearSelection();
		}
		
		lista.clear();
		for(Tupla p : Propuesta.getPropuestasSimple()) {
				lista.addElement(p);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		boton.setForeground(new Color(51, 204, 204));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		boton.setForeground(Color.BLACK);
		
	}

}

