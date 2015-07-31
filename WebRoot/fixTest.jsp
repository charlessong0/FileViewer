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
	
  </head>
  
  <body>
   <%
	 String finalPath=(String)request.getAttribute("finalPath");
	 String fixedPath=(String)request.getAttribute("fixedPath");
	 String csvPath=(String)request.getAttribute("csvPath");
	 String fileType=(String)request.getAttribute("fileType");
	 String date=(String)request.getAttribute("date");
	 String table=(String)request.getAttribute("table");
	 String header=(String)request.getAttribute("header");
	 String tailer=(String)request.getAttribute("tailer");
	 
	 %>
	<div id="cover">
	
	
   <%-- 
   <jsp:getProperty property="error" name="table"/> 
   --%> 
<%--

 <div id="table-header" style="width: auto;height: auto;left:10px;top:10px; position: relative">
    <table id="bootstrap-table" class="table table-hover" border='1'cellspacing="0" cellpadding="0" > 
<%=header %>
     </tbody>
    </table>
    </div>
    
     <div id="table-body" style="width: auto;height: auto; left:10px; position: relative">
    <b><%=fileType %></b><br>
    <b><%=date %></b>
    <table id="bootstrap-table" class="table table-hover" border='1'cellspacing="0" cellpadding="0" > 
    
   <%=table %>
    
    </tbody>
    </table>
    </div>
    
    <div id="table-tailer" style="width: auto;height: auto; left:10px;bottom:10px; position: relative">
    <table id="bootstrap-table" class="table table-hover" border='1'cellspacing="0" cellpadding="0" > 
<%=tailer %>
     </tbody>
    </table>
    </div>
    

    
	</div>


 --%>
 
    
	
   <%-- 
   <jsp:getProperty property="error" name="table"/> 
   --%> 
  
    <div id="table-header" style="width: auto;height: auto; position: relative;left:10px;top:10px;float:left;clear:both">
    <table id="bootstrap-table2" class="table table-hover" border='1'cellspacing="0" cellpadding="0" > 
     <%=header %>
     </tbody>
    </table>
    </div>
    
    
    <div id="table-body" style="width: auto;height: auto; position: relative;left:10px;float:left;clear:both">
	    <b><%=fileType %></b><br>
	    <b><%=date %></b>
	    <table id="bootstrap-table" class="table table-hover" border='1'cellspacing="0" cellpadding="0" > 
	    
	    <%=table %>
	    
	    </tbody>
	    </table>
    </div>
    
    <div id="table-tailer" style="width: auto;height: auto; position: relative;left:10px;float:left;clear:both">
    <table id="bootstrap-table3" class="table table-hover" border='1'cellspacing="0" cellpadding="0" > 
    <%=tailer %>
     </tbody>
    </table>
    </div>
    
    <div id="searchPart">
    
    </div>
 
 </div>
   
  </body>
</html>
