package Model;

import java.io.Serializable;
import java.util.*;

public class OrderBean implements Serializable {
	
	private int orderId;
	private String date;
	private double totalPrice;
	private HashMap<Integer, PurchaseProductBean> products;
	
	public void setOrderId(int orderId){
		this.orderId=orderId;
	}
	
	public int getOrderId(){
		return orderId;
	}
	
	public void setDate(String date){
		
		this.date=date;
		
	}
	
	public String getDate(){
		
		return date;
	}
	
	public void setTotalPrice(double totalPrice){
		this.totalPrice=totalPrice;
	}
	
	public double getTotalPrice(){
		
		return totalPrice;
	}

	public void setProducts(HashMap<Integer, PurchaseProductBean> products){
		this.products=products;
	}
	
	public HashMap<Integer, PurchaseProductBean> getProducts(){
		return products;
	}
}
