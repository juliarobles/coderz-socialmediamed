package vista;

import javax.swing.JPanel;

import modelo.todosUsuarios;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AdapterChat extends JPanel {
		private String receptor;
	/**
	 * Create the panel.
	 */
	public AdapterChat(String correo) {
		this.receptor = correo;
		setLayout(null);
		this.setSize(316, 80);
		JLabel lblCorreo = new JLabel("");
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setBounds(47, 11, 226, 20);
		add(lblCorreo);
		lblCorreo.setText(correo);
	}
	public String getReceptor() {
		return receptor;
	}
}
