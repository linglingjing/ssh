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
										<a href="index.html">首页</a>
									</li>
								</ul>
								<!-- /BREADCRUMBS -->
								<div class="clearfix">
									<h3 class="content-title pull-left">管理员列表</h3>
								</div>
								<div class="description">管理员列表</div>
							</div>
						</div>
					</div>
					<!-- /PAGE HEADER -->
					<!-- TABLES -->
					<div class="row">
						<div class="col-md-12">
							<!-- BOX -->
							<div class="box border green">
								<div class="box-title">
									<h4><i class="fa fa-table"></i>超级管理员列表</h4>
									<div class="tools">
										<a href="javascript:;" id="chooseAll">全选</a>
										<a href="javascript:;" id="chooseInverse">反选</a>
										<a id="batchdelete" href="" class="reload">批量删除</a>
									</div>
								</div>
								<div class="box-body">
									<table id="super_datatable" cellpadding="0" cellspacing="0" border="0" class="datatable table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>选择</th>
												<th>管理员ID</th>
												<th>账户名</th>
												<th>密码</th>
												<th>类型</th>
												<th>注册时间</th>
												<s:if test="#session.admin.limits==0"><th>操作</th></s:if>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="#AdminList" var="s">
												<tr class="gradeA">
													<td><input type="checkbox" name="ids" value="<s:property value="#s.id"/>"/></td>
													<td><s:property value="#s.id"/></td>
													<td><s:property value="#s.adminName"/></td>
													<td><s:property value="#s.password"/></td>
													<td>
														<s:if test="#s.limits==0">超级管理员</s:if>
														<s:else>普通管理员</s:else>
													</td>
													<td><s:property value="#s.registerDate"/></td>
													<s:if test="#session.admin.limits==0"><td>
													 <s:a href="adminAction_DeleteSuperAdmin.action?adminId=%{#s.id}">删除</s:a>
													 <s:a href="adminAction_UpdateEdit?adminId=%{#s.id}">修改</s:a>
													 <%-- <s:a href="modifyAdministrator.jsp?adminId=%{#s.id}&adminName=%{#s.adminName}&adminPassword=%{#s.password}&adminLimits=%{#s.limits}">修改</s:a> --%>
													</td></s:if>
												</tr>
											</s:iterator>
										</tbody>
										<tfoot id="tfoot">
											<tr>
												<th>选择</th>
												<th>管理员ID</th>
												<th>账户名</th>
												<th>密码</th>
												<th>类型</th>
												<th>注册时间</th>
												<s:if test="#session.admin.limits==0"><th>操作</th></s:if>
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

	    $('#super_datatable').DataTable( {
	        "pagingType": "full_numbers"
	    } );
	  //一、检查是否已选，jquery实现
	    $('#batchdelete').click(function() {
	 	   var obj =$("input[type=checkbox]:checked");//定义一个数组 
	   	   var count=$("input[type=checkbox]:checked").size(); //size是选中的个数
	 	   if(count==0){
	 	  	 alert("没有选中删除的记录");
	 	  	 $(this).attr("href","javascript:;");
	 	   }else{
	 		 var chk_value=0;
	 		 for(var i=0;i<count;i++){
	 			 if(obj[i].checked){ 
	 				 console.log(obj[i].value);
	 				 chk_value+=obj[i].value+',';
	                }
	 		 }
	 		 console.log(chk_value);
	 	  	 $(this).attr("href","adminAction_DeleteSuperAdmins.action?ids="+chk_value);
	 	   }
	    });
	    
	</script>

</body>
</html>