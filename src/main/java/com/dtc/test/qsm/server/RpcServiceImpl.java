package com.dtc.test.qsm.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dtc.test.qsm.client.RpcService;
import com.dtc.test.qsm.server.dao.AuthorDao;
import com.dtc.test.qsm.server.dao.orm.tables.records.AuthorRecord;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RpcServiceImpl extends RemoteServiceServlet implements RpcService {
	private static final long serialVersionUID = 1L;


	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		AuthorDao dao = (AuthorDao)context.getBean("authorDao");
		List<AuthorRecord> result = dao.getAll();

		System.out.println("== AUTHOR ===========================");
		for (AuthorRecord r : result) {
			for (int i = 0; i < r.size(); i++) {
				if (i != 0) {
					System.out.print(" | ");
				}
				System.out.print(r.get(i));
			}
			System.out.println();
		}
	}

//	@Override
//	public List<AuthorRecord> getAllAuthor() {
//		System.out.println("== getAllAuthor() ===========================");
//		ArrayList<AuthorRecord> res = new ArrayList<>();
//		AuthorDao dao = new AuthorDao();
//		res.addAll(dao.getAll());
//		return res;
//	}
}
