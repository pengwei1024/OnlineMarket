package com.cxft.onlinemarket.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.dao.BookDao;
import com.cxft.onlinemarket.dao.OrderDao;
import com.cxft.onlinemarket.model.Book;
import com.cxft.onlinemarket.model.Order;
import com.cxft.onlinemarket.model.OrderDetail;
import com.cxft.onlinemarket.model.User;

public class OrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			//当用户没登陆时跳转到登录界面
			request.setAttribute("Info", "no_login");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
			Order order = new Order();
			order.setOrderId(UUID.randomUUID().toString());
			order.setUser_ID(user.getUserEmail());
			order.setReceiverName(request.getParameter("receiverName"));
			order.setReceiverAddress(request.getParameter("receiverAddress"));
			order.setReceiverTel(request.getParameter("receiverTel"));
			order.setPayType(request.getParameter("payType"));
			order.setPaystate("0");
			order.setOrderRemark(request.getParameter("orderRemark"));
			Map<Book, Integer> cartmap = (Map<Book, Integer>) request
					.getSession().getAttribute("cartmap");
			double money = 0;
			List<OrderDetail> list = new ArrayList<OrderDetail>();
			for (Map.Entry<Book, Integer> entry : cartmap.entrySet()) {
				money += entry.getKey().getBookPrice() * entry.getValue();
				OrderDetail item = new OrderDetail();
				item.setOrder_id(order.getOrderId());
				item.setBook_id(entry.getKey().getBookId());
				item.setNumber(entry.getValue());
				list.add(item);
			}
			order.setMoney(money);
			order.setList(list);
			OrderDao orderdao = new OrderDao();
			BookDao bookdao = new BookDao();
			orderdao.addOrder(order);
			for (OrderDetail item : order.getList()) {
				orderdao.AddOrderDetail(item);
				bookdao.delnum(item.getBook_id(), item.getNumber());
			}
			// 清空购物车
			cartmap.clear();
			response.getWriter().write("订单生成成功!请去支付!");
			response.setHeader("refresh", "2;url=" + request.getContextPath()+"/OrderListServlet");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
