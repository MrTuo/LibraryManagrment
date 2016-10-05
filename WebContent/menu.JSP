<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<div class="navbar-default sidebar" role="navigation">
<div class="sidebar-nav navbar-collapse">
	<ul class="nav" id="side-menu">
		<li class="sidebar-search">
			<div class="input-group custom-search-form">
			<form action="query" class="navbar-form navbar-left" role="search">
			  <div class="form-group input-grouop">
			    <input type="text" class="form-control" placeholder="请输入图书或作者名" style="border-radius: 4px;">
			  </div>
			  <button class="btn btn-default" style="padding:9px 12px;"><span class="glyphicon glyphicon-search"></span></button>
			  
			</form>
			</div>
		</li>	
		<li>
			<a href="index_book.jsp"><span class="glyphicon glyphicon-tasks"></span>&nbsp&nbsp&nbsp所有图书</a>
		</li>
		<li>
			<a href="index_author.jsp"><span class="glyphicon glyphicon-th"></span>&nbsp&nbsp&nbsp所有作者</a>
		</li>
		<li>
			<a href="insert_book.jsp"><span class="glyphicon glyphicon-plus"></span>&nbsp&nbsp&nbsp添加图书</a>
		</li>
		<li>
			<a href="insert_author.jsp"><span class="glyphicon glyphicon-user"></span>&nbsp&nbsp&nbsp添加作者</a>
		</li>
		
	</ul>
</div>

</div>