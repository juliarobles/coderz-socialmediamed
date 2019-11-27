package modelo;

public class Fecha {
	private int dia;
	private Meses mes;
	private int a�o;
	
	public Fecha(int dia, Meses mes, int a�o) {
		this.dia = dia; 
		this.mes = mes;
		this.a�o = a�o;
	}
	//Esta funci�n comprueba si es correcta la disposici�n de las fechas. 
	//Si la fecha que invoca a la funcion es igual o anterior a la fecha de los parametros
	public boolean igualOAnterior(Fecha f) {
		boolean res = true;
		if(this.getA�o() > f.getA�o()) {
			res = false;
		}else if(this.getA�o()==this.getA�o()) {
			if(this.getMes().ordinal()> f.getMes().ordinal()) {
				res = false;
			}else {
				if(this.getMes()==f.getMes()) {
					if(this.getDia()>f.getDia()) {
						res = false;
					}
				}
			}
		}
		return res;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public Meses getMes() {
		return mes;
	}
	public void setMes(Meses mes) {
		this.mes = mes;
	}
	public int getA�o() {
		return a�o;
	}
	public void setA�o(int a�o) {
		this.a�o = a�o;
	}
	public static int comprobarDias(Meses mes) {
		int res = 0;
		if(mes.equals(Meses.Febrero)) {
			res = 28;
		}else if(mes.equals(Meses.Abril)||mes.equals(Meses.Junio)||mes.equals(Meses.Septiembre)||
				mes.equals(Meses.Noviembre)) {
			res = 30;
		}else {
			res = 31;
		}
		return res;
	}
	public String toString() {
		
		return dia + "/" + mes.ordinal() + "/" + a�o;
	}
}
