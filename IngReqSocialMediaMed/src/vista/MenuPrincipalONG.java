package vista;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.ONG;
import utilidades.JPictureBox;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class MenuPrincipalONG extends JPanel {

	public MenuPrincipalONG(MenuPrincipal padre,ONG usu) {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipalUsuario.class.getResource("/resources/_Logo AccionSocialMed png.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, padre.getWidth(), padre.getHeight());
		setBounds(100, 100, 1100, 715);
		//setLocationRelativeTo(null);
		
		JLabel lblSocialmediamed = new JLabel("SocialMediaMed");
		lblSocialmediamed.setBounds(110, 26, 199, 52);
		lblSocialmediamed.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 24));
		add(lblSocialmediamed);
		
		ImageIcon logo = new ImageIcon(InicioSesion.class.getResource("/resources/_Logo AccionSocialMed png.png"));
		JPictureBox pictureBox = new JPictureBox();
		pictureBox.setBounds(44, 26, 56, 52);
		pictureBox.setIcon(logo);
		add(pictureBox);
		
		JLabel lblCopyright = new JLabel("2019 AccionSocialMed\u00AE es una marca registrada de CoderZ. Reservados todos los derechos. Versi\u00F3n 2.1.29.15");
		lblCopyright.setBounds(10, 660, 537, 14);
		add(lblCopyright);
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		
		JLabel login = new JLabel("Logout");
		login.setBounds(990, 24, 105, 62);
		login.setForeground(Color.BLACK);
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana login
				padre.cambiarAInvitado();
				//dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				login.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				login.setForeground(Color.BLACK);
			}
		});
		login.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setBounds(875, 24, 105, 62);
		lblPerfil.setForeground(Color.BLACK);
		lblPerfil.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Implementar perfil ong
				padre.cambiarAPerfilONG(usu, false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPerfil.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblPerfil.setForeground(Color.BLACK);
			}
		});
		
		JLabel lblEnviarPropuesta = new JLabel("Enviar propuesta");
		lblEnviarPropuesta.setBounds(681, 24, 184, 62);
		lblEnviarPropuesta.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Implementar perfil ong
				padre.cambiarACrearPropuesta(usu);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblEnviarPropuesta.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblEnviarPropuesta.setForeground(Color.BLACK);
			}
		});
		lblEnviarPropuesta.setForeground(Color.BLACK);
		lblEnviarPropuesta.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		
		
		JLabel lblBienvenida = new JLabel("");
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 67));
		lblBienvenida.setBounds(-21, 147, 1166, 460);
		add(lblBienvenida);
		lblBienvenida.setText("¡Bienvenid@ "+usu.getNombre()+"!");
		setLayout(null);
		add(lblSocialmediamed);
		add(pictureBox);
		add(lblCopyright);
		add(lblBienvenida);
		add(lblEnviarPropuesta);
		add(lblPerfil);
		add(login);
		
		JLabel lblGestionPropuestas = new JLabel("Gestion propuestas");
		lblGestionPropuestas.setBounds(895, 75, 168, 62);
		lblGestionPropuestas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion propuestas
				padre.cambiarAGestionPropuestasONG(usu);
				lblGestionPropuestas.setForeground(Color.BLACK);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGestionPropuestas.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblGestionPropuestas.setForeground(Color.BLACK);
			}
		});
		lblGestionPropuestas.setForeground(Color.BLACK);
		lblGestionPropuestas.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		add(lblGestionPropuestas);
		
		JLabel lblGestionarActividades = new JLabel("Gesti\u00F3n de actividades");
		lblGestionarActividades.setForeground(Color.BLACK);
		lblGestionarActividades.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblGestionarActividades.setBounds(454, 24, 184, 62);
		lblGestionarActividades.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion propuestas
				padre.cambiarAGestionActividades(usu, null);
				lblGestionarActividades.setForeground(Color.BLACK);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGestionarActividades.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblGestionarActividades.setForeground(Color.BLACK);
			}
		});
		add(lblGestionarActividades);
	}

}
