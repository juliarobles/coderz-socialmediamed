package vista;

import java.awt.Dimension;

import javax.swing.JPanel;

import modelo.Mensaje;
import modelo.Tupla;
import modelo.todosUsuarios;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class Chat extends JFrame
{

	/**
	 * Create the panel.
	 */
	public Chat(todosUsuarios usu) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Chat.class.getResource("/resources/chat.png")));
		setTitle("Chat");
		setSize(new Dimension(1100, 715));
		getContentPane().setLayout(null);
		
		JScrollPane paneConversaciones = new JScrollPane();
		paneConversaciones.setBounds(35, 73, 320, 631);
		getContentPane().add(paneConversaciones);
		
		
		//Crea el adaptador
		
		JList<AdapterChat> listaConversaciones = new JList<AdapterChat>();
		paneConversaciones.setViewportView(listaConversaciones);
		
		List<Tupla> l = Mensaje.getChat(usu.getEmail());
		for (Tupla t: l){
			listaConversaciones.add(new AdapterChat(t.elemento1));
			System.out.println("Añadida conversación nueva");
		}
		
		
		JLabel lblConversaciones = new JLabel("Conversaciones");
		lblConversaciones.setBounds(117, 33, 160, 29);
		lblConversaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversaciones.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 23));
		getContentPane().add(lblConversaciones);
		
		JScrollPane AreaConversacion = new JScrollPane();
		AreaConversacion.setBounds(417, 73, 638, 631);
		getContentPane().add(AreaConversacion);
		
		JTextArea textConversacion = new JTextArea();
		AreaConversacion.setViewportView(textConversacion);
		
		JLabel lblNewLabel = new JLabel("Conversaci\u00F3n");
		lblNewLabel.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 23));
		lblNewLabel.setBounds(625, 33, 181, 29);
		getContentPane().add(lblNewLabel);
		
	}
}
