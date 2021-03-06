package vista;

import javax.swing.JPanel;

import modelo.ONG;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import utilidades.JPictureBox;

public class PerfilONG extends JPanel {

	/**
	 * Create the panel.
	 */
	public PerfilONG(MenuPrincipal padre, ONG ong, boolean editar) {
		ImageIcon imgasm = new ImageIcon(PerfilUsuario2.class.getResource("/resources/_Logo AccionSocialMed png.png"));
		setBackground(Color.WHITE);
		setLayout(null);
		this.setSize(1100,715);
		//fondo.setVisible(false);
		
		JLabel lblCopyright = new JLabel("2019 AccionSocialMed\u00AE es una marca registrada de CoderZ. Reservados todos los derechos. Versi\u00F3n 2.1.29.15");
		lblCopyright.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCopyright.setBounds(10, 654, 620, 14);
		lblCopyright.setVisible(true);
		add(lblCopyright);

		//imagenASM1.repaint();
		
		JLabel lblxb = new JLabel("<html>&larr;<html>");
		lblxb.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion
				if(editar) {
					padre.cambiarONG(ong);
				}else {
					padre.volverAConsultarActividad();
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
	   
	    if(editar) {
			
			
	    	 JPanel panelEditarPerfil = new JPanel();
	 	    panelEditarPerfil.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
	 	    panelEditarPerfil.setBounds(450, 457, 200, 50);
	 	    panelEditarPerfil.setBackground(new Color(93,103,175));
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
	 	    		padre.cambiarAEditarONG(ong);
	 				//dispose();
	 				
	 	    	}
	 	    });
		    lblEditarPerfil.setFont(new Font("Tahoma", Font.BOLD, 14));
		    lblEditarPerfil.setBounds(0, 0, 200, 50);
		    panelEditarPerfil.add(lblEditarPerfil);
		    lblEditarPerfil.setForeground(Color.WHITE);
		    lblEditarPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		    lblEditarPerfil.setBackground(new Color(93,103,175));
	    }else {
	    	 JPanel panelEnviarMensaje = new JPanel();
			    panelEnviarMensaje.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			    panelEnviarMensaje.setBounds(135, 457, 140, 50);
			    panelEnviarMensaje.setBackground(new Color(93,103,175));
		 	    add(panelEnviarMensaje);
		 	   panelEnviarMensaje.setLayout(null);
		 	    
		 	    JLabel lblEnviarMensaje = new JLabel("Enviar mensaje");
		 	    lblEnviarMensaje.addMouseListener(new MouseAdapter() {
		 	    	@Override
		 	    	public void mousePressed(MouseEvent e) {
		 	    		
		 	    		Border bordeAbajo = new BevelBorder(1);
		 	    		
		 	    		panelEnviarMensaje.setBorder(bordeAbajo);
		 	    		
		 	    		System.out.println("Boton abajo");
		 	    		//panelEditarPerfil.setBorder(bordeArriba);
		 	    		
		 	    	}
		 	    	
		 	    	@Override
		 	    	public void mouseClicked(MouseEvent e) {
		 	    		Border bordeArriba = new BevelBorder(0);
		 	    		panelEnviarMensaje.setBorder(bordeArriba);
		 	    		//Cambiar a nuevo mensaje
		 	    		System.out.println("Entrando a nuevo mensaje");
		 	    		padre.cambiarNuevoMensaje(ong);
		 	    		
		 				//dispose();
		 				
		 	    	}
		 	    });
			    lblEnviarMensaje.setFont(new Font("Tahoma", Font.BOLD, 14));
			    lblEnviarMensaje.setBounds(0, 0, 140, 50);
			    panelEnviarMensaje.add(lblEnviarMensaje);
			    lblEnviarMensaje.setForeground(Color.WHITE);
			    lblEnviarMensaje.setHorizontalAlignment(SwingConstants.CENTER);
			    lblEnviarMensaje.setBackground(new Color(93,103,175));
	    }

	    
		   
	   
	    
	    //Aqui continua la flecha para volver atr�s --- Todo lo que tiene lblxb
	    

		
		JLabel lblNombreONG = new JLabel("");
		lblNombreONG.setForeground(Color.WHITE);
		lblNombreONG.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreONG.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 41));
		lblNombreONG.setBounds(180, 30, 733, 150);
		add(lblNombreONG);
		lblNombreONG.setText("<html>" + ong.getNombre() + "</html>");
		
		
		JPanel bordeDescripcion = new JPanel();
		bordeDescripcion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		bordeDescripcion.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Descripci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		bordeDescripcion.setBounds(399, 221, 562, 183);
		add(bordeDescripcion);
		bordeDescripcion.setLayout(null);
		
		JScrollPane panelDescripcion = new JScrollPane();
		panelDescripcion.setBounds(6, 16, 550, 161);
		bordeDescripcion.add(panelDescripcion);
		
		JTextArea textoDescripcion = new JTextArea();
		textoDescripcion.setOpaque(false);
		textoDescripcion.setEditable(false);
		//textoDescripcion.setVerticalAlignment(SwingConstants.TOP);
		textoDescripcion.setText( ong.getDescripcion());
		panelDescripcion.setViewportView(textoDescripcion);
		
		
		JLabel fotoONG = new JLabel("FOTO ONG");
		fotoONG.setOpaque(true);
		fotoONG.setHorizontalAlignment(SwingConstants.CENTER);
		fotoONG.setBounds(135, 221, 140, 183);
		add(fotoONG);
		fotoONG.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPictureBox imagenASM = new JPictureBox();
		imagenASM.setBounds(922, 30, 150, 150);
		imagenASM.setIcon(imgasm);
		add(imagenASM);
		imagenASM.repaint();
		
		/*
		 * JPictureBox imagenASM1 = new JPictureBox(); imagenASM1.setBounds(30, 30, 150,
		 * 150); imagenASM1.setIcon(imgasm); add(imagenASM1);
		 * imagenASM1.setVisible(false);
		 */
		
		JLabel fondo = new JLabel("");
		fondo.setFont(new Font("Tahoma", Font.BOLD, 11));
		fondo.setIcon(new ImageIcon(PerfilONG.class.getResource("/resources/fondo 2.png")));
		fondo.setBounds(0, 0, 1100, 715);
		add(fondo);
	}
}
