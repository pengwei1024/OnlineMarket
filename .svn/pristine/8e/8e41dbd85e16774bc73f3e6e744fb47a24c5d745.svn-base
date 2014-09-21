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
import com.cxft.onlinemarket.model.OrderDetail;
import com.cxft.onlinemarket.utils.Paging;

@SuppressWarnings("serial")
@WebServlet("/queryorderinfo")
public class QueryOrderInfoServlet extends BaseServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderDao dao = new OrderDao();
		String orderId = request.getParameter("orderId");
		// ¶©µ¥
		String sql = "select * from tb_order where orderId='" + orderId + "'";
		List<Order> list = new ArrayList<Order>();
		list = dao.findOrder(sql);
		// ¶©µ¥Ïî
		List<OrderDetail> list_item = dao.findOrderDeitelById(orderId);

		request.setAttribute("list_item", list_item);

		String cur_page = request.getParameter("cur_page");
		if (null == cur_page) {
			cur_page = "1";
		}
		int curPage = Integer.parseInt(cur_page);
		Paging page = new Paging(list, curPage, 1);
		list = (ArrayList<Order>) page.getData();
		request.setAttribute("list", list);
		String toolBar = page.getToolBar("QueryOrderInfoServlet");
		request.setAttribute("toolBar", toolBar);
		request.getRequestDispatcher(
				"/admin/includes/column/orderManage/query_order_info.jsp")
				.forward(request, response);
	}
}
