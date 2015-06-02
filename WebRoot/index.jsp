<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>PGW Toolkit Demo Page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>

    <jsp:useBean id="user" class="test.Test" scope="page"></jsp:useBean> 
    <jsp:getProperty property="user" name="user"/> 
    

	
    <b>PP_TRR</b><br><b>2015-06-02</b>
    <table border='1'cellspacing="0" cellpadding="0" > 
    
    <jsp:useBean id="table" class="test.TestTable" scope="page"></jsp:useBean> 
    <jsp:getProperty property="table" name="table"/> 
    </table>
    <div style="color:red"><b>there is a validation conflict in row 1 column 10, which is marked in red</b></div>
    
  </body>
</html>
