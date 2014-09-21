package com.cxft.onlinemarket.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import java.util.Map;
import java.util.Set;

import com.cxft.onlinemarket.utils.JDBCUtils;

public abstract class BaseDao<T> {

	private Connection conn;

	public BaseDao() {
		conn = JDBCUtils.getConnection();
	}
	
	/**
	 * 执行sql语句并返回ResultSet集合
	 * @param sql
	 * @return
	 */
	protected final ResultSet query(String sql) throws SQLException{
		PreparedStatement ps = null;
		ResultSet rst = null;
		try {
			ps = conn.prepareStatement(sql);
			rst = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rst;
	}
	
	/**
	 * 执行update语句 (包括delete，insert，update)
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	protected final int update(String sql) throws SQLException{
		PreparedStatement ps = null;
		int  count = 0;
		try {
			ps = conn.prepareStatement(sql);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(null, ps, null, conn);
		}
		return count;
	}
	

	/**
	 * 执行sql语句并返回ResultSet结果集
	 * @param tableName 数据库表明
	 * @param projection  选择的列名
	 * @param where where语句
	 * @param whereArgs where语句的参数
	 * @return ResultSet结果集
	 */
	protected  ResultSet select(String tableName, String[] projection,String where, Object[] whereArgs) {
		String selectParam = "*";
		if(projection != null && projection.length != 0){
			for(String str : projection)
				selectParam += str +",";
			selectParam = selectParam.substring(1,selectParam.length()-1);
		}
		where = where==null?"":" where " + where;
		String sql = "select "+selectParam+" from " + tableName  + where;
		PreparedStatement ps = null;
		ResultSet rst = null;
		try {
			ps = conn.prepareStatement(sql);
			if (whereArgs != null) {
				for (int i = 0; i < whereArgs.length; i++) {
					if (whereArgs[i] instanceof Integer) {
						ps.setInt(i + 1, (Integer) whereArgs[i]);
					} else if (whereArgs[i] instanceof String) {
						ps.setString(i + 1, (String) whereArgs[i]);
					} else if (whereArgs[i] instanceof Float) {
						ps.setFloat(i + 1, (Float) whereArgs[i]);
					} else if (whereArgs[i] instanceof Double) {
						ps.setDouble(i + 1, (Double) whereArgs[i]);
					}
				}
			}
			rst = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rst;
	}
	
	/**
	 * 查询一条记录并返回对象
	 * @param tableName
	 * @param where
	 * @param c
	 * @return
	 */

	protected T select(String tableName, String where,Object[] whereArgs, Class<T> c){
		List<T> list = getList(tableName, where, whereArgs, c);
		return list.size()>0?list.get(0):null;
	}

	/**
	 * 删除操作
	 * @param tableName 数据库表名
	 * @param where where参数
	 * @param whereArgs where参数的值
	 * @return 受影响的条数
	 */
	protected int detele(String tableName, String where, Object[] whereArgs) {
		PreparedStatement ps = null;
		where = where==null?"":" where " + where;
		String sql = "delete  from " + tableName + where;
		int count =0;
		try {
			ps = conn.prepareStatement(sql);
			if(whereArgs != null)
				for(int i=0 ;i<whereArgs.length;i++)
					ps.setObject(i+1, whereArgs[i]);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, ps, null, conn);
		}
		return count;
	}

	/**
	 * 更新数据
	 * @param tableName 数据库表名
	 * @param map map集合
	 * @param where where条件
	 * @param whereArgs where具体参数
	 * @return 受影响的条数
	 */
	protected int update(String tableName, Map<String,Object> map,String where,Object[] whereArgs) {
		int count =0;
		PreparedStatement ps = null;
		String updateParam = "";
		Set<String> set = map.keySet();
		for(Iterator<String> it=set.iterator();it.hasNext();){
			String s = it.next();
			Object o =map.get(s);
			if(o instanceof Integer ||o instanceof Float||o instanceof Double){
				updateParam += s+"="+o+",";
			}else if(o instanceof String||o instanceof Character){
				updateParam += s+"='"+o+"',";
			}
		}
		updateParam = updateParam.substring(0,updateParam.length()-1);
		where = where==null?"":" where " + where;
		String sql = "update " + tableName +" set "+updateParam+ where;
		try {
			ps = conn.prepareStatement(sql);
			if(whereArgs != null)
				for(int i=0 ;i<whereArgs.length;i++)
					ps.setObject(i+1, whereArgs[i]);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, ps, null, conn);
		}
		return count;
	}

	
	/**
	 * 直接向数据库中写入对象
	 * @param tableName
	 * @param t
	 */
	protected final void insert(String tableName, T t) {
		StringBuilder sb =new StringBuilder();
		sb.append("insert into "+tableName+" ( ");
		Class<? extends Object> c = t.getClass();
		Method met[] = c.getDeclaredMethods();
		List<Object> list=new ArrayList<Object>(); 
		for (Method me : met) {
			String mName = me.getName();
			if (mName.startsWith("get") && !mName.startsWith("getClass")) {
				Class<?> fieType=me.getReturnType();
				String fieName=mName.substring(3, mName.length());
				Object value=null;
				try {
					value=me.invoke(t, null);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				if(fieType==String.class){
					list.add("'"+value+"'");
				}else if(fieType==Integer.class||fieType.toString().equals("int")){
					list.add(value);
				}else if(fieType==Float.class||fieType.toString().equals("float")){
					list.add(value);
				}else if(fieType==Double.class||fieType.toString().equals("double")){
					list.add(value);
				}
				sb.append(fieName.toLowerCase()+",");
			}
		}
		sb.replace(sb.length()-1, sb.length(), ") values ( ");
		for (int i = 0; i < list.size(); i++) {
			if(i<list.size()-1){
				sb.append(list.get(i)+",");
			}else{
				sb.append(list.get(i)+" );");
			}
		}
		PreparedStatement ps=null;
		try {
			ps =conn.prepareStatement(sb.toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 执行insert操作
	 * @param tableName 数据库表名
	 * @param projection 插入的字段名
	 * @param value  对应字段名的值
	 */
	protected final void insert(String tableName,String projection,String value){
		String sql = "insert into "+tableName+" ("+projection+") values ("+value+") ";
		try {
			update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 返回sql语句查询到的条数
	 * @param sql
	 * @return
	 */
	protected int getRowNum(String sql){
		ResultSet rs=null;
		int count = 0;
		try {
			rs =query(sql);
			rs.last(); 
			count = rs.getRow();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	/**
	 * 查询得到一个list
	 * @param tableName 表名
	 * @param where where参数
	 * @param whereArgs where参数的值
	 * @param c 类名.class
	 * @return
	 */
	protected List<T> getList(String tableName,String where,Object[] whereArgs,Class<T> c) {
		List<T> list = new ArrayList<T>();
		ResultSet rs = this.select(tableName, null, where, whereArgs);
		try {
			while(rs.next()){
				T t = (T) c.newInstance();
				Method[] methods = c.getMethods();

				 for (Method method : methods) {
					 String methodName = method.getName();
					 if (methodName.startsWith("set")) {
						 String columnName = methodName.substring(3,
	                                methodName.length());
						 @SuppressWarnings("rawtypes")
						 Class[] parmts = method.getParameterTypes();
						 if (parmts[0] == String.class) {
	                         // 如果参数为String类型，则从结果集中按照列名取得对应的值，并且执行改set方法
	                         method.invoke(t, rs.getString(columnName));
	                     }else if (parmts[0] == int.class) {
	                         method.invoke(t, rs.getInt(columnName));
	                     }
					 }
				 }
			
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
	 * 构建whereArgs参数
	 * @param whereArgs
	 * @return
	 */
	@SuppressWarnings("unused")
	private final String whereBuild(Object[] whereArgs){
		StringBuilder sb = new StringBuilder();
		for(Object obj : whereArgs){
			if(obj instanceof Integer || obj instanceof Float || obj instanceof Double){
				sb.append(obj+",");
			}else{
				sb.append("'"+obj+"',");
			}
		}
		return sb.substring(0,sb.length());
	}
	
	/**
	 * 关闭数据库连接
	 */
	protected void close(){
		JDBCUtils.close(null, null, null, conn);
	}
	
	

}
