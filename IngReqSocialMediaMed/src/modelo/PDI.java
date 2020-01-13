package modelo;

import java.util.ArrayList;
import java.util.List;

public class PDI extends Usuario{

	public static List<Tupla> getPDISimple(){
		List<Tupla> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT pdi.email, pa.nombre, pa.apellido1, pa.apellido2 FROM PDI pdi INNER JOIN PARTICIPANTES pa ON pdi.email = pa.email")) {
			lista.add(new Tupla((String) tupla[0], (String) tupla[1] + " " + (String) tupla[2] + " " + (String) tupla[3]));
		}
		mibd.finalize();
		return lista;
	}
	
	
	public PDI(String email, String nombre, String apellido1, String apellido2, int telefono,
			Disponibilidad disponibilidad, TipoOferta tipoOferta, ZonaAccion zonaAccion, String url,
			String descripcion, Ambito ambito) {
		super(email, nombre, apellido1, apellido2, telefono, disponibilidad, tipoOferta, zonaAccion, url, descripcion, ambito);
		BD mibd = new BD();
		mibd.Insert("INSERT INTO PDI VALUES ('" + email + "');");
	}

	public PDI(String email, String nombre, String apellido1, String apellido2) {
		super(email, nombre, apellido1, apellido2);
		BD mibd = new BD();
		mibd.Insert("INSERT INTO PDI VALUES ('" + email + "');");
	}

	public PDI(String email) {
		super(email);

	}
	
	public void BorrarPDI() {
		BD mibd = new BD();
		mibd.Delete("DELETE FROM IMPARTIR WHERE pdi = '" + email + "';");
		mibd.Delete("DELETE FROM PDI WHERE email = '" + email + "';");
		mibd.finalize();
		this.BorrarUsuario();
	}
	
	
}
