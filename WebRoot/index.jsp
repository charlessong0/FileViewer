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

	
	
  </head>
  
  <body>

    <jsp:useBean id="user" class="test.Test" scope="page"></jsp:useBean> 
    <jsp:getProperty property="user" name="user"/> 

    <b>PP_TRR</b><br><b>2015-06-03</b>
    
   <script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/jquery.sortelements.js" type="text/javascript"></script>
	<script src="js/jquery.bdt.js" type="text/javascript"></script>
    <script>
    
	$(document).ready( function () {
	    $('#bootstrap-table').bdt();
	});
	// Using aoColumnDefs
$(document).ready( function() {
  $('#example').dataTable( {
    "aoColumnDefs": [ 
      { "bSortable": true, "aTargets": [ 0 ] }
    ] } );
} );
 
 
// Using aoColumns
$(bootstrap-table).ready( function() {
  $('#example').dataTable( {
    "aoColumns": [ 
      { "bSortable": true },
      null,
      null,
      null,
      null
    ] } );
} );
	</script>
    <table id="bootstrap-table" class="table table-hover" border='1'cellspacing="0" cellpadding="0" > 
    
    <jsp:useBean id="table" class="test.TestTable" scope="page"></jsp:useBean> 
    <jsp:getProperty property="table" name="table"/> 
    
    
    </table>
    
     
    
    <div style="color:red"><b>there is a validation conflict in row 1 column 10, which is marked in red</b></div>
    
  </body>
</html>
