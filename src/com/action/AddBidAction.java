package com.action;

import java.util.*;

import com.baseaction.BaseAction;
import com.model.Bid;
import com.opensymphony.xwork2.ActionContext;



public class AddBidAction extends BaseAction
{
	
	private int itemId;
	private Bid bid;
	private double maxPrice;
	private String vercode;
	
	@Override
	public void validate()
	{
		
		if(bid.getBidPrice() <= maxPrice)
		{
			addFieldError("bid.bidPrice", "您输入的竞价必须高于当前最高价！");
		}
	}
	
	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		
		Integer userId = (Integer)session.get("userId");
		String ver2 = (String)session.get("rand");
		session.put("rand" , null);
		
		if (vercode.equals(ver2))
		{
			mgr.addBid(itemId , bid ,userId);
			return SUCCESS;
		}
		else
		{
			addActionError("验证码不匹配,请重新输入");
			return INPUT;
		}
	}

	
	public void setItemId(int itemId)
	{
		this.itemId = itemId;
	}
	public int getItemId()
	{
		return this.itemId;
	}


	public void setBid(Bid bid)
	{
		this.bid = bid;
	}
	public Bid getBid()
	{
		return this.bid;
	}

	
	public void setMaxPrice(double maxPrice)
	{
		this.maxPrice = maxPrice;
	}
	public double getMaxPrice()
	{
		return this.maxPrice;
	}

	
	public void setVercode(String vercode)
	{
		this.vercode = vercode;
	}
	public String getVercode()
	{
		return this.vercode;
	}
}