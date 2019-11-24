package modelo;

import java.util.ArrayList;
import java.util.List;

public class PDI extends Usuario{
	
	//private List<Asignatura> asigImpartidas;
	//private CargoPdi[] cargo;
	
	public PDI(String email) {
		super(email);
		// TODO Auto-generated constructor stub
	}

	//usar bd pa sacar las asignaturas impartidas
	public List<Asignatura> getAsigImpartidas(){
		List<Asignatura> asigImpartidas = new ArrayList<Asignatura>();
		
		return asigImpartidas;
	}
	
	/*
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
	*/
}
