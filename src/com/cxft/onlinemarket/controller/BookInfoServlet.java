package com.cxft.onlinemarket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.dao.BookDao;
import com.cxft.onlinemarket.model.Book;

public class BookInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 调用Bookdao获取全部书的信息
		BookDao bookdao = new BookDao();
		int Id = Integer.parseInt(request.getParameter("id"));
		List<Book> list_book = bookdao.findBookByID(Id);
		Book book = list_book.get(0);
		if(book==null){
			System.out.println("找不到该ID对应的商品");
		}else{
			request.setAttribute("book", book);
			request.setAttribute("name", "神兽护体,代码无bug");
			request.getRequestDispatcher("/product.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
