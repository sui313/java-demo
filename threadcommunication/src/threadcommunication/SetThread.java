package threadcommunication;

public class SetThread implements Runnable {

	private Student s;
	private int x = 0;

	public SetThread(Student s) {
		this.s = s;
	}

	@Override
	public void run() {

		while (true) {

			synchronized (s) {

				if (s.flag) {
					try {
						s.wait();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}

				}
				if (x % 2 == 0) {
					s.name = "张三";
					s.age = 33;
				} else {
					s.name = "李四";
					s.age = 13;
				}
				s.flag = true;
				x++;
				s.notify();
				if (x == 10) {
					break;
				}
			}

		}

	}

}
