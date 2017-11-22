<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Checkout</title>
<jsp:include page="top.jsp"></jsp:include>	
<style type="text/css">
.cart-bottom{padding:1em 0;margin-top:2em;}
.cart-bottom li:first-child{width:70%;}
.cart-bottom li:nth-child(2){width:15%}
.cart-bottom li:last-child{width:15%;text-aligin:right;}
.cart-bottom li{
	display:inline-block;
	list-style:none;
}
#totalprice{border:none;outline:none;display:inline-block;width:120px;font-size:1.5em;color:#f60;}
#total_button{
	padding:10px 3em;
	font-size:1.1em;
	background:#000;
	color:#fff;
	text-decoration:none;
}
#total_button:hover{
	text-decoration:none;
	background:#337ab7;
	cursor:pointer;
}
#address{
	width:40%;
	height: 2.5em;
    padding: 5px 0;
    text-indent:10px;
    margin-left:10px;
}
.cart-bottom li:nth-child(2) span{font-size:1.3em;padding:8px 0;}
</style>
</head>
<body> 
	<s:action name="sitemAction_Menu" executeResult="true"></s:action>
	<!--start-ckeckout-->
	<div class="ckeckout">
		<div class="container">
			<div class="ckeck-top heading">
				<h2>CHECKOUT</h2>
			</div>
			<div class="ckeckout-top">
			<div class="cart-items">
			 <h3>我的购物车 (3)</h3>
			<div class="in-check" >
				<ul class="unit">
					<li><span>列表</span></li>
					<li><span>产品名称</span></li>		
					<li><span>单价</span></li>
					<li><span>数量</span></li>
					<li><span>总计</span></li>
					<div class="clearfix"> </div>
				</ul>
				<s:iterator value="#CartList" var="s">
				<ul class="cart-header2">
					<a href="cartAction_deleteCartList.action?cartId=<s:property value='#s.cartid'/>">
					<div class="close3"></div>
					</a>
					<li class="ring-in"><a href="single.jsp" ><img src=" <s:property value="#s.book.photoURL"/>" class="img-cart" alt=""></a>
					</li>
					<li><span class="name"> <s:property value="#s.book.bookName"/></span></li>
					<li><span class="cost"><s:property value="#s.book.current_price"/></span></li>
					<li><span class="count"><s:property value="#s.count"/></span></li>
					<li><span>￥</span><span class="subcost"> <%-- <s:property value="#s.subtotal"/> --%></span></li>
					<div class="clearfix"> </div>
				</ul>
				</s:iterator>
				<form id="total_form" name="total_form" method="post" action="">
					<ul class="cart-bottom">
						<li><span>地址: </span><input name="address" type="text" id="address" required="required"></li>
						<li><span>共￥</span><input name="totalprice" id="totalprice" type="text" value="0"/></li>
						<li><a id="total_button">结算</a></li>		
						<div class="clearfix"> </div>
					</ul>
				</form>
			</div>
			</div>  
		 </div>
		</div>
	</div>
	<!--end-ckeckout-->
	<jsp:include page="bottom.jsp"></jsp:include>
	<script>
	$(document).ready(function(){
		/* 小计 */
		
		/* 总计 */
		var size=$('.subcost').size();
		var totalprice=0;
		/* $('.subcost').each(function(){ */
			for(var i=0;i<size;i++){
				console.log($('.cost').eq(i).text());
				var cost=parseFloat($('.cost').eq(i).text())*parseInt($('.count').eq(i).text());
				$('.subcost').eq(i).html(cost.toFixed(2));
				var subtotal=parseFloat($('.subcost').eq(i).text());
				totalprice=totalprice+subtotal;
			}
		/* }) */
		console.log("totalprice:"+totalprice);
		$('#totalprice').val(totalprice.toFixed(2));
		$('.simpleCart_total').html('￥ '+totalprice.toFixed(2));
		
		$('#total_button').click(function(){
			$('#total_form').attr("action","orderAction_addOrder.action");
			$('#total_form').submit();
		});
		
	});
	</script>
</body>
</html>