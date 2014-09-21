package com.cxft.onlinemarket.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.dao.BookDao;
import com.cxft.onlinemarket.model.Book;

public class DelCartInPageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookDao bookdao = new BookDao();
		//删除购物车里面对应ID的书
		int Id = Integer.parseInt(request.getParameter("id"));
		List<Book> list_book = bookdao.findBookByID(Id);
		Book book = list_book.get(0);
		Map<Book, Integer> cartmap = (Map<Book, Integer>) request.getSession()
				.getAttribute("cartmap");
		cartmap.remove(book);
		//删除完成对应ID的书继续留在改页面
		response.sendRedirect(request.getContextPath() +"/cart.jsp");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
