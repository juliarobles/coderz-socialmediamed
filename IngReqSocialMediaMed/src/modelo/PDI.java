package modelo;

public class PDI extends Usuario{
	
	private Asignatura[] asigImpartidas;
	private CargoPdi[] cargo;
	public Asignatura[] getAsigImpartidas() {
		return asigImpartidas;
	}
	public void setAsigImpartidas(Asignatura[] asigImpartidas) {
		this.asigImpartidas = asigImpartidas;
	}
	public CargoPdi[] getCargo() {
		return cargo;
	}
	public void setCargo(CargoPdi[] cargo) {
		this.cargo = cargo;
	}
	
}
