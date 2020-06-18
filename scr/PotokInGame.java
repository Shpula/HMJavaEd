import javax.swing.JFrame;

public class PotokInGame {

	static int test = 1;

	public static void start() {
		Thread t3 = new Thread(new D());
		Thread t4 = new Thread(new C());
		t3.start(); // ������ ������ ������
		if (test == 1) {
			t4.start(); // ������ ������ ������
			test = 0;
		}
	}

	@SuppressWarnings({ "deprecation", "unused" })
	public static void stop() {
		Thread t3 = new Thread(new D());
		Thread t4 = new Thread(new C());
		t3.stop(); // ������ ������ ������
		// t4.stop(); // ������ ������ ������
	}
}

class D implements Runnable {
	static JFrame fr = new JFrame("hero");

	// ����� ����� ������ ������
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
	// ����� ����� ������ ������
	public void run() {
		SoundsInGame.main(null);
	}
}
