package modelo;

public class Asignatura {
	
	private int id;
	private String nombre;
	
	
	public Asignatura(int id) { //Saca de la BD una asignatura
		BD mibd = new BD();
		Object[] tupla = mibd.Select("SELECT * FROM ASIGNATURAS WHERE id = " + id + ";").get(0);
		mibd.finalize();
		this.id = (Integer) tupla[0];
		this.nombre = (String) tupla[1];
	}


	public Asignatura(String nombre) { //Añade a la BD una nueva asignatura y crea el objeto correspondiente
		BD mibd = new BD();
		mibd.Insert("INSERT INTO ASIGNATURAS VALUES ('" + nombre + "');");
		mibd.finalize();
		this.id = (Integer) mibd.SelectEscalar("SELECT MAX(id) FROM ASIGNATURAS;");;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		BD mibd = new BD();
		mibd.Update("UPDATE ASIGNATURAS SET nombre = '" + nombre + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.nombre = nombre;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	
}
