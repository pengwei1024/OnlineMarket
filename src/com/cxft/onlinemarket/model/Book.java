package com.cxft.onlinemarket.model;

import java.io.Serializable;

public class Book implements Serializable{
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private String bookPublisher;
	private String bookType;
	private double bookPrice;
	private double bookNowPrice;
	private String bookPicture;
	private int pnum;
	private int sale;
	private int newbook;
	private int hit;
	private String bookIntroduction;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public double getBookNowPrice() {
		return bookNowPrice;
	}

	public void setBookNowPrice(double bookNowPrice) {
		this.bookNowPrice = bookNowPrice;
	}

	public String getBookPicture() {
		return bookPicture;
	}

	public void setBookPicture(String bookPicture) {
		this.bookPicture = bookPicture;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getNewbook() {
		return newbook;
	}

	public void setNewbook(int newbook) {
		this.newbook = newbook;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getBookIntroduction() {
		return bookIntroduction;
	}

	public void setBookIntroduction(String bookIntroduction) {
		this.bookIntroduction = bookIntroduction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookId != other.bookId)
			return false;
		return true;
	}

}
