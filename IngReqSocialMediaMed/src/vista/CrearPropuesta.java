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
import modelo.Meses;
import modelo.ONG;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class CrearPropuesta extends JPanel {
	
		
	private ONG ong;
	private CtrCrearPropuesta control;
	private JTextField campoTitulo;
	private JTextField campoExplicacion;
	private JTextField anyoInicio;
	private JTextField anyoFin;
	private JComboBox <Integer>dIni, dFin;
	private JComboBox <Meses>mIni, mFin;
	private JButton btnCrear, btnCancelar;
	



	


	
	
	//private Propuesta propuestaActiva;
	

	public JComboBox<Integer> getdIni() {
		return dIni;
	}

	public void setdIni(JComboBox<Integer> dIni) {
		this.dIni = dIni;
	}

	public JComboBox<Integer> getdFin() {
		return dFin;
	}

	public void setdFin(JComboBox<Integer> dFin) {
		this.dFin = dFin;
	}

	/**
	 * Create the panel.
	 */
	public CrearPropuesta(ONG ong, MenuPrincipal padre) {
		setForeground(Color.WHITE);
		this.ong = ong;
		
		this.setSize(1100,715);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setBounds(91, 69, 75, 20);
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		
		JLabel lblSolicitud = new JLabel("Solicitud de actividad");
		lblSolicitud.setBounds(170, 27, 210, 31);
		lblSolicitud.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		
		campoTitulo = new JTextField();
		campoTitulo.setBounds(172, 71, 277, 20);
		campoTitulo.setColumns(10);
		
		JLabel lblExplicacin = new JLabel("Explicaci\u00F3n:");
		lblExplicacin.setBounds(93, 97, 75, 20);
		lblExplicacin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExplicacin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		
		campoExplicacion = new JTextField();
		campoExplicacion.setBounds(172, 97, 704, 145);
		campoExplicacion.setColumns(10);
		
		JScrollBar BarraExplicacion = new JScrollBar();
		BarraExplicacion.setBounds(1703, 102, 17, 48);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio:");
		lblFechaInicio.setBounds(95, 345, 73, 28);
		lblFechaInicio.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		
		JLabel lblDia = new JLabel("D\u00EDa");
		lblDia.setBounds(240, 290, 42, 20);
		lblDia.setHorizontalAlignment(SwingConstants.CENTER);
		lblDia.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(352, 290, 124, 20);
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMes.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		
		JLabel lblAnyo = new JLabel("A\u00F1o");
		lblAnyo.setBounds(576, 290, 25, 20);
		lblAnyo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		
		JLabel lblFechaFin = new JLabel("Fecha fin:");
		lblFechaFin.setBounds(95, 416, 73, 28);
		lblFechaFin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaFin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		
		JComboBox <Integer> DiaInicio = new JComboBox<Integer>();
		DiaInicio.setBounds(240, 345, 42, 28);
		DiaInicio.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		
		JComboBox <Integer>DiaFin = new JComboBox<Integer>();
		DiaFin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		DiaFin.setBounds(240, 416, 42, 28);
		
		JComboBox <Meses>mesInicio = new JComboBox<Meses>();
		mesInicio.setBounds(352, 345, 133, 28);
		mesInicio.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		
		JComboBox<Meses> mesFin = new JComboBox<Meses>();
		mesFin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		mesFin.setBounds(352, 417, 133, 28);
		
		anyoInicio = new JTextField(4);
		((AbstractDocument)anyoInicio.getDocument()).setDocumentFilter(new DocumentFilter(){
	        Pattern regEx = Pattern.compile("\\d*");
	        @Override
	        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {          
	            Matcher matcher = regEx.matcher(text);
	            if(!matcher.matches()){
	                return;
	            }
	            super.replace(fb, offset, length, text, attrs);
	        }
	    });
		anyoInicio.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		anyoInicio.setBounds(546, 345, 86, 28);
		anyoInicio.setColumns(10);
		
		anyoFin = new JTextField(4);
		((AbstractDocument)anyoFin.getDocument()).setDocumentFilter(new DocumentFilter(){
	        Pattern regEx = Pattern.compile("\\d*");
	        @Override
	        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {          
	            Matcher matcher = regEx.matcher(text);
	            if(!matcher.matches()){
	                return;
	            }
	            super.replace(fb, offset, length, text, attrs);
	        }
	    });
		anyoFin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		anyoFin.setBounds(546, 416, 86, 28);
		anyoFin.setColumns(10);
		setLayout(null);
		add(lblTitulo);
		add(campoTitulo);
		add(lblDia);
		add(lblMes);
		add(lblAnyo);
		add(lblExplicacin);
		add(lblFechaInicio);
		add(lblFechaFin);
		add(campoExplicacion);
		add(lblSolicitud);
		add(BarraExplicacion);
		add(DiaInicio);
		add(DiaFin);
		add(mesInicio);
		add(mesFin);
		add(anyoInicio);
		add(anyoFin);
		
		JButton btnEnviarSolicitud = new JButton("Enviar solicitud");
		btnEnviarSolicitud.setForeground(Color.WHITE);
		btnEnviarSolicitud.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 17));
		btnEnviarSolicitud.setBounds(779, 290, 160, 63);
		add(btnEnviarSolicitud);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 17));
		btnCancelar.setBounds(779, 401, 160, 62);
		add(btnCancelar);
		
		btnEnviarSolicitud.setBackground(new Color(51,204,204));
		btnCancelar.setBackground(new Color(51,204,204));
		control = new CtrCrearPropuesta(this, ong, padre);
		this.dIni = DiaInicio;
		this.dFin = DiaFin;
		this.mFin = mesFin;
		this.mIni = mesInicio;
		this.btnCancelar =btnCancelar;
		this.btnCrear= btnEnviarSolicitud;
		llenarMeses(mIni);
		llenarMeses(mFin);
		llenarDias(dIni);
		llenarDias(dFin);
		this.btnCancelar.addMouseListener(control);
		this.btnCrear.addMouseListener(control);
		
		this.dIni.addItemListener(control);
		this.dFin.addItemListener(control);
		this.mFin.addItemListener(control);
		this.mIni.addItemListener(control);
		
	
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

	private void llenarDias(JComboBox<Integer> cb) {
		for(int cont = 1; cont <= 31; cont++) {
			cb.addItem(cont);
		}
		
	}

	public JComboBox<Meses> getmIni() {
		return mIni;
	}



	public JComboBox<Meses> getmFin() {
		return mFin;
	}


	
	private void llenarMeses(JComboBox<Meses> cb) {
		Meses[] a = Meses.values();
		for(int cont = 0; cont < a.length; cont++) {
			cb.addItem(a[cont]);
		}
		
	}



	public String getCampoTitulo() {
		return campoTitulo.getText();
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

	public JTextField getAnyoInicio() {
		return anyoInicio;
	}

	public void setAnyoInicio(JTextField anyoInicio) {
		this.anyoInicio = anyoInicio;
	}

	public JTextField getAnyoFin() {
		return anyoFin;
	}

	public void setAnyoFin(JTextField anyoFin) {
		this.anyoFin = anyoFin;
	}

	
}
