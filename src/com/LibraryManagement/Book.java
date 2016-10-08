package com.LibraryManagement;
import com.LibraryManagement.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.sun.crypto.provider.RSACipher;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class Book extends ActionSupport{
	private Integer price;
	private String ISBN;
	private Integer authorid;
	private String title;
	private String publisher;
	private String publish_date;
	private String name;
	public String InsertBook()throws SQLException, Exception{
		Connection conn = DbUtil.getConnection();
		String sql = "SELECT authorid, name FROM Library.Author";
		Statement ptmt=conn.createStatement();
		ValueStack stack = ActionContext.getContext().getValueStack();
		Map context = new HashMap();
		try {
			ResultSet rs=ptmt.executeQuery(sql);
			ArrayList<Author> authors = new ArrayList<Author>();
			while (rs.next()) {
				Author b=new Author();
				b.setAuthorid(rs.getInt("authorid"));
				b.setName(rs.getString("name"));		
				authors.add(b);
			}
			//返回结果不为空，则将获得的数据压入值栈
			
			if(authors.size() != 0){
				context.put("Authors", authors);
				context.put("empty", 0);
			}
			else{
				context.put("empty", 1);
			}
			stack.push(context);
			//关闭相应链接
		    ptmt.close();
		    rs.close();
			return SUCCESS;
		    } catch (SQLException e) {
				context.put("err_info", new String(e.getMessage()));
				stack.push(context);
		    	return "failed";
			}
	}
	public String InsertBookSave() throws SQLException, Exception{
		 //获取连接
		Connection conn = DbUtil.getConnection();
		//判断ISBN是否已存在
		String sql="SELECT ISBN FROM Library.Book WHERE ISBN = ?";
		PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行
	    ptmt.setString(1, ISBN);
	    ValueStack stack = ActionContext.getContext().getValueStack();
		Map context = new HashMap();
		try{
			ResultSet rs=ptmt.executeQuery();
		    
		    if (rs.next()){
				context.put("err_info", new String("您输入ISBN已存在！请输入正确的ISBN！"));
				stack.push(context);
		    	return "failed";
		    }
			//sql
			sql = "INSERT INTO library.Book(ISBN, Title, AuthorID, Publisher, PublishDate, Price)"
		                +"values("+"?,?,?,?,?,?)";
			//预编译
		    ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行
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
				context.put("err_info", new String(e.getMessage()));
				stack.push(context);
		    	return "failed";
			}
		  //关闭相应链接
		    ptmt.close();
		    context.put("info", new String("恭喜您！图书添加成功！"));
			stack.push(context);
			return "success";
		} catch (SQLException e) {
			context.put("err_info", new String(e.getMessage()));
			stack.push(context);
	    	return "failed";
		}
	    
	}
	
	public String IndexBook()throws SQLException, Exception{
		Connection conn = DbUtil.getConnection();
		String sql="SELECT Library.Author.name, Library.Book.* FROM Library.Author, library.Book WHERE Library.Author.AuthorID = Library.Book.AuthorID;";
		Statement ptmt=conn.createStatement();
		//返回结果不为空，则将获得的数据压入值栈
		ValueStack stack = ActionContext.getContext().getValueStack();
		Map context = new HashMap();
		try{
			ResultSet rs=ptmt.executeQuery(sql);
			ArrayList<Book> books = new ArrayList<Book>();
			while (rs.next()) {
				Book b=new Book();
				b.setTitle(rs.getString("title"));
				b.setISBN(rs.getString("ISBN"));
				b.setPrice(rs.getInt("price"));
				b.setPublish_date(rs.getString("publishdate"));
				b.setPublisher(rs.getString("publisher"));
				b.setName(rs.getString("name"));
				b.setAuthorid(rs.getInt("authorid"));
				
				books.add(b);
			}
			
			if(books.size() != 0){
				context.put("Books", books);
				context.put("empty", 0);
			}
			else{
				context.put("empty", 1);
			}
			stack.push(context);
			//关闭相应链接
		    ptmt.close();
		    rs.close();
			return SUCCESS;
		} catch (SQLException e) {
			context.put("err_info", new String(e.getMessage()));
			stack.push(context);
	    	return "failed";
		}
		
	}
	
	public String AuthorBook()throws SQLException, Exception {
		 //获取连接
		Connection conn = DbUtil.getConnection();
		//sql
		String sql = "SELECT Library.Author.name, Library.Book.* " +
				"FROM Library.Author, library.Book " +
				"WHERE Library.Book.AuthorID = ? " +
				"AND Library.Author.Authorid = ? ";
		//预编译
	    PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行
	    ptmt.setInt(1, authorid);
	    ptmt.setInt(2, authorid);
	  //返回结果不为空，则将获得的数据压入值栈
  		ValueStack stack = ActionContext.getContext().getValueStack();
  		Map context = new HashMap();
	    try{
	    	ResultSet rs = ptmt.executeQuery();
		    
		    ArrayList<Book> books = new ArrayList<Book>();
			while (rs.next()) {
				Book b=new Book();
				b.setTitle(rs.getString("title"));
				b.setISBN(rs.getString("ISBN"));
				b.setPrice(rs.getInt("price"));
				b.setPublish_date(rs.getString("publishdate"));
				b.setPublisher(rs.getString("publisher"));
				b.setName(rs.getString("name"));
				b.setAuthorid(rs.getInt("authorid"));
				
				books.add(b);
			}
			
			context.put("Books", books);
			context.put("rsNum", books.size());
			stack.push(context);
			//关闭相应链接
		    ptmt.close();
		    rs.close();
			return SUCCESS;
	    }catch (SQLException e) {
			context.put("err_info", new String(e.getMessage()));
			stack.push(context);
	    	return "failed";
		}
	}
	
	public String EditBook()throws SQLException, Exception{
		Connection conn = DbUtil.getConnection();
		String sql = "SELECT * FROM Library.Book WHERE ISBN = ?";
		PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行
		ptmt.setString(1, ISBN);
		//返回结果不为空，则将获得的数据压入值栈
		ValueStack stack = ActionContext.getContext().getValueStack();
		Map context = new HashMap();
		try {
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			setTitle(rs.getString("title"));
			setISBN(rs.getString("ISBN"));
			setPrice(rs.getInt("price"));
			setPublish_date(rs.getString("publishdate"));
			setPublisher(rs.getString("publisher"));
			Integer originAuthorid=rs.getInt("authorid");
			//获取所有作者信息
			sql = "SELECT authorid, name FROM Library.Author";
			Statement ptmt2=conn.createStatement();
			ResultSet rs2=ptmt2.executeQuery(sql);
			ArrayList<Author> authors = new ArrayList<Author>();
			while (rs2.next()) {
				Author b=new Author();
				b.setAuthorid(rs2.getInt("authorid"));
				b.setName(rs2.getString("name"));		
				authors.add(b);
			}
			
			if(authors.size() != 0){
				context.put("Authors", authors);
				//单独保存authorid用于显示用户。
				context.put("originAuthorid", originAuthorid);
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
	
	public String EditBookSave() throws SQLException, Exception{
		 //获取连接
		Connection conn = DbUtil.getConnection();
	    String sql = "UPDATE library.Book SET AuthorID = ?, Title = ?, Publisher = ?, PublishDate = ?, Price = ? "
	                +"WHERE Book.ISBN = ? ";
		
		//预编译
	    PreparedStatement ptmt = conn.prepareStatement(sql); 
	    ValueStack stack = ActionContext.getContext().getValueStack();
		Map context = new HashMap();
	    //预编译SQL，减少sql执行
	    
	    ptmt.setInt(1, authorid);
	    ptmt.setString(2, title);
	    ptmt.setString(3, publisher);
	    ptmt.setString(4, publish_date);
	    ptmt.setInt(5, price);
	    ptmt.setString(6, ISBN);
	    
		//执行
	    try {
	    ptmt.execute();
	    } catch (SQLException e) {
			context.put("err_info", new String(e.getMessage()));
			stack.push(context);
	    	return "failed";
		}
	  //关闭相应链接
	    ptmt.close();
	    context.put("info", new String("恭喜您！图书信息成功！"));
		stack.push(context);
		return "success";
	}

	public String DeleteBook()throws SQLException, Exception{
		Connection conn = DbUtil.getConnection();
		String sql = "DELETE  FROM Library.Book WHERE Book.ISBN = ?";
		PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行
		ptmt.setString(1, ISBN);
		ValueStack stack = ActionContext.getContext().getValueStack();
		Map context = new HashMap();
		try {
		    ptmt.execute();
	    } 
		catch (SQLException e) {
			context.put("err_info", new String(e.getMessage()));
			stack.push(context);
	    	return "failed";
		}
	  //关闭相应链接
	    ptmt.close();
	    context.put("info", new String("恭喜您！图书删除成功！"));
		stack.push(context);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
