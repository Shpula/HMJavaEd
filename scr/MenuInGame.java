
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MenuInGame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInGame window = new MenuInGame();
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
	public MenuInGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		Image img = new ImageIcon(this.getClass().getResource("/Внутреннее меню.png")).getImage();

		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setUndecorated(true);
		frame.setLocation(650, 200);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("В меню");
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 30));
		btnNewButton.setOpaque(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				D.fr.dispose();
				NewMainMenu.main(null);
				frame.dispose();
				PotokInGame.stop();
			}
		});

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 30));
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// frame.setVisible(false);
				frame.dispose();

			}
		});

		JButton btnNewButton_1 = new JButton("Coxранение");
		btnNewButton_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 30));
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame fr = new JFrame("hero");
				fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				fr.setUndecorated(true);
				fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
				fr.setContentPane(new Field(1));
				fr.pack();
				fr.setLocationRelativeTo(null);
				fr.setVisible(true);
				frame.dispose();
			}
		});

		btnNewButton_2.setBounds(261, 524, 80, 35);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_1.setBounds(162, 125, 272, 116);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton.setBounds(165, 331, 267, 116);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 600, 600);
		frame.getContentPane().add(lblNewLabel);

		Image curImage = Toolkit.getDefaultToolkit().createImage(getClass().getResource("Курсор.png"));
		frame.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(curImage, new Point(8, 8), "CustomCursor"));
	}
}
