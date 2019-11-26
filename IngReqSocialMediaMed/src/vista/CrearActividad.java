package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

import java.awt.Button;

import javax.swing.JComboBox;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;



import modelo.TipoOferta;
import modelo.ZonaAccion;


public class CrearActividad extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearActividad frame = new CrearActividad();
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
	public CrearActividad() {
		setType(Type.UTILITY);
		setTitle("AccionSocialMed - Crear Actividad\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblCrearActividad = new JLabel("Crear Actividad");
		lblCrearActividad.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 29));
		lblCrearActividad.setBounds(255, 11, 214, 48);
		getContentPane().add(lblCrearActividad);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblTitulo.setBounds(67, 93, 45, 14);
		getContentPane().add(lblTitulo);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblDescripcion.setBounds(31, 118, 81, 20);
		getContentPane().add(lblDescripcion);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio: ");
		lblFechaInicio.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblFechaInicio.setBounds(31, 249, 81, 14);
		getContentPane().add(lblFechaInicio);
		
		JLabel lblFecha = new JLabel("Fecha Fin: ");
		lblFecha.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblFecha.setBounds(326, 249, 70, 14);
		getContentPane().add(lblFecha);
		
		textField_3 = new JTextField();
		textField_3.setBounds(397, 248, 96, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblImagen = new JLabel("Imagen:");
		lblImagen.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblImagen.setBounds(570, 249, 48, 19);
		getContentPane().add(lblImagen);
		
		JLabel lblTipoOferta = new JLabel("Tipo Oferta:");
		lblTipoOferta.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblTipoOferta.setBounds(31, 307, 81, 14);
		getContentPane().add(lblTipoOferta);
		
		Button button = new Button("Enviar Solicitud");
		button.setFont(new Font("Dialog", Font.BOLD, 14));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(51, 204, 204));
		button.setActionCommand("Enviar Solicitud");
		button.setBounds(122, 384, 154, 41);
		getContentPane().add(button);
		
		Button button_1 = new Button("Atras");
		button_1.setFont(new Font("Dialog", Font.BOLD, 14));
		button_1.setBackground(new Color(51, 204, 204));
		button_1.setForeground(Color.WHITE);
		button_1.setBounds(397, 384, 154, 41);
		getContentPane().add(button_1);
		
		JComboBox<TipoOferta> comboBox = new JComboBox<TipoOferta>();
		comboBox.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		for(int cont = 0;TipoOferta.values().length>cont; cont++) {
			comboBox.addItem(TipoOferta.values()[cont]);
		}
		comboBox.setBounds(122, 305, 126, 22);
		getContentPane().add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(122, 121, 496, 116);
		getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JComboBox<ZonaAccion> comboBox_1 = new JComboBox<ZonaAccion>();
		comboBox_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		for(int cont = 0;ZonaAccion.values().length>cont; cont++) {
			comboBox_1.addItem(ZonaAccion.values()[cont]);
		}
		comboBox_1.setBounds(397, 305, 96, 22);
		getContentPane().add(comboBox_1);
		
		JLabel lblZonaDeAccion = new JLabel("Zona de Accion:");
		lblZonaDeAccion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblZonaDeAccion.setBounds(292, 309, 104, 14);
		getContentPane().add(lblZonaDeAccion);
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 248, 96, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(122, 92, 254, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
	}
}
