package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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

import utilidades.*;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class InicioSesion extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JTextField contraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
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
	public InicioSesion() {
		setResizable(false);
		setUndecorated(true);
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 475);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setSize(new Dimension(800, 500));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setSize(800, 500);
		contentPane.setLayout(null);
	
		JButton cerrar = new JButton("X");
		cerrar.setBounds(760, 0, 40, 30);
		cerrar.setForeground(new Color(0, 0, 0));
		
		cerrar.setFocusable(false);
		cerrar.setFocusPainted(false);
		cerrar.setBorderPainted(false);
		cerrar.setFont(new Font("Arial Narrow", Font.PLAIN, 23));
		cerrar.setAlignmentY(Component.TOP_ALIGNMENT);
		
		cerrar.setOpaque(true);
		cerrar.setBorder(null);
	
		contentPane.add(cerrar);
		
		JLabel barra = new JLabel("");
		barra.setBounds(400, 0, 400, 40);
		barra.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		barra.setOpaque(true);
		barra.setBackground(new Color(255, 255, 255));
		contentPane.add(barra);
		
		cerrar.setBackground(barra.getBackground());
		
		JLabel iniciarsesionong = new JLabel("Iniciar sesi\u00F3n");
		iniciarsesionong.setBounds(0, 159, 400, 45);
		iniciarsesionong.setHorizontalAlignment(SwingConstants.CENTER);
		iniciarsesionong.setForeground(new Color(255, 255, 255));
		iniciarsesionong.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 21));
		contentPane.add(iniciarsesionong);
		
		JLabel iniciarsesionuma = new JLabel("Iniciar sesi\u00F3n");
		iniciarsesionuma.setHorizontalAlignment(SwingConstants.CENTER);
		iniciarsesionuma.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 21));
		iniciarsesionuma.setBounds(400, 161, 400, 40);
		contentPane.add(iniciarsesionuma);
		
		JLabel integrantesuma = new JLabel("como integrante de la comunidad universitaria");
		integrantesuma.setHorizontalAlignment(SwingConstants.CENTER);
		integrantesuma.setForeground(Color.WHITE);
		integrantesuma.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		integrantesuma.setBounds(0, 186, 400, 45);
		contentPane.add(integrantesuma);
		
		ImageIcon uma = new ImageIcon(InicioSesion.class.getResource("/resources/untitled.png"));
		JPictureBox iconuma = new JPictureBox();
		iconuma.setIcon(uma);
		iconuma.setBounds(133, 61, 133, 100);
		contentPane.add(iconuma);
		iconuma.repaint();
		
		ImageIcon ong  = new ImageIcon(InicioSesion.class.getResource("/resources/logoong.png"));
		JPictureBox iconong = new JPictureBox();
		iconong.setIcon(ong);
		iconong.setSize(512, 512);
		iconong.setBounds(546, 50, 105, 100);
		contentPane.add(iconong);
		iconong.repaint();
		
		email = new JTextField();
		email.setForeground(new Color(255, 255, 255));
		email.setBackground(new Color(28, 47, 87));
		email.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		email.setBounds(143, 251, 175, 30);
		
		TextPrompt placeholder = new TextPrompt("Email", email);
		placeholder.changeAlpha(0.75f);
		placeholder.changeStyle(Font.ITALIC);
		
		contentPane.add(email);
		email.setColumns(10);
		
		ImageIcon arrobab  = new ImageIcon(InicioSesion.class.getResource("/resources/lockblanco.png"));
		JPictureBox arrobablanco = new JPictureBox();
		arrobablanco.setIcon(arrobab);
		arrobablanco.setSize(24, 24);
		arrobablanco.setBounds(104, 307, 24, 24);
		contentPane.add(arrobablanco);
		
		contraseña = new JTextField();
		contraseña.setForeground(new Color(255, 255, 255));
		contraseña.setBackground(new Color(28, 47, 87));
		contraseña.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		contraseña.setBounds(143, 301, 175, 30);
		
		TextPrompt placeholder2 = new TextPrompt("Contraseña", contraseña);
		placeholder2.changeAlpha(0.75f);
		placeholder2.changeStyle(Font.ITALIC);
		
		contentPane.add(contraseña);
		contraseña.setColumns(10);
		
		JButton btnEntrar = new JButton("LOGIN");
		btnEntrar.setBounds(137, 407, 129, 40);
		contentPane.add(btnEntrar);
		/*
		ImagePanelBuffered imagePanelBuffered;
		try {
			imagePanelBuffered = new ImagePanelBuffered(ImageIO.read(new File(InicioSesion.class.getResource("/resources/arrobanegro.png").getFile())));
			imagePanelBuffered.setBounds(463, 270, 24, 24);
			contentPane.add(imagePanelBuffered);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		
		JButton btnRecuperarContrasea = new JButton("Recuperar contrase\u00F1a");
		btnRecuperarContrasea.setBounds(546, 376, 133, 21);
		contentPane.add(btnRecuperarContrasea);
		
		JLabel fondoazul = new JLabel("");
		fondoazul.setBorder(null);
		fondoazul.setBounds(0, 0, 400, 500);
		fondoazul.setBackground(new Color(28, 47, 87));
		fondoazul.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		fondoazul.setOpaque(true);
		contentPane.add(fondoazul);
		
		JLabel lblParaOng = new JLabel("como ONG");
		lblParaOng.setHorizontalAlignment(SwingConstants.CENTER);
		lblParaOng.setForeground(Color.BLACK);
		lblParaOng.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		lblParaOng.setBounds(400, 186, 400, 45);
		contentPane.add(lblParaOng);
		
		
		
		

			
			//arrobablanco.resizeTrick(24, 24);
			//arrobablanco.setIcon(arrobab);
		   // arrobablanco.setSize(24, 24);
	
		
		
		
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
				System.exit(0); 
			}
		});
	}
	}


