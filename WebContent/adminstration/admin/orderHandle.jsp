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
	<!-- SAMPLE BOX CONFIGURATION MODAL FORM-->
	<div class="modal fade" id="box-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		  <div class="modal-content">
			<div class="modal-header">
			  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			  <h4 class="modal-title">填写物流信息</h4>
			</div>
			<form class="form-horizontal" method="post" id="handleForm" name="handleForm" action="">
			  <div class="modal-body">
			  	<div class="form-group">
					<label class="col-md-3 control-label">物流公司</label>
					<div class="col-md-7">
					  <input class="form-control" type="text"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">物流单号</label>
					<div class="col-md-7">
					  <input class="form-control" type="text" value="<s:property value="#unhandleOrder.oid"/>"/>
					</div>
				</div>
			 </div>
			 <div class="modal-footer">
			  <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			  <input type="submit" class="btn btn-primary" id="handleButton" value="保存">
			 </div>
		   </form>
		  </div>
		</div>
	  </div>
	<!-- /SAMPLE BOX CONFIGURATION MODAL FORM-->
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
								<h4><i class="fa fa-table"></i>待处理订单</h4>
								<div class="tools hidden-xs">
									
									<a href="javascript:;" class="reload">批量处理
									</a>
								</div>
							</div>
							<div class="box-body">
								<table id="super_datatable" cellpadding="0" cellspacing="0" border="0" class="datatable table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th><input type="checkbox"></th>
											<th>订单ID</th>
											<th>用户ID</th>
											<th>用户名</th>
											<th>下单时间</th>
											<th>收货地址</th>
											<th>订单状态</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="#unhandleOrder" var="s">
											<tr class="gradeA">
												<td><input type="checkbox"></td>
												<td clsaa="oid"><s:property value="#s.oid"/></td>
												<td><s:property value="#s.user.id"/></td>
												<td><s:property value="#s.user.username"/></td>
												<td><s:property value="#s.orderTime"/></td>
												<td><s:property value="#s.address"/></td>
												<td><a href="#box-config" data-toggle="modal" class="config" onclick="getOid(<s:property value="#s.oid"/>)">未发货</a></td>
											</tr>
										</s:iterator>
									</tbody>
									<tfoot id="tfoot">
										<tr>
											<th><input type="checkbox"></th>
											<th>订单ID</th>
											<th>用户ID</th>
											<th>用户名</th>
											<th>下单时间</th>
											<th>收货地址</th>
											<th>订单状态</th>
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
	<jsp:include page="bottom.jsp"></jsp:include>
	<script>
		jQuery(document).ready(function() {		
			App.setPage("widgets_box");  //Set current page
			App.init(); //Initialise plugins and elements
		});

	    $('#super_datatable').DataTable( {
	        "pagingType": "full_numbers"
	    } );
	    var oid;
	    function getOid(oid){
	    	this.oid=oid;
	    	console.log(this.oid);
	    	$('#handleForm').attr("action","orderAction_changeOrderState.action?oid="+this.oid);
	    }
	    $('#handleButton').click(function(){
	    	alert("保存成功！");
	    })
	</script>

</body>
</html>