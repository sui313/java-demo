package threadcommunication;

public class GetThread implements Runnable {
	private Student s;

	public GetThread(Student s) {
		this.s = s;
	}

	@Override
	public void run() {

		while (true) {

			synchronized (s) {

				if (!s.flag) {
					try {
						s.wait();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}

				}
				System.out.println(s.name + "-----" + s.age);
				s.flag = false;
				s.notify();
			}

		}

	}
}
