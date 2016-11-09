package com.dtc.test.qsm.server.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.h2.Driver;
import org.h2.jdbcx.JdbcConnectionPool;

import com.dtc.test.qsm.server.QsmSetting;

public class ConnectionFactory {
	private static JdbcConnectionPool pool;
	static {
		Driver.load();
		pool = JdbcConnectionPool.create(
			QsmSetting.dbUrl(),
			QsmSetting.dbUsername(),
			QsmSetting.dbPassword()
		);
		pool.setMaxConnections(QsmSetting.dbPoolMaxConnections());
		pool.setLoginTimeout(QsmSetting.dbPoolLoginTimeout());
	}

	public static Connection get() throws SQLException {
		return pool.getConnection();
	}
}
