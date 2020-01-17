package vista;

import java.awt.Dimension;

import javax.swing.JPanel;

import modelo.Mensaje;
import modelo.Tupla;
import modelo.todosUsuarios;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JTextArea;

public class Chat extends JPanel {

	/**
	 * Create the panel.
	 */
	public Chat(todosUsuarios usu) {
		setSize(new Dimension(1100, 715));
		setLayout(null);
		
		JScrollPane paneConversaciones = new JScrollPane();
		paneConversaciones.setBounds(35, 73, 320, 631);
		add(paneConversaciones);
		
		DefaultListModel<Tupla> conversaciones = new DefaultListModel<Tupla>();
		conversaciones.addAll(Mensaje.getChat(usu.getEmail()));
		JList listaConversaciones = new JList(conversaciones);
		paneConversaciones.setViewportView(listaConversaciones);
		
		JLabel lblConversaciones = new JLabel("Conversaciones");
		lblConversaciones.setBounds(117, 33, 160, 29);
		lblConversaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversaciones.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 23));
		add(lblConversaciones);
		
		JScrollPane AreaConversacion = new JScrollPane();
		AreaConversacion.setBounds(417, 73, 638, 631);
		add(AreaConversacion);
		
		JTextArea textConversacion = new JTextArea();
		AreaConversacion.setViewportView(textConversacion);
		
		JLabel lblNewLabel = new JLabel("Conversaci\u00F3n");
		lblNewLabel.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 23));
		lblNewLabel.setBounds(625, 33, 181, 29);
		add(lblNewLabel);
		
	}
}
