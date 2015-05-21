package com.action;

import java.util.*;

import com.baseaction.BaseAction;
import com.busniess.BidBean;
import com.opensymphony.xwork2.ActionContext;




public class ViewBidAction extends BaseAction
{
	private List<BidBean> bids;

	public String execute()throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		Integer userId = (Integer)session.get("userId");
		setBids(mgr.getBidByUser(userId));
		return SUCCESS;
	}

	
	public void setBids(List<BidBean> bids)
	{
		this.bids = bids;
	}
	public List<BidBean> getBids()
	{
		 return this.bids;
	}
}