package com.cxft.onlinemarket.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.base.BaseServlet;
import com.cxft.onlinemarket.dao.BbsDao;
import com.cxft.onlinemarket.model.BBS;
import com.cxft.onlinemarket.utils.TimeUtil;

@WebServlet("/bbs")
public class BbsTest extends BaseServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		BbsDao dao = new BbsDao();
		
		//新增公告用例
		/*
		BBS bbs =new BBS();
		bbs.setAuthor("gzm@qq.com");
		bbs.setBbsId(0);
		bbs.setContent("gzm发送的公告");
		bbs.setInTime(String.valueOf(TimeUtil.getCurrentTime()));
		bbs.setTitle("你是好人");
		dao.addBbs(bbs);
		response.getWriter().write("新增成功");
		*/
		
	
		
		//查询公告用例	
		/*
		BBS b = dao.get(1);
		response.getWriter().write(b.getTitle()+b.getContent());
		*/
		
		
		//删除公告用例
		/*
	    boolean b = dao.delBbs(2);
		response.getWriter().write("删除成功"+b);
		*/
		
		
		//查询队列用例
		List<BBS> list = dao.getList();
		response.getWriter().write("当前总条数："+list.size());
	}

}
