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
import javax.swing.DefaultListModel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class CrearProyecto extends JPanel {

	private JTextField titulo;

	public CrearProyecto(MenuPrincipal padre) {
		setBackground(Color.WHITE);
		setBounds(100, 100, 1100, 715);
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setBounds(284, 139, 54, 30);
		add(lblTitulo);
		lblTitulo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		
		titulo = new JTextField();
		titulo.setBounds(348, 139, 543, 30);
		titulo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (titulo.getText().length() == 100) {
			         e.consume(); 
			    }
			}
		});
		add(titulo);
		titulo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		titulo.setColumns(10);
		
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
		
		JLabel lblCreacionProy = new JLabel("CREACION DE PROYECTOS");
		lblCreacionProy.setBounds(10, 21, 1100, 39);
		lblCreacionProy.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 29));
		lblCreacionProy.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCreacionProy);

		
		JComboBox<Tupla> boxProfesor = new JComboBox<Tupla>();
		for(Tupla t : PDI.getPDISimple()) {
			boxProfesor.addItem(t);
		}
		boxProfesor.setBounds(348, 186, 543, 30);
		add(boxProfesor);
		
		JLabel lblProfesor = new JLabel("PDI al cargo:");
		lblProfesor.setBounds(234, 179, 117, 36);
		add(lblProfesor);
		lblProfesor.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		
		DefaultListModel<Tupla> actividades = new DefaultListModel<Tupla>();
		for(Tupla t : Actividad.getActividadesDisponiblesSimple()) {
			actividades.addElement(t);
		}
		JScrollPane scroll = new JScrollPane();
		JList<Tupla> list = new JList<Tupla>(actividades);
		list.setSelectionModel(new ToggleSelectionModel());
		list.setLayoutOrientation(JList.VERTICAL);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		scroll.setBounds(196, 287, 695, 251);

		scroll.setViewportView(list);
		add(scroll);
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
		
		JLabel lblActividades = new JLabel("A\u00F1ade actividades existentes a este proyecto:");
		lblActividades.setBounds(196, 238, 424, 39);
		add(lblActividades);
		lblActividades.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		
		JLabel info = new JLabel("\"\"");
		info.setVisible(false);
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		info.setBounds(196, 565, 693, 25);
		add(info);
		
		JButton btnPublicarProyecto = new JButton("Publicar proyecto");
		btnPublicarProyecto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					if(titulo.getText().isEmpty()) {
						info.setForeground(Color.RED);
						info.setText("Email y nombre son campos obligatorios");
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
		btnPublicarProyecto.setBounds(451, 600, 188, 44);
		add(btnPublicarProyecto);
		
		if(boxProfesor.getItemCount() <= 0) {
			boxProfesor.setEnabled(false);
			btnPublicarProyecto.setEnabled(false);
			info.setForeground(Color.RED);
			info.setText("No se puede crear un proyecto sin existir ningún PDI en el sistema");
			info.setVisible(true);
		}
	}
}
