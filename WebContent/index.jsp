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

		<br>
		Available products:
		<br>
		<center>
		<form action="ShoppingBasketContoller" method=POST>
		<input align="right" type=submit value='View' name=submitButton>
		</form>
		</center>
			<% 
			HashMap<Integer,ProductBean> productsHm=(HashMap<Integer,ProductBean>)getServletContext().getAttribute("products");
			out.print("<table>");
			for(Map.Entry<Integer,ProductBean> m:productsHm.entrySet()){
				int key = m.getKey();
				ProductBean pb = m.getValue();
				%>
				<form method=POST action="productInfo.jsp">
				<%
				out.print("<tr><td><br><img src='"+pb.getImageUrl()+
							"'style='width:auto;max-height:128px;padding:5px;align=center;'></td><td><br><hr width='1' size='128'></td><td>"
							+pb.getName()+"<input type='hidden' name='productId' value='"
							+pb.getId()+"'><input type='hidden' name='productName' value='"
							+pb.getName()+"'><br><br><input type='submit' value='View' name='view'></td></tr>");
				%>
				</form>
				<%
			}
			out.print("</table>");
	}%>
</body>
</html>