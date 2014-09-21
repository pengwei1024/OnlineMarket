package com.cxft.onlinemarket.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.base.BaseServlet;
import com.cxft.onlinemarket.dao.UserDao;

/**
 * 用户激活用户
 * @author pengwei
 *
 */
public class ActiveUser extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid = request.getParameter("uid");
		String token = request.getParameter("token");
		String time = request.getParameter("time");
		UserDao user =new UserDao();
		PrintWriter pw =response.getWriter();	
		if(user.check(uid, token)){
			user.setActive(uid);
			pw.write("激活成功，正在跳转到登录页面。");
			response.setHeader("refresh","2;url=" + request.getContextPath()+"/login.jsp");
		}else{
			pw.write("激活过程出现异常，请重新发送邮件激活");
			response.setHeader("refresh","2;url=" + request.getContextPath()+"/register.jsp");
		}
		
	}

}
