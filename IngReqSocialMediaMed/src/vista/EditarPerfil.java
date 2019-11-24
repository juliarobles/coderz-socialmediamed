package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class EditarPerfil extends JFrame{

	private JFrame frameEditarPerfil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarPerfil window = new EditarPerfil();
					window.frameEditarPerfil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditarPerfil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int width = 800;
		int height = 500;
		frameEditarPerfil = new JFrame();
		frameEditarPerfil.setTitle("AccionSocialMed - Editar perfil");
		frameEditarPerfil.setIconImage(Toolkit.getDefaultToolkit().getImage(EditarPerfil.class.getResource("/resources/_Logo AccionSocialMed png.png")));
		frameEditarPerfil.setResizable(false);
		frameEditarPerfil.setBounds(100, 100, width, height);
		frameEditarPerfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameEditarPerfil.getContentPane().setLayout(null);
		
		JLabel lblHola = new JLabel("Hola");
		lblHola.setBounds(179, 120, 49, 14);
		frameEditarPerfil.getContentPane().add(lblHola);
	}
}
