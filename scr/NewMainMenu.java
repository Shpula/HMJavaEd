import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class NewMainMenu {

	private JFrame frame;

	Image Help = new ImageIcon(this.getClass().getResource("/help.png")).getImage();
	Image BackG = new ImageIcon(this.getClass().getResource("/BackGraund.gif")).getImage();
	Image NewGame = new ImageIcon(this.getClass().getResource("/NG.png")).getImage();
	Image LoadGame = new ImageIcon(this.getClass().getResource("/LG.png")).getImage();
	Image Records = new ImageIcon(this.getClass().getResource("/RC.png")).getImage();
	Image Exit = new ImageIcon(this.getClass().getResource("/EX.png")).getImage();
	Image Autors = new ImageIcon(this.getClass().getResource("/AV.png")).getImage();
	Image AutorsD = new ImageIcon(this.getClass().getResource("/DD.png")).getImage();
	Image MainHelp = new ImageIcon(this.getClass().getResource("/MainHelp.png")).getImage();
	
	private boolean key_pressed = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMainMenu window = new NewMainMenu();
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
	public NewMainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		


		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		JButton btnNewButton = new JButton(""); // Новая игра
		btnNewButton.setIcon(new ImageIcon(NewGame));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Potoki.stop();
				PotokInGame.start();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(1181, 16, 414, 209);
		btnNewButton.setOpaque(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(null);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setBackground(Color.CYAN);
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Graphics g = frame.getGraphics();
				g.drawImage(MainHelp, 270, 180, 800, 850, null);
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(Help));
		btnNewButton_5.setOpaque(false);
		btnNewButton_5.setFocusable(false);
		btnNewButton_5.setBorder(null);
		btnNewButton_5.setBounds(1760, 43, 125, 136);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_1 = new JButton(""); // Выход
		btnNewButton_1.setIcon(new ImageIcon(Exit));
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(1261, 835, 252, 174);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBorder(null);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton(""); // Загрузка игры
		btnNewButton_2.setIcon(new ImageIcon(LoadGame));
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnNewButton_2.setBounds(1177, 230, 414, 209);
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBorder(null);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton(""); // Рекорды
		btnNewButton_3.setIcon(new ImageIcon(Records));
		btnNewButton_3.setBackground(Color.CYAN);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_3.setBounds(1171, 443, 414, 185);
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setBorder(null);
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton(""); // Авторы
		btnNewButton_4.setIcon(new ImageIcon(Autors));
		btnNewButton_4.setBackground(Color.CYAN);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Graphics g = frame.getGraphics();
				g.drawImage(AutorsD, 270, 180, 800, 850, null);
				try {
					TimeUnit.SECONDS.sleep(4);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(1183, 645, 409, 174);
		btnNewButton_4.setOpaque(false);
		btnNewButton_4.setFocusable(false);
		btnNewButton_4.setBorder(null);
		frame.getContentPane().add(btnNewButton_4);

		JLabel lblNewLabel = new JLabel(" "); // Фон
		lblNewLabel.setIcon(new ImageIcon(BackG));
		lblNewLabel.setBounds(0, 0, 1920, 1080);
		frame.getContentPane().add(lblNewLabel);

		Image curImage = Toolkit.getDefaultToolkit()
				.createImage(getClass().getResource("Курсор.png"));
		frame.setCursor(Toolkit.getDefaultToolkit()
				.createCustomCursor(curImage, new Point(8, 8), "CustomCursor"));
	}

	private void addKeyListener(KeyListener keyListener) {
		// TODO Auto-generated method stub
		
	}
}
