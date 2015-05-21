package com.action;

import java.util.*;

import com.baseaction.BaseAction;
import com.busniess.ItemBean;
import com.opensymphony.xwork2.ActionContext;





public class ViewSuAction extends BaseAction
{
	private List<ItemBean> items;

	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		Integer userId = (Integer)session.get("userId");
		setItems(mgr.getItemByWiner(userId));
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
}