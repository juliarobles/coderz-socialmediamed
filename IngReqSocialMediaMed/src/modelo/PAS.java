package modelo;


public class PAS extends Usuario{
	
	private OcupacionPas[] Ocupacion;
	
	public OcupacionPas[] getOcupacion() {
		return Ocupacion;
	}
	public void setOcupacion(OcupacionPas[] ocupacion) {
		this.Ocupacion = ocupacion;
	}
}
