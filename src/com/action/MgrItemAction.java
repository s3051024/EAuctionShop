package com.action;

import java.util.*;

import com.baseaction.BaseActionInterface;
import com.busniess.ItemBean;
import com.busniess.KindBean;
import com.opensymphony.xwork2.*;




public class MgrItemAction extends BaseActionInterface
{
	private List<ItemBean> items;
	private List<KindBean> kinds;

	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		Integer userId = (Integer)session.get("userId");
		setItems(mgr.getItemsByOwner(userId));
		setKinds(mgr.getAllKind());
		return SUCCESS;
	}

	
	public void setItems(List<ItemBean> items)
	{
		this.items = items;
	}
	public List<ItemBean> getItems()
	{
		 return this.items;
	}

	
	public void setKinds(List<KindBean> kinds)
	{
		this.kinds = kinds;
	}
	public List<KindBean> getKinds()
	{
		 return this.kinds;
	}
}