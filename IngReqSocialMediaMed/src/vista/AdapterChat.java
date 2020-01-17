package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class AdapterChat extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdapterChat() {
		setLayout(null);
		
		JLabel lblNombre = new JLabel("");
		lblNombre.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		lblNombre.setBounds(135, 11, 46, 14);
		add(lblNombre);
		
		lblNombre.getPreferredSize();
	}

}
