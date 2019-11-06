package client;

import java.net.Socket;
import java.util.concurrent.TimeUnit;

import net.Msg;
import net.Tlv;

public class Client implements Runnable {
	private Tlv tlv = null;
	Socket s = null;

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Client c = new Client();

			Thread t = new Thread(c.new ShutdownHook(), "ShutdownHook-Thread");

			Runtime.getRuntime().addShutdownHook(t);

			Socket s = new Socket("127.0.0.1", 3333);

			c.tlv = new Tlv(s);
			new Thread(c).start();
			for (int i = 0; i < 1; i++) {
				String str = i + "_" + "Hello java world!!!";
				c.tlv.writeMsg(str, 1);
				Thread.sleep(1 * 1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		Msg msg = null;
		while (true) {
			msg = tlv.readMsg();
			System.out.println("read a msg:" + (new String(msg.getmsg())));
		}

	}

	class ShutdownHook implements Runnable {
		@Override
		public void run() {
			System.out.println("ShutdownHook execute start...");
			try {
				tlv.close();
				TimeUnit.SECONDS.sleep(1);// 模拟应用进程退出前的处理操作
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("ShutdownHook execute end...");
		}
	}
}
