package modelo;

public class Asignatura {
	
	private String nombre;
	private int codAsig;
	private String curso; //EJ 17-18, 19-20 en el modelo de dominio esta como int
	
	public int getcodAsig() {
		return codAsig;
	}
	public void setcodAsig(int codAsig) {
		this.codAsig = codAsig;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	
}
