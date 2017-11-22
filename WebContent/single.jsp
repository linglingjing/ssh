<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Single</title>
<jsp:include page="top.jsp"></jsp:include>
<style type="text/css">
.con{
	width: 2em;
    text-align: center;
    }
.buycount{margin:1em 9em 0 0;display:inline-block;}
</style>		
</head>
<body> 
	<s:action name="sitemAction_Menu" executeResult="true"></s:action>
	<!--start-single-->
	<div class="single contact">
		<div class="container">
			<div class="single-main">
				<div class="col-md-12 single-main-left">
					<div class="sngl-top">
						<div class="col-md-4 single-top-left">	
							<div class="flexslider">
								  <ul class="slides">
									<li data-thumb="<s:property value="#detailBook.photoURL"/>">
										<div class="thumb-image"> <img src="<s:property value="#detailBook.photoURL"/>" data-imagezoom="true" class="img-responsive" alt=""/> </div>
									</li>
									<li data-thumb="<s:property value="#detailBook.photoURL"/>">
										 <div class="thumb-image"> <img src="<s:property value="#detailBook.photoURL"/>" data-imagezoom="true" class="img-responsive" alt=""/> </div>
									</li>
									<li data-thumb="<s:property value="#detailBook.photoURL"/>">
									   <div class="thumb-image"> <img src="<s:property value="#detailBook.photoURL"/>" data-imagezoom="true" class="img-responsive" alt=""/> </div>
									</li> 
								  </ul>
							</div>
							<!-- FlexSlider -->
						</div>	
						<div class="col-md-1"></div>
						<div class="col-md-7 single-top-right">
							<div class="single-para simpleCart_shelfItem">
							<h2><s:property value="#detailBook.bookName"/></h2>
								<div class="star-on">
									<ul class="star-footer">
											<li><a href="#"><i> </i></a></li>
											<li><a href="#"><i> </i></a></li>
											<li><a href="#"><i> </i></a></li>
											<li><a href="#"><i> </i></a></li>
											<li><a href="#"><i> </i></a></li>
										</ul>
									<div class="review">
										<span><s:property value="#detailBook.author"/></span> 
									</div>
								<div class="clearfix"> </div>
								</div>
								
								<h5><span class="item_price1">￥ <s:property value="#detailBook.original_price"/></span>
								<span class="item_price2"><em>￥ <s:property value="#detailBook.current_price"/></em></span></h5>

								<p><s:property value="#detailBook.info"/></p>
								<ul class="tag-men">
									<li><span>出&nbsp;版&nbsp;社&nbsp;&nbsp;</span>
									<span class="women1">: <s:property value="#detailBook.publisher"/></span></li>
									<%-- <li><span>销&nbsp;售&nbsp;量&nbsp;&nbsp;</span>
									<span class="women1">: 358</span></li> --%>
									<li><span>库&nbsp;存&nbsp;量&nbsp;&nbsp;</span>
									<span class="women1">: <s:property value="#detailBook.quantity"/></span></li>
									<li><span>出版时间</span>
									<span class="women1">: <s:property value="#detailBook.publishDate"/></span></li>
								</ul>
								<form id="cart_form" name="cart_form" method="post" action="cartAction_addCart?bid=<s:property value='#detailBook.bid'/>">
									<div class="buycount">
										<input type="button" id="" value="-" class="jian"/>
										<input type="text" name="buycount"  value="1" class="con"/>
										<input type="button" value="+" class="jia"/>
									</div>
									<a class="add-cart item_add">加入购物车</a>
								</form>
								<s:if test="#session.user.username!=null">
								<script>
									$(document).ready(function(){
									  $(".add-cart").click(function(){
									    	$("#cart_form").submit();
									    	alert("加入购物车成功！");
										});
									});
								</script>
							</s:if>
							<s:else>
								<script>
									$(document).ready(function(){
									  $(".add-cart").click(function(){
										if(alert("您还没登录，请先登录！")){
									    $("#cart_form").attr("action"," ");}
									  });
									});
								</script>
							</s:else>
							</div>
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<%-- <div class="single comment">
		<div class="container">
		<s:if test="#session.user.username!=null">
			<h3>评论区</h3>
			<form class="comment_form" action="commentAction_addComment?bid=<s:property value="#detailBook.bid"/>" method="post">
				<textarea name="content"  class="comment_area container">
				</textarea>
				<input type="submit" value="发表">
			</form>
		</s:if>
			<div class="comment_display">
			<h3>评论详情</h3>
			<s:iterator value="#comments" var="s">
				<div class="comment_record">
					<h4 class="username"><s:property value="#s.user.username"/> :</h4>
					<p><s:property value="#s.content"/></p>
				</div>
			</s:iterator>
			</div>
		</div>
	</div>
	 --%><!--end-single-->
	
	<jsp:include page="bottom.jsp"></jsp:include>
	<script>
	$(window).load(function() {
	$('.flexslider').flexslider({
	animation: "slide",
	controlNav: "thumbnails"
	});
	});
	
	$(function(){
		//这是加1
		$(".buycount").find(".jia").click(function(){
		$(this).prev().val(parseInt($(this).prev().val())+1); 

		});
		//这是减1
		$(".buycount").find(".jian").click(function(){
		$(this).next().val(parseInt($(this).next().val())-1); 
		});
	
	});
	</script>
	
	</body>
</html>