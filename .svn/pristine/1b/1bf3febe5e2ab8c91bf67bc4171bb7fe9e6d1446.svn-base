package com.cxft.onlinemarket.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBCUtils {
	private static Properties pro = null;

	static {
		
	}
	/*
	 * 获取连接
	 */
	public static Connection getConnection() {	
		
		pro = new Properties(); 
		String binPath = System.getProperty("user.dir");  //D:\apache-tomcat-7.0.55\bin
		String filePath = binPath.substring(0, binPath.length()-3)+
				"webapps"+File.separator+"OnlineMarket"+File.separator+
				"WEB-INF"+File.separator+
				"config.properties";	
		try {
			pro.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("配置文件未找到。"+filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		try {
			Class.forName(pro.getProperty("driver"));
			String url = pro.getProperty("url");
			String userName = pro.getProperty("username");
			String password = pro.getProperty("password");
			con = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	/*
	 * 关闭连接
	 */
	public static void close(ResultSet rst,PreparedStatement ps, Statement stm, Connection con) {
		if (rst != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				con = null;
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ps = null;
			}
		}
		if (stm != null) {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stm = null;
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				con = null;
			}
		}
	}

}
