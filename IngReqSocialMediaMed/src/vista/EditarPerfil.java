package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modelo.Disponibilidad;
import modelo.Etiquetas;
import modelo.Usuario;
import modelo.ZonaAccion;

import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;

public class EditarPerfil extends JFrame{
	
	private Usuario UsuarioActivo;
	private JFrame frameEditarPerfil;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { EditarPerfil window = new
	 * EditarPerfil(); window.frameEditarPerfil.setVisible(true); } catch (Exception
	 * e) { e.printStackTrace(); } } }); }
	 * 
	 */
	/**
	 * Create the application.
	 */
	public EditarPerfil(Usuario usuario) {
		UsuarioActivo = usuario;
		getContentPane().setBackground(Color.WHITE);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// EditarPerfil window = new EditarPerfil();
		System.out.println("EditarPerfil");
		int width = 800;
		int height = 500;
		//frameEditarPerfil.setVisible(true);
		//frameEditarPerfil = new JFrame();
		setTitle("AccionSocialMed - Editar perfil");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditarPerfil.class.getResource("/resources/_Logo AccionSocialMed png.png")));
		setResizable(false);
		setBounds(100, 100, width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n personal:");
		lblDescripcion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblDescripcion.setBounds(46, 76, 134, 20);
		getContentPane().add(lblDescripcion);
		
		JLabel lblEditarPerfil = new JLabel("Editar perfil");
		lblEditarPerfil.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 29));
		lblEditarPerfil.setBounds(316, 11, 162, 47);
		getContentPane().add(lblEditarPerfil);
		
		JPanel panelBorde = new JPanel();
		panelBorde.setBackground(Color.WHITE);
		panelBorde.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelBorde.setBounds(185, 76, 564, 136);
		getContentPane().add(panelBorde);
		panelBorde.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setText(UsuarioActivo.getDescripcion());
		textPane.setBounds(10, 11, 548, 114);
		panelBorde.add(textPane);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblTelefono.setBounds(118, 250, 62, 20);
		getContentPane().add(lblTelefono);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(Color.WHITE);
		panel.setBounds(185, 239, 162, 41);
		getContentPane().add(panel);
		
		JTextPane rellenarTelefono = new JTextPane();
		rellenarTelefono.setText(String.valueOf(UsuarioActivo.getTelf()));
		rellenarTelefono.setBounds(10, 11, 142, 20);
		panel.add(rellenarTelefono);
		
		JLabel lblZona = new JLabel("Zona de acci\u00F3n:");
		lblZona.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblZona.setBounds(75, 301, 106, 20);
		getContentPane().add(lblZona);
		
		int index;
		JComboBox<ZonaAccion> boxZona = new JComboBox<ZonaAccion>();
		for(int cont = 0;ZonaAccion.values().length>cont; cont++) {
			boxZona.addItem(ZonaAccion.values()[cont]);
			if(ZonaAccion.values()[cont] == UsuarioActivo.getZonaAccion()) {
				index = cont;
			}
		}
		//boxZona.setSelectedIndex(index);
		boxZona.setBackground(Color.WHITE);
		boxZona.setBounds(185, 300, 162, 22);
		getContentPane().add(boxZona);
		
		JComboBox <Disponibilidad>boxDispo = new JComboBox<Disponibilidad>();
		
		for(int cont = 0;Disponibilidad.values().length>cont; cont++) {
			boxDispo.addItem(Disponibilidad.values()[cont]);
		}
		boxDispo.setBackground(Color.WHITE);
		boxDispo.setBounds(185, 332, 162, 22);
		getContentPane().add(boxDispo);
		
		JLabel lblDisponibilidad = new JLabel("Disponibilidad:");
		lblDisponibilidad.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblDisponibilidad.setBounds(75, 333, 106, 20);
		getContentPane().add(lblDisponibilidad);
		
		JComboBox <Etiquetas> boxOferta = new JComboBox<Etiquetas>();
		for(int cont = 0;Etiquetas.values().length>cont; cont++) {
			boxOferta.addItem(Etiquetas.values()[cont]);
		}
		boxOferta.setBackground(Color.WHITE);
		boxOferta.setBounds(185, 365, 162, 22);
		getContentPane().add(boxOferta);
		
		JLabel lblOfertaPreferida = new JLabel("Oferta preferida:");
		lblOfertaPreferida.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblOfertaPreferida.setBounds(75, 366, 106, 20);
		getContentPane().add(lblOfertaPreferida);
	}
}
