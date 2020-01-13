package modelo;

import java.util.ArrayList;
import java.util.List;

public class Asignatura {
	
	private int id;
	private String nombre;
	private PDI PDICargo;
	private String grado;
	
	public static List<Asignatura> getAsignaturasSimple() {
		List<Asignatura> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT * FROM ASIGNATURAS")) {
			lista.add(new Asignatura((Integer)tupla[0], (String)tupla[1], (String)tupla[2], (String) tupla[3]));
		}
		mibd.finalize();
		return lista;
	}
	
	public static List<String> getAsignaturasEstudia(String alumno) {
		List<String> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT a.nombre FROM ESTUDIA e, ASIGNATURAS a WHERE a.id = e.asignatura AND e.alumno = '" + alumno + "';")) {
			lista.add((String)tupla[0]);
		}
		mibd.finalize();
		return lista;
	}
	
	public static List<String> getAsignaturasImparte(String pdi) {
		List<String> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT a.nombre FROM IMPARTIR e, ASIGNATURAS a WHERE a.id = e.asignatura AND e.pdi = '" + pdi + "';")) {
			lista.add((String)tupla[0]);
		}
		mibd.finalize();
		return lista;
	}
	
	private Asignatura(int id, String nombre, String pdi, String grado) { 
		this.id = id;
		this.nombre = nombre;
		this.PDICargo = new PDI(pdi);
		this.grado = grado;
	}
	
	public Asignatura(int id) { //Saca de la BD una asignatura
		BD mibd = new BD();
		Object[] tupla = mibd.Select("SELECT * FROM ASIGNATURAS WHERE id = " + id + ";").get(0);
		mibd.finalize();
		this.id = (Integer) tupla[0];
		this.nombre = (String) tupla[1];
		this.PDICargo = new PDI((String) tupla[2]);
		this.grado = (String) tupla[3];
	}
	
	public static int getId(String nombre) { //Saca de la BD una asignatura
		BD mibd = new BD();
		Object[] tupla = mibd.Select("SELECT id FROM ASIGNATURAS WHERE nombre = '" + nombre + "';").get(0);
		mibd.finalize();
		return (Integer) tupla[0];
	}

	public Asignatura(String nombre, PDI pdi, String grado) { //Añade a la BD una nueva asignatura y crea el objeto correspondiente
		BD mibd = new BD();
		mibd.Insert("INSERT INTO ASIGNATURAS (nombre, PDICargo, grado) VALUES ('" + nombre + "', '" + pdi.getEmail() + "', '" + grado + "');");
		this.id = (Integer) mibd.SelectEscalar("SELECT MAX(id) FROM ASIGNATURAS;");
		mibd.finalize();
		this.nombre = nombre;
		this.PDICargo = pdi;
		this.grado = grado;
	}

	public void eliminarAsignatura() {
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT id FROM ACTIVIDADES WHERE asignatura = " + id + ";")) {
			Actividad.borrarActividad((Integer)tupla[0]);
		}
		mibd.Delete("DELETE FROM ESTUDIA WHERE asignatura = " + id + ";");
		mibd.Delete("DELETE FROM IMPARTIR WHERE asignatura = " + id + ";");
		mibd.Delete("DELETE FROM ASIGNATURAS WHERE id = " + id + ";");
		mibd.finalize();
		this.nombre = null;
		this.PDICargo = null;
		this.grado = null;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		BD mibd = new BD();
		mibd.Update("UPDATE ASIGNATURAS SET nombre = '" + nombre + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.nombre = nombre;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public PDI getPDICargo() {
		return PDICargo;
	}

	public void setPDICargo(PDI pDICargo) {
		BD mibd = new BD();
		mibd.Update("UPDATE ASIGNATURAS SET PDICargo = '" + pDICargo.getEmail() + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.PDICargo = pDICargo;
	}
	
	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		BD mibd = new BD();
		mibd.Update("UPDATE ASIGNATURAS SET grado = '" + grado + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.grado = grado;
	}

	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public static void cursar(String email, ConsultaiDuma ci) {
		int idAsig;
		BD mibd = new BD();
		mibd.Delete("DELETE FROM ESTUDIA WHERE alumno = '" + email + "';");
		for(String asig : ci.sacarAsignaturas()) {
			List<Object[]> lista = mibd.Select("SELECT id FROM ASIGNATURAS WHERE nombre = '" + asig + "';");
			idAsig = (lista.isEmpty()) ? -1 : (Integer)lista.get(0)[0];
			if(idAsig >= 0) {
				mibd.Insert("INSERT INTO ESTUDIA VALUES('" + email + "', " + idAsig + ");");
			}
		}
		mibd.finalize();
		
	}
	
	public static void impartir(String email, ConsultaiDuma ci) {
		// TODO Auto-generated method stub
		int idAsig;
		BD mibd = new BD();
		mibd.Delete("DELETE FROM IMPARTIR WHERE pdi = '" + email + "';");
		for(String asig : ci.sacarAsignaturas()) {
			List<Object[]> lista = mibd.Select("SELECT id FROM ASIGNATURAS WHERE nombre = '" + asig + "';");
			idAsig = (lista.isEmpty()) ? -1 : (Integer)lista.get(0)[0];
			if(idAsig >= 0) {
				mibd.Insert("INSERT INTO IMPARTIR VALUES('" + email + "', " + idAsig + ");");
			}
		}
		mibd.finalize();
	}
	
	
}
