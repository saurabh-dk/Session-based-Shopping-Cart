<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,Model.ProductBean" import="Controller.ShoppingBasketContoller" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Basket</title>
</head>
<body>
<%

if(getServletContext().getAttribute("products")==null){
	RequestDispatcher rd;
	rd = request.getRequestDispatcher("/ShoppingBasketContoller");
	rd.forward(request,response);
	out.print("No products in Database");
}
else
{
%>
<form method=POST action="ShoppingBasketContoller">
		<br>
		Please enter item to add or remove:
		<br>
		<br>
		Add Item:
		<SELECT NAME="items">
			<% 
			HashMap<Integer,ProductBean> productsHm;
			productsHm=(HashMap<Integer,ProductBean>)getServletContext().getAttribute("products");
			for(Map.Entry<Integer,ProductBean> m:productsHm.entrySet()){
				int key = m.getKey();
				ProductBean pb = m.getValue();
				out.print("<OPTION value='"+pb.getId()+"'>"+pb.getName()+"");
				}
			%>
			</SELECT>
			<br>
			<br>
		Select quantity:
			<br>
			<INPUT TYPE="number" name="quantity" value="1">
			<br>
			<br>
			
		<INPUT TYPE=submit value="Add" name="submitButton">
		<INPUT TYPE=submit value="Remove" name="submitButton">
		<INPUT TYPE=submit value="View" name="submitButton">
		
	</form>
	<br>
	<%
	}%>
</body>
</html>