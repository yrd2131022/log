package com.yrd.log.jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * .JCL 有两个基本的抽象类：Log(基本记录器)和LogFactory(负责创建Log实例)。
 * .优先使用log4j,再使用jul
 * @ClassName:JCLTest
 * @Description:
 *
 * @author:Yrd
 * @date:2021-6-21 14:14:58
 *
 */
public class JCLTest {

	public void testQuick() throws Exception {
		// 创建日志对象,JCL原理   (优先使用log4j,再使用jul)
		Log log = LogFactory.getLog(JCLTest.class);
		// 日志记录输出
		log.fatal("fatal-JCLTest");
		log.error("error-JCLTest");
		log.warn("warn-JCLTest");
		log.info("info-JCLTest");
		log.debug("debug-JCLTest");
	}
	
	public static void main(String[] args) {
		JCLTest jclTest = new JCLTest();
		try {
			
			jclTest.testQuick();
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
