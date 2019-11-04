package dao;

import java.nio.charset.StandardCharsets;

import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import io.nats.client.Message;
import io.nats.client.MessageHandler;
import io.nats.client.Nats;
import io.nats.client.Options;;

public class NatsDao {
	static Connection nc = null;
	private PrintMsg PTM;
	static {
		try {
			// Connection nc = Nats.connect("nats://192.168.101.156:4222");
			Options o = new Options.Builder().server("nats://192.168.101.156:4222")
					.server("nats://192.168.101.156:4223").maxReconnects(-1).build();
			nc = Nats.connect(o);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void send(String msg) {
		nc.publish("test", msg.getBytes(StandardCharsets.UTF_8));
	}

	public String recv(PrintMsg ptm) {
		this.PTM = ptm;
		try {

			MsgHand mh = new MsgHand();
			Dispatcher d = nc.createDispatcher(mh);
			d.subscribe("foo");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	class MsgHand implements MessageHandler {

		public void onMessage(Message msg) throws InterruptedException {
			// TODO 自动生成的方法存根
			if (msg != null) {
				PTM.print_msg(new String(msg.getData(), StandardCharsets.UTF_8));
			}

		}
	}

	public static void close() {
		try {
			if (nc != null) {
				nc.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
