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

import com.cxft.onlinemarket.model.Book;
import com.cxft.onlinemarket.model.Order;
import com.cxft.onlinemarket.model.OrderDetail;
import com.cxft.onlinemarket.model.Order_ListBean;
import com.cxft.onlinemarket.model.User;
import com.cxft.onlinemarket.utils.JDBCUtils;

public class OrderDao {

	/**
	 * ���ɶ�����
	 * 
	 * @param request
	 * @param Email
	 */
	public void addOrder(Order order) {
		Connection conn = JDBCUtils.getConnection();
		String sql = "insert into tb_order(orderId,user_ID,receiverName,receiverAddress,receiverTel,payType, paystate,orderRemark,money) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, order.getOrderId());
			ps.setString(2, order.getUser_ID());
			ps.setString(3, order.getReceiverName());
			ps.setString(4, order.getReceiverAddress());
			ps.setString(5, order.getReceiverTel());
			ps.setString(6, order.getPayType());
			ps.setString(7, order.getPaystate());
			ps.setString(8, order.getOrderRemark());
			ps.setDouble(9, order.getMoney());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, ps, null, conn);
		}
	}

	/**
	 * ���ɶ�����
	 * 
	 * @param item
	 */
	public void AddOrderDetail(OrderDetail item) {
		Connection conn = JDBCUtils.getConnection();
		String sql = "insert into tb_orderitem(order_id,Book_id,buynum) values(?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, item.getOrder_id());
			ps.setInt(2, item.getBook_id());
			ps.setInt(3, item.getNumber());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, ps, null, conn);
		}
	}

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public List<Order> findOrder(String sql) {
		Statement stm = null;
		ResultSet rst = null;
		// �������ݿ�
		Connection con = JDBCUtils.getConnection();
		List<Order> list = new ArrayList<Order>();
		try {
			stm = con.createStatement();
			rst = stm.executeQuery(sql);
			while (rst.next()) {
				Order order = new Order();
				order.setOrderId(rst.getString("orderId"));
				order.setUser_ID(rst.getString("user_ID"));
				order.setReceiverName(rst.getString("receiverName"));
				order.setReceiverAddress(rst.getString("receiverAddress"));
				order.setReceiverTel(rst.getString("receiverTel"));
				order.setPayType(rst.getString("payType"));
				order.setOrderRemark(rst.getString("orderRemark"));
				order.setMoney(rst.getDouble("money"));
				order.setPaystate(rst.getString("paystate"));
				order.setOrderDate(rst.getTimestamp("orderDate"));
				order.setExpress(rst.getString("express"));
				order.setExpressId(rst.getString("expressId"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rst, null, stm, con);
		}
		return list;
	}

	/**
	 * ���ݶ���ID���Ҷ�����
	 * 
	 * @param id
	 * @return
	 */
	public List<OrderDetail> findOrderDeitelById(String id) {
		Statement stm = null;
		ResultSet rst = null;
		// �������ݿ�
		Connection con = JDBCUtils.getConnection();
		/*
		 * String sql = "select * from tb_orderitem where order_id='" + id +
		 * "'";
		 */
		String sql = "select * from tb_orderitem left join tb_book on tb_orderitem.Book_id=tb_book.bookId where order_id='"
				+ id + "'";
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		try {
			stm = con.createStatement();
			rst = stm.executeQuery(sql);
			while (rst.next()) {
				OrderDetail orderdetail = new OrderDetail();
				orderdetail.setOrder_id(rst.getString("order_id"));
				orderdetail.setBook_id(rst.getInt("Book_id"));
				orderdetail.setNumber(rst.getInt("buynum"));

				Book book = new Book();
				book.setBookId(rst.getInt("Book_id"));
				book.setBookName(rst.getString("bookName"));
				book.setBookPicture(rst.getString("bookPicture"));
				book.setBookNowPrice(rst.getFloat("bookNowPrice"));
				orderdetail.setBook(book);

				list.add(orderdetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rst, null, stm, con);
		}
		return list;
	}

	/**
	 * �����û���ID��ѯȫ������
	 * 
	 * @param id
	 * @return
	 */
	public List<Order_ListBean> findOrdersList(String user_id) {
		// TODO Auto-generated method stub
		List<Order_ListBean> order_listbean = new ArrayList<Order_ListBean>();
		// �����û�Id���ҵ���Ӧ�Ķ���
		List<Order> order_list = findOrderByEmail(user_id);
		for (Order order : order_list) {

			Order_ListBean orderlist = new Order_ListBean();
			// ����������Ϣ
			// BeanUtils.copyProperties(orderlist, order);
			orderlist.setUser_ID(order.getOrderId());
			orderlist.setReceiverAddress(order.getReceiverAddress());
			orderlist.setReceiverName(order.getReceiverName());
			orderlist.setMoney(order.getMoney());
			orderlist.setReceiverTel(order.getReceiverTel());
			orderlist.setPaystate(order.getPaystate());
			orderlist.setPayType(order.getPayType());
			orderlist.setOrdertime(order.getOrderDate());
			UserDao userdao = new UserDao();
			// �õ��û���
			List<User> user_list = userdao.findUserByEmail(order.getUser_ID());
			User user = user_list.get(0);
			orderlist.setUserName(user.getUserName());
			List<OrderDetail> order_itemlist = findOrderDeitelById(order
					.getOrderId());
			Map<Book, Integer> bookmap = new HashMap<Book, Integer>();
			for (OrderDetail item : order_itemlist) {
				int book_id = item.getBook_id();
				BookDao bookdao = new BookDao();
				List<Book> book_list = bookdao.findBookByID(book_id);
				Book book = book_list.get(0);
				bookmap.put(book, item.getNumber());
			}
			orderlist.setBookMap(bookmap);
			order_listbean.add(orderlist);

		}
		return order_listbean;
	}

	/**
	 * 
	 * ���Ҷ���
	 */
	public List<Order> findAllOrder() {
		String sql = "select * from tb_order";
		return findOrder(sql);
	}

	/**
	 * 
	 * �û�ID���ݻ�ȡ����
	 */
	public List<Order> findOrderByEmail(String email) {
		String sql = "select * from tb_order where user_ID='" + email + "'";
		return findOrder(sql);
	}

	/**
	 * ɾ��������������ɾ����
	 * 
	 * @param orderIds
	 */
	public void delete(String[] orderIds) {
		// �������ݿ�
		Connection con = JDBCUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from tb_order where orderId=?";
		try {
			ps = con.prepareStatement(sql);
			for (String orderId : orderIds) {
				ps.setString(1, orderId);
				ps.addBatch();
			}
			ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, ps, null, con);
		}
	}

	/**
	 * �޸Ķ�����Ϣ
	 * 
	 * @param receiverName
	 * @param receiverAddress
	 * @param postCode
	 * @param userTel
	 */
	public void update(String receiverName, String receiverAddress,
			int postCode, int receiverTel) {
		// �������ݿ�
		Connection con = JDBCUtils.getConnection();
		Statement stm = null;
		// �޸ģ��ռ����������ռ��˵�ַ���ʱ࣬�ռ�����ϵ��ʽ
		String sql = "update tb_order set receiverName='" + receiverName
				+ "'receiverAddress='" + receiverAddress + "',postCode='"
				+ postCode + "'receiverTel'" + receiverTel + "'";
		try {
			stm = con.prepareStatement(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, null, stm, con);
		}
	}

	/*
	 * ɾ��������
	 */
	public void deleteItem(String[] orderIds) {
		// �������ݿ�
		Connection con = JDBCUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from tb_orderitem where order_id=?";
		try {
			ps = con.prepareStatement(sql);
			for (String orderId : orderIds) {
				ps.setString(1, orderId);
				ps.addBatch();
			}
			ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, ps, null, con);
		}
	}

	/*
	 * Ϊ��������������Ϣ
	 */
	public void addDeliveryInfo(String orderId, String express, String expressId) {
		Connection con = JDBCUtils.getConnection();
		PreparedStatement ps = null;
		System.out.println(orderId);
		String sql = "update tb_order set express='" + express
				+ "',expressId='" + expressId
				+ "',paystate='2' where orderId='" + orderId + "'";
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, ps, null, con);
		}
	}
}