package com.dtc.test.qsm.server.dao;

import java.util.List;

import com.dtc.test.qsm.server.dao.orm.tables.records.AuthorRecord;

public interface AuthorDao {
	public List<AuthorRecord> getAll();
	public List<AuthorRecord> getAllBeta();
}
