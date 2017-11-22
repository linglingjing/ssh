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
									<a href="javascript">分类管理</a>
								</li>
								<li>
									<a href="addAdministrator.jsp">添加分类</a>
								</li>
							</ul>
							<!-- /BREADCRUMBS -->
							<div class="clearfix">
								<h3 class="content-title pull-left">添加分类</h3>
							</div>
							<div class="description">添加分类</div>
						</div>
					</div>
				</div>
				<!-- /PAGE HEADER -->
				<!-- 添加一级分类 -->
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<!-- addItems2 -->
						<div class="box border orange" id="addAdministrator">
							<div class="box-title">
								<h4><i class="fa fa-bars"></i><span class="stepHeader">添加一级分类</h4>
							</div>
							<div class="divide-40" style="background:#fff;"></div>
							<div class="box-body form">
								<form id="wizForm" method="post" action="itemAction_addItem" class="form-horizontal" >
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
													<label class="col-md-3 control-label">一级分类</label>
													<div class="col-md-6">
														<input type="text" class="form-control" name="itemname" placeholder="一级分类名" required="required"/>
													  <span class="error-span"></span>
													 </div>
													 <div class="col-md-3"></div>	
												</div>
											 </div>
										  </div>
									   </div>
									   <div class="divide-10"></div>
									   <div class="wizard-buttons">
										  <div class="row">
											 <div class="col-md-12">
												<div class="col-md-offset-3 col-md-9">
												   <input type="submit" value="提交" class="btn btn-warning submitBtn col-md-3">
												   <input type="reset" value="重置" class="btn btn-warning col-md-3 resetBtn">
												</div>
											 </div>
										  </div>
									   </div>
									</div>
								</form>
							</div>
							<div class="divide-40" style="background:#fff;"></div>
						</div>
						 <!-- /addItems2 -->
					</div>
				</div> 
				<!-- /添加一级分类 -->
				<div class="divide-40"></div>
				<!-- 添加二级分类 -->
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<!-- addItems2 -->
						<div class="box border orange" id="addAdministrator">
							<div class="box-title">
								<h4><i class="fa fa-bars"></i><span class="stepHeader">添加二级分类</h4>
							</div>
							<div class="divide-40" style="background:#fff;"></div>
							<div class="box-body form">
								<form id="wizForm" method="post" action="sitemAction_addSItem" class="form-horizontal" >
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
													<label class="col-md-3 control-label">一级分类</label>
													<div class="col-md-6">
														<select class="form-control" name="itemCid">
														  <s:iterator value="#ItemList" var="s">
														     <option value="<s:property value="#s.cid"/>" ><s:property value="#s.cname"/></option>
														  </s:iterator>
														</select>
													 </div>
													 <div class="col-md-3"></div>	
												 </div>
												 <div class="divide-10"></div>
												 <div class="form-group">
												   <label class="control-label col-md-3">二级分类名</label>
												   <div class="col-md-6">
													  <input type="text" class="form-control" name="sitemName" required="required"/>
													  <div class="col-md-3"></div>
												   </div>
												</div>						
											 </div>
										  </div>
									   </div>
									   <div class="divide-10"></div>
									   <div class="wizard-buttons">
										  <div class="row">
											 <div class="col-md-12">
												<div class="col-md-offset-3 col-md-9">
												   <input type="submit" value="提交" class="btn btn-warning submitBtn col-md-3">
												   <input type="reset" value="重置" class="btn btn-warning col-md-3 resetBtn">
												</div>
											 </div>
										  </div>
									   </div>
									</div>
								</form>
							</div>
							<div class="divide-40" style="background:#fff;"></div>
						</div>
						 <!-- /addItems2 -->
					</div>
				</div> 
				<!-- / 添加二级分类 -->
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