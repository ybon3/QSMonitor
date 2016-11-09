package com.dtc.test.qsm.server.dao;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MyAfterMethod implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		if (target instanceof AuthorDaoImpl) {
			if (((AuthorDaoImpl)target).conn != null) {
				try{
					((AuthorDaoImpl)target).conn.close();
				} catch (Exception e) {}
			}
		}
	}

}
