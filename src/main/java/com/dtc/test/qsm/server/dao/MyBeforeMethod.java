package com.dtc.test.qsm.server.dao;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeMethod implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object target) throws Throwable {
		if (target instanceof AuthorDaoImpl) {
			((AuthorDaoImpl)target).conn = ConnectionFactory.get();
		}
	}
}
