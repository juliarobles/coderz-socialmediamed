package vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.regex.*;
import java.util.regex.Pattern;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

import controlador.CtrCrearPropuesta;
import modelo.Ambito;
import modelo.Meses;
import modelo.ONG;
import modelo.TipoOferta;
import modelo.ZonaAccion;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class CrearPropuesta extends JPanel {
	
		
	private ONG ong;
	private CtrCrearPropuesta control;
	private JTextField campoTitulo;
	//private JComboBox <Integer>dIni, dFin;
	//private JComboBox <Meses>mIni, mFin;
	private JButton btnCrear, btnCancelar;
	private JTextArea campoExplicacion;
	public JComboBox zonaaccion, ambito, tipooferta;
	private JDateChooser fechaini, fechafin;
	public JLabel info;
	
	//private Propuesta propuestaActiva;
	

	/**
	 * Create the panel.
	 */
	public CrearPropuesta(ONG ong, MenuPrincipal padre) {
		setForeground(Color.WHITE);
		this.ong = ong;
		
		this.setSize(1100,715);
		
		JLabel lblLimiteCaracteres = new JLabel("");
		lblLimiteCaracteres.setForeground(Color.GRAY);
		lblLimiteCaracteres.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		lblLimiteCaracteres.setBounds(859, 77, 46, 14);
		add(lblLimiteCaracteres);
		lblLimiteCaracteres.setText( 0+ "/" + 100);
		
		JLabel lblCopyright = new JLabel("2019 AccionSocialMed\u00AE es una marca registrada de CoderZ. Reservados todos los derechos. Versi\u00F3n 2.1.29.15");
		lblCopyright.setBounds(10, 660, 537, 14);
		add(lblCopyright);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setBounds(91, 69, 75, 20);
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		
		JLabel lblSolicitud = new JLabel("Solicitud de actividad");
		lblSolicitud.setBounds(170, 27, 679, 31);
		lblSolicitud.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		
		campoTitulo = new JTextField();
		campoTitulo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				 int limite  = 100;
				
					if (campoTitulo.getText().length()== limite)
					     e.consume();
					
					
				if(campoTitulo.getText().length()>limite) {
					campoTitulo.setText(campoTitulo.getText().substring(0, limite));
					e.consume();
				}
				 lblLimiteCaracteres.setText( (campoTitulo.getText().length())+ "/" + limite);
				
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				int limite = 100;
				lblLimiteCaracteres.setText( (campoTitulo.getText().length())+ "/" + limite);
				if(e.getKeyCode()==8) {
					
				}else
				if (campoTitulo.getText().length()>= limite) e.consume();
				
			}
		});
		campoTitulo.setBounds(172, 71, 677, 20);
		campoTitulo.setColumns(10);
		
		JLabel lblExplicacin = new JLabel("Explicaci\u00F3n:");
		lblExplicacin.setBounds(93, 97, 75, 20);
		lblExplicacin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExplicacin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		
		JScrollBar BarraExplicacion = new JScrollBar();
		BarraExplicacion.setBounds(1703, 102, 17, 48);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio:");
		lblFechaInicio.setBounds(153, 305, 118, 31);
		lblFechaInicio.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		
		JLabel lblFechaFin = new JLabel("Fecha fin:");
		lblFechaFin.setBounds(439, 306, 108, 28);
		lblFechaFin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaFin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		setLayout(null);
		add(lblTitulo);
		add(campoTitulo);
		add(lblExplicacin);
		add(lblFechaInicio);
		add(lblFechaFin);
		add(lblSolicitud);
		add(BarraExplicacion);
		
		JButton btnEnviarSolicitud = new JButton("Enviar solicitud");
		btnEnviarSolicitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnviarSolicitud.setForeground(Color.WHITE);
		btnEnviarSolicitud.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 17));
		btnEnviarSolicitud.setBounds(779, 290, 160, 63);
		add(btnEnviarSolicitud);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 17));
		btnCancelar.setBounds(779, 401, 160, 62);
		add(btnCancelar);
		
		btnEnviarSolicitud.setBackground(new Color(51,204,204));
		btnCancelar.setBackground(new Color(51,204,204));
		control = new CtrCrearPropuesta(this, ong, padre);
		this.btnCancelar =btnCancelar;
		this.btnCrear= btnEnviarSolicitud;
		
		JLabel lblLimiteCaracteresDescripcion = new JLabel("9/100");
		lblLimiteCaracteresDescripcion.setForeground(Color.GRAY);
		lblLimiteCaracteresDescripcion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		lblLimiteCaracteresDescripcion.setBounds(859, 249, 46, 14);
		add(lblLimiteCaracteresDescripcion);
		 lblLimiteCaracteresDescripcion.setText( 0+ "/" + 255);
		
		JTextArea cmpExplicacion = new JTextArea();
		cmpExplicacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int limite  = 255;
				 
					
				 lblLimiteCaracteresDescripcion.setText( (campoExplicacion.getText().length())+ "/" + limite);
					if(e.getKeyCode()==8) {
						
					}else if (campoExplicacion.getText().length()>= limite)
					     e.consume();
					
					
			}
			@Override
			public void keyReleased(KeyEvent e) {
				 int limite  = 255;
				 lblLimiteCaracteresDescripcion.setText( (campoExplicacion.getText().length())+ "/" + limite);
					{if (campoExplicacion.getText().length()>= limite)
					     e.consume();
					
					}
				if(campoExplicacion.getText().length()>limite) {
					campoExplicacion.setText(campoExplicacion.getText().substring(0, 254));
				}
			}
		});
	
		cmpExplicacion.setBounds(172, 102, 677, 163);
		campoExplicacion = cmpExplicacion;
		campoExplicacion.setLineWrap(true);
		campoExplicacion.setWrapStyleWord(true);
		
		add(cmpExplicacion);
		
		JScrollPane scrollPane = new JScrollPane(campoExplicacion);
		scrollPane.setBounds(172, 102, 677, 161);
		add(scrollPane);
		
		fechaini = new JDateChooser();
		fechaini.setBounds(281, 317, 133, 19);
		fechaini.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		add(fechaini);
		
		fechafin = new JDateChooser();
		fechafin.setBounds(551, 317, 124, 19);
		fechafin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		add(fechafin);
		
		zonaaccion = new JComboBox();
		zonaaccion.setBounds(281, 347, 348, 31);
		zonaaccion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		for(int cont = 0;ZonaAccion.values().length>cont; cont++) {
			zonaaccion.addItem(ZonaAccion.values()[cont]);
		}
		zonaaccion.setSelectedIndex(0);
		add(zonaaccion);
		
		JLabel lblZonaAccion = new JLabel("Zona accion:");
		lblZonaAccion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblZonaAccion.setBounds(153, 341, 118, 28);
		add(lblZonaAccion);
		
		JLabel lblAmbito = new JLabel("Ambito:");
		lblAmbito.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblAmbito.setBounds(153, 378, 118, 28);
		add(lblAmbito);
		
		ambito = new JComboBox();
		ambito.setBounds(281, 394, 348, 31);
		ambito.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		for(int cont = 0;Ambito.values().length>cont; cont++) {
			ambito.addItem(Ambito.values()[cont]);
		}
		ambito.setSelectedIndex(0);
		add(ambito);
		
		JLabel sas = new JLabel("Tipo oferta:");
		sas.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		sas.setBounds(153, 416, 118, 28);
		add(sas);
		
		tipooferta = new JComboBox();
		tipooferta.setBounds(281, 446, 348, 31);
		tipooferta.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		for(int cont = 0;TipoOferta.values().length>cont; cont++) {
			tipooferta.addItem(TipoOferta.values()[cont]);
		}
		tipooferta.setSelectedIndex(0);
		add(tipooferta);
		
		info = new JLabel("New label");
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setVisible(false);
		info.setBounds(281, 500, 348, 48);
		info.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		add(info);
		
	
		

		this.btnCancelar.addMouseListener(control);
		this.btnCrear.addMouseListener(control);
		
	
	}

	public JButton getBtnCrear() {
		return btnCrear;
	}

	public void setBtnCrear(JButton btnCrear) {
		this.btnCrear = btnCrear;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	/*
	 * private void llenarDias(JComboBox<Integer> cb) { for(int cont = 1; cont <=
	 * 31; cont++) { cb.addItem(cont); }
	 * 
	 * }
	 * 
	 * 
	 * private void llenarMeses(JComboBox<Meses> cb) { Meses[] a = Meses.values();
	 * for(int cont = 0; cont < a.length; cont++) { cb.addItem(a[cont]); }
	 * 
	 * }
	 */
	public String getCampoTitulo() {
		return campoTitulo.getText();
	}

	public String getFechaIni() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(fechaini.getDate());
	}
	public String getFechaFin() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(fechafin.getDate());
	}
	public void setCampoTitulo(String campoTitulo) {
		this.campoTitulo.setText(campoTitulo);;
	}

	public String getCampoExplicacion() {
		return campoExplicacion.getText();
	}

	public void setCampoExplicacion(String campoExplicacion) {
		this.campoExplicacion.setText(campoExplicacion);;
	}
}
