package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Actividad;
import modelo.ONG;
import modelo.PDI;
import modelo.Propuesta;
import modelo.Usuario;

public class MenuPrincipal extends JFrame {

	private JPanel invitado;
	private MenuPrincipalUsuario usuario;
	private JPanel ong;
	private JPanel gestor;
	private GestionPropuestas gestionPropuestas;
	private JPanel registroong;
	private JPanel crearactividad;
	private JPanel crearPropuesta;
	private GestionProyectos crearproyecto;
	private GestionActividades gestionActividades;
	private JPanel perfilong;
	private JPanel editarong;
	private JPanel listaActividades;
	private EditarActividad editarActividad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipalUsuario.class.getResource("/resources/_Logo AccionSocialMed png.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1321, 715);
		setSize(1100, 715);
		setLocationRelativeTo(null);
		invitado = new MenuPrincipalInvitado(this);
		invitado.setVisible(true);
		setContentPane(invitado);
		setResizable(false);
		
		
		
	}
	public void cambiarACrearPropuesta(ONG ong) {
		crearPropuesta = new CrearPropuesta(ong, this);
		crearPropuesta.setVisible(true);
		this.ong.setVisible(false);
		setContentPane(crearPropuesta);
	}
	
	public void cambiarAInvitado() {
		if(usuario != null) {
			usuario.setVisible(false);
			usuario = null;
		}
		if(ong != null) {
			ong.setVisible(false);
			ong = null;
		}
		if(gestor != null) {
			gestor.setVisible(false);
			gestor = null;
		}
		invitado.setVisible(true);
		setContentPane(invitado);
	}
	
	public void cambiarUsuario(Usuario usu) {
		if(usuario != null) {
			usuario.actualizarMatch();
			usuario.actualizarMasSolicitadas();
			usuario.actualizarUltimasPublicadas();
		} else {
			usuario = new MenuPrincipalUsuario(this, usu);
		}
		if(listaActividades != null) {
			listaActividades.setVisible(false);
			listaActividades = null;
		}
		if(gestionActividades != null) {
			gestionActividades.setVisible(false);
			gestionActividades = null;
		}
		if(invitado != null) {
			invitado.setVisible(false);
		}
		usuario.setVisible(true);
		
		setContentPane(usuario);
	}
	public void cambiardePropuestaAONG(ONG usu) {
		ong = new MenuPrincipalONG(this,usu);
		ong.setVisible(true);
		this.crearPropuesta.setVisible(false);
		setContentPane(ong);
	}
	public void cambiarONG(ONG usu) {
		ong = new MenuPrincipalONG(this, usu);
		
		
		ong.setVisible(true);
		if(invitado != null) {
			invitado.setVisible(false);
		}
		if(perfilong != null) {
			perfilong.setVisible(false);;
			perfilong = null;
		}
		if(gestionActividades != null) {
			gestionActividades.setVisible(false);
			gestionActividades = null;
		}
		setContentPane(ong);
	}

	public void cambiarGestor() {
		if(gestor == null) {
			gestor = new MenuPrincipalGestor(this);
		}
		if(gestionPropuestas != null) {
			gestionPropuestas.setVisible(false);
			gestionPropuestas = null;
		}
		if(registroong != null) {
			registroong.setVisible(false);
			registroong = null;
		}
		if(crearactividad != null) {
			crearactividad.setVisible(false);
			crearactividad = null;
		}
		if(crearproyecto != null) {
			crearproyecto.setVisible(false);
			crearproyecto = null;
		}
		if(gestionActividades != null) {
			gestionActividades.setVisible(false);
			gestionActividades = null;
		}
		gestor.setVisible(true);
		invitado.setVisible(false);
		setContentPane(gestor);
	}
	
	public void cambiarAGestionPropuestas() {
		gestionPropuestas = new GestionPropuestas(this);
		gestionPropuestas.setVisible(true);
		gestor.setVisible(false);
		setContentPane(gestionPropuestas);
	}

	public void cambiarARegistroONG() {
		registroong = new RegistroONG(this);
		registroong.setVisible(true);
		gestor.setVisible(false);
		setContentPane(registroong);
	}
	
	public void cambiarACrearActividad(Propuesta p) {
		crearactividad = new CrearActividad(this, p);
		gestionPropuestas.setVisible(false);
		crearactividad.setVisible(true);
		setContentPane(crearactividad);
	}
	
	public void volverAPropuestas() {
		gestionPropuestas.setVisible(true);
		crearactividad.setVisible(false);
		crearactividad = null;
		setContentPane(gestionPropuestas);
	}

	public void volverAPropuestasModificado() {
		gestionPropuestas = new GestionPropuestas(this);
		volverAPropuestas();
		
	}

	public void cambiarACrearProyecto() {
		crearproyecto = new GestionProyectos(this);
		gestor.setVisible(false);
		crearproyecto.setVisible(true);
		setContentPane(crearproyecto);
		
	}
	public void cambiarAPerfilONG(ONG ong) {
		perfilong = new PerfilONG (this, ong);
		if(ong != null)
		{
			this.ong.setVisible(false);
			ong = null;
		}
		if(editarong != null) {
			editarong.setVisible(false);
			editarong= null;
		}
		perfilong.setVisible(true);
		setContentPane(perfilong);
		
	}
	public void cambiarAEditarONG (ONG ong) {
		editarong = new EditarPerfilONG(this, ong);
		this.perfilong.setVisible(false);
		this.editarong.setVisible(true);
		setContentPane(editarong);
		
	}

	public void cambiarAListaActividades(Usuario usu) {
		listaActividades = new ListaActividades(this, usu);
		this.listaActividades.setVisible(true);
		this.usuario.setVisible(false);
		setContentPane(listaActividades);
		
	}

	public void cambiarAGestionActividades(ONG ong, PDI pdi) {
		gestionActividades = new GestionActividades(this, ong, pdi);
		this.gestionActividades.setVisible(true);
		if(usuario != null) {
			usuario.setVisible(false);
		}
		if(gestor != null) {
			gestor.setVisible(false);
		}
		if(this.ong != null) {
			this.ong.setVisible(false);
		}
		setContentPane(gestionActividades);
		
	}

	public void volverAGestionActividades(Actividad editada) {
		if(gestionActividades != null) {
			gestionActividades.setVisible(true);
			if(editada != null) {
				gestionActividades.establecerConsultado(editada);
				gestionActividades.actualizarActividades();
			}
			setContentPane(gestionActividades);
		}
		if(editarActividad != null) {
			editarActividad.setVisible(false);
			editarActividad = null;
		}
		
	}

	public void cambiarAEditarActividad(Actividad a, boolean gestor) {
		if(a != null) {
			editarActividad = new EditarActividad(this, a, gestor);
			gestionActividades.setVisible(false);
			editarActividad.setVisible(true);
			setContentPane(editarActividad);
		}
	}
}
