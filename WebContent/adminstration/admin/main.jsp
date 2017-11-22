<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="top.jsp"></jsp:include>
</head>
<script>

</script>
<body>
	<!-- HEADER -->
	<header class="navbar clearfix" id="header">
		<div class="container">
				<div class="navbar-brand">
					<!-- COMPANY LOGO -->
					<a href="index.html">
						<img src="img/logo/logo.png" alt="二手书城" class="img-responsive" height="30" width="120">
					</a>
					<!-- /COMPANY LOGO -->
					<!-- TEAM STATUS FOR MOBILE -->
					<div class="visible-xs">
						<a href="#" class="team-status-toggle switcher btn dropdown-toggle">
							<i class="fa fa-users"></i>
						</a>
					</div>
				</div>
				
				<!-- BEGIN TOP NAVIGATION MENU -->					
				<ul class="nav navbar-nav pull-right">
					<!-- BEGIN USER LOGIN DROPDOWN -->
					<li class="dropdown user" id="header-user">
					<s:if test="#session.admin.adminName!=null">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<span class="username">${session.admin.adminName}</span>
							<i class="fa fa-angle-down"></i>
						</a>
					</s:if>
						<ul class="dropdown-menu">
							<li><a href="#"><i class="fa fa-user"></i>个人信息</a></li>
							<li><a href="adminAction_logout.action"><i class="fa fa-power-off"></i>退出</a></li>
						</ul>
					</li>
					<!-- END USER LOGIN DROPDOWN -->
				</ul>
				<!-- END TOP NAVIGATION MENU -->
		</div>
	</header>
	<!--/HEADER -->
	
	<!-- PAGE -->
	<section id="page">
		<!-- SIDEBAR -->
		<div id="sidebar" class="sidebar">
			<div class="sidebar-menu nav-collapse">
				<div class="divide-20"></div>
				<!-- SEARCH BAR -->
				<div id="search-bar">
					<input class="search" type="text" placeholder="Search"><i class="fa fa-search search-icon"></i>
				</div>
				<!-- /SEARCH BAR -->
				
				<!-- SIDEBAR MENU -->
				<ul>
					<li>
						<a href="index.jsp" target="content">
							<i class="fa fa-tachometer fa-fw"></i> <span class="menu-text">首&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</span>
						</a>					
					</li>
					<li class="has-sub">
						<a href="javascript:;">
						<i class="fa fa-bookmark-o fa-fw"></i> <span class="menu-text">系统管理</span>
						<span class="arrow"></span>
						</a>
						<ul class="sub">
							<li class="has-sub-sub">
								<a href="adminAction_AdminList.action" target="content"><span class="sub-menu-text">管理员列表</span>
								</a></li>
							<s:if test="#session.admin.limits==0">
							<li><a id="addAdmin" href="addAdministrator.jsp" target="content"><span class="sub-menu-text">添加管理员</span></a></li>
							</s:if>
						</ul>
					</li>
					<li><a href="userAction_UserList.action" target="content"><i class="fa fa-envelope-o fa-fw"></i> <span class="menu-text">用户管理</span></a></li>
					<li class="has-sub">
						<a href="javascript:;">
						<i class="fa fa-bookmark-o fa-fw"></i> <span class="menu-text">分类管理</span>
						<span class="arrow"></span>
						</a>
						<ul class="sub">
							<li class="has-sub-sub"><a href="itemAction_ItemList.action" target="content"><span class="sub-menu-text">一级分类列表</span></a></li>
							<li class="has-sub-sub"><a href="sitemAction_SItemList.action" target="content"><span class="sub-menu-text">二级分类列表</span></a></li>
							<li><a href="sitemAction_ItemList.action " target="content"><span class="sub-menu-text">添加分类</span></a></li>
						<!-- addItems.jsp-->
						</ul>
					</li>
					<li class="has-sub">
						<a href="javascript:;">
						<i class="fa fa-table fa-fw"></i> <span class="menu-text">图书管理</span>
						<span class="arrow"></span>
						</a>
						<ul class="sub">
							<li><a href="bookAction_BookList.action" target="content"><span class="sub-menu-text">图书列表</span></a></li>
							<li><a href="bookAction_SelectMenu.action" target="content"><span class="sub-menu-text">添加图书</span></a></li>
						</ul>
					</li>
					<li class="has-sub">
						<a href="javascript:;" >
						<i class="fa fa-pencil-square-o fa-fw"></i> <span class="menu-text">订单管理</span>
						<span class="arrow"></span>
						</a>
						<ul class="sub">
							<li><a href="orderAction_Orders.action" target="content"><span class="sub-menu-text">订单列表</span></a></li>
							<li><a href="orderAction_unhandleOrder.action" target="content"><span class="sub-menu-text">处理订单</span></a></li>
						</ul>
					</li>
				</ul>
				<!-- /SIDEBAR MENU -->
			</div>
		</div>
		<!-- /SIDEBAR -->
		<iframe id="content_iframe" onload="adjustFrameSize()" frameborder="0" width="100%" scrolling="no" src="<s:url value='index.jsp'/>" name="content">
		</iframe>
	</section>
	<jsp:include page="bottom.jsp"></jsp:include>
	
	<script>
		jQuery(document).ready(function() {		
			App.setPage("widgets_box");  //Set current page
			App.init(); //Initialise plugins and elements
		});

	    $('#super_datatable').DataTable( {
	        "pagingType": "full_numbers"
	    } );
	    
	    function adjustFrameSize()
	    {
	      var frm = document.getElementById("content_iframe"); //å°iframe1æ¿æ¢ä¸ºä½ çIDå
	      var subWeb = document.frames ? document.frames["iframe1"].document : frm.contentDocument;
	      if(frm != null && subWeb !=null)
	      {
	       frm.style.height="0px";
	       frm.style.height = subWeb.documentElement.scrollHeight+"px";
	       frm.style.width = subWeb.documentElement.scrollWidth+"px";
	       subWeb.body.style.overflowX="auto";
	       subWeb.body.style.overflowY="auto";
	      }
	    }
	</script>


</body>
</html>