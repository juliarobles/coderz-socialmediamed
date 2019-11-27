package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import modelo.Alumno;
import modelo.BD;
import modelo.ConsultaiDuma;
import modelo.PAS;
import modelo.PDI;
import modelo.Usuario;
import vista.CompletarPerfil;
import vista.InicioSesion;
import vista.MenuPrincipal;
import vista.MenuPrincipalUsuario;

public class CtrLoginUMA implements MouseListener{
	
	private InicioSesion vista;
	private MenuPrincipal principal;
	private JButton miboton;
		  
	public CtrLoginUMA (InicioSesion vista, MenuPrincipal principal, JButton btn) {
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
		// TODO Auto-generated method stub
		String email = vista.emailuma.getText();
		char[] password = vista.passuma.getPassword();
		String pass = String.valueOf(password);
		
		if(email.isEmpty() && pass.isEmpty()) {
			vista.errorUma("Introduzca los datos");
		}else if(email.isEmpty()) {
			vista.errorUma("Campo email vacio");
		}else if(pass.isEmpty()) {
			vista.errorUma("Campo contraseña vacio");
		}
		
		if(email != null && pass != null && !email.isEmpty() && !pass.isEmpty()) {
			ConsultaiDuma ci = new ConsultaiDuma();
			if(ci.consultar(email, pass)) {
				BD mibd = new BD();
				List<Object[]> lista = mibd.Select("SELECT * FROM USUARIOSUMA WHERE email = '" + email + "';");
				if(lista.isEmpty()) { //El usuario es nuevo en nuestra BD
					CompletarPerfil cp = new CompletarPerfil(principal, ci, email);
					cp.setVisible(true);
					
				} else { //No es usuario nuevo
					Usuario usu;
					Object[] usuario = lista.get(0);
					int tipo = (Integer)usuario[1];
					
					if(tipo == 0) { //Es un gestor, hacer interfaz de gestor
						principal.cambiarGestor();
					} else if (tipo == 1) { //Es alumno
						usu = new Alumno((String)usuario[0]);
						principal.cambiarUsuario(usu);
					} else if (tipo == 2) {
						usu = new PDI((String)usuario[0]);
						principal.cambiarUsuario(usu);
					} else {
						usu = new PAS((String)usuario[0]);
						principal.cambiarUsuario(usu);
					}
					principal.setEnabled(true);
				}
				vista.dispose();
				
			} else {
				vista.errorUma("El email y/o la pass no son validos");
			}
		}		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
			
	}
	
	public void mouseEntered(MouseEvent e) {
		miboton.setForeground(Color.DARK_GRAY);
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		miboton.setForeground(Color.WHITE);
	}
}