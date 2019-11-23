package modelo;

public class Alumno extends Usuario{
	
	private int idUniv;
	private String imagenUrl;
	private String descripcion;
	private Asignatura[] asigCursadas;
	private idioma[] idiomas;
	
	public enum titulacion { //Añadir más titulaciones
		Medicina, Enfermeria
	}
	private enum idioma{ //Añadir todos los idiomas
		Espa�ol, Ingles, Frances
	}
	
	public enum disponibilidad{ //Mejorar con fechas concretas
		Siempre, Parcial, Nunca
	}
	public enum zonaAccion{
		Local, Nacional, Internacional
	}
	public int getCodUniv() {
		return idUniv;
	}
	public void setCodUniv(int codUniv) {
		this.idUniv = codUniv;
	}
	public String getImagenUrl() {
		return imagenUrl;
	}
	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public idioma[] getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(idioma[] idiomas) {
		this.idiomas = idiomas;
	}
	public Asignatura[] getAsigCursadas() {
		return asigCursadas;
	}
	public void setAsigCursadas(Asignatura[] asigCursadas) {
		this.asigCursadas = asigCursadas;
	}
	
}
