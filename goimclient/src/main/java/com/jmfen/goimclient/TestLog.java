package com.jmfen.goimclient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestLog {
	private static Log logger = LogFactory.getLog(TestLog.class);

	public void printlog() {
		logger.trace("我是trace信息");
		logger.debug("我是debug信息");
		logger.info("我是info信息");
		logger.warn("我是warn信息");
		logger.error("我是error信息");
		logger.fatal("我是fatal信息");
	}
}
