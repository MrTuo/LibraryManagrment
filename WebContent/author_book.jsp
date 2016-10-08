<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="static.html" %>
<title>图书管理系统-作者图书</title>
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
			<h1>作者图书</h1>
			<hr>
			<s:if test="%{!rsNum}">
				<h2>暂无该作者创作的图书！</h2>
			</s:if>
			<s:else>
			<p style="color: #777;">该作者的图书共计<span class="badge"><s:property value="rsNum"/></span>本</p>
			<table class="table table-condensed table-hover">
				<tr>
					<th>书名</th>
					<th>ISBN</th>
					<th>作者</th>
					<th>出版社</th>
					<th>出版日期</th>
					<th>价格</th>
					<th style="text-align: center;">操作</th>
				</tr>
				<s:iterator value="Books">
				<tr>
					<td><s:property value="title"/></td>
					<td><s:property value="ISBN"/></td>
					<td><a href="check_author?authorid=<s:property value='authorid'/>"><s:property value="name"/></a></td>
					<td><s:property value="publisher"/></td>
					<td><s:property value="publish_date"/></td>
					<td><s:property value="price"/></td>
					<td style="text-align: center;">
						<a href="edit_book?ISBN=<s:property value="ISBN"/>"><span class="glyphicon glyphicon-pencil"></span>编辑&nbsp&nbsp&nbsp</a>
						<a href="delete_book?ISBN=<s:property value="ISBN"/>"><span class="glyphicon glyphicon-trash"></span>删除</a>
					</td>
				</tr>
				</s:iterator>
			</table>
			</s:else>
		</div>
	</div>
	<%@ include file="page_footer.jsp" %>
</div>
</body>
</html>