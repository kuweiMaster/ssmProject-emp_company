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
	<script type="text/javascript" src="<%=path %>/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript">
		$(function(){
			//获取复选框内容
			$.post(
				"<%=path %>/emp/getCompanyList.co",
				function(obj){
					for(var i in obj){
						$("#companyBox").append("<input type='checkbox' name='ids' value="+obj[i].id+" />"+obj[i].company);
					}
				},
				"json"
			);
		});
	</script>
	
  </head>
  
  <body>
  <form action="<%=path %>/emp/add.co" method="post">
	  <table>
	  	<tr>
	  		<td>姓名</td>
	  		<td>
	  			<input name="name" />
	  		</td>
	  	</tr>
	  	<tr>
	  		<td>工资</td>
	  		<td>
	  			<input name="salary" />
	  		</td>
	  	</tr>
	  	<tr>
	  		<td>工作过的公司</td>
	  		<td id="companyBox"></td>
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
