package vista;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pruebas {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pruebas window = new Pruebas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pruebas() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnCambiarFoto = new JButton("Cambiar foto");
		btnCambiarFoto.setBounds(172, 209, 89, 23);
		frame.getContentPane().add(btnCambiarFoto);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(110, 55, 100, 100);
		frame.getContentPane().add(lblImagen);
		btnCambiarFoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setDialogTitle("Añadir imagen");
				
				if(fc.showOpenDialog(frame)== JFileChooser.APPROVE_OPTION) {
					//File archivo = new File(fc.getSelectedFile().toString());
					
					//Falta añadir la libreria RSScaleLabel para poder reescalar la imagen 
					
					rsscalelabel.RSScaleLabel.setScaleLabel(lblImagen, fc.getSelectedFile().toString());
				}
			}
		});
		
		
	
	}
}
