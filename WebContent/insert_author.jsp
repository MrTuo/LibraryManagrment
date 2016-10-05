<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ include file="static.html" %>
<script src="js/checkAuthor.js"></script>
<title>图书管理系统-添加作者</title>
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
			<h1>添加作者</h1>
			<hr>
			<div class="insert-form">
			<form class="form-horizontal" action="insert_author" role="form" method="POST" onsubmit="return regs('click')">
				<div class="form-group input_row">
		    		<label for="isbn" class="col-sm-2 control-label input-label">姓名</label>
		    		<div class="col-sm-10">
		    			<input type="text" class="form-control" placeholder="请输入长度不大于20字的人名" id="isbn" name="name"><span></span>
	    			</div>
		  		</div>
		  		<div class="form-group input_row">
		    		<label for="title" class="col-sm-2 control-label input-label">年龄</label>
		    		<div class="col-sm-10">
		    			<input type="text" class="form-control" placeholder="请输入正整数的年龄" id="title" name="age"><span></span>
		    		</div>
		  		</div>
		  		<div class="form-group input_row">
		    		<label for="author" class="col-sm-2 control-label input-label">国籍</label>
		    		<div class="col-sm-10">
		    			<input type="text" class="form-control" placeholder="请输入不超过20字的作者国籍" id="author" name="country"><span></span>
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