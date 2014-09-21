package com.cxft.onlinemarket.controller;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.base.BaseServlet;
import com.cxft.onlinemarket.dao.BookDao;
import com.cxft.onlinemarket.model.Book;

@WebServlet("/searchbox")
public class searchBox extends BaseServlet{

	@Override
	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BookDao bookDao = new BookDao();
		String key=new String(request.getParameter("key").getBytes("ISO-8859-1"),"UTF-8");
		 List<Book> list=bookDao.searchBook(key);
		 if(list!=null){
		request.setAttribute("list",list );
		request.setAttribute("key",key );
		request.getRequestDispatcher("/searchInterface.jsp").forward(request, response);
		 }
	}
}
