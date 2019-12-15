package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Actividad;
import modelo.Usuario;
import vista.ListaActividades;
import vista.MenuPrincipal;

public class CtrListaActividades extends JPanel implements MouseListener{
	private MenuPrincipal padre;
	private Usuario usu;
	private ListaActividades panel;
	
	/**
	 * Create the panel.
	 */
	public CtrListaActividades(MenuPrincipal padre, Usuario usu, ListaActividades panel) {
		this.padre = padre;
		this.usu = usu;
		this.panel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if((JButton) o instanceof JButton) {
			JButton a = (JButton) o;
			if(a.equals(panel.getConsultar())) {
				padre.cambiarAConsultarActividad(new Actividad(Integer.parseInt(panel.getLista().getSelectedValue().elemento1)), usu);   //Valor para iniciar la vista de consultar actividad.
				
				
			}
		}
			
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

}
