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

import modelo.Usuario;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PerfilUsuario2 {

	private JFrame frmAccionsocialmedPerfil;
	private Usuario usuarioActivo;
	private JLabel Nombre, Titulo, Telefono, DNI, Descripcion, Oferta, Disponibilidad, Zona;

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
		  Telefono = lblTelfono;
		  lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  lblTelfono.setBounds(407, 109, 61, 14);
		  frmAccionsocialmedPerfil.getContentPane().add(lblTelfono);
		  
		  JLabel lblTitulacion = new JLabel("Titulaci\u00F3n:");
		  Titulo = lblTitulacion;
		  lblTitulacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  lblTitulacion.setBounds(274, 82, 73, 14);
		  frmAccionsocialmedPerfil.getContentPane().add(lblTitulacion);
		  
		  JLabel lblDni = new JLabel("DNI:");
		  DNI = lblDni;
		  lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  lblDni.setBounds(274, 107, 61, 14);
		  frmAccionsocialmedPerfil.getContentPane().add(lblDni);
		  
		  JPanel panelDisponibilidad = new JPanel();
		  
		  panelDisponibilidad.setBackground(Color.WHITE);
		  panelDisponibilidad.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Disponibilidad", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		  panelDisponibilidad.setBounds(274, 320, 250, 50);
		  frmAccionsocialmedPerfil.getContentPane().add(panelDisponibilidad);
		  panelDisponibilidad.setLayout(null);
		  
		  JLabel lblDisponibilidad = new JLabel("");
		  lblDisponibilidad.setBounds(6, 16, 90, 24);
		  panelDisponibilidad.add(lblDisponibilidad);
		  lblDisponibilidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  
		  JPanel panelZonaDeAccion = new JPanel();
		  panelZonaDeAccion.setBackground(Color.WHITE);
		  panelZonaDeAccion.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Zona de acci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		  panelZonaDeAccion.setBounds(274, 250, 250, 50);
		  frmAccionsocialmedPerfil.getContentPane().add(panelZonaDeAccion);
		  panelZonaDeAccion.setLayout(null);
		  
		  JLabel lblZonaDeAccin = new JLabel("");
		  Zona = lblZonaDeAccin;
		  lblZonaDeAccin.setBounds(6, 16, 127, 24);
		  panelZonaDeAccion.add(lblZonaDeAccin);
		  lblZonaDeAccin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  
		  JPanel panelOferta = new JPanel();
		  
		  panelOferta.setBackground(Color.WHITE);
		  panelOferta.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tipo de oferta preferida", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		  panelOferta.setBounds(274, 390, 250, 46);
		  frmAccionsocialmedPerfil.getContentPane().add(panelOferta);
		  panelOferta.setLayout(null);
		  
		  JLabel lblTipoDeOferta = new JLabel("");
		  Oferta = lblTipoDeOferta;
		  lblTipoDeOferta.setBounds(6, 16, 153, 24);
		  panelOferta.add(lblTipoDeOferta);
		  lblTipoDeOferta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  
		  JLabel lblOferta = new JLabel("Nombre:");
		  lblOferta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  lblOferta.setBounds(274, 57, 61, 14);
		  frmAccionsocialmedPerfil.getContentPane().add(lblOferta);
		  frmAccionsocialmedPerfil.getContentPane().add(user);
		    
		    JPanel panelEditarPerfil = new JPanel();
		    panelEditarPerfil.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		    panelEditarPerfil.setBounds(40, 340, 200, 50);
		    panelEditarPerfil.setBackground(new Color(51,204,204));
		    frmAccionsocialmedPerfil.getContentPane().add(panelEditarPerfil);
		    panelEditarPerfil.setLayout(null);
		    
		    JLabel lblEditarPerfil = new JLabel("Editar perfil");
		    lblEditarPerfil.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mousePressed(MouseEvent e) {
		    		
		    		Border bordeAbajo = new BevelBorder(1);
		    		
		    		panelEditarPerfil.setBorder(bordeAbajo);
		    		
		    		
		    		//panelEditarPerfil.setBorder(bordeArriba);
		    		
		    	}
		    	
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		Border bordeArriba = new BevelBorder(0);
		    		panelEditarPerfil.setBorder(bordeArriba);
		    	}
		    });
		     
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
		  
		    
		  
		  
		  
		    JLabel lblFondo = new JLabel("");
		    lblFondo.setBounds(0, 0, 794, 471);
		    lblFondo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		    lblFondo.setIcon(new
		    		  ImageIcon(PerfilUsuario2.class.getResource("/resources/Perfil usuario.png")))
		    		  ;
		    frmAccionsocialmedPerfil.getContentPane().add(lblFondo);
		 
		  
		
	}

	public JFrame getFrmAccionsocialmedPerfil() {
		return frmAccionsocialmedPerfil;
	}

	public void setFrmAccionsocialmedPerfil(JFrame frmAccionsocialmedPerfil) {
		this.frmAccionsocialmedPerfil = frmAccionsocialmedPerfil;
	}

	public Usuario getUsuarioActivo() {
		return usuarioActivo;
	}

	public void setUsuarioActivo(Usuario usuarioActivo) {
		this.usuarioActivo = usuarioActivo;
	}
	public void esperar(int tiempo) {
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
  
	}
}
