package com.dtc.test.qsm.server.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.h2.jdbcx.JdbcConnectionPool;

import com.dtc.test.qsm.server.QsmSetting;

public class TestDao {

	private JdbcConnectionPool pool;

	public TestDao() {
		org.h2.Driver.load();

		pool = JdbcConnectionPool.create(
			QsmSetting.dbUrl(),
			QsmSetting.dbUsername(),
			QsmSetting.dbPassword()
		);

		pool.setMaxConnections(QsmSetting.dbPoolMaxConnections());
		pool.setLoginTimeout(QsmSetting.dbPoolLoginTimeout());
	}

	public void test(int i) {
		try {
			int count = 0;
			while (true) {
				System.out.println("=== " + i + " | count: " + count++);
				Connection conn = this.getConnection();
				ResultSet res = conn.createStatement().executeQuery("SELECT * FROM CONTACTS");
/*
				while (res.next()) {
					int size = res.getMetaData().getColumnCount();
					for (int i = 1; i <= size; i++) {
						System.out.print(" | ");
						System.out.print(res.getString(i));
					}
					System.out.println();
				}
*/
				Thread.sleep(5000);
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return pool.getConnection();
	}

	public void destroy() {
		if (pool != null) {
			pool.dispose();
		}
	}
}
