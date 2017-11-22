<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
											<a href="index.html">Home</a>
										</li>
										<li>
											<a href="#">Other Pages</a>
										</li>
										<li>Blank Page</li>
									</ul>
									<!-- /BREADCRUMBS -->
									<div class="clearfix">
										<h3 class="content-title pull-left">Blank Page</h3>
									</div>
									<div class="description">Blank Page</div>
								</div>
							</div>
						</div>
						<!-- /PAGE HEADER -->
						<!-- TABLES -->
						<div class="row">
							<div class="col-md-12">
								<!-- BOX -->
								<div class="box border blue" id="userList">
									<div class="box-title">
										<h4><i class="fa fa-table"></i>订单列表</h4>
										<div class="tools hidden-xs">
											<a href="javascript:;">
												<i class="fa fa-minus"></i> &nbsp;&nbsp;批量删除
											</a>
										</div>
									</div>
									<div class="box-body">
										<table id="order_datatable" cellpadding="0" cellspacing="0" border="0" class="datatable table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th><input type="checkbox"></th>
													<th>订单ID</th>
													<th>用户ID</th>
													<th>用户名</th>
													<th>用户电话</th>
													<th>下单时间</th>
													<th>收货地址</th>
													<th>总额</th>
													<!-- <th>操作</th> -->
													<th>详情</th>
												</tr>
											</thead>
											<tbody>
											<s:iterator value="#orders" var="s">
												<tr class="">
													<td><input type="checkbox"></td>
													<td><s:property value="#s.oid"/></td>
													<td><s:property value="#s.user.id"/></td>
													<td><s:property value="#s.user.username"/></td>
													<td><s:property value="#s.user.telephone"/></td>
													<td><s:property value="#s.orderTime"/></td>
													<td><s:property value="#s.address"/></td>
													<td><i class="fa fa-jpy"></i><s:property value="#s.totalPrice"/></td>
													<!-- <td class="operation">
														<a href="javascript:;">删除</a>
													</td> -->
													<td></td>
												</tr>
											</s:iterator>
											</tbody>
											<tfoot id="tfoot">
												<tr>
													<th><input type="checkbox"></th>
													<th>订单ID</th>
													<th>用户ID</th>
													<th>用户名</th>
													<th>用户电话</th>
													<th>下单时间</th>
													<th>处理时间</th>
													<th>总额</th>
													<!-- <th>操作</th> -->
													<th>详情</th>
												</tr>
											</tfoot>
										</table>
									</div>
								</div>
								 <!-- /BOX -->
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
	<!-- JAVASCRIPTS -->
	<jsp:include page="bottom.jsp"></jsp:include>
	<script>
		jQuery(document).ready(function() {		
			App.setPage("widgets_box");  //Set current page
			App.init(); //Initialise plugins and elements
		});

	  
	</script>
	
</body>
</html>