package helloworld;

import dao.NatsDao;
import dao.PrintMsg;

public class HelloWorld implements PrintMsg {

	private NatsDao nd = null;

	public static void main(String[] args) {
		System.out.println("-----------------Hello world!!!!!!!!----------");

		HelloWorld hl = new HelloWorld();
		hl.nd = new NatsDao();
		hl.start();

//		hl.SendMsgClass sm = hl.new SendMsgClass();
//
//		NatsDao nd = new NatsDao();
//
//		// SendMsgClass sm = (new HelloWorld).new SendMsgClass();
//
//		try {
//			if (true) {
//				String msg = nd.recv();
//				System.out.println("-----------------recv:" + msg);
//				return;
//			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			nd.close();
//		}
		System.out.println("-----------------Hello world! END ----------");
	}

	void start() {
		SendMsgClass sm = new SendMsgClass();
		Thread t = new Thread(sm);
		t.start();

		nd.recv(this);
	}

	class SendMsgClass implements Runnable {

		public void run() {
			int i = 0;
			while (true) {
				try {
					nd.send("IM JAVA,send a msg:" + i);
					Thread.sleep(1000);
					i++;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

			}
		}
	}

	public void print_msg(String msg) {
		System.out.println("HelloWorld收到一条消息：" + msg);
	}

}
