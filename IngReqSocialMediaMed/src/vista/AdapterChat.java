package vista;

import javax.swing.JPanel;

import modelo.todosUsuarios;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class AdapterChat extends JPanel {
		private String receptor;
	/**
	 * Create the panel.
	 */
	public AdapterChat(String correo) {
		this.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		this.receptor = correo;
		setLayout(null);
		this.setSize(316, 30);
		JLabel lblCorreo = new JLabel("");
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setBounds(47, 5, 226, 20);
		add(lblCorreo);
		lblCorreo.setText(correo);
		this.addMouseListener(new MouseAdapter() {
 	    	@Override
 	    	public void mousePressed(MouseEvent e) {
 	    		
 	    		Border bordeAbajo = new BevelBorder(1);
 	    		
 	    		setBorder(bordeAbajo);
 	    		
 	    		
 	    		//panelEditarPerfil.setBorder(bordeArriba);
 	    		
 	    	}
 	    	
 	    	@Override
 	    	public void mouseClicked(MouseEvent e) {
 	    		Border bordeArriba = new BevelBorder(0);
 	    		setBorder(bordeArriba);
 	    	}
 	    });
	}
	public String getReceptor() {
		return receptor;
	}
}
