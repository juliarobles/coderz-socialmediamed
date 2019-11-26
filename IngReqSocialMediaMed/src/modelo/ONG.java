package modelo;

import java.util.ArrayList;
import java.util.List;

public class ONG {
	
	private String email;
	private String nombre;
	private String descripcion;
	
	public static List<ONG> getTodasONG() {
		List<ONG> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT email FROM USUARIOONG")) {
			lista.add(new ONG((String)tupla[0]));
		}
		mibd.finalize();
		return lista;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
	public ONG(String email) {
		BD mibd = new BD();
		Object[] tupla = mibd.Select("SELECT * FROM USUARIOONG WHERE email = '" + email + "';").get(0);
		mibd.finalize();
		this.email = (String) tupla[0];
		this.nombre = (String) tupla[1];
		this.descripcion = (String) tupla[2];
		
	}
	
	public ONG(String email, String pass, String nombre, String descripcion) {
		BD mibd = new BD();
		mibd.Insert("INSERT INTO USUARIOONG VALUES('" + email + "', '" + pass + "', '" + nombre + "', '" + descripcion +"');");
		mibd.finalize();
		this.email = email;
		this.nombre = nombre;
		this.descripcion = descripcion;
		
	}
	
	public void setPass(String pass) { //No guardamos la pass como variable por privacidad
		BD mibd = new BD();
		mibd.Update("UPDATE USUARIOONG SET pass = '" + pass + "' WHERE email = '" + this.email +"';");
		mibd.finalize();
	}
	
	
	public String getEmail() {
		return email;
	}
	/*
	public void setEmail(String email) {
		this.email = email; //No puede cambiar su email
	}
	*/
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		BD mibd = new BD();
		mibd.Update("UPDATE USUARIOONG SET nombre = '" + nombre + "' WHERE email = '" + this.email +"';");
		mibd.finalize();
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		BD mibd = new BD();
		mibd.Update("UPDATE USUARIOONG SET descripcion = '" + descripcion + "' WHERE email = '" + this.email +"';");
		mibd.finalize();
		this.descripcion = descripcion;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		ONG other = (ONG) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
}
