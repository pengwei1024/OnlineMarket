package com.cxft.onlinemarket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.base.BaseServlet;
import com.cxft.onlinemarket.dao.OrderDao;

@SuppressWarnings("serial")
@WebServlet("/deliveryservlet")
public class DeliveryServlet extends BaseServlet {

	@Override
	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String orderId= request.getParameter("orderId");
		System.out.println(orderId);
		String express= request.getParameter("express");
		System.out.println(express);
		String expressId = request.getParameter("expressId");
		System.out.println(expressId);
		OrderDao dao = new OrderDao();
		dao.addDeliveryInfo(orderId, express, expressId);
		request.getRequestDispatcher(
				"/QueryOrderListServlet").forward(
				request, response);
	}

}
