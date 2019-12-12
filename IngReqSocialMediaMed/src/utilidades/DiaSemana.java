package utilidades;

import java.util.Calendar;

public class DiaSemana {
	public static String diaSemana(int dia, int mes, int ano)
	   {
	    String letraD="";
	    int nD =-1;
	    Calendar c = Calendar.getInstance();

	    c.set(ano, mes, dia);
	    nD=c.get(Calendar.DAY_OF_WEEK); 
	    switch (nD){
	        case 1: letraD = "D";
	            break;
	        case 2: letraD = "L";
	            break;
	        case 3: letraD = "M";
	            break;
	        case 4: letraD = "X";
	            break;
	        case 5: letraD = "J";
	            break;
	        case 6: letraD = "V";
	            break;
	        case 7: letraD = "S";
	            break;
	    }

	    return letraD;
	}
}
