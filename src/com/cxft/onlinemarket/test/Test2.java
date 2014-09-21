package com.cxft.onlinemarket.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.cxft.onlinemarket.base.BaseDao;

public class Test2 extends BaseDao<TestBean> {
	public Test2(){
		
	}
	
	public String select() throws SQLException{
		ResultSet rs =select("test",null,"score=?",new Object[]{70});
		String p ="";
		while(rs.next()){
			String t="[";
			t+=rs.getString("uid")+rs.getString("pwd")+"]";
			p+=t;
		}
		return p;
	}
	
	public int update(){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("score",80);
		return update("test", map, "score=?", new Object[]{70});
		
	}
	
	public int getNum(){
		return getRowNum("select * from test");
	}
	
	public void delete(){
		detele("test", "uid=?", new Object[]{"pw"});
	}
	
	public void insert(){
		TestBean t =new TestBean();
		t.setUid("pw");
		t.setPwd("123456");
		t.setScore(70);
		insert("test", t);
	}
	
	public void insert2(){
		insert("test", "uid,pwd,score", "'pw','123',50");
	}
}
