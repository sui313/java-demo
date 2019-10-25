package server;

public class TestCl {
	public int fun1(int a, int b) {
		int c = 0;
		try {
			c = a / b;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return c;
	}
}
