package com.cxft.onlinemarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cxft.onlinemarket.base.BaseDao;
import com.cxft.onlinemarket.model.Admin;
import com.cxft.onlinemarket.model.User;
import com.cxft.onlinemarket.utils.EncryptionUtils;
import com.cxft.onlinemarket.utils.JDBCUtils;

public class AdminDao extends BaseDao<Admin> {
	
	private final static String TABLE_NAME = "tb_admin";

	// 管理员登陆验证
	public boolean loginCheck(String uid, String pwd) {
		pwd = EncryptionUtils.createPwd(uid, pwd);
		Admin admin = super.select(TABLE_NAME, "adminEmail=? and adminPassword=?", new Object[]{uid,pwd}, Admin.class);
		return admin != null;
	}

	// 查询用户
	public List<User> findUser() {
		Statement stm = null;
		ResultSet rst = null;
		Connection con = JDBCUtils.getConnection();
		List<User> list = new ArrayList<User>();
		try {
			stm = con.createStatement();
			String sql = "select * from tb_user";
			rst = stm.executeQuery(sql);
			while (rst.next()) {
				User user = new User();
				user.setUserName(rst.getString("userName"));
				user.setUserTel(rst.getString("userTel"));
				list.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rst, null, stm, con);
		}
		return list;
	}

	// 根据用户ID删除用户(批量删除)
	public void delete(int[] userIds) {
		Connection con = JDBCUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from tb_user where userId=?";
		try {
			ps = con.prepareStatement(sql);
			for (int userId:userIds){
				ps.setInt(1, userId);
				ps.addBatch();
			}
			ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, ps, null, con);
		}
	}
	
	public void insert(Admin admin){
		super.insert(TABLE_NAME, admin);
	}
	
	public List<Admin> getList(){
		return super.getList(TABLE_NAME, null, null, Admin.class);
	}

}
