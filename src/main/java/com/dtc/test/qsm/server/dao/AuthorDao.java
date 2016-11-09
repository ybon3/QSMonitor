package com.dtc.test.qsm.server.dao;

import static com.dtc.test.qsm.server.dao.orm.Tables.AUTHOR;

import java.sql.Connection;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.dtc.test.qsm.server.dao.orm.tables.records.AuthorRecord;

public class AuthorDao extends BaseDao {

	public List<AuthorRecord> getAll() {
		Connection conn = get();

		DSLContext create = DSL.using(conn, SQLDialect.H2);
		Result<AuthorRecord> res = create
			.selectFrom(AUTHOR)
			.fetch();

		close(conn);
		return res;
	}
}