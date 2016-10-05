<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ include file="static.html" %>
<title>图书管理系统-添加图书</title>
</head>
<body>
<div class="wrapper">
	<div class="header">
		<%@ include file="page_header.JSP" %>
	</div>
	<div class="body">
		<div class="menu ">
			<%@ include file="menu.JSP" %>
		</div>
		<div class="main">
			<h1>添加图书</h1>
			<hr>
			<div class="insert-form">
			<form class="form-horizontal" action="insert_book" role="form" onsubmit="return regs('click')">
				<div class="form-group input_row">
		    		<label for="author" class="col-sm-2 control-label input-label">作者</label>
		    		<div class="col-sm-10">
		    			<input type="text" class="form-control" placeholder="请输入已存在的作者名" id="author" name="authorid">
		    		</div> 
		  		</div>
				<div class="form-group input_row">
		    		<label for="isbn" class="col-sm-2 control-label input-label">ISBN</label>
		    		<div class="col-sm-10">
		    			<input type="text" class="form-control" placeholder="请按照ISBN标准填写(10位或13位纯数字)" id="isbn" name="ISBN">
		    		</div>
		  		</div>
		  		<div class="form-group input_row">
		    		<label for="title" class="col-sm-2 control-label input-label">书名</label>
		    		<div class="col-sm-10">
		    			<input type="text" class="form-control" placeholder="请输入长度不大于20字的书名" id="title" name="title">
		    		</div>
		  		</div>
		  		<div class="form-group input_row">
		  			<label for="publisher" class="col-sm-2 control-label input-label">出版社</label>
		  			<div class="col-sm-10">
		  			<input type="text" class="form-control" id="publisher" placeholder="请输入长度不超过20字的出版社名称" name="publisher">
		  			</div>
		  		</div>
		  		<div class="form-group input_row">
		  			<label for="publish_date" class="col-sm-2 control-label input-label">出版日期</label>
		  			<div class="col-sm-10">
		  			<input type="text" class="form-control" id="publish_date" placeholder="请按照1999-01-01格式输入出版日期" name="publish_date">
		  			</div>
		  		</div>
		  		<div class="form-group input_row">
		  			<label for="price" class="col-sm-2 control-label input-label">价格</label>
		  			<div class="col-sm-10">
		  			<input type="text" class="form-control" id="price" placeholder="请输入整数价格" name="price">
		  			</div>
		  		</div>
		  		<div class="input_row">
		  			<button type="submit" class="btn btn-primary submit-btn">添加</button>
	  			</div>
			</form>
			</div>
		</div>
		</div>
</div>

</body>
</html>