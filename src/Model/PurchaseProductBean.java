package Model;

import java.io.Serializable;

public class PurchaseProductBean implements Serializable {
	private int productId;
	private int productQuantity;
	private double totalPrice;
	 
	public void setProductId(int id)
	{
		productId=id;
	}
	public int getProductId()
	{
		return productId;
	}
	public void setQuantity(int quantity)
	{
		productQuantity=quantity;
	}
	public int getQuantity()
	{
		return productQuantity;
	}
	
	public void setTotalPrice(double price)
	{
		totalPrice=price;
	}
	public double getTotalPrice()
	{
		return totalPrice;
	}
  
}
