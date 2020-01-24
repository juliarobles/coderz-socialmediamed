package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modelo.Actividad;
import modelo.ONG;
import modelo.PDI;
import modelo.Proyecto;
import modelo.Seguimiento;
import modelo.Solicitud;
import modelo.Tupla;
import modelo.Usuario;
import modelo.Valoracion;
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
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;

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
import javax.swing.ListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import javax.swing.event.ListSelectionEvent;

@SuppressWarnings("serial")
public class SeguimientoONGPDIGestor extends JPanel {
	enum Modo {
		Gestor, PDI, ONG
	}
	
	enum Pantalla {
		Seguimiento, Vacio
	}
	
	private JPanel gestionarPersonas;
	private DefaultListModel<Tupla> actividades;
	private JList<Tupla> listaActividades;
	private SeguimientoONGPDIGestor yo;
	private int ActConsultada;
	private Modo modo;
	private Pantalla pantalla;
	private PDI pdi;
	private ONG ong;
	private DefaultListModel<Tupla> listaparticipantes;
	private JTextField numHoras;
	private JTextField nota;
	private Seguimiento consultado;
	private boolean tieneValONG;
	private JTextArea comentarioONG, comentarioPDI;
	private JComboBox<Valoracion> valoracionONG;
	private JButton guardarcambio;

	
	
	public SeguimientoONGPDIGestor(MenuPrincipal padre, ONG ong, PDI pdi) { 	//Si se entra como ONG se deja usu null y se envia ong
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
		
		JLabel lblCreacionProy = new JLabel("SEGUIMIENTOS");
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
		//listaActividades.addListSelectionListener(new CtrListaGestionActividades(this, listaActividades));
		scroll3.setViewportView(listaActividades);
		
		JLabel lblListaDeProyectos = new JLabel("Lista de actividades");
		lblListaDeProyectos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeProyectos.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblListaDeProyectos.setBounds(20, 82, 261, 30);
		add(lblListaDeProyectos);
		
		ponerModoVacio();
		//ponerModoSeguimiento();

						
						listaparticipantes = new DefaultListModel<Tupla>();
						JScrollPane scroll = new JScrollPane();
						JList<Tupla> participantes = new JList<Tupla>(listaparticipantes);
						participantes.addListSelectionListener(new ListSelectionListener() {
							public void valueChanged(ListSelectionEvent e) {
								if(!participantes.isSelectionEmpty()) {
									String part = participantes.getSelectedValue().elemento1;
									consultado = new Seguimiento(part, ActConsultada);
									ponerModoSeguimiento();
								}
							}
						});
						participantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						participantes.setLayoutOrientation(JList.VERTICAL);
						participantes.setBorder(new LineBorder(new Color(0, 0, 0)));
						participantes.setBackground(SystemColor.menu);
						scroll.setBounds(301, 116, 249, 541);
						scroll.setViewportView(participantes);
						add(scroll);
						
						guardarcambio = new JButton("Guardar cambios");
						guardarcambio.setEnabled(false);
						guardarcambio.setVisible(false);
						guardarcambio.setForeground(Color.WHITE);
						guardarcambio.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
						guardarcambio.setBackground(new Color(51, 204, 204));
						guardarcambio.setBounds(916, 83, 151, 30);
						add(guardarcambio);
						
						
						JLabel lblListaDeParticipantes = new JLabel("Lista de participantes");
						lblListaDeParticipantes.setHorizontalAlignment(SwingConstants.CENTER);
						lblListaDeParticipantes.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						lblListaDeParticipantes.setBounds(299, 82, 251, 30);
						add(lblListaDeParticipantes);
						
						
		
						listaActividades.addListSelectionListener(new ListSelectionListener() {
							public void valueChanged(ListSelectionEvent e) {
								listaparticipantes.clear();
								if(!listaActividades.isSelectionEmpty()) {
									ActConsultada = Integer.parseInt(listaActividades.getSelectedValue().elemento1);
									listaparticipantes.addAll(Actividad.getParticipantesSimple(Integer.toString(ActConsultada)));
									ponerModoVacio();
									guardarcambio.setEnabled(false);
									guardarcambio.setVisible(false);
								}
							}
						});
		
	}


