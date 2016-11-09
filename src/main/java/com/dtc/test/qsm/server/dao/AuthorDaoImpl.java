package com.dtc.test.qsm.server.dao;

import static com.dtc.test.qsm.server.dao.orm.Tables.AUTHOR;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.dtc.test.qsm.server.dao.orm.tables.records.AuthorRecord;

class BaseDao {
	protected Connection get() {
		try {
			return ConnectionFactory.get();
		} catch (Exception e) {
			return null;
		}
	}

	protected void close(Connection conn) {

	}
}

public class AuthorDaoImpl extends BaseDao implements AuthorDao {
	public Connection conn;

	public List<AuthorRecord> getAllWTF() {
		//write by hand
		Connection conn = get();
		////

		DSLContext create = DSL.using(conn, SQLDialect.H2);
		Result<AuthorRecord> res = create
			.selectFrom(AUTHOR)
			.fetch();

		//write by hand
		close(conn);
		////

		return res;
	}

	@Override
	public List<AuthorRecord> getAll() {
		Connection conn = null;
		Result<AuthorRecord> res = null;
		try {
			conn = ConnectionFactory.get();
			DSLContext create = DSL.using(conn, SQLDialect.H2);
			res = create
				.selectFrom(AUTHOR)
				.fetch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {}
		}
		return res;
	}

	@Override
	public List<AuthorRecord> getAllBeta() {
		Result<AuthorRecord> res = null;
		try {
			DSLContext create = DSL.using(conn, SQLDialect.H2);
			res = create
				.selectFrom(AUTHOR)
				.fetch();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}
}