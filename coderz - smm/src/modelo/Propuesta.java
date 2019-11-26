package modelo;

import java.util.ArrayList;
import java.util.List;

public class Propuesta {
	private int id;
	private String titulo;
	private String descripcion;
	private String fechainicial;
	private String fechafinal;
	private ONG ong;
	
	public static List<Propuesta> getPropuestas() {
		List<Propuesta> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT id FROM PROPUESTA")) {
			lista.add(new Propuesta((Integer)tupla[0]));
		}
		mibd.finalize();
		return lista;
	}
	
	@Override
	public String toString() {
		return titulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propuesta other = (Propuesta) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public static List<Propuesta> getPropuestasFiltrado(ONG ong) {
		List<Propuesta> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT id FROM PROPUESTA WHERE ong = '" + ong.getEmail() +"';")) {
			lista.add(new Propuesta((Integer)tupla[0]));
		}
		mibd.finalize();
		return lista;
	}
	
	public Propuesta(int id) {
		BD mibd = new BD();
		Object[] tupla = mibd.Select("SELECT * FROM PROPUESTA WHERE id = " + id + ";").get(0);
		mibd.finalize();
		this.id = (Integer) tupla[0];
		this.titulo = (String) tupla[1];
		this.descripcion = (String) tupla[2];
		this.fechainicial = (String) tupla[3];
		this.fechafinal = (String) tupla[4];
		this.ong = new ONG((String) tupla[5]);
	}

	public Propuesta(int id, String titulo, String descripcion, String fechainicial, String fechafinal, ONG ong) {
		BD mibd = new BD();
		mibd.Insert("INSERT INTO PROPUESTA VALUES('" + titulo + "', '" + descripcion + "', '" + fechainicial 
				+ "', '" + fechafinal + "', '" + ong.getEmail() + "');");
		this.id = (Integer) mibd.SelectEscalar("SELECT MAX(id) FROM PROPUESTA;");
		mibd.finalize();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechainicial = fechainicial;
		this.fechafinal = fechafinal;
		this.ong = ong;
	}
	
	public void eliminarPropuesta() {
		BD mibd = new BD();
		mibd.Delete("DELETE FROM PROPUESTA WHERE id = " + id + ";");
		mibd.finalize();
		this.id = -1;
		this.titulo = null;
		this.descripcion = null;
		this.fechainicial = null;
		this.fechafinal = null;
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
		mibd.Update("UPDATE PROPUESTA SET titulo = '" + titulo + "' WHERE id = " + id +";");
		mibd.finalize();
		this.titulo = titulo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		BD mibd = new BD();
		mibd.Update("UPDATE PROPUESTA SET descripcion = '" + descripcion + "' WHERE id = " + id +";");
		mibd.finalize();
		this.descripcion = descripcion;
	}
	
	public String getFechainicial() {
		return fechainicial;
	}
	
	public void setFechainicial(String fechainicial) {
		BD mibd = new BD();
		mibd.Update("UPDATE PROPUESTA SET fechainicial = '" + fechainicial + "' WHERE id = " + id +";");
		mibd.finalize();
		this.fechainicial = fechainicial;
	}
	
	public String getFechafinal() {
		return fechafinal;
	}
	
	public void setFechafinal(String fechafinal) {
		BD mibd = new BD();
		mibd.Update("UPDATE PROPUESTA SET fechafinal = '" + fechafinal + "' WHERE id = " + id +";");
		mibd.finalize();
		this.fechafinal = fechafinal;
	}
	
	public ONG getOng() {
		return ong;
	}
	
	public void setOng(ONG ong) {
		BD mibd = new BD();
		mibd.Update("UPDATE PROPUESTA SET ong = '" + ong.getEmail() + "' WHERE id = " + id +";");
		mibd.finalize();
		this.ong = ong;
	}
}
