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
  <h2>书本列表</h2>
  
  <table>
      <tr>
          <th>id</th>
          <th>系列号</th>
          <th>书名</th>
          <th>价格</th>
          <th>操作</th>
      </tr>
  
      <s:iterator value="#list" var="book">
          <tr>
          
           <td><s:property value="#book.id"/> </td>
           <td><s:property value="#book.isbn"/> </td>
           <td><s:property value="#book.bookName"/> </td>
           <td><s:property value="#book.price"/> </td>
           
           <td>
              <a href="bookAction_delete?id=<s:property value='#book.id'/>">删除</a>
               <a href="bookAction_update?id=<s:property value='#book.id'/>&flag=0">编辑</a>
            </td>
          </tr>
         
      </s:iterator>
   
  </table>
  <div style="text-align: center">
     <a href="bookAction_add?flag=1">添加</a>
  </div>
</body>
</html>