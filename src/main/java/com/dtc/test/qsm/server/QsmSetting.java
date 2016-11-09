package com.dtc.test.qsm.server;

import com.dtc.common.DoubleProperties;

public class QsmSetting extends DoubleProperties {
	private static QsmSetting instance = new QsmSetting();

	private QsmSetting() {
		super("dtc-config.xml", "dtc-qsm.properties");
	}

	public static String dbUrl() {
		return instance.getProperty("db.url");
	}

	public static String dbUsername() {
		return instance.getProperty("db.username");
	}

	public static String dbPassword() {
		return instance.getProperty("db.password");
	}

	public static int dbPoolMaxConnections() {
		try {
			return Integer.parseInt(instance.getProperty("db.pool.max.connections", "30")); // default : 30
		} catch (Exception e) {
			return 30;
		}
	}

	public static int dbPoolLoginTimeout() {
		try {
			return Integer.parseInt(instance.getProperty("db.pool.login.timeout", "30")); // default : 30
		} catch (Exception e) {
			return 30;
		}
	}
}
