package com.dtc.test.qsm.client;

import java.util.List;

import com.dtc.test.qsm.server.dao.orm.tables.pojos.Author;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("RPC")
public interface RpcService extends RemoteService{

	List<Author> getAllAuthor();

	boolean addAuthor(Author data);

	boolean updateAuthor(Author data);

	void deleteAuthor(int id);
}
