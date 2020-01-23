package vista;

import javax.swing.JPanel;

import modelo.todosUsuarios;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controlador.CtrNuevoMensaje;

import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NuevoMensaje extends JFrame {
	private CtrNuevoMensaje control;
	private JButton EnviarMensaje;
	private JTextArea mensaje;
	
	public JTextArea getMensaje() {
		return this.mensaje;
	}
	
	public JButton getEnviarMensaje() {
		return this.EnviarMensaje;
	}
	/**
	 * Create the panel.
	 */
	public NuevoMensaje(MenuPrincipal padre, todosUsuarios emisor, todosUsuarios receptor) {
		control = new CtrNuevoMensaje(padre, this, emisor, receptor);
		setIconImage(Toolkit.getDefaultToolkit().getImage(NuevoMensaje.class.getResource("/resources/chat.png")));
		setTitle("Nuevo mensaje");
		this.setBounds(0, 0, 600, 400);
		getContentPane().setLayout(null);
		
		System.out.println("He entrado a nuevo mensaje");
		JLabel lblNuevoMensaje = new JLabel("Nuevo mensaje");
		lblNuevoMensaje.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 31));
		lblNuevoMensaje.setBounds(187, 11, 210, 53);
		getContentPane().add(lblNuevoMensaje);
		
		JLabel lblReceptor = new JLabel("Receptor: " + receptor.getEmail());
		lblReceptor.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblReceptor.setBounds(42, 67, 131, 20);
		getContentPane().add(lblReceptor);
		
		JScrollPane panelMensaje = new JScrollPane();
		panelMensaje.setBounds(40, 98, 500, 150);
		getContentPane().add(panelMensaje);
		
		JTextArea textoMensaje = new JTextArea();
		panelMensaje.setViewportView(textoMensaje);
		lblReceptor.setSize(lblReceptor.getPreferredSize());
		textoMensaje.setLineWrap(true);
		
		JButton btnEnviar = new JButton("Enviar mensaje");
		this.EnviarMensaje = btnEnviar;
		btnEnviar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		btnEnviar.setBounds(217, 288, 149, 34);
		getContentPane().add(btnEnviar);
		
		mensaje= textoMensaje;
		EnviarMensaje.addMouseListener(control);
	}
}
