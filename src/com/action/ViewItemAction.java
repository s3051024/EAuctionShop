package com.action;

import java.util.*;

import com.baseaction.BaseAction;
import com.busniess.ItemBean;
import com.opensymphony.xwork2.ActionContext;




public class ViewItemAction extends BaseAction
{
	private int kindId;
	private String kind;
	private List<ItemBean> items;

	public String execute()throws Exception
	{
		if (kindId <= 0)
		{
			addActionError("您必须选择有效的种类");
			return ERROR;
		}
		else
		{
			setKind(mgr.getKind(kindId));
			setItems(mgr.getItemsByKind(kindId));
			return SUCCESS;
		}
	}


	public void setKindId(int kindId)
	{
		this.kindId = kindId;
	}
	public int getKindId()
	{
		 return this.kindId;
	}


	public void setKind(String kind)
	{
		this.kind = kind;
	}
	public String getKind()
	{
		 return this.kind;
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