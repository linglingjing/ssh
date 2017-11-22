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
							<div class="box border red" id="userList">
								<div class="box-title">
									<h4><i class="fa fa-table"></i>用户列表</h4>
									<div class="tools">
										<a href="javascript:;" id="chooseAll">全选</a>
										<a href="javascript:;" id="chooseInverse">反选</a>
										<a id="batchdelete_user" href="" class="reload">批量删除</a>
									</div>
								</div>
								<div class="box-body">
									<table id="super_datatable" cellpadding="0" cellspacing="0" border="0" class="datatable table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th><input type="checkbox"></th>
												<th>用户ID</th>
												<th>用户名</th>
												<th>手机号码</th>
												<th>密码</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
										<s:iterator value="#UserList" var="s">
											<tr class="gradeA">
												<td><input type="checkbox" name="ids" value="<s:property value="#s.id"/>"/></td>
												<td><s:property value="#s.id"/></td>
												<td><s:property value="#s.username"/></td>
												<td><s:property value="#s.telephone"/></td>
												<td><s:property value="#s.password"/></td>
												<td><a href="userAction_DeleteUser.action?userId=<s:property value="#s.id"/>">删除</a></td>
											</tr>
										</s:iterator>
										</tbody>
										<tfoot id="tfoot">
											<tr>
												<th><input type="checkbox"></th>
												<th>用户ID</th>
												<th>用户名</th>
												<th>手机号码</th>
												<th>密码</th>
												<th>操作</th>
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
	    $('#batchdelete_user').click(function() {
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
	 	  	 $(this).attr("href","userAction_DeleteUsers.action?ids="+chk_value);
	 	   }
	    });
	</script>

</body>
</html>