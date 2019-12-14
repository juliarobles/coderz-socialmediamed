package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import modelo.Actividad;
import modelo.Tupla;
import modelo.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import utilidades.JPictureBox;
import javax.swing.JList;

@SuppressWarnings("serial")
public class MenuPrincipalUsuario extends JPanel {

	private DefaultListModel<Tupla> listamatch;
	private DefaultListModel<Tupla> listanuevos;
	private DefaultListModel<Tupla> listamassolicitados;
	private Usuario usu;
	
	public MenuPrincipalUsuario(MenuPrincipal padre, Usuario usu) {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipalUsuario.class.getResource("/resources/_Logo AccionSocialMed png.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.usu = usu;
		//setBounds(100, 100, padre.getWidth(), padre.getHeight());
		setBounds(100, 100, 1100, 715);
		//setLocationRelativeTo(null);
		
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		
		JLabel login = new JLabel("Logout");
		login.setBounds(971, 24, 105, 62);
		login.setForeground(Color.BLACK);
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana login
				padre.cambiarAInvitado();
				//dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				login.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				login.setForeground(Color.BLACK);
			}
		});
		login.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		
		
		JLabel lblCopyright = new JLabel("2019 AccionSocialMed\u00AE es una marca registrada de CoderZ. Reservados todos los derechos. Versi\u00F3n 2.1.29.15");
		lblCopyright.setBounds(10, 691, 537, 14);
		add(lblCopyright);
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setBounds(872, 24, 105, 62);
		lblPerfil.setForeground(Color.BLACK);
		lblPerfil.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Perfil pu = new Perfil(usu);
				pu.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPerfil.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblPerfil.setForeground(Color.BLACK);
			}
		});
		
		JLabel lblActividades = new JLabel("Actividades");
		lblActividades.setBounds(731, 24, 105, 62);
		lblActividades.setForeground(Color.BLACK);
		lblActividades.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		
		JLabel lblSocialmediamed = new JLabel("SocialMediaMed");
		lblSocialmediamed.setBounds(110, 26, 199, 52);
		lblSocialmediamed.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 24));
		
		ImageIcon logo = new ImageIcon(InicioSesion.class.getResource("/resources/_Logo AccionSocialMed png.png"));
		JPictureBox pictureBox = new JPictureBox();
		pictureBox.setBounds(44, 26, 56, 52);
		pictureBox.setIcon(logo);
		
		lblActividades.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				padre.cambiarAListaActividades(usu);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblActividades.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblActividades.setForeground(Color.BLACK);
			}
		});
		setLayout(null);
		add(lblCopyright);
		add(pictureBox);
		add(lblSocialmediamed);
		add(lblActividades);
		add(lblPerfil);
		add(login);
		
		JLabel lblTeRecomendamos = new JLabel("Te recomendamos...");
		lblTeRecomendamos.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblTeRecomendamos.setBounds(44, 129, 199, 52);
		add(lblTeRecomendamos);
		
		JLabel lblltimasActividadesPublicadas = new JLabel("\u00DAltimas actividades publicadas");
		lblltimasActividadesPublicadas.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblltimasActividadesPublicadas.setBounds(44, 296, 265, 52);
		add(lblltimasActividadesPublicadas);
		
		JLabel lblActividadesMsSolicitadas = new JLabel("Actividades m\u00E1s solicitadas");
		lblActividadesMsSolicitadas.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblActividadesMsSolicitadas.setBounds(44, 463, 265, 52);
		add(lblActividadesMsSolicitadas);
		
		listamatch = new DefaultListModel<Tupla>();
		listanuevos = new DefaultListModel<Tupla>();
		listamassolicitados = new DefaultListModel<Tupla>();
		
		actualizarMatch();
		actualizarUltimasPublicadas();
		actualizarMasSolicitadas();
		
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBorder(null);
		scroll.setBounds(43, 171, 967, 119);
		add(scroll);
		
		JList<Tupla> match = new JList<Tupla>(listamatch);
		match.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		match.setBorder(null);
		match.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		match.setLayoutOrientation(JList.VERTICAL);
		scroll.setViewportView(match);
		
		JScrollPane scroll2 = new JScrollPane();
		scroll2.setBorder(null);
		scroll2.setBounds(43, 336, 967, 119);
		add(scroll2);
		
		JList<Tupla> nuevas = new JList<Tupla>(listanuevos);
		nuevas.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		nuevas.setBorder(null);
		nuevas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		nuevas.setLayoutOrientation(JList.VERTICAL);
		scroll2.setViewportView(nuevas);
		
		
		JScrollPane scroll3 = new JScrollPane();
		scroll3.setBorder(null);
		scroll3.setBounds(43, 505, 967, 119);
		add(scroll3);
		
		JList<Tupla> list = new JList<Tupla>(listamassolicitados);
		list.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		list.setBorder(null);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		scroll3.setViewportView(list);
		
	}
	
	public void actualizarMatch(){
		listamatch.clear();
		for(Tupla t : Actividad.getMatch(usu)) {
			listamatch.addElement(t);
		}
	}
	
	public void actualizarUltimasPublicadas() {
		listanuevos.clear();
		for(Tupla t : Actividad.getUltimasAniadidas()) {
			listanuevos.addElement(t);
		}
	}
	
	public void actualizarMasSolicitadas() {
		listamassolicitados.clear();
		for(Tupla t : Actividad.getMasSolicitadas()) {
			listamassolicitados.addElement(t);
		}
	}
}
