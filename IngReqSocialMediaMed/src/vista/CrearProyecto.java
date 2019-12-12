package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modelo.Actividad;
import modelo.Asignatura;
import modelo.ONG;
import modelo.PDI;
import modelo.Proyecto;
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
import java.awt.Color;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import controlador.CtrListaProyectos;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.ListModel;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class CrearProyecto extends JPanel {

	private Proyecto consultado;
	private JTextField titulo;
	private JLabel aquititulo;
	private JLabel aquipdi;
	private JPanel creareditar;
	private DefaultListModel<Tupla> actividadesProyecto;

	public void establecerConsultado(Proyecto p) {
		if(p != null) {
			consultado = p;
			aquititulo.setText(p.getNombre());
			aquipdi.setText(p.getPDI().getNombre() +  " " + p.getPDI().getApellido1() + " " + p.getPDI().getApellido2());
			actividadesProyecto.clear();
			for(Tupla t : Proyecto.getActividadesSimple(p.getId())) {
				actividadesProyecto.addElement(t);
			}
		} else {
			consultado = null;
			aquititulo.setText("");
			aquipdi.setText("");
			actividadesProyecto.clear();
		}
		
		
	}
	
	
	public CrearProyecto(MenuPrincipal padre) {
		setBackground(Color.WHITE);
		setBounds(100, 100, 1100, 715);
		setLayout(null);
		
		consultado = null;
		
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
		add(lblxb);
		
		JLabel lblCreacionProy = new JLabel("PROYECTOS");
		lblCreacionProy.setBounds(10, 21, 1100, 39);
		lblCreacionProy.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 29));
		lblCreacionProy.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCreacionProy);
		
		JLabel lblCopyright = new JLabel("2019 AccionSocialMed\u00AE es una marca registrada de CoderZ. Reservados todos los derechos. Versi\u00F3n 2.1.29.15");
		lblCopyright.setBounds(10, 660, 537, 14);
		add(lblCopyright);
		
		/*
		JLabel lblAadirActividad = new JLabel("A\u00F1adir nueva actividad");
		lblAadirActividad.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				padre.cambiarACrearActividad(p);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAadirActividad.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAadirActividad.setForeground(Color.BLACK);
			}
		});
		
		lblAadirActividad.setBounds(703, 226, 188, 51);
		add(lblAadirActividad);
		lblAadirActividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirActividad.setForeground(Color.BLACK);
		lblAadirActividad.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblAadirActividad.setBackground(Color.WHITE);
		*/
		
		JScrollPane scroll3 = new JScrollPane();
		scroll3.setBounds(30, 114, 251, 543);
		add(scroll3);
		
		DefaultListModel<Tupla> proyectos = new DefaultListModel<Tupla>();
		for(Tupla t : Proyecto.getProyectosSimple()) {
			proyectos.addElement(t);
		}
		
		JList<Tupla> listaProyectos = new JList<Tupla>(proyectos);
		listaProyectos.setLayoutOrientation(JList.VERTICAL);
		listaProyectos.setBorder(new LineBorder(new Color(0, 0, 0)));
		listaProyectos.setBackground(SystemColor.menu);
		listaProyectos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaProyectos.setLayoutOrientation(JList.VERTICAL);
		scroll3.setViewportView(listaProyectos);
		listaProyectos.addListSelectionListener(new CtrListaProyectos(this, listaProyectos));
		
		JLabel lblListaDeProyectos = new JLabel("Lista de proyectos");
		lblListaDeProyectos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeProyectos.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblListaDeProyectos.setBounds(20, 82, 261, 30);
		add(lblListaDeProyectos);
		
		ponerModoEditar();
		
						
						JLabel lblCreaeditaProyectosAqu = new JLabel("Crea/edita proyectos aqu\u00ED");
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
						
						JScrollPane scroll2 = new JScrollPane();
						scroll2.setBounds(27, 185, 303, 240);
						panel.add(scroll2);
						
						actividadesProyecto = new DefaultListModel<Tupla>();
						
						JList<Tupla> listact = new JList<Tupla>(actividadesProyecto);
						listact.setBackground(UIManager.getColor("Button.background"));
						listact.setSelectionModel(new ToggleSelectionModel());
						listact.setLayoutOrientation(JList.VERTICAL);
						listact.setBorder(new LineBorder(new Color(0, 0, 0)));
						
								scroll2.setViewportView(listact);
								
								JLabel lblActividades_1 = new JLabel("Actividades:");
								lblActividades_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
								lblActividades_1.setBounds(27, 146, 303, 39);
								panel.add(lblActividades_1);
								
								JButton btnEditar = new JButton("Editar");
								btnEditar.setEnabled(false);
								btnEditar.addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										if(consultado != null) {
											
										}
									}
								});
								btnEditar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
								btnEditar.setBackground(new Color(51, 204, 204));
								btnEditar.setBounds(27, 463, 135, 44);
								panel.add(btnEditar);
								
								JButton btnEliminar = new JButton("Eliminar");
								btnEliminar.setEnabled(false);
								btnEliminar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
								btnEliminar.setBackground(new Color(51, 204, 204));
								btnEliminar.setBounds(192, 463, 135, 44);
								panel.add(btnEliminar);
						
						JLabel lblConsultaUnProyecto = new JLabel("Consulta un proyecto aqu\u00ED");
						lblConsultaUnProyecto.setHorizontalAlignment(SwingConstants.CENTER);
						lblConsultaUnProyecto.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						lblConsultaUnProyecto.setBounds(291, 82, 357, 30);
						add(lblConsultaUnProyecto);
		
		
	}


	private void ponerModoCreacion() {
		// TODO Auto-generated method stub
		creareditar = new JPanel();
		creareditar.setBorder(new LineBorder(new Color(0, 0, 0)));
		creareditar.setBounds(658, 114, 409, 543);
		add(creareditar);
		creareditar.setLayout(null);
				
				JComboBox<Tupla> boxProfesor = new JComboBox<Tupla>();
				boxProfesor.setBounds(140, 108, 248, 30);
				for(Tupla t : PDI.getPDISimple()) {
					boxProfesor.addItem(t);
				}
				creareditar.add(boxProfesor);
				
				JLabel lblProfesor = new JLabel("PDI al cargo:");
				lblProfesor.setBounds(27, 101, 117, 36);
				creareditar.add(lblProfesor);
				lblProfesor.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
				
				JLabel lblTitulo = new JLabel("T\u00EDtulo:");
				lblTitulo.setBounds(27, 61, 54, 30);
				creareditar.add(lblTitulo);
				lblTitulo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
				
				titulo = new JTextField();
				titulo.setBounds(91, 61, 297, 30);
				creareditar.add(titulo);
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
				lblActividades.setBounds(27, 147, 361, 39);
				creareditar.add(lblActividades);
				lblActividades.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
				JScrollPane scroll = new JScrollPane();
				scroll.setBounds(27, 185, 361, 240);
				creareditar.add(scroll);
				
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
						creareditar.add(info);
						info.setVisible(false);
						info.setHorizontalAlignment(SwingConstants.CENTER);
						info.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						
						JButton btnPublicarProyecto = new JButton("Publicar proyecto");
						btnPublicarProyecto.setBounds(113, 470, 188, 44);
						creareditar.add(btnPublicarProyecto);
						btnPublicarProyecto.addMouseListener(new MouseAdapter() {
							@Override
							public void mousePressed(MouseEvent e) {
								try {
									if(titulo.getText().isEmpty()) {
										info.setForeground(Color.RED);
										info.setText("El titulo es obligatorio");
										info.setVisible(true);
									} else {
										Proyecto p = new Proyecto(titulo.getText(), new PDI(((Tupla)boxProfesor.getSelectedItem()).elemento1));
										if(!list.isSelectionEmpty()) {
											for(Tupla t : list.getSelectedValuesList()) {
												Actividad.setProyectoSimple(p, Integer.parseInt(t.elemento1));
											}
										}
										titulo.setText("");
										if(boxProfesor.getItemCount() > 0) {
											boxProfesor.setSelectedIndex(0);
										}
										actividades.clear();
										for(Tupla t : Actividad.getActividadesDisponiblesSimple()) {
											actividades.addElement(t);
										}
										info.setForeground(new Color(46, 139, 87));
										info.setText("El proyecto se ha creado correctamente");
										info.setVisible(true);
										Timer timer = new Timer (8000, new ActionListener () 
										{ 
											@Override
											public void actionPerformed(ActionEvent e) {
												if(e.getWhen() >= 7000) {
													info.setVisible(false);
												} else {
													info.setVisible(true);
												}
											} 
										}); 
										timer.start();
										timer.setRepeats(false);
									}
								} catch(Exception ex) {
									info.setForeground(Color.RED);
									System.out.println(ex.getMessage());
									info.setText("Error: el proyecto no se ha creado correctamente");
									info.setVisible(true);
								}
							}
						});
						btnPublicarProyecto.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						btnPublicarProyecto.setBackground(new Color(51, 204, 204));
						
						JLabel lblModoCreacin = new JLabel("MODO CREACI\u00D3N");
						lblModoCreacin.setHorizontalAlignment(SwingConstants.CENTER);
						lblModoCreacin.setForeground(Color.BLUE);
						lblModoCreacin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						lblModoCreacin.setBounds(27, 21, 361, 30);
						creareditar.add(lblModoCreacin);
		
		
		if(boxProfesor.getItemCount() <= 0) {
			boxProfesor.setEnabled(false);
			btnPublicarProyecto.setEnabled(false);
			info.setForeground(Color.RED);
			info.setText("No se puede crear un proyecto sin existir ningún PDI en el sistema");
			info.setVisible(true);
		}
	}
	
	private void ponerModoEditar() {
		//if(consultado != null) {
		creareditar = new JPanel();
		creareditar.setBorder(new LineBorder(new Color(0, 0, 0)));
		creareditar.setBounds(658, 114, 409, 543);
		add(creareditar);
		creareditar.setLayout(null);
				
				JComboBox<Tupla> boxProfesor = new JComboBox<Tupla>();
				boxProfesor.setBounds(140, 108, 248, 30);
				for(Tupla t : PDI.getPDISimple()) {
					boxProfesor.addItem(t);
				}
				creareditar.add(boxProfesor);
				
				JLabel lblProfesor = new JLabel("PDI al cargo:");
				lblProfesor.setBounds(27, 101, 117, 36);
				creareditar.add(lblProfesor);
				lblProfesor.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
				
				JLabel lblTitulo = new JLabel("T\u00EDtulo:");
				lblTitulo.setBounds(27, 61, 54, 30);
				creareditar.add(lblTitulo);
				lblTitulo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
				
				titulo = new JTextField();
				titulo.setBounds(91, 61, 297, 30);
				creareditar.add(titulo);
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
				creareditar.add(lblActividades);
				lblActividades.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
				JScrollPane scroll = new JScrollPane();
				scroll.setBounds(27, 185, 361, 101);
				creareditar.add(scroll);
				
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
						creareditar.add(info);
						info.setVisible(false);
						info.setHorizontalAlignment(SwingConstants.CENTER);
						info.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						
						JScrollPane scroll2 = new JScrollPane();
						scroll2.setBounds(27, 324, 361, 101);
						creareditar.add(scroll2);
						
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
						
						JButton btnPublicarProyecto = new JButton("Guardar");
						btnPublicarProyecto.setBounds(57, 463, 140, 44);
						creareditar.add(btnPublicarProyecto);
						btnPublicarProyecto.addMouseListener(new MouseAdapter() {
							@Override
							public void mousePressed(MouseEvent e) {
								try {
									if(titulo.getText().isEmpty()) {
										info.setForeground(Color.RED);
										info.setText("El titulo es obligatorio");
										info.setVisible(true);
									} else {
										Proyecto p = new Proyecto(titulo.getText(), new PDI(((Tupla)boxProfesor.getSelectedItem()).elemento1));
										if(!list.isSelectionEmpty()) {
											for(Tupla t : list.getSelectedValuesList()) {
												Actividad.setProyectoSimple(p, Integer.parseInt(t.elemento1));
											}
										}
										titulo.setText("");
										if(boxProfesor.getItemCount() > 0) {
											boxProfesor.setSelectedIndex(0);
										}
										actividades.clear();
										for(Tupla t : Actividad.getActividadesDisponiblesSimple()) {
											actividades.addElement(t);
										}
										info.setForeground(new Color(46, 139, 87));
										info.setText("El proyecto se ha creado correctamente");
										info.setVisible(true);
										Timer timer = new Timer (8000, new ActionListener () 
										{ 
											@Override
											public void actionPerformed(ActionEvent e) {
												if(e.getWhen() >= 7000) {
													info.setVisible(false);
												} else {
													info.setVisible(true);
												}
											} 
										}); 
										timer.start();
										timer.setRepeats(false);
									}
								} catch(Exception ex) {
									info.setForeground(Color.RED);
									System.out.println(ex.getMessage());
									info.setText("Error: el proyecto no se ha creado correctamente");
									info.setVisible(true);
								}
							}
						});
						btnPublicarProyecto.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						btnPublicarProyecto.setBackground(new Color(51, 204, 204));
						
						JLabel lblModoCreacin = new JLabel("MODO EDITAR");
						lblModoCreacin.setHorizontalAlignment(SwingConstants.CENTER);
						lblModoCreacin.setForeground(Color.RED);
						lblModoCreacin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						lblModoCreacin.setBounds(27, 21, 361, 30);
						creareditar.add(lblModoCreacin);
						
						JLabel lblEliminaActividadesDe = new JLabel("Elimina actividades de este proyecto:");
						lblEliminaActividadesDe.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						lblEliminaActividadesDe.setBounds(27, 292, 361, 39);
						creareditar.add(lblEliminaActividadesDe);
						
						JButton btnNoGuardar = new JButton("No guardar");
						btnNoGuardar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						btnNoGuardar.setBackground(new Color(51, 204, 204));
						btnNoGuardar.setBounds(207, 463, 140, 44);
						creareditar.add(btnNoGuardar);
		}
	//}
}