	private void ponerModoSeguimiento() {
		if(gestionarPersonas != null) {
			gestionarPersonas.setVisible(false);
			remove(gestionarPersonas);
			gestionarPersonas = null;
		}
		gestionarPersonas = new JPanel();
		gestionarPersonas.setBorder(new LineBorder(new Color(0, 0, 0)));
		gestionarPersonas.setBounds(571, 114, 496, 543);
		add(gestionarPersonas);
		gestionarPersonas.setVisible(true);
		gestionarPersonas.setLayout(null);
		pantalla = Pantalla.Seguimiento;
		
		JLabel lblComentarioOng = new JLabel("Comentario de la ONG:");
		lblComentarioOng.setBounds(31, 10, 433, 25);
		lblComentarioOng.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		gestionarPersonas.add(lblComentarioOng);
		
		JLabel lblComentarioDelParticipante = new JLabel("Comentario del participante:");
		lblComentarioDelParticipante.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblComentarioDelParticipante.setBounds(31, 195, 433, 25);
		gestionarPersonas.add(lblComentarioDelParticipante);
		
		JLabel lblComentarioPdiA = new JLabel("Comentario PDI a cargo de la asignatura:");
		lblComentarioPdiA.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblComentarioPdiA.setBounds(31, 374, 433, 25);
		gestionarPersonas.add(lblComentarioPdiA);
		
		
		JLabel numONG = new JLabel(Integer.toString(255 - consultado.getComentarioONG().length()));
		numONG.setHorizontalAlignment(SwingConstants.RIGHT);
		numONG.setForeground(Color.BLACK);
		numONG.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		numONG.setBounds(408, 67, 56, 21);
		numONG.setVisible(false);
		gestionarPersonas.add(numONG);
		
		comentarioONG = new JTextArea();
		comentarioONG.setEditable(false);
		comentarioONG.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 12));
		comentarioONG.setWrapStyleWord(true);
		comentarioONG.setLineWrap(true);
		comentarioONG.setSize(new Dimension(350, 90));
		comentarioONG.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (comentarioONG.getText().length() == 255) {
			         e.consume(); 
			    }
				numONG.setText(Integer.toString(255 - comentarioONG.getText().length()));
			}
		});
		comentarioONG.setBounds(31, 89, 436, 81);
		comentarioONG.setText(consultado.getComentarioONG());
		
		gestionarPersonas.add(comentarioONG);
		
		JLabel lblcualEsTu = new JLabel("Valoraci\u00F3n:");
		lblcualEsTu.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblcualEsTu.setBounds(31, 39, 92, 25);
		gestionarPersonas.add(lblcualEsTu);
		
		JLabel lblEscribeUnComentario = new JLabel("Escribe un comentario al respecto:");
		lblEscribeUnComentario.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblEscribeUnComentario.setBounds(31, 63, 265, 25);
		gestionarPersonas.add(lblEscribeUnComentario);
		
		valoracionONG = new JComboBox<Valoracion>();
		for(int i = 1; i < Valoracion.values().length; i++) {
			valoracionONG.addItem(Valoracion.values()[i]);
		}
		if(consultado.getValoracionONG().equals(Valoracion.No)) {
			valoracionONG.setSelectedItem(Valoracion.Bien);
			tieneValONG = false;
		} else {
			valoracionONG.setSelectedItem(consultado.getValoracionONG());
			tieneValONG = true;
		}
		valoracionONG.setBounds(126, 41, 101, 26);
		valoracionONG.setEnabled(false);
		valoracionONG.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		gestionarPersonas.add(valoracionONG);
		
		JTextArea comentarioUSU = new JTextArea();
		comentarioUSU.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 12));
		comentarioUSU.setEditable(false);
		comentarioUSU.setWrapStyleWord(true);
		comentarioUSU.setSize(new Dimension(350, 90));
		comentarioUSU.setLineWrap(true);
		comentarioUSU.setBounds(31, 272, 436, 81);
		comentarioUSU.setText(consultado.getComentarioPAR());
		gestionarPersonas.add(comentarioUSU);
		
		JLabel lblLaValoracinDel = new JLabel("La valoraci\u00F3n del participante sobre la actividad:");
		lblLaValoracinDel.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblLaValoracinDel.setBounds(31, 224, 318, 25);
		gestionarPersonas.add(lblLaValoracinDel);
		
		JLabel numPDI = new JLabel(Integer.toString(255 - consultado.getComentarioPDI().length()));
		numPDI.setHorizontalAlignment(SwingConstants.RIGHT);
		numPDI.setForeground(Color.BLACK);
		numPDI.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		numPDI.setBounds(408, 409, 56, 21);
		numPDI.setVisible(false);
		gestionarPersonas.add(numPDI);
		
		comentarioPDI = new JTextArea();
		comentarioPDI.setEditable(false);
		comentarioPDI.setWrapStyleWord(true);
		comentarioPDI.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 12));
		comentarioPDI.setSize(new Dimension(350, 90));
		comentarioPDI.setLineWrap(true);
		comentarioPDI.setBounds(31, 438, 436, 81);
		comentarioPDI.setText(consultado.getComentarioPDI());
		comentarioPDI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (comentarioPDI.getText().length() == 255) {
			         e.consume(); 
			    }
				numPDI.setText(Integer.toString(255 - comentarioPDI.getText().length()));
			}
		});
		gestionarPersonas.add(comentarioPDI);
		
		JLabel lblComentarioDelParticipante_1 = new JLabel("Comentario del participante al respecto:");
		lblComentarioDelParticipante_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblComentarioDelParticipante_1.setBounds(31, 248, 318, 25);
		gestionarPersonas.add(lblComentarioDelParticipante_1);
		
		JLabel lblEscribeUnComentario_1 = new JLabel("Escribe un comentario:");
		lblEscribeUnComentario_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblEscribeUnComentario_1.setBounds(31, 403, 152, 25);
		gestionarPersonas.add(lblEscribeUnComentario_1);
		
		JLabel lblNmeroDeHoras = new JLabel("N\u00FAmero de horas:");
		lblNmeroDeHoras.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblNmeroDeHoras.setBounds(251, 39, 127, 25);
		
		gestionarPersonas.add(lblNmeroDeHoras);
		
		numHoras = new JTextField(6);
		numHoras.addKeyListener(new KeyAdapter()
		{
		   public void keyTyped(KeyEvent e)
		   {
		      char caracter = e.getKeyChar();

		      // Verificar si la tecla pulsada no es un digito
		      if(((caracter < '0') ||
		         (caracter > '9')) &&
		         (caracter != '\b' /*corresponde a BACK_SPACE*/))
		      {
		         e.consume();  // ignorar el evento de teclado
		      }
		   }
		});
		numHoras.setEditable(false);
		numHoras.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		numHoras.setBounds(382, 39, 82, 25);
		if(consultado.getNumHoras() >= 0) {
			numHoras.setText(Integer.toString(consultado.getNumHoras()));
		}
		gestionarPersonas.add(numHoras);
		numHoras.setColumns(10);
		
		JLabel valoracionUSU = new JLabel("\"\"");
		valoracionUSU.setHorizontalAlignment(SwingConstants.LEFT);
		valoracionUSU.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		valoracionUSU.setBounds(351, 224, 113, 25);
		if(consultado.getValoracionPAR().equals(Valoracion.No)) {
			valoracionUSU.setText("");
		} else {
			valoracionUSU.setText(consultado.getValoracionPAR().toString());
		}
		gestionarPersonas.add(valoracionUSU);
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setVisible(true);
		lblNota.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblNota.setBounds(247, 403, 49, 25);
		gestionarPersonas.add(lblNota);
		
		nota = new JTextField();
		nota.setEditable(false);
		nota.setVisible(true);
		nota.setColumns(10);
		if(consultado.getNota() >= 0) {
			nota.setText(Double.toString(consultado.getNota()));
		}
		nota.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		nota.setBounds(292, 406, 82, 25);
		gestionarPersonas.add(nota);
		
		JLabel info = new JLabel("\"\"");
		info.setVisible(false);
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		info.setBounds(571, 82, 335, 30);
		add(info);
		
		
		guardarcambio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(modo == Modo.ONG) {
					if(numHoras.getText().isEmpty()) {
						info.setText("Número de horas vacio");
						info.setForeground(Color.RED);
					} else if (comentarioONG.getText().isEmpty()) {
						info.setText("Comentario vacio");
						info.setForeground(Color.RED);
					} else {
						System.out.println(consultado.getComentarioONG() +" !! " + comentarioONG.getText());
						if(!consultado.getComentarioONG().equals(comentarioONG.getText())) consultado.setComentarioONG(comentarioONG.getText());
						System.out.println(consultado.getValoracionONG() +" !! " + valoracionONG.getSelectedItem().toString());
						if(!consultado.getValoracionONG().equals((Valoracion)valoracionONG.getSelectedItem())) consultado.setValoracionONG((Valoracion)valoracionONG.getSelectedItem());
						if(!(consultado.getNumHoras() == Integer.parseInt(numHoras.getText()))) consultado.setNumHoras(Integer.parseInt(numHoras.getText()));
						info.setText("Guardado correctamente");
						info.setForeground(Color.GREEN);
					}
				} else {
					if(nota.getText().isEmpty()) {
						info.setText("Nota vacio");
						info.setForeground(Color.RED);
					} else {
						if(!consultado.getComentarioPDI().equals(comentarioPDI.getText())) consultado.setComentarioPDI(comentarioPDI.getText());
						if(!(consultado.getNota() == Double.parseDouble(nota.getText()))) consultado.setNota(Double.parseDouble(nota.getText()));
						info.setText("Guardado correctamente");
						info.setForeground(Color.GREEN);
					}
				}
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
			}
		});
		
		
		if(modo == Modo.PDI){
			lblEscribeUnComentario.setText("Comentario:");
			if(Actividad.esDeAprendizaje(ActConsultada)) { //Es de aprendizaje y ademas soy su profe ole
				nota.setEditable(true);
				comentarioPDI.setEditable(true);
				guardarcambio.setEnabled(true);
				guardarcambio.setVisible(true);
				numPDI.setVisible(true);
			} else {
				lblEscribeUnComentario_1.setText("");
				lblComentarioPdiA.setVisible(false);
				nota.setVisible(false);
				lblNota.setVisible(false);
				comentarioPDI.setVisible(false);
				numPDI.setVisible(false);
				guardarcambio.setEnabled(false);
				guardarcambio.setVisible(false);
			}
			if(!tieneValONG) {
				valoracionONG.setVisible(false);
			}
		} else {
			if(modo == Modo.ONG) {
				valoracionONG.setEditable(true);
				valoracionONG.setEnabled(true);
				guardarcambio.setEnabled(true);
				guardarcambio.setVisible(true);
				numHoras.setEditable(true);
				comentarioONG.setEditable(true);
				numONG.setVisible(true);
			} else {
				guardarcambio.setEnabled(false);
				guardarcambio.setVisible(false);
				lblEscribeUnComentario.setText("Comentario:");
				if(!tieneValONG) {
					valoracionONG.setVisible(false);
				}
			}
			if(!Actividad.esDeAprendizaje(ActConsultada)) { //Es de aprendizaje y ademas soy su profe ole
				nota.setVisible(false);
				lblNota.setVisible(false);
				comentarioPDI.setVisible(false);
				lblEscribeUnComentario_1.setText("");
				lblComentarioPdiA.setVisible(false);
				numPDI.setVisible(false);
			} else {
				lblEscribeUnComentario_1.setText("Comentario:");
			}
		}
		
	}


	private void ponerModoVacio() {
		if(gestionarPersonas != null) {
			gestionarPersonas.setVisible(false);
			remove(gestionarPersonas);
			gestionarPersonas = null;
		}
		gestionarPersonas = new JPanel();
		gestionarPersonas.setBorder(new LineBorder(new Color(0, 0, 0)));
		gestionarPersonas.setBounds(571, 114, 496, 543);
		add(gestionarPersonas);
		gestionarPersonas.setVisible(true);
		gestionarPersonas.setLayout(null);
		pantalla = Pantalla.Vacio;
		
		JLabel lblModoCreacin = new JLabel("<html><center>Pulsa sobre una actividad para ver sus participantes. Posteriormente, pulse sobre un participante para ver su seguimiento.</center><html>");
		lblModoCreacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblModoCreacin.setForeground(Color.BLACK);
		lblModoCreacin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblModoCreacin.setBounds(10, 229, 476, 77);
		gestionarPersonas.add(lblModoCreacin);
	}


	public void actualizarActividades() {
		actividades.clear();
		System.out.println("hola");
		if(modo.equals(Modo.Gestor)) {
			for(Tupla t : Actividad.getActividadesSimpleFinalizadas()) {
				actividades.addElement(t);
			}
		} else if (modo.equals(Modo.PDI)) {
			for(Tupla t : Actividad.getActividadesSimpleConAccesoPDIFinalizadas(pdi.getEmail())) {
				actividades.addElement(t);
			}
		} else {
			System.out.println("hola");
			for(Tupla t : Actividad.getActividadesSimpleConAccesoONGFinalizadas(ong.getEmail())) {
				System.out.println("ho");
				actividades.addElement(t);
			}
		}
		
	}
}
