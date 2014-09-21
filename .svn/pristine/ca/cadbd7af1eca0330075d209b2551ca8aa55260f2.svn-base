package com.cxft.onlinemarket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.base.BaseServlet;
import com.cxft.onlinemarket.dao.OrderDao;

@SuppressWarnings("serial")
@WebServlet("/deleteorder")
public class DeleteOrderServlet extends BaseServlet {

	@Override
	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderDao dao = new OrderDao();
		String[] orderIds = request.getParameterValues("orderId");
		dao.deleteItem(orderIds);
		dao.delete(orderIds);
		request.getRequestDispatcher("/QueryOrderListServlet").forward(request,
				response);
	}

}
