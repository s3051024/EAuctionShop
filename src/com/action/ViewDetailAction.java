package com.action;

import java.util.*;

import com.baseaction.BaseActionInterface;
import com.busniess.ItemBean;
import com.opensymphony.xwork2.*;




public class ViewDetailAction extends BaseActionInterface
{
	
	private int itemId;
	private ItemBean item;

	private String errMsg;

	public String execute()throws Exception
	{
		if (itemId <= 0)
		{
			setErrMsg("您选择物品ID不是一个有效的物品ID！");
			return ERROR;
		}
		else
		{
			setItem(mgr.getItem(itemId));
			return SUCCESS;
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


	public void setItem(ItemBean item)
	{
		this.item = item;
	}
	public ItemBean getItem()
	{
		 return this.item;
	}

	
	public void setErrMsg(String errMsg)
	{
		this.errMsg = errMsg;
	}
	public String getErrMsg()
	{
		 return this.errMsg;
	}
}