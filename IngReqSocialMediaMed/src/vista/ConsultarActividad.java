package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modelo.Actividad;
import modelo.PDI;
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
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class ConsultarActividad extends JPanel {
	private boolean apuntado;
		
	/**
	 * Create the panel.
	 */
	public ConsultarActividad(MenuPrincipal padre, Usuario usu, Actividad act) {
		this.setSize(1100, 715);
		setLayout(null);
		
		JLabel lblApuntado = new JLabel("\u00A1Solicitud enviada!");
		lblApuntado.setHorizontalAlignment(SwingConstants.CENTER);
		lblApuntado.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 14));
		lblApuntado.setForeground(Color.GREEN);
		lblApuntado.setBounds(87, 629, 210, 20);
		add(lblApuntado);
		
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
				if(!apuntado) {
					Border bordeAbajo = new BevelBorder(1);
					
					panelApuntarse.setBorder(bordeAbajo);
				}
				
				
				
				//panelEditarPerfil.setBorder(bordeArriba);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!apuntado) {
				Border bordeArriba = new BevelBorder(0);
				panelApuntarse.setBorder(bordeArriba);
				//Cambiar a editar perfil
				//padre.cambiarAEditarONG(ong);
				//dispose();
				int vol = 0;
				if(act.esVoluntariado()) {
					vol =1;
				}
				
					System.out.println("Solicitud enviada");
					new Solicitud(usu, act, vol,0);	
				}
				apuntado = true;
				lblApuntarse.setEnabled(false);
				lblApuntado.setVisible(true);
				
				
			}
		});
		
		lblApuntarse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApuntarse.setBounds(0, 0, 212, 50);
		panelApuntarse.add(lblApuntarse);
		lblApuntarse.setForeground(Color.WHITE);
		lblApuntarse.setHorizontalAlignment(SwingConstants.CENTER);
		lblApuntarse.setBackground(new Color(93,103,175));
		
		
		
		if(Solicitud.estaApuntado(usu.getEmail(), act)) {
			apuntado = true;
			lblApuntado.setVisible(true);
			lblApuntarse.setEnabled(false);
		}else {
			apuntado = false;
			lblApuntado.setVisible(false);
			lblApuntarse.setEnabled(true);
		}
		
		JLabel lblTituloActividad = new JLabel("");
		lblTituloActividad.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 32));
		lblTituloActividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloActividad.setBounds(94, 47, 911, 90);
		add(lblTituloActividad);
		lblTituloActividad.setText(act.getTitulo());
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(87, 165, 212, 271);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblFoto = new JLabel("Foto");
		lblFoto.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setBounds(6, 16, 200, 250);
		panel.add(lblFoto);
		
		JScrollPane sclActividades = new JScrollPane();
		sclActividades.setBounds(362, 165, 663, 271);
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
				padre.volverAtras();
				
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
		campoONG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				padre.cambiarAPerfilONG(act.getOng(), true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				campoONG.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				campoONG.setForeground(Color.BLACK);
			}
		});
		
		JLabel lblTipoOferta = new JLabel("Fecha inicio: <dynamic>");
		lblTipoOferta.setSize(new Dimension(148, 20));
		lblTipoOferta.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblTipoOferta.setBounds(674, 493, 148, 20);
		add(lblTipoOferta);
		lblTipoOferta.setText("Tipo de oferta: " + act.getTipooferta().toString());
		lblTipoOferta.setSize(lblTipoOferta.getPreferredSize());
		
		JLabel lblAmbito = new JLabel();
		lblAmbito.setSize(new Dimension(148, 20));
		lblAmbito.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblAmbito.setBounds(674, 529, 148, 20);
		add(lblAmbito);
		lblAmbito.setText("Ámbito: " + act.getAmbito().toString());
		lblAmbito.setSize(lblAmbito.getPreferredSize());
		
		JLabel lblFechaFin = new JLabel();
		lblFechaFin.setSize(new Dimension(148, 20));
		lblFechaFin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblFechaFin.setBounds(362, 524, 148, 20);
		add(lblFechaFin);
		lblFechaFin.setText("Fecha fin: " + act.getFechafinal());
		lblFechaFin.setSize(lblFechaFin.getPreferredSize());
		
		
		JLabel lblFechaInicio = new JLabel("");
		lblFechaInicio.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblFechaInicio.setBounds(362, 493, 90, 29);
		add(lblFechaInicio);
		lblFechaInicio.setText("Fecha inicio: " + act.getFechainicio());
		lblFechaInicio.setSize(lblFechaInicio.getPreferredSize());
		
		campoONG.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		campoONG.setBounds(140, 493, 159, 20);
		add(campoONG);
		campoONG.setText(act.getOng().toString());
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ConsultarActividad.class.getResource("/resources/fondo 6 asm.png")));
		label.setBounds(0, 0, 1100, 715);
		add(label);
		
		JLabel lblTipoActividad = new JLabel("");
		lblTipoActividad.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblTipoActividad.setBounds(557, 459, 46, 14);
		add(lblTipoActividad);
		String tipoActividad;
		if(act.getInvestigador() != null) {
			//INvestigacion
			tipoActividad = " investigación";
		} else if (act.getAsignatura() != null) {
			//Aprendizaje
			tipoActividad = " aprendizaje";
		} else {
			tipoActividad = " voluntariado";
			}
		lblTipoActividad.setText("Actividad de "+ tipoActividad) ;
		lblTipoActividad.setSize(lblTipoActividad.getPreferredSize());
	}
}
