package vista;

import javax.swing.JPanel;

import modelo.todosUsuarios;

import javax.swing.JLabel;
import java.awt.Font;

public class AdapterChat extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdapterChat(String correo) {
		setLayout(null);
		
		JLabel lblCorreo = new JLabel("");
		lblCorreo.setBounds(47, 11, 226, 14);
		add(lblCorreo);
		lblCorreo.setText(correo);
	}
}
