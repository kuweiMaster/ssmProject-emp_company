<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>updatePage</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/kuweiCss/index_work.css">

  </head>
  
  <body>
  <form action="<%=path %>/emp/update.co" method="post">
	  <table>
	  	<tr>
	  		<td>姓名</td>
	  		<td>
	  			<input name="id" type="hidden" value="${emp2.id }" />
	  			<input name="name" value="${emp2.name }" />
	  		</td>
	  	</tr>
	  	<tr>
	  		<td>工资</td>
	  		<td>
	  			<input name="salary" value="${emp2.salary }" />
	  		</td>
	  	</tr>
	  	<tr>
	  		<td>工作过的公司</td>
	  		<td>
	  			<c:forEach items="${list }" var="c">
	  				<input type="checkbox" name="ids" value="${c.id }" 
	  					<c:forEach items="${comList }" var="p">
	  						<c:if test="${c.id==p }">checked</c:if>
	  					</c:forEach>
	  				/>${c.company }
	  			</c:forEach>
	  		</td>
	  	</tr>
	  	<tr>
	  		<td colspan="10">
	  			<input type="submit" value="提交" />
	  		</td>
	  	</tr>
	  </table>
  </form>
  </body>
</html>
