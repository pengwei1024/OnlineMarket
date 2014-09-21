package com.cxft.onlinemarket.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class Paging {
	private int first; // 首页
	private int last; // 最后一页
	private int pageCount; // 页总数
	private int rowCount; // 总共显示的数据条数
	private int pageRowCount; // 每页显示的数据条数
	private int curPage; // 当前页
	private Collection data; // 得到的数据

	/*
	 * 设置 默认显示10条数据
	 */
	public Paging(Collection data, int curPage) {
		this.data = data;
		this.curPage = curPage;
		this.pageRowCount = 10;
		this.rowCount = data.size();
		this.pageCount = (int) Math.ceil((double) this.rowCount
				/ (double) this.pageRowCount);
	}

	/*
	 * 自行设置页面显示的数据条数
	 */
	public Paging(Collection data, int curPage, int pageRowCount) {
		this.data = data;
		this.curPage = curPage;
		this.pageRowCount = pageRowCount;
		this.rowCount = data.size();
		this.pageCount = (int) Math.ceil((double) this.rowCount
				/ (double) this.pageRowCount);
	}

	/*
	 * 取得首页
	 */
	public int getFirst() {
		return this.first = 1;
	}

	/*
	 * 取得最后一页
	 */
	public int getLast() {
		return this.last = this.pageCount;
	}

	/*
	 * 上一页
	 */
	public int previous() {
		return (this.curPage > 1) ? this.curPage - 1 : 1;
	}

	/*
	 * 下一页
	 */
	public int next() {
		return (this.curPage < this.pageCount) ? this.curPage + 1
				: this.pageCount;
	}

	/*
	 * 判断是否是首页
	 */
	public boolean isFirst() {
		return (this.curPage == 1) ? true : false;
	}

	/*
	 * 判断是否是最后一页
	 */
	public boolean isLast() {
		return (this.curPage == this.pageCount) ? true : false;
	}

	/**
	 * 当前要显示的数据取得
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Collection getData() {
		Collection curData = null;

		if (data != null) {
			// 定义每一页开始到最后的显示的行数
			int start, end;
			start = (this.curPage - 1) * this.pageRowCount;
			// 判断当前显示的数据是否足以显示一整页
			if (start + this.pageRowCount > this.rowCount) {
				end = this.rowCount;
			} else {
				end = start + this.pageRowCount;
			}

			ArrayList arrayData = null;
			Vector vectorData = null;
			ArrayList arrayCurData = new ArrayList();
			Vector vectorCurData = new Vector();
			boolean isArrayData = true;
			// 判断是属于哪一种集合
			if (data instanceof ArrayList) {
				arrayData = (ArrayList) data;
				isArrayData = true;
			} else if (data instanceof Vector) {
				vectorData = (Vector) data;
				isArrayData = false;
			}
			// 循环得到每一页的数据
			for (int i = start; i < end; i++) {
				if (isArrayData) {
					arrayCurData.add(arrayData.get(i));
				} else {
					vectorCurData.add(vectorData.get(i));
				}
			}
			if (isArrayData) {
				curData = arrayCurData;
			} else {
				curData = vectorCurData;
			}
		}
		return curData;
	}

	/**
	 * 客户端显示的工具条
	 */
	public String getToolBar(String url) {
		String str, temp;

		// 用于判断url中是否存在？
		if (url.indexOf("?") == -1) {
			temp = "?";
		} else {
			temp = "&";
		}

		str = "<form method='post' name='frmPage' action='" + url + "'> ";
		str += "";
		str += "<span style='font-size: 12px; font-weight: bold;'>";
		// 判断是否是首页
		if (isFirst()) {
			str += "首页 上一页 ";
		} else {
			str += "<a href='" + url + temp + this.getFirst() + "'>首页</a> ";
			str += "<a href='" + url + temp + "cur_page=" + this.previous()
					+ "'>上一页</a> ";
		}
		// 判断是否是最后一页
		if (isLast()) {
			str += "下一页 尾页 ";
		} else {
			str += "<a href='" + url + temp + "cur_page=" + this.next()
					+ "'>下一页</a> ";
			str += "<a href='" + url + temp + "cur_page=" + this.getLast()
					+ "'>尾页</a> ";
		}
		str += " 共<b>" + this.rowCount + "</b>条记录 ";
		str += " 转到<select name='page' onChange=\"location='" + url + temp
				+ "cur_page='+this.options[this.selectedIndex].value\">";

		for (int i = 1; i <= this.pageCount; i++) {
			// 判断是否是当前页，若是，则默认为选中当前页
			if (i == curPage)
				str += "<option value='" + i + "' selected>第" + i
						+ "页</option>";
			else
				str += "<option value='" + i + "'>第" + i + "页</option>";
		}
		str += "</select></span></form>";
		return str;
	}

}
