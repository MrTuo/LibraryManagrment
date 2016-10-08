<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ include file="static.html" %>
<title>图书管理系统-作者详情</title>
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
			<h1>作者详情</h1>
			<hr>
				<table class="table table-condensed table-hover">
				  	<tr>
						<th>姓名</th>
						<th>年龄</th>
						<th>国籍</th>
						<th>操作</th>
				  	</tr>
				  	<tr>
				  		<td><s:property value="name"/></td>
				  		<td><s:property value="age"/></td>
				  		<td><s:property value="country"/></td>
				  		<td><a href="author_book?authorid=<s:property value='authorid'/>"><span class="glyphicon glyphicon-search"></span>&nbsp&nbsp&nbsp查看他的著作</a></td>
				  	</tr>
				</table>
		</div>
	</div>
	<%@ include file="page_footer.jsp" %>
</div>

</body>
</html>