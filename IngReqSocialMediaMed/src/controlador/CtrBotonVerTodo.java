package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import modelo.Propuesta;

public class CtrBotonVerTodo implements MouseListener{

	private  JList<Propuesta> p;
	private JLabel boton;
	private DefaultListModel<Propuesta> lista;
	
	public CtrBotonVerTodo(JLabel vertodo, JList<Propuesta> propuesta, DefaultListModel<Propuesta> listapropuestas) {
		// TODO Auto-generated constructor stub
		boton = vertodo;
		p = propuesta;
		lista = listapropuestas;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		p = new JList<Propuesta>(lista);
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

