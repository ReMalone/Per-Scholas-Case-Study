<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Esign</title>
<script language = "JavaScript" type="text/javascript">
window.history.forward();     
function noBack() 
{ 
	window.history.forward();
}
function enableEsign()
{
	document.esign.esignature.disabled=false;
}
</script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script>
  $( function() {
    $( "#datepicker" ).datepicker({ minDate: 0, maxDate: "+60D" });
  } );
 </script>
</head>
<body onload="noBack();" onunload="">
	<%@include file="policyHeader.jsp"%>
	<hr/>
	<div style="width:800px; margin:0 auto;">
	<h1 align="center">Buy Policy</h1>
	<div align="right"><a href="logout.jsp">Logout</a></div>
	<p>Quote to Buy : <%=request.getParameter("quoteIdSelected")%></p>
	<form name="esign" action="policy" method="post">
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String todaysDate = sdf.format(Calendar.getInstance().getTime());
	%>
	Enter Policy Start Date: <input type="text" name="policyEffDate" id="datepicker" value =" <%=todaysDate%>"/>(yyyy-MM-dd);
	<br/>
	<h6>Policy start date cannot be more than 60 days from today's date</h6>
	<h6>The date 60 days after today is <%=todaysDate%></h6>
	<br/>
	<input type="checkbox" name="esignature" value="Esign" enabled="disabled" required/>This is to acknowledge that I have read the <a href="terms.html" onclick="enableEsign()" target="_blank">terms and conditions</a>.
	<br/><input type="submit" name="submit" value="Submit"/>
	</form>
	</div>
	<hr/>
	<script type="text/javascript">
		document.getElementById("esignImg").src="images/tick.jpg";
		document.getElementById("esign").className = "header1";
	</script>
</body>
</html>