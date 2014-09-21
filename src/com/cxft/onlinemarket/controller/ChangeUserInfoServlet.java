package com.cxft.onlinemarket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.base.BaseServlet;
import com.cxft.onlinemarket.dao.UserDao;
import com.cxft.onlinemarket.model.User;

public class ChangeUserInfoServlet extends BaseServlet {

	@Override
	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			String uid = user.getUserEmail();
			String swich_value = request.getParameter("value");
			// 提交的用户信息表单
			if (swich_value.equals("1")) {
				UserDao userdao = new UserDao();
				boolean flag;
				String userName = request.getParameter("userName");
				
			//	String cardType = request.getParameter("cardType");
				String cardNumber = request.getParameter("cardNumber");
				String city = request.getParameter("city");
				String sex = request.getParameter("sex");
				String userAddress = request.getParameter("userAddress");
				String userTel = request.getParameter("userTel");
				flag = userdao.updateUserInfo(uid, userName,
						cardNumber, city, sex, userAddress, userTel);
				if (flag) {
					request.setAttribute("Info", "updatesucess");
					request.getRequestDispatcher("/ShowUserInfoServlet").forward(request, response);
				} else {
					request.setAttribute("Info", "failInfo");
					request.getRequestDispatcher("/personalCenter.jsp")
							.forward(request, response);

				}
			}

			// 提交的用户修改密码表单
			if (swich_value.equals("2")) {
				UserDao userdao = new UserDao();
				String old_password = request.getParameter("old_userPassword");
				String new_password = request.getParameter("new_userPassword");
				if (userdao.checkPasWd(uid, old_password)) {
					userdao.Updatepassword(uid, old_password, new_password);
					// 密码修改成功弹窗提醒
					request.setAttribute("Info", "updatesucess");
					Cookie newCookie = new Cookie("JSESSIONID", null);
					newCookie.setMaxAge(0); // 立即删除
					newCookie.setPath("/OnlineMarket/");
					response.addCookie(newCookie); // 重新写入，将覆盖之前的
					request.getRequestDispatcher("/personalCenter.jsp")
							.forward(request, response);
				} else {
					request.setAttribute("Info", "worng");
					request.getRequestDispatcher("/personalCenter.jsp")
							.forward(request, response);
				}
			}
		}
		else{
			request.setAttribute("Info", "no_login");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
