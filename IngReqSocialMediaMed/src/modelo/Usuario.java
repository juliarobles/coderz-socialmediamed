package modelo;

public class Usuario {
	
	private String DNI; //Se podria quitar id
	private int id;
	private String nombre;
	private String correo;
	private String pass;
	private String apellido1;
	private String apellido2;
	private int telf;
	private String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
	
	
	
}
