package com.yrd.log.log4j;

import org.apache.log4j.Logger;

public class Log4jTest {

	public void testQuick() throws Exception {

		// 初始化系统配置，不需要配置文件(在没有log4j.properties时候，才需要初始化系统配置)
//		BasicConfigurator.configure();

		// 创建日志记录器对象 com.yrd.log.log4j.Log4jTest
		Logger logger = Logger.getLogger(Log4jTest.class);

		for (int i = 0; i < 20; i++) {
			// 日志记录输出
			logger.info("hello log4j" + i);
		}

		// 日志级别
		logger.fatal("fatal"); // 严重错误，一般会造成系统崩溃和终止运行
		logger.error("error"); // 错误信息，但不会影响系统运行
		logger.warn("warn"); // 警告信息，可能会发生问题
		logger.info("info"); // 程序运行信息，数据库的连接、网络、IO操作等
		logger.debug("debug"); // 调试信息，一般在开发阶段使用，记录程序的变量、参数等
		logger.trace("trace"); // 追踪信息，记录程序的所有流程信息

		// Logger.class目录在：org.apache.log4j.Logger
		// 自定义配置，输出目录log4j.logger.org.apache = error。没写默认log4j.rootLogger中的输出类型
		Logger logger2 = Logger.getLogger(Logger.class);
		logger2.fatal("fatal——logger2"); // 严重错误，一般会造成系统崩溃和终止运行
		logger2.error("error——logger2"); // 错误信息，但不会影响系统运行
		logger2.warn("warn——logger2"); // 警告信息，可能会发生问题
		logger2.info("info——logger2"); // 程序运行信息，数据库的连接、网络、IO操作等
		logger2.debug("debug——logger2"); // 调试信息，一般在开发阶段使用，记录程序的变量、参数等
		logger2.trace("trace——logger2"); // 追踪信息，记录程序的所有流程信息

		Logger logger3 = Logger.getLogger("com.yrd.log.log4j");
		logger3.fatal("fatal——logger3"); // 严重错误，一般会造成系统崩溃和终止运行
		logger3.error("error——logger3"); // 错误信息，但不会影响系统运行
		logger3.warn("warn——logger3"); // 警告信息，可能会发生问题
		logger3.info("info——logger3"); // 程序运行信息，数据库的连接、网络、IO操作等
		logger3.debug("debug——logger3"); // 调试信息，一般在开发阶段使用，记录程序的变量、参数等
		logger3.trace("trace——logger3"); // 追踪信息，记录程序的所有流程信息
	

	}

	public static void main(String[] args) {
		Log4jTest log4jTest = new Log4jTest();

		try {

			log4jTest.testQuick();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
