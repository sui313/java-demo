package lock;

public class App {
	public static void main(String[] args) {

		LockDemo ld = new LockDemo();

		// for (int i = 0; i < 10; i++) {
		Thread t1 = new Thread(ld, "窗口" + 1);
		t1.start();
		Thread t2 = new Thread(ld, "窗口" + 2);
		t2.start();
		Thread t3 = new Thread(ld, "窗口" + 3);
		t3.start();
		Thread t4 = new Thread(ld, "窗口" + 4);
		t4.start();
		Thread t5 = new Thread(ld, "窗口" + 5);
		t5.start();
		// }

	}
}
