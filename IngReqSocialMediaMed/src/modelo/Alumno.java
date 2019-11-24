package modelo;

public class Alumno extends Usuario {

	public Alumno(String email) { //Saca un alumno de la base de datos
		super(email);
	}

	public Alumno(String email, String nombre, String apellido1, String apellido2, int telefono,
			Disponibilidad disponibilidad, TipoOferta tipoOferta, ZonaAccion zonaAccion, String url,
			String descripcion) {
		super(email, nombre, apellido1, apellido2, telefono, disponibilidad, tipoOferta, zonaAccion, url, descripcion);
		BD mibd = new BD();
		mibd.Insert("INSERT INTO ALUMNOS VALUES ('" + email + "');");
		mibd.finalize();
	}

	public Alumno(String email, String nombre, String apellido1, String apellido2) {
		super(email, nombre, apellido1, apellido2);
		BD mibd = new BD();
		mibd.Insert("INSERT INTO ALUMNOS VALUES ('" + email + "');");
		mibd.finalize();
	}
	
	public void BorrarAlumno() {
		BD mibd = new BD();
		mibd.Delete("DELETE FROM ALUMNOS WHERE email = '" + email + "';");
		mibd.finalize();
		this.BorrarUsuario();
	}
	
	

}
