package modelo;

public class Seguimiento {
//AUN NO ESTA SINCRONIZADO CON LA BD
	//No usar aun
	private String comentariosAlu;
	private String comentariosPdi;
	private String comentariosOng;
	private int nota;
	private int numHoras;
	
	public String getComentariosAlu() {
		return comentariosAlu;
	}
	public void setComentariosAlu(String comentariosAlu) {
		this.comentariosAlu = comentariosAlu;
	}
	public String getComentariosPdi() {
		return comentariosPdi;
	}
	public void setComentariosPdi(String comentariosPdi) {
		this.comentariosPdi = comentariosPdi;
	}
	public String getComentariosOng() {
		return comentariosOng;
	}
	public void setComentariosOng(String comentariosOng) {
		this.comentariosOng = comentariosOng;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public int getNumHoras() {
		return numHoras;
	}
	public void setNumHoras(int numHoras) {
		this.numHoras = numHoras;
	}
	

}
