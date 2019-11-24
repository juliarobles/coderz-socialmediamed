package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Usuario;

public class Perfil extends JDialog {

	private PerfilUsuario2 verPerfil;
	private EditarPerfil editarPerfil;
	private Usuario usu;

	/**
	 * Create the dialog.
	 */
	public Perfil(Usuario usu) {
		setTitle("AccionSocialMed - Editar perfil");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditarPerfil.class.getResource("/resources/_Logo AccionSocialMed png.png")));
		setResizable(false);
		setBounds(100, 100, 800, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.usu = usu;
		verPerfil = new PerfilUsuario2(usu, this);
		verPerfil.setVisible(true);
		setContentPane(verPerfil);
		
	}
	
	public void cambiarAEditar() {
		editarPerfil = new EditarPerfil(usu, this);
		verPerfil.setVisible(false);
		editarPerfil.setVisible(true);
		setContentPane(editarPerfil);
	}
	
	public void cambiarAVer() {
		verPerfil = new PerfilUsuario2(usu, this);
		verPerfil.setVisible(true);
		editarPerfil.setVisible(false);
		setContentPane(verPerfil);
	}

}
