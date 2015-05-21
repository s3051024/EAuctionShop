package com.schedule;

import java.util.TimerTask;

import com.exception.AuctionException;
import com.service.AuctionManager;



public class CheckWiner extends TimerTask
{
	
	private AuctionManager mgr;
	
	public void setMgr(AuctionManager mgr)
	{
		this.mgr = mgr;
	}

	public void run()
	{
		try
		{
			mgr.updateWiner();
		}
		catch (AuctionException ae)
		{
			ae.printStackTrace();
		}
	}
}
