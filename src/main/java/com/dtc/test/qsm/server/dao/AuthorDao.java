package com.dtc.test.qsm.server.dao;

import static com.dtc.test.qsm.server.dao.orm.Tables.AUTHOR;

import java.sql.Connection;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.dtc.test.qsm.server.dao.orm.tables.pojos.Author;
import com.dtc.test.qsm.server.dao.orm.tables.records.AuthorRecord;

public class AuthorDao extends BaseDao {

	public List<Author> getAll() {
		Connection conn = get();

		DSLContext create = DSL.using(conn, SQLDialect.H2);
		List<Author> res = create
			.selectFrom(AUTHOR)
			.fetchInto(Author.class);

		close(conn);
		return res;
	}


	public boolean add(Author data) {
		boolean isOk = false;
		Connection conn = get();

		DSLContext create = DSL.using(conn, SQLDialect.H2);
		AuthorRecord record = create.newRecord(AUTHOR, data);

		if (create.executeInsert(record) > 0) {
			isOk = true;
		}
		close(conn);

		return isOk;
	}

	public boolean update(Author data) {
		boolean isOk = false;
		Connection conn = get();

		DSLContext create = DSL.using(conn, SQLDialect.H2);
		AuthorRecord record = create.newRecord(AUTHOR, data);
		if (create.executeUpdate(record) > 0) {
			isOk = true;
		}
		close(conn);

		return isOk;
	}

	public void delete(int id) {
		Connection conn = get();

		DSLContext create = DSL.using(conn, SQLDialect.H2);

		AuthorRecord r1 = new AuthorRecord();
		r1.setId(id);

		create
			.deleteFrom(AUTHOR)
			.where(DSL.condition(r1))
			.execute();

		close(conn);
	}
}