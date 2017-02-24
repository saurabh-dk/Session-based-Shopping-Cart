package Model;

import java.io.Serializable;

public class ProductBean implements Serializable {
	
	private int productId;
	private String productName;
	private String productDescription;
	private double productPrice;
	private String imageUrl;
	
	public void setId(int id){
		productId=id;
	}
	public int getId(){
		return productId;
	}
	public void setName(String name){
		productName=name;
	}
	public String getName(){
		return  productName;
	}
	public void setProductDescription(String desc){
		productDescription=desc;
	}
	public String getProductDescription(){
		return  productDescription;
	}
	public void setProductPrice(double price){
		 productPrice=price;
	 }
	 public double getProductPrice(){
		 return productPrice;
	 }
	 public void setImageUrl(String url){
		 imageUrl = url;
	 }
	 public String getImageUrl(){
		 return imageUrl;
	 }
}
