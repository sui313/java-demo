package threadcommunication;

public class App {
	public static void main(String[] args) {

		Student s = new Student();

		SetThread st = new SetThread(s);
		GetThread gt = new GetThread(s);

		Thread t1 = new Thread(st, "设置");
		Thread t2 = new Thread(gt, "打印");
		t1.start();
		t2.start();
	}
}
