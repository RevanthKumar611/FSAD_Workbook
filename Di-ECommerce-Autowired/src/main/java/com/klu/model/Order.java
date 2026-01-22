package com.klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Order {

	private int orderId;
	private String customerName;
	private int quantity;
	@Autowired
	private Product product;
	
	public Order()
	{
		this.orderId=2006;
		this.customerName="Tarun";
		this.quantity=4;
		
	}
	public void display()
	{
		System.out.println("The following are the order details of customer:");
		System.out.println("orderID:"+orderId);
		System.out.println("CustomerName"+customerName);
		System.out.println("quantity:"+quantity);
		System.out.println("productId:"+product.getproductId());
		System.out.println("productName:"+product.getproductName());
		System.out.println("productPrice:"+product.getprice());
		System.out.println("productCategory:"+product.getcategory());
		}
}
