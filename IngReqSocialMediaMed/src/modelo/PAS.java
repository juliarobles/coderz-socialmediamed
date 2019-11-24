package modelo;


public class PAS extends Usuario{

	public PAS(String email, String nombre, String apellido1, String apellido2, int telefono,
			Disponibilidad disponibilidad, TipoOferta tipoOferta, ZonaAccion zonaAccion, String url,
			String descripcion) {
		super(email, nombre, apellido1, apellido2, telefono, disponibilidad, tipoOferta, zonaAccion, url, descripcion);
		BD mibd = new BD();
		mibd.Insert("INSERT INTO PAS VALUES ('" + email + "');");
	}

	public PAS(String email, String nombre, String apellido1, String apellido2) {
		super(email, nombre, apellido1, apellido2);
		BD mibd = new BD();
		mibd.Insert("INSERT INTO PAS VALUES ('" + email + "');");
	}

	public PAS(String email) {
		super(email);
	}
	
	public void BorrarPAS() {
		BD mibd = new BD();
		mibd.Delete("DELETE FROM PAS WHERE email = '" + email + "';");
		mibd.finalize();
		this.BorrarUsuario();
	}
	
}
