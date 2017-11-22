<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<html>
<head>
<title>Register</title>
<jsp:include page="top.jsp"></jsp:include>
</head>
<body> 

	<!--register-starts-->
	<div class="register">
		<div class="container">
			<div class="register-top heading">
				<h2>REGISTER</h2>
			</div>
			<div class="register-main">
				<form action="userAction_register" method="post" class="col-md-offset-4 ">
					<div class="col-md-7 account-left">
						<input placeholder="用户名" name="username" type="text" tabindex="1" required>
						<input placeholder="手机号码" name="telephone" type="text" tabindex="3" required>
						<input placeholder="密码" name="password" type="password" tabindex="4" required>
						<input placeholder="确认密码" name="comfirm_password" type="password" tabindex="4" required>
						<div class="address submit">
							<input type="submit" value="注册" class="col-md-11">
						</div>
					</div>
				</form>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--register-end-->
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>