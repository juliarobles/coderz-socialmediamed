package modelo;

public class ONG {
	
	private String email;
	private String nombre;
	private String descripcion;
	
	
	
	public ONG(String email) {
		BD mibd = new BD();
		Object[] tupla = mibd.Select("SELECT * FROM USUARIOONG WHERE email = '" + email + "';").get(0);
		mibd.finalize();
		this.email = (String) tupla[0];
		this.nombre = (String) tupla[1];
		this.descripcion = (String) tupla[2];
		
	}
	
	public ONG(String email, String pass, String nombre, String descripcion) {
		BD mibd = new BD();
		mibd.Insert("INSERT INTO USUARIOONG VALUES('" + email + "', '" + pass + "', '" + nombre + "', '" + descripcion +"');");
		mibd.finalize();
		this.email = email;
		this.nombre = nombre;
		this.descripcion = descripcion;
		
	}
	
	public void setPass(String pass) { //No guardamos la pass como variable por privacidad
		BD mibd = new BD();
		mibd.Update("UPDATE USUARIOONG SET pass = '" + pass + "' WHERE email = '" + this.email +"';");
		mibd.finalize();
	}
	
	
	public String getEmail() {
		return email;
	}
	/*
	public void setEmail(String email) {
		this.email = email; //No puede cambiar su email
	}
	*/
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		BD mibd = new BD();
		mibd.Update("UPDATE USUARIOONG SET nombre = '" + nombre + "' WHERE email = '" + this.email +"';");
		mibd.finalize();
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		BD mibd = new BD();
		mibd.Update("UPDATE USUARIOONG SET descripcion = '" + descripcion + "' WHERE email = '" + this.email +"';");
		mibd.finalize();
		this.descripcion = descripcion;
	}
	
}
