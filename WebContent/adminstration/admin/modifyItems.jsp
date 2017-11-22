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
									<a href="addAdministrator.jsp">修改分类</a>
								</li>
							</ul>
							<!-- /BREADCRUMBS -->
							<div class="clearfix">
								<h3 class="content-title pull-left">修改分类</h3>
							</div>
							<div class="description">修改分类</div>
						</div>
					</div>
				</div>
				<!-- /PAGE HEADER -->
				<!-- TABLES -->
				<div class="row">
					<div class="col-md-6">
						<!-- addItems2 -->
						<div class="box border orange" id="addAdministrator">
							<div class="box-title">
								<h4><i class="fa fa-bars"></i><span class="stepHeader">修改一级分类</h4>
							</div>
							<div class="divide-40" style="background:#fff;"></div>
							<div class="box-body form">
								<form id="wizForm" method="post" action="itemAction_updateItem?itemID=<s:property value="#i.cid"/>" class="form-horizontal" >
									<div class="wizard-form">
									   <div class="wizard-content">
										  <div class="tab-content">
											 <div class="tab-pane active" id="account">
											 <div class="form-group">
													<label class="col-md-3 control-label">一级分类ID</label>
													<div class="col-md-6">
														<input type="text" class="form-control"  value="<s:property value="#i.cid"/>" disabled/>
													  <span class="error-span"></span>
													 </div>
													 <div class="col-md-3"></div>	
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">一级分类名</label>
													<div class="col-md-6">
														<input type="text" class="form-control" name="itemName" value="<s:property value="#i.cname"/>"/>
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
					<div class="col-md-6">
						<!-- addItems2 -->
						<div class="box border orange" id="addAdministrator">
							<div class="box-title">
								<h4><i class="fa fa-bars"></i><span class="stepHeader">修改二级分类</h4>
							</div>
							<div class="divide-40" style="background:#fff;"></div>
							<div class="box-body form">
								<form id="wizForm" method="post" action="sitemAction_UpdateSItem?SID=<s:property value="#sitem.sid"/>" class="form-horizontal" >
									<div class="wizard-form">
									   <div class="wizard-content">
										  <div class="tab-content">
											 <div class="tab-pane active" id="account">
												<div class="form-group">
													<label class="col-md-3 control-label">一级分类</label>
													<div class="col-md-6">
														<select class="form-control" name="CID">
														 <s:iterator value="#ItemList" var="s"> 
															<s:if test="#sitem.item.cid==#s.cid"> 
														  		<option value="<s:property value="#s.cid"/>"selected>
														  			<s:property value="#s.cname"/> 
														  		</option>
														  	</s:if>
														 	<s:else> 
															  	<option value="<s:property value="#s.cid"/>"><s:property value="#s.cname"/></option>
														    </s:else> 
														  </s:iterator>
														</select>
													 </div>
													 <div class="col-md-3"></div>	
												 </div>
												 <div class="divide-10"></div>
												 <div class="form-group">
													<label class="col-md-3 control-label">二级分类</label>
													<div class="col-md-6">
													  <input type="text" class="form-control" name="SNAME" value="<s:property value="#sitem.sname"/>"/>
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
				<!-- /TABLES -->
				<!-- TABLES2 -->
				<div class="row">
					
				</div> 
				<!-- /TABLES2 -->
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