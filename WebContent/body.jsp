<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>You Shu | body</title>

</head>
<body> 
	<!--product-starts-->
	<!-- <div class="product">  -->
		<div class="container">
			<div class="product-top">
				<h3><span>新</span>书上架</h3>
				<div class="product-one">  
				<s:iterator value="#subBookList1" var="s">
					<div class="col-md-3 product-left">
						<div class="product-main">
							<a href="bookAction_loadDetailBook.action?deleteBId=<s:property value="#s.bid"/>" class="mask"><img src="<s:property value="#s.photoURL"/>" /></a>
							<div class="product-bottom">
								<h3><s:property value="#s.bookName"/></h3>
								<p><s:property value="#s.author"/></p>
								<h4><a class="item_add" href="#"></a> 
									<span class=" item_price1">￥ <s:property value="#s.current_price"/></span>
									<span class="item_price2"><em>￥ <s:property value="#s.original_price"/></em></span>
								</h4>
							</div>
							<div class="srch">
								<span>新</span>
							</div>
						</div>
					</div>
				</s:iterator>
				</div> 
				<div class="product-one">  
				<s:iterator value="#subBookList2" var="s">
					<div class="col-md-3 product-left">
						<div class="product-main">
							<a href="bookAction_loadDetailBook.action?deleteBId=<s:property value="#s.bid"/>" class="mask"><img src="<s:property value="#s.photoURL"/>" /></a>
							<div class="product-bottom">
								<h3><s:property value="#s.bookName"/></h3>
								<p><s:property value="#s.author"/></p>
								<h4><a class="item_add" href="#"></a> 
									<span class=" item_price1">￥ <s:property value="#s.current_price"/></span>
									<span class="item_price2"><em>￥ <s:property value="#s.original_price"/></em></span>
								</h4>
							</div>
							<div class="srch">
								<span>新</span>
							</div>
						</div>
					</div>
				</s:iterator>
				</div> 
			</div>
		</div>
	<!--product-end-->
	
	

	 
</body>
</html>