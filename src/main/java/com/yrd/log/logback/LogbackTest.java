package com.yrd.log.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yrd.log.slf4j.Slf4jTest;

public class LogbackTest {
	public static final Logger LOGGER = LoggerFactory.getLogger(Slf4jTest.class);

	public void testSlf4j() {

		for (int i = 0; i < 10; i++) {
			// 打印日志信息
			LOGGER.error("error_"+i);
			LOGGER.warn("warn_"+i);
			LOGGER.info("info_"+i);
			LOGGER.debug("debug_"+i);
			LOGGER.trace("trace_"+i);
		}
		// 打印日志信息
		LOGGER.error("error");
		LOGGER.warn("warn");
		LOGGER.info("info");
		LOGGER.debug("debug");
		LOGGER.trace("trace");

		// 使用占位符输出日志信息
		String name = "jack";
		Integer age = 18;
		LOGGER.info("用户：{},{}", name, age);
	}

	public static void main(String[] args) {

		LogbackTest logbackTest = new LogbackTest();

		logbackTest.testSlf4j();
	}
}





