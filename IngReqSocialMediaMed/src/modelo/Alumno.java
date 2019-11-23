package modelo;

public class Alumno extends Usuario{
	
	private int idUniv;
	private String imagenUrl;
	private String descripcion;
	private Asignatura[] asigCursadas;
	private idioma[] idiomas;
	private titulacion[] titulacion;
	private disponibilidad[] disponibilidad;
	private zonaAccion[] zonaAccion;
	
	private enum titulacion { //Añadir más titulaciones
		Medicina, Enfermeria
	}
	private enum idioma{ //Añadir todos los idiomas
		Español, Ingles, Frances, Aleman, Italiano, Otros
	}
	private enum disponibilidad{ //Mejorar con fechas concretas
		Siempre, FindeSemana, EntreSemana, Nunca
	}
	private enum zonaAccion{
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
	public titulacion[] getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(titulacion[] titulacion) {
		this.titulacion = titulacion;
	}
	public disponibilidad[] getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(disponibilidad[] disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public zonaAccion[] getZonaAccion() {
		return zonaAccion;
	}
	public void setZonaAccion(zonaAccion[] zonaAccion) {
		this.zonaAccion = zonaAccion;
	}
	public Asignatura[] getAsigCursadas() {
		return asigCursadas;
	}
	public void setAsigCursadas(Asignatura[] asigCursadas) {
		this.asigCursadas = asigCursadas;
	}
	
}
