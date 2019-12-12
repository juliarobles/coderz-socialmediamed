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
import modelo.TipoOferta;
import modelo.Usuario;
import modelo.ZonaAccion;

import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditarPerfil extends JPanel{
	
	private Usuario UsuarioActivo;
	private JFrame frameEditarPerfil;
	private Perfil padre;

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
	 * @param perfil 
	 */
	public EditarPerfil(Usuario usuario, Perfil perfil) {
		UsuarioActivo = usuario;
		padre = perfil;
		//getContentPane().setBackground(Color.WHITE);
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
		//setTitle("AccionSocialMed - Editar perfil");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(EditarPerfil.class.getResource("/resources/_Logo AccionSocialMed png.png")));
		//setResizable(false);
		setBounds(100, 100, width, height);
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n personal:");
		lblDescripcion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblDescripcion.setBounds(46, 76, 134, 20);
		add(lblDescripcion);
		
		JLabel lblCopyright = new JLabel("2019 AccionSocialMed\u00AE es una marca registrada de CoderZ. Reservados todos los derechos. Versi\u00F3n 2.1.29.15");
		lblCopyright.setBounds(10, 460, 537, 14);
		add(lblCopyright);
		
		JLabel lblEditarPerfil = new JLabel("Editar perfil");
		lblEditarPerfil.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 29));
		lblEditarPerfil.setBounds(316, 11, 162, 47);
		add(lblEditarPerfil);
		
		JPanel panelBorde = new JPanel();
		panelBorde.setBackground(Color.WHITE);
		panelBorde.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelBorde.setBounds(185, 76, 564, 136);
		add(panelBorde);
		panelBorde.setLayout(null);
		
		JTextPane textoDescripcion = new JTextPane();
		textoDescripcion.setBounds(10, 10, 548, 114);
		panelBorde.add(textoDescripcion);
		textoDescripcion.setText(UsuarioActivo.getDescripcion());
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblTelefono.setBounds(118, 250, 62, 20);
		add(lblTelefono);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(Color.WHITE);
		panel.setBounds(185, 239, 162, 41);
		add(panel);
		
		JTextPane rellenarTelefono = new JTextPane();
		rellenarTelefono.setText(String.valueOf(UsuarioActivo.getTelf()));
		rellenarTelefono.setBounds(10, 11, 142, 20);
		panel.add(rellenarTelefono);
		
		JLabel lblZona = new JLabel("Zona de acci\u00F3n:");
		lblZona.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblZona.setBounds(75, 301, 106, 20);
		add(lblZona);
		
		int index=0;
		JComboBox<ZonaAccion> boxZona = new JComboBox<ZonaAccion>();
		for(int cont = 0;ZonaAccion.values().length>cont; cont++) {
			boxZona.addItem(ZonaAccion.values()[cont]);
			if(ZonaAccion.values()[cont] == UsuarioActivo.getZonaAccion()) {
				index = cont;
			}
		}
		boxZona.setSelectedIndex(index);
		boxZona.setBackground(Color.WHITE);
		boxZona.setBounds(185, 300, 162, 22);
		add(boxZona);
		
		JComboBox <Disponibilidad>boxDispo = new JComboBox<Disponibilidad>();
		
		for(int cont = 0;Disponibilidad.values().length>cont; cont++) {
			boxDispo.addItem(Disponibilidad.values()[cont]);
			if(Disponibilidad.values()[cont] == UsuarioActivo.getDisponibilidad()) {
				index = cont;
			}
		}
		boxDispo.setSelectedIndex(index);
		boxDispo.setBackground(Color.WHITE);
		boxDispo.setBounds(185, 332, 162, 22);
		add(boxDispo);
		
		JLabel lblDisponibilidad = new JLabel("Disponibilidad:");
		lblDisponibilidad.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblDisponibilidad.setBounds(75, 333, 106, 20);
		add(lblDisponibilidad);
		
		JComboBox <TipoOferta> boxOferta = new JComboBox<TipoOferta>();
		for(int cont = 0;TipoOferta.values().length>cont; cont++) {
			boxOferta.addItem(TipoOferta.values()[cont]);
			if(TipoOferta.values()[cont] == UsuarioActivo.getEtiquetas()) {
				index = cont;
			}
		}
		boxOferta.setSelectedIndex(index);
		boxOferta.setBackground(Color.WHITE);
		boxOferta.setBounds(185, 365, 162, 22);
		add(boxOferta);
		
		JLabel lblOfertaPreferida = new JLabel("Oferta preferida:");
		lblOfertaPreferida.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblOfertaPreferida.setBounds(75, 366, 106, 20);
		add(lblOfertaPreferida);
		
		JPanel panelGuardarCambios = new JPanel();
		panelGuardarCambios.setLayout(null);
		panelGuardarCambios.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelGuardarCambios.setBackground(new Color(51, 204, 204));
		panelGuardarCambios.setBounds(185, 398, 200, 50);
		add(panelGuardarCambios);
		
		JLabel lblGuardarCambios = new JLabel("Guardar cambios");
		lblGuardarCambios.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

	    		Border bordeAbajo = new BevelBorder(1);
	    		
	    		panelGuardarCambios.setBorder(bordeAbajo);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Border bordeArriba = new BevelBorder(0);
	    		panelGuardarCambios.setBorder(bordeArriba);
	    		
	    		//UsuarioActivo.setTelf(Integer.parseInt(rellenarTelefono.getText()));
	    		UsuarioActivo.setDisponibilidad((Disponibilidad)boxDispo.getSelectedItem());
	    		UsuarioActivo.setZonaAccion((ZonaAccion)boxZona.getSelectedItem());
	    		UsuarioActivo.setTipoOferta((TipoOferta)boxOferta.getSelectedItem());
	    		UsuarioActivo.setDescripcion(textoDescripcion.getText());
	    		//Cambiar a perfil
	    		//PerfilUsuario2 frame = new PerfilUsuario2(UsuarioActivo);
				//frame.setVisible(true);
				//dispose();
	    		padre.cambiarAVer();
				
			}
		});
		lblGuardarCambios.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardarCambios.setForeground(Color.WHITE);
		lblGuardarCambios.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGuardarCambios.setBackground(new Color(51, 204, 204));
		lblGuardarCambios.setBounds(0, 0, 200, 50);
		panelGuardarCambios.add(lblGuardarCambios);
		
		JPanel panelSalir = new JPanel();
		panelSalir.setLayout(null);
		panelSalir.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelSalir.setBackground(new Color(51, 204, 204));
		panelSalir.setBounds(412, 398, 200, 50);
		add(panelSalir);
		
		JLabel salirSinGuardar = new JLabel("Salir sin guardar");
		salirSinGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Border bordeArriba = new BevelBorder(0);
	    		panelSalir.setBorder(bordeArriba);
	    		padre.cambiarAVer();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Border bordeAbajo = new BevelBorder(1);
	    		panelSalir.setBorder(bordeAbajo);
	    		
			}
		});
		salirSinGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		salirSinGuardar.setForeground(Color.WHITE);
		salirSinGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		salirSinGuardar.setBackground(new Color(51, 204, 204));
		salirSinGuardar.setBounds(0, 0, 200, 50);
		panelSalir.add(salirSinGuardar);
		
		JLabel label = new JLabel("");
		label.setBounds(383, 239, 120, 147);
		add(label);
	}
}
