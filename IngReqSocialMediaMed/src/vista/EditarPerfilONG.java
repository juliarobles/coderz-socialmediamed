package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import controlador.CtrCrearPropuesta;
import controlador.CtrEditarPerfilONG;
import modelo.ONG;
import utilidades.JPictureBox;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EditarPerfilONG extends JPanel {
	private CtrEditarPerfilONG control;
	private JTextField textoNombre;
	private JTextField textoAntiguaPass;
	private JTextField textoNuevaPass;
	private JTextArea textoDescripcion;
	private JLabel guardar;
	private JLabel correcto;

	/**
	 * Create the panel.
	 */
	public EditarPerfilONG(MenuPrincipal padre, ONG ong) {
		control = new CtrEditarPerfilONG( ong, padre, this);
		ImageIcon imgasm = new ImageIcon(PerfilUsuario2.class.getResource("/resources/_Logo AccionSocialMed png.png"));
		setBackground(Color.WHITE);
		this.setSize(1100,715);	
		setLayout(null);
		
		JPictureBox imagenASM = new JPictureBox();
		imagenASM.setBounds(135, 53, 140, 140);
		imagenASM.setIcon(imgasm);
		add(imagenASM);
		imagenASM.repaint();
		
		JLabel lblLimiteCaracteres = new JLabel("");
		lblLimiteCaracteres.setForeground(Color.GRAY);
		lblLimiteCaracteres.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		lblLimiteCaracteres.setBounds(789, 96, 46, 14);
		add(lblLimiteCaracteres);
		lblLimiteCaracteres.setText( ong.getNombre().length()+ "/" + 100);
		
		
		JLabel lblxb = new JLabel("<html>&larr;<html>");
		lblxb.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana gestion
				//padre.cambiarGestor();
				padre.cambiarAPerfilONG(ong, false);
				
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
		
		
		JPanel panelEditarPerfil = new JPanel();
		panelEditarPerfil.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelEditarPerfil.setBounds(630, 457, 200, 50);
		panelEditarPerfil.setBackground(new Color(17,92,161));
		add(panelEditarPerfil);
		panelEditarPerfil.setLayout(null);
		
		JLabel lblEditarPerfil = new JLabel("Guardar");
		guardar = lblEditarPerfil;
		
	
		lblEditarPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				Border bordeAbajo = new BevelBorder(1);
				
				panelEditarPerfil.setBorder(bordeAbajo);
				
				
				//panelEditarPerfil.setBorder(bordeArriba);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Border bordeArriba = new BevelBorder(0);
				panelEditarPerfil.setBorder(bordeArriba);
				//Cambiar a editar perfil
				//padre.cambiarAEditarONG(ong);
				//dispose();
				
			}
		});
		
		lblEditarPerfil.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEditarPerfil.setBounds(0, 0, 200, 50);
		panelEditarPerfil.add(lblEditarPerfil);
		lblEditarPerfil.setForeground(Color.WHITE);
		lblEditarPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarPerfil.setBackground(new Color(93,103,175));
		lblxb.setForeground(Color.BLACK);
		lblxb.setBounds(40, 10, 52, 51);
		lblxb.setFont(new Font("Tahoma", Font.PLAIN, 46));
		add(lblxb);
		
		JLabel fotoONG = new JLabel("FOTO ONG");
		fotoONG.setOpaque(true);
		fotoONG.setHorizontalAlignment(SwingConstants.CENTER);
		fotoONG.setBounds(135, 221, 140, 183);
		add(fotoONG);
		fotoONG.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblNombreONG = new JLabel("Nombre:");
		lblNombreONG.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblNombreONG.setBounds(304, 92, 53, 20);
		add(lblNombreONG);
		
		JLabel lblCorrecto = new JLabel("\u00A1Guardado correctamente!");
		lblCorrecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorrecto.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblCorrecto.setForeground(Color.GREEN);
		lblCorrecto.setBounds(630, 518, 200, 20);
		add(lblCorrecto);
		lblCorrecto.setVisible(false);
		correcto = lblCorrecto;
		textoNombre = new JTextField();
		textoNombre.setBounds(365, 92, 414, 20);
		add(textoNombre);
		textoNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblDescripcion.setBounds(284, 155, 73, 20);
		add(lblDescripcion);
		
		JScrollPane panelDescripcion = new JScrollPane();
		panelDescripcion.setBounds(365, 155, 593, 249);
		add(panelDescripcion);
		
		JTextArea sclDescripcion = new JTextArea();
		textoDescripcion = sclDescripcion;
		panelDescripcion.setViewportView(sclDescripcion);
		
		JLabel lblCopyright = new JLabel("2019 AccionSocialMed\u00AE es una marca registrada de CoderZ. Reservados todos los derechos. Versi\u00F3n 2.1.29.15");
		lblCopyright.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCopyright.setForeground(Color.BLACK);
		lblCopyright.setBounds(10, 660, 620, 14);
		add(lblCopyright);
		
		JLabel lblAntiguaPass = new JLabel("Antigua contrase\u00F1a");
		lblAntiguaPass.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblAntiguaPass.setBounds(135, 457, 117, 20);
		add(lblAntiguaPass);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contrase\u00F1a");
		lblNuevaContrasea.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblNuevaContrasea.setBounds(143, 521, 109, 20);
		add(lblNuevaContrasea);
		
		JLabel lblLimiteCaracteresDescripcion = new JLabel("9/100");
		lblLimiteCaracteresDescripcion.setForeground(Color.GRAY);
		lblLimiteCaracteresDescripcion.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		lblLimiteCaracteresDescripcion.setBounds(968, 390, 46, 14);
		add(lblLimiteCaracteresDescripcion);
		 lblLimiteCaracteresDescripcion.setText( ong.getDescripcion().length()+ "/" + 255);
		
		
		textoAntiguaPass = new JTextField();
		textoAntiguaPass.setBounds(271, 457, 174, 20);
		add(textoAntiguaPass);
		textoAntiguaPass.setColumns(10);
		
		textoNuevaPass = new JTextField();
		textoNuevaPass.setColumns(10);
		textoNuevaPass.setBounds(271, 521, 174, 20);
		add(textoNuevaPass);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(EditarPerfilONG.class.getResource("/resources/fondo 6 asm.png")));
		fondo.setBounds(0, 0, 1100, 715);
		add(fondo);
	    
		guardar.addMouseListener(control);
		this.textoNombre.setText(ong.getNombre());
		this.textoDescripcion.setText(ong.getDescripcion());
		
		textoNombre.addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent e) {
				 int limite  = 100;
				
					if (textoNombre.getText().length()== limite)
					     e.consume();
					
					
				if(textoNombre.getText().length()>limite) {
					textoNombre.setText(textoNombre.getText().substring(0, limite));
					e.consume();
				}
				 lblLimiteCaracteres.setText( (textoNombre.getText().length())+ "/" + limite);
				
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				int limite = 100;
				lblLimiteCaracteres.setText( (textoNombre.getText().length())+ "/" + limite);
				if(e.getKeyCode()==8) {
					
				}else
				if (textoNombre.getText().length()>= limite) e.consume();
				
			}
		});
		

	    this.textoDescripcion.addKeyListener(new KeyAdapter() {
	    	@Override
			public void keyReleased(KeyEvent e) {
				 int limite  = 255;
				
					if (textoDescripcion.getText().length()== limite)
					     e.consume();
					
					
				if(textoDescripcion.getText().length()>limite) {
					textoDescripcion.setText(textoDescripcion.getText().substring(0, limite));
					e.consume();
				}
				 lblLimiteCaracteresDescripcion.setText( (textoDescripcion.getText().length())+ "/" + limite);
				
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				int limite = 250;
				lblLimiteCaracteresDescripcion.setText( (textoDescripcion.getText().length())+ "/" + limite);
				if(e.getKeyCode()==8) {
					
				}else
				if (textoDescripcion.getText().length()>= limite) e.consume();
				
			}
	    });
	
	}

	public JTextArea getTextoDescripcion() {
		return textoDescripcion;
	}

	public void setTextoDescripcion(JTextArea textoDescripcion) {
		this.textoDescripcion = textoDescripcion;
	}

	public JTextField getTextoNombre() {
		return textoNombre;
	}

	public void setTextoNombre(JTextField textoNombre) {
		this.textoNombre = textoNombre;
	}

	public JTextField getTextoAntiguaPass() {
		return textoAntiguaPass;
	}

	public void setTextoAntiguaPass(JTextField textoAntiguaPass) {
		this.textoAntiguaPass = textoAntiguaPass;
	}

	public JTextField getTextoNuevaPass() {
		return textoNuevaPass;
	}

	public void setTextoNuevaPass(JTextField textoNuevaPass) {
		this.textoNuevaPass = textoNuevaPass;
	}

	public JLabel getGuardar() {
		return guardar;
	}

	public void setGuardar(JLabel guardar) {
		this.guardar = guardar;
	}
	public void guardadoCorrectamente() {
		correcto.setVisible(true);
		System.out.println("Cambios guardados correctamente");
	}

	public void noGuardado() {
		 correcto.setVisible(false);
		  System.out.println("Cambios no guardados ");
		 
		
	}
}
