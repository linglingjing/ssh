<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>You Shu | Index</title>
<jsp:include page="top.jsp"></jsp:include>
</head>
<body> 
	<!-- executeResult="true" 显示返回的页面 -->
	<s:action name="sitemAction_Menu" executeResult="true"></s:action>
	<!--banner-starts-->
	<div class="bnr" id="home">
		<div  id="top" class="callbacks_container">
			<ul class="rslides" id="slider4">
			    <li>
					<div class="banner">
					</div>
				</li>
				<li>
					<div class="banner1">
					</div>
				</li>
				<li>
					<div class="banner2">
					</div>
				</li>
			</ul>
		</div>
		<div class="clearfix"> </div>
	</div>
	<!--banner-ends--> 	

	<!--product-starts-->
	 <div class="product"> 
			<s:action name="bookAction_recommendBooks" executeResult="true"></s:action>
	</div>
	 <!--product-end-->
	
	
	<!--Slider-Starts-Here-->
	<jsp:include page="bottom.jsp"></jsp:include>
	 <script>
	    // You can also use "$(window).load(function() {"
	    $(function () {
	      // Slideshow 4
	      $("#slider4").responsiveSlides({
	        auto: true,
	        pager: true,
	        nav: true,
	        speed: 500,
	        namespace: "callbacks",
	        before: function () {
	          $('.events').append("<li>before event fired.</li>");
	        },
	        after: function () {
	          $('.events').append("<li>after event fired.</li>");
	        }
	      });
	
	    });
	    <!--End-slider-script-->
	  </script>
	
</body>
</html>