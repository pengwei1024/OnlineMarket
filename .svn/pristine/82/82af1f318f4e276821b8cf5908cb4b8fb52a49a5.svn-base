package com.cxft.onlinemarket.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.base.BaseServlet;

//注意!!通过注解配置servlet访问路径  ，访问路径为 localhost:8080/项目名/pw
@WebServlet("/pw")
public class Test extends BaseServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().write("你好世界");
	}
}