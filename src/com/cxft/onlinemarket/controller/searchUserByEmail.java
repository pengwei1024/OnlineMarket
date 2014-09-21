package com.cxft.onlinemarket.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.cxft.onlinemarket.base.*;
import com.cxft.onlinemarket.dao.UserDao;
import com.cxft.onlinemarket.model.Book;
import com.cxft.onlinemarket.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
@WebServlet("/searchbyemail")
public class searchUserByEmail extends BaseServlet {
	public void Error(){
	String msg="Email不能为空！";
	int type=JOptionPane.YES_NO_CANCEL_OPTION;
	String title="信息提示";
	
		
	}

	@Override
	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String useremail=request.getParameter("userEmail");
		System.out.println("!!!!");
	System.out.println(useremail);
		UserDao userdao=new UserDao();
		 List<User> list=userdao.findUserByEmail(useremail);
		 if(list!=null){
				request.setAttribute("list",list );
				request.getRequestDispatcher("/admin/includes/column/userManage/show.jsp").forward(request, response);
				 }
	}

	

}
