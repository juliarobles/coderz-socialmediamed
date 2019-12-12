package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

import controlador.CtrBotonVerTodo;
import controlador.CtrListaONG;
import controlador.CtrListaPropuesta;

import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import modelo.ONG;
import modelo.Propuesta;
import modelo.Tupla;

import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.TextArea;
import javax.swing.JButton;

public class GestionPropuestas extends JPanel {
	
	public Map<String, String> mapa;
	public Propuesta prop;
	public JList<String> ong;
	/**
	 * Create the panel.
	 * @param padre 
	 */
	public GestionPropuestas(MenuPrincipal padre) {
		setBackground(Color.WHITE);
		prop = null;
		
		JLabel lblCopyright = new JLabel("2019 AccionSocialMed\u00AE es una marca registrada de CoderZ. Reservados todos los derechos. Versi\u00F3n 2.1.29.15");
		lblCopyright.setBounds(10, 660, 537, 14);
		add(lblCopyright);
		setSize(new Dimension(1100, 715));
		
		JLabel lblGestinDePropuestas = new JLabel("Gesti\u00F3n de propuestas");
		lblGestinDePropuestas.setBounds(0, 22, 1100, 42);
		lblGestinDePropuestas.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestinDePropuestas.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 31));
		
		JScrollPane scrollPropuestas = new JScrollPane();
		DefaultListModel<Tupla> listapropuestas = new DefaultListModel<Tupla>();
		JList<Tupla> propuesta = new JList<Tupla>(listapropuestas);
		propuesta.setBackground(UIManager.getColor("Button.background"));
		propuesta.setBorder(new LineBorder(new Color(0, 0, 0)));
		propuesta.setBounds(40, 317, 574, 304);
		propuesta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		propuesta.setLayoutOrientation(JList.VERTICAL);
		scrollPropuestas.setViewportView(propuesta);
		scrollPropuestas.setBounds(40, 317, 443, 304);
		
		DefaultListModel<String> listaong = new DefaultListModel<String>();
		mapa = ONG.getNombresONG();
		for(String o : mapa.keySet()) {
			listaong.addElement(o);
		}
		JScrollPane scrollONG = new JScrollPane();
		ong = new JList<String>(listaong);
		ong.setBackground(UIManager.getColor("Button.background"));
		ong.setBorder(new LineBorder(new Color(0, 0, 0)));
		ong.setBounds(40, 134, 574, 117);
		ong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ong.setLayoutOrientation(JList.VERTICAL);
		ong.addListSelectionListener(new CtrListaONG(ong, listapropuestas, mapa));
		scrollONG.setViewportView(ong);
		scrollONG.setBounds(40, 134, 443, 117);
		
		JLabel lblPropuestas = new JLabel("Filtra por ONG");
		lblPropuestas.setBounds(40, 94, 321, 42);
		lblPropuestas.setHorizontalAlignment(SwingConstants.LEFT);
		lblPropuestas.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		
		JLabel lbldpropuesta = new JLabel("Propuestas");
		lbldpropuesta.setBounds(40, 277, 574, 42);
		lbldpropuesta.setHorizontalAlignment(SwingConstants.LEFT);
		lbldpropuesta.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		
		JLabel vertodo = new JLabel("Ver todas las propuestas");
		vertodo.setBounds(40, 631, 199, 21);
		vertodo.addMouseListener(new CtrBotonVerTodo(vertodo, listapropuestas, ong));
		vertodo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		
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
		setLayout(null);
		add(lblPropuestas);
		add(lbldpropuesta);
		add(vertodo);
		//add(ong);
		//add(propuesta);
		add(lblxb);
		add(lblGestinDePropuestas);
		add(scrollONG);
		add(scrollPropuestas);
		
		JPanel propuestapanel = new JPanel();
		propuestapanel.setBackground(UIManager.getColor("Button.background"));
		propuestapanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		propuestapanel.setBounds(534, 134, 517, 482);
		add(propuestapanel);
		propuestapanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblTitulo.setBounds(10, 10, 64, 31);
		propuestapanel.add(lblTitulo);
		
		JLabel titulo = new JLabel("<html>" + "<html>");
		titulo.setHorizontalAlignment(SwingConstants.LEFT);
		titulo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		titulo.setBounds(10, 38, 497, 36);
		propuestapanel.add(titulo);
		
		JLabel lbldescripcion = new JLabel("Descripcion:");
		lbldescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		lbldescripcion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lbldescripcion.setBounds(10, 84, 389, 31);
		propuestapanel.add(lbldescripcion);
		
		JLabel descripcion = new JLabel("");
		descripcion.setHorizontalAlignment(SwingConstants.LEFT);
		descripcion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		descripcion.setBounds(10, 114, 497, 135);
		propuestapanel.add(descripcion);
		
		JLabel lblFechaInicial = new JLabel("Fecha inicial:");
		lblFechaInicial.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaInicial.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblFechaInicial.setBounds(10, 270, 107, 31);
		propuestapanel.add(lblFechaInicial);
		
		JLabel lblFechaFinal = new JLabel("Fecha final:");
		lblFechaFinal.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaFinal.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblFechaFinal.setBounds(10, 311, 107, 31);
		propuestapanel.add(lblFechaFinal);
		
		JLabel fechaini = new JLabel("");
		fechaini.setHorizontalAlignment(SwingConstants.LEFT);
		fechaini.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		fechaini.setBounds(155, 270, 334, 31);
		propuestapanel.add(fechaini);
		
		JLabel fechafin = new JLabel("");
		fechafin.setHorizontalAlignment(SwingConstants.LEFT);
		fechafin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		fechafin.setBounds(155, 311, 334, 31);
		propuestapanel.add(fechafin);
		
		JButton btnAceptarYCrear = new JButton("Aceptar y crear");
		btnAceptarYCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(prop != null) {
					padre.cambiarACrearActividad(prop);
				}
			}
		});
		btnAceptarYCrear.setForeground(Color.WHITE);
		btnAceptarYCrear.setBackground(new Color(51, 204, 204));
		btnAceptarYCrear.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		btnAceptarYCrear.setBounds(83, 416, 151, 43);
		propuestapanel.add(btnAceptarYCrear);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				prop.eliminarPropuesta();
				prop = null;
				listapropuestas.clear();
				ponerpanelvisible(propuestapanel, false);
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(51, 204, 204));
		btnCancelar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		btnCancelar.setBounds(274, 416, 151, 43);
		propuestapanel.add(btnCancelar);
		
		
		
		JLabel lblPropuestaSeleccionada = new JLabel("Propuesta seleccionada");
		lblPropuestaSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPropuestaSeleccionada.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblPropuestaSeleccionada.setBounds(534, 94, 321, 42);
		add(lblPropuestaSeleccionada);
		
		JLabel lblNombreOng = new JLabel("Nombre ONG:");
		lblNombreOng.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreOng.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblNombreOng.setBounds(10, 352, 125, 31);
		propuestapanel.add(lblNombreOng);
		
		JLabel nomong = new JLabel("");
		nomong.setHorizontalAlignment(SwingConstants.LEFT);
		nomong.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		nomong.setBounds(155, 352, 334, 31);
		propuestapanel.add(nomong);

		propuesta.addListSelectionListener(new CtrListaPropuesta(propuestapanel, propuesta, titulo, descripcion, fechaini, fechafin, nomong, this));
		ponerpanelvisible(propuestapanel, false);
	}
	
	private void ponerpanelvisible(JPanel propuestapanel, boolean b) {
		for(Component c : propuestapanel.getComponents()) {
			c.setVisible(b);
		}
	}
	
	public void setPropuesta(Propuesta p) {
		prop = p;
	}
}
