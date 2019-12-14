package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modelo.Actividad;
import modelo.ONG;
import modelo.PDI;
import modelo.Proyecto;
import modelo.Tupla;
import utilidades.ToggleSelectionModel;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class GestionActividades extends JPanel {
	enum Modo {
		Gestor, PDI, ONG
	}
	
	enum Pantalla {
		Editar, Solicitudes, Participantes, Vacio
	}
	
	private JLabel aquipdi, aquititulo;
	private JTextField titulo;
	private JPanel gestionarPersonas;
	private JButton btnEditar;
	private JButton btnEliminar;
	private DefaultListModel<Tupla> actividadesProyecto;
	private DefaultListModel<Tupla> actividades;
	private JList<Tupla> listaActividades;
	private GestionActividades yo;
	private Actividad consultado;
	private Modo modo;
	private Pantalla pantalla;
	private PDI pdi;
	private ONG ong;

	/*
	public void establecerConsultado(Actividad p) {
		if(p != null) {
			consultado = p;
			aquititulo.setText(p.getNombre());
			aquipdi.setText(p.getPDI().getNombre() +  " " + p.getPDI().getApellido1() + " " + p.getPDI().getApellido2());
			actividadesProyecto.clear();
			for(Tupla t : Proyecto.getActividadesSimple(p.getId())) {
				actividadesProyecto.addElement(t);
			}
			btnEditar.setEnabled(true);
			btnEliminar.setEnabled(true);
			if(!modoCreacion) {
				ponerModoCreacion();
			}
		} else {
			consultado = null;
			aquititulo.setText("");
			aquipdi.setText("");
			actividadesProyecto.clear();
			btnEliminar.setEnabled(false);
			btnEditar.setEnabled(false);
		}
	}
	*/
	
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
		scroll3.setViewportView(listaActividades);
		
		JLabel lblListaDeProyectos = new JLabel("Lista de actividades");
		lblListaDeProyectos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeProyectos.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblListaDeProyectos.setBounds(20, 82, 261, 30);
		add(lblListaDeProyectos);
		
		ponerModoVacio();
						
						JLabel lblCreaeditaProyectosAqu = new JLabel("Solicitudes / Participantes / Edici\u00F3n");
						lblCreaeditaProyectosAqu.setHorizontalAlignment(SwingConstants.CENTER);
						lblCreaeditaProyectosAqu.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						lblCreaeditaProyectosAqu.setBounds(658, 82, 409, 30);
						if(modo.equals(Modo.ONG)) {
							lblCreaeditaProyectosAqu.setText("Solicitudes / Participantes");
						}
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
						aquititulo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						aquititulo.setBounds(27, 37, 308, 30);
						panel.add(aquititulo);
						
						JLabel label_2 = new JLabel("PDI al cargo:");
						label_2.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						label_2.setBounds(27, 77, 117, 36);
						panel.add(label_2);
						
						aquipdi = new JLabel("");
						aquipdi.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						aquipdi.setBounds(27, 107, 308, 30);
						panel.add(aquipdi);
						
						actividadesProyecto = new DefaultListModel<Tupla>();
								
								JLabel lblActividades_1 = new JLabel("Actividades:");
								lblActividades_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
								lblActividades_1.setBounds(27, 146, 303, 39);
								panel.add(lblActividades_1);
								
								btnEditar = new JButton("Editar");
								btnEditar.setEnabled(false);
								btnEditar.addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										if(consultado != null) {
											ponerModoEditar();
										}
									}
								});
								btnEditar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
								btnEditar.setBackground(new Color(51, 204, 204));
								btnEditar.setBounds(27, 463, 135, 44);
								if(modo.equals(Modo.ONG)) {
									btnEditar.setVisible(false);
								}
								panel.add(btnEditar);
								
								btnEliminar = new JButton("Eliminar");
								btnEliminar.addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
									}
								});
								btnEliminar.setEnabled(false);
								btnEliminar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
								btnEliminar.setBackground(new Color(51, 204, 204));
								btnEliminar.setBounds(192, 463, 135, 44);
								if(modo.equals(Modo.ONG)) {
									btnEliminar.setVisible(false);
								}
								panel.add(btnEliminar);
						
						JLabel lblConsultaUnProyecto = new JLabel("Consulta una actividad aqu\u00ED");
						lblConsultaUnProyecto.setHorizontalAlignment(SwingConstants.CENTER);
						lblConsultaUnProyecto.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						lblConsultaUnProyecto.setBounds(291, 82, 357, 30);
						add(lblConsultaUnProyecto);
		
		
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


	
	
	private void ponerModoEditar() {
		if(consultado != null) {
		gestionarPersonas.setVisible(false);
		remove(gestionarPersonas);
		gestionarPersonas = null;
		gestionarPersonas = new JPanel();
		pantalla = Pantalla.Editar;
		gestionarPersonas.setBorder(new LineBorder(new Color(0, 0, 0)));
		gestionarPersonas.setBounds(658, 114, 409, 543);
		add(gestionarPersonas);
		gestionarPersonas.setVisible(true);
		gestionarPersonas.setLayout(null);
				
				int i = 0;
				JComboBox<Tupla> boxProfesor = new JComboBox<Tupla>();
				boxProfesor.setBounds(140, 108, 248, 30);
				for(Tupla t : PDI.getPDISimple()) {
					boxProfesor.addItem(t);
					if(t.elemento1.equals(Integer.toString(consultado.getId()))) {
						i = boxProfesor.getItemCount()-1;
					}
				}
				boxProfesor.setSelectedIndex(i);
				gestionarPersonas.add(boxProfesor);
				
				JLabel lblProfesor = new JLabel("PDI al cargo:");
				lblProfesor.setBounds(27, 101, 117, 36);
				gestionarPersonas.add(lblProfesor);
				lblProfesor.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
				
				JLabel lblTitulo = new JLabel("T\u00EDtulo:");
				lblTitulo.setBounds(27, 61, 54, 30);
				gestionarPersonas.add(lblTitulo);
				lblTitulo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
				
				titulo = new JTextField();
				titulo.setText(consultado.getTitulo());
				titulo.setBounds(91, 61, 297, 30);
				gestionarPersonas.add(titulo);
				titulo.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						if (titulo.getText().length() == 100) {
					         e.consume(); 
					    }
					}
				});
				titulo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
				titulo.setColumns(10);
				
				JLabel lblActividades = new JLabel("A\u00F1ade actividades existentes a este proyecto:");
				lblActividades.setBounds(27, 151, 361, 39);
				gestionarPersonas.add(lblActividades);
				lblActividades.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
				JScrollPane scroll = new JScrollPane();
				scroll.setBounds(27, 185, 361, 101);
				gestionarPersonas.add(scroll);
				
				DefaultListModel<Tupla> actividades = new DefaultListModel<Tupla>();
				for(Tupla t : Actividad.getActividadesDisponiblesSimple()) {
					actividades.addElement(t);
				}
				
				JList<Tupla> list = new JList<Tupla>(actividades);
				list.setBackground(UIManager.getColor("Button.background"));
				list.setSelectionModel(new ToggleSelectionModel());
				list.setLayoutOrientation(JList.VERTICAL);
				list.setBorder(new LineBorder(new Color(0, 0, 0)));
				
						scroll.setViewportView(list);
						
						JLabel info = new JLabel("\"\"");
						info.setBounds(27, 435, 361, 25);
						gestionarPersonas.add(info);
						info.setVisible(false);
						info.setHorizontalAlignment(SwingConstants.CENTER);
						info.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						
						JScrollPane scroll2 = new JScrollPane();
						scroll2.setBounds(27, 324, 361, 101);
						gestionarPersonas.add(scroll2);
						
						DefaultListModel<Tupla> actividadesproy = new DefaultListModel<Tupla>();
						for(Tupla t : Proyecto.getActividadesSimple(consultado.getId())) {
							actividadesproy.addElement(t);
						}
						
						JList<Tupla> list2 = new JList<Tupla>(actividadesproy);
						list2.setBackground(UIManager.getColor("Button.background"));
						list2.setSelectionModel(new ToggleSelectionModel());
						list2.setLayoutOrientation(JList.VERTICAL);
						list2.setBorder(new LineBorder(new Color(0, 0, 0)));
						
						scroll2.setViewportView(list2);
						
						JButton btnGuardar = new JButton("Guardar");
						btnGuardar.setBounds(57, 463, 140, 44);
						gestionarPersonas.add(btnGuardar);
						btnGuardar.addMouseListener(new MouseAdapter() {
							@Override
							public void mousePressed(MouseEvent e) {
								try {
									if(titulo.getText().isEmpty()) {
										info.setForeground(Color.RED);
										info.setText("El titulo es obligatorio");
										info.setVisible(true);
									} else {
										if(!titulo.getText().equals(consultado.getTitulo())){
											consultado.setTitulo(titulo.getText());
										}
										/*
										Tupla seleccionada = (Tupla)boxProfesor.getSelectedItem();
										if (!consultado.getPDI().getEmail().equals(seleccionada.elemento1)) {
											consultado.setPDI(new PDI(seleccionada.elemento1));
										}
										*/
										
										actualizarActividades();
										ponerModoVacio();
										//establecerConsultado(consultado);
									}
								} catch(Exception ex) {
									info.setForeground(Color.RED);
									System.out.println(ex.getMessage());
									info.setText("Error: el proyecto no se ha editado correctamente");
									info.setVisible(true);
								}
							}
						});
						btnGuardar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						btnGuardar.setBackground(new Color(51, 204, 204));
						
						JLabel lblModoCreacin = new JLabel("MODO EDITAR");
						lblModoCreacin.setHorizontalAlignment(SwingConstants.CENTER);
						lblModoCreacin.setForeground(Color.RED);
						lblModoCreacin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						lblModoCreacin.setBounds(27, 21, 361, 30);
						gestionarPersonas.add(lblModoCreacin);
						
						JLabel lblEliminaActividadesDe = new JLabel("Elimina actividades de este proyecto:");
						lblEliminaActividadesDe.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						lblEliminaActividadesDe.setBounds(27, 292, 361, 39);
						gestionarPersonas.add(lblEliminaActividadesDe);
						
						JButton btnNoGuardar = new JButton("No guardar");
						btnNoGuardar.addMouseListener(new MouseAdapter() {
							@Override
							public void mousePressed(MouseEvent e) {
								ponerModoVacio();
							}
						});
						btnNoGuardar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						btnNoGuardar.setBackground(new Color(51, 204, 204));
						btnNoGuardar.setBounds(207, 463, 140, 44);
						gestionarPersonas.add(btnNoGuardar);
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
