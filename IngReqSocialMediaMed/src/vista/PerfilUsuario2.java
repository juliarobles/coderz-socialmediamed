package vista;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import utilidades.JPictureBox;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modelo.Alumno;
import modelo.Asignatura;
import modelo.Disponibilidad;
import modelo.PDI;
import modelo.Tupla;
import modelo.Usuario;
import modelo.ZonaAccion;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JList;

public class PerfilUsuario2 extends JPanel{
	

	private JFrame frmAccionsocialmedPerfil;
	private Perfil padre;
	private Usuario UsuarioActivo;
	private JLabel Nombre, Titulo, Telefono, DNI, Descripcion, Oferta, Dispo, Zona;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilUsuario2 window = new PerfilUsuario2();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 * @param perfil 
	 */
	public PerfilUsuario2(Usuario usuario, Perfil perfil) {
		setBackground(Color.WHITE);
		UsuarioActivo = usuario;
		padre = perfil;
		System.out.println("He entrado por constructor con argumento");
		initialize();
	}
	/*
	public PerfilUsuario2() {
		System.out.println("He entrado por constructor sin argumento");
		UsuarioActivo = new Usuario(null);
		UsuarioActivo.setApellido1("Ruiz");
		UsuarioActivo.setApellido2("Aswani");
		UsuarioActivo.setNombre("Daniel");
		UsuarioActivo.setDescripcion("Mi nombre es Dani y esto es una prueba");
		UsuarioActivo.setDNI("123456A");
		UsuarioActivo.setTelf(952123456);
		UsuarioActivo.setDisponibilidad(Disponibilidad.Nunca);
		UsuarioActivo.setEtiquetas(Etiquetas.ancianos);
		UsuarioActivo.setZonaAccion(ZonaAccion.Internacional);
		initialize();
		
	}
	*/

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		DefaultListModel<String> lista = new DefaultListModel<String>();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Asignaturas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(522, 274, 250, 130);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scroll= new JScrollPane();
		scroll.setForeground(Color.BLACK);
		scroll.setBorder(null);
		scroll.setBounds(10, 15, 226, 102);
		panel_1.add(scroll);
		JList<String> asignaturas = new JList<String>(lista);
		asignaturas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asignaturas.setLayoutOrientation(JList.VERTICAL);
		scroll.setViewportView(asignaturas);
		
