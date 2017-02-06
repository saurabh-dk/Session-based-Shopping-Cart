<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
</head>
<body>
<%
int status=(Integer)request.getAttribute("checkoutStatus");


if(status==1)
	out.print("You have successfully ordered your products<br/>Thankyou for visiting us");
	else out.print("Sorry due to system failure we are unable to proceed your order.Plz try again later");
		
			session.invalidate();
%>

<br/><form action='index.jsp' method='POST'><input type='submit'value='Back to shopping'  /></form>
<br/><br/>
</body>
</html>