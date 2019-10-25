import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class CallableTest implements Callable<Integer> {

	@Override
	public Integer call() throws Exception{
		int i=0;
		for (;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+"_"+i);
		}
		return i;
	}

}

public class CallableDemo {

	public  static  void main(String[] args) {
		CallableTest ctt = new CallableTest();
		FutureTask<Integer> ft = new FutureTask<>(ctt);

		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " ��ѭ������i��ֵ" + i);
			if (i == 20) {
				new Thread(ft, "�з���ֵ���߳�").start();
			}
		}
		try {
			System.out.println("���̵߳ķ���ֵ��" + ft.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
