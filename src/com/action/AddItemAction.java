package com.action;

import java.util.*;

import com.baseaction.BaseAction;
import com.model.Item;
import com.opensymphony.xwork2.ActionContext;




public class AddItemAction extends BaseAction
{
	private Item item;
	private int avail;
	private int kindId;
	private String vercode;
	
	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		String ver2 = (String)session.get("rand");
	
		session.put("rand" , null);
		Integer userId = (Integer)session.get("userId");
		
		if (vercode.equals(ver2))
		{
			
			switch(avail)
			{
				case 6 :
					avail = 7;
					break;
				case 7 :
					avail = 30;
					break;
				case 8 :
					avail = 365;
					break;
			}
		
			mgr.addItem(item ,avail , kindId, userId);
			return SUCCESS;
		}
		else
		{
			addActionError("验证码不匹配,请重新输入");
			return INPUT;
		}
	}


	public void setItem(Item item)
	{
		this.item = item;
	}
	public Item getItem()
	{
		return this.item;
	}

	
	public void setAvail(int avail)
	{
		this.avail = avail;
	}
	public int getAvail()
	{
		return this.avail;
	}

	
	public void setKindId(int kindId)
	{
		this.kindId = kindId;
	}
	public int getKindId()
	{
		return this.kindId;
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