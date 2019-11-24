package modelo;

import java.util.HashSet;

public class Proyecto {
	
	private int id;
	private String titulo;
	private String contenido;
	private String image;
	private HashSet<Actividad> Actividades = new HashSet<Actividad>();
	
	public HashSet<Actividad> getActividades() {
		return Actividades;
	}
	public void setActividades(HashSet<Actividad> actividades) {
		Actividades = actividades;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
