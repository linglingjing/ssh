<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	
</head>
<body>
	<!-- JAVASCRIPTS -->
	<!-- JQUERY -->
	<script src="${pageContext.request.contextPath }/adminstration/admin/js/jquery/jquery-2.0.3.min.js"></script>
	<!-- JQUERY UI-->
	<script src="${pageContext.request.contextPath }/adminstration/admin/js/jquery-ui-1.10.3.custom.min.js"></script>
	<!-- BOOTSTRAP -->
	<script src="${pageContext.request.contextPath }/adminstration/admin/js/bootstrap.min.js"></script>
	<!-- DATATABLES -->
	<script src="${pageContext.request.contextPath }/adminstration/admin/js/datatables/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath }/adminstration/admin/js/datatables/define_datatables.js"></script>
	<!-- DATATABLES -->
	<script src="${pageContext.request.contextPath }/adminstration/admin/js/form/jquery.validate.min.js"></script>
	<script src="${pageContext.request.contextPath }/adminstration/admin/js/formValidation.js"></script>
	<!-- FileInput -->
	<script src="${pageContext.request.contextPath }/adminstration/admin/js/fileinput/fileinput.min.js"></script>
	<script src="${pageContext.request.contextPath }/adminstration/admin/js/fileinput/fileinput_locale_zh.js"></script>
	<!-- FileInput -->
	<!-- CUSTOM SCRIPT -->
	<script src="${pageContext.request.contextPath }/adminstration/admin/js/script.js"></script>
	
	<script >
	/*全选JS*/
    $('#chooseAll').click(function() {
    	var objs = window.document.getElementsByName("ids");
		for ( var i = 0; i < objs.length; i++) {
			var obj = objs[i];
			obj.checked = true;
		}  
	});
   
   $('#chooseInverse').click(function() {
  		var objs = window.document.getElementsByName("ids");
        for (var i=0; i < objs.length; i++) {  
            var obj = objs[i];  
            if(obj.checked) {  
         	   obj.checked = false;  
            }else {  
         	   obj.checked = true;  
            }  
        }
	}); 
	
 
 </script>
 
   </body>
   </html>