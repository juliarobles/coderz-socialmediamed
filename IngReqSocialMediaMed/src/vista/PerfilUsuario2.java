package vista;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import utilidades.JPictureBox;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class PerfilUsuario2 {

	private JFrame frmAccionsocialmedPerfil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilUsuario2 window = new PerfilUsuario2();
					window.frmAccionsocialmedPerfil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PerfilUsuario2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int width, height;
		width = 800;
		height = 500;
		ImageIcon imgus = new ImageIcon(PerfilUsuario2.class.getResource("/resources/user.png"));
		frmAccionsocialmedPerfil = new JFrame();
		frmAccionsocialmedPerfil.setIconImage(Toolkit.getDefaultToolkit().getImage(PerfilUsuario2.class.getResource("/resources/_Logo AccionSocialMed png.png")));
		frmAccionsocialmedPerfil.setTitle("AccionSocialMed - Perfil");
		frmAccionsocialmedPerfil.setResizable(false);
		frmAccionsocialmedPerfil.setBounds(100, 100, width, height);
		frmAccionsocialmedPerfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPictureBox user = new JPictureBox();
		user.setBounds(121, 52, 90, 85);
		user.setIcon(imgus);
		user.repaint();
		  frmAccionsocialmedPerfil.getContentPane().setLayout(null);
		  
		  JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		  lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  lblTelfono.setBounds(407, 109, 61, 14);
		  frmAccionsocialmedPerfil.getContentPane().add(lblTelfono);
		  
		  JLabel lblTitulacin = new JLabel("Titulaci\u00F3n:");
		  lblTitulacin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  lblTitulacin.setBounds(274, 82, 73, 14);
		  frmAccionsocialmedPerfil.getContentPane().add(lblTitulacin);
		  
		  JLabel lblDni = new JLabel("DNI:");
		  lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  lblDni.setBounds(274, 107, 61, 14);
		  frmAccionsocialmedPerfil.getContentPane().add(lblDni);
		  
		  JPanel panel = new JPanel();
		  panel.setBackground(Color.WHITE);
		  panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Disponibilidad", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		  panel.setBounds(274, 320, 250, 50);
		  frmAccionsocialmedPerfil.getContentPane().add(panel);
		  panel.setLayout(null);
		  
		  JLabel lblDisponibilidad = new JLabel("");
		  lblDisponibilidad.setBounds(6, 16, 90, 24);
		  panel.add(lblDisponibilidad);
		  lblDisponibilidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  
		  JPanel panel_1 = new JPanel();
		  panel_1.setBackground(Color.WHITE);
		  panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Zona de acci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		  panel_1.setBounds(274, 250, 250, 50);
		  frmAccionsocialmedPerfil.getContentPane().add(panel_1);
		  panel_1.setLayout(null);
		  
		  JLabel lblZonaDeAccin = new JLabel("");
		  lblZonaDeAccin.setBounds(6, 16, 127, 24);
		  panel_1.add(lblZonaDeAccin);
		  lblZonaDeAccin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  
		  JPanel panel_2 = new JPanel();
		  panel_2.setBackground(Color.WHITE);
		  panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tipo de oferta preferida", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		  panel_2.setBounds(274, 390, 250, 46);
		  frmAccionsocialmedPerfil.getContentPane().add(panel_2);
		  panel_2.setLayout(null);
		  
		  JLabel lblTipoDeOferta = new JLabel("");
		  lblTipoDeOferta.setBounds(6, 16, 153, 24);
		  panel_2.add(lblTipoDeOferta);
		  lblTipoDeOferta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  
		  JLabel lblNombre = new JLabel("Nombre:");
		  lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  lblNombre.setBounds(274, 62, 61, 14);
		  frmAccionsocialmedPerfil.getContentPane().add(lblNombre);
		  frmAccionsocialmedPerfil.getContentPane().add(user);
		    
		    JPanel panelEditarPerfil = new JPanel();
		    panelEditarPerfil.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		    panelEditarPerfil.setBounds(40, 340, 200, 50);
		    panelEditarPerfil.setBackground(new Color(51,204,204));
		    frmAccionsocialmedPerfil.getContentPane().add(panelEditarPerfil);
		    panelEditarPerfil.setLayout(null);
		    
		    JLabel lblEditarPerfil = new JLabel("Editar perfil");
		    lblEditarPerfil.setFont(new Font("Tahoma", Font.BOLD, 14));
		    lblEditarPerfil.setBounds(0, 0, 200, 50);
		    panelEditarPerfil.add(lblEditarPerfil);
		    lblEditarPerfil.setForeground(Color.WHITE);
		    lblEditarPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		    lblEditarPerfil.setBackground(new Color(51,204,204));
		    
		    JPanel panelDescripcion = new JPanel();
		    panelDescripcion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		    panelDescripcion.setBackground(Color.WHITE);
		    panelDescripcion.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Descripci\u00F3n personal", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		    panelDescripcion.setBounds(274, 130, 442, 100);
		    frmAccionsocialmedPerfil.getContentPane().add(panelDescripcion);
		    panelDescripcion.setLayout(null);
		    
		    JLabel label = new JLabel("");
		    label.setBounds(6, 16, 430, 93);
		    panelDescripcion.add(label);
		    label.setHorizontalAlignment(SwingConstants.LEFT);
		    label.setVerticalAlignment(SwingConstants.TOP);
		    label.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		  
		    
		  
		  
		  
		    JLabel lblNewLabel = new JLabel("");
		    lblNewLabel.setBounds(0, 0, 794, 471);
		    lblNewLabel.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		    lblNewLabel.setIcon(new
		    		  ImageIcon(PerfilUsuario2.class.getResource("/resources/Perfil usuario.png")))
		    		  ;
		    frmAccionsocialmedPerfil.getContentPane().add(lblNewLabel);
		 
		  
		
	}
}
