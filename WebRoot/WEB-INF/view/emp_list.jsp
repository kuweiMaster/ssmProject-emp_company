<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'emp_list.jsp' starting page</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/kuweiCss/index_work.css">

  </head>
  
  <body>
  <table>
  	<tr>
  		<td>序号</td>
  		<td>姓名</td>
  		<td>工资</td>
  		<td>工作过的公司</td>
  		<td>工作过的公司数量</td>
  		<td>操作
  			<input type="button" value="添加" onclick="location='<%=path %>/emp/toAdd.co'" />
  		</td>
  	</tr>
  	<c:forEach items="${list }" var="e" varStatus="s">
  		<tr>
	  		<td>${s.index+1 }</td>
	  		<td>${e.name }</td>
	  		<td>${e.salary }</td>
	  		<td>${e.company }</td>
	  		<td>${e.comNum }</td>
	  		<td>
	  			<input type="button" value="修改" onclick="location='<%=path %>/emp/toUpdate.co?id=${e.id }'" />
	  			<input type="button" value="删除" onclick="location='<%=path %>/emp/deleteEmp.co?id=${e.id }'"/>
	  		</td>
	  	</tr>
  	</c:forEach>
  </table>
  </body>
</html>
