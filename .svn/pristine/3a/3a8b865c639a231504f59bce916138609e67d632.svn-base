package com.cxft.onlinemarket.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.base.BaseServlet;
import com.cxft.onlinemarket.dao.SiteDao;
import com.cxft.onlinemarket.model.Site;
import com.google.json.JSONObject;

@WebServlet("/site")
public class SiteServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String PATH = "admin/includes/column/siteManage";

	@Override
	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		SiteDao dao =new SiteDao();
		String action = request.getParameter("action");
		action =  action == null ? "" : action;
		if(action.equals("update")){
			String title =request.getParameter("title");
			String keyword = request.getParameter("keyword");
			String describe = request.getParameter("describe");
			
			
			dao.update(title, keyword, describe);
			response.getWriter().write("<h4>修改成功</h4><script type='text/javascript'>setInterval(function(){location.href='"+PATH+"/site.jsp'},2000)</script>");
		
		}else if(action.equals("getSiteData")){
			Site site = dao.get();
			Map<String, String> map =new HashMap<String, String>();
			map.put("title", site.getSite_name());
			map.put("keyword", site.getSite_key());
			map.put("describe", site.getSite_describe());
			JSONObject json =new JSONObject(map);
			response.getWriter().write(json.toString());
		}
		
	}
	
	/**
	 * 
	 * 标准json
	 * {"title":"传习在线书城","keyword":"书城 在线书屋 北京传习","describe":"传习图书-中文网上书店，有小说、少儿、教辅、青春、文艺等40多大品类的图书、特价书。提供图书阅读风向标—畅销榜"}
	 * 
	 * 
	 * 
	 */

}
