package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modelo.Actividad;
import modelo.ONG;
import modelo.PDI;
import modelo.Proyecto;
import modelo.Solicitud;
import modelo.Tupla;
import utilidades.ToggleSelectionModel;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.Color;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import controlador.CtrListaGestionActividades;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.TextArea;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class GestionActividades extends JPanel {
	enum Modo {
		Gestor, PDI, ONG
	}
	
	enum Pantalla {
		Solicitudes, Participantes, Vacio
	}
	
	private JLabel aquititulo, aquidescripcion;
	private JTextField titulo;
	private JPanel gestionarPersonas;
	private JButton btnEditar;
	private JButton btnEliminar;
	private DefaultListModel<Tupla> actividades;
	private JList<Tupla> listaActividades;
	private GestionActividades yo;
	private Actividad consultado;
	private Modo modo;
	private Pantalla pantalla;
	private PDI pdi;
	private ONG ong;
	private JLabel aquiasiginvest;
	private JLabel aquiproyecto;
	private JLabel aquitipooferta;
	private JButton solicitudes;
	private JButton btnParticipantes;
	private JLabel aquiambito;
	private JLabel aquizonaaccion;
	private JLabel aquifechafin;
	private JLabel aquifechaini;
	private JLabel lblAsigInves;
	private JLabel lblParticipantes;
	private JLabel info;
	private JButton btnAceptar;
	private DefaultListModel<Tupla> participantes, solicitantes;
	private JButton btnRechazar;

	
	public void establecerConsultado(Actividad p) {
		if(p != null) {
			consultado = p;
			aquititulo.setText(p.getTitulo());
			aquidescripcion.setText("<html>" + p.getDescripcion() + "<html>");
			aquifechaini.setText(p.getFechainicio());
			aquifechafin.setText(p.getFechafinal());
			aquizonaaccion.setText(p.getZonaaccion().toString());
			aquiambito.setText(p.getAmbito().toString());
			aquitipooferta.setText(p.getTipooferta().toString());
			if(p.getAsignatura() != null) {
				lblAsigInves.setText("Asignatura:");
				aquiasiginvest.setText(p.getAsignatura().getNombre());
			} else if (p.getInvestigador() != null) {
				lblAsigInves.setText("Investigador:");
				aquiasiginvest.setText(p.getInvestigador().getNombre() + " " + p.getInvestigador().getApellido1());
			} else {
				lblAsigInves.setText("Actividad de voluntariado");
				aquiasiginvest.setText("");
			}
			if(p.getProyecto() != null) {
				aquiproyecto.setText(p.getProyecto().getNombre());
			} else {
				aquiproyecto.setText("No incluida en ningún proyecto");
			}
			if(modo != Modo.ONG) {
				btnEditar.setEnabled(true);
				btnEliminar.setEnabled(true);
			}
			btnParticipantes.setEnabled(true);
			solicitudes.setEnabled(true);
			if(pantalla != Pantalla.Vacio) {
				ponerModoVacio();
			}
		} else {
			consultado = null;
			aquititulo.setText("");
			aquidescripcion.setText("");
			aquifechaini.setText("");
			aquifechafin.setText("");
			aquizonaaccion.setText("");
			aquiambito.setText("");
			aquitipooferta.setText("");
			lblAsigInves.setText("Asig/Inves:");
			aquiasiginvest.setText("");
			aquiproyecto.setText("");
			btnEditar.setEnabled(false);
			btnEliminar.setEnabled(false);
			btnParticipantes.setEnabled(false);
			solicitudes.setEnabled(false);
			if(pantalla != Pantalla.Vacio) {
				ponerModoVacio();
			}
		}
	}
	
	
	public GestionActividades(MenuPrincipal padre, ONG ong, PDI pdi) { 	//Si se entra como ONG se deja usu null y se envia ong
																		//Si se entra como PDI se deja ong null y se envia pdi
																		//Si se entra como Gestor se deja ambos null
		if(ong != null) {
			modo = Modo.ONG;
			this.ong = ong;
		} else if (pdi != null) {
			modo = Modo.PDI;
			this.pdi = pdi;
		} else {
			modo = Modo.Gestor;
		}
		
		setBackground(Color.WHITE);
		setBounds(100, 100, 1100, 715);
		setLayout(null);
		
		consultado = null;
		yo = this;
		JLabel lblxb = new JLabel("<html>&larr;<html>");
		lblxb.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion
				if(modo.equals(Modo.Gestor)) {
					padre.cambiarGestor();
				} else if (modo.equals(Modo.PDI)) {
					padre.cambiarUsuario(pdi);
				} else {
					padre.cambiarONG(ong);
				}
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
		
		JLabel lblCreacionProy = new JLabel("ACTIVIDADES");
		lblCreacionProy.setBounds(0, 21, 1100, 39);
		lblCreacionProy.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 29));
		lblCreacionProy.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCreacionProy);
		
		JLabel lblCopyright = new JLabel("2019 AccionSocialMed\u00AE es una marca registrada de CoderZ. Reservados todos los derechos. Versi\u00F3n 2.1.29.15");
		lblCopyright.setBounds(20, 691, 671, 14);
		add(lblCopyright);
		
		JScrollPane scroll3 = new JScrollPane();
		scroll3.setBounds(30, 114, 251, 543);
		add(scroll3);
		
		actividades = new DefaultListModel<Tupla>();
		actualizarActividades();
		
		listaActividades = new JList<Tupla>(actividades);
		listaActividades.setLayoutOrientation(JList.VERTICAL);
		listaActividades.setBorder(new LineBorder(new Color(0, 0, 0)));
		listaActividades.setBackground(SystemColor.menu);
		listaActividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaActividades.setLayoutOrientation(JList.VERTICAL);
		listaActividades.addListSelectionListener(new CtrListaGestionActividades(this, listaActividades));
		scroll3.setViewportView(listaActividades);
		
		JLabel lblListaDeProyectos = new JLabel("Lista de actividades");
		lblListaDeProyectos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeProyectos.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblListaDeProyectos.setBounds(20, 82, 261, 30);
		add(lblListaDeProyectos);
		
		ponerModoVacio();
		
						
						JLabel lblCreaeditaProyectosAqu = new JLabel("Solicitudes / Participantes");
						lblCreaeditaProyectosAqu.setHorizontalAlignment(SwingConstants.CENTER);
						lblCreaeditaProyectosAqu.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						lblCreaeditaProyectosAqu.setBounds(658, 82, 409, 30);
						add(lblCreaeditaProyectosAqu);
						
						
						JPanel panel = new JPanel();
						panel.setBorder(new LineBorder(new Color(0, 0, 0)));
						panel.setBounds(291, 114, 359, 543);
						add(panel);
						panel.setLayout(null);
						
						JLabel label_1 = new JLabel("T\u00EDtulo:");
						label_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						label_1.setBounds(27, 10, 54, 30);
						panel.add(label_1);
						
						aquititulo = new JLabel("");
						aquititulo.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
						aquititulo.setBounds(27, 37, 308, 30);
						panel.add(aquititulo);
						
						JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
						lblDescripcin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						lblDescripcin.setBounds(27, 77, 117, 36);
						panel.add(lblDescripcin);
								
								JLabel lblActividades_1 = new JLabel("Fecha inicio:");
								lblActividades_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
								lblActividades_1.setBounds(27, 220, 105, 39);
								panel.add(lblActividades_1);
								
								btnEditar = new JButton("Editar");
								btnEditar.setEnabled(false);
								btnEditar.addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										if(consultado != null) {
											padre.cambiarAEditarActividad(consultado, modo.equals(Modo.Gestor));
										}
									}
								});
								btnEditar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
								btnEditar.setBackground(new Color(51, 204, 204));
								btnEditar.setBounds(27, 438, 142, 36);
								if(modo.equals(Modo.ONG)) {
									btnEditar.setVisible(false);
								}
								panel.add(btnEditar);
								
								btnEliminar = new JButton("Eliminar");
								btnEliminar.addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										SeguroEliminarActividad se = new SeguroEliminarActividad(yo, consultado);
										se.setVisible(true);
										yo.setEnabled(false);
									}
								});
								btnEliminar.setEnabled(false);
								btnEliminar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
								btnEliminar.setBackground(new Color(51, 204, 204));
								btnEliminar.setBounds(190, 438, 145, 36);
								if(modo.equals(Modo.ONG)) {
									btnEliminar.setVisible(false);
								}
								panel.add(btnEliminar);
								
								JLabel lblFechaFinal = new JLabel("Fecha final:");
								lblFechaFinal.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
								lblFechaFinal.setBounds(27, 247, 105, 39);
								panel.add(lblFechaFinal);
								
								JLabel lblZonaDeAccin = new JLabel("Zona de acci\u00F3n:");
								lblZonaDeAccin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
								lblZonaDeAccin.setBounds(27, 275, 126, 39);
								panel.add(lblZonaDeAccin);
								
								JLabel lblmbito = new JLabel("\u00C1mbito:");
								lblmbito.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
								lblmbito.setBounds(27, 305, 72, 39);
								panel.add(lblmbito);
								
								JLabel lblTipoOferta = new JLabel("Tipo oferta:");
								lblTipoOferta.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
								lblTipoOferta.setBounds(27, 335, 97, 39);
								panel.add(lblTipoOferta);
								
								lblAsigInves = new JLabel("Asig/Inves:");
								lblAsigInves.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
								lblAsigInves.setBounds(27, 392, 117, 39);
								panel.add(lblAsigInves);
								
								JLabel lblProyecto = new JLabel("Proyecto:");
								lblProyecto.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
								lblProyecto.setBounds(27, 365, 82, 39);
								panel.add(lblProyecto);
								
								aquidescripcion = new JLabel("");
								aquidescripcion.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
								aquidescripcion.setVerticalAlignment(SwingConstants.TOP);
								aquidescripcion.setBounds(27, 114, 308, 108);
								panel.add(aquidescripcion);
								
								aquifechaini = new JLabel("");
								aquifechaini.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
								aquifechaini.setBounds(130, 220, 205, 39);
								panel.add(aquifechaini);
								
								aquifechafin = new JLabel("");
								aquifechafin.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
								aquifechafin.setBounds(130, 247, 205, 39);
								panel.add(aquifechafin);
								
								aquizonaaccion = new JLabel("");
								aquizonaaccion.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
								aquizonaaccion.setBounds(163, 275, 172, 39);
								panel.add(aquizonaaccion);
								
								aquiambito = new JLabel("");
								aquiambito.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
								aquiambito.setBounds(109, 305, 226, 39);
								panel.add(aquiambito);
								
								aquitipooferta = new JLabel("");
								aquitipooferta.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
								aquitipooferta.setBounds(130, 335, 205, 39);
								panel.add(aquitipooferta);
								
								aquiproyecto = new JLabel("");
								aquiproyecto.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
								aquiproyecto.setBounds(130, 365, 205, 39);
								panel.add(aquiproyecto);
								
								aquiasiginvest = new JLabel("");
								aquiasiginvest.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
								aquiasiginvest.setBounds(154, 392, 181, 39);
								panel.add(aquiasiginvest);
								
								solicitudes = new JButton("Solicitudes");
								solicitudes.addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										ponerModoSolicitudes();
									}
								});
								solicitudes.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
								solicitudes.setEnabled(false);
								solicitudes.setBackground(new Color(51, 204, 204));
								solicitudes.setBounds(27, 484, 142, 36);
								panel.add(solicitudes);
								
								btnParticipantes = new JButton("Participantes");
								btnParticipantes.addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										if(consultado != null) {
											ponerModoParticipantes();
										}	
									}
								});
								btnParticipantes.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
								btnParticipantes.setEnabled(false);
								btnParticipantes.setBackground(new Color(51, 204, 204));
								btnParticipantes.setBounds(190, 484, 145, 36);
								panel.add(btnParticipantes);
						
						JLabel lblConsultaUnProyecto = new JLabel("Consulta una actividad aqu\u00ED");
						lblConsultaUnProyecto.setHorizontalAlignment(SwingConstants.CENTER);
						lblConsultaUnProyecto.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						lblConsultaUnProyecto.setBounds(291, 82, 357, 30);
						add(lblConsultaUnProyecto);
		
		
	}


	private void ponerModoSolicitudes() {
		if(gestionarPersonas != null) {
			gestionarPersonas.setVisible(false);
			remove(gestionarPersonas);
			gestionarPersonas = null;
		}
		gestionarPersonas = new JPanel();
		gestionarPersonas.setBorder(new LineBorder(new Color(0, 0, 0)));
		gestionarPersonas.setBounds(658, 114, 409, 543);
		add(gestionarPersonas);
		gestionarPersonas.setVisible(true);
		gestionarPersonas.setLayout(null);
		pantalla = Pantalla.Participantes;
		
		lblParticipantes = new JLabel("SOLICITUDES");
		lblParticipantes.setForeground(Color.BLUE);
		lblParticipantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblParticipantes.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblParticipantes.setBounds(10, 10, 389, 30);
		gestionarPersonas.add(lblParticipantes);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(20, 50, 367, 380);
		gestionarPersonas.add(scroll);
	
		solicitantes = new DefaultListModel<Tupla>();
		actualizarSolicitantes();
		
		JList<Tupla> list = new JList<Tupla>(solicitantes);
		list.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		list.setOpaque(false);
		list.setSelectionModel(new ToggleSelectionModel());
		list.setLayoutOrientation(JList.VERTICAL);
		scroll.setViewportView(list);
		
		info = new JLabel("");
		info.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		info.setBounds(10, 440, 389, 30);
		info.setVisible(false);
		gestionarPersonas.add(info);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					for(Tupla t : list.getSelectedValuesList()) {
						Solicitud s =  new Solicitud(t.elemento1, consultado);
						if(modo.equals(Modo.Gestor)) {
							consultado.aniadirParticipante(t.elemento1);
							s.aceptadoPorPDIGestor();
							s.aceptadoPorONG();
						} else if (modo.equals(Modo.PDI)) {
							s.aceptadoPorPDIGestor();
							if(s.getAceptadoong()) {
								consultado.aniadirParticipante(t.elemento1);
							} 
						} else {
							s.aceptadoPorONG();
							if(s.getAceptadopdi()) {
								consultado.aniadirParticipante(t.elemento1);
							} 
						}
					}
					actualizarSolicitantes();
					info.setText("Solicitante/s aceptados correctamente");
					info.setForeground(Color.GREEN);
					info.setHorizontalAlignment(SwingConstants.CENTER);
					info.setVisible(true);
					Timer timer = new Timer (6000, new ActionListener () 
					{ 
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getWhen() >= 5000) {
								info.setVisible(false);
							} else {
								info.setVisible(true);
							}
						} 
					}); 
					timer.start();
					timer.setRepeats(false);
				} catch (Exception ex) {
					info.setText("ERROR: " + ex.getMessage());
					info.setForeground(Color.RED);
					info.setVisible(true);
					System.out.println(ex.getMessage());
				}
			}
		});
		btnAceptar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		btnAceptar.setBackground(new Color(51, 204, 204));
		btnAceptar.setBounds(73, 480, 128, 36);
		gestionarPersonas.add(btnAceptar);
		
		btnRechazar = new JButton("Rechazar");
		btnRechazar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					for(Tupla t : list.getSelectedValuesList()) {
						Solicitud s =  new Solicitud(t.elemento1, consultado);
						if(modo.equals(Modo.Gestor)) {
							s.rechazadoPorPDIGestor();
							s.rechazadoPorONG();
						} else if (modo.equals(Modo.PDI)) {
							s.rechazadoPorPDIGestor();
						} else {
							s.rechazadoPorONG();
						}
					}
					actualizarSolicitantes();
					info.setText("Solicitante/s rechazados correctamente");
					info.setForeground(Color.GREEN);
					info.setHorizontalAlignment(SwingConstants.CENTER);
					info.setVisible(true);
					Timer timer = new Timer (6000, new ActionListener () 
					{ 
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getWhen() >= 5000) {
								info.setVisible(false);
							} else {
								info.setVisible(true);
							}
						} 
					}); 
					timer.start();
					timer.setRepeats(false);
				} catch (Exception ex) {
					info.setText("ERROR: " + ex.getMessage());
					info.setForeground(Color.RED);
					info.setVisible(true);
					System.out.println(ex.getMessage());
				}
			}
		});
		btnRechazar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		btnRechazar.setBackground(new Color(51, 204, 204));
		btnRechazar.setBounds(211, 480, 128, 36);
		gestionarPersonas.add(btnRechazar);
		
	}


	private void ponerModoVacio() {
		if(gestionarPersonas != null) {
			gestionarPersonas.setVisible(false);
			remove(gestionarPersonas);
			gestionarPersonas = null;
		}
		gestionarPersonas = new JPanel();
		gestionarPersonas.setBorder(new LineBorder(new Color(0, 0, 0)));
		gestionarPersonas.setBounds(658, 114, 409, 543);
		add(gestionarPersonas);
		gestionarPersonas.setVisible(true);
		gestionarPersonas.setLayout(null);
		pantalla = Pantalla.Vacio;
		
		JLabel lblModoCreacin = new JLabel("<html><center>Pulsa sobre una actividad para gestionarla. Aquí podrás gestionar sus solicitudes y sus participantes.</center><html>");
		lblModoCreacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblModoCreacin.setForeground(Color.BLACK);
		lblModoCreacin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblModoCreacin.setBounds(26, 229, 361, 77);
		gestionarPersonas.add(lblModoCreacin);
	}

	private void ponerModoParticipantes(){
		if(gestionarPersonas != null) {
			gestionarPersonas.setVisible(false);
			remove(gestionarPersonas);
			gestionarPersonas = null;
		}
		gestionarPersonas = new JPanel();
		gestionarPersonas.setBorder(new LineBorder(new Color(0, 0, 0)));
		gestionarPersonas.setBounds(658, 114, 409, 543);
		add(gestionarPersonas);
		gestionarPersonas.setVisible(true);
		gestionarPersonas.setLayout(null);
		pantalla = Pantalla.Participantes;
		
		lblParticipantes = new JLabel("PARTICIPANTES");
		lblParticipantes.setForeground(Color.RED);
		lblParticipantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblParticipantes.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblParticipantes.setBounds(10, 10, 389, 30);
		gestionarPersonas.add(lblParticipantes);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(20, 50, 367, 380);
		gestionarPersonas.add(scroll);
	
		participantes = new DefaultListModel<Tupla>();
		actualizarParticipantes();
		
		JList<Tupla> list = new JList<Tupla>(participantes);
		list.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		list.setOpaque(false);
		list.setSelectionModel(new ToggleSelectionModel());
		list.setLayoutOrientation(JList.VERTICAL);
		scroll.setViewportView(list);
		
		info = new JLabel("");
		info.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		info.setBounds(10, 440, 389, 30);
		info.setVisible(false);
		gestionarPersonas.add(info);
		
		btnAceptar = new JButton("Eliminar de la actividad");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					consultado.borrarParticipantes(list.getSelectedValuesList());
					actualizarParticipantes();
					info.setText("Participante/s eliminados correctamente");
					info.setForeground(Color.GREEN);
					info.setHorizontalAlignment(SwingConstants.CENTER);
					info.setVisible(true);
					Timer timer = new Timer (6000, new ActionListener () 
					{ 
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getWhen() >= 5000) {
								info.setVisible(false);
							} else {
								info.setVisible(true);
							}
						} 
					}); 
					timer.start();
					timer.setRepeats(false);
				} catch (Exception ex) {
					info.setText("ERROR: " + ex.getMessage());
					info.setForeground(Color.RED);
					info.setVisible(true);
				}
				
			}
		});
		btnAceptar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		btnAceptar.setBackground(new Color(51, 204, 204));
		btnAceptar.setBounds(93, 480, 221, 36);
		gestionarPersonas.add(btnAceptar);
		
	}
	
	private void actualizarSolicitantes() {
		solicitantes.clear();
		if(!modo.equals(Modo.ONG)) {
			for(Tupla t : Solicitud.getTodasSolicitudesPDIGestorSimple(consultado.getId())) {
				solicitantes.addElement(t);
			}
		} else {
			for(Tupla t : Solicitud.getTodasSolicitudesONGSimple(consultado.getId())) {
				solicitantes.addElement(t);
			}
		}
		
	}


	private void actualizarParticipantes() {
		participantes.clear();
		for(Tupla t : consultado.getParticipantes()) {
			participantes.addElement(t);
		}
	}


	public void actualizarActividades() {
		actividades.clear();
		if(modo.equals(Modo.Gestor)) {
			for(Tupla t : Actividad.getActividadesSimple()) {
				actividades.addElement(t);
			}
		} else if (modo.equals(Modo.PDI)) {
			for(Tupla t : Actividad.getActividadesSimpleConAccesoPDI(pdi.getEmail())) {
				actividades.addElement(t);
			}
		} else {
			for(Tupla t : Actividad.getActividadesSimpleConAccesoONG(ong.getEmail())) {
				actividades.addElement(t);
			}
		}
		
	}
}
