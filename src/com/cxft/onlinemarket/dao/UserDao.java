package com.cxft.onlinemarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cxft.onlinemarket.base.BaseDao;
import com.cxft.onlinemarket.model.User;
import com.cxft.onlinemarket.utils.EncryptionUtils;
import com.cxft.onlinemarket.utils.JDBCUtils;

public class UserDao extends BaseDao<User> {

	/**
	 * 根据邮箱密码查找用户，登录验证
	 * 
	 * @param UseEmail
	 * @param userPassword
	 * @return
	 */
	public User loginCheck(String UseEmail, String userPassword) {
		User user = null;
		Connection con = JDBCUtils.getConnection();
		String sql = "select * from tb_user where UserEmail='" + UseEmail
				+ "'  and userPassword='" + userPassword + "'";
		Statement stm = null;
		ResultSet rst = null;
		try {
			stm = con.createStatement();
			rst = stm.executeQuery(sql);
			if (rst.next()) {
				user = new User();
				user.setUserName(rst.getString("username"));
				user.setUserEmail(rst.getString("userEmail"));
				user.setUserPassword(rst.getString("userPassword"));
				user.setUserTel(rst.getString("userTel"));
				user.setUserAddress(rst.getString("UserAddress"));
				user.setSex(rst.getString("sex"));
				user.setCardType(rst.getString("cardType"));
				user.setCardNumber(rst.getString("cardNumber"));
				user.setCity(rst.getString("city"));
				user.setPostCode(rst.getInt("postCode"));
				user.setGrade(rst.getString("grade"));
				user.setToken(rst.getString("token"));
				user.setRegisterTime(rst.getTimestamp("registerTime"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rst, null, stm, con);
		}
		return user;
	}

	public User getuser(String uid)
	{
		String sql ="SELECT * FROM `tb_user` WHERE UserEmail='"+uid+"'";
		try {
			User user = null;
			ResultSet rst = null;
			rst=query(sql);
			while(rst.next())
			{
				user = new User();
				user.setUserName(rst.getString("username"));
				user.setUserEmail(rst.getString("userEmail"));
				user.setUserPassword(rst.getString("userPassword"));
				user.setUserTel(rst.getString("userTel"));
				user.setUserAddress(rst.getString("UserAddress"));
				user.setSex(rst.getString("sex"));
				user.setCardType(rst.getString("cardType"));
				user.setCardNumber(rst.getString("cardNumber"));
				user.setCity(rst.getString("city"));
				user.setPostCode(rst.getInt("postCode"));
				user.setGrade(rst.getString("grade"));
				user.setToken(rst.getString("token"));
				user.setRegisterTime(rst.getTimestamp("registerTime"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据email和token值判断用户账号是否正确
	 * 
	 * @param uid
	 * @param token
	 * @return
	 */
	public boolean check(String uid, String token) {
		Connection con = JDBCUtils.getConnection();
		String sql = "select count(*) as count from tb_user where UserEmail='"
				+ uid + "'  and token='" + token + "' limit 1";
		Statement stm = null;
		ResultSet rst = null;
		try {
			stm = con.createStatement();
			rst = stm.executeQuery(sql);
			if (rst.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 通过email查找用户, 注册时避免用户邮箱已注册冲突
	 * 
	 * @param userEmail
	 * @return
	 */
	public boolean findUserByUserEmail(String userEmail) {
		Connection con = JDBCUtils.getConnection();
		Statement stm = null;
		ResultSet rst = null;
		String sql = "select * from tb_user where userEmail='" + userEmail
				+ "'";
		try {
			stm = con.createStatement();
			rst = stm.executeQuery(sql);
			if (rst.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rst, null, stm, con);
		}
		return false;
	}

	/**
	 * 新用户注册
	 * 
	 * @param user
	 */
	public void registerUser(User user) {
		Connection con = JDBCUtils.getConnection();
		String sql = "insert into tb_user(userName,userPassword,userEmail,token) values(?,?,?,?) ";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPassword());
			ps.setString(3, user.getUserEmail());
			ps.setString(4, user.getToken());
			// 执行注册
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, ps, null, con);
		}
	}

	/**
	 * 用户修改个人信息
	 * 
	 * @param userEmail用做找到对应表项
	 * @param userName
	 * @param cardType
	 * @param cardNumber
	 * @param city
	 * @param sex
	 * @param userAddress
	 * @param userTel
	 */

	public boolean updateUserInfo(String userEmail, String userName,
			 String cardNumber, String city, String sex,
			String userAddress, String userTel) {
		//boolean flag = false;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", userName);
		map.put("cardNumber", cardNumber);
		map.put("city", city);
		map.put("sex", sex);
		map.put("userAddress", userAddress);
		map.put("userTel", userTel);
		if(super.update("tb_user", map,  "userEmail=?", new Object[] { userEmail })==1)
		{
			return true;
		}
		return false;
	}

	/**
	 * 激活用户
	 * 
	 * @param uid
	 */
	public void setActive(String uid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("activeMail", 1);
		super.update("tb_user", map, "userEmail=?", new Object[] { uid });
	}

	/**
	 * 检验对用iD的用户账号是否处于激活状态
	 * 
	 * @param uid
	 * @return
	 */
	public boolean checkActive(String uid) {
		ResultSet rst = super.select("tb_user", new String[] { "activeMail" },
				"userEmail=? and activeMail=?", new Object[] { uid, "1" });
		try {
			rst.last();
			if (rst.getRow() == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 冻结用户
	 * 
	 * @param uid
	 */
	public void setPermission(String uid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("grade", 1);
		super.update("tb_user", map, "userEmail=?", new Object[] { uid });
	}
	/**
	 * 解除用户
	 * 
	 * @param uid
	 */
	public void clearPermission(String uid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("grade", 0);
		super.update("tb_user", map, "userEmail=?", new Object[] { uid });
	}
	
	/**
	 * 检验对用iD的用户账号是否处冻结状态
	 * 
	 * @param uid
	 * @return
	 */
	public boolean checkPermission(String uid) {
		ResultSet rst = super.select("tb_user", new String[] { "grade" },
				"userEmail=? and grade=?", new Object[] { uid, "0" });
		try {
			rst.last();
			if (rst.getRow() == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 检验密码是否正确
	 * 
	 * @param uid
	 * @return
	 */
	public boolean checkPasWd(String uid, String paswd) {
		String userPassword = EncryptionUtils.createPwd(uid, paswd);
		ResultSet rst = super.select("tb_user",
				new String[] { "userPassword" },
				"userEmail=? and userPassword=?", new Object[] { uid,
						userPassword });
		try {
			rst.last();
			if (rst.getRow() == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改密码
	 * 
	 * @param id用户邮箱
	 * @param oldpasswd用户原始密码
	 * @param new_password用户新密码
	 */
	public void Updatepassword(String id, String oldpasswd, String new_password) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 密码加密
		String old_userPassword = EncryptionUtils.createPwd(id, oldpasswd);
		String new_userPassword = EncryptionUtils.createPwd(id, new_password);
		map.put("userPassword", new_userPassword);
		super.update("tb_user", map, "userEmail=? and userPassword=?",
				new Object[] { id, old_userPassword });
	}

	/**
	 * 查找用户
	 * 
	 * @param sql
	 * @return
	 */
	public List<User> findUser(String sql) {
		List<User> list = new ArrayList<User>();
		User user = null;
		Connection con = JDBCUtils.getConnection();
		Statement stm = null;
		ResultSet rst = null;
		try {
			stm = con.createStatement();
			rst = stm.executeQuery(sql);
			while (rst.next()) {
				user = new User();
				user.setUserName(rst.getString("userName"));
				user.setSex(rst.getString("sex"));
				user.setUserEmail(rst.getString("userEmail"));
				user.setCardType(rst.getString("cardType"));
				user.setCardNumber(rst.getString("cardNumber"));
				user.setCity(rst.getString("city"));
				user.setUserAddress(rst.getString("userAddress"));
				user.setPostCode(rst.getInt("postCode"));
				user.setUserTel(rst.getString("userTel"));
				user.setGrade(rst.getString("grade"));
				user.setRegisterTime(rst.getTimestamp("registerTime"));
				list.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rst, null, stm, con);
		}
		return list;
	}

	/**
	 * 根据邮箱查询某个用户
	 * 
	 * @param email
	 * @return
	 */
	public List<User> findUserByEmail(String email) {
		String sql = "SELECT * FROM tb_user WHERE userEmail ='" + email + "'";
		return findUser(sql);
	}

	/**
	 * 根据用户名查询多个用户
	 * 
	 * @param name
	 * @return
	 */
	public List<User> findUserByUserName(String name) {
		String sql = "select * from tb_user where userName='" + name + "'";
		return findUser(sql);
	}

	/**
	 * 根据电话号码查询多个用户
	 * 
	 * @param tel
	 * @return
	 */
	public List<User> findUserByUserTel(String tel) {
		String sql = "select * from tb_user where userTel='" + tel + "'";
		return findUser(sql);
	}

	/**
	 * 根据用户等级查询多个用户
	 * 
	 * @param grade
	 * @return
	 */
	public List<User> findUserByGrade(String grade) {
		String sql = "select * from tb_user where grade='" + grade + "'";
		return findUser(sql);
	}

}