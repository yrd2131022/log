package com.yrd.log.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTest {

	public static final Logger LOGGER = LoggerFactory.getLogger(Slf4jTest.class);

	
	public void testQuick() throws Exception {
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
		// 将系统异常信息写入日志
		try {
			@SuppressWarnings("unused")
			int i = 1 / 0;
		} catch (Exception e) {
			// e.printStackTrace();
			LOGGER.info("出现异常：", e);
		}
	}
	
	public static void main(String[] args) {
		Slf4jTest slf4jTest = new Slf4jTest();
		try {
			
			
			slf4jTest.testQuick();
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
