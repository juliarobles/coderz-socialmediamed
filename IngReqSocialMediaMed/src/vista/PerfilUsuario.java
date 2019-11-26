package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Window.Type;
import java.awt.Frame;
import utilidades.JPictureBox;



public class PerfilUsuario {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilUsuario window = new PerfilUsuario();
					window.frmAccionsocialmed.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PerfilUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int alto = 400;
		int ancho = 650;
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(PerfilUsuario.class.getResource("/resources/_Logo AccionSocialMed png.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed - Perfil");
		frmAccionsocialmed.setBounds(100, 100, ancho, alto);
		
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		//frmAccionsocialmed.setBounds(0, 0,screen.width,screen.height - 30);
		//frmAccionsocialmed.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

		
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JPanel panlFondo = new JPanel();
		panlFondo.setBounds(0, 0, ancho, alto);
		panlFondo.setBackground(new Color(28,47,87));
		frmAccionsocialmed.getContentPane().add(panlFondo);
		panlFondo.setLayout(null);
		
		JLabel lblHola = new JLabel("");
		lblHola.setBounds(10, 11, 53, 67);
		//lblHola.setIcon(new ImageIcon(PerfilUsuario.class.getResource("/resources/A\u00F1adirImagenDefinitivoPNG.png")));
		
		
		
	
		String path;
		JLabel iconASM = new JLabel("");
		//label.setIcon(new ImageIcon(PerfilUsuario.class.getResource("/resources/_Logo AccionSocialMed png.png")));
		iconASM.setBounds(517, 316, 45, 45);
		
		
		JLabel iconoUMA = new JLabel("");
		//iconoUMA.setIcon(new ImageIcon(PerfilUsuario.class.getResource("/resources/untitled.png")));
		iconoUMA.setBounds(581, 316, 50, 45);
		path = "/resources/untitled.png";
		iconoUMA.setIcon(ajustarImagen(path, iconoUMA));
		path = "/resources/_Logo AccionSocialMed png.png";
		panlFondo.add(iconoUMA);
		iconASM.setIcon(ajustarImagen(path, iconASM));
		panlFondo.add(iconASM);
		path = "/resources/A\u00F1adirImagenDefinitivoPNG.png";
		lblHola.setIcon(ajustarImagen(path, lblHola));
		panlFondo.add(lblHola);
		
		JLabel Disenio1 = new JLabel("");
		//label.setIcon(new ImageIcon(PerfilUsuario.class.getResource("/resources/Perfil dise\u00F1o 2.png")));
		Disenio1.setBounds(0, -10, 640, 154);
		path = "/resources/Perfil dise\u00F1o 2.png";
		Disenio1.setIcon(ajustarImagen(path,Disenio1 ));
		panlFondo.add(Disenio1);
		
	
	}
	public ImageIcon ajustarImagen (String path, JLabel lbl ) {

		
		ImageIcon imgic = new ImageIcon(PerfilUsuario.class.getResource(path));
		Image img = imgic.getImage();
		Image newimg = img.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imgfinal  = new ImageIcon(newimg);
		return imgfinal;
	}
}

