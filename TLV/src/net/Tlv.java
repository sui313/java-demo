package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

public class Tlv {

	DataInputStream dis = null;
	DataOutputStream dos = null;
	Socket s = null;

	public Tlv(Socket s) {
		this.s = s;
		try {
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void writeMsg(String msg, int type) {

		byte[] MsgB = msg.getBytes(StandardCharsets.UTF_8);
		int len = MsgB.length;

		byte[] SendMsg = new byte[4 + 4 + len]; // int(type) + int(len) + msg.len
		ByteBuffer bb = ByteBuffer.wrap(SendMsg);
		bb.order(ByteOrder.LITTLE_ENDIAN);// 这里使用小端序
		bb.putInt(type);
		bb.putInt(len);
		bb.put(MsgB);

//		// 写入类型
//		bb.asIntBuffer().put(type);
//		for (i = 0; i < by.length; i++) {
//			SendMsg[i] = by[i];
//		}
//
//		bb.asIntBuffer().put(0);// 清空
//
//		// 写入长度
//		bb.asIntBuffer().put(len);//
//		int j = i;
//		for (int k = 0; k < by.length; j++, k++) {
//			SendMsg[j] = by[k];
//		}
//
//		// 写入消息
//		int n = j;
//		for (int k = 0; k < MsgB.length; k++, n++) {
//			SendMsg[n] = MsgB[k];
//		}
		try {
			dos.write(SendMsg);
			dos.flush();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("写入消息错误");
			e.printStackTrace();
		}

	}

	public Msg readMsg() {

		byte[] typeB = new byte[4];

		byte[] lenB = new byte[4];

		try {
			Msg msg = new Msg();
			dis.readFully(typeB);
			msg.type = LITTLEENDIAN(typeB);

			dis.readFully(lenB);
			msg.len = LITTLEENDIAN(lenB);

			byte[] rmsg = new byte[msg.len];
			dis.readFully(rmsg);

			msg.msg = rmsg;
			// System.out.println("========读取到的消息为:" + (new String(rmsg)));
			return msg;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("读取数据错误");
			e.printStackTrace();
		}

		return null;
	}

	public static int BIGENDIAN(byte[] b) {
		int t = 0;

		if (b.length != 4) {
			return 0;
		}
		t = 0xff & b[0] << 24;
		t = t | (0xff & b[1]) << 16;
		t = t | (0xff & b[2]) << 8;
		t = t | (0xff & b[3]);
		return t;
	}

	public static int LITTLEENDIAN(byte[] b) {
		int t = 0;
		if (b.length != 4) {
			return 0;
		}
		t = 0xff & b[0];
		t = t | (0xff & b[1]) << 8;
		t = t | (0xff & b[2]) << 16;
		t = t | (0xff & b[3]) << 24;
		return t;
	}

	public void close() {
		try {
			if (dis != null) {
				dis.close();
			}
			if (dos != null) {
				dos.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
