package com.yrd.log.jul;

import java.io.InputStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * .JUL全称Java util Logging是java原生的日志框架，使用时不需要另外引用第三方类库
 * ,相对其他日志框架使用方便，学习简单，能够在小型应用中灵活使用
 * 
 * @ClassName:JulTest01
 * @Description:
 *
 * @author:Yrd
 * @date:2021-6-21 9:46:23
 *
 */
public class JulTest01 {

	// 1
	public static void testQuick() throws Exception {

		// 1.创建日志记录器对象
		Logger logger = Logger.getLogger("com.yrd.log.jul.JULTest01");

		// 2.日志记录输出
		logger.info("hello jul");

		logger.log(Level.INFO, "info msg");

		// 通过占位符，方式输出变量
		String name = "jack";
		Integer age = 18;
		logger.log(Level.INFO, "用户信息：{0},{1}", new Object[] { name, age });
	}

	// 2日志级别
	/*
	 * * java.util.logging.Level中定义了日志的级别： SEVERE（最高值） WARNING INFO （默认级别） CONFIG
	 * FINE FINER FINEST（最低值） 还有两个特殊的级别： OFF，可用来关闭日志记录。 ALL，启用所有消息的日志记录。
	 */
	public static void testLogLevel() throws Exception {
		// 1.获取日志对象
		Logger logger = Logger.getLogger("com.yrd.log.jul.JULTest01");
		// 2.日志记录输出
		logger.severe("severe");
		logger.warning("warning");
		logger.info("info"); // jul默认的日志级别 info
		logger.config("cofnig");
		logger.fine("fine");
		logger.finer("finer");
		logger.finest("finest");
	}

	// 3自定义日志级别配置
	public static void testLogConfig() throws Exception {

		// 1.创建日志记录器对象
		Logger logger = Logger.getLogger("com.yrd.log.jul.JULTest01");

		// 一、自定义日志级别
		// a.关闭系统默认配置
		logger.setUseParentHandlers(false);

		// b.创建handler对象ConsoleHandler,(控制台输出)
		ConsoleHandler consoleHandler = new ConsoleHandler();

		// c.创建formatter对象(简单格式转换对象)
		SimpleFormatter simpleFormatter = new SimpleFormatter();

		// d.进行关联
		consoleHandler.setFormatter(simpleFormatter);
		logger.addHandler(consoleHandler);

		// e.设置日志级别
		logger.setLevel(Level.ALL);
		consoleHandler.setLevel(Level.ALL);

		// 二、输出到日志文件
		FileHandler fileHandler = new FileHandler("d:/logs/jul.log");

		fileHandler.setFormatter(simpleFormatter);
		logger.addHandler(fileHandler);

		// 2.日志记录输出
		logger.severe("severe");
		logger.warning("warning");
		logger.info("info");// 默认
		logger.config("config");
		logger.fine("fine");
		logger.finer("finer");
		logger.finest("finest");
	}

	/**
	 * JUL中Logger之间存在父子关系，这种父子关系通过树状结构存储， JUL在初始化时会创建一个顶层RootLogger作为所有Logger父Logger
	 * ,存储上作为树状结构的根节点。并父子关系通过路径来关联。
	 * 
	 * @Title: testLogParent
	 * @Description:
	 * @throws Exception
	 * 
	 * @user: Yrd
	 * @date: 2021-6-21 10:02:05
	 *
	 */
	public static void testLogParent() throws Exception {

		// 日志记录器对象父子关系
		Logger logger1 = Logger.getLogger("com.yrd.log.jul");
		Logger logger2 = Logger.getLogger("com.yrd.log");

		System.out.println(logger1.getParent() == logger2);

		// 所有日志记录器对象的顶级父元素 class为java.util.logging.LogManager$RootLogger,name为""
		System.out.println("logger2 parent:" + logger2.getParent() + "，name：" + logger2.getParent().getName());
		// 一、自定义日志级别
		// a.关闭系统默认配置
		logger2.setUseParentHandlers(false);
		// b.创建handler对象
		ConsoleHandler consoleHandler = new ConsoleHandler();
		// c.创建formatter对象
		SimpleFormatter simpleFormatter = new SimpleFormatter();
		// d.进行关联
		consoleHandler.setFormatter(simpleFormatter);
		logger2.addHandler(consoleHandler);
		// e.设置日志级别
		logger2.setLevel(Level.ALL);
		consoleHandler.setLevel(Level.ALL);
		// 测试日志记录器对象父子关系
		logger1.severe("severe");
		logger1.warning("warning");
		logger1.info("info");
		logger1.config("config");
		logger1.fine("fine");
		logger1.finer("finer");
		logger1.finest("finest");
	}

	// 默认配置文件路径$JAVAHOME\jre\lib\logging.properties
	public static void testProperties() throws Exception {
		// 读取自定义配置文件
		InputStream in = JulTest01.class.getClassLoader().getResourceAsStream("logging.properties");
		// 获取日志管理器对象
		LogManager logManager = LogManager.getLogManager();
		// 通过日志管理器加载配置文件
		logManager.readConfiguration(in);

		Logger logger = Logger.getLogger("com.yrd.log.jul.JULTest01");
		logger.severe("severe");
		logger.warning("warning");
		logger.info("info");
		logger.config("config");
		logger.fine("fine");
		logger.finer("finer");
		logger.finest("finest");

		// 自定义Logger
		Logger logger2 = Logger.getLogger("mycom.yrd2.log");
		logger2.severe("severe_test");
		logger2.warning("warning_test");
		logger2.info("info_test");
		logger2.config("config_test");
		logger2.fine("fine_test");
		logger2.finer("finer_test");
		logger2.finest("finest_test");

	}

	public static void main(String[] args) {
		try {

//			testQuick();
//			testLogLevel();
//			testLogConfig();
//			testLogParent();
			testProperties();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
