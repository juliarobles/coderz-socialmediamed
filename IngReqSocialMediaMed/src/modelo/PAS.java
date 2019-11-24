package modelo;


public class PAS extends Usuario{
	
	public PAS(String email) {
		super(email);
		// TODO Auto-generated constructor stub
	}
	private OcupacionPas[] Ocupacion;
	
	public OcupacionPas[] getOcupacion() {
		return Ocupacion;
	}
	public void setOcupacion(OcupacionPas[] ocupacion) {
		this.Ocupacion = ocupacion;
	}
}
