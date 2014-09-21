package com.cxft.onlinemarket.dao;

import java.util.HashMap;
import java.util.Map;

import com.cxft.onlinemarket.base.BaseDao;
import com.cxft.onlinemarket.model.Site;

public class SiteDao extends BaseDao<Site> {
	
	private final static String TABLE_NAME = "tb_site";
	
	public void update(String title,String keyword,String describe){
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("site_name", title);
		map.put("site_key", keyword);
		map.put("site_describe", describe);
		super.update(TABLE_NAME, map, null, null);
	}
	
	public Site get(){
		return super.select(TABLE_NAME, null, null, Site.class);
	}

}
