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
import controlador.CtrListaPropuestaONG;
import controlador.CtrListaPropuestaPDI;

import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import modelo.Actividad;
import modelo.Ambito;
import modelo.Asignatura;
import modelo.ONG;
import modelo.PDI;
import modelo.Propuesta;
import modelo.Proyecto;
import modelo.TipoOferta;
import modelo.Tupla;
import modelo.ZonaAccion;

import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.SystemColor;

public class GestionPropuestasONG extends JPanel {
	
	public Map<String, String> mapa;
	public Propuesta prop;
	public DefaultListModel<Tupla> listapropuestas;
	public ONG ong;
	public JLabel zonaaccion, ambito, tipooferta, proyecto, tipo;
	/**
	 * Create the panel.
	 * @param padre 
	 */
	public GestionPropuestasONG(MenuPrincipal padre, ONG ong) {
		setBackground(Color.WHITE);
		prop = null;
		this.ong = ong;
		JLabel lblCopyright = new JLabel("2019 AccionSocialMed\u00AE es una marca registrada de CoderZ. Reservados todos los derechos. Versi\u00F3n 2.1.29.15");
		lblCopyright.setBounds(10, 691, 537, 14);
		add(lblCopyright);
		setSize(new Dimension(1100, 715));
		
		JLabel lblGestinDePropuestas = new JLabel("Gesti\u00F3n de propuestas");
		lblGestinDePropuestas.setBounds(0, 22, 1100, 42);
		lblGestinDePropuestas.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestinDePropuestas.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 31));
		
		JScrollPane scrollPropuestas = new JScrollPane();
		listapropuestas = new DefaultListModel<Tupla>();
		JList<Tupla> propuesta = new JList<Tupla>(listapropuestas);
		propuesta.setBackground(UIManager.getColor("Button.background"));
		propuesta.setBorder(new LineBorder(new Color(0, 0, 0)));
		propuesta.setBounds(40, 317, 574, 304);
		propuesta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		propuesta.setLayoutOrientation(JList.VERTICAL);
		scrollPropuestas.setViewportView(propuesta);
		scrollPropuestas.setBounds(40, 134, 443, 160);
		
		actualizarLista();
		
		JLabel lbldpropuesta = new JLabel("Actividades validadas, falta confirmaci\u00F3n de la ONG");
		lbldpropuesta.setBounds(42, 94, 574, 42);
		lbldpropuesta.setHorizontalAlignment(SwingConstants.LEFT);
		lbldpropuesta.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		
		JLabel lblxb = new JLabel("<html>&larr;<html>");
		lblxb.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion
				padre.cambiarONG(ong);
				
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
		add(lbldpropuesta);
		//add(ong);
		//add(propuesta);
		add(lblxb);
		add(lblGestinDePropuestas);
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
		titulo.setBounds(73, 10, 434, 36);
		propuestapanel.add(titulo);
		
		JLabel lbldescripcion = new JLabel("Descripcion:");
		lbldescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		lbldescripcion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lbldescripcion.setBounds(10, 105, 389, 31);
		propuestapanel.add(lbldescripcion);
		
		JLabel descripcion = new JLabel("");
		descripcion.setHorizontalAlignment(SwingConstants.LEFT);
		descripcion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		descripcion.setBounds(10, 135, 497, 135);
		propuestapanel.add(descripcion);
		
		JLabel lblFechaInicial = new JLabel("Fecha inicial:");
		lblFechaInicial.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaInicial.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblFechaInicial.setBounds(10, 270, 107, 31);
		propuestapanel.add(lblFechaInicial);
		
		JLabel lblFechaFinal = new JLabel("Fecha final:");
		lblFechaFinal.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaFinal.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblFechaFinal.setBounds(272, 270, 107, 31);
		propuestapanel.add(lblFechaFinal);
		
		JLabel fechaini = new JLabel("");
		fechaini.setHorizontalAlignment(SwingConstants.LEFT);
		fechaini.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		fechaini.setBounds(120, 270, 142, 31);
		propuestapanel.add(fechaini);
		
		JLabel fechafin = new JLabel("");
		fechafin.setHorizontalAlignment(SwingConstants.LEFT);
		fechafin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		fechafin.setBounds(372, 270, 135, 31);
		propuestapanel.add(fechafin);
		
		JButton btnAceptarYCrear = new JButton("Publicar");
		btnAceptarYCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(prop != null) {
					//(String titulo, String descripcion, String imagen, String fechainicio, String fechafinal,
					//ZonaAccion zonaaccion, TipoOferta tipooferta, Asignatura asignatura, Proyecto proyecto, ONG ong, PDI pdi, Ambito ambito) {
						
					Actividad a = new Actividad(prop.getTitulo(), prop.getDescripcion(), null, prop.getFechainicial(), prop.getFechafinal(),
							prop.getZonaaccion(), prop.getTipooferta(), prop.getAsignatura(), prop.getProyecto(), prop.getOng(), prop.getInvestigador(), prop.getAmbito());
					prop.eliminarPropuesta();
					prop = null;
					actualizarLista();
					ponerpanelvisible(propuestapanel, false);
				}
			}
		});
		btnAceptarYCrear.setForeground(Color.WHITE);
		btnAceptarYCrear.setBackground(new Color(51, 204, 204));
		btnAceptarYCrear.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		btnAceptarYCrear.setBounds(83, 429, 151, 43);
		propuestapanel.add(btnAceptarYCrear);
		
		JButton btnCancelar = new JButton("Eliminar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				prop.eliminarPropuesta();
				prop = null;
				actualizarLista();
				ponerpanelvisible(propuestapanel, false);
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(51, 204, 204));
		btnCancelar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		btnCancelar.setBounds(276, 429, 151, 43);
		propuestapanel.add(btnCancelar);
		
		
		
		JLabel lblPropuestaSeleccionada = new JLabel("Propuesta seleccionada");
		lblPropuestaSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPropuestaSeleccionada.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblPropuestaSeleccionada.setBounds(534, 94, 321, 42);
		add(lblPropuestaSeleccionada);
		
		JLabel lblNombreOng = new JLabel("Nombre PDI:");
		lblNombreOng.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreOng.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblNombreOng.setBounds(10, 75, 151, 31);
		propuestapanel.add(lblNombreOng);
		
		JLabel nompdi = new JLabel("");
		nompdi.setHorizontalAlignment(SwingConstants.LEFT);
		nompdi.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		nompdi.setBounds(120, 75, 383, 31);
		propuestapanel.add(nompdi);

		
		
		JLabel lblZonaDeAccin = new JLabel("Zona de acci\u00F3n:");
		lblZonaDeAccin.setHorizontalAlignment(SwingConstants.LEFT);
		lblZonaDeAccin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblZonaDeAccin.setBounds(10, 311, 142, 31);
		propuestapanel.add(lblZonaDeAccin);
		
		zonaaccion = new JLabel("");
		zonaaccion.setHorizontalAlignment(SwingConstants.LEFT);
		zonaaccion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		zonaaccion.setBounds(149, 311, 142, 31);
		propuestapanel.add(zonaaccion);
		
		JLabel sasa = new JLabel("Ambito:");
		sasa.setHorizontalAlignment(SwingConstants.LEFT);
		sasa.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		sasa.setBounds(10, 352, 142, 31);
		propuestapanel.add(sasa);
		
		ambito = new JLabel("");
		ambito.setHorizontalAlignment(SwingConstants.LEFT);
		ambito.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		ambito.setBounds(83, 352, 151, 31);
		propuestapanel.add(ambito);
		
		JLabel lblTipoDeOferta = new JLabel("Tipo de oferta:");
		lblTipoDeOferta.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipoDeOferta.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblTipoDeOferta.setBounds(244, 352, 142, 31);
		propuestapanel.add(lblTipoDeOferta);
		
		tipooferta = new JLabel("");
		tipooferta.setHorizontalAlignment(SwingConstants.LEFT);
		tipooferta.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		tipooferta.setBounds(365, 352, 142, 31);
		propuestapanel.add(tipooferta);
		
		JLabel lblProyecto = new JLabel("Proyecto:");
		lblProyecto.setHorizontalAlignment(SwingConstants.LEFT);
		lblProyecto.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblProyecto.setBounds(10, 388, 142, 31);
		propuestapanel.add(lblProyecto);
		
		proyecto = new JLabel("");
		proyecto.setHorizontalAlignment(SwingConstants.LEFT);
		proyecto.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		proyecto.setBounds(93, 388, 389, 31);
		propuestapanel.add(proyecto);
		
		tipo = new JLabel("Investigaci\u00F3n");
		tipo.setBounds(73, 44, 418, 31);
		propuestapanel.add(tipo);
		tipo.setHorizontalAlignment(SwingConstants.LEFT);
		tipo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblTipo.setBounds(10, 44, 64, 31);
		propuestapanel.add(lblTipo);
		
		propuesta.addListSelectionListener(new CtrListaPropuestaONG(propuestapanel, propuesta, titulo, descripcion, fechaini, fechafin, nompdi, this));
		ponerpanelvisible(propuestapanel, false);
		
		JLabel lblPropuestasPendientesDe = new JLabel("Propuestas pendientes de validaci\u00F3n");
		lblPropuestasPendientesDe.setHorizontalAlignment(SwingConstants.LEFT);
		lblPropuestasPendientesDe.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblPropuestasPendientesDe.setBounds(42, 297, 574, 42);
		add(lblPropuestasPendientesDe);
		
		JLabel lblPropuestasRechazadas = new JLabel("Propuestas rechazadas");
		lblPropuestasRechazadas.setHorizontalAlignment(SwingConstants.LEFT);
		lblPropuestasRechazadas.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblPropuestasRechazadas.setBounds(42, 456, 574, 42);
		add(lblPropuestasRechazadas);
		
		DefaultListModel<Tupla> listaenvalidacion = new DefaultListModel<Tupla>();
		for(Tupla p : Propuesta.getPropuestasSimplePendientesONG(ong.getEmail())) {
			listaenvalidacion.addElement(p);
		}
		
		DefaultListModel<Tupla> listarechazadas = new DefaultListModel<Tupla>();
		for(Tupla p : Propuesta.getPropuestasSimpleRechazadasONG(ong.getEmail())) {
			listarechazadas.addElement(p);
		}
		
		JScrollPane scrollvalidacion = new JScrollPane();
		JList<Tupla> validacion = new JList<Tupla>(listaenvalidacion);
		validacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		validacion.setLayoutOrientation(JList.VERTICAL);
		validacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		validacion.setBackground(SystemColor.menu);
		scrollvalidacion.setBounds(42, 335, 441, 121);
		scrollvalidacion.setViewportView(validacion);
		add(scrollvalidacion);
		
		JScrollPane scrollrechazadas = new JScrollPane();
		JList<Tupla> rechazadas = new JList<Tupla>(listarechazadas);
		rechazadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rechazadas.setLayoutOrientation(JList.VERTICAL);
		rechazadas.setBorder(new LineBorder(new Color(0, 0, 0)));
		rechazadas.setBackground(SystemColor.menu);
		scrollrechazadas.setBounds(42, 495, 441, 121);
		scrollrechazadas.setViewportView(rechazadas);
		add(scrollrechazadas);
	}
	
	private void ponerpanelvisible(JPanel propuestapanel, boolean b) {
		for(Component c : propuestapanel.getComponents()) {
			c.setVisible(b);
		}
	}
	
	public void setPropuesta(Propuesta p) {
		prop = p;
	}
	
	public void actualizarLista() {
		listapropuestas.clear();
		for(Tupla p : Propuesta.getPropuestasSimpleONG(ong.getEmail())) {
			listapropuestas.addElement(p);
		}
	}
}
