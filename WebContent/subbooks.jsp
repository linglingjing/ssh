<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Product</title>
<jsp:include page="top.jsp"></jsp:include>
</head>
<body> 
	<s:action name="sitemAction_Menu" executeResult="true"></s:action>
	<!--prdt-starts-->
	<div class="prdt"> 
		<div class="container">
			<div class="prdt-top">
				<div class="col-md-12 prdt-left" id="itemContainer">
					<s:iterator value="#subBookList" var="s">
						<div class="col-md-3 product-left p-left">
							<div class="product-main">
								<a href="bookAction_loadDetailBook.action?deleteBId=<s:property value="#s.bid"/>" class="mask"><img class="img-responsive zoom-img" src="<s:property value="#s.photoURL"/>"/></a>
								<div class="product-bottom">
									<h3><s:property value="#s.bookName"/></h3>
									<p><s:property value="#s.author"/></p>
									<h4><a class="item_add" href="#"><i></i></a>
										<span class=" item_price">￥ <s:property value="#s.current_price"/></span>
										<span class="item_price">￥ <s:property value="#s.original_price"/></span>
									</h4>
								</div>
								<div class="srch srch1">
									<span><s:property value="#s.original_price-#s.current_price"/></span>
								</div>
							</div>
						</div>
					</s:iterator>	
					<div class="clearfix"></div>
				</div>	
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="holder"></div>
	</div>
	<!-- </div> -->
<!-- </div> -->
	<!--product-end-->
	
	<jsp:include page="bottom.jsp"></jsp:include>
	 <script>  
	  $(function(){  
	    $("div.holder").jPages({  
	      containerID : "itemContainer",  
	      previous : "←",  
	      next : "→",  
	      perPage : 8,  
	      delay : 100  
	    });  
	  });  
	</script>  
</body>
</html>