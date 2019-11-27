package modelo;

import java.util.ArrayList;
import java.util.List;

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
	
	public static List<Tupla> getActividadesDisponiblesSimple(){
		List<Tupla> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT id, titulo FROM ACTIVIDADES WHERE proyecto IS NULL")) {
			lista.add(new Tupla(Integer.toString((Integer) tupla[0]), (String) tupla[1]));
		}
		mibd.finalize();
		return lista;
	}
	
	public Actividad(int id) {
		BD mibd = new BD();
		Object[] tupla = mibd.Select("SELECT * FROM ACTIVIDADES WHERE id = " + id + ";").get(0);
		mibd.finalize();
		this.id = (Integer)tupla[0];
		this.titulo = (String)tupla[1];
		this.descripcion = (String)tupla[2];
		this.imagen = null; //POR AHORA NULL HASTA QUE MIREMOS LO DE LAS IMAGENES
		this.fechainicio = (String)tupla[4];
		this.fechafinal = (String)tupla[5];
		this.zonaaccion = ZonaAccion.valueOf((String)tupla[6]);
		this.tipooferta = TipoOferta.valueOf((String)tupla[7]);
		this.asignatura = new Asignatura((Integer)tupla[8]);
		this.proyecto = new Proyecto((Integer)tupla[9]);
		this.ong = new ONG((String)tupla[10]);
	}

	public Actividad(String titulo, String descripcion, String imagen, String fechainicio, String fechafinal,
			ZonaAccion zonaaccion, TipoOferta tipooferta, Asignatura asignatura, Proyecto proyecto, ONG ong) {
		
		String asig = (asignatura != null)? Integer.toString(asignatura.getId()) : "NULL";
		String proy = (proyecto != null)? Integer.toString(proyecto.getId()) : "NULL";
	
		BD mibd = new BD();
		mibd.Insert("INSERT INTO ACTIVIDADES (titulo, descripcion, imagen, fechainicio, fechafinal, zonaaccion, tipooferta, asignatura, proyecto, ong) "
				+ "VALUES('" + titulo + "', '" + descripcion + "', NULL, '" + fechainicio + "', '" 
				+ fechafinal + "', '" + zonaaccion.toString() + "', '" + tipooferta.toString() + "', " + asig + ", " 
				+ proy + ", '" + ong.getEmail() + "');");
		
		this.id = (Integer) mibd.SelectEscalar("SELECT MAX(id) FROM ACTIVIDADES;");
		mibd.finalize();
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
	
	public void borrarActividad() {
		BD mibd = new BD();
		mibd.Delete("DELETE FROM SEGUIMIENTO WHERE actividad = " + id + ";");
		mibd.Delete("DELETE FROM ACTIVDIDADES WHERE id = " + id + ";");
		mibd.finalize();
		
		this.id = -1;
		this.titulo = null;
		this.descripcion = null;
		this.imagen = null;
		this.fechainicio = null;
		this.fechafinal = null;
		this.zonaaccion = null;
		this.tipooferta = null;
		this.asignatura = null;
		this.proyecto = null;
		this.ong = null;
	}
	
	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		BD mibd = new BD();
		mibd.Update("UPDATE ACTIVIDADES SET titulo = '" + titulo + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.titulo = titulo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		BD mibd = new BD();
		mibd.Update("UPDATE ACTIVIDADES SET descripcion = '" + descripcion + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.descripcion = descripcion;
	}
	
	public String getImagen() {
		return imagen;
	}
	/*HAY QUEMIRAR
	public void setImagen(String imagen) {
		BD mibd = new BD();
		mibd.Update("");
		mibd.finalize();
		this.imagen = imagen;
	}
	*/
	public String getFechainicio() {
		return fechainicio;
	}
	
	public void setFechainicio(String fechainicio) {
		BD mibd = new BD();
		mibd.Update("UPDATE ACTIVIDADES SET fechainicio = '" + fechainicio + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.fechainicio = fechainicio;
	}
	
	public String getFechafinal() {
		return fechafinal;
	}
	
	public void setFechafinal(String fechafinal) {
		BD mibd = new BD();
		mibd.Update("UPDATE ACTIVIDADES SET fechafinal = '" + fechafinal + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.fechafinal = fechafinal;
	}
	
	public ZonaAccion getZonaaccion() {
		return zonaaccion;
	}
	
	public void setZonaaccion(ZonaAccion zonaaccion) {
		BD mibd = new BD();
		mibd.Update("UPDATE ACTIVIDADES SET zonaaccion = '" + zonaaccion.toString() + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.zonaaccion = zonaaccion;
	}
	
	public TipoOferta getTipooferta() {
		return tipooferta;
	}
	
	public void setTipooferta(TipoOferta tipooferta) {
		BD mibd = new BD();
		mibd.Update("UPDATE ACTIVIDADES SET tipooferta = '" + tipooferta.toString() + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.tipooferta = tipooferta;
	}
	
	public Asignatura getAsignatura() {
		return asignatura;
	}
	
	public void setAsignatura(Asignatura asignatura) {
		BD mibd = new BD();
		if(asignatura == null) {
			mibd.Update("UPDATE ACTIVIDADES SET asignatura = NULL WHERE id = " + this.id + ";");
			mibd.finalize();
			this.asignatura = null;
		} else {
			mibd.Update("UPDATE ACTIVIDADES SET asignatura = " + asignatura.getId() + " WHERE id = " + this.id + ";");
			mibd.finalize();
			this.asignatura = asignatura;
		}
		
	}
	
	public Proyecto getProyecto() {
		return proyecto;
	}
	
	public void setProyecto(Proyecto proyecto) {
		BD mibd = new BD();
		if(proyecto == null) {
			mibd.Update("UPDATE ACTIVIDADES SET proyecto = NULL WHERE id = " + this.id + ";");
			mibd.finalize();
			this.proyecto = null;
		} else {
			mibd.Update("UPDATE ACTIVIDADES SET proyecto = " + proyecto.getId() + " WHERE id = " + this.id + ";");
			mibd.finalize();
			this.proyecto = proyecto;
		}
		
	}
	
	public static void setProyectoSimple(Proyecto proyecto, int id) {
		BD mibd = new BD();
		if(proyecto == null) {
			mibd.Update("UPDATE ACTIVIDADES SET proyecto = NULL WHERE id = " + id + ";");
		} else {
			mibd.Update("UPDATE ACTIVIDADES SET proyecto = " + proyecto.getId() + " WHERE id = " + id + ";");
		}
		mibd.finalize();
	}
	
	public ONG getOng() {
		return ong;
	}
	
	public void setOng(ONG ong) {
		BD mibd = new BD();
		mibd.Update("UPDATE ACTIVIDADES SET ong = '" + ong.getEmail() + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.ong = ong;
	}
}
