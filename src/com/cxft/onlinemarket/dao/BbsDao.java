package com.cxft.onlinemarket.dao;


import java.util.List;
import java.util.Map;

import com.cxft.onlinemarket.base.BaseDao;
import com.cxft.onlinemarket.model.BBS;

/**
 * 公告管理类
 * @author pengwei
 *
 */
public class BbsDao extends BaseDao<BBS> {

	private static final String TABLE_NAME = "tb_bbs";
	
	public BbsDao(){
		
	}
	
	/**
	 * 增加新公告
	 * @param bbs
	 */
	public void addBbs(BBS bbs){
		super.insert(TABLE_NAME, bbs);
	}
	
	/**
	 * 获得一条公告
	 * @param bid
	 * @return
	 */
	public BBS get(int bid){
		return super.select(TABLE_NAME, "bbsId=?", new Object[]{bid},BBS.class);
	}
	
	/**
	 * 获取所有公共
	 * @return
	 */
	public List<BBS> getList(){
		return super.getList(TABLE_NAME, null, null, BBS.class);
	}
	
	/**
	 * 删除公告
	 * @param bid
	 * @return
	 */
	public boolean delBbs(int bid){
		return super.detele(TABLE_NAME, "bbsId=?", new Object[]{bid})>0;
	}
	
	/**
	 * 修改公告
	 * @param map
	 * @param where
	 * @param whereArgs
	 */
	public void update(Map<String,Object> map,String where,Object[] whereArgs){
		super.update(TABLE_NAME, map, where, whereArgs);
	}

}
