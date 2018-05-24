<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/javawebtest/css/bootstrap.css">
<title>添加商品</title>
</head>
<body>
	<div class="container">
		<!-- action:就是配置提交到后台的地址,请注意在web项目中,所有的请求都需要添加工程名 -->
		<!-- *.mvc是在web.xml中已经配置,只有mvc后缀的请求才会交给spring mvc处理 -->
		<!-- request.getContextPath() 动态获取当前项目的工程名 -->
		

		<form class="form-horizontal"
			action="<%=request.getContextPath()%>/product/save.mvc" method="post">
			<div class="form-group">
				<label for="pname" class="col-sm-2 control-label">商品名称</label>
				<div class="col-sm-6">
					<input type="text" name="name" class="form-control" id="pname"
						placeholder="商品名称">
				</div>
			</div>

			<div class="form-group">
				<label for="price" class="col-sm-2 control-label">商品价格</label>
				<div class="col-sm-6">
					<input type="text" name="price" class="form-control" id="price"
						placeholder="商品价格">
				</div>
			</div>

			<div class="form-group">
				<label for="remark" class="col-sm-2 control-label">商品备注</label>
				<div class="col-sm-6">
					<textarea  name="remark" class="form-control"
						id="remark" rows="3" placeholder="请输入备注"></textarea>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">添加商品</button>
				</div>
			</div>
		</form>

	</div>

</body>
</html>