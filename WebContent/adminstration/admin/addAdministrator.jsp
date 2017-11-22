<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*"%> <!-- //获取系统时间必须导入的  -->
<%@ page import="java.text.*"%> <!-- //获取系统时间必须导入的      -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="top.jsp"></jsp:include>
</head>
<body>
	<!-- PAGE -->
<div id="main-content">
	<div class="container">
		<div class="row">
			<div id="content" class="col-lg-12">
				<!-- PAGE HEADER-->
				<div class="row">
					<div class="col-sm-12">
						<div class="page-header">
							<!-- BREADCRUMBS -->
							<ul class="breadcrumb">
								<li>
									<i class="fa fa-home"></i>
									<a href="javascript">系统管理</a>
								</li>
								<li>
									<a href="addAdministrator.jsp">添加管理员</a>
								</li>
							</ul>
							<!-- /BREADCRUMBS -->
							<div class="clearfix">
								<h3 class="content-title pull-left">添加管理员</h3>
							</div>
							<div class="description">添加管理员</div>
						</div>
					</div>
				</div>
				<!-- /PAGE HEADER -->
				<!-- TABLES -->
				<div class="row">
					<div class="col-md-12">
						<!-- addAdministrator -->
						<div class="box border green" id="addAdministrator">
							<div class="box-title">
								<h4><i class="fa fa-bars"></i><span class="stepHeader">添加管理员</h4>
							</div>
							<div class="divide-40" style="background:#fff;"></div>
							<div class="box-body form">
								<form id="wizForm" method="post" action="adminAction_AddAdmin" class="form-horizontal" >
									<div class="wizard-form">
									   <div class="wizard-content">
										  <div class="tab-content">
											 <div class="alert alert-danger" id="error">
												<a class="close" aria-hidden="true" href="#" data-dismiss="alert">×</a>
												您的表单有错误，请正确填写或填写完整！
											 </div>
											 <div class="alert alert-success" id="success">
												<a class="close" aria-hidden="true" href="#" data-dismiss="alert">×</a>
												您的表单已正确提交！
											 </div>
											 <div class="tab-pane active" id="account">
												<div class="form-group">
												   <label class="control-label col-md-3">账户名<span class="required">*</span></label>
												   <div class="col-md-4">
													  <input type="text" class="form-control" name="a_adminName" placeholder="管理员的账户名"/>
													  <span class="error-span"></span>
												   </div>
												</div>
												<div class="form-group">
												   <label class="control-label col-md-3">密码<span class="required">*</span></label>
												   <div class="col-md-4">
													  <input type="password" id="password" class="form-control" name="a_password" placeholder="输入密码"/>
													  <span class="error-span"></span>
												   </div>
												</div>
												<div class="form-group">
												   <label class="control-label col-md-3">确认密码<span class="required">*</span></label>
												   <div class="col-md-4">
													  <input type="password" class="form-control" name="confirm_password" placeholder="确认密码"/>
													  <span class="error-span"></span>
												   </div>
												</div>
												<div class="form-group">
												   <label class="control-label col-md-3">管理员类型<span class="required">*</span></label>
												   <div class="col-md-4">
														 <label class="radio-inline"><input type="radio" name="a_adminType" value="0" checked="checked" />
														 超级管理员
														 </label>
														 <label class="radio-inline"><input type="radio" name="a_adminType" value="1"  class=""/>
														 普通管理员
														 </label>			  
												   </div>
												</div>
												<div class="form-group">
												   <label class="control-label col-md-3">注册时间<span class="required">*</span></label>
												   <div class="col-md-4">
													  <input type="text" class="form-control" name="register_time" value="<%out.print(new java.text.SimpleDateFormat("yyyy-MM-dd").format(new Date())); %>" disabled />
													  <span class="error-span"></span>
												   </div>
												</div>
											 </div>
										  </div>
									   </div>
									   <div class="wizard-buttons">
										  <div class="row">
											 <div class="col-md-12">
												<div class="col-md-offset-3 col-md-9">
												   <input type="submit" value="提交" class="btn btn-success submitBtn col-md-2">
												   <input type="reset" value="重置" class="btn btn-success col-md-2 resetBtn">
												</div>
											 </div>
										  </div>
									   </div>
									</div>
								</form>
							</div>
							<div class="divide-40" style="background:#fff;"></div>
						</div>
						 <!-- /addAdministrator -->
					</div>
				</div> 
				<!-- /TABLES -->
				<div class="footer-tools">
					<span class="go-top">
						<i class="fa fa-chevron-up"></i> Top
					</span>
				</div>
			</div>
		</div>
	</div>
</div>
	<!--/PAGE -->

	<jsp:include page="bottom.jsp"></jsp:include>
	<script>
		jQuery(document).ready(function() {		
			App.setPage("widgets_box");  //Set current page
			App.init(); //Initialise plugins and elements
		});

	    $('#super_datatable').DataTable( {
	        "pagingType": "full_numbers"
	    } );
	</script>
</body>
</html>