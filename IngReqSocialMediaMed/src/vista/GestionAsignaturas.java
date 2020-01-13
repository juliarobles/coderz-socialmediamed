package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import modelo.Asignatura;
import modelo.PDI;
import modelo.Tupla;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class GestionAsignaturas extends JPanel {

	
	private DefaultListModel<Asignatura> asignaturas;
	private JTextField tituloA;
	private JTextField gradoA;
	private JTextField tituloM;
	private JTextField gradoM;
	private JComboBox<Tupla> profesoresM;
	private JButton btnGuardar, btnNoGuardar;
	private Asignatura modificando;
	/**
	 * Create the panel.
	 */
	public GestionAsignaturas(MenuPrincipal padre) {
		setBackground(Color.WHITE);
		setBounds(100, 100, 1100, 715);
		setLayout(null);
		
		JLabel lblCopyright = new JLabel("2019 AccionSocialMed\u00AE es una marca registrada de CoderZ. Reservados todos los derechos. Versi\u00F3n 2.1.29.15");
		lblCopyright.setBounds(10, 691, 671, 14);
		add(lblCopyright);
		
		JLabel lblxb = new JLabel("<html>&larr;<html>");
		lblxb.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
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
		lblxb.setBounds(40, 5, 46, 56);
		lblxb.setFont(new Font("Tahoma", Font.PLAIN, 46));
		add(lblxb);
		
		asignaturas = new DefaultListModel<Asignatura>();
		actualizarLista();
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		btnModificar.setBackground(new Color(51, 204, 204));
		btnModificar.setBounds(88, 555, 379, 36);
		add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		btnEliminar.setBackground(new Color(51, 204, 204));
		btnEliminar.setBounds(88, 601, 379, 36);
		add(btnEliminar);
		
		JScrollPane scroll = new JScrollPane();
		JList<Asignatura> list = new JList<Asignatura>(asignaturas);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list.isSelectionEmpty()) {
					btnModificar.setEnabled(false);
					btnEliminar.setEnabled(false);
				} else {
					modificarEnabled(false);
					btnModificar.setEnabled(true);
					btnEliminar.setEnabled(true);
				}
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		scroll.setBounds(88, 119, 379, 426);
		scroll.setViewportView(list);
		add(scroll);
		
		
		
		
		JLabel lblAsignaturasExistentesEn = new JLabel("Asignaturas existentes en el sistema");
		lblAsignaturasExistentesEn.setBounds(111, 89, 337, 25);
		lblAsignaturasExistentesEn.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsignaturasExistentesEn.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		add(lblAsignaturasExistentesEn);
		
		
		
		tituloA = new JTextField();
		tituloA.setBounds(622, 146, 404, 31);
		tituloA.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		add(tituloA);
		tituloA.setColumns(10);
		
		JLabel infoA = new JLabel("Ambos campos deben estar rellenos");
		infoA.setVisible(false);
		infoA.setForeground(Color.RED);
		infoA.setHorizontalAlignment(SwingConstants.CENTER);
		infoA.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		infoA.setBounds(554, 111, 472, 25);
		add(infoA);
		
		JLabel lblAadirAsignaturas = new JLabel("A\u00F1adir asignatura");
		lblAadirAsignaturas.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirAsignaturas.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblAadirAsignaturas.setBounds(554, 89, 472, 25);
		add(lblAadirAsignaturas);
		
		JButton agregar = new JButton("Agregar nueva asignatura");
		
		agregar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		agregar.setBackground(new Color(51, 204, 204));
		agregar.setBounds(545, 311, 481, 36);
		add(agregar);
		
		JLabel lblModificarAsignatura = new JLabel("Modificar asignatura");
		lblModificarAsignatura.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarAsignatura.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblModificarAsignatura.setBounds(554, 380, 472, 25);
		add(lblModificarAsignatura);
		
		JLabel lblTtulo = new JLabel("Nombre:");
		lblTtulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTtulo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblTtulo.setBounds(545, 139, 77, 36);
		add(lblTtulo);
		
		gradoA = new JTextField();
		gradoA.setColumns(10);
		gradoA.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		gradoA.setBounds(622, 187, 404, 31);
		add(gradoA);
		
		JLabel lblGrado = new JLabel("Grado:");
		lblGrado.setHorizontalAlignment(SwingConstants.LEFT);
		lblGrado.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblGrado.setBounds(545, 180, 67, 36);
		add(lblGrado);
		
		JComboBox<Tupla> profesoresA = new JComboBox<Tupla>();
		for(Tupla t : PDI.getPDISimple()) {
			profesoresA.addItem(t);
		}
		profesoresA.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		profesoresA.setBounds(545, 265, 481, 36);
		add(profesoresA);
		
		JLabel lblPdiACargo = new JLabel("PDI a cargo de la asignatura:");
		lblPdiACargo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPdiACargo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblPdiACargo.setBounds(545, 226, 245, 36);
		add(lblPdiACargo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblNombre.setBounds(545, 442, 77, 36);
		add(lblNombre);
		
		JLabel label_1 = new JLabel("Grado:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		label_1.setBounds(545, 483, 67, 36);
		add(label_1);
		
		tituloM = new JTextField();
		tituloM.setEnabled(false);
		tituloM.setColumns(10);
		tituloM.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		tituloM.setBounds(622, 449, 404, 31);
		add(tituloM);
		
		gradoM = new JTextField();
		gradoM.setEnabled(false);
		gradoM.setColumns(10);
		gradoM.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		gradoM.setBounds(622, 490, 404, 31);
		add(gradoM);
		
		profesoresM = new JComboBox<Tupla>();
		profesoresM.setEnabled(false);
		for(Tupla t : PDI.getPDISimple()) {
			profesoresM.addItem(t);
		}
		profesoresM.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		profesoresM.setBounds(545, 569, 481, 36);
		add(profesoresM);
		
		JLabel label_2 = new JLabel("PDI a cargo de la asignatura:");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		label_2.setBounds(545, 529, 245, 36);
		add(label_2);
		
		JLabel infoM = new JLabel("Ambos campos deben estar rellenos y deben existir profesores disponibles");
		infoM.setVisible(false);
		infoM.setForeground(Color.RED);
		infoM.setHorizontalAlignment(SwingConstants.CENTER);
		infoM.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		infoM.setBounds(545, 414, 481, 25);
		add(infoM);
		
		btnNoGuardar = new JButton("No guardar");
		btnNoGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				modificarEnabled(false);
				modificando = null;
			}
		});
		btnNoGuardar.setEnabled(false);
		btnNoGuardar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		btnNoGuardar.setBackground(new Color(51, 204, 204));
		btnNoGuardar.setBounds(803, 617, 223, 36);
		add(btnNoGuardar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(modificando != null) {
					if(tituloM.getText().isEmpty() || gradoM.getText().isEmpty() || profesoresM.getItemCount() == 0) {
						infoM.setText("Ambos campos deben estar rellenos y deben existir profesores");
						infoM.setForeground(Color.RED);
					} else {
						if(!modificando.getNombre().equals(tituloM.getText())) modificando.setNombre(tituloM.getText());
						if(!modificando.getGrado().equals(gradoM.getText())) modificando.setGrado(gradoM.getText());
						if(!modificando.getPDICargo().getEmail().equals(((Tupla)profesoresM.getSelectedItem()).elemento1)) modificando.setPDICargo(new PDI(((Tupla)profesoresM.getSelectedItem()).elemento1));
						infoM.setText("Modificado correctamente");
						infoM.setForeground(Color.GREEN);
						profesoresM.setSelectedIndex(0);
						actualizarLista();
						modificarEnabled(false);
					}
					infoM.setVisible(true);
					Timer timer = new Timer (8000, new ActionListener () 
					{ 
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getWhen() >= 7000) {
								infoM.setVisible(false);
							} else {
								infoM.setVisible(true);
							}
						} 
					}); 
					timer.start();
					timer.setRepeats(false);
				}
			}
		});
		btnGuardar.setEnabled(false);
		btnGuardar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		btnGuardar.setBackground(new Color(51, 204, 204));
		btnGuardar.setBounds(545, 615, 223, 36);
		add(btnGuardar);
		
		JLabel lblTambienSeEliminaran = new JLabel("Tambien se eliminaran todas sus actividades asociadas");
		lblTambienSeEliminaran.setHorizontalAlignment(SwingConstants.CENTER);
		lblTambienSeEliminaran.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		lblTambienSeEliminaran.setBounds(59, 636, 432, 36);
		add(lblTambienSeEliminaran);
		
		JLabel info = new JLabel("Asignatura y actividades eliminadas correctamente");
		info.setVisible(false);
		info.setForeground(Color.GREEN);
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		info.setBounds(50, 71, 472, 25);
		add(info);
		
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!list.isSelectionEmpty()) {
					try {
						list.getSelectedValue().eliminarAsignatura();
						actualizarLista();
						info.setText("Asignatura y actividades eliminadas correctamente");
						info.setForeground(Color.GREEN);
					} catch (Exception ex) {
						info.setText("Ha ocurrido un error al eliminar");
						info.setForeground(Color.RED);
					} finally {
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
					
				}
			}
		});
		
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!list.isSelectionEmpty()) {
					modificando = list.getSelectedValue();
					modificarEnabled(true);
					tituloM.setText(modificando.getNombre());
					gradoM.setText(modificando.getGrado());
					profesoresM.setSelectedIndex(encontrarPdi(modificando.getPDICargo().getEmail()));
				}
			}

			private int encontrarPdi(String email) {
				boolean enc = false;
				int i = 0; 
				List<Tupla> list = PDI.getPDISimple();
				while(i < list.size() && !enc) {
					if(list.get(i).elemento1.equals(email)) {
						enc = true;
					} else {
						i++;
					}
				}
				return (i < list.size()) ? i : 0;
			}
		});
		
		agregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(tituloA.getText().isEmpty() || gradoA.getText().isEmpty() || profesoresA.getItemCount() == 0) {
					infoA.setText("Ambos campos deben estar rellenos y deben existir profesores");
					infoA.setForeground(Color.RED);
				} else {
					//(String nombre, PDI pdi, String grado)
					Asignatura a = new Asignatura(tituloA.getText(), new PDI(((Tupla)profesoresA.getSelectedItem()).elemento1), gradoA.getText());
					tituloA.setText("");
					gradoA.setText("");
					profesoresA.setSelectedIndex(0);
					actualizarLista();
					infoA.setText("Asignatura agregada correctamente");
					infoA.setForeground(Color.GREEN);
				}
				infoA.setVisible(true);
				Timer timer = new Timer (8000, new ActionListener () 
				{ 
					@Override
					public void actionPerformed(ActionEvent e) {
						if(e.getWhen() >= 7000) {
							infoA.setVisible(false);
						} else {
							infoA.setVisible(true);
						}
					} 
				}); 
				timer.start();
				timer.setRepeats(false);
			}
		});
		
	}

	public void actualizarLista(){
		asignaturas.clear();
		for(Asignatura a : Asignatura.getAsignaturasSimple()) {
			asignaturas.addElement(a);
		}
	}
	
	public void modificarEnabled(boolean e) {
		tituloM.setText("");
		gradoM.setText("");
		tituloM.setEnabled(e);
		gradoM.setEnabled(e);
		profesoresM.setEnabled(e);
		btnGuardar.setEnabled(e);
		btnNoGuardar.setEnabled(e);
	}
}
