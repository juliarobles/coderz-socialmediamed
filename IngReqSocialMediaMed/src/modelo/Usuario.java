package modelo;

public class Usuario {
	
	private String DNI;
	private String nombre;
	private String correo;
	private String pas;
	private String apellido1;
	private String apellido2;
	private int telf;
	private String imagenUrl;
	private Etiquetas[] etiquetas;
	private Disponibilidad[] disponibilidad;
	private ZonaAccion[] zonaAccion;
	private String descripcion;
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContraseña() {
		return pas;
	}
	public void setContraseña(String contraseña) {
		this.pas = contraseña;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public int getTelf() {
		return telf;
	}
	public void setTelf(int telf) {
		this.telf = telf;
	}
	public Etiquetas[] getEtiquetas() {
		return etiquetas;
	}
	public void setEtiquetas(Etiquetas[] etiquetas) {
		this.etiquetas = etiquetas;
	}
	public Disponibilidad[] getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(Disponibilidad[] disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public ZonaAccion[] getZonaAccion() {
		return zonaAccion;
	}
	public void setZonaAccion(ZonaAccion[] zonaAccion) {
		this.zonaAccion = zonaAccion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagenUrl() {
		return imagenUrl;
	}
	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}
}
