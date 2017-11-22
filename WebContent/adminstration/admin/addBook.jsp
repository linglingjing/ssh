<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="top.jsp"></jsp:include>
	<style type="text/css">
	
	</style>
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
						<!-- addAdministrator -->
						<div class="box border pink" id="addAdministrator">
							<div class="box-title">
								<h4><i class="fa fa-bars"></i><span class="stepHeader">添加新图书</h4>
							</div>
							<div class="divide-40" style="background:#fff;"></div>
							<div class="box-body form">
								<s:form id="bookForm" method="post" action="bookAction_addBook.action" class="form-horizontal" name="addbook" enctype="multipart/form-data">
									<div class="form-group">
										<label class="col-md-2 control-label">图书名</label>
										<div class="col-md-9">
										  <input class="form-control" type="text" name="bookName">
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-2 control-label">图书原价</label>
										<div class="col-md-9">
										  <input class="form-control" type="text" name="original_price">
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-2 control-label">图书二手价</label>
										<div class="col-md-9">
										  <input class="form-control" type="text" name="current_price">
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-2 control-label">作者</label>
										<div class="col-md-9">
										  <input class="form-control" type="text" name="author">
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-2 control-label">出版社</label>
										<div class="col-md-9">
										  <input class="form-control" type="text" name="publisher">
										</div>
									</div>
								    <div class="form-group">
										<label class="col-md-2 control-label">图书简介</label>
										<div class="col-md-9">
										  <textarea class="form-control" rows="6" name="info" ></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-2 control-label">库存量</label>
										<div class="col-md-9">
										  <input class="form-control" type="text" name="quantity">
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-2 control-label">图书分类</label>
										<div class="doubleselect">
											 <s:doubleselect 
											list="selectMenus" listKey="cid" listValue="cname"  name="cid" cssClass="form-control  col-md-2" cssStyle="width:150px;margin-left:1em;"
											doubleList="subCategoryMap[top.cid]" doubleListKey="sid" doubleListValue="sname" doubleName="sid" 
											 doubleCssClass="form-control  col-md-2" doubleCssStyle="width:150px;margin-left:2em;" formName="addbook">
											</s:doubleselect>
										</div>
										<div class="col-md-2">
											
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-2 control-label">图书图片</label>
										<div class="col-md-9">
										  <input id="images" class="form-control" name="photo" type="file">
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-2 control-label">出版时间</label>
										<div class="col-md-9">
										  <input class="form-control" type="text" name="publishDate">
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-offset-4">
											<input class="btn btn-pink col-md-6"  style="margin:1em 0 0 1em; padding:.8em 0;" type="submit" value="提交"/>
										</div>
									</div>
								</s:form>
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
	    $('.doubleselect').find('br').remove();
	    
	</script>
</body>
</html>