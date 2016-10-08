<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ include file="static.html" %>
<script src="js/checkBook.js"></script>
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
			<s:if test="%{empty}">
				<h2>没有作者哦~你需要先<a href="insert_author.jsp">添加作者</a>!</h2>
			</s:if>
			<s:else>
			<div class="insert-form">
			<form class="form-horizontal" action="insert_book_save" role="form" method="POST" onsubmit="return regs('click')">
				<div class="form-group input_row">
		    		<label for="author" class="col-sm-2 control-label input-label">作者</label>
		    		<div class="col-sm-10">
		    			<!-- <input type="text" class="form-control" placeholder="请输入已存在的作者名" id="author" name="authorid"> -->
		    			<select class="form-control" name="authorid" id="author" style="display: inline-block; width: auto;"> 
						      <s:iterator value="Authors">
						      <option value="<s:property value='authorid'/>"><s:property value="name"/></option> 
						      </s:iterator>
				        </select>
				        <a href="insert_author.jsp" target="_blank"><span class="glyphicon glyphicon-plus">添加作者</span></a>
				        <span>*注：插入新作者后刷新该页面即可出现</span>
		    		</div> 
		  		</div>
				<div class="form-group input_row">
		    		<label for="isbn" class="col-sm-2 control-label input-label">ISBN</label>
		    		<div class="col-sm-10">
		    			<input type="text" class="form-control my-input" placeholder="请按照ISBN标准填写(10位或13位纯数字)" id="isbn" name="ISBN" required><span></span>
		    		</div>
		  		</div>
		  		<div class="form-group input_row">
		    		<label for="title" class="col-sm-2 control-label input-label">书名</label>
		    		<div class="col-sm-10">
		    			<input type="text" class="form-control my-input" placeholder="请输入长度不大于20字的书名" id="title" name="title" required><span></span>
		    		</div>
		  		</div>
		  		<div class="form-group input_row">
		  			<label for="publisher" class="col-sm-2 control-label input-label">出版社</label>
		  			<div class="col-sm-10">
		  			<input type="text" class="form-control my-input" id="publisher" placeholder="请输入长度不超过20字的出版社名称" name="publisher" required><span></span>
		  			</div>
		  		</div>
		  		<div class="form-group input_row">
		  			<label for="publish_date" class="col-sm-2 control-label input-label">出版日期</label>
		  			<div class="col-sm-10">
		  			<input type="text" class="form-control my-input" id="publish_date" placeholder="请按照1999-01-01格式输入出版日期" name="publish_date" required><span></span>
		  			</div>
		  		</div>
		  		<div class="form-group input_row">
		  			<label for="price" class="col-sm-2 control-label input-label">价格</label>
		  			<div class="col-sm-10">
		  			<input type="text" class="form-control my-input" id="price" placeholder="请输入整数价格" name="price" required><span></span>
		  			</div>
		  		</div>
		  		<div class="input_row">
		  			<button type="submit" class="btn btn-primary submit-btn">添加</button>
	  			</div>
			</form>
			</div>
			</s:else>
		</div>
		</div>
		<%@ include file="page_footer.jsp" %>
</div>

</body>
</html>