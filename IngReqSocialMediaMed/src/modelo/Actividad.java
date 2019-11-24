package modelo;

public class Actividad {
	//Quizás sea conveniente crear dos subclases que ereden de esta,
	//ApreServ y Voluntariado
	
	private int id;
	private String titulo;
	private String descripcion;
	private String imagen;
	private String fechainicio;
	private String fechafinal;
	private ZonaAccion zonaaccion;
	private TipoOferta tipooferta;
	private Asignatura asignatura;
	private Proyecto proyecto;
	private ONG ong;
	
	public Actividad(int id) {
		
	}

	public Actividad(int id, String titulo, String descripcion, String imagen, String fechainicio, String fechafinal,
			ZonaAccion zonaaccion, TipoOferta tipooferta, Asignatura asignatura, Proyecto proyecto, ONG ong) {
		
		
		
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.fechainicio = fechainicio;
		this.fechafinal = fechafinal;
		this.zonaaccion = zonaaccion;
		this.tipooferta = tipooferta;
		this.asignatura = asignatura;
		this.proyecto = proyecto;
		this.ong = ong;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}
	public String getFechafinal() {
		return fechafinal;
	}
	public void setFechafinal(String fechafinal) {
		this.fechafinal = fechafinal;
	}
	public ZonaAccion getZonaaccion() {
		return zonaaccion;
	}
	public void setZonaaccion(ZonaAccion zonaaccion) {
		this.zonaaccion = zonaaccion;
	}
	public TipoOferta getTipooferta() {
		return tipooferta;
	}
	public void setTipooferta(TipoOferta tipooferta) {
		this.tipooferta = tipooferta;
	}
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public ONG getOng() {
		return ong;
	}
	public void setOng(ONG ong) {
		this.ong = ong;
	}

	
	
	
}
