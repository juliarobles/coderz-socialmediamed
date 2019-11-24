package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Usuario;

public class MenuPrincipal extends JFrame {

	private JPanel invitado;
	private JPanel usuario;

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
		setLocationRelativeTo(null);
		invitado = new MenuPrincipalInvitado(this);
		invitado.setVisible(true);
		setContentPane(invitado);
		
		
	}
	
	public void cambiarAInvitado() {
		usuario.setVisible(false);
		invitado.setVisible(true);
		setContentPane(invitado);
	}
	
	public void cambiarUsuario(Usuario usu) {
		usuario = new MenuPrincipalUsuario(this, usu);
		usuario.setVisible(true);
		invitado.setVisible(false);
		setContentPane(usuario);
	}
	
	

}
