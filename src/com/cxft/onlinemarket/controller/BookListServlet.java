package com.cxft.onlinemarket.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.dao.BookDao;
import com.cxft.onlinemarket.model.Book;

public class BookListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//调用Bookdao获取全部书的信息
		BookDao bookdao =new BookDao();
		/*
		 * 新书
		 */
		List<Book> list_newBook =bookdao.newBook();
/*		Iterator<Book> its=list_newBook.iterator();
		while(its.hasNext())
		{
			System.out.println(its.next().getBookName());
		}*/
		request.setAttribute("list_newBook", list_newBook);
		/*
		 * 特价书
		 */
		List<Book> list_saleBook =bookdao.saleBook();
		request.setAttribute("list_saleBook", list_saleBook);
		/*
		 * 畅销书
		 */
		List<Book> list_sellingBook =bookdao.sellingBook();
		request.setAttribute("list_sellingBook", list_sellingBook);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		//response.sendRedirect(request.getContextPath() + "/index.jsp");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
