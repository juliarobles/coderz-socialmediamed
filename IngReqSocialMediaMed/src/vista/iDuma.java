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
public class iDuma extends JFrame {

	private JPanel contentPane;
	public JTextField emailuma;
	public JTextField emailong;
	public JPasswordField passong;
	public JPasswordField passuma;
	
	public JLabel lblErrorUma = new JLabel("");
	
	public void errorUma(String mess) {
		lblErrorUma.setText(mess);
	}


	public iDuma(MenuPrincipal principal, JFrame inicioSesion) {
		setResizable(false);
		setUndecorated(true);
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 874, 548);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 247, 247));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setSize(874, 548);
		contentPane.setLayout(null);
	
		JButton cerrar = new JButton("<html>&#10005;<html>");
		cerrar.setBounds(830, 10, 30, 30);
		cerrar.setForeground(new Color(0, 0, 0));
		
		cerrar.setFocusable(false);
		cerrar.setFocusPainted(false);
		cerrar.setBorderPainted(false);
		cerrar.setFont(new Font("Corbel", Font.PLAIN, 23));
		cerrar.setAlignmentY(Component.TOP_ALIGNMENT);
		
		cerrar.setOpaque(false);
		cerrar.setBorder(null);
	
		contentPane.add(cerrar);
		lblErrorUma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblErrorUma.setForeground(Color.RED);
		lblErrorUma.setBounds(60, 158, 323, 14);
		lblErrorUma.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblErrorUma);
		
		JLabel barra = new JLabel("");
		barra.setBounds(400, 0, 400, 40);
		barra.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		barra.setOpaque(true);
		barra.setBackground(new Color(247, 247, 247));
		contentPane.add(barra);
		
		cerrar.setBackground(barra.getBackground());
		
		ImageIcon uma = new ImageIcon(iDuma.class.getResource("/resources/iduma.PNG"));
		
		emailuma = new JTextField();
		emailuma.setOpaque(false);
		emailuma.setForeground(Color.BLACK);
		emailuma.setBackground(new Color(28, 47, 87));
		emailuma.setBorder(null);
		emailuma.setBounds(187, 182, 200, 22);
		
		contentPane.add(emailuma);
		emailuma.setColumns(10);
		
		passuma = new JPasswordField();
		passuma.setOpaque(false);
		passuma.setForeground(Color.BLACK);
		passuma.setBackground(new Color(28, 47, 87));
		passuma.setBorder(null);
		passuma.setBounds(187, 230, 200, 22);
		
		contentPane.add(passuma);
		passuma.setColumns(10);
		
		JButton btnEntrar = new JButton("");
		btnEntrar.setBorder(null);
		btnEntrar.setOpaque(false);
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setFocusPainted(false);
		btnEntrar.setBackground(Color.WHITE);
		btnEntrar.setBounds(47, 272, 76, 40);
		btnEntrar.addMouseListener(new CtrLoginUMA(this, principal, btnEntrar, inicioSesion));
		contentPane.add(btnEntrar);
		
		JPictureBox iconuma = new JPictureBox();
		iconuma.setIcon(uma);
		iconuma.setBounds(0, 0, 874, 548);
		contentPane.add(iconuma);
		iconuma.repaint();
		
	
		
		
		
		cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cerrar.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
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


