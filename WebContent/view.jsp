<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Shopping Cart</title>
</head>
<body>
<%@ page import="java.io.*,java.util.*,Model.PurchaseProductBean,Model.ProductBean"%>
	
	
<%
	HashMap<Integer,ProductBean> productDetails;
	HashMap<Integer,PurchaseProductBean> addedProducts;
	ProductBean pb;
	PurchaseProductBean ppb;
	String productName;
	int productQuantity;
	double unitPrice;
	double totalPrice;
	
	if(session.getAttribute("selected_products")!=null){
		
		
		
		addedProducts=(HashMap<Integer,PurchaseProductBean>)session.getAttribute("selected_products");
		
		if(addedProducts.size()>0)
		{
		productDetails=(HashMap<Integer,ProductBean>)application.getAttribute("products");
		out.print("You have selected the following product(s) <br/>");
		out.print("<table>");
		out.print("<tr><th>Product Name</th><th>Quantity</th><th>Unit Price</th><th>Total Price</th><th>Remove?</th></tr>");
		for(Map.Entry<Integer,PurchaseProductBean> m : addedProducts.entrySet()){
			out.print("<tr>");
			pb=productDetails.get(m.getKey());
			productName=pb.getName();
			ppb=m.getValue();
			productQuantity=ppb.getQuantity();
			
			unitPrice=pb.getProductPrice();
			totalPrice= productQuantity * unitPrice;
			ppb.setTotalPrice(totalPrice);
			
			out.print("<td>"+productName+"</td>");
			out.print("<td>"+productQuantity+"</td>");
			out.print("<td>"+unitPrice+"</td>");
			out.print("<td>"+totalPrice+"</td>");
			out.print("<td><form action='ShoppingBasketContoller' method=POST><input type='hidden' name='items' value='"
						+m.getKey()+"'><input type=submit value='Remove' name='submitButton'></form></td>");
			out.print("</tr>");
		}
		
		out.print("</table>");
		out.print("<br/><br/><form action='ShoppingBasketContoller' method='POST'><input type='submit'value='Checkout'  /></form>");
		}//end of inner if
		else out.print("Sorry no products found in cart");
	}
	else{
		out.print("Sorry no products found in cart");	
	}

%>
<br/><form action='index.jsp' method='POST'><input type='submit'value='Back to shopping'  /></form>

</body>
</html>