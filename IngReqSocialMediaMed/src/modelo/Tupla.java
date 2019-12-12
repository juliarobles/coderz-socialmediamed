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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((elemento1 == null) ? 0 : elemento1.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tupla other = (Tupla) obj;
		if (elemento1 == null) {
			if (other.elemento1 != null)
				return false;
		} else if (!elemento1.equals(other.elemento1))
			return false;
		return true;
	}
	
	
	
}
