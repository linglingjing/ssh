<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="top.jsp"></jsp:include>
</head>
<body>
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
									<a href="index.html">首&nbsp;&nbsp;&nbsp;&nbsp;页</a>
								</li>
							</ul>
							<!-- /BREADCRUMBS -->
							<div class="clearfix">
								<h3 class="content-title pull-left">首&nbsp;&nbsp;页</h3>
							</div>
							<div class="description">首&nbsp;&nbsp;页</div>
						</div>
					</div>
				</div>
				<!-- /PAGE HEADER -->
				<div class="row"><div class="col-md-12"><h1>欢迎你</h1></div></div>
			</div>
		</div>
	</div>
</div>
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