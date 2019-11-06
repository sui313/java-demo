package synch;

public class SyncMethod implements Runnable {
	private int num = 100;

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			sellTicket();
		}
	}

	synchronized void sellTicket() {
		System.out.println("SyncMethod::theadid=" + Thread.currentThread().getId() + ",threadName="
				+ Thread.currentThread().getName() + ",num还剩:" + num--);
	}

}
