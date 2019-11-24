package modelo;

public class Alumno extends Usuario{
	
	public Alumno(String email) {
		super(email);
		// TODO Auto-generated constructor stub
	}
	private int idUniv;
	private Asignatura[] asigCursadas;
	//Todo lo comentado en principio fuera
	/*private idioma[] idiomas;
	private titulacion[] titulacion;
	private enum titulacion { //Añadir más titulaciones
		Medicina, Enfermeria
	}
	private enum idioma{ //Añadir todos los idiomas
		Español, Ingles, Frances, Aleman, Italiano, Otros
	}*/
	public int getCodUniv() {
		return idUniv;
	}
	public void setCodUniv(int codUniv) {
		this.idUniv = codUniv;
	}/*
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
	}*/
	public Asignatura[] getAsigCursadas() {
		return asigCursadas;
	}
	public void setAsigCursadas(Asignatura[] asigCursadas) {
		this.asigCursadas = asigCursadas;
	}
	
}
