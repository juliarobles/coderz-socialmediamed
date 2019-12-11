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
	public PerfilONG(MenuPrincipal padre, ONG ong) {
		ImageIcon imgasm = new ImageIcon(PerfilUsuario2.class.getResource("/resources/_Logo AccionSocialMed png.png"));
		setBackground(Color.WHITE);
		setLayout(null);
		this.setSize(1100,715);
		//fondo.setVisible(false);
		
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
		//imagenASM1.repaint();
		
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
		lblxb.setForeground(Color.BLACK);
		lblxb.setBounds(40, 10, 52, 51);
		lblxb.setFont(new Font("Tahoma", Font.PLAIN, 46));
		add(lblxb);
		
		JLabel lblNombreONG = new JLabel("");
		lblNombreONG.setForeground(Color.WHITE);
		lblNombreONG.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreONG.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 41));
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
		
		JLabel textoDescripcion = new JLabel();
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
		fondo.setIcon(new ImageIcon(PerfilONG.class.getResource("/resources/fondo 2.png")));
		fondo.setBounds(0, 0, 1100, 715);
		add(fondo);
	}
}
