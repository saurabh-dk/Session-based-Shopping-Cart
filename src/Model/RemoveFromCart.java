package Model;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveFromCart {

	
	public static String execute(HttpServletRequest request,HttpServletResponse response){
		
		 HashMap<Integer,PurchaseProductBean> existedProducts;

		 int selectedProductId=Integer.parseInt(request.getParameter("items"));//get selected product id
		 
		 String removedProductId=null;
		 
		 if(request.getSession().getAttribute("selected_products")!=null )//check product already exist
		 {
			 
			  existedProducts=(HashMap<Integer, PurchaseProductBean>) request.getSession().getAttribute("selected_products");
			  if(existedProducts.size()>0 && existedProducts.containsKey(selectedProductId)){
				  existedProducts.remove(selectedProductId);
				  request.getSession(false).setAttribute("selected_products", existedProducts);
				  request.setAttribute("productId", selectedProductId);
				  removedProductId=selectedProductId+"";
				  
			  }
			  
			//  request.setAttribute("Status", "1");
		 }
		  
		 return removedProductId;
		//return addProduct;
	}
	
}
