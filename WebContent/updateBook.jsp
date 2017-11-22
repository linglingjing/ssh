<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="bookAction_save" method="post">
  <h2>编辑书本</h2>
  
  <input type="hidden" name="id" value="<s:property value='#book.id'/>"/>
  <input type="hidden" name="flag" value="<s:property value='#flag'/>"/>
  
  书的系列号：<input type="text" name="isbn" value="<s:property value='#book.isbn'/>"/>
   书的名称：<input type="text" name="bookName" value="<s:property value='#book.bookName'/>"/>
   书的价格：<input type="text" name="price" value="<s:property value='#book.price'/>"/>
   
   <input type="submit" value="提交"/>
  </form>
</body>
</html>