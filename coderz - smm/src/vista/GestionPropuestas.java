package vista;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import modelo.ONG;
import modelo.Propuesta;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestionPropuestas extends JPanel {

	/**
	 * Create the panel.
	 */
	public GestionPropuestas() {
		setSize(new Dimension(1100, 715));
		
		JLabel lblGestinDePropuestas = new JLabel("Gesti\u00F3n de propuestas");
		lblGestinDePropuestas.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestinDePropuestas.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 31));
		
		
		DefaultListModel<Propuesta> listapropuestas = new DefaultListModel<Propuesta>();
		for(Propuesta p : Propuesta.getPropuestas()) {
			listapropuestas.addElement(p);
		}
		JList<Propuesta> propuesta = new JList<Propuesta>(listapropuestas);
		propuesta.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		propuesta.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		
		DefaultListModel<ONG> listaong = new DefaultListModel<ONG>();
		for(ONG o : ONG.getTodasONG()) {
			listaong.addElement(o);
		}
		
		JList<ONG> ong = new JList<ONG>(listaong);
		ong.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		ong.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		
		JLabel lblPropuestas = new JLabel("Filtra por ONG");
		lblPropuestas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPropuestas.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		
		JLabel label = new JLabel("Propuestas");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		
		JLabel vertodo = new JLabel("Ver todas las propuestas");
		vertodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//propuesta = new JList<Propuesta>(listapropuestas);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				vertodo.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				vertodo.setForeground(Color.BLACK);
			}
		});
		vertodo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblGestinDePropuestas, GroupLayout.PREFERRED_SIZE, 1100, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(lblPropuestas, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(vertodo, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(ong, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(propuesta, GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)))
					.addGap(28))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblGestinDePropuestas)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPropuestas, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(ong, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE)
						.addComponent(propuesta, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(vertodo)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
