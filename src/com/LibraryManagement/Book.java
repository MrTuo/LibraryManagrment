package com.LibraryManagement;
import com.LibraryManagement.DbUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;

@SuppressWarnings("serial")
public class Book extends ActionSupport{
	private Integer price;
	private String ISBN;
	private Integer authorid;
	private String title;
	private String publisher;
	private String publish_date;
	public String InsertBook() throws SQLException, Exception{
		 //获取连接
		Connection conn = DbUtil.getConnection();
		//sql
		String sql = "INSERT INTO library.Book(ISBN, Title, AuthorID, Publisher, PublishDate, Price)"
	                +"values("+"?,?,?,?,?,?)";
		//预编译
	    PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行
	    ptmt.setString(1, ISBN);
	    ptmt.setInt(3, authorid);
	    ptmt.setString(2, title);
	    ptmt.setString(4, publisher);
	    ptmt.setString(5, publish_date);
	    ptmt.setInt(6, price);
		//执行
	    try {
	    ptmt.execute();
	    } catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return "success";
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}
	public Integer getAuthorid() {
		return authorid;
	}
	public void setAuthorid(Integer authorid) {
		this.authorid = authorid;
	}
}
