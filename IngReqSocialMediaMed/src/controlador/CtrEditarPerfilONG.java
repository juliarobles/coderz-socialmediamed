package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import modelo.Fecha;
import modelo.Meses;
import modelo.ONG;
import vista.CrearPropuesta;
import vista.EditarPerfil;
import vista.EditarPerfilONG;
import vista.MenuPrincipal;
import vista.Toast;

public class CtrEditarPerfilONG implements MouseListener {
	private ONG ong;
	private MenuPrincipal padre;
	private EditarPerfilONG panel;
	
	public CtrEditarPerfilONG(ONG ong, MenuPrincipal padre, EditarPerfilONG panel) {
		this.ong = ong;
		this.padre = padre;
		this.panel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Object o = e.getSource();
		if((JLabel) o instanceof JLabel) {
			JLabel a = (JLabel) o;
			if(a.equals(panel.getGuardar())) {
				
				if(todoCorrecto().equals(" ")) {
					if(!panel.getTextoAntiguaPass().getText().trim().isEmpty() || !panel.getTextoNuevaPass().getText().trim().isEmpty()) {
						ong.setPass(panel.getTextoNuevaPass().getText());
					}
					
					ong.setNombre(panel.getTextoNombre().getText());
					ong.setDescripcion(panel.getTextoDescripcion().getText());
					panel.guardadoCorrectamente();
				}else {
					JFrame error = new Toast(todoCorrecto(), false);
					error.setVisible(true);
					panel.noGuardado();
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse pressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private String todoCorrecto() {
		String res = " ";
		if(panel.getTextoNombre().getText().trim().isEmpty()) res+= "Campo nombre obligatorio<br>";
		if(!panel.getTextoAntiguaPass().getText().trim().isEmpty() || !panel.getTextoNuevaPass().getText().trim().isEmpty()) {
			if(!ong.getPassword().equals(panel.getTextoAntiguaPass().getText().trim())) res+= "Contraseña antigua incorrecta<br>";
			if(panel.getTextoNuevaPass().getText().trim().isEmpty()) res+="Contraseña nueva no válida<br>";
		}
		if(panel.getTextoNombre().getText().length()>100 )res+= "Nombre demasiado largo(más de 100 caracteres) <br>";
		if(panel.getTextoDescripcion().getText().length()>255)res+= "Descripcion demasiado larga(más de 255 caracteres) <br>";
		
		
		//System.out.println(res);
		return res;
	}
}
