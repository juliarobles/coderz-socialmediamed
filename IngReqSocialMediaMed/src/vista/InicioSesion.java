package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import controlador.CtrLoginONG;
import controlador.CtrLoginUMA;
import utilidades.*;
import java.awt.image.BufferedImage;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class InicioSesion extends JFrame {

	private JPanel contentPane;
	private JFrame yo;
	public JTextField emailuma;
	public JTextField emailong;
	public JPasswordField passong;
	public JPasswordField passuma;
	public JLabel lblErrorOng = new JLabel("");
	
	public void errorOng(String mess) {
		lblErrorOng.setText(mess);
	}


	public InicioSesion(MenuPrincipal principal) {
		setResizable(false);
		setUndecorated(true);
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 475);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 247, 247));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setSize(800,430);
		contentPane.setLayout(null);
		yo = this;
	
		JButton cerrar = new JButton("<html>&#10005;<html>");
		cerrar.setBounds(770, 0, 30, 30);
		cerrar.setForeground(new Color(0, 0, 0));
		
		cerrar.setFocusable(false);
		cerrar.setFocusPainted(false);
		cerrar.setBorderPainted(false);
		cerrar.setFont(new Font("Corbel", Font.PLAIN, 23));
		cerrar.setAlignmentY(Component.TOP_ALIGNMENT);
		
		cerrar.setOpaque(true);
		cerrar.setBorder(null);
	
		contentPane.add(cerrar);
		lblErrorOng.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblErrorOng.setForeground(Color.RED);
		lblErrorOng.setBounds(478, 388, 250, 14);
		lblErrorOng.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblErrorOng);
		
		JLabel barra = new JLabel("");
		barra.setBounds(400, 0, 400, 40);
		barra.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		barra.setOpaque(true);
		barra.setBackground(new Color(247, 247, 247));
		contentPane.add(barra);
		
		cerrar.setBackground(barra.getBackground());
		
		JLabel iniciarsesionong = new JLabel("Iniciar sesi\u00F3n");
		iniciarsesionong.setBounds(0, 145, 400, 45);
		iniciarsesionong.setHorizontalAlignment(SwingConstants.CENTER);
		iniciarsesionong.setForeground(new Color(255, 255, 255));
		iniciarsesionong.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 21));
		contentPane.add(iniciarsesionong);
		
		JLabel iniciarsesionuma = new JLabel("Iniciar sesi\u00F3n");
		iniciarsesionuma.setHorizontalAlignment(SwingConstants.CENTER);
		iniciarsesionuma.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 21));
		iniciarsesionuma.setBounds(400, 147, 400, 40);
		contentPane.add(iniciarsesionuma);
		
		JLabel integrantesuma = new JLabel("como integrante de la comunidad universitaria");
		integrantesuma.setHorizontalAlignment(SwingConstants.CENTER);
		integrantesuma.setForeground(Color.WHITE);
		integrantesuma.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		integrantesuma.setBounds(0, 173, 400, 45);
		contentPane.add(integrantesuma);
		
		ImageIcon uma = new ImageIcon(InicioSesion.class.getResource("/resources/untitled.png"));
		JPictureBox iconuma = new JPictureBox();
		iconuma.setIcon(uma);
		iconuma.setBounds(138, 49, 133, 100);
		contentPane.add(iconuma);
		iconuma.repaint();
		
		ImageIcon ong  = new ImageIcon(InicioSesion.class.getResource("/resources/ong.png"));
		JPictureBox iconong = new JPictureBox();
		iconong.setIcon(ong);
		iconong.setSize(512, 512);
		iconong.setBounds(547, 35, 105, 100);
		contentPane.add(iconong);
		iconong.repaint();
		
		
		BordeRedondo border = new BordeRedondo(10);
		JButton btnEntrar = new JButton("LOGIN");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				iDuma frame = new iDuma(principal, yo);
				frame.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEntrar.setForeground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEntrar.setForeground(Color.WHITE);
			}
		});
		btnEntrar.setOpaque(false);
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setFocusPainted(false);
		btnEntrar.setBorder(border);
		btnEntrar.setBackground(Color.WHITE);
		btnEntrar.setBounds(138, 272, 129, 40);
		contentPane.add(btnEntrar);
		
		
		JLabel fondoazul = new JLabel("");
		fondoazul.setBorder(null);
		fondoazul.setBounds(0, 0, 400, 430);
		fondoazul.setBackground(new Color(28, 47, 87));
		fondoazul.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		fondoazul.setOpaque(true);
		contentPane.add(fondoazul);
		
		JLabel lblParaOng = new JLabel("como ONG");
		lblParaOng.setHorizontalAlignment(SwingConstants.CENTER);
		lblParaOng.setForeground(Color.BLACK);
		lblParaOng.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		lblParaOng.setBounds(400, 173, 400, 45);
		contentPane.add(lblParaOng);
		
		emailong = new JTextField();
		emailong.setForeground(Color.BLACK);
		emailong.setColumns(10);
		emailong.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLACK));
		emailong.setBackground(new Color(247, 247, 247));
		emailong.setBounds(527, 228, 190, 30);
		
		TextPrompt placeholder3 = new TextPrompt("Email", emailong);
		placeholder3.changeAlpha(0.75f);
		placeholder3.changeStyle(Font.ITALIC);
		
		contentPane.add(emailong);
		
		passong = new JPasswordField();
		passong.setForeground(Color.BLACK);
		passong.setColumns(10);
		passong.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		passong.setBackground(new Color(247, 247, 247));
		passong.setBounds(527, 278, 190, 30);
		
		TextPrompt placeholder4 = new TextPrompt("Password", passong);
		placeholder4.changeAlpha(0.75f);
		placeholder4.changeStyle(Font.ITALIC);
		
		contentPane.add(passong);
		
		JLabel lblhasOlvidadoTu = new JLabel("\u00BFHas olvidado tu contrase\u00F1a?");
		lblhasOlvidadoTu.setHorizontalAlignment(SwingConstants.CENTER);
		lblhasOlvidadoTu.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		lblhasOlvidadoTu.setForeground(Color.BLACK);
		lblhasOlvidadoTu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//CONTRASE�A OLVIDADA
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblhasOlvidadoTu.setForeground(new Color(161, 186, 240));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblhasOlvidadoTu.setForeground(Color.BLACK);
			}
		});
		lblhasOlvidadoTu.setBounds(516, 307, 170, 30);
		contentPane.add(lblhasOlvidadoTu);
		
		JButton loginong = new JButton("LOGIN");
		loginong.setOpaque(false);
		loginong.setForeground(Color.BLACK);
		loginong.setFocusPainted(false);
		loginong.setBackground(Color.WHITE);
		loginong.setBounds(538, 337, 129, 40);
		loginong.setBorder(border);
		loginong.addMouseListener(new CtrLoginONG(this, principal, loginong));
		contentPane.add(loginong);
		
		JLabel label = new JLabel("@");
		label.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 30));
		label.setBounds(488, 218, 58, 40);
		contentPane.add(label);
		
		ImageIcon ln  = new ImageIcon(InicioSesion.class.getResource("/resources/locknegro.png"));
		JPictureBox locknegro = new JPictureBox();
		locknegro.setSize(64, 64);
		locknegro.setBounds(488, 278, 29, 30);
		locknegro.setIcon(ln);
		contentPane.add(locknegro);
	
		
		
		
		cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cerrar.setBackground(new Color(221, 6, 6));
				cerrar.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cerrar.setBackground(barra.getBackground());
				cerrar.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				principal.setEnabled(true);
				dispose();
			}
		});
	}
	}


