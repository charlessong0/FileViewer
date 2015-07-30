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
	
	<link rel="stylesheet" type="text/css" href="styles.css">
	<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
	<link href="css/font-awesome.min.css" type="text/css" rel="stylesheet">
	<link href="css/jquery.bdt.css" type="text/css" rel="stylesheet">
	
	<link href="css/bsetterTable.css" type="text/css" rel="stylesheet">
	

	<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/jquery.sortelements.js" type="text/javascript"></script>
	<script src="js/jquery.bdt.js" type="text/javascript"></script>
    <script>
	$(document).ready( function () {
	    $('#bootstrap-table').bdt();
	});
	
	</script>
	 <script>
	$(document).ready( function () {
	    $('#bootstrap-table2').bdt();
	});
	
	</script>
	
  </head>
  
  <body>
	<div id="cover">
	 <div id="table-body" style="width: auto;height: auto; position: absolute;left:10px;top:100px">
    <b>Cash Management</b><br>
    <b>2015-07-28</b>
    <br>
    <br>
    <b>Adjustment Record:</b>
    <table id="bootstrap-table" class="table table-hover" border='1'cellspacing="0" cellpadding="0" > 
    
    <jsp:useBean id="table" class="servlets.TableServlet" scope="page"></jsp:useBean> 
    <jsp:getProperty property="table2" name="table"/> 
    
    </tbody>
    </table>
    </div>
	
   <%-- 
   <jsp:getProperty property="error" name="table"/> 
   --%> 
  
  
    <div id="table-header" style="width: auto;height: auto; position: absolute;left:10px;top:10px">
    <table id="bootstrap-table" class="table table-hover" border='1'cellspacing="0" cellpadding="0" > 
     <jsp:getProperty property="header2" name="table" /> 
     </tbody>
    </table>
    </div>
    
    <div id="table-tailer" style="width: auto;height: auto; position: absolute;left:10px;top:1900px">
    <table id="bootstrap-table" class="table table-hover" border='1'cellspacing="0" cellpadding="0" > 
    <jsp:getProperty property="tailer2" name="table"/> 
     </tbody>
    </table>
    </div>
    
    <div id="table-body2" style="width: auto;height: auto; position: absolute;left:10px;top:800px">
   
    <b>CheckBack Record:</b>
    <table id="bootstrap-table2" class="table table-hover" border='1'cellspacing="0" cellpadding="0" > 
    
    <jsp:useBean id="tables" class="servlets.TableServlet" scope="page"></jsp:useBean> 
    <jsp:getProperty property="table3" name="tables"/> 
    
    </tbody>
    </table>
    </div>
    
	</div>
    
  </body>
</html>
