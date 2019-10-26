package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import net.Msg;
import net.Tlv;

public class Server {
	ServerSocket ss = null;
	List<SC> list = new ArrayList<SC>(); // 保存客户端线程类

	public static void main(String[] args) {
		System.out.println("server started");
//		try {
//			TestCl c = new TestCl();
//			c.fun1(1, 0);
//			System.out.println("222222222222");
//			int dd = 123 + 654;
//			System.out.println(dd);
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("3333333333");
//			e.printStackTrace();
//		}
//		System.out.println("44444444444");
		new Server().start();
	}

	void start() {
		try {
			ss = new ServerSocket(3334);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try {
			while (true) {
				Socket s = ss.accept(); // 接收客户端
				SC sc = new SC(s);
				new Thread(sc).start();
				list.add(sc);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	class SC implements Runnable {
		Socket s = null;
		Tlv tlv = null;

		public SC(Socket s) {
			this.s = s;
			tlv = new Tlv(s);
		}

		@Override
		public void run() {
			// TODO 自动生成的方法存根
			while (true) {
				Msg msg = tlv.readMsg();
				System.out.println("recived a message:" + (new String(msg.getmsg())));
				tlv.writeMsg("recived a message", 2);
			}

		}

		void close() {
			tlv.close();
			try {
				if (s != null) {
					s.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	void close() {
		try {

			if (ss != null) {
				ss.close();
			}
			for (int i = 0; i < list.size(); i++) {
				list.get(i).close();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	class shutdownhook implements Runnable {
		@Override
		public void run() {
			// TODO 自动生成的方法存根
			close();
			System.out.println("server closed");
		}
	}

}
