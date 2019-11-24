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
		if(email != null && pass != null && !email.isEmpty() && !pass.isEmpty()) {
			ConsultaiDuma ci = new ConsultaiDuma();
			if(ci.consultar(email, pass)) {
				BD mibd = new BD();
				List<Object[]> lista = mibd.Select("SELECT * FROM USUARIOSUMA WHERE email = '" + email + "';");
				Usuario usu;
				if(lista.isEmpty()) { //El usuario es nuevo en nuestra BD
					String tipo = ci.dameTipo();
					if(tipo.equalsIgnoreCase("Estudiante")) {
						mibd.Insert("INSERT INTO USUARIOSUMA VALUES ('" + email + "', 1);");
						usu = new Alumno(email, ci.dameNombre(), ci.dameApellido1(), ci.dameApellido2());
					} else if (tipo.equalsIgnoreCase("PDI")) {
						mibd.Insert("INSERT INTO USUARIOSUMA VALUES ('" + email + "', 2);");
						usu = new PDI(email, ci.dameNombre(), ci.dameApellido1(), ci.dameApellido2());
					} else {
						mibd.Insert("INSERT INTO USUARIOSUMA VALUES ('" + email + "', 3);");
						usu = new PAS(email, ci.dameNombre(), ci.dameApellido1(), ci.dameApellido2());
					}
					
					CompletarPerfil cp = new CompletarPerfil(usu, principal);
					cp.setVisible(true);
					
				} else { //No es usuario nuevo
					Object[] usuario = lista.get(0);
					int tipo = (Integer)usuario[1];
					
					if(tipo == 0) { //Es un gestor, hacer interfaz de gestor
						usu = null;
					} else if (tipo == 1) { //Es alumno
						usu = new Alumno((String)usuario[0]);
					} else if (tipo == 2) {
						usu = new PDI((String)usuario[0]);
					} else {
						usu = new PAS((String)usuario[0]);
					}
					principal.cambiarUsuario(usu);
					principal.setEnabled(true);
				}
				vista.dispose();
				
			} else {
				//Poner un error o algo de que no esta en la uma
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