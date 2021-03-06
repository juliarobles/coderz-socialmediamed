package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Actividad;
import modelo.Proyecto;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class SeguroEliminarActividad extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public SeguroEliminarActividad(GestionActividades panel, Actividad actividad) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SeguroEliminarActividad.class.getResource("/resources/blanco.png")));
		setBounds(100, 100, 450, 197);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00BFEstas seguro de querer eliminar la actividad?");
		lblNewLabel.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 426, 32);
		contentPanel.add(lblNewLabel);
		
		JButton btnNoEliminar = new JButton("No eliminar");
		btnNoEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel.setEnabled(true);
				dispose();
			}
		});
		btnNoEliminar.setFocusable(false);
		btnNoEliminar.setBackground(new Color(51, 204, 204));
		btnNoEliminar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		btnNoEliminar.setBounds(44, 52, 355, 39);
		contentPanel.add(btnNoEliminar);
		
		JButton btnEliminarSoloProyecto = new JButton("Eliminar actividad");
		btnEliminarSoloProyecto.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		btnEliminarSoloProyecto.setBackground(new Color(51, 204, 204));
		btnEliminarSoloProyecto.setBounds(44, 101, 355, 39);
		contentPanel.add(btnEliminarSoloProyecto);
		
		btnEliminarSoloProyecto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				actividad.borrarActividad();
				panel.actualizarActividades();
				panel.establecerConsultado(null);
				btnNoEliminar.setVisible(false);
				btnEliminarSoloProyecto.setVisible(false);
				contentPanel.setEnabled(false);
				lblNewLabel.setBounds(10, 101, 426, 32);
				lblNewLabel.setText("Actividad eliminada correctamente");
				
				Timer timer = new Timer (6000, new ActionListener () 
				{ 
					@Override
					public void actionPerformed(ActionEvent e) {
						if(e.getWhen() >= 5000) {
							panel.setEnabled(true);
							dispose();
						}
					} 
				});
				timer.start();
				timer.setRepeats(false);
			}
		});
		
		
		
	}
}
