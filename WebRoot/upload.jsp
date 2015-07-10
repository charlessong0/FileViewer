<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload Form</title>
</head>
<body>

<form action="upload.do" method="post" enctype="multipart/form-data">
	<input type="text" name="description" />
    <input type="file" name="file" />
    <input type="submit" />
</form>


</body>
</html>