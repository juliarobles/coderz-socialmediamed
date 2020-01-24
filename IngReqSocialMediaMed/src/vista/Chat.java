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

import controlador.CtrChat;

import javax.swing.JList;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Chat extends JFrame
{
	private CtrChat control;
	private JTextField lblMensaje;
	private JPanel panelConv;
	private JTextArea conversacion;
	private JButton enviar;
	public JTextField getLblMensaje() {
		return lblMensaje;
	}
	public void setLblMensaje(JTextField lblMensaje) {
		this.lblMensaje = lblMensaje;
	}
	public JPanel getPanelConv() {
		return panelConv;
	}
	public void setPanelConv(JPanel panelConv) {
		this.panelConv = panelConv;
	}
	/**
	 * Create the panel.
	 */
	public Chat(todosUsuarios usu) {
		control = new CtrChat(this, usu);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Chat.class.getResource("/resources/chat.png")));
		setTitle("Chat");
		setSize(new Dimension(1100, 715));
		getContentPane().setLayout(null);
		
		JScrollPane paneConversaciones = new JScrollPane();
		paneConversaciones.setBounds(35, 73, 320, 539);
		getContentPane().add(paneConversaciones);
		paneConversaciones.setBorder(null);
		paneConversaciones.setLayout(null);
		
		
		//Crea el adaptador
		
		/*
		 * JList<AdapterChat> listaConversaciones = new JList<AdapterChat>();
		 * paneConversaciones.setViewportView(listaConversaciones);
		 */
		
		List<Tupla> l = Mensaje.getChat(usu.getEmail());
		int x = 0;
		for (Tupla t: l){
			JPanel conv = new AdapterChat(t.elemento1);
			paneConversaciones.add(conv);
			conv.setVisible(true);
			conv.setLocation(2, x);
			conv.addMouseListener(control);
			x+=30;
			System.out.println("Añadida conversación nueva");
		}
		//paneConversaciones.
		
		JLabel lblConversaciones = new JLabel("Conversaciones");
		lblConversaciones.setBounds(117, 33, 160, 29);
		lblConversaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversaciones.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 23));
		getContentPane().add(lblConversaciones);
		
		JScrollPane AreaConversacion = new JScrollPane();
		AreaConversacion.setBounds(417, 73, 638, 539);
		getContentPane().add(AreaConversacion);
		
		JTextArea textConversacion = new JTextArea();
		textConversacion.setEditable(false);
		AreaConversacion.setViewportView(textConversacion);
		//textConversacion.setText("Hola Hola");											///Borrar despues de las comprobaciones
		
		JLabel lblConversacion = new JLabel("Conversaci\u00F3n");
		lblConversacion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 23));
		lblConversacion.setBounds(625, 33, 181, 29);
		getContentPane().add(lblConversacion);
		
		lblMensaje = new JTextField();
		lblMensaje.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblMensaje.setBounds(417, 623, 552, 29);
		getContentPane().add(lblMensaje);
		lblMensaje.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setEnabled(false);
		btnEnviar.setBounds(985, 623, 70, 29);
		getContentPane().add(btnEnviar);
		enviar = btnEnviar;
		textConversacion.setLineWrap(true);
		conversacion = textConversacion;
		btnEnviar.addMouseListener(control);
	}
	public JButton getEnviar() {
		return enviar;
	}
	public void setEnviar(JButton enviar) {
		this.enviar = enviar;
	}
	public JTextArea getConversacion() {
		return conversacion;
	}
	public void setConversacion(JTextArea conversacion) {
		this.conversacion = conversacion;
	}
}
