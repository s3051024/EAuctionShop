package com.action;

import java.util.*;

import com.baseaction.BaseAction;
import com.busniess.ItemBean;
import com.opensymphony.xwork2.ActionContext;




public class ViewFailAction extends BaseAction
{
	private List<ItemBean> failItems;

	public String execute()throws Exception
	{
		setFailItems(mgr.getFailItems());
		return SUCCESS;
	}


	public void setFailItems(List<ItemBean> failItems)
	{
		this.failItems = failItems;
	}
	public List<ItemBean> getFailItems()
	{
		 return this.failItems;
	}
}