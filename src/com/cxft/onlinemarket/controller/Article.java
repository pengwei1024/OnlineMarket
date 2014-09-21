package com.cxft.onlinemarket.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.base.BaseServlet;
import com.cxft.onlinemarket.dao.BbsDao;
import com.cxft.onlinemarket.model.BBS;
import com.cxft.onlinemarket.utils.TimeUtil;
import com.google.json.JSONObject;

@WebServlet("/article")
public class Article extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String PATH = "admin/includes/column/noticeManage";

	@Override
	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		BbsDao dao = new BbsDao();
		String action = request.getParameter("action");
		action = action == null ? "" : action;
		// 首页列表
		if (action.equals("getList")) {
			List<BBS> list = dao.getList();
			String output = "<dt>最新动态</dt>";
			for (BBS bbs : list) {
				if(TimeUtil.betweenDays(Long.parseLong(bbs.getInTime())) < 5){
					output += "<dd><a href='article?aid=" + bbs.getBbsId() + "'>"
							+ bbs.getTitle() + "</a><img src='images/new_icon.gif'/></dd>";
				}else{
					output += "<dd><a href='article?aid=" + bbs.getBbsId() + "'>"
							+ bbs.getTitle() + "</a></dd>";
				}
				
			}
			response.getWriter().write(output);

			// 跳转到文章内容页
		} 
		else if(action.equals("deleteBbs")){
			String aid = request.getParameter("bid");
			dao.delBbs(Integer.parseInt(aid));
			response.getWriter().write("<h4>删除成功</h4><script type='text/javascript'>setInterval(function(){location.href='"+PATH+"/show.jsp'},2000)</script>");
		}else if(action.equals("addArticle")){
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String time = String.valueOf(TimeUtil.getCurrentTime());
			String author = "wei8888go@qq.com";
			BBS bbs = new BBS();
			bbs.setAuthor(author);
			bbs.setBbsId(0);
			bbs.setContent(content);
			bbs.setInTime(time);
			bbs.setTitle(title);
			dao.addBbs(bbs);
			response.getWriter().write("<h4>添加成功</h4><script type='text/javascript'>setInterval(function(){location.href='"+PATH+"/show.jsp'},2000)</script>");
		}
		else if(action.equals("updateArticle")){
			String id = request.getParameter("bbsid");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String time = String.valueOf(TimeUtil.getCurrentTime());
			String author = "wei8888go@qq.com";
			Map<String,Object> map =new HashMap<String,Object>();
			map.put("title", title);
			map.put("content", content);
			map.put("inTime", time);
			map.put("author", author);
			dao.update(map, "bbsId=?", new Object[]{Integer.parseInt(id)});
			response.getWriter().write("<h4>更新成功</h4><script type='text/javascript'>setInterval(function(){location.href='"+PATH+"/show.jsp'},2000)</script>");
		}
		else {
			String aid = request.getParameter("aid");
			int num = aid == null ? 1 : Integer.parseInt(aid);

			BBS bbs = dao.get(num);
			bbs.setInTime(TimeUtil.getYmdHmW(Long.parseLong(bbs.getInTime())));
			request.setAttribute("data", bbs);
			request.getRequestDispatcher("/article.jsp").forward(request,
					response);
		}

	}

}
