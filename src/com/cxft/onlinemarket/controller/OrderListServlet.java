package com.cxft.onlinemarket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.dao.OrderDao;
import com.cxft.onlinemarket.model.Order_ListBean;
import com.cxft.onlinemarket.model.User;

public class OrderListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ�û�email
		User user = (User) request.getSession().getAttribute("user");	

		if(user!=null)
		{
			String id = user.getUserEmail();
			OrderDao orderdao =new OrderDao();
			// �����û�id��ѯ�û����еĶ���
			List<Order_ListBean> list_order = orderdao.findOrdersList(id);
			// 3.����request�����ҳ����ʾ
			request.setAttribute("list", list_order);
			request.getRequestDispatcher("/orderlist.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("Info", "no_login");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}