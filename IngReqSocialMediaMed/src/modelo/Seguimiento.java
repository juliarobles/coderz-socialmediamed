package modelo;

import java.util.List;

public class Seguimiento {
//AUN NO ESTA SINCRONIZADO CON LA BD
	//No usar aun
	private String usuario;
	private int actividad;
	private String comentarioPAR;
	private String comentarioPDI;
	private String comentarioONG;
	private double nota;
	private int numHoras;
	private Valoracion valoracionPAR;
	private Valoracion valoracionONG;
	
	/*
	public Seguimiento(Usuario usuario, Actividad actividad, String comentarioPAR, String comentarioPDI,
			String comentarioONG, int nota, int numHoras, Valoracion valoracionPAR, Valoracion valoracionONG) {
		BD mibd = new BD();
		mibd.Insert(usuario.getEmail());
		mibd.finalize();
		this.usuario = usuario;
		this.actividad = actividad;
		this.comentarioPAR = comentarioPAR;
		this.comentarioPDI = comentarioPDI;
		this.comentarioONG = comentarioONG;
		this.nota = nota;
		this.numHoras = numHoras;
		this.valoracionPAR = valoracionPAR;
		this.valoracionONG = valoracionONG;
	}
*/
	public Seguimiento(Usuario usuario, Actividad actividad) {
		BD mibd = new BD();
		List<Object[]> res = mibd.Select("SELECT * FROM SEGUIMIENTO WHERE usuario = '" + usuario.getEmail() + "' AND actividad = " + actividad.getId() + ";");
		if(res.isEmpty()) {
			mibd.Insert("INSERT INTO SEGUIMIENTO VALUES('" + usuario.getEmail() + "', " + actividad.getId() + ", ' ', ' ', ' ', -1, -1, 'No', 'No');");
			this.comentarioPAR = "";
			this.comentarioPDI = "";
			this.comentarioONG = "";
			this.nota = -1;
			this.numHoras = -1;
			this.valoracionPAR = Valoracion.No;
			this.valoracionONG = Valoracion.No;
		} else {
			Object[] tupla = res.get(0);
			this.comentarioPAR = (String)tupla[2];
			this.comentarioPDI = (String)tupla[3];
			this.comentarioONG = (String)tupla[4];
			this.nota = (double)tupla[5];
			this.numHoras = (int)tupla[6];;
			this.valoracionPAR = Valoracion.valueOf((String)tupla[7]);
			this.valoracionONG = Valoracion.valueOf((String)tupla[8]);
		}
		this.usuario = usuario.getEmail();
		this.actividad = actividad.getId();
	}
	
	public Seguimiento(String usuario, int actividad) {
		BD mibd = new BD();
		List<Object[]> res = mibd.Select("SELECT * FROM SEGUIMIENTO WHERE usuario = '" + usuario + "' AND actividad = " + actividad + ";");
		if(res.isEmpty()) {
			mibd.Insert("INSERT INTO SEGUIMIENTO VALUES('" + usuario + "', " + actividad + ", ' ', ' ', ' ', -1, -1, 'No', 'No');");
			mibd.finalize();
			this.comentarioPAR = "";
			this.comentarioPDI = "";
			this.comentarioONG = "";
			this.nota = -1;
			this.numHoras = -1;
			this.valoracionPAR = Valoracion.No;
			this.valoracionONG = Valoracion.No;
		} else {
			mibd.finalize();
			Object[] tupla = res.get(0);
			this.comentarioPAR = (String)tupla[2];
			this.comentarioPDI = (String)tupla[3];
			this.comentarioONG = (String)tupla[4];
			this.nota = (double)tupla[5];
			this.numHoras = (int)tupla[6];;
			this.valoracionPAR = Valoracion.valueOf((String)tupla[7]);
			this.valoracionONG = Valoracion.valueOf((String)tupla[8]);
		}
		this.usuario = usuario;
		this.actividad = actividad;
	}

	public String getComentarioPAR() {
		return comentarioPAR;
	}

	public void setComentarioPAR(String comentarioPAR) {
		BD mibd = new BD();
		mibd.Update("UPDATE SEGUIMIENTO SET comentarioPAR = '" + comentarioPAR + "' WHERE usuario = '" + this.usuario + "' AND actividad = " + this.actividad + ";");
		mibd.finalize();
		this.comentarioPAR = comentarioPAR;
	}

	public String getComentarioPDI() {
		return comentarioPDI;
	}

	public void setComentarioPDI(String comentarioPDI) {
		BD mibd = new BD();
		mibd.Update("UPDATE SEGUIMIENTO SET comentarioPDI = '" + comentarioPDI + "' WHERE usuario = '" + this.usuario + "' AND actividad = " + this.actividad + ";");
		mibd.finalize();
		this.comentarioPDI = comentarioPDI;
	}

	public String getComentarioONG() {
		return comentarioONG;
	}

	public void setComentarioONG(String comentarioONG) {
		BD mibd = new BD();
		mibd.Update("UPDATE SEGUIMIENTO SET comentarioONG = '" + comentarioONG + "' WHERE usuario = '" + this.usuario + "' AND actividad = " + this.actividad + ";");
		mibd.finalize();
		this.comentarioONG = comentarioONG;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		BD mibd = new BD();
		mibd.Update("UPDATE SEGUIMIENTO SET nota = " + nota + " WHERE usuario = '" + this.usuario + "' AND actividad = " + this.actividad + ";");
		mibd.finalize();
		this.nota = nota;
	}

	public int getNumHoras() {
		return numHoras;
	}

	public void setNumHoras(int numHoras) {
		BD mibd = new BD();
		mibd.Update("UPDATE SEGUIMIENTO SET numHoras = " + numHoras + " WHERE usuario = '" + this.usuario + "' AND actividad = " + this.actividad + ";");
		mibd.finalize();
		this.numHoras = numHoras;
	}

	public Valoracion getValoracionPAR() {
		return valoracionPAR;
	}

	public void setValoracionPAR(Valoracion valoracionPAR) {
		BD mibd = new BD();
		mibd.Update("UPDATE SEGUIMIENTO SET valoracionPAR = '" + valoracionPAR.toString() + "' WHERE usuario = '" + this.usuario + "' AND actividad = " + this.actividad + ";");
		mibd.finalize();
		this.valoracionPAR = valoracionPAR;
	}

	public Valoracion getValoracionONG() {
		return valoracionONG;
	}

	public void setValoracionONG(Valoracion valoracionONG) {
		BD mibd = new BD();
		mibd.Update("UPDATE SEGUIMIENTO SET valoracionONG = '" + valoracionONG.toString() + "' WHERE usuario = '" + this.usuario + "' AND actividad = " + this.actividad + ";");
		mibd.finalize();
		this.valoracionONG = valoracionONG;
	}

}
