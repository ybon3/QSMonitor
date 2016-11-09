package com.dtc.test.qsm.server.dao;

import java.sql.Connection;

public class BaseDao {
	protected Connection get() {
		try {
			return ConnectionFactory.get();
		} catch (Exception e) {
			return null;
		}
	}

	protected void close(Connection conn) {
		try {
			if (conn != null) { conn.close(); }
		} catch (Exception e) {}
	}
}
