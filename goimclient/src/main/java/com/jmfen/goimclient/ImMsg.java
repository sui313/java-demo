package com.jmfen.goimclient;

public class ImMsg {

	int ver;
	int op;
	int seq;
	byte[] body;
	// OpHandshake handshake
	static final int OpHandshake = 0;
	// OpHandshakeReply handshake reply
	static final int OpHandshakeReply = 1;

	// OpHeartbeat heartbeat
	static final int OpHeartbeat = 2;
	// OpHeartbeatReply heartbeat reply
	static final int OpHeartbeatReply = 3;

	// OpSendMsg send message.
	static final int OpSendMsg = 4;
	// OpSendMsgReply send message reply
	static final int OpSendMsgReply = 5;

	// OpDisconnectReply disconnect reply
	static final int OpDisconnectReply = 6;

	// OpAuth auth connnect
	static final int OpAuth = 7;
	// OpAuthReply auth connect reply
	static final int OpAuthReply = 8;

	// OpRaw raw message
	static final int OpRaw = 9;

	// OpProtoReady proto ready
	static final int OpProtoReady = 10;
	// OpProtoFinish proto finish
	static final int OpProtoFinish = 11;

	// OpChangeRoom change room
	static final int OpChangeRoom = 12;
	// OpChangeRoomReply change room reply
	static final int OpChangeRoomReply = 13;

	// OpSub subscribe operation
	static final int OpSub = 14;
	// OpSubReply subscribe operation
	static final int OpSubReply = 15;

	// OpUnsub unsubscribe operation
	static final int OpUnsub = 16;
	// OpUnsubReply unsubscribe operation reply
	static final int OpUnsubReply = 17;
}
