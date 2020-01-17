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
		lblCopyright.setBounds(10, 660, 699, 14);
		add(lblCopyright);
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		
		JLabel login = new JLabel("Logout");
		login.setBounds(965, 24, 105, 62);
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
				login.setForeground(new Color(51, 204, 204)); //#33CCCC
			}
			@Override
			public void mouseExited(MouseEvent e) {
				login.setForeground(Color.BLACK);
			}
		});
		login.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfil.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblPerfil.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/perfil.png")));
		lblPerfil.setBounds(421, 175, 241, 177);
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
				lblPerfil.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/perfilAZUL.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblPerfil.setForeground(Color.BLACK);
				lblPerfil.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/perfil.png")));
			}
		});
		
		JLabel lblEnviarPropuesta = new JLabel("  Enviar propuesta");
		lblEnviarPropuesta.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnviarPropuesta.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEnviarPropuesta.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblEnviarPropuesta.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/enviarpropuesta.png")));
		lblEnviarPropuesta.setBounds(110, 175, 241, 177);
		lblEnviarPropuesta.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Implementar perfil ong
				padre.cambiarACrearPropuesta(usu);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblEnviarPropuesta.setForeground(new Color(51, 204, 204));
				lblEnviarPropuesta.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/enviarpropuestaAZUL.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblEnviarPropuesta.setForeground(Color.BLACK);
				lblEnviarPropuesta.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/enviarpropuesta.png")));
			}
		});
		lblEnviarPropuesta.setForeground(Color.BLACK);
		lblEnviarPropuesta.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		
		
		JLabel lblBienvenida = new JLabel("");
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 23));
		lblBienvenida.setBounds(10, 88, 1080, 42);
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
		lblGestionPropuestas.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblGestionPropuestas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGestionPropuestas.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionPropuestas.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/gestionpropuestas.png")));
		lblGestionPropuestas.setBounds(122, 395, 241, 177);
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
				lblGestionPropuestas.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/gestionpropuestasAZUL.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblGestionPropuestas.setForeground(Color.BLACK);
				lblGestionPropuestas.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/gestionpropuestas.png")));
			}
		});
		lblGestionPropuestas.setForeground(Color.BLACK);
		lblGestionPropuestas.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		add(lblGestionPropuestas);
		
		JLabel lblGestionarActividades = new JLabel("Gesti\u00F3n de actividades");
		lblGestionarActividades.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/gestionActividades.png")));
		lblGestionarActividades.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGestionarActividades.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarActividades.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblGestionarActividades.setForeground(Color.BLACK);
		lblGestionarActividades.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblGestionarActividades.setBounds(421, 395, 241, 177);
		lblGestionarActividades.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion propuestas
				padre.cambiarAGestionActividades(usu, null);
				lblGestionarActividades.setForeground(Color.BLACK);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				//Menú color cuando pones ratón encima de una opción (Azul)
				lblGestionarActividades.setForeground(new Color(51, 204, 204));
				lblGestionarActividades.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/gestionActividadesAZUL.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblGestionarActividades.setForeground(Color.BLACK);
				lblGestionarActividades.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/gestionActividades.png")));
			}
		});
		add(lblGestionarActividades);
		
		JLabel seguimientos = new JLabel("Seguimientos");
		seguimientos.setVerticalTextPosition(SwingConstants.BOTTOM);
		seguimientos.setHorizontalTextPosition(SwingConstants.CENTER);
		seguimientos.setHorizontalAlignment(SwingConstants.CENTER);
		seguimientos.setIconTextGap(5);
		seguimientos.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/seguimiento.png")));
		seguimientos.setForeground(Color.BLACK);
		seguimientos.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		seguimientos.setBounds(732, 395, 241, 177);
		seguimientos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion propuestas
				padre.cambiarASeguimientoEncargados(usu, null);
				seguimientos.setForeground(Color.BLACK);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				seguimientos.setForeground(new Color(51, 204, 204));
				seguimientos.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/seguimientoAZUL.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				seguimientos.setForeground(Color.BLACK);
				seguimientos.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/seguimiento.png")));
			}
		});
		add(seguimientos);
		
		JLabel chat = new JLabel("Chat");
		chat.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/chat.png")));
		chat.setVerticalTextPosition(SwingConstants.BOTTOM);
		chat.setHorizontalTextPosition(SwingConstants.CENTER);
		chat.setHorizontalAlignment(SwingConstants.CENTER);
		chat.setForeground(Color.BLACK);
		chat.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		chat.setBounds(732, 175, 241, 177);
		chat.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//CAMBIAR A CHAT
				chat.setForeground(Color.BLACK);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				chat.setForeground(new Color(51, 204, 204));
				chat.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/chatAZUL.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				chat.setForeground(Color.BLACK);
				chat.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/chat.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		add(chat);
		
	}
}
