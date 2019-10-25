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
			System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
			if (i == 20) {
				new Thread(ft, "有返回值的线程").start();
			}
		}
		try {
			System.out.println("子线程的返回值：" + ft.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
