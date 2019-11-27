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
	
	public static int getId(String nombre) { //Saca de la BD una asignatura
		BD mibd = new BD();
		Object[] tupla = mibd.Select("SELECT id FROM ASIGNATURAS WHERE nombre = '" + nombre + "';").get(0);
		mibd.finalize();
		return (Integer) tupla[0];
	}

	public Asignatura(String nombre) { //Añade a la BD una nueva asignatura y crea el objeto correspondiente
		BD mibd = new BD();
		mibd.Insert("INSERT INTO ASIGNATURAS (nombre) VALUES ('" + nombre + "');");
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Asignatura other = (Asignatura) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
}
