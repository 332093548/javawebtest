package cn.dw.utils;

import org.aspectj.lang.JoinPoint;

public class AopClass {
	
	public void logs(JoinPoint jp) {
		System.out.println("日志入库........");
		System.out.println("被切的目标对象" + jp.getTarget());
		System.out.println("被切方法" + jp.getSignature());
		System.out.println("被切参数"+jp.getArgs());
	}
	
	public void ex(Exception e) {
		System.out.println("异常处理==>" + e);
	}
	
}
