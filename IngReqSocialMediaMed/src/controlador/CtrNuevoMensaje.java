package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import modelo.Mensaje;
import modelo.ONG;
import modelo.Usuario;
import modelo.todosUsuarios;
import vista.MenuPrincipal;
import vista.NuevoMensaje;

public class CtrNuevoMensaje implements MouseListener {
	private NuevoMensaje panel;
	private todosUsuarios emisor;
	private MenuPrincipal padre;
	private todosUsuarios receptor;
	
	public CtrNuevoMensaje(MenuPrincipal p, NuevoMensaje n, todosUsuarios e, todosUsuarios r) {
		panel = n;
		padre = p;
		emisor = e;
		receptor = r;
	}
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Botón pulsado");
		Object o = e.getSource();
		if((JButton) o instanceof JButton) {
			JButton a = (JButton) o;
			if(a.equals(panel.getEnviarMensaje())) {
				int rec = 2 ; //En principio
				if(this.receptor instanceof ONG) {
					System.out.println("Es una ONG");
				}else if(this.receptor instanceof Usuario ) {
					System.out.println("Es un participante");
				}else {
					System.out.println("Es un gestor");
				}
				System.out.println("Mensaje aún no enviado");
				Mensaje.enviarMensaje(emisor.getEmail(), receptor.getEmail(), panel.getMensaje().getText(), rec);
				System.out.println("Mensaje enviado");
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

}
