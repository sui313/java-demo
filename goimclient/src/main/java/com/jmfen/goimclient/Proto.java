package com.jmfen.goimclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Proto {

	private static Log logger = LogFactory.getLog(App.class);

	final int MaxBodySize = 1 << 12;
	// size
	final int _packSize = 4;
	final int _headerSize = 2;
	final int _verSize = 2;
	final int _opSize = 4;
	final int _seqSize = 4;
	final int _heartSize = 4;
	final int _rawHeaderSize = _packSize + _headerSize + _verSize + _opSize + _seqSize;
	final int _maxPackSize = MaxBodySize + _rawHeaderSize;
	// offset
	final int _packOffset = 0;
	final int _headerOffset = _packOffset + _packSize;
	final int _verOffset = _headerOffset + _headerSize;
	final int _opOffset = _verOffset + _verSize;
	final int _seqOffset = _opOffset + _opSize;
	final int _heartOffset = _seqOffset + _seqSize;
	private int seq = 1;

	public void sendMsg(DataOutputStream out, ImMsg msg) {

		byte[] bb = tobytes(msg);
		try {
			out.write(bb);
			out.flush();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("发送消息错误" + e.toString());
			e.printStackTrace();
		}

	}

	private byte[] tobytes(ImMsg msg) {
		if (MaxBodySize < msg.body.length) {
			logger.error("发送消息超过最大长度");
			return null;
		}

		byte[] msgB = new byte[_rawHeaderSize + msg.body.length];

		// byte[] by = new byte[4];
		ByteBuffer bf = ByteBuffer.wrap(msgB);
		bf.order(ByteOrder.BIG_ENDIAN);// 这里使用大端序
		bf.putInt(_rawHeaderSize + msg.body.length); // 包总长度=头部长度+消息长度
		bf.putShort((short) (_rawHeaderSize));
		bf.putShort((short) (msg.ver));
		bf.putInt(msg.op);
		msg.seq = this.seq;
		this.seq += 1;
		bf.putInt(msg.seq);
		bf.put(msg.body);
		return msgB;
	}

	public ImMsg recvMsg(DataInputStream dis) {
		ImMsg msg = new ImMsg();
		byte[] msgHead = new byte[_rawHeaderSize];
		try {
			dis.readFully(msgHead);
			ByteBuffer bf = ByteBuffer.wrap(msgHead);
			bf.order(ByteOrder.BIG_ENDIAN);// 这里使用大端序
			int packLen = bf.getInt();
			int headLen = bf.getShort();
			msg.ver = bf.getShort();
			msg.op = bf.getInt();
			msg.seq = bf.getInt();
			int bodyLen = packLen - headLen;

			if (bodyLen > MaxBodySize) {
				logger.error("消息长度错误");
				return null;
			}
			msg.body = new byte[bodyLen];
			dis.readFully(msg.body);
			return msg;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("读取消息错误");
			e.printStackTrace();
		}
		return null;
	}

}
