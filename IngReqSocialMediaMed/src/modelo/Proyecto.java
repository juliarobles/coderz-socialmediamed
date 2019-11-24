package modelo;

public class Proyecto {
	
	private int id;
	private String nombre;
	
	public Proyecto(int id) { //Saca un proyecto de la BD y lo guarda en un objeto
		BD mibd = new BD();
		Object[] tupla = mibd.Select("SELECT * FROM PROYECTO WHERE id = " + id + ";").get(0);
		mibd.finalize();
		this.id = (Integer) tupla[0];
		this.nombre = (String) tupla[1];
	}
	
	public Proyecto(String nombre) {
		BD mibd = new BD();
		mibd.Insert("INSERT INTO PROYECTO VALUES('" + nombre + "');");
		mibd.finalize();
		this.id = (Integer) mibd.SelectEscalar("SELECT MAX(id) FROM PROYECTO;");;
		this.nombre = nombre;
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
	
	
}
