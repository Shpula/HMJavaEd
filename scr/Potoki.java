
public class Potoki {

	static Thread t1 = new Thread(new A());
	static Thread t2 = new Thread(new B());
	static Thread t3 = new Thread(new Z());

	public static void main(String[] args) {
		t1.start(); // запуск нового потока
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
	// точка входа нового потока
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
	// точка входа нового потока
	public void run() {
		Sound.main(null);
	}
}

class A implements Runnable {
	// точка входа нового потока
	public void run() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		NewMainMenu.main(null);
	}
}