package com.cxft.onlinemarket.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxft.onlinemarket.base.BaseServlet;
import com.cxft.onlinemarket.utils.HttpRequest;
import com.google.json.JSONArray;
import com.google.json.JSONException;
import com.google.json.JSONObject;

@WebServlet("/logistics")
public class Logistics extends BaseServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		//String pid = req.getParameter("pid");
		String url ="http://m.kuaidi100.com/query?type=yunda&postid=1500066330925&id=1&valicode=&temp=1";
		String content = HttpRequest.sendPost(url, "");
		try {
			JSONObject json = new  JSONObject(content);
			req.setAttribute("status", json.get("message"));
			req.setAttribute("com", json.get("com"));
			JSONArray jsonArray = json.getJSONArray("data");
			List<Map<String,String>> list =new ArrayList<Map<String,String>>();
			for(int i=0;i<jsonArray.length();i++){
				Map<String,String> map=new HashMap<String, String>();
				JSONObject jb=jsonArray.getJSONObject(i);
				map.put("time", jb.getString(("time")));
				map.put("context", jb.getString(("context")));
				map.put("ftime", jb.getString(("ftime")));
				list.add(map);
			}
			req.setAttribute("data", list);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/logistics.jsp").forward(req, resp);
	}

}
