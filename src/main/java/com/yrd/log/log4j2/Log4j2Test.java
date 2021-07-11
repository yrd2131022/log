package com.yrd.log.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/*
 * <!-- log4j2 日志门面 ,一般不用,而是用slf4j-->
		<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-api</artifactId>
			<version>2.13.3</version>
		</dependency>

		<!-- log4j2 日志实现 -->
		<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-core</artifactId>
			<version>2.13.3</version>
		</dependency>
 */
public class Log4j2Test {

	public static final Logger LOGGER = LogManager.getLogger(Log4j2Test.class);

	public void testQuick() throws Exception {
		LOGGER.fatal("fatal");
		LOGGER.error("error");
		LOGGER.warn("warn");
		LOGGER.info("info");
		LOGGER.debug("debug");
		LOGGER.trace("trace");
	}
	
	public static void main(String[] args) {
		Log4j2Test log4j2Test = new Log4j2Test();
		try {
			
			
			log4j2Test.testQuick();
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
