package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConsultaiDuma {
	private String urlBase;
	private String c, codigo;
	private JsonParser parser;
	private JsonObject datos;
	
	public ConsultaiDuma() {
		urlBase = "http://idumamockup-env.3mca2qexfx.eu-central-1.elasticbeanstalk.com/getuser/";
		codigo = "";
		parser = new JsonParser();
	}
	
	public boolean consultar(String user, String pass) {
		Boolean res = null;
		try {
			URL consulta = new URL(urlBase + user + "/" + pass);
			BufferedReader entrada = new BufferedReader(new InputStreamReader(consulta.openStream()));
			c = entrada.readLine();
			
			while (c != null) {
				codigo = codigo + c;
				c = entrada.readLine();
			}

			datos = parser.parse(codigo).getAsJsonObject();
			res = datos.get("situation").toString().equals("\"PRESENT\"");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	/*
	public boolean existe(String user, String pass) {
		consultar(user, pass);
		return datos.get("situation").toString().equals("\"PRESENT\"");
	}
	*/
}
