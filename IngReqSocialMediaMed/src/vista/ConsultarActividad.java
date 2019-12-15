package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modelo.Actividad;
import modelo.Solicitud;
import modelo.Usuario;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class ConsultarActividad extends JPanel {
		
	/**
	 * Create the panel.
	 */
	public ConsultarActividad(MenuPrincipal padre, Usuario usu, Actividad act) {
		this.setSize(1100, 715);
		setLayout(null);
		
		JPanel panelApuntarse = new JPanel();
		panelApuntarse.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelApuntarse.setBounds(87, 568, 212, 50);
		panelApuntarse.setBackground(new Color(17,92,161));
		add(panelApuntarse);
		panelApuntarse.setLayout(null);
		
		JLabel lblApuntarse = new JLabel("Apuntarse");
		
		
	
		lblApuntarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				Border bordeAbajo = new BevelBorder(1);
				
				panelApuntarse.setBorder(bordeAbajo);
				
				
				//panelEditarPerfil.setBorder(bordeArriba);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Border bordeArriba = new BevelBorder(0);
				panelApuntarse.setBorder(bordeArriba);
				//Cambiar a editar perfil
				//padre.cambiarAEditarONG(ong);
				//dispose();
				int vol = 0;
				if(!act.esVoluntariado()) {
					vol =1;
				}
				new Solicitud(usu, act, vol,0);
			}
		});
		
		lblApuntarse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApuntarse.setBounds(0, 0, 212, 50);
		panelApuntarse.add(lblApuntarse);
		lblApuntarse.setForeground(Color.WHITE);
		lblApuntarse.setHorizontalAlignment(SwingConstants.CENTER);
		lblApuntarse.setBackground(new Color(93,103,175));
		
		
		
		JLabel lblTituloActividad = new JLabel("");
		lblTituloActividad.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 32));
		lblTituloActividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloActividad.setBounds(94, 47, 911, 90);
		add(lblTituloActividad);
		lblTituloActividad.setText(act.getTitulo());
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(87, 165, 212, 272);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblFoto = new JLabel("Foto");
		lblFoto.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setBounds(6, 16, 200, 250);
		panel.add(lblFoto);
		
		JScrollPane sclActividades = new JScrollPane();
		sclActividades.setBounds(362, 165, 663, 453);
		add(sclActividades);
		
		JTextArea sclDescripcion = new JTextArea();
		sclDescripcion.setEditable(false);
		sclActividades.setViewportView(sclDescripcion);
		sclDescripcion.setText(act.getDescripcion());
		
	
		
		JLabel lblxb = new JLabel("<html>&larr;<html>");
		lblxb.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion
				//padre.cambiarGestor();
				padre.cambiarAListaActividades(usu);
				
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
		lblxb.setForeground(Color.BLACK);
		lblxb.setBounds(40, 5, 46, 56);
		lblxb.setFont(new Font("Tahoma", Font.PLAIN, 46));
		add(lblxb);
		
		JLabel lblOng = new JLabel("ONG:");
		lblOng.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblOng.setBounds(85, 493, 34, 20);
		add(lblOng);
		
		JLabel campoONG = new JLabel("");
		campoONG.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		campoONG.setBounds(140, 493, 159, 20);
		add(campoONG);
	}
}
