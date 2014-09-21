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

public class AddToCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookDao bookdao = new BookDao();
		int Id = Integer.parseInt(request.getParameter("id"));
		List<Book> list_book = bookdao.findBookByID(Id);
		Book book = list_book.get(0);
		if (book == null) {
			System.out.println("找不到该ID对应的商品");
		} else {
			Map<Book, Integer> cartmap = (Map<Book, Integer>) request.getSession().getAttribute("cartmap");
			cartmap.put(book, cartmap.containsKey(book)?cartmap.get(book)+1:1);
			response.sendRedirect(request.getContextPath());

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
