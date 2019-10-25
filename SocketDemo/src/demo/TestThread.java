//extends Thread
 //class RunnableDemo implements Runnable {
class RunnableDemo extends Thread {
	private Thread t;
	private String threadName;

	RunnableDemo(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		System.out.println("Running " + threadName);

		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread:" + threadName + "," + i);
				Thread.sleep(50);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Thread " + threadName + "interrunpted. ");
		}
		System.out.println("Thread " + threadName + "exiting");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
			//t.setName(threadName);
		}
	}
}

public class TestThread {
	public static void main(String []args) {
		RunnableDemo R1 = new RunnableDemo("Thread-1");
		R1.start();
		RunnableDemo R2 = new RunnableDemo("Thread-2");
		R2.start();
	}
}