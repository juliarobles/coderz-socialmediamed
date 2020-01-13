package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modelo.Actividad;
import modelo.ONG;
import modelo.PDI;
import modelo.Proyecto;
import modelo.Solicitud;
import modelo.Tupla;
import modelo.Usuario;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class GestionSolicitudes extends JPanel {

	private DefaultListModel<Tupla> actividades;
	private JTable table;


	public GestionSolicitudes(MenuPrincipal padre, Usuario usu) { 

		setBackground(Color.WHITE);
		setBounds(100, 100, 1321, 715);
		setSize(1100, 715);
		setLayout(null);
		
		JLabel lblxb = new JLabel("<html>&larr;<html>");
		lblxb.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion
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
		
		JLabel lblCreacionProy = new JLabel("Mis solicitudes");
		lblCreacionProy.setBounds(0, 21, 1100, 39);
		lblCreacionProy.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 29));
		lblCreacionProy.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCreacionProy);
		
		JLabel lblCopyright = new JLabel("2019 AccionSocialMed\u00AE es una marca registrada de CoderZ. Reservados todos los derechos. Versi\u00F3n 2.1.29.15");
		lblCopyright.setBounds(10, 650, 671, 14);
		add(lblCopyright);
		
		actividades = new DefaultListModel<Tupla>();
		
		DefaultTableModel model = new DefaultTableModel(
				Solicitud.getTodasSolicitudesParticipante(usu.getEmail()),
				new String[] {
					"Nombre de la actividad", "ONG", "Fecha inicio", "Fecha final", "Estado", "id Actividad"
				}
			);
		
		table = new JTable();
		table.setModel(model);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.getColumnModel().getColumn(5).setMaxWidth(0);
		table.getColumnModel().getColumn(5).setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
		table.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		JScrollPane sc = new JScrollPane(table);
		sc.setBounds(91, 107, 910, 432);
		add(sc);
		
		JLabel info = new JLabel("Selecciona una solicitud");
		info.setVisible(false);
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		info.setBounds(91, 540, 910, 31);
		add(info);
		
		JButton eliminar = new JButton("Eliminar solicitud");
		eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int index = table.getSelectedRow();
				int idAct;
				if(index != -1) {
					idAct = (int)table.getValueAt(index, 5);
					Solicitud.borrarSolicitud(usu.getEmail(), idAct);
					model.removeRow(index);
					info.setText("La solicitud se ha eliminado correctamente");
					info.setForeground(Color.RED);
				} else {
					info.setText("Selecciona una solicitud");
					info.setForeground(Color.RED);
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
		eliminar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		eliminar.setBackground(new Color(51, 204, 204));
		eliminar.setBounds(430, 573, 234, 36);
		add(eliminar);
		
		
		
	}
}
