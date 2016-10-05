package com.LibraryManagement;
import com.LibraryManagement.DbUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;

@SuppressWarnings("serial")
public class Author  extends ActionSupport{
	private String name;
	private String country;
	private Integer age;
	public String InsertAuthor() throws SQLException, Exception{
		Connection conn = DbUtil.getConnection();
		String sql="INSERT INTO Library.Author(Name, Age, Country)"+
					"values(?, ?, ?)";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, getName());
		ptmt.setInt(2, getAge());
		ptmt.setString(3, getCountry());
		System.out.println(name);
		
		try {
		    ptmt.execute();
		    } catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		return SUCCESS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
