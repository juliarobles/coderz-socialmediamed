package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

import java.awt.Button;

import javax.swing.JComboBox;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import modelo.Actividad;
import modelo.Propuesta;
import modelo.TipoOferta;
import modelo.ZonaAccion;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CrearActividad extends JPanel {

	private JPanel contentPane;
	private JTextField fechafin;
	private JTextField fechainicio;
	private JTextField titulo;

	
	public CrearActividad(MenuPrincipal padre, Propuesta p) {
		setBounds(100, 100, 1100, 750);
		setLayout(null);
		
		JLabel lblCrearActividad = new JLabel("Crear Actividad");
		lblCrearActividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearActividad.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 29));
		lblCrearActividad.setBounds(10, 47, 1080, 48);
		add(lblCrearActividad);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblTitulo.setBounds(511, 155, 70, 31);
		add(lblTitulo);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblDescripcion.setBounds(511, 212, 104, 31);
		add(lblDescripcion);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio: ");
		lblFechaInicio.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblFechaInicio.setBounds(511, 420, 126, 31);
		add(lblFechaInicio);
		
		JLabel lblFecha = new JLabel("Fecha Fin: ");
		lblFecha.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblFecha.setBounds(785, 423, 104, 24);
		add(lblFecha);
		
		fechafin = new JTextField();
		fechafin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		fechafin.setBorder(new LineBorder(new Color(0, 0, 0)));
		fechafin.setBounds(873, 420, 136, 31);
		fechafin.setText(p.getFechafinal());
		add(fechafin);
		fechafin.setColumns(10);
		
		JLabel lblImagen = new JLabel("Imagen:");
		lblImagen.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImagen.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblImagen.setBounds(42, 153, 401, 270);
		add(lblImagen);
		
		JLabel lblTipoOferta = new JLabel("Tipo Oferta:");
		lblTipoOferta.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblTipoOferta.setBounds(511, 539, 126, 31);
		add(lblTipoOferta);
		
		JComboBox<TipoOferta> tipooferta = new JComboBox<TipoOferta>();
		tipooferta.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		for(int cont = 0;TipoOferta.values().length>cont; cont++) {
			tipooferta.addItem(TipoOferta.values()[cont]);
		}
		tipooferta.setSelectedIndex(0);
		tipooferta.setBounds(651, 542, 203, 31);
		add(tipooferta);
	
		JLabel num = new JLabel("255");
		num.setHorizontalAlignment(SwingConstants.CENTER);
		num.setForeground(Color.BLACK);
		num.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		num.setBounds(964, 370, 43, 20);
		add(num);
		
		JTextArea descripcion = new JTextArea();
		descripcion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		descripcion.setBorder(new LineBorder(new Color(0, 0, 0)));
		descripcion.setBounds(511, 253, 496, 116);
		descripcion.setWrapStyleWord(true);
		descripcion.setLineWrap(true);
		descripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (descripcion.getText().length() == 255) {
			         e.consume(); 
			    }
				num.setText(Integer.toString(255 - descripcion.getText().length()));
			}
		});
		descripcion.setText(p.getDescripcion());
		add(descripcion);
		
		JComboBox<ZonaAccion> zonaaccion = new JComboBox<ZonaAccion>();
		zonaaccion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		for(int cont = 0;ZonaAccion.values().length>cont; cont++) {
			zonaaccion.addItem(ZonaAccion.values()[cont]);
		}
		zonaaccion.setSelectedIndex(0);
		zonaaccion.setBounds(651, 482, 203, 31);
		add(zonaaccion);
		
		JLabel lblZonaDeAccion = new JLabel("Zona de Accion:");
		lblZonaDeAccion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblZonaDeAccion.setBounds(511, 481, 142, 28);
		add(lblZonaDeAccion);
		
		fechainicio = new JTextField();
		fechainicio.setBorder(new LineBorder(new Color(0, 0, 0)));
		fechainicio.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		fechainicio.setBounds(617, 420, 136, 31);
		fechainicio.setText(p.getFechainicial());
		add(fechainicio);
		fechainicio.setColumns(10);
		
		titulo = new JTextField();
		titulo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		titulo.setBorder(new LineBorder(new Color(0, 0, 0)));
		titulo.setBounds(591, 155, 418, 30);
		titulo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (titulo.getText().length() == 100) {
			         e.consume(); 
			    }
			}
		});
		titulo.setText(p.getTitulo());
		add(titulo);
		titulo.setColumns(10);
		
		JButton btnSubirActividad = new JButton("Subir actividad");
		btnSubirActividad.setForeground(new Color(255, 255, 255));
		btnSubirActividad.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!titulo.getText().isEmpty()) {
					try {
						Actividad a = new Actividad(titulo.getText(), descripcion.getText(), "", fechainicio.getText(), fechafin.getText(), 
								(ZonaAccion)zonaaccion.getSelectedItem(), (TipoOferta)tipooferta.getSelectedItem(), null, null, p.getOng());
						p.eliminarPropuesta();
						padre.volverAPropuestasModificado();
						
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
					
				} else {
					//mostrar error
				}
			}
		});
		btnSubirActividad.setBackground(new Color(51, 204, 204));
		btnSubirActividad.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		btnSubirActividad.setBounds(573, 627, 159, 41);
		add(btnSubirActividad);
		
		JButton btnCancelar = new JButton("Cancelar\r\n");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				padre.volverAPropuestas();
			}
		});
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		btnCancelar.setBackground(new Color(51, 204, 204));
		btnCancelar.setBounds(802, 627, 159, 41);
		add(btnCancelar);
		
		JLabel lblAsignaturaRelacionada = new JLabel("Asignatura relacionada:");
		lblAsignaturaRelacionada.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblAsignaturaRelacionada.setBounds(42, 460, 225, 28);
		add(lblAsignaturaRelacionada);
		
		JComboBox<ZonaAccion> comboBox = new JComboBox<ZonaAccion>();
		comboBox.setEnabled(false);
		comboBox.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		comboBox.setBounds(42, 498, 401, 31);
		add(comboBox);
		
		JLabel lblProyectoEnEl = new JLabel("Proyecto en el que se incluye:");
		lblProyectoEnEl.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblProyectoEnEl.setBounds(42, 539, 364, 28);
		add(lblProyectoEnEl);
		
		JComboBox<ZonaAccion> comboBox_1 = new JComboBox<ZonaAccion>();
		comboBox_1.setEnabled(false);
		comboBox_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		comboBox_1.setBounds(42, 577, 401, 31);
		add(comboBox_1);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
	}
}
