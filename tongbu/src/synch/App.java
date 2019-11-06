package synch;

public class App {
	public static void main(String[] args) {
		System.out.println("--------Bolck Start----------");
		SyncBlock syncb = new SyncBlock();
		for (int i = 0; i < 4; i++) {
			Thread t = new Thread(syncb, "sb_" + i);
			t.start();
		}

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("--------Bolck End----------");

		System.out.println("--------SyncMethod Start----------");
		SyncMethod syncM = new SyncMethod();
		for (int i = 0; i < 4; i++) {
			Thread t = new Thread(syncM, "smt_" + i);
			t.start();
		}
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("--------SyncMethod End----------");
	}
}
