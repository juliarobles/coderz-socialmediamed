package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Actividad;
import modelo.Asignatura;
import modelo.PDI;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JList;

public class CrearProyecto extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitulo;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearProyecto frame = new CrearProyecto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public CrearProyecto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCreacionProy = new JLabel("CREACION DE PROYECTO");
		lblCreacionProy.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 29));
		lblCreacionProy.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCreacionProy, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 424, 44);
		panel.add(panelTitulo);
		panelTitulo.setLayout(null);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setBounds(47, 5, 36, 20);
		lblTitulo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		panelTitulo.add(lblTitulo);
		
		JPanel panelTituloEntrada = new JPanel();
		panelTituloEntrada.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelTituloEntrada.setBounds(103, 5, 304, 24);
		panelTitulo.add(panelTituloEntrada);
		panelTituloEntrada.setLayout(null);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(2, 2, 300, 20);
		panelTituloEntrada.add(textFieldTitulo);
		textFieldTitulo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldTitulo.setColumns(10);
		
		JPanel panelAsignatura = new JPanel();
		panelAsignatura.setBounds(0, 44, 424, 44);
		panel.add(panelAsignatura);
		panelAsignatura.setLayout(null);
		
		JLabel lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setBounds(15, 5, 68, 20);
		lblAsignatura.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		panelAsignatura.add(lblAsignatura);
		
		JComboBox<Asignatura> comboBox = new JComboBox<Asignatura>();
		comboBox.setBounds(103, 5, 162, 22);
		panelAsignatura.add(comboBox);
		
		JPanel panelProfesor = new JPanel();
		panelProfesor.setBounds(0, 88, 424, 44);
		panel.add(panelProfesor);
		panelProfesor.setLayout(null);
		
		JLabel lblProfesor = new JLabel("Profesor:");
		lblProfesor.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblProfesor.setBounds(29, 5, 54, 20);
		panelProfesor.add(lblProfesor);
		
		JComboBox<PDI> boxProfesor = new JComboBox<PDI>();
		boxProfesor.setBounds(103, 5, 162, 22);
		panelProfesor.add(boxProfesor);
		
		JPanel panelAux = new JPanel();
		panelAux.setBounds(0, 132, 424, 200);
		panel.add(panelAux);
		panelAux.setLayout(null);
		
		JPanel panelActividades = new JPanel();
		panelActividades.setBounds(0, 0, 300, 197);
		panelAux.add(panelActividades);
		panelActividades.setLayout(null);
		
		JLabel lblActividades = new JLabel("Actividades:");
		lblActividades.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblActividades.setBounds(12, 5, 71, 14);
		panelActividades.add(lblActividades);
		
		JLabel lblAadirActividad = new JLabel("A\u00F1adir actividad");
		lblAadirActividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirActividad.setForeground(Color.WHITE);
		lblAadirActividad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAadirActividad.setBackground(new Color(51, 204, 204));
		lblAadirActividad.setBounds(103, 0, 123, 36);
		panelActividades.add(lblAadirActividad);
		
		JPanel panelActividadesEntrada = new JPanel();
		panelActividadesEntrada.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelActividadesEntrada.setBounds(103, 53, 166, 137);
		panelActividades.add(panelActividadesEntrada);
		panelActividadesEntrada.setLayout(null);
		
		JList<Actividad> list = new JList<Actividad>();
		list.setBounds(2, 2, 162, 133);
		panelActividadesEntrada.add(list);
		
		JLabel lblPublicar = new JLabel("Publicar");
		lblPublicar.setHorizontalAlignment(SwingConstants.CENTER);
		lblPublicar.setForeground(Color.WHITE);
		lblPublicar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPublicar.setBackground(new Color(51, 204, 204));
		lblPublicar.setBounds(301, 139, 123, 50);
		panelAux.add(lblPublicar);
		
		JComboBox<Asignatura> boxAsignatura = new JComboBox<Asignatura>();
		panelAsignatura.add(boxAsignatura, 5, 5);
	}
}
