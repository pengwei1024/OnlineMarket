package com.cxft.onlinemarket.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.model.Book;

@SuppressWarnings("serial")
public class DelAllCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//清空购物车里面的全部map
		Map<Book,Integer> cartmap =(Map<Book, Integer>) request.getSession().getAttribute("cartmap");
		cartmap.clear();
		//重定向到首页。
		response.sendRedirect(request.getContextPath());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
