package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
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
		//setContentPane(contentPane);

		JLabel lblCopyright = new JLabel("2019 AccionSocialMed\u00AE es una marca registrada de CoderZ. Reservados todos los derechos. Versi\u00F3n 2.1.29.15");
		lblCopyright.setBounds(10, 660, 537, 14);
		add(lblCopyright);
		JLabel login = new JLabel("Logout");
		login.setBounds(990, 5, 105, 62);
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
		lblGestionPropuestas.setBounds(804, 5, 168, 62);
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
		lblRegistroOng.setBounds(657, 5, 129, 62);
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
		setLayout(null);
		add(lblRegistroOng);
		add(lblGestionPropuestas);
		add(login);
		
		JLabel lblCrearProyectoNuevo = new JLabel("Crear proyecto nuevo");
		lblCrearProyectoNuevo.setForeground(Color.BLACK);
		lblCrearProyectoNuevo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblCrearProyectoNuevo.setBounds(438, 5, 193, 62);
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
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 67));
		lblBienvenida.setBounds(-33, 8, 1166, 699);
		add(lblBienvenida);
		lblBienvenida.setText("¡Bienvenid@ administrador!");
		
		
	}
}
