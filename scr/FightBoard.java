

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FightBoard {

	private JFrame board;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FightBoard window = new FightBoard();
					window.board.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FightBoard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Image boardimg = new ImageIcon(this.getClass().getResource("/tableboard.png")).getImage();
		Image agreeimg = new ImageIcon(this.getClass().getResource("/agreeimg.png")).getImage();
		Image disagreeimg = new ImageIcon(this.getClass().getResource("/disagreeimg.png")).getImage();
		board = new JFrame();
		board.setUndecorated(true);
		JLabel lblNewLabel_1 = new JLabel("");  //Фон
		lblNewLabel_1.setBounds(0, 0, 568, 567);
		lblNewLabel_1.setIcon(new ImageIcon(boardimg));
		
		
		JButton agree = new JButton("");  //согласие
		agree.setBounds(148, 428, 126, 67);
		agree.setIcon(new ImageIcon(agreeimg));
		agree.setOpaque(false);
		agree.setFocusable(true);
		agree.setBorder(null);
		agree.setBackground(Color.DARK_GRAY);
		agree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fightpusk.main(null);
				board.dispose();
			}
		});
		board.getContentPane().setLayout(null);
		board.getContentPane().add(agree);
		
		JButton disagree = new JButton("");  //согласие
		disagree.setBounds(305, 428, 126, 67);
		disagree.setIcon(new ImageIcon(disagreeimg));
		disagree.setOpaque(false);
		disagree.setFocusable(true);
		disagree.setBorder(null);
		disagree.setBackground(Color.DARK_GRAY);
		disagree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				board.dispose();
			}
		});
		board.getContentPane().setLayout(null);
		board.getContentPane().add(disagree);
		
		board.getContentPane().add(lblNewLabel_1);
		board.setBounds(100, 100, 568, 567);
		board.setLocationRelativeTo(null);
		board.setFocusable(true);
	}
	
}
