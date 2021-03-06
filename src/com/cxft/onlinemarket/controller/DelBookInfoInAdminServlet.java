package com.cxft.onlinemarket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.base.BaseServlet;
import com.cxft.onlinemarket.dao.BookDao;

@SuppressWarnings("serial")
public class DelBookInfoInAdminServlet extends BaseServlet {

	@Override
	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDao bookdao = new BookDao();
		String id = request.getParameter("id");
		bookdao.update(Integer.parseInt(id));
		request.getRequestDispatcher("/QueryBookInfoServlet").forward(request,
				response);
	}

}
