<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/quote.css">
<title>Homeowners Insurance Quote - New User Registration</title>
<SCRIPT LANGUAGE="JavaScript" TYPE="text/javascript">

function validate(user) {
	//review layout of location.jsp validation
	//created variable to reduce typing
	var userName = document.forms["registration"]["userName"];
	var password = document.forms["registration"]["password"];
	var confirmPass = document.forms["registration"]["confirmPass"];
		
	if(userName.value == "")//updated
	{
		alert("Please enter the User name");
		userName.focus();//updated
		return false;
	}

	if(password.value == "")//updated
	{
		alert("Please enter your Password");
		password.focus();//updated
		return false;
	}
	if (confirmPass.value == "")//updated
	{
		alert("Please confirm password");
		confirmPass.focus();//updated
		return false;
	}	
	if (password.value!=confirmPass.value)//updated
	{
		alert("Please enter same value for password and re-enter password");
		
		return false;
	}
	return true;
}
</script>

</head>
<body>
<hr/>
<h1 align="center"><img src="images/home2.jpg"/>Homeowner Insurance Quote</h1>
<hr/>
<br />
<div align="center" style="width:800px; margin:0 auto;">
<form name="registration" action="login?action=newUser" method="post">
<%
if(request.getAttribute("message")!= null) {
	out.println("<font color=red size=4px>"+request.getAttribute("message")+"</font>");
}
%>	
<jsp:useBean id='user' scope='session' class='com.cts.insurance.homequote.model.User' type="com.cts.insurance.homequote.model.User" />
	<table>
		<tr>
			<th colspan="2">For New users:</th>
		</tr>
		<tr></tr>
		<tr>
			<td>Username :</td>
			<td width="70%"><input value='<jsp:getProperty name="user" property="userName"/>' name="userName" value=""
			pattern="[A-Za-z0-9]{1,20}" title="Alphanumeric and be less than 20 characters" /></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td width="70%"><input type="password" name="password" value='<jsp:getProperty name="user" property="password"/>' name="password" value=""
			pattern="[A-Za-z0-9]{1,20}" title="Alphanumeric and be less than 20 characters"/></td>
		</tr>
		<tr>
			<td>Re-enter password</td>
			<td width="70%"><input type="password" name="confirmPass" value='<jsp:getProperty name="user" property="password"/>' name="password" value=""/></td>
		</tr>
		<tr></tr>
		<tr>
			<td colspan=2 align="center"><input type="submit" value="Login"
				onclick="return validate(this);" /> <!-- For some reason the word user wasn't working. perhaps because the property of name is user. the word this does. -->
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>