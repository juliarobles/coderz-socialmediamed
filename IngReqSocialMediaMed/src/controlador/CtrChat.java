package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import modelo.Mensaje;
import modelo.todosUsuarios;
import vista.AdapterChat;
import vista.Chat;

public class CtrChat implements MouseListener {
	private Chat panel;
	private todosUsuarios usu;
	private String receptor;
	private List<Mensaje> lista;
	public CtrChat(Chat p, todosUsuarios u) {
		panel = p;
		usu = u;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Object o = e.getSource();
		if( o instanceof AdapterChat) {
			AdapterChat a = (AdapterChat) o;
			 this.receptor =a.getReceptor();
			
			 lista= Mensaje.getMensajes(usu.getEmail(), a.getReceptor());
			
			crearConversacion(lista);
			panel.getEnviar().setEnabled(true);
		}else if( o instanceof JButton ) {
			System.out.println("Enviar");
			Mensaje m = new Mensaje(this.usu.getEmail(), receptor, panel.getLblMensaje().getText() );
			lista.add(m);
			Mensaje.enviarMensaje(this.usu.getEmail(), receptor, panel.getLblMensaje().getText(), 2 );
			panel.getConversacion().setText("");
			panel.getLblMensaje().setText("");
			crearConversacion(lista);
			
			//Guardar nuevos mensajes (Enviar)
		}
			
			
		
	}

	private void crearConversacion(List<Mensaje> lista) {
		Iterator<Mensaje> iter = lista.iterator();
		JTextArea c = panel.getConversacion();
		
		String conver = "";
		while(iter.hasNext()) {
			System.out.println("Añadido mensaje");
			Mensaje m = iter.next();
			conver += m.getEmisor() + ":" + m.getMensaje() + "\n";
		}
		System.out.println(c);
		c.setText( conver );
		panel.setConversacion(c);
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
