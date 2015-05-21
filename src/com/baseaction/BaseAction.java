package com.baseaction;

import com.opensymphony.xwork2.ActionSupport;
import com.service.AuctionManager;




public class BaseAction extends ActionSupport
{
	protected AuctionManager mgr;

	public void setMgr(AuctionManager mgr)
	{
		this.mgr = mgr;
	}
}