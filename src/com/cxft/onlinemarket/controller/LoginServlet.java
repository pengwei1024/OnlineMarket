package com.cxft.onlinemarket.controller;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.dao.UserDao;
import com.cxft.onlinemarket.model.User;
import com.cxft.onlinemarket.utils.EncryptionUtils;
import com.cxft.onlinemarket.utils.Sha1Util;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userEmail = request.getParameter("userEmail");
		// 密码被加密，以同等方式加密对比
		String userPassword = EncryptionUtils.createPwd(userEmail,
				request.getParameter("userPassword"));
		UserDao userdao = new UserDao();
		// 用户名密码正确
		User user = userdao.loginCheck(userEmail, userPassword);
		if (user != null) {
			// 1、先判断是否激活
			if (userdao.checkActive(userEmail)) {
				// 2、在判断是否账号被冻结
				if (userdao.checkPermission(userEmail)) {
					request.getSession().setAttribute("user", user);
					request.getSession().setAttribute("username",
							user.getUserName());
					response.sendRedirect(request.getContextPath());
				} else {
					//被冻结返回被冻结信息
					request.setAttribute("Info", "NoPermission");
					request.getRequestDispatcher("/login.jsp").forward(request,
							response);
				}

			} else {
				request.setAttribute("Info", "Notactive");
				request.getRequestDispatcher("/login.jsp").forward(request,
						response);
			}
		} else {
			request.setAttribute("Info", "login_error");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
