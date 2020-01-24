package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Gestor;
import utilidades.JPictureBox;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;

public class MenuPrincipalGestor extends JPanel {

	/**
	 * Create the frame.
	 */
	public MenuPrincipalGestor(MenuPrincipal padre) {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipalInvitado.class.getResource("/resources/_Logo AccionSocialMed png.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 715);
		//setLocationRelativeTo(null);
		
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		//setContentPane(contentPane);

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
		JLabel login = new JLabel("Logout");
		login.setBounds(978, 24, 105, 62);
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
		
		JLabel lblGestionPropuestas = new JLabel("Gestion propuestas");
		lblGestionPropuestas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGestionPropuestas.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionPropuestas.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblGestionPropuestas.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/gestionpropuestas.png")));
		lblGestionPropuestas.setBounds(541, 179, 241, 177);
		lblGestionPropuestas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion propuestas
				padre.cambiarAGestionPropuestas();
				lblGestionPropuestas.setForeground(Color.BLACK);
				lblGestionPropuestas.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/gestionpropuestas.png")));
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGestionPropuestas.setForeground(new Color(51, 204, 204));
				lblGestionPropuestas.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/gestionpropuestasAZUL.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblGestionPropuestas.setForeground(Color.BLACK);
				lblGestionPropuestas.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/gestionpropuestas.png")));
			}
		});
		lblGestionPropuestas.setForeground(Color.BLACK);
		lblGestionPropuestas.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		
		JLabel lblRegistroOng = new JLabel("Registro ONG");
		lblRegistroOng.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblRegistroOng.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/registrarONG.png")));
		lblRegistroOng.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRegistroOng.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroOng.setBounds(306, 179, 241, 177);
		lblRegistroOng.setForeground(Color.BLACK);
		lblRegistroOng.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblRegistroOng.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion propuestas
				padre.cambiarARegistroONG();
				lblRegistroOng.setForeground(Color.BLACK);
				lblRegistroOng.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/registrarONG.png")));
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRegistroOng.setForeground(new Color(51, 204, 204));
				lblRegistroOng.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/registrarONGAZUL.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRegistroOng.setForeground(Color.BLACK);
				lblRegistroOng.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/registrarONG.png")));
			}
		});
		add(lblRegistroOng);
		add(lblGestionPropuestas);
		add(login);
		
		JLabel lblCrearProyectoNuevo = new JLabel("Gesti\u00F3n de proyectos");
		lblCrearProyectoNuevo.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/gestionProyectos.png")));
		lblCrearProyectoNuevo.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCrearProyectoNuevo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCrearProyectoNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearProyectoNuevo.setBounds(85, 179, 241, 177);
		lblCrearProyectoNuevo.setForeground(Color.BLACK);
		lblCrearProyectoNuevo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblCrearProyectoNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion propuestas
				padre.cambiarACrearProyecto();
				lblCrearProyectoNuevo.setForeground(Color.BLACK);
				lblCrearProyectoNuevo.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/gestionProyectos.png")));
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCrearProyectoNuevo.setForeground(new Color(51, 204, 204));
				lblCrearProyectoNuevo.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/gestionProyectosAZUL.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCrearProyectoNuevo.setForeground(Color.BLACK);
				lblCrearProyectoNuevo.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/gestionProyectos.png")));
			}
		});
		add(lblCrearProyectoNuevo);
		
		JLabel lblBienvenida = new JLabel("");
		lblBienvenida.setBounds(10, 104, 1073, 42);
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 23));
		add(lblBienvenida);
		lblBienvenida.setText("¡Bienvenid@ administrador!");
		
		JLabel lblGestinDeActividades = new JLabel("Gesti\u00F3n de actividades");
		lblGestinDeActividades.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblGestinDeActividades.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGestinDeActividades.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestinDeActividades.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/gestionActividades.png")));
		lblGestinDeActividades.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion propuestas
				padre.cambiarAGestionActividades(null, null);
				lblGestinDeActividades.setForeground(Color.BLACK);
				lblGestinDeActividades.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/gestionActividades.png")));
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGestinDeActividades.setForeground(new Color(51, 204, 204));
				lblGestinDeActividades.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/gestionActividadesAZUL.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblGestinDeActividades.setForeground(Color.BLACK);
				lblGestinDeActividades.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/gestionActividades.png")));
			}
		});
		lblGestinDeActividades.setForeground(Color.BLACK);
		lblGestinDeActividades.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblGestinDeActividades.setBounds(677, 408, 241, 177);
		add(lblGestinDeActividades);
		
		JLabel lblGestinDeAsignaturas = new JLabel("Gesti\u00F3n de asignaturas");
		lblGestinDeAsignaturas.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/gestionAsignaturas.png")));
		lblGestinDeAsignaturas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGestinDeAsignaturas.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestinDeAsignaturas.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblGestinDeAsignaturas.setForeground(Color.BLACK);
		lblGestinDeAsignaturas.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblGestinDeAsignaturas.setBounds(205, 408, 241, 177);
		lblGestinDeAsignaturas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion propuestas
				padre.cambiarAGestionAsignaturas();
				lblGestinDeAsignaturas.setForeground(Color.BLACK);
				lblGestinDeAsignaturas.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/gestionAsignaturas.png")));
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGestinDeAsignaturas.setForeground(new Color(51, 204, 204));
				lblGestinDeAsignaturas.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/gestionAsignaturasAZUL.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblGestinDeAsignaturas.setForeground(Color.BLACK);
				lblGestinDeAsignaturas.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/gestionAsignaturas.png")));
			}
		});
		add(lblGestinDeAsignaturas);
		
		JLabel seguimientos = new JLabel("Seguimientos");
		seguimientos.setHorizontalTextPosition(SwingConstants.CENTER);
		seguimientos.setHorizontalAlignment(SwingConstants.CENTER);
		seguimientos.setVerticalTextPosition(SwingConstants.BOTTOM);
		seguimientos.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/seguimiento.png")));
		seguimientos.setForeground(Color.BLACK);
		seguimientos.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		seguimientos.setBounds(435, 408, 241, 177);
		seguimientos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion propuestas
				padre.cambiarASeguimientoEncargados(null, null);
				seguimientos.setForeground(Color.BLACK);
				seguimientos.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/seguimiento.png")));
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				seguimientos.setForeground(new Color(51, 204, 204));
				seguimientos.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/seguimientoAZUL.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				seguimientos.setForeground(Color.BLACK);
				seguimientos.setIcon(new ImageIcon(MenuPrincipalGestor.class.getResource("/resources/seguimiento.png")));
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
		chat.setBounds(759, 179, 241, 177);
		chat.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//CAMBIAR A CHAT
				chat.setForeground(Color.BLACK);
				chat.setIcon(new ImageIcon(MenuPrincipalONG.class.getResource("/resources/chat.png")));
				
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
				padre.cambiarAChat(new Gestor("gestor"));
			}
		});
		add(chat);
		
	}
}
