package synch;

public class SyncBlock implements Runnable {

	private int num = 500;
	Object obj = new Object();

	@Override
	public void run() {
		for (int i = 0; i < 5; i++)
			synchronized (obj) {
				System.out.println("SyncBlock::theadid=" + Thread.currentThread().getId() + ",threadName="
						+ Thread.currentThread().getName() + ",num还剩:" + num--);
			}
	}
}
