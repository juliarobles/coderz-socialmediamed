package modelo;


public class PAS extends Usuario{
	
	private ocupacion[] Ocupacion;
	private enum ocupacion{ //completar con más
		Conserje, Secretario, Administrativo, Tecnicos
	}
	
	public ocupacion[] getOcupacion() {
		return Ocupacion;
	}
	public void setOcupacion(ocupacion[] ocupacion) {
		this.Ocupacion = ocupacion;
	}
}
