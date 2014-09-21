package com.cxft.onlinemarket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.base.BaseServlet;
import com.cxft.onlinemarket.dao.BookDao;

@SuppressWarnings("serial")
public class DisplayBookServlet extends BaseServlet {

	@Override
	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String string= request.getParameter("type");
		BookDao bookDao = new BookDao();
		if(string.equals("newbook")){
			request.setAttribute("list",bookDao.AllNewBook());
		}if(string.equals("salebook")){
			request.setAttribute("list",bookDao.AllSaleBook());
		}
		if(string.equals("sellingbook")){
			request.setAttribute("list",bookDao.AllSellingBook());
		}
		request.getRequestDispatcher("/book.jsp").forward(request, response);

	}

}
