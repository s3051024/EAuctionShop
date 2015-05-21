package com.busniess;

import java.io.Serializable;
import java.util.Date;


public class BidBean implements Serializable
{
	private int id;
	private String user;
	private String item;
	private double price;
	private Date bidDate;


	
	public BidBean()
	{
	}
	
	public BidBean(int id , String user , String item ,
		double price , Date bidDate)
	{
		this.id = id;
		this.user = user;
		this.item = item;
		this.price = price;
		this.bidDate = bidDate;
	}

	
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return this.id;
	}

	
	public void setUser(String user)
	{
		this.user = user;
	}
	public String getUser()
	{
		return this.user;
	}

	
	public void setItem(String item)
	{
		this.item = item;
	}
	public String getItem()
	{
		return this.item;
	}

	
	public void setPrice(double price)
	{
		this.price = price;
	}
	public double getPrice()
	{
		return this.price;
	}

	
	public void setBidDate(Date bidDate)
	{
		this.bidDate = bidDate;
	}
	public Date getBidDate()
	{
		return this.bidDate;
	}
}