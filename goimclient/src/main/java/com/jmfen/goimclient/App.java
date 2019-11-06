package com.jmfen.goimclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Hello world!
 *
 */
public class App {

	// private static Log log = LogFactory.getLog(App.class.getClass());
	private static Log logger = LogFactory.getLog(App.class);
	static Socket s = null;

	static DataInputStream dis = null;
	static DataOutputStream dos = null;

	public static void main(String[] args) {
		// PropertyConfigurator.configure("./log4j.properties");
//		logger.trace("我是trace信息");
//		logger.debug("我是debug信息");
//		logger.info("我是info信息");
//		logger.warn("我是warn信息");
//		logger.error("我是error信息");
//		logger.fatal("我是fatal信息");
		logger.info("main start");
		try {
			s = new Socket("192.168.101.156", 3101);
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());

			ImMsg auth = new ImMsg();

			auth.op = ImMsg.OpAuth;
			auth.ver = 1;

			auth.body = "{\"mid\":100013, \"room_id\":\"live://1000\", \"platform\":\"web\", \"accepts\":[1000,1001,1002]}"
					.getBytes();
			Proto p = new Proto();
			p.sendMsg(dos, auth);

			ImMsg authreply = p.recvMsg(dis);
			if (authreply == null) {
				logger.info("认证失败");
				return;
			}
			if (authreply.op == ImMsg.OpAuthReply) {
				logger.info("收到认证回复：" + (new String(auth.body)));
			}

			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO 自动生成的方法存根
					logger.info("心跳开始");
					ImMsg heartbeat = new ImMsg();
					heartbeat.op = ImMsg.OpHeartbeat;
					heartbeat.ver = 1;
					heartbeat.body = new byte[0];
					while (true) {
						p.sendMsg(dos, heartbeat);
						try {
							Thread.sleep(2000);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				}
			}).start();

			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO 自动生成的方法存根
					logger.info("开始读消息");
					ImMsg msg = null;
					while (true) {
						msg = p.recvMsg(dis);
						switch (msg.op) {
						case ImMsg.OpHeartbeatReply:
							logger.info("收到心跳回复:" + msg.seq);
							break;
						case ImMsg.OpAuthReply:
							logger.info("收到认证回复：" + (new String(msg.body)));
							break;
						default:
							logger.info("收到一条消息：" + msg.op + "--" + msg.seq + "--" + (new String(msg.body)));
						}
					}
				}
			}).start();
//			while (true) {
//				Thread.sleep(100000);
//			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			logger.info("main end");
		}

	}

}
