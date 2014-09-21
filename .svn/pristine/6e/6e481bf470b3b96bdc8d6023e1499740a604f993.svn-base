package com.cxft.onlinemarket.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.base.BaseServlet;
import com.cxft.onlinemarket.dao.OrderDao;
import com.cxft.onlinemarket.model.Order;
import com.cxft.onlinemarket.utils.Paging;

@SuppressWarnings("serial")
@WebServlet("/queryoneorderinfo")
public class QueryOneOrderServlet extends BaseServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		OrderDao dao = new OrderDao();
		List<Order> list = dao.findOrderByEmail(userId);
		String cur_page = request.getParameter("cur_page");
		if (null == cur_page) {
			cur_page = "1";
		}
		int curPage = Integer.parseInt(cur_page);
		Paging page = new Paging(list, curPage, 10);
		list = (ArrayList<Order>) page.getData();
		request.setAttribute("order_list", list);
		String toolBar = page.getToolBar("QueryOneOrderServlet");
		request.setAttribute("toolBar", toolBar);

		request.getRequestDispatcher(
				"/admin/includes/column/orderManage/query_order.jsp").forward(
				request, response);
	}

}
