
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Fightpusk {

	private JFrame fre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fightpusk window = new Fightpusk();
					window.fre.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fightpusk() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fre = new JFrame();
		//fre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fre.setUndecorated(true); 
		fre.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fre.setContentPane(new Battleground("wolf"));
		fre.pack();
		fre.setLocationRelativeTo(null);
		fre.setVisible(true);
	}

}
