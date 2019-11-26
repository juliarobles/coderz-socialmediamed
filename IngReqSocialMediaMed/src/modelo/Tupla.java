package modelo;

public class Tupla {
	public String elemento1;
	public String elemento2;
	
	public Tupla(String elemento1, String elemento2) {
		this.elemento1 = elemento1;
		this.elemento2 = elemento2;
	}

	@Override
	public String toString() {
		return elemento2;
	}
	
}
