<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,Model.ProductBean" import="Controller.ShoppingBasketContoller" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=request.getParameter("productName")%></title>
</head>
<body>
<center><h2><%=request.getParameter("productName")%></h2></center>
<form action="index.jsp" method=POST>
<input type=submit name="back" value="< Back">
<br>
<br>
</form>
<%
HashMap<Integer,ProductBean> productsHm=(HashMap<Integer,ProductBean>)getServletContext().getAttribute("products");
ProductBean pb = new ProductBean();
pb = productsHm.get(Integer.parseInt(request.getParameter("productId")));
out.print("<br><img src='"+pb.getImageUrl()+"'style='width:auto;max-height:350px;float:left'>");
out.print("<span style='padding:20px;'>Description : "
			+pb.getProductDescription()+
			"</span>");
out.print("<br><br>");
out.print("<span style='padding:20px;'>Price : "+pb.getProductPrice());
%>
<form action="ShoppingBasketContoller" method=POST>
<br>
<br>
<span style='padding:20px;'>Quantity : <input type='number' name='quantity' value='1'>
<% out.print("<input type=hidden name=items value='"+request.getParameter("productId")+"'>"); %>
<INPUT TYPE=submit value="Add" name="submitButton">
</span>
</form>

</body>
</html>