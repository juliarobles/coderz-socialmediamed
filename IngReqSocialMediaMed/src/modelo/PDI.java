package modelo;

public class PDI extends Usuario{
	
	private Asignatura[] asigImpartidas;
	private cargo[] Cargo;
	private enum cargo{
		profesor, investigador
	}
	
	public Asignatura[] getAsigImpartidas() {
		return asigImpartidas;
	}
	public void setAsigImpartidas(Asignatura[] asigImpartidas) {
		this.asigImpartidas = asigImpartidas;
	}
	public cargo[] getCargo() {
		return Cargo;
	}
	public void setCargo(cargo[] cargo) {
		this.Cargo = cargo;
	}
	
}
