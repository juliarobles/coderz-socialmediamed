package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
		lblGestionPropuestas.setBounds(800, 24, 168, 62);
		lblGestionPropuestas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion propuestas
				padre.cambiarAGestionPropuestas();
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
		
		JLabel lblRegistroOng = new JLabel("Registro ONG");
		lblRegistroOng.setBounds(640, 24, 129, 62);
		lblRegistroOng.setForeground(Color.BLACK);
		lblRegistroOng.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblRegistroOng.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion propuestas
				padre.cambiarARegistroONG();
				lblRegistroOng.setForeground(Color.BLACK);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRegistroOng.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRegistroOng.setForeground(Color.BLACK);
			}
		});
		add(lblRegistroOng);
		add(lblGestionPropuestas);
		add(login);
		
		JLabel lblCrearProyectoNuevo = new JLabel("Gesti\u00F3n de proyectos");
		lblCrearProyectoNuevo.setBounds(427, 24, 193, 62);
		lblCrearProyectoNuevo.setForeground(Color.BLACK);
		lblCrearProyectoNuevo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblCrearProyectoNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion propuestas
				padre.cambiarACrearProyecto();
				lblCrearProyectoNuevo.setForeground(Color.BLACK);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCrearProyectoNuevo.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCrearProyectoNuevo.setForeground(Color.BLACK);
			}
		});
		add(lblCrearProyectoNuevo);
		
		JLabel lblBienvenida = new JLabel("");
		lblBienvenida.setBounds(-22, 182, 1166, 368);
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 67));
		add(lblBienvenida);
		lblBienvenida.setText("¡Bienvenid@ administrador!");
		
		JLabel lblGestinDeActividades = new JLabel("Gesti\u00F3n de actividades");
		lblGestinDeActividades.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion propuestas
				padre.cambiarAGestionActividades(null, null);
				lblGestinDeActividades.setForeground(Color.BLACK);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGestinDeActividades.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblGestinDeActividades.setForeground(Color.BLACK);
			}
		});
		lblGestinDeActividades.setForeground(Color.BLACK);
		lblGestinDeActividades.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblGestinDeActividades.setBounds(517, 96, 193, 62);
		add(lblGestinDeActividades);
		
		JLabel lblGestinDeAsignaturas = new JLabel("Gesti\u00F3n de asignaturas");
		lblGestinDeAsignaturas.setForeground(Color.BLACK);
		lblGestinDeAsignaturas.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblGestinDeAsignaturas.setBounds(739, 96, 193, 62);
		lblGestinDeAsignaturas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion propuestas
				padre.cambiarAGestionAsignaturas();
				lblGestinDeAsignaturas.setForeground(Color.BLACK);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGestinDeAsignaturas.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblGestinDeAsignaturas.setForeground(Color.BLACK);
			}
		});
		add(lblGestinDeAsignaturas);
		
		JLabel seguimientos = new JLabel("Seguimientos");
		seguimientos.setForeground(Color.BLACK);
		seguimientos.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		seguimientos.setBounds(352, 96, 123, 62);
		seguimientos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion propuestas
				padre.cambiarASeguimientoEncargados(null, null);
				seguimientos.setForeground(Color.BLACK);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				seguimientos.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				seguimientos.setForeground(Color.BLACK);
			}
		});
		add(seguimientos);
		
		
	}
}
