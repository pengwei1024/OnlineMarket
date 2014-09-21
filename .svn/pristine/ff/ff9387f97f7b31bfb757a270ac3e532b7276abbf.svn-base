package com.cxft.onlinemarket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.dao.AdminDao;

public class AdminLoginServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String adminName=request.getParameter("adminName");
		String adminPassword =request.getParameter("adminPassword");
		AdminDao  dao = new AdminDao();
		//管理员用户名密码正确
		if(dao.loginCheck(adminName, adminPassword)){
			
		}//管理员用户名密码错误
		else{
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
