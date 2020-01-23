package vista;

import javax.swing.JPanel;

import modelo.todosUsuarios;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AdapterChat extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdapterChat(String correo) {
		setLayout(null);
		this.setSize(320, 80);
		JLabel lblCorreo = new JLabel("");
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setBounds(47, 11, 226, 14);
		add(lblCorreo);
		lblCorreo.setText(correo);
	}
}
