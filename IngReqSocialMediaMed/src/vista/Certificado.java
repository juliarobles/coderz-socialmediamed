package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Actividad;
import modelo.PDI;
import modelo.Usuario;

import java.awt.Color;
import utilidades.JPictureBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Certificado extends JDialog {

	private final JPanel contentPanel = new JPanel();

	

	/**
	 * Create the dialog.
	 */
	public Certificado(Actividad a, Usuario usu) {
		setBounds(100, 100, 721, 539);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel nombre = new JLabel("nombre");
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 29));
		nombre.setBounds(138, 175, 431, 35);
		nombre.setText(usu.getNombre() + " " + usu.getApellido1() + " " + usu.getApellido1());
		contentPanel.add(nombre);
		
		JLabel lblPorHaberRealizado = new JLabel("Por haber realizado la actividad");
		lblPorHaberRealizado.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorHaberRealizado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPorHaberRealizado.setBounds(138, 224, 431, 35);
		contentPanel.add(lblPorHaberRealizado);
		
		JLabel titulo = new JLabel("titulo");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		titulo.setBounds(138, 245, 431, 35);
		titulo.setText(a.getTitulo());
		contentPanel.add(titulo);
		
		JLabel lblDeInicioA = new JLabel("De " + a.getFechainicio() + " a " + a.getFechafinal());
		lblDeInicioA.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeInicioA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDeInicioA.setBounds(138, 269, 431, 35);
		contentPanel.add(lblDeInicioA);
		
		JLabel nombreONG = new JLabel("nombreONG");
		nombreONG.setHorizontalAlignment(SwingConstants.CENTER);
		nombreONG.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nombreONG.setBounds(62, 360, 247, 35);
		nombreONG.setText(a.getOng().getNombre());
		contentPanel.add(nombreONG);
		
		JLabel nombrepdi = new JLabel("nombrePDI");
		nombrepdi.setHorizontalAlignment(SwingConstants.CENTER);
		nombrepdi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nombrepdi.setBounds(388, 360, 247, 35);
		if(a.getAsignatura() != null) {
			PDI cargo = a.getAsignatura().getPDICargo();
			nombrepdi.setText(cargo.getNombre() + " " + cargo.getApellido1() + " " + cargo.getApellido2());
		} else if (a.getInvestigador() != null) {
			PDI cargo = a.getInvestigador();
			nombrepdi.setText(cargo.getNombre() + " " + cargo.getApellido1() + " " + cargo.getApellido2());
		} else {
			nombrepdi.setText("");
		}
		contentPanel.add(nombrepdi);
		
		JPictureBox pictureBox = new JPictureBox();
		pictureBox.setBounds(0, 0, 707, 502);
		pictureBox.setIcon(new ImageIcon(Certificado.class.getResource("/resources/plantillas-certificados-diplomas-2.png")));
		contentPanel.add(pictureBox);
		
		
	}
}
