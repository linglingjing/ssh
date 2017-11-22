<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<jsp:include page="top.jsp"></jsp:include>
</head>
<body> 
	<!--account-starts-->
	<div class="account" >
		<div class="container">
		<div class="account-top heading">
				<h2>ACCOUNT</h2>
			</div>
			<div class="account-main">
				<div class="col-md-6 account-left">
					<form action="userAction_login" method="post">
					<h3>已有账号</h3>
					<div class="account-bottom">
						<input placeholder="用户名" name="f_userName" type="text" tabindex="1" required>
						<input placeholder="密码" name="f_password" type="password" tabindex="4" required>
						<div class="address">
							<input type="submit" value="Login" class="col-md-11">
						</div>
					</div>
					</form>
				</div>
				<div class="col-md-6 account-right account-left">
					<h3>新用户? 创建一个账号</h3>
					<p>By creating an account with our store, you will be able to move through the checkout process faster, store multiple shipping addresses, view and track your orders in your account and more.</p>
					<a href="register.jsp">前往注册</a>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--account-end-->
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>