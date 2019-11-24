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

import controlador.CtrLoginUMA;
import modelo.Disponibilidad;
import modelo.TipoOferta;
import modelo.Usuario;
import modelo.ZonaAccion;
import utilidades.*;
import java.awt.image.BufferedImage;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class CompletarPerfil extends JFrame {

	private JPanel contentPane;
	public JTextField telefono;

	public CompletarPerfil(Usuario usu, MenuPrincipal principal) {
		setAlwaysOnTop(true);
		setResizable(false);
		setUndecorated(true);
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 247, 247));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setSize(400,650);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel iniciarsesionuma = new JLabel("\u00A1Bienvenido!");
		iniciarsesionuma.setHorizontalAlignment(SwingConstants.CENTER);
		iniciarsesionuma.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 21));
		iniciarsesionuma.setBounds(0, 10, 400, 40);
		contentPane.add(iniciarsesionuma);
		
		
		BordeRedondo border = new BordeRedondo(10);
		
		JLabel lblParaOng = new JLabel("Antes de comenzar necesitamos hacerte algunas");
		lblParaOng.setHorizontalAlignment(SwingConstants.CENTER);
		lblParaOng.setForeground(Color.BLACK);
		lblParaOng.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		lblParaOng.setBounds(0, 40, 400, 45);
		contentPane.add(lblParaOng);
		
		JLabel lblPreguntasParaRecomendarte = new JLabel("preguntas para recomendarte lo mejor posible ;)");
		lblPreguntasParaRecomendarte.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreguntasParaRecomendarte.setForeground(Color.BLACK);
		lblPreguntasParaRecomendarte.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		lblPreguntasParaRecomendarte.setBounds(0, 60, 400, 45);
		contentPane.add(lblPreguntasParaRecomendarte);
		
		JLabel lblcuantoEstsDisponible = new JLabel("\u00BFCuanto est\u00E1s disponible?");
		lblcuantoEstsDisponible.setHorizontalAlignment(SwingConstants.CENTER);
		lblcuantoEstsDisponible.setForeground(Color.BLACK);
		lblcuantoEstsDisponible.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		lblcuantoEstsDisponible.setBounds(0, 115, 400, 45);
		contentPane.add(lblcuantoEstsDisponible);
		
		JLabel lblcuantoEstsDispuesto = new JLabel("\u00BFCuanto est\u00E1s dispuesto a moverte?");
		lblcuantoEstsDispuesto.setHorizontalAlignment(SwingConstants.CENTER);
		lblcuantoEstsDispuesto.setForeground(Color.BLACK);
		lblcuantoEstsDispuesto.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		lblcuantoEstsDispuesto.setBounds(0, 189, 400, 45);
		contentPane.add(lblcuantoEstsDispuesto);
		
		JLabel lblqueTipoDe = new JLabel("\u00BFQue tipo de actividades prefieres?");
		lblqueTipoDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblqueTipoDe.setForeground(Color.BLACK);
		lblqueTipoDe.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		lblqueTipoDe.setBounds(0, 263, 400, 45);
		contentPane.add(lblqueTipoDe);
		
		JComboBox disponibilidad = new JComboBox();
		disponibilidad.setBounds(93, 160, 211, 21);
		for(int cont = 0;Disponibilidad.values().length>cont; cont++) {
			disponibilidad.addItem(Disponibilidad.values()[cont]);
		}
		disponibilidad.setSelectedIndex(0);
		contentPane.add(disponibilidad);
		
		JComboBox zona = new JComboBox();
		zona.setBounds(93, 234, 211, 21);
		for(int cont = 0;ZonaAccion.values().length>cont; cont++) {
			zona.addItem(ZonaAccion.values()[cont]);
		}
		zona.setSelectedIndex(0);
		contentPane.add(zona);
		
		JComboBox tipooferta = new JComboBox();
		tipooferta.setBounds(93, 308, 211, 21);
		for(int cont = 0;TipoOferta.values().length>cont; cont++) {
			tipooferta.addItem(TipoOferta.values()[cont]);
		}
		tipooferta.setSelectedIndex(0);
		contentPane.add(tipooferta);
		
		JLabel lbltuTelefono = new JLabel("\u00BFTu telefono?");
		lbltuTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lbltuTelefono.setForeground(Color.BLACK);
		lbltuTelefono.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		lbltuTelefono.setBounds(0, 476, 400, 40);
		contentPane.add(lbltuTelefono);
		
		telefono = new JTextField();
		telefono.setBounds(100, 514, 200, 29);
		contentPane.add(telefono);
		telefono.setColumns(10);
		
		JLabel num = new JLabel("255");
		num.setHorizontalAlignment(SwingConstants.CENTER);
		num.setForeground(Color.BLACK);
		num.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		num.setBounds(334, 473, 65, 29);
		contentPane.add(num);
		
		JLabel lblcuentanosUnPoco = new JLabel("\u00A1Cuentanos un poco m\u00E1s sobre ti!");
		lblcuentanosUnPoco.setHorizontalAlignment(SwingConstants.CENTER);
		lblcuentanosUnPoco.setForeground(Color.BLACK);
		lblcuentanosUnPoco.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		lblcuentanosUnPoco.setBounds(0, 337, 400, 45);
		contentPane.add(lblcuentanosUnPoco);
		
		JTextArea descripcion = new JTextArea();
		descripcion.setWrapStyleWord(true);
		descripcion.setLineWrap(true);
		descripcion.setSize(new Dimension(350, 90));
		descripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (descripcion.getText().length() == 255) {
			         e.consume(); 
			    }
				num.setText(Integer.toString(255 - descripcion.getText().length()));
			}
		});
		descripcion.setBounds(25, 382, 350, 90);
		contentPane.add(descripcion);
		
		JFrame esto = this;
		JButton loginong = new JButton("LISTO");
		loginong.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!descripcion.getText().isEmpty() && !telefono.getText().isEmpty()) {
					usu.setTelf(Integer.parseInt(telefono.getText()));
					usu.setDisponibilidad((Disponibilidad)disponibilidad.getSelectedItem());
					usu.setDescripcion(descripcion.getText());
					usu.setTipoOferta((TipoOferta)tipooferta.getSelectedItem());
					usu.setZonaAccion((ZonaAccion) zona.getSelectedItem());
					principal.cambiarUsuario(usu);
					esto.dispose();
				}
				//Poner algun aviso de el fallo que tienen
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				loginong.setForeground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				loginong.setForeground(Color.BLACK);
			}
		});
		loginong.setOpaque(false);
		loginong.setForeground(Color.BLACK);
		loginong.setFocusPainted(false);
		loginong.setBackground(Color.WHITE);
		loginong.setBounds(131, 570, 129, 40);
		loginong.setBorder(border);
		contentPane.add(loginong);
	
	}
	}


