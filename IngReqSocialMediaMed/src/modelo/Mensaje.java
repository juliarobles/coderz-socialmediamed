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
	//0 gestor, 1 participante, 2 ong 
	
	public static List<Mensaje> getMensajes(String emisor, String receptor){
		List<Mensaje> lista = new ArrayList<Mensaje>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT emisor, receptor, mensaje FROM MENSAJE WHERE emisor = '" + emisor + "' AND receptor = '" + receptor +"' ORDER BY id;")) {
			lista.add(new Mensaje((String)tupla[0], (String)tupla[1], (String)tupla[2]));
		}
		mibd.finalize();
		return lista;
	}
	
	public static List<Tupla> getChat(String usuario){
		List<Tupla> lista = new ArrayList<Tupla>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT receptor, tiporeceptor FROM MENSAJE WHERE emisor = '" + usuario + "' UNION SELECT emisor, tiporeceptor FROM MENSAJE WHERE receptor = '" + usuario + "';")) {
			int tipo = (int) tupla[1];
			if(tipo == 0) { //gestor
				lista.add(new Tupla((String)tupla[0], "Gestor"));
			} else if (tipo == 1) { //participante
				Object[] tupla2 = mibd.Select("SELECT nombre, apellido1, apellido2 FROM PARTICIPANTES WHERE email = '" + usuario + "';").get(0);
				lista.add(new Tupla((String)tupla[0], (String)tupla2[0] + " " + (String)tupla2[1] + " " + (String)tupla2[2]));
			} else if (tipo == 2) { //ong
				Object[] tupla2 = mibd.Select("SELECT nombre FROM USUARIOONG WHERE email = '" + usuario + "';").get(0);
				lista.add(new Tupla((String)tupla[0], (String)tupla2[0]));
			}
		}
		mibd.finalize();
		return lista;
	}
	
	//En tipo receptor tiene que poner 0 si es gestor, 1 si es participante y 2 si es ong
	public static void enviarMensaje(String emisor, String receptor, String mensaje, int tipoReceptor){
		BD mibd = new BD();
		mibd.Insert("INSERT INTO MENSAJE (emisor, receptor, mensaje, tipoReceptor) VALUES('" + emisor + "', '" + receptor + "', '" + mensaje + "', " + tipoReceptor + ");");
		mibd.finalize();
	}

	public Mensaje(String emisor, String receptor, String mensaje) {
		this.emisor = emisor;
		this.receptor = receptor;
		this.mensaje = mensaje;
	}
	
	
}