		if(UsuarioActivo.getClass() == Alumno.class) {
			panel_1.setBorder(new TitledBorder(null, "Asignaturas que estudia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			lista.addAll(Asignatura.getAsignaturasEstudia(UsuarioActivo.getEmail()));
		} else if (UsuarioActivo.getClass() == PDI.class) {
			panel_1.setBorder(new TitledBorder(null, "Asignaturas que imparte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			lista.addAll(Asignatura.getAsignaturasImparte(UsuarioActivo.getEmail()));
		} else {
			panel_1.setVisible(false);
		}
		
		JLabel lblCopyright = new JLabel("2019 AccionSocialMed\u00AE es una marca registrada de CoderZ. Reservados todos los derechos. Versi\u00F3n 2.1.29.15");
		lblCopyright.setBounds(10, 441, 683, 14);
		add(lblCopyright);
		int width, height;
		
		width = 800;
		height = 500;
		ImageIcon imgasm = new ImageIcon(PerfilUsuario2.class.getResource("/resources/_Logo AccionSocialMed png.png"));
		ImageIcon imgus = new ImageIcon(PerfilUsuario2.class.getResource("/resources/user.png"));
		//frmAccionsocialmedPerfil = new JFrame();
		//setIconImage(Toolkit.getDefaultToolkit().getImage(PerfilUsuario2.class.getResource("/resources/_Logo AccionSocialMed png.png")));
		// setTitle("AccionSocialMed - Perfil");
		 //setResizable(false);
		 setBounds(100, 100, width, height);
		 //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPictureBox user = new JPictureBox();
		user.setBounds(121, 65, 90, 85);
		user.setIcon(imgus);
		user.repaint();
		setLayout(null);
		 setLayout(null);
		  
		  JPictureBox asm = new JPictureBox();
		  asm.setBounds(682, 11, 60, 60);
		  asm.setIcon(imgasm);
		  add(asm);
		  asm.repaint();
		  
		
		
		  
		  JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		  lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  lblTelfono.setBounds(274, 53, 61, 14);
		  add(lblTelfono);
		  
		  JPanel panelDispo = new JPanel();
		  
		  panelDispo.setBackground(Color.WHITE);
		  panelDispo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Disponibilidad", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		  panelDispo.setBounds(262, 284, 250, 50);
		  add(panelDispo);
		  panelDispo.setLayout(null);
		  
		  JLabel lblDispo = new JLabel("");
		  lblDispo.setBounds(10, 16, 234, 24);
		  panelDispo.add(lblDispo);
		  lblDispo.setText(UsuarioActivo.getDisponibilidad().toString());
		  lblDispo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  
		  JPanel panelZonaDeAccion = new JPanel();
		  panelZonaDeAccion.setBackground(Color.WHITE);
		  panelZonaDeAccion.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Zona de acci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		  panelZonaDeAccion.setBounds(262, 214, 250, 50);
		  add(panelZonaDeAccion);
		  panelZonaDeAccion.setLayout(null);
		  
		  JLabel lblZonaDeAccion = new JLabel("");
		  lblZonaDeAccion.setBounds(10, 16, 234, 24);
		  panelZonaDeAccion.add(lblZonaDeAccion);
		  this.Zona = lblZonaDeAccion;
		  lblZonaDeAccion.setText(UsuarioActivo.getZonaAccion().toString());
		  lblZonaDeAccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  
		  JPanel panelOferta = new JPanel();
		  
		  panelOferta.setBackground(Color.WHITE);
		  panelOferta.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tipo de oferta preferida", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		  panelOferta.setBounds(262, 354, 250, 50);
		  add(panelOferta);
		  panelOferta.setLayout(null);
		  
		  JLabel lblTipoDeOferta = new JLabel("");
		  Oferta = lblTipoDeOferta;
		  lblTipoDeOferta.setText(UsuarioActivo.getEtiquetas().toString());
		  lblTipoDeOferta.setBounds(10, 16, 234, 24);
		  panelOferta.add(lblTipoDeOferta);
		  lblTipoDeOferta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  
		  JPanel panel = new JPanel();
		  panel.setLayout(null);
		  panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u00C1mbito preferido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		  panel.setBackground(Color.WHITE);
		  panel.setBounds(522, 214, 250, 50);
		  add(panel);
		  
		  JLabel ambito = new JLabel((String) null);
		  ambito.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  ambito.setBounds(10, 16, 234, 24);
		  ambito.setText(UsuarioActivo.getAmbito().toString());
		  panel.add(ambito);
		  
		  JLabel lblOferta = new JLabel("Nombre:");
		  lblOferta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  lblOferta.setBounds(274, 29, 61, 14);
		  add(lblOferta);
		  
		  JLabel lblNombreR = new JLabel("");
		  this.Nombre = lblNombreR;
		  lblNombreR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  lblNombreR.setBounds(345, 29, 383, 14);
		  lblNombreR.setText(UsuarioActivo.getNombre() + " " + UsuarioActivo.getApellido1()+ " " + UsuarioActivo.getApellido2());
		  add(lblNombreR);
		  JLabel lblTelefonoR = new JLabel("");
		  this.Telefono = lblTelefonoR;
		  lblTelefonoR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  lblTelefonoR.setBounds(343, 53, 150, 14);
		  lblTelefonoR.setText(String.valueOf(UsuarioActivo.getTelf()));
		  add(lblTelefonoR);
		 
		  add(user);
		    
		    JPanel panelEditarPerfil = new JPanel();
		    panelEditarPerfil.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		    panelEditarPerfil.setBounds(40, 340, 200, 50);
		    panelEditarPerfil.setBackground(new Color(51,204,204));
		    add(panelEditarPerfil);
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
		    		//Cambiar a editar perfil
		    		padre.cambiarAEditar();
					//dispose();
					
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
		    panelDescripcion.setBounds(262, 81, 442, 123);
		    add(panelDescripcion);
		    panelDescripcion.setLayout(null);
		   
		  
		    
		    JScrollPane sclDescripcion = new JScrollPane();
		    sclDescripcion.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		    sclDescripcion.setBounds(10, 14, 422, 98);
		    panelDescripcion.add(sclDescripcion);
		    
		     
		       JTextArea txtDescripcion = new JTextArea("");
		       txtDescripcion.setEditable(false);
		       txtDescripcion.setOpaque(true);
		       txtDescripcion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		       
		       txtDescripcion.setBackground(Color.WHITE);
		      
		       txtDescripcion.setBounds(383, 11, 0, 59);
		       txtDescripcion.setLineWrap(true);
		       txtDescripcion.setWrapStyleWord(true);
		       sclDescripcion.setViewportView(txtDescripcion);
		       sclDescripcion.setBackground(Color.white);
		       txtDescripcion.setText(this.UsuarioActivo.getDescripcion());
		      
		       
		    
		  
		  
		    JLabel lblFondo = new JLabel("");
		    lblFondo.setBounds(0, 0, 800, 500);
		    lblFondo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		    lblFondo.setIcon(new
		    		  ImageIcon(PerfilUsuario2.class.getResource("/resources/Perfil usuario.png")))
		    		  ;
		    add(lblFondo);
		    
		    
		 lblTelfono.setBackground(Color.red);
		  
		
	}

	public JFrame getFrmAccionsocialmedPerfil() {
		return frmAccionsocialmedPerfil;
	}

	public void setFrmAccionsocialmedPerfil(JFrame frmAccionsocialmedPerfil) {
		this.frmAccionsocialmedPerfil = frmAccionsocialmedPerfil;
	}

	public Usuario getUsuarioActivo() {
		return UsuarioActivo;
	}

	public void setUsuarioActivo(Usuario UsuarioActivo) {
		this.UsuarioActivo = UsuarioActivo;
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
