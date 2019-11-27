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

public class ErrorVista extends JFrame {

	/**
	 * Create the panel.
	 */
	public ErrorVista(String prob) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Error");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ErrorVista.class.getResource("/resources/error.png")));
		ImageIcon error = new ImageIcon(PerfilUsuario2.class.getResource("/resources/error.png"));
		JPictureBox imagenError = new JPictureBox();
		imagenError.setIcon(error);
		imagenError.repaint();
		setBounds(10, 10, 510, 220);
		this.setLocation(SwingConstants.CENTER, SwingConstants.CENTER);
		
		JLabel lblError = new JLabel("Error");
		lblError.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		
		//JScrollPane sclError = new JScrollPane();
		
		JScrollPane sclProblema = new JScrollPane((Component) null);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(158)
							.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addComponent(imagenError, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(sclProblema, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(lblError)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sclProblema, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addComponent(imagenError, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
		JLabel lblProblema = new JLabel("");
		sclProblema.setViewportView(lblProblema);
		getContentPane().setLayout(groupLayout);
		
		lblProblema.setText(prob);

	}
}
