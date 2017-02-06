package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConfirmedOrder {
	
	private static HashMap<Integer,PurchaseProductBean> addedProducts;
	
	public static int execute(HttpServletRequest request,HttpServletResponse response){
		
		addedProducts=(HashMap<Integer, PurchaseProductBean>) request.getSession().getAttribute("selected_products");
		
		
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    
		 sdf.setTimeZone(TimeZone.getTimeZone("GMT+05:30"));
		 Calendar cal= Calendar.getInstance();
		    	
		 String time=sdf.format(cal.getTime());//get current datetime
			 	
		 OrderBean ob=new OrderBean();
		 ob.setDate(time);
		 
		
		 double price=0.0;
		 double finalPrice=0.0;
		 PurchaseProductBean ppb=null;
		 for(Map.Entry<Integer, PurchaseProductBean> m:addedProducts.entrySet()){
			 
			 ppb=m.getValue();
			 price=ppb.getTotalPrice();
			 finalPrice+=price;
			 price=0.0;
		 }
		 
		 ob.setTotalPrice(finalPrice);
		 
		 ob.setProducts(addedProducts);
		 
		 
		 ShoppingBasketDBInteractions sbdbi=new ShoppingBasketDBInteractions();
			
		int orderCheck=sbdbi.generateOrder(ob);
		int purchasedProductCheck=0;
		 if(orderCheck==1){
			 if(sbdbi.getOrderId(ob))
			 {
			 purchasedProductCheck= sbdbi.insertPurchasedProducts(ob);
			 
			 }
		 }
		 
		 return purchasedProductCheck;
			
	}
	
}
