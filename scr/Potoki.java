
public class Potoki {

	static Thread t1 = new Thread(new A());
	static Thread t2 = new Thread(new B());
	static Thread t3 = new Thread(new Z());

	public static void main(String[] args) {
		t1.start(); // ������ ������ ������
		t2.start();
		t3.start();
	}

	@SuppressWarnings("deprecation")
	public static void stop() {
		t1.stop();
		t2.stop();
		t3.stop();

	}
}

class Z implements Runnable {
	// ����� ����� ������ ������
	public void run() {
		Logo.main(null);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Logo.frame.dispose();
	}
}

class B implements Runnable {
	// ����� ����� ������ ������
	public void run() {
		Sound.main(null);
	}
}

class A implements Runnable {
	// ����� ����� ������ ������
	public void run() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		NewMainMenu.main(null);
	}
}