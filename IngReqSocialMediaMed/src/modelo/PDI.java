package modelo;

public class PDI extends Usuario{
	
	private Asignatura[] asigImpartidas;
	private enum cargo{
		profesor, investigador
	}
	
	public Asignatura[] getAsigImpartidas() {
		return asigImpartidas;
	}
	public void setAsigImpartidas(Asignatura[] asigImpartidas) {
		this.asigImpartidas = asigImpartidas;
	}
}
