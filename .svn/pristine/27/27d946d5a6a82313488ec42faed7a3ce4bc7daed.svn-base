package com.cxft.onlinemarket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.base.BaseServlet;
import com.cxft.onlinemarket.dao.AdminDao;
import com.cxft.onlinemarket.model.Admin;
import com.cxft.onlinemarket.utils.EncryptionUtils;
import com.cxft.onlinemarket.utils.TimeUtil;

@WebServlet("/adminManage")
public class AdminServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String PATH = "admin/includes/column/siteManage";

	@Override
	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		action = action == null ? "" : action;
		AdminDao  dao =new AdminDao();
		if(action.equals("addAdmin")){
			String email = request.getParameter("email");
			String nickname = request.getParameter("nickname");
			String pwd = request.getParameter("pwd");
			Admin admin =new Admin();
			admin.setAdminEmail(email);
			admin.setAdminName(nickname);
			admin.setAdminPassword(EncryptionUtils.createPwd(email, pwd));
			dao.insert(admin);
			response.getWriter().write("<h4>新增成功</h4><script type='text/javascript'>setInterval(function(){location.href='"+PATH+"/index.jsp'},2000)</script>");
		}else if(action.equals("adminLogin")){
			String uid =request.getParameter("uid");
			String pwd =request.getParameter("pwd");
			
			Cookie ck = new Cookie("uid",uid);
			ck.setMaxAge(7*24*60*60);
			response.addCookie(ck);
			
			if(dao.loginCheck(uid, pwd)){
				response.sendRedirect("admin/main.jsp");
			}else{
				response.sendRedirect("admin/index.jsp?result=error");
			}
		}
	}

}
