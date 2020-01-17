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
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import utilidades.JPictureBox;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ListaActividades extends JPanel {
	
	 private CtrListaActividades control;
	 private JList <Tupla> lista;
	 private JButton consultar;
	 private JTextField busqueda;
	 
	 
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
		setBackground(Color.WHITE);
		DefaultListModel <Tupla> listmodel = new DefaultListModel<Tupla>();
		ImageIcon imglupa = new ImageIcon(PerfilUsuario2.class.getResource("/resources/lupita.png"));
		ImageIcon imglupaz = new ImageIcon(PerfilUsuario2.class.getResource("/resources/search.png"))
		;
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
		
		JPictureBox lupa = new JPictureBox();
		
		lupa.setBounds(857, 83, 24, 24);
		add(lupa);
		
		lupa.setIcon(imglupa);
		lupa.repaint();
		lupa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lupa.setIcon(imglupaz);
				lupa.repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lupa.setIcon(imglupa);
				lupa.repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				listmodel.clear();
				for(Tupla t : Actividad.getActividadesSimple()) {
					if(t.elemento2.contains(busqueda.getText())) {
						System.out.println(t.elemento2);
						System.out.println(busqueda.getText());
						System.out.println("Añadido elemento");
						listmodel.addElement(t);
					}
					
				}
				System.out.println("He añadido ");
			}
		});
		lblxb.setForeground(Color.BLACK);
		lblxb.setBounds(40, 5, 46, 56);
		lblxb.setFont(new Font("Tahoma", Font.PLAIN, 46));
		add(lblxb);
		
		JLabel lblListaActividades = new JLabel("Lista de actividades");
		lblListaActividades.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 30));
		lblListaActividades.setBounds(63, 71, 325, 46);
		add(lblListaActividades);
		
		JScrollPane sclActividades = new JScrollPane();
		sclActividades.setBorder(new EmptyBorder(0, 0, 0, 0));
		sclActividades.setBounds(65, 131, 965, 530);
		add(sclActividades);
		
		
		
		
		//System.out.println("Hola??????????????????????");
		for(Tupla t : Actividad.getActividadesSimple()) {
			System.out.println("Añadido elemento");
			listmodel.addElement(t);
		}
		JList<Tupla> listaActividades = new JList<Tupla>(listmodel);
		listaActividades.setBorder(new EmptyBorder(0, 0, 0, 0));
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
		
		busqueda = new JTextField();
		busqueda.setBounds(413, 78, 421, 34);
		add(busqueda);
		busqueda.setColumns(10);
		
		btnConsultar.addMouseListener(control);
		
		
	}


	public JButton getConsultar() {
		return consultar;
	}


	public void setConsultar(JButton consultar) {
		this.consultar = consultar;
	}
}
