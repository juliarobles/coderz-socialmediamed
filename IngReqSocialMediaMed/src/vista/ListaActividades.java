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

import controlador.CtrListaActividades;
import modelo.Actividad;
import modelo.Tupla;
import modelo.Usuario;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaActividades extends JPanel {
	
	 private CtrListaActividades control;
	 private JList <Tupla> lista;
	 private JButton consultar;
	 
	 
	public JList<Tupla> getLista() {
		return lista;
	}


	public void setLista(JList<Tupla> lista) {
		this.lista = lista;
	}

	
	/**
	 * Create the panel.
	 */
	public ListaActividades(MenuPrincipal padre, Usuario usu) {
		
		control = new CtrListaActividades(padre, usu, this);
		this.setSize(1100,715);
		
		JLabel lblxb = new JLabel("<html>&larr;<html>");
		lblxb.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion
				//padre.cambiarGestor();
				padre.cambiarUsuario(usu);
				
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
		
		JLabel lblListaActividades = new JLabel("Lista de actividades");
		lblListaActividades.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 34));
		lblListaActividades.setBounds(101, 62, 289, 46);
		add(lblListaActividades);
		
		JScrollPane sclActividades = new JScrollPane();
		sclActividades.setBounds(65, 131, 965, 530);
		add(sclActividades);
		
		
		
		DefaultListModel <Tupla> listmodel = new DefaultListModel<Tupla>();
		System.out.println("Hola??????????????????????");
		for(Tupla t : Actividad.getActividadesSimple()) {
			System.out.println("A�adido elemento");
			listmodel.addElement(t);
		}
		JList<Tupla> listaActividades = new JList<Tupla>(listmodel);
		listaActividades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lista.getSelectedValue()==null) {
					consultar.setEnabled(false);
				}else {
					consultar.setEnabled(true);
				}
			}
		});
		sclActividades.setViewportView(listaActividades);
		lista = listaActividades;
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setEnabled(false);
		
		
		btnConsultar.setBounds(906, 78, 124, 34);
		add(btnConsultar);
		
		consultar = btnConsultar;
		btnConsultar.addMouseListener(control);
		
		
	}


	public JButton getConsultar() {
		return consultar;
	}


	public void setConsultar(JButton consultar) {
		this.consultar = consultar;
	}
}
