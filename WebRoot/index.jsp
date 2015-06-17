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


 <script>
	function accountSubmit(){ 
  var submitType = $("input[name='file-type']").val();
  if(submitType=='c'){
    $('#file-type').attr('action','http://localhost:8080/FileViewer/csvTable.jsp');
  }else if(submitType=='f'){
    $('#file-type').attr('action','http://localhost:8080/FileViewer/fixedTable.jsp');
  }
  $('#file-type').submit();
}
	</script>

<form action="" method="post" id="file-type">
	Choose File<br> 
	<select>  
  <option value ="1">US-eBay-EOM-Fees@ebay.com.TRR-20140702.01.008.csv</option>  
  <option value ="2">KXCV00P.GB.GLOBAL.BIN.RANGE.G3586V00.txt</option>  
</select> <br>
<br>
	File Type<br>
	<select>  
  <option value ="1">PP_TRR</option>  
  <option value="2">GLOBAL.BIN.RANGE</option>  
</select> <br>
<br>
	File Template<br>
	<input type="radio" name="file-type" value="c" onclick="if (this.checked){window.location='http://localhost:8080/FileViewer/csvTable.jsp'}"> CSV File<br>
	<input type = "radio" name="file-type" value="f" onclick="if (this.checked){window.location='http://localhost:8080/FileViewer/fixedTable.jsp'}"> Fixed File<br>
	<br>
	<input type="submit" value="Submit" onclick="$('#account').submit();"></input> <input type="reset" value="Reset" />
</form>


	
    
</body>
</html>
