package modelo;

public class Actividad {
	//Quizás sea conveniente crear dos subclases que ereden de esta,
	//ApreServ y Voluntariado
	
	private int codActividad;
	private String nombre;
	private String descripcion;
	private String imageUrl;
	private TipoOferta[] etiquetas;
	public int getCodActividad() {
		return codActividad;
	}
	public void setCodActividad(int codActividad) {
		this.codActividad = codActividad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public TipoOferta[] getEtiquetas() {
		return etiquetas;
	}
	public void setEtiquetas(TipoOferta[] etiquetas) {
		this.etiquetas = etiquetas;
	}
	
	
}
