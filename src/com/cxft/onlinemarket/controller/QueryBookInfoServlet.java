package com.cxft.onlinemarket.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.base.BaseServlet;
import com.cxft.onlinemarket.dao.BookDao;
import com.cxft.onlinemarket.model.Book;
import com.cxft.onlinemarket.utils.Paging;

@SuppressWarnings("serial")
public class QueryBookInfoServlet extends BaseServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDao bookDao = new BookDao();
		List<Book> list = bookDao.findAllBook();
		String cur_page = request.getParameter("cur_page");
		if (null == cur_page) {
			cur_page = "1";
		}
		int curPage = Integer.parseInt(cur_page);
		Paging page = new Paging(list, curPage, 16);
		list = (ArrayList<Book>) page.getData();
		request.setAttribute("querybook", list);
		String toolBar = page.getToolBar("QueryBookInfoServlet");
		request.setAttribute("toolBar", toolBar);
		request.getRequestDispatcher(
				"/admin/includes/column/goodsManage/query_book_info.jsp")
				.forward(request, response);
	}

}
