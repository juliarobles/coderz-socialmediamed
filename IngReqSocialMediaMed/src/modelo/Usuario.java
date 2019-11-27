package modelo;

public abstract class Usuario{
	
	protected String email;
	protected String nombre;
	protected String apellido1;
	protected String apellido2;
	protected int telf;
	protected Disponibilidad disponibilidad;
	protected TipoOferta tipoOferta;
	protected ZonaAccion zonaAccion;
	protected String imagenUrl;
	protected String descripcion;
	
	protected Usuario(String email) { //Saca un alumno de la base de datos
		BD mibd = new BD();
		Object[] tupla = mibd.Select("SELECT * FROM PARTICIPANTES WHERE email = '" + email + "';").get(0);
		this.email = (String) tupla[0];
		this.nombre = (String) tupla[1];
		this.apellido1 = (String) tupla[2];
		this.apellido2 = (String) tupla[3];
		this.telf = (Integer) tupla[4];
		this.disponibilidad = Disponibilidad.valueOf((String) tupla[5]);
		this.tipoOferta = TipoOferta.valueOf((String) tupla[6]);
		this.zonaAccion = ZonaAccion.valueOf((String) tupla[7]);
		this.imagenUrl = ""; //POR AHORA HASTA QUE VEAMOS COMO HACER LO DE LAS IMAGENES
		this.descripcion = (String) tupla[9];
	}
	
	protected Usuario(String email, String nombre, String apellido1, String apellido2, int telefono, Disponibilidad disponibilidad,
			TipoOferta tipoOferta, ZonaAccion zonaAccion, String url, String descripcion) { //Insertamos el usuario en la base de datos
		BD mibd = new BD();
		mibd.Insert("INSERT INTO PARTICIPANTES VALUES ('" + email + "', '" + nombre + "', '" + apellido1 + "', '" + apellido2 + "', " +
				 telefono + ", '" + disponibilidad.toString() + "', '" + tipoOferta.toString() + "', '" + zonaAccion.toString() + "', NULL, '" + descripcion + "');");
		this.email = email;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telf = telefono;
		this.disponibilidad = disponibilidad;
		this.tipoOferta = tipoOferta;
		this.zonaAccion = zonaAccion;
		this.imagenUrl = url; //POR AHORA HASTA QUE VEAMOS COMO HACER LO DE LAS IMAGENES
		this.descripcion = descripcion;
	}
	
	protected Usuario(String email, String nombre, String apellido1, String apellido2) { //Este constructor es para insertar el usuario inicial
		BD mibd = new BD();
		mibd.Insert("INSERT INTO PARTICIPANTES (email, nombre, apellido1, apellido2) VALUES ('" + email + "', '" + nombre + "', '" + apellido1 + "', '" + apellido2 + "');");
		this.email = email;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telf = -1;
		this.disponibilidad = null;
		this.tipoOferta = null;
		this.zonaAccion = null;
		this.imagenUrl = null; //POR AHORA HASTA QUE VEAMOS COMO HACER LO DE LAS IMAGENES
		this.descripcion = null;
	}
	
	public void BorrarUsuario() {
		BD mibd = new BD();
		mibd.Delete("DELETE FROM PARTICIPAR WHERE usuario = '" + email + "';");
		mibd.Delete("DELETE FROM PARTICIPANTES WHERE email = '" + email + "';");
		mibd.Delete("DELETE FROM USUARIOSUMA WHERE email = '" + email + "';");
		mibd.finalize();
		this.email = null;
		this.nombre = null;
		this.apellido1 = null;
		this.apellido2 = null;
		this.telf = -1;
		this.disponibilidad = null;
		this.tipoOferta = null;
		this.zonaAccion = null;
		this.imagenUrl = null;
		this.descripcion = null;
	}
	
	public String getEmail() {
		return email;
	}
	/*
	private void setEmail(String email) {
		no se puede cambiar el email
	}
	*/
	public String getNombre() {
		return nombre;
	}
	/*
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	*/
	public String getApellido1() {
		return apellido1;
	}
	/*
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	*/
	public String getApellido2() {
		return apellido2;
	}
	
	/*
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	*/
	public int getTelf() {
		return telf;
	}
	public void setTelf(int telf) {
		BD mibd = new BD();
		mibd.Update("UPDATE PARTICIPANTES SET telefono = " + telf + " WHERE email = '" + this.email + "';");
		this.telf = telf;
		mibd.finalize();
	}
	public Disponibilidad getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(Disponibilidad disponibilidad) {
		BD mibd = new BD();
		mibd.Update("UPDATE PARTICIPANTES SET disponibilidad = '" + disponibilidad.toString() + "' WHERE email = '" + this.email + "';");
		this.disponibilidad = disponibilidad;
		mibd.finalize();
	}
	public TipoOferta getEtiquetas() {
		return tipoOferta;
	}
	public void setTipoOferta(TipoOferta etiquetas) {
		BD mibd = new BD();
		mibd.Update("UPDATE PARTICIPANTES SET tipooferta = '" + etiquetas.toString() + "' WHERE email = '" + this.email + "';");
		this.tipoOferta = etiquetas;
		mibd.finalize();
	}
	public ZonaAccion getZonaAccion() {
		return zonaAccion;
	}
	public void setZonaAccion(ZonaAccion zonaAccion) {
		BD mibd = new BD();
		mibd.Update("UPDATE PARTICIPANTES SET zonaAccion = '" + zonaAccion.toString() + "' WHERE email = '" + this.email + "';");
		this.zonaAccion = zonaAccion;
		mibd.finalize();
	}
	public String getImagenUrl() {
		return imagenUrl;
	}
	/* ESTO HAY QUE INVESTIGARLO
	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}
	*/
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		BD mibd = new BD();
		mibd.Update("UPDATE PARTICIPANTES SET descripcion = '" + descripcion + "' WHERE email = '" + this.email + "';");
		this.descripcion = descripcion;
		mibd.finalize();
	}
}
