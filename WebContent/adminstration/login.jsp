<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title>Cloud Admin | Login</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">

	<!-- STYLESHEETS --><!--[if lt IE 9]><script src="js/flot/excanvas.min.js"></script><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script><![endif]-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/adminstration/admin/css/cloud-admin.css" >
	<link href="${pageContext.request.contextPath }/adminstration/admin/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<!-- FONTS -->
</head>
<body class="login">	
	<!-- PAGE -->
	<section id="page">
			<!-- HEADER -->
			<header>
				<!-- NAV-BAR -->
				<div class="container">
					<div class="row">
						<div class="col-md-4 col-md-offset-4">
							<div id="logo">
								<a href="index.html"><img src="admin/img/logo/logo-alt.png" height="40" alt="logo name" /></a>
							</div>
						</div>
					</div>
				</div>
				<!--/NAV-BAR -->
			</header>
			<!--/HEADER -->
			<!-- LOGIN -->
			<section id="login" class="visible">
				<div class="container">
					<div class="row">
						<div class="col-md-4 col-md-offset-4">
							<div class="login-box-plain">
								<h2 class="bigintro">login</h2>
								<div class="divide-40"></div>
								<form role="form" action="adminAction_login" method="post">
								  <div class="form-group">
									<label for="username">用户名</label>
									<i class="fa fa-user"></i>
									<input type="text" class="form-control" id="username" name="f_adminName">
								  </div>
								  <div class="form-group"> 
									<label for="password">密码</label>
									<i class="fa fa-lock"></i>
									<input type="password" class="form-control" id="password" name="f_password">
								  </div>
								  <div class="form-actions">
									<label class="checkbox"><input type="checkbox" value="" style="width:auto;margin:2px 0 0 -20px;" /> 记住密码</label>
									<button type="submit" class="btn btn-danger">提交</button>
								  </div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!--/LOGIN -->

	</section>
	<!--/PAGE -->
	<!-- JAVASCRIPTS -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- JQUERY -->
	<script src="${pageContext.request.contextPath }/adminstration/admin/js/jquery/jquery-2.0.3.min.js"></script>
	<!-- JQUERY UI-->
	<script src="${pageContext.request.contextPath }/adminstration/admin/js/jquery-ui-1.10.3.custom.min.js"></script>
	<!-- BOOTSTRAP -->
	<script src="${pageContext.request.contextPath }/adminstration/admin/js/bootstrap.min.js"></script>
	<!-- /JAVASCRIPTS -->
</body>
</html>