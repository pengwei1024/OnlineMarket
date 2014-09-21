package com.cxft.onlinemarket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.base.BaseServlet;
import com.cxft.onlinemarket.dao.UserDao;
import com.cxft.onlinemarket.model.User;

public class ShowUserInfoServlet extends BaseServlet {

	@Override
	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取用户Email
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			UserDao userdao = new UserDao();
			User new_user = userdao.getuser(user.getUserEmail());
			request.setAttribute("user", new_user);
			request.getRequestDispatcher("/personalCenter.jsp").forward(
					request, response);
		} else {
			request.setAttribute("Info", "no_login");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}

	}

}
