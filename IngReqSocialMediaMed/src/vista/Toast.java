package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import utilidades.JPictureBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;

public class Toast extends JFrame {

	/**
	 * Create the panel.
	 */
	public Toast(String prob, boolean corr) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Error");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Toast.class.getResource("/resources/error.png")));
		ImageIcon error = new ImageIcon(PerfilUsuario2.class.getResource("/resources/error.png"));
		ImageIcon correcto = new ImageIcon(PerfilUsuario2.class.getResource("/resources/tick.png"));
		JPictureBox imagenError = new JPictureBox();
		imagenError.setBounds(34, 60, 49, 49);
	
		
		

		setBounds(10, 10, 510, 220);
		this.setLocation(SwingConstants.CENTER, SwingConstants.CENTER);
		
		JLabel lblError = new JLabel();
		lblError.setBounds(93, 11, 293, 31);
		lblError.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		
		if(corr) {
			this.setIconImage(correcto.getImage());
			this.setTitle("Todo correcto");
			lblError.setText("Todo correcto");
			//lblError.setSize(lblError.getPreferredSize());
			imagenError.setIcon(correcto);
			imagenError.repaint();
		}else {
			lblError.setText("Error");
			//lblError.setSize(lblError.getPreferredSize());
			this.setIconImage(error.getImage());
			this.setTitle("Error");
			imagenError.setIcon(error);
			imagenError.repaint();
		}
		
		//JScrollPane sclError = new JScrollPane();
		
		JScrollPane sclProblema = new JScrollPane((Component) null);
		sclProblema.setBounds(93, 53, 355, 127);
		
		JLabel lblProblema = new JLabel("<html>" + prob +"</html>");
		sclProblema.setRowHeaderView(lblProblema);
		getContentPane().setLayout(null);
		getContentPane().add(lblError);
		getContentPane().add(imagenError);
		getContentPane().add(sclProblema);
		
		//lblProblema.setText(prob);

	}
}
