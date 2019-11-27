package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.TextArea;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import modelo.ONG;
import utilidades.PasswordGenerator;

import javax.swing.JTextField;
import javax.swing.JButton;

public class RegistroONG extends JPanel {
	private JTextField nombre;
	private JTextField email;
	private static final int MaxLongitudEmailOng = 100;

	/**
	 * Create the panel.
	 */
	public RegistroONG(MenuPrincipal padre) {
		setBackground(Color.WHITE);
		setSize(new Dimension(1100, 715));
		setLayout(null);
		
		JLabel lblxb = new JLabel("<html>&larr;<html>");
		lblxb.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion
				padre.cambiarGestor();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblxb.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblxb.setForeground(Color.BLACK);
			}
		});
		lblxb.setForeground(Color.BLACK);
		lblxb.setBounds(40, 10, 52, 51);
		lblxb.setFont(new Font("Tahoma", Font.PLAIN, 46));
		add(lblxb);
		
		JLabel lblRegistroDeNueva = new JLabel("Registro de nueva ONG");
		lblRegistroDeNueva.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeNueva.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 24));
		lblRegistroDeNueva.setBounds(-16, 10, 1116, 64);
		add(lblRegistroDeNueva);
		
		JLabel lblNewLabel = new JLabel("Futuro subir imagen\r\n");
		lblNewLabel.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 21));
		lblNewLabel.setBounds(130, 301, 209, 135);
		add(lblNewLabel);
		
		JLabel num = new JLabel("255");
		num.setHorizontalAlignment(SwingConstants.CENTER);
		num.setForeground(Color.BLACK);
		num.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		num.setBounds(1015, 470, 43, 20);
		add(num);
		
		JTextArea descripcion = new JTextArea();
		descripcion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		descripcion.setBorder(new LineBorder(new Color(0, 0, 0)));
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
		descripcion.setBounds(531, 325, 527, 135);
		add(descripcion);
		
		nombre = new JTextField();
		nombre.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (nombre.getText().length() == 100) {
			         e.consume(); 
			    }
			}
		});
		nombre.setBorder(new LineBorder(Color.BLACK));
		nombre.setBounds(645, 246, 413, 29);
		add(nombre);
		nombre.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:\r\n");
		lblDescripcin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblDescripcin.setBounds(531, 292, 145, 41);
		add(lblDescripcin);
		
		JLabel lblNombre = new JLabel("Nombre:\r\n");
		lblNombre.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblNombre.setBounds(531, 236, 145, 46);
		add(lblNombre);
		
		email = new JTextField();
		email.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		email.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (email.getText().length() == MaxLongitudEmailOng) {
			         e.consume(); 
			    }
			}
		});
		email.setColumns(10);
		email.setBorder(new LineBorder(Color.BLACK));
		email.setBounds(645, 197, 413, 29);
		add(email);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblEmail.setBounds(531, 184, 145, 46);
		add(lblEmail);
		
		JLabel lblHey = new JLabel("hey");
		lblHey.setVisible(false);
		lblHey.setHorizontalAlignment(SwingConstants.CENTER);
		lblHey.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblHey.setBounds(10, 107, 1080, 46);
		add(lblHey);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					if(email.getText().isEmpty() || nombre.getText().isEmpty()) {
						lblHey.setForeground(Color.RED);
						lblHey.setText("Email y nombre son campos obligatorios");
						lblHey.setVisible(true);
					} else if (ONG.getTodosNombres().contains(nombre.getText())) {
						lblHey.setForeground(Color.RED);
						lblHey.setText("El nombre introducido ya está registrado en nuestro sistema");
						lblHey.setVisible(true);
					} else if (!email.getText().contains("@") || !email.getText().contains(".")) {
						lblHey.setForeground(Color.RED);
						lblHey.setText("Introduzca un email válido");
						lblHey.setVisible(true);
					} else if (ONG.getTodosEmail().contains(email.getText())) {
						lblHey.setForeground(Color.RED);
						lblHey.setText("El email introducido ya está registrado en nuestro sistema");
						lblHey.setVisible(true);
					} else {
						String pass = PasswordGenerator.getPassword(PasswordGenerator.MINUSCULAS+PasswordGenerator.MAYUSCULAS+PasswordGenerator.NUMEROS,10);
						ONG ong = new ONG(email.getText(), pass, nombre.getText(), descripcion.getText());
						//Enviar por email la contraseña FALTA POR IMPLEMENTARRRRRRRR
						email.setText("");
						nombre.setText("");
						descripcion.setText("");
						
						//Informo al gestor
						lblHey.setForeground(new Color(46, 139, 87));
						lblHey.setText("La ONG se ha registrado correctamente");
						lblHey.setVisible(true);
						Timer timer = new Timer (10000, new ActionListener () 
						{ 
							@Override
							public void actionPerformed(ActionEvent e) {
								if(e.getWhen() >= 9000) {
									lblHey.setVisible(false);
								} else {
									lblHey.setVisible(true);
								}
							} 
						}); 
						timer.start();
						timer.setRepeats(false);	
					}
				} catch (Exception ex){
					lblHey.setForeground(Color.RED);
					lblHey.setText("Ha ocurrido un error" + ex.getMessage());
					lblHey.setVisible(true);
				}
				
			}
		});
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(new Color(51, 204, 204));
		btnRegistrar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		btnRegistrar.setBounds(722, 500, 151, 43);
		add(btnRegistrar);
		
		
		
		
	}
}
