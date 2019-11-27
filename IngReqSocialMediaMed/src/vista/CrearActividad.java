package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import modelo.Asignatura;
import modelo.Propuesta;
import modelo.Proyecto;
import modelo.TipoOferta;
import modelo.Tupla;
import modelo.ZonaAccion;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;


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
		
		JComboBox<Asignatura> asignatura = new JComboBox<Asignatura>();
		for(Asignatura a : Asignatura.getAsignaturasSimple()) {
			asignatura.addItem(a);
		}
		asignatura.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		asignatura.setBounds(42, 485, 401, 31);
		asignatura.setEnabled(false);
		add(asignatura);
		
		JComboBox<Tupla> proyecto = new JComboBox<Tupla>();
		for(Tupla t : Proyecto.getProyectosSimple()) {
			proyecto.addItem(t);
		}
		proyecto.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		proyecto.setBounds(42, 571, 401, 31);
		proyecto.setEnabled(false);
		add(proyecto);
		
		JCheckBox proyectosi = new JCheckBox("Actividad incluida en un proyecto");
		proyectosi.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		proyectosi.setBounds(42, 544, 335, 21);
		proyectosi.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		        JCheckBox cb = (JCheckBox) event.getSource();
		        if (cb.isSelected()) {
		        	proyecto.setEnabled(true);
		        } else {
		        	proyecto.setEnabled(false);
		        }
		    }
		});
		proyectosi.setSelected(false);
		add(proyectosi);
		
		JCheckBox asignaturasi = new JCheckBox("Actividad relacionada con una asignatura");
		asignaturasi.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		asignaturasi.setBounds(42, 458, 401, 21);
		asignaturasi.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		        JCheckBox cb = (JCheckBox) event.getSource();
		        if (cb.isSelected()) {
		        	asignatura.setEnabled(true);
		        } else {
		        	asignatura.setEnabled(false);
		        }
		    }
		});
		asignaturasi.setSelected(false);
		add(asignaturasi);
		
		JButton btnSubirActividad = new JButton("Subir actividad");
		btnSubirActividad.setForeground(new Color(255, 255, 255));
		btnSubirActividad.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!titulo.getText().isEmpty()) {
					try {
						Asignatura asig = ( asignaturasi.isSelected())? (Asignatura) asignatura.getSelectedItem() : null;
						Proyecto proy = (proyectosi.isSelected())? new Proyecto(Integer.parseInt(((Tupla) proyecto.getSelectedItem()).elemento1)) : null;
						
						Actividad a = new Actividad(titulo.getText(), descripcion.getText(), "", fechainicio.getText(), fechafin.getText(), 
								(ZonaAccion)zonaaccion.getSelectedItem(), (TipoOferta)tipooferta.getSelectedItem(), asig, proy, p.getOng());
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
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
	}
}
