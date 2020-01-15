package modelo;

import java.util.ArrayList;
import java.util.List;

public class Mensaje {
	
	private String emisor;
	private String receptor;
	private String mensaje;
	
	//Esta clase es distinta, con crear el constructor no se guarda el mensaje en la BD, usa los metodos static
	//No hay ni getter ni setter no hace falta
	//WANY, CUANDO QUIERAS ENVIAR O RECIBIR ALGO DEL GESTOR PON "gestor" COMO SI FUERA SU EMAIL
	//emisor y receptor son los email de cada uno de ellos
	//Si te hace falta alguna funcion dimelo
	
	public static List<Mensaje> getMensajes(String emisor, String receptor){
		List<Mensaje> lista = new ArrayList<Mensaje>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT emisor, receptor, mensaje FROM MENSAJE WHERE emisor = '" + emisor + "' AND receptor = '" + receptor +"' ORDER BY id;")) {
			lista.add(new Mensaje((String)tupla[0], (String)tupla[1], (String)tupla[2]));
		}
		mibd.finalize();
		return lista;
	}
	
	public static List<String> getChat(String usuario){
		List<String> lista = new ArrayList<String>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT receptor FROM MENSAJE WHERE emisor = '" + usuario + "' UNION SELECT emisor FROM MENSAJE WHERE receptor = '" + usuario + "';")) {
			lista.add((String)tupla[0]);
		}
		mibd.finalize();
		return lista;
	}
	
	public static void enviarMensaje(String emisor, String receptor, String mensaje){
		BD mibd = new BD();
		mibd.Insert("INSERT INTO MENSAJE (emisor, receptor, mensaje) VALUES('" + emisor + "', '" + receptor + "', '" + mensaje + "');");
		mibd.finalize();
	}

	public Mensaje(String emisor, String receptor, String mensaje) {
		this.emisor = emisor;
		this.receptor = receptor;
		this.mensaje = mensaje;
	}
	
	
}
