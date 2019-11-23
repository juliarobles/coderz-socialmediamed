package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ConsultaiDuma {
	private String urlBase;
	private String c, codigo;
	
	public ConsultaiDuma() {
		urlBase = "http://idumamockup-env.3mca2qexfx.eu-central-1.elasticbeanstalk.com/getuser/";
		codigo = "";
	}
	
	public boolean existe(String user, String pass) {
		boolean existe = true;
		try {
			URL consulta = new URL(urlBase + user + "/" + pass);
			BufferedReader entrada = new BufferedReader(new InputStreamReader(consulta.openStream()));
			c = entrada.readLine();
			
			while (c != null) {
				codigo = codigo + c;
				c = entrada.readLine();
			}
			
			if (codigo.contains("ABSENT")) existe = false;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return existe;
	}
}
