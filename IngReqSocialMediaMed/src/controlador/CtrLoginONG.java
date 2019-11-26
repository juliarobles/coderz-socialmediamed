package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;

import modelo.BD;
import modelo.ONG;
import vista.InicioSesion;
import vista.MenuPrincipal;

public class CtrLoginONG implements MouseListener{

	private InicioSesion vista;
	private MenuPrincipal principal;
	private JButton miboton;
	
	public CtrLoginONG (InicioSesion vista, MenuPrincipal principal, JButton btn) {
		  this.vista = vista;
		  this.principal = principal;
		  miboton = btn;
	}  
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		String email = vista.emailong.getText();
		char[] password = vista.passong.getPassword();
		String pass = String.valueOf(password);
		if(email != null && pass != null && !email.isEmpty() && !pass.isEmpty()) {
			BD mibd = new BD();
			List<Object[]> lista = mibd.Select("SELECT * FROM USUARIOONG WHERE email = '" + email + "' and pass = '" + pass + "';");
			if(!lista.isEmpty()) {
				ONG ong = new ONG(email);
				principal.setEnabled(true);
				principal.cambiarONG(ong);
				vista.dispose();
			}
			vista.errorOng();
			//A�ADIR AVISO DE QUE ESTA MAL LA CONTRASE�A O ALGO
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		miboton.setForeground(Color.GRAY);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		miboton.setForeground(Color.BLACK);
		
	}

}
