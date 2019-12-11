package modelo;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	
	private int id;
	private String nombre;
	private PDI pdi;
	
	public static List<Tupla> getProyectosSimple(){
		List<Tupla> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT id, nombre FROM PROYECTO")) {
			lista.add(new Tupla(Integer.toString((Integer) tupla[0]), (String) tupla[1]));
		}
		mibd.finalize();
		return lista;
	}
	
	public static List<Tupla> getActividadesSimple(int id) {
		List<Tupla> lista = new ArrayList<>();
		if(id > 0) {
			BD mibd = new BD();
			for(Object[] tupla : mibd.Select("SELECT id, titulo FROM ACTIVIDADES WHERE proyecto = " + id + ";")) {
				lista.add(new Tupla(Integer.toString((Integer) tupla[0]), (String) tupla[1]));
			}
			mibd.finalize();
		}
		return lista;
	}
	
	
	public Proyecto(int id) { //Saca un proyecto de la BD y lo guarda en un objeto
		BD mibd = new BD();
		Object[] tupla = mibd.Select("SELECT * FROM PROYECTO WHERE id = " + id + ";").get(0);
		mibd.finalize();
		this.id = (Integer) tupla[0];
		this.nombre = (String) tupla[1];
		this.pdi = new PDI((String) tupla[2]);
	}
	
	public Proyecto(String nombre, PDI pdi) {
		BD mibd = new BD();
		mibd.Insert("INSERT INTO PROYECTO (nombre, pdi) VALUES('" + nombre + "', '" + pdi.getEmail() + "');");
		this.id = (Integer) mibd.SelectEscalar("SELECT MAX(id) FROM PROYECTO;");
		mibd.finalize();
		this.nombre = nombre;
		this.pdi = pdi;
	}
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		BD mibd = new BD();
		mibd.Update("UPDATE PROYECTO SET nombre = '" + nombre + "' WHERE id = " + id + ";");
		mibd.finalize();
		this.nombre = nombre;
	}
	
	public PDI getPDI() {
		return pdi;
	}
	public void setPDI(PDI pdi) {
		BD mibd = new BD();
		mibd.Update("UPDATE PROYECTO SET pdi = '" + pdi + "' WHERE id = " + id + ";");
		mibd.finalize();
		this.pdi = pdi;
	}

	@Override
	public String toString() {
		return nombre;
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
		Proyecto other = (Proyecto) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	
	
}
