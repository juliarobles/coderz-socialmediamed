package modelo;

import java.util.ArrayList;
import java.util.List;

public class Solicitud {
	private Usuario participante;
	private Actividad actividad;
	private int aceptadopdi; //0 indefinido, 1 aceptado, 2 rechazado
	private int aceptadoong;
	
	private String email;
	
	public static Object[][] getTodasSolicitudesParticipante(String email){
		BD mibd = new BD();
		List<Object[]> list = mibd.Select("SELECT a.titulo, o.nombre, a.fechainicio, a.fechafinal, s.aceptadopdi, s.aceptadoong, a.id FROM SOLICITUDES s, ACTIVIDADES a, USUARIOONG o WHERE s.actividad = a.id AND a.ong = o.email AND s.participante = '" + email + "';");
		Object[][] res = new Object[list.size()][6];
		int i = 0, acepPDI, acepONG;
		for(Object[] tupla : list) {
			res[i][0] = tupla[0]; //Nombre de la actividad
			res[i][1] = tupla[1]; //Nombre de la ONG
			res[i][2] = tupla[2]; //Fecha inicio
			res[i][3] = tupla[3]; //Fecha fin
			acepPDI = (Integer)tupla[4];
			acepONG = (Integer)tupla[5];
			if(acepPDI == 1 && acepONG == 1) {
				res[i][4] = "Aceptada"; 
			} else if (acepPDI == 2 || acepONG == 2) {
				res[i][4] = "Rechazada"; 
			} else {
				res[i][4] = "Pendiente"; 
			}
			res[i][5] = tupla[6]; 
			i++;
		}
		mibd.finalize();
		return res;
	}
	
	
	public static List<Tupla> getTodasSolicitudesPDIGestorSimple(int idActividad){
		List<Tupla> list = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT s.participante, u.nombre, u.apellido1, u.apellido2 FROM SOLICITUDES s, PARTICIPANTES u WHERE u.email = s.participante AND s.aceptadopdi = 0 AND s.actividad = " + idActividad + ";")) {
			list.add(new Tupla((String) tupla[0], (String)tupla[1] + " " + (String)tupla[2] + " " + (String)tupla[3]));
		}
		mibd.finalize();
		return list;
	}
	
	public static List<Tupla> getTodasSolicitudesONGSimple(int idActividad){
		List<Tupla> list = new ArrayList<>();
		BD mibd = new BD();
		int i = 1;
		for(Object[] tupla : mibd.Select("SELECT participante FROM SOLICITUDES WHERE aceptadoong = 0 AND actividad = " + idActividad + ";")) {
			list.add(new Tupla((String) tupla[0], "Solicitud " + i));
			i++;
		}
		mibd.finalize();
		return list;
	}
	
	public void aceptadoPorPDIGestor() {
		setAceptadopdi(1);
	}
	
	public void rechazadoPorPDIGestor() {
		setAceptadopdi(2);
	}
	
	public void aceptadoPorONG() {
		setAceptadoong(1);
	}
	
	public void rechazadoPorONG() {
		setAceptadoong(2);
	}
	
	public Solicitud(Usuario participante, Actividad actividad) {
		BD mibd = new BD();
		Object[] tupla = mibd.Select("SELECT * FROM SOLICITUDES WHERE participante = '" + participante.email + "' AND actividad = " + actividad.getId() + ";").get(0);
		int tipo = (int)mibd.SelectEscalar("SELECT tipo FROM USUARIOSUMA WHERE email = '" + (String)tupla[0] + "';");
		mibd.finalize();
		if(tipo == 1) {
			this.participante = new Alumno((String) tupla[0]);
		} else if (tipo == 2){
			this.participante = new PDI((String) tupla[0]);
		} else {
			this.participante = new PAS((String) tupla[0]);
		}
		this.actividad = new Actividad((Integer) tupla[1]);
		this.aceptadopdi = (Integer) tupla[2];
		this.aceptadoong = (Integer) tupla[3];
		this.email = participante.email;
	}
	
	public Solicitud(String usuario, Actividad actividad) {
		BD mibd = new BD();
		Object[] tupla = mibd.Select("SELECT * FROM SOLICITUDES WHERE participante = '" + usuario + "' AND actividad = " + actividad.getId() + ";").get(0);
		mibd.finalize();
		this.actividad = new Actividad((Integer) tupla[1]);
		this.aceptadopdi = (Integer) tupla[2];
		this.aceptadoong = (Integer) tupla[3];
		this.email = usuario;
	}

	public static boolean estaApuntado(String emailusu, Actividad a) {
		BD mibd = new BD();
		boolean res = !mibd.Select("SELECT participante FROM SOLICITUDES WHERE participante = '" + emailusu + "' AND actividad = " + a.getId() + ";").isEmpty();
		if(!res) {
			res = !mibd.Select("SELECT usuario FROM PARTICIPAR WHERE usuario = '" + emailusu + "' AND actividad = " + a.getId() + ";").isEmpty();
		}
		mibd.finalize();
		return res;
	}
	
	
	/**
	 * Este método crea una nueva solicitud
	 * @param aceptadopdi debe ser 0 si es una solicitud nueva de investigacion/aprendizaje y 1 si es voluntariado
	 * @param aceptadoong debe ser 0 si es una solicitud nueva, en todos los casos
	 * @return void
	*/
	public Solicitud(Usuario participante, Actividad actividad, int aceptadopdi, int aceptadoong) { //INICIALMENTE AMBOS INT DEBEN SER 0
		BD mibd = new BD();
		mibd.Insert("INSERT INTO SOLICITUDES VALUES ('" + participante.getEmail() + "', " + actividad.getId() + ", " + aceptadopdi + ", " + aceptadoong + ");");
		mibd.finalize();
		this.participante = participante;
		this.actividad = actividad;
		this.aceptadopdi = aceptadopdi;
		this.aceptadoong = aceptadoong;
		this.email = participante.email;
	}

	public Usuario getParticipante() {
		return participante;
	}

	public void setParticipante(Usuario participante) {
		BD mibd = new BD();
		mibd.Update("UPDATE SOLICITUDES SET participante = '" + participante.getEmail() + "' WHERE participante = '" + this.email + "' AND actividad = " + this.actividad.getId() + ";");
		mibd.finalize();
		this.participante = participante;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		BD mibd = new BD();
		mibd.Update("UPDATE SOLICITUDES SET actividad = " + actividad.getId() + " WHERE participante = '" + this.email + "' AND actividad = " + this.actividad.getId() + ";");
		mibd.finalize();
		this.actividad = actividad;
	}

	public boolean getAceptadopdi() {
		return aceptadopdi == 1;
	}

	private void setAceptadopdi(int aceptadopdi) {
		BD mibd = new BD();
		mibd.Update("UPDATE SOLICITUDES SET aceptadopdi = " + aceptadopdi + " WHERE participante = '" + this.email + "' AND actividad = " + this.actividad.getId() + ";");
		mibd.finalize();
		this.aceptadopdi = aceptadopdi;
	}

	public boolean getAceptadoong() {
		return aceptadoong == 1;
	}

	private void setAceptadoong(int aceptadoong) {
		BD mibd = new BD();
		mibd.Update("UPDATE SOLICITUDES SET aceptadoong = " + aceptadoong + " WHERE participante = '" + this.email + "' AND actividad = " + this.actividad.getId() + ";");
		mibd.finalize();
		this.aceptadoong = aceptadoong;
	}
	
	public void borrarSolicitud() {
		BD mibd = new BD();
		mibd.Delete("DELETE FROM SOLICITUDES WHERE participante = '" + this.email + "' AND actividad = " + this.actividad.getId() + ";");
		mibd.finalize();
		this.participante = null;
		this.actividad = null;
		this.aceptadopdi = -1;
		this.aceptadoong = -1;
		this.email = null;
	}
	
	public static void borrarSolicitud(String email, int idAct) {
		BD mibd = new BD();
		mibd.Delete("DELETE FROM SOLICITUDES WHERE participante = '" + email + "' AND actividad = " + idAct + ";");
		mibd.finalize();
	}
}
