package com.LibraryManagement;
import com.LibraryManagement.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("serial")
public class Author  extends ActionSupport{
	private Integer authorid;
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

		ValueStack stack = ActionContext.getContext().getValueStack();
		Map context = new HashMap();
		try {
		    ptmt.execute();
		    } catch (SQLException e) {
		    	context.put("err_info", new String(e.getMessage()));
				stack.push(context);
				return "failed";
			}
		ptmt.close();
	    context.put("info", new String("恭喜您！作者添加成功！"));
		stack.push(context);
		return SUCCESS;
	}

	public String IndexAuthor()throws SQLException, Exception{
		Connection conn = DbUtil.getConnection();
		String sql="SELECT * FROM Library.Author";
		Statement ptmt=conn.createStatement();
		//返回结果不为空，则将获得的数据压入值栈
		ValueStack stack = ActionContext.getContext().getValueStack();
		Map context = new HashMap();
		try {
			ResultSet rs=ptmt.executeQuery(sql);
			ArrayList<Author> gs = new ArrayList<Author>();
			while(rs.next())
			{
				Author g = new Author();
				g.setName(rs.getString("name"));
				g.setAge(rs.getInt("age"));
				g.setCountry(rs.getString("country"));
				g.setAuthorid(rs.getInt("authorid"));
				
				gs.add(g);
			}
			
			
			if(gs.size() != 0){
				context.put("Authors", gs);
				context.put("empty", 0);		
			}
			else{
				context.put("empty", 1);	
			}
			stack.push(context);
			return SUCCESS;
		} catch (SQLException e) {
	    	context.put("err_info", new String(e.getMessage()));
			stack.push(context);
			return "failed";
		}
	}
	
	public String QueryAuthor() throws SQLException, Exception{
		Connection conn = DbUtil.getConnection();
		String sql="SELECT * FROM Library.Author WHERE Name = ?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, name);
		//返回结果不为空，则将获得的数据压入值栈
		ValueStack stack = ActionContext.getContext().getValueStack();
		Map context = new HashMap();
		try {
			ResultSet rs=ptmt.executeQuery();
			ArrayList<Author> gs = new ArrayList<Author>();
			while(rs.next())
			{
				Author g = new Author();
				g.setName(rs.getString("name"));
				g.setAge(rs.getInt("age"));
				g.setCountry(rs.getString("country"));
				g.setAuthorid(rs.getInt("authorid"));
				
				gs.add(g);
			}
			
			context.put("Authors", gs);
			context.put("rsNum", gs.size());	
			stack.push(context);
			
			return SUCCESS;
		} catch (SQLException e) {
	    	context.put("err_info", new String(e.getMessage()));
			stack.push(context);
			return "failed";
		}
	}
	
	public String CheckAuthor() throws SQLException, Exception{
		Connection conn = DbUtil.getConnection();
		String sql="SELECT * FROM Library.Author WHERE AuthorID = ?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setInt(1, authorid);
		//返回结果不为空，则将获得的数据压入值栈
		ValueStack stack = ActionContext.getContext().getValueStack();
		Map context = new HashMap();
		try {
			ResultSet rs=ptmt.executeQuery();
			ArrayList<Author> gs = new ArrayList<Author>();
			rs.next();
			setName(rs.getString("name"));
			setAge(rs.getInt("age"));
			setCountry(rs.getString("country"));
			setAuthorid(rs.getInt("authorid"));
			return SUCCESS;
		} catch (SQLException e) {
	    	context.put("err_info", new String(e.getMessage()));
			stack.push(context);
			return "failed";
		}
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

	public Integer getAuthorid() {
		return authorid;
	}

	public void setAuthorid(Integer authorid) {
		this.authorid = authorid;
	}
	
}
