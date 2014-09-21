package com.cxft.onlinemarket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.base.BaseServlet;
import com.cxft.onlinemarket.dao.BookDao;

@SuppressWarnings("serial")
public class UpdateBookInfoServlet extends BaseServlet {

	@Override
	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		BookDao bookDao = new BookDao();
		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");
		String bookPublisher = request.getParameter("bookPublisher");
		String bookType = request.getParameter("bookType");
		float bookPrice = Float.parseFloat(request.getParameter("bookPrice"));
		float bookNowPrice = Float.parseFloat(request
				.getParameter("bookNowPrice"));
		String bookPicture = request.getParameter("bookPicture");
		int sale = Integer.parseInt(request.getParameter("sale"));
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		int newBook = Integer.parseInt(request.getParameter("newBook"));
		String bookIntrodution = request.getParameter("bookIntrodution");
		bookDao.updateBookInfo(bookId, bookName, bookAuthor, bookPublisher,
				bookType, bookPrice, bookNowPrice, bookPicture, sale, pnum,
				newBook, bookIntrodution);
		request.getRequestDispatcher("/QueryBookInfoServlet").forward(request,
				response);
	}

}
