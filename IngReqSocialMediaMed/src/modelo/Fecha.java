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
