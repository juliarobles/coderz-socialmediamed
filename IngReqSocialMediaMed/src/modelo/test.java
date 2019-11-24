package modelo;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BD mibd = new BD();
		
		mibd.Insert("INSERT INTO USUARIO VALUES ('HOLA','hola',1213,'s','f','d');");
		System.out.println("ha funcionao");
	}

}
