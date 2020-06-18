import javax.swing.JFrame;

public class PotokInGame {

	static int test = 1;

	public static void start() {
		Thread t3 = new Thread(new D());
		Thread t4 = new Thread(new C());
		t3.start(); // запуск нового потока
		if (test == 1) {
			t4.start(); // запуск нового потока
			test = 0;
		}
	}

	@SuppressWarnings({ "deprecation", "unused" })
	public static void stop() {
		Thread t3 = new Thread(new D());
		Thread t4 = new Thread(new C());
		t3.stop(); // запуск нового потока
		// t4.stop(); // запуск нового потока
	}
}

class D implements Runnable {
	static JFrame fr = new JFrame("hero");

	// точка входа нового потока
	public void run() {
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setUndecorated(true);
		fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fr.setContentPane(new Field(0));
		fr.pack();
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);
	}
}

class C implements Runnable {
	// точка входа нового потока
	public void run() {
		SoundsInGame.main(null);
	}
}
