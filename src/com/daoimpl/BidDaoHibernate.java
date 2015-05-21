package com.daoimpl;

import java.util.*;

import com.basedao.BaseDaoHibernate;
import com.dao.BidDao;
import com.model.*;


public class BidDaoHibernate
	extends BaseDaoHibernate<Bid> implements BidDao
{
	
	public List<Bid> findByUser(Integer userId)
	{
		return (List<Bid>)find(
			"from Bid as bid where bid.bidUser.id=?0" , userId);
	}
	
	public AuctionUser findUserByItemAndPrice(Integer itemId , Double price)
	{
		
		List<Bid> l = (List<Bid>)find(
			"from Bid as bid where bid.bidItem.id=?0 and bid.bidPrice=?1"
			, new Object[]{itemId , price});
		
		if (l.size() >= 1)
		{
			Bid b = (Bid)l.get(0);
			return b.getBidUser();
		}
		return null;
	}
}
