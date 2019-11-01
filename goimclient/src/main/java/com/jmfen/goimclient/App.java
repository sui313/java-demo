package com.jmfen.goimclient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;;

/**
 * Hello world!
 *
 */
public class App {

	// private static Log log = LogFactory.getLog(App.class.getClass());
	private static Log logger = LogFactory.getLog(App.class);

	public static void main(String[] args) {
		// PropertyConfigurator.configure("./log4j.properties");

		logger.trace("我是trace信息");
		logger.debug("我是debug信息");
		logger.info("我是info信息");
		logger.warn("我是warn信息");
		logger.error("我是error信息");
		logger.fatal("我是fatal信息");

		System.out.println("Hello World!");
		new TestLog().printlog();
	}
}
