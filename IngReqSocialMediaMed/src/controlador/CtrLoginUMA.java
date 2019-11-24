package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import modelo.ConsultaiDuma;
import modelo.Usuario;
import vista.InicioSesion;
import vista.MenuPrincipal;
import vista.MenuPrincipalUsuario;

public class CtrLoginUMA implements MouseListener{
	
	private InicioSesion vista;
	private MenuPrincipal principal;
		  
	public CtrLoginUMA (InicioSesion vista, MenuPrincipal principal) {
		  this.vista = vista;
		  this.principal = principal;
	}  

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		String email = vista.emailuma.getText();
		char[] password = vista.passuma.getPassword();
		String pass = String.valueOf(password);
		ConsultaiDuma ci = new ConsultaiDuma();
		if(ci.consultar(email, pass)) {
			principal.cambiarUsuario(new Usuario(email));
			vista.dispose();
		}
				
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