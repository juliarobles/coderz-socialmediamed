package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.ONG;
import modelo.Usuario;

public class MenuPrincipal extends JFrame {

	private JPanel invitado;
	private JPanel usuario;
	private JPanel ong;
	private JPanel gestor;
	private JPanel gestionPropuestas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipalUsuario.class.getResource("/resources/_Logo AccionSocialMed png.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1321, 715);
		setSize(1100, 715);
		setLocationRelativeTo(null);
		invitado = new MenuPrincipalInvitado(this);
		invitado.setVisible(true);
		setContentPane(invitado);
		
		
	}
	
	public void cambiarAInvitado() {
		if(usuario != null) {
			usuario.setVisible(false);
			usuario = null;
		}
		if(ong != null) {
			ong.setVisible(false);
			ong = null;
		}
		if(gestor != null) {
			gestor.setVisible(false);
			gestor = null;
		}
		invitado.setVisible(true);
		setContentPane(invitado);
	}
	
	public void cambiarUsuario(Usuario usu) {
		usuario = new MenuPrincipalUsuario(this, usu);
		usuario.setVisible(true);
		invitado.setVisible(false);
		setContentPane(usuario);
	}
	
	public void cambiarONG(ONG usu) {
		ong = new MenuPrincipalONG(this, usu);
		ong.setVisible(true);
		invitado.setVisible(false);
		setContentPane(ong);
	}

	public void cambiarGestor() {
		if(gestor == null) {
			gestor = new MenuPrincipalGestor(this);
		}
		if(gestionPropuestas != null) {
			gestionPropuestas.setVisible(false);
			gestionPropuestas = null;
		}
		gestor.setVisible(true);
		invitado.setVisible(false);
		setContentPane(gestor);
	}
	
	public void cambiarAGestionPropuestas() {
		gestionPropuestas = new GestionPropuestas();
		gestionPropuestas.setVisible(true);
		gestor.setVisible(false);
		setContentPane(gestionPropuestas);
	}
	
	

}
