package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MenuPrincipalInvitado extends JPanel {

	/**
	 * Create the frame.
	 */
	public MenuPrincipalInvitado(MenuPrincipal padre) {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipalInvitado.class.getResource("/resources/_Logo AccionSocialMed png.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, padre.getWidth(), padre.getHeight());
		//setLocationRelativeTo(null);
		
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);

		JLabel login = new JLabel("Login");
		login.setForeground(Color.BLACK);
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Abrir ventana login
				InicioSesion frame = new InicioSesion(padre);
				frame.setVisible(true);
				padre.setEnabled(false);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				login.setForeground(new Color(51, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				login.setForeground(Color.BLACK);
			}
		});
		login.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(1192, Short.MAX_VALUE)
					.addComponent(login, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(login, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(690, Short.MAX_VALUE))
		);
		setLayout(gl_contentPane);
		JLabel lblBienvenida = new JLabel("");
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 67));
		lblBienvenida.setBounds(-33, 8, 1166, 699);
		add(lblBienvenida);
		lblBienvenida.setText("¡Bienvenid@!");
	}

}
