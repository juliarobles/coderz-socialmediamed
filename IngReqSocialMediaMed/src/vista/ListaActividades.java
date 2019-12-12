package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modelo.Actividad;
import modelo.Tupla;
import modelo.Usuario;

import javax.swing.JList;

public class ListaActividades extends JPanel {

	/**
	 * Create the panel.
	 */
	public ListaActividades(MenuPrincipal padre, Usuario usu) {
		this.setSize(1100,715);
		
		JLabel lblxb = new JLabel("<html>&larr;<html>");
		lblxb.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion
				//padre.cambiarGestor();
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblxb.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblxb.setForeground(Color.BLACK);
			}
		});
		setLayout(null);
		lblxb.setForeground(Color.BLACK);
		lblxb.setBounds(40, 5, 46, 56);
		lblxb.setFont(new Font("Tahoma", Font.PLAIN, 46));
		add(lblxb);
		
		JLabel lblNewLabel = new JLabel("Lista de actividades");
		lblNewLabel.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 34));
		lblNewLabel.setBounds(101, 62, 289, 46);
		add(lblNewLabel);
		
		JScrollPane sclActividades = new JScrollPane();
		sclActividades.setBounds(65, 131, 965, 544);
		add(sclActividades);
		
		
		
		List<Tupla> lista = Actividad.getActividadesDisponiblesSimple();
		Iterator <Tupla> iter = lista.iterator();
		DefaultListModel <String> listmodel = new DefaultListModel<String>();
		while(iter.hasNext()) {
			String a = iter.next().elemento1;
			listmodel.addElement(a);
		}
		JList<String> listaActividades = new JList<String>(listmodel);
		sclActividades.setViewportView(listaActividades);
	}
}
