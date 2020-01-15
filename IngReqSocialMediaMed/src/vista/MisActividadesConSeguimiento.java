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
public class MisActividadesConSeguimiento extends JPanel {

	enum Pantalla {
		Seguimiento, Vacio
	}
	
	private JPanel gestionarPersonas;
	private DefaultListModel<Tupla> actProximas;
	private JList<Tupla> proximas;
	private DefaultListModel<Tupla> actFinalizadas;
	private JTextField numHoras;
	private JTextField nota;
	private Seguimiento consultado;
	private boolean tieneValONG;
	private JTextArea comentarioONG, comentarioPDI;
	private JComboBox<Valoracion> valoracionUSU;
	private Pantalla pantalla;
	private JTextArea comentarioUSU;

	
	
	public MisActividadesConSeguimiento(MenuPrincipal padre, Usuario usu) { 	
		
		setBackground(Color.WHITE);
		setBounds(100, 100, 1100, 715);
		setLayout(null);
		
		JLabel lblxb = new JLabel("<html>&larr;<html>");
		lblxb.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
					padre.cambiarUsuario(usu);
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
		
		JLabel lblCreacionProy = new JLabel("MIS ACTIVIDADES");
		lblCreacionProy.setBounds(0, 21, 1100, 39);
		lblCreacionProy.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 29));
		lblCreacionProy.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCreacionProy);
		
		JLabel lblCopyright = new JLabel("2019 AccionSocialMed\u00AE es una marca registrada de CoderZ. Reservados todos los derechos. Versi\u00F3n 2.1.29.15");
		lblCopyright.setBounds(20, 691, 671, 14);
		add(lblCopyright);
		
		JScrollPane scroll3 = new JScrollPane();
		scroll3.setBounds(30, 114, 251, 461);
		add(scroll3);
		
		actProximas = new DefaultListModel<Tupla>();
		actProximas.addAll(Actividad.getActividadesSimpleParticipanteProximas(usu.getEmail()));
		
		proximas = new JList<Tupla>(actProximas);
		
		proximas.setLayoutOrientation(JList.VERTICAL);
		proximas.setBorder(new LineBorder(new Color(0, 0, 0)));
		proximas.setBackground(SystemColor.menu);
		proximas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		proximas.setLayoutOrientation(JList.VERTICAL);
		scroll3.setViewportView(proximas);
		
		JLabel lblListaDeProyectos = new JLabel("Pr\u00F3ximas o actuales");
		lblListaDeProyectos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeProyectos.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblListaDeProyectos.setBounds(30, 82, 251, 30);
		add(lblListaDeProyectos);
		
		ponerModoVacio();
		//ponerModoSeguimiento();

						
						actFinalizadas = new DefaultListModel<Tupla>();
						actFinalizadas.addAll(Actividad.getActividadesSimpleParticipanteFinalizadas(usu.getEmail()));
						JScrollPane scroll = new JScrollPane();
						JList<Tupla> finalizadas = new JList<Tupla>(actFinalizadas);
						finalizadas.addListSelectionListener(new ListSelectionListener() {
							public void valueChanged(ListSelectionEvent e) {
								if(!finalizadas.isSelectionEmpty()) {
									int act = Integer.parseInt(finalizadas.getSelectedValue().elemento1);
									consultado = new Seguimiento(usu.getEmail(), act);
									ponerModoSeguimiento();
								}
							}
						});
						finalizadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						finalizadas.setLayoutOrientation(JList.VERTICAL);
						finalizadas.setBorder(new LineBorder(new Color(0, 0, 0)));
						finalizadas.setBackground(SystemColor.menu);
						scroll.setBounds(301, 116, 249, 541);
						scroll.setViewportView(finalizadas);
						add(scroll);
						
						JLabel infoP = new JLabel("Cancelado correctamente");
						infoP.setVisible(false);
						infoP.setHorizontalAlignment(SwingConstants.CENTER);
						infoP.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						infoP.setBounds(30, 585, 251, 30);
						add(infoP);
						
						JLabel lblListaDeParticipantes = new JLabel("Finalizadas");
						lblListaDeParticipantes.setHorizontalAlignment(SwingConstants.CENTER);
						lblListaDeParticipantes.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						lblListaDeParticipantes.setBounds(299, 82, 251, 30);
						add(lblListaDeParticipantes);
						
						JButton btnCancelarParticipacin = new JButton("Cancelar participaci\u00F3n");
						btnCancelarParticipacin.addMouseListener(new MouseAdapter() {
							@Override
							public void mousePressed(MouseEvent e) {
								if(proximas.isSelectionEmpty()) {
									infoP.setText("Nada seleccionado");
									infoP.setForeground(Color.RED);
								} else {
									Actividad.cancelarParticipacion(Integer.parseInt(proximas.getSelectedValue().elemento1), usu.getEmail());
									actProximas.remove(proximas.getSelectedIndex());
									infoP.setText("Cancelado correctamente");
									infoP.setForeground(Color.GREEN);
								}
								infoP.setVisible(true);
								Timer timer = new Timer (6000, new ActionListener () 
								{ 
									@Override
									public void actionPerformed(ActionEvent e) {
										if(e.getWhen() >= 5000) {
											infoP.setVisible(false);
										} else {
											infoP.setVisible(true);
										}
									} 
								}); 
								timer.start();
								timer.setRepeats(false);
							}
						});
						btnCancelarParticipacin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
						btnCancelarParticipacin.setBackground(new Color(51, 204, 204));
						btnCancelarParticipacin.setBounds(33, 621, 241, 36);
						add(btnCancelarParticipacin);
						
						
		
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
		
		JLabel num = new JLabel(Integer.toString(255 - consultado.getComentarioPAR().length()));
		num.setHorizontalAlignment(SwingConstants.RIGHT);
		num.setForeground(Color.BLACK);
		num.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		num.setBounds(408, 252, 56, 21);
		gestionarPersonas.add(num);
		
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
				num.setText(Integer.toString(255 - comentarioONG.getText().length()));
			}
		});
		comentarioONG.setBounds(31, 89, 436, 81);
		comentarioONG.setText(consultado.getComentarioONG());
		
		gestionarPersonas.add(comentarioONG);
		
		JLabel lblcualEsTu = new JLabel("Valoraci\u00F3n:");
		lblcualEsTu.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblcualEsTu.setBounds(31, 39, 92, 25);
		gestionarPersonas.add(lblcualEsTu);
		
		JLabel lblEscribeUnComentario = new JLabel("Comentario:");
		lblEscribeUnComentario.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblEscribeUnComentario.setBounds(31, 63, 265, 25);
		gestionarPersonas.add(lblEscribeUnComentario);
		
		JLabel valoracionONG = new JLabel();
		if(consultado.getValoracionONG().equals(Valoracion.No)) {
			valoracionONG.setVisible(false);
		} else {
			valoracionONG.setText(consultado.getValoracionONG().toString());
		}
		valoracionONG.setBounds(126, 39, 101, 26);
		valoracionONG.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		gestionarPersonas.add(valoracionONG);

		
		
		comentarioUSU = new JTextArea();
		comentarioUSU.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 12));
		comentarioUSU.setWrapStyleWord(true);
		comentarioUSU.setSize(new Dimension(350, 90));
		comentarioUSU.setLineWrap(true);
		comentarioUSU.setBounds(31, 272, 436, 81);
		comentarioUSU.setText(consultado.getComentarioPAR());
		comentarioUSU.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (comentarioUSU.getText().length() == 255) {
			         e.consume(); 
			    }
				num.setText(Integer.toString(255 - comentarioUSU.getText().length()));
			}
		});
		gestionarPersonas.add(comentarioUSU);
		
		JLabel lblLaValoracinDel = new JLabel("\u00BFQue te ha parecido la actividad?");
		lblLaValoracinDel.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblLaValoracinDel.setBounds(31, 224, 235, 25);
		gestionarPersonas.add(lblLaValoracinDel);
		
		
		comentarioPDI = new JTextArea();
		comentarioPDI.setEditable(false);
		comentarioPDI.setWrapStyleWord(true);
		comentarioPDI.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 12));
		comentarioPDI.setSize(new Dimension(350, 90));
		comentarioPDI.setLineWrap(true);
		comentarioPDI.setBounds(31, 438, 436, 81);
		comentarioPDI.setText(consultado.getComentarioPDI());
		gestionarPersonas.add(comentarioPDI);
		
		JLabel lblComentarioDelParticipante_1 = new JLabel("Escribe un comentario:");
		lblComentarioDelParticipante_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblComentarioDelParticipante_1.setBounds(31, 248, 318, 25);
		gestionarPersonas.add(lblComentarioDelParticipante_1);
		
		JLabel lblEscribeUnComentario_1 = new JLabel("Comentario:");
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
		
		valoracionUSU = new JComboBox<Valoracion>();
		for(int i = 1; i < Valoracion.values().length; i++) {
			valoracionUSU.addItem(Valoracion.values()[i]);
		}
		valoracionUSU.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		valoracionUSU.setBounds(263, 224, 201, 25);
		if(consultado.getValoracionPAR().equals(Valoracion.No)) {
			valoracionUSU.setSelectedItem(Valoracion.Bien);
		} else {
			valoracionUSU.setSelectedItem(consultado.getValoracionPAR());
		}
		gestionarPersonas.add(valoracionUSU);
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setVisible(true);
		lblNota.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblNota.setBounds(329, 403, 49, 25);
		gestionarPersonas.add(lblNota);
		
		nota = new JTextField();
		nota.setEditable(false);
		nota.setVisible(true);
		nota.setColumns(10);
		if(consultado.getNota() >= 0) {
			nota.setText(Double.toString(consultado.getNota()));
		}
		nota.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		nota.setBounds(382, 405, 82, 25);
		gestionarPersonas.add(nota);
		
		JLabel info = new JLabel("\"\"");
		info.setVisible(false);
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		info.setBounds(571, 82, 335, 30);
		add(info);
		
		JButton guardarcambios = new JButton("Guardar cambios");
		guardarcambios.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				  if(comentarioUSU.getText().isEmpty()) {
					  info.setText("Número de horas vacio"); 
					  info.setForeground(Color.RED);
				  } else {
					  if(!comentarioUSU.getText().equals(consultado.getComentarioPAR())) consultado.setComentarioPAR(comentarioUSU.getText());
					  if(!consultado.getValoracionPAR().equals(valoracionUSU.getSelectedItem())) consultado.setValoracionPAR((Valoracion)valoracionUSU.getSelectedItem());
					  info.setText("Guardado correctamente"); 
					  info.setForeground(Color.GREEN); 
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
		guardarcambios.setForeground(Color.WHITE);
		guardarcambios.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		guardarcambios.setBackground(new Color(51, 204, 204));
		guardarcambios.setBounds(916, 83, 151, 30);
		add(guardarcambios);
		repaint();
		
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
}
