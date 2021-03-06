<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品</title>
<link rel="stylesheet" href="/javawebtest/css/bootstrap.css">
</head>
<body>
	<div class="container">
		
		<br />

		<form class="form-inline"
			action="<%=request.getContextPath()%>/product/queryByName.mvc"
			method="post">
			<div class="form-group">
				<label for="word">关键字</label> <input type="text" name="keyword"
					class="form-control" id="word" placeholder="请输入查询关键字">
			</div>
			<button type="submit" class="btn btn-primary">查询</button>
			
		</form>
		<br />
	<!-- 此处只需要显示从后台获取的数据即可(在web中推荐使用jstl标签,因此需要在页面顶部添加标签库)
                        如果在导入标签库时报错,则需要添加两个jar: jstl-1.2.jar standard-1.1.2.jar
     -->
	<table class="table table-striped table-hover">
		<tr>
			<th>编号</th>
			<th>名称</th>
			<th>价格</th>
			<th>备注</th>
			<th>日期</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.proList }" var="product">
			<tr>
				<td>${product.id }</td>
				<td>${product.name }</td>
				<td>${product.price }</td>
				<td>${product.remark }</td>
				<td>${product.date }</td>
				<td>更新|删除</td>
			</tr>
		</c:forEach>
	</table>
	
	</div>
</body>
</html>