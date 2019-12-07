package lock;

public class DeadLock {
	public static void main(String[] args) {
		Ticket t = new Ticket();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.flag = false;
		t2.start();
	}
}

class Ticket implements Runnable {
	private static int num = 30;
	Object obj = new Object();
	boolean flag = true;

	public void run() {
		if (flag) {
			while (true) {
				synchronized (obj) {
					System.out.println(Thread.currentThread().getName() + "==1");
					show();
				}
			}
		} else
			while (true) {
				System.out.println(Thread.currentThread().getName() + "__1");
				show();
			}
	}

	public synchronized void show() {
		System.out.println(Thread.currentThread().getName() + "__1");
		synchronized (obj) {
			System.out.println(Thread.currentThread().getName() + "__2");
			if (num > 0) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "...function..." + num--);
			} else {
				System.out.println(Thread.currentThread().getName() + "-----------");
			}
		}
	}

}