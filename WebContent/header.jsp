<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Product</title>

</head>
<body> 
	<!--top-header-->
	<div class="top-header">
		<div class="container">
			<div class="top-header-main">
				<div class="col-md-8 top-header-left">
					<!--start-logo-->
					<div class="logo">
						<a href="index.html"><h1>Luxury Watches</h1></a>
					</div>
					<!--start-logo-->
				</div>
				<div class="col-md-2 top-header-left" style="text-align: right;">
					<div class="login_register">
						<ul>
							<s:if test="#session.user.username!=null">
							<li><a href="javascript:;">${session.user.username}</a></li>
							<li><a href="javascript:;">/</a></li>
								<li><a href="userAction_logout.action">退出</a></li>
							</s:if>
							<s:else>
								<li><a href="login.jsp">登录</a></li>
								<li><a href="javascript:;">/</a></li>
								<li><a href="register.jsp">注册</a></li>
							</s:else>
						</ul>
					</div>
				</div>
				<s:if test="#session.user.username!=null">
				<div class="col-md-2 top-header-left">
					<div class="cart box_1">
						<a href="cartAction_cartList.action">
							<div class="total"><span class="simpleCart_total">￥ 0</span></div>
							<img src="images/cart-1.png" alt="" />
						</a>
						<div class="clearfix"> </div>
					</div>
				</div>
				</s:if>
				<div class="clearfix"></div>
			</div>
			</div>
		</div>
	</div>
	<!--top-header-->
	
	<!--bottom-header-->
	<div class="header-bottom">
		<div class="container">
			<div class="header">
				<div class="col-md-9 header-left">
				<div class="top-nav">
					<ul class="memenu skyblue"><li class="active"><a href="Index.jsp">首&nbsp;&nbsp;&nbsp;&nbsp;页</a></li>
						<s:iterator value="#request.menus" var="s">
						<li class="grid"><a href="javacscript:;"><s:property value="#s.cname"/></a>
							<div class="mepanel">
								<div class="row">
									<ul class="me-one" >
										<s:iterator value="#s.Sitems" var="sm">
										<li><a href="bookAction_subBooks.action?SID=<s:property value="#sm.sid"/>"><s:property value="#sm.sname"/></a></li>
										</s:iterator>
									</ul>
								</div>
							</div>
						</li>
						</s:iterator>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="col-md-3 header-right"> 
				<div class="search-bar">
					<input type="text" value="Search" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Search';}">
					<input type="submit" value="">
				</div>
			</div>
			<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--bottom-header-->

</body>
</html>