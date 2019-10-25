package client;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client extends Frame {

	TextField tf = new TextField();

	TextArea ta = new TextArea();

	Socket s = null;

	DataOutputStream dos = null;

	DataInputStream dis = null;

	boolean bConnected = false;

	recvThread r = new recvThread();

	public static void main(String[] args) {

//		int type = 1234;
//		byte[] by = new byte[4];
//		ByteBuffer bb = ByteBuffer.wrap(by);
//
//		bb.order(ByteOrder.BIG_ENDIAN);
//		// ByteOrder.LITTLE_ENDIAN
//		bb.asIntBuffer().put(type);
//		int t = 0;
//
//		t = (0xff & by[0]) << 24;
//		System.out.println("---------number:" + t);
//		t = t | (0xff & by[1]) << 16;
//		System.out.println("---------number:" + t);
//		t = t | (0xff & by[2]) << 8;
//		System.out.println("---------number:" + t);
//		t = t | (0xff & by[3]);
//		System.out.println("---------number:" + t);
//
//		System.out.println("---------number:" + t);
//		for (int i = 0; i < by.length; i++) {
//			System.out.println("---------byte:" + (by[i] & 0xFF));
//		}
//		bb.asIntBuffer().put(0);// 清空
//		bb.put("1234".getBytes());
//		for (int i = 0; i < by.length; i++) {
//			System.out.println("---------byte:" + (by[i] & 0xFF));
//
//		}

		// if (false) {
		new Client().createFram();
		// }
	}

	public void createFram() {
		this.setBounds(300, 300, 300, 300);
		ta.setEditable(false);
		this.add(tf, BorderLayout.SOUTH);
		this.add(ta, BorderLayout.NORTH);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				disconnect();
				System.exit(0);
			}
		});

		tf.addActionListener(new tfListener());

		this.pack();
		this.setVisible(true);
		connect();
		new Thread(r).start();
	}

	public void connect() {
		try {
			s = new Socket("127.0.0.1", 8888);
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());

			bConnected = true;

		} catch (UnknownHostException e) {
			// TODO: handle exception

			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void disconnect() {

		try {
			dos.close();
			dis.close();
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	class tfListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String str = tf.getText();

			tf.setText("");

			try {
				dos.writeUTF(str);
				dos.flush();

			} catch (IOException e1) {
				// TODO: handle exception

				e1.printStackTrace();

			}
		}

	}

	class recvThread implements Runnable {

		public void run() {

			try {
				while (bConnected) {

					String str;

					str = dis.readUTF();

					ta.setText(ta.getText() + str + '\n');

				}

			} catch (SocketException e) {
				// TODO: handle exception

				System.out.println("退出了");

			} catch (IOException e) {
				// TODO: handle exception

				e.printStackTrace();
			}

		}

	}

}
