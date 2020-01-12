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
import modelo.Ambito;
import modelo.Asignatura;
import modelo.PDI;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;


public class CrearActividadPDI extends JPanel {

	enum Modo {
		Crear, Editar
	}
	
	private JPanel contentPane;
	//private JTextField fechafin;
	//private JTextField fechainicio;
	private JTextField titulo;
	public JDateChooser fechaini, fechafinal;

	
	public CrearActividadPDI(MenuPrincipal padre, Propuesta p) {

		setBackground(Color.WHITE);
		setBounds(100, 100, 1100, 715);
		setLayout(null);
		
		JLabel lblCopyright = new JLabel("2019 AccionSocialMed\u00AE es una marca registrada de CoderZ. Reservados todos los derechos. Versi\u00F3n 2.1.29.15");
		lblCopyright.setBounds(10, 660, 537, 14);
		add(lblCopyright);
		
		JLabel lblCrearActividad = new JLabel("Crear Actividad");
		lblCrearActividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearActividad.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 29));
		lblCrearActividad.setBounds(10, 10, 1080, 48);
		add(lblCrearActividad);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblTitulo.setBounds(512, 87, 70, 31);
		add(lblTitulo);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblDescripcion.setBounds(512, 144, 104, 31);
		add(lblDescripcion);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio: ");
		lblFechaInicio.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblFechaInicio.setBounds(511, 366, 126, 31);
		add(lblFechaInicio);
		
		JLabel lblFecha = new JLabel("Fecha Fin: ");
		lblFecha.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblFecha.setBounds(788, 369, 104, 24);
		add(lblFecha);
		
		/*
		 * fechafin = new JTextField();
		 * 
		 * fechafin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		 * fechafin.setBorder(new LineBorder(new Color(0, 0, 0)));
		 * fechafin.setBounds(873, 366, 136, 31); fechafin.setText(p.getFechafinal());
		 * add(fechafin); fechafin.setColumns(10);
		 */
		
		JLabel lblImagen = new JLabel("Imagen:");
		lblImagen.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImagen.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblImagen.setBounds(42, 87, 401, 227);
		add(lblImagen);
		
		JLabel lblTipoOferta = new JLabel("Tipo Oferta:");
		lblTipoOferta.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblTipoOferta.setBounds(511, 497, 126, 31);
		add(lblTipoOferta);
		
		JComboBox<TipoOferta> tipooferta = new JComboBox<TipoOferta>();
		tipooferta.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		for(int cont = 0;TipoOferta.values().length>cont; cont++) {
			tipooferta.addItem(TipoOferta.values()[cont]);
		}
		tipooferta.setSelectedItem(p.getTipooferta());
		tipooferta.setBounds(661, 500, 348, 31);
		add(tipooferta);
	
		JLabel num = new JLabel("255");
		num.setHorizontalAlignment(SwingConstants.CENTER);
		num.setForeground(Color.BLACK);
		num.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		num.setBounds(966, 306, 43, 20);
		add(num);
		
		JTextArea descripcion = new JTextArea();
		
		descripcion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		descripcion.setBorder(new LineBorder(new Color(0, 0, 0)));
		descripcion.setBounds(512, 185, 496, 129);
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
		zonaaccion.setSelectedItem(p.getZonaaccion());
		zonaaccion.setBounds(661, 420, 348, 31);
		add(zonaaccion);
		
		JLabel lblZonaDeAccion = new JLabel("Zona de Accion:");
		lblZonaDeAccion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblZonaDeAccion.setBounds(512, 421, 142, 28);
		add(lblZonaDeAccion);
		
		/*
		 * fechainicio = new JTextField(); fechainicio.setBorder(new LineBorder(new
		 * Color(0, 0, 0))); fechainicio.setFont(new Font("Malgun Gothic Semilight",
		 * Font.PLAIN, 18)); fechainicio.setBounds(617, 366, 136, 31);
		 * fechainicio.setText(p.getFechainicial()); add(fechainicio);
		 * fechainicio.setColumns(10);
		 */
		
		titulo = new JTextField();
		titulo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		titulo.setBorder(new LineBorder(new Color(0, 0, 0)));
		titulo.setBounds(592, 88, 418, 30);
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
				padre.volverAPropuestasPDI();
			}
		});
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		btnCancelar.setBackground(new Color(51, 204, 204));
		btnCancelar.setBounds(798, 562, 159, 41);
		add(btnCancelar);
		
		JComboBox<Asignatura> asignatura = new JComboBox<Asignatura>();
		for(Asignatura a : Asignatura.getAsignaturasSimple()) {
			asignatura.addItem(a);
		}
		asignatura.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		asignatura.setBounds(42, 420, 401, 31);
		asignatura.setEnabled(false);
		add(asignatura);
		
		JComboBox<Tupla> proyecto = new JComboBox<Tupla>();
		for(Tupla t : Proyecto.getProyectosSimple()) {
			proyecto.addItem(t);
		}
		proyecto.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		proyecto.setBounds(42, 552, 401, 31);
		proyecto.setEnabled(false);
		add(proyecto);
		
		JComboBox<Tupla> profesores = new JComboBox<Tupla>();
		for(Tupla t : PDI.getPDISimple()) {
			profesores.addItem(t);
		}
		profesores.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		profesores.setEnabled(false);
		profesores.setBounds(42, 460, 401, 31);
		add(profesores);
		
		JCheckBox proyectosi = new JCheckBox("Actividad incluida en un proyecto");
		proyectosi.setOpaque(false);
		proyectosi.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		proyectosi.setBounds(42, 515, 335, 21);
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
		proyectosi.setEnabled(false);
		add(proyectosi);
		
		JComboBox<String> tipo = new JComboBox<String>();
		tipo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		tipo.setEnabled(false);
		tipo.addItem("Voluntariado");
		tipo.addItem("Aprendizaje");
		tipo.addItem("Investigacion");
		tipo.setBounds(42, 379, 401, 31);
		tipo.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	String s = (String)tipo.getSelectedItem();
		    	if(s.equalsIgnoreCase("Aprendizaje")) {
		    		asignatura.setEnabled(true);
		    		profesores.setEnabled(false);
		    	} else if (s.equalsIgnoreCase("Investigacion")) {
		    		asignatura.setEnabled(false);
		    		profesores.setEnabled(true);
		    	} else {
		    		asignatura.setEnabled(false);
		    		profesores.setEnabled(false);
		    	}
		    }
		});
		add(tipo);
		
		JComboBox<Ambito> ambito = new JComboBox<Ambito>();
		ambito.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		for(int cont = 0;Ambito.values().length>cont; cont++) {
			ambito.addItem(Ambito.values()[cont]);
		}
		ambito.setSelectedItem(p.getAmbito());
		ambito.setBounds(661, 461, 348, 31);
		add(ambito);
		
		JButton btnSubirActividad = new JButton("Guardar propuesta");
		btnSubirActividad.setForeground(new Color(255, 255, 255));
		btnSubirActividad.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!titulo.getText().isEmpty()) {
					try {
						
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						if(!titulo.getText().equals(p.getTitulo())) p.setTitulo(titulo.getText());
						if(!descripcion.getText().equals(p.getDescripcion())) p.setDescripcion(descripcion.getText());
						if(!sdf.format(fechaini.getDate()).equals(p.getFechainicial())) p.setFechainicial(sdf.format(fechaini.getDate()));
						if(!sdf.format(fechafinal.getDate()).equals(p.getFechafinal())) p.setFechafinal(sdf.format(fechafinal.getDate()));
						if(!((ZonaAccion)zonaaccion.getSelectedItem()).equals(p.getZonaaccion())) p.setZonaaccion((ZonaAccion)zonaaccion.getSelectedItem());
						if(!((TipoOferta)tipooferta.getSelectedItem()).equals(p.getTipooferta())) p.setTipooferta((TipoOferta)tipooferta.getSelectedItem());
						if(!((Ambito)ambito.getSelectedItem()).equals(p.getAmbito())) p.setAmbito((Ambito)ambito.getSelectedItem());
						p.setAceptadopdi(1);
						padre.volverAPropuestasPDImodificado();
							
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
		btnSubirActividad.setBounds(592, 562, 194, 41);
		add(btnSubirActividad);
		
		
		
		
		JLabel lblqueTipoDe = new JLabel("\u00BFQue tipo de actividad es?");
		lblqueTipoDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblqueTipoDe.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblqueTipoDe.setBounds(42, 345, 401, 24);
		add(lblqueTipoDe);
		
		JLabel lblmbito = new JLabel("\u00C1mbito:");
		lblmbito.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblmbito.setBounds(512, 459, 142, 28);
		add(lblmbito);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		fechaini = new JDateChooser();
		fechaini.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		try {
			fechaini.setDate(sdf.parse(p.getFechainicial()));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		fechaini.setBounds(617, 366, 136, 31);
		add(fechaini);
		
		fechafinal = new JDateChooser();
		fechafinal.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		fechafinal.setBounds(873, 366, 136, 31);
		try {
			fechafinal.setDate(sdf.parse(p.getFechafinal()));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		add(fechafinal);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
	}
}
