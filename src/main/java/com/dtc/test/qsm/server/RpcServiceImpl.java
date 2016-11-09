package com.dtc.test.qsm.server;

import java.util.List;

import com.dtc.test.qsm.client.RpcService;
import com.dtc.test.qsm.server.dao.AuthorDao;
import com.dtc.test.qsm.server.dao.orm.tables.pojos.Author;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RpcServiceImpl extends RemoteServiceServlet implements RpcService {
	private static final long serialVersionUID = 1L;

	@Override
	public List<Author> getAllAuthor() {
		System.out.println("== getAllAuthor() ===========================");
		AuthorDao dao = new AuthorDao();
		return dao.getAll();
	}

	@Override
	public boolean addAuthor(Author data) {
		System.out.println("== addAuthor() ===========================");
		AuthorDao dao = new AuthorDao();
		return dao.add(data);
	}

	@Override
	public boolean updateAuthor(Author data) {
		System.out.println("== updateAuthor() ===========================");
		AuthorDao dao = new AuthorDao();
		return dao.update(data);
	}

	@Override
	public void deleteAuthor(int id) {
		System.out.println("== deleteAuthor() ===========================");
		AuthorDao dao = new AuthorDao();
		dao.delete(id);
	}
}
