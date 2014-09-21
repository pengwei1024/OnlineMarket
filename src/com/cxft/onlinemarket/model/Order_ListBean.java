package com.cxft.onlinemarket.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.cxft.onlinemarket.model.Book;

public class Order_ListBean {
	private String user_ID;
	private String receiverName;
	private String receiverAddress;
	private String receiverTel;
	private String payType;
	private String paystate;
	private Timestamp ordertime;
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getReceiverTel() {
		return receiverTel;
	}
	public void setReceiverTel(String receiverTel) {
		this.receiverTel = receiverTel;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getPaystate() {
		return paystate;
	}
	public void setPaystate(String paystate) {
		this.paystate = paystate;
	}
	public Timestamp getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Timestamp ordertime) {
		this.ordertime = ordertime;
	}
	public String getOrderRemark() {
		return orderRemark;
	}
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Map<Book, Integer> getBookMap() {
		return bookMap;
	}
	public void setBookMap(Map<Book, Integer> bookMap) {
		this.bookMap = bookMap;
	}
	private String orderRemark;
	private double money;
	private String username;
	private Map<Book,Integer> bookMap;
}
