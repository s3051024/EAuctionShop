package com.dao;

import java.util.List;

import com.basedao.BaseDao;
import com.model.AuctionUser;
import com.model.Bid;



public interface BidDao extends BaseDao<Bid>
{
	
	List<Bid> findByUser(Integer userId);

	
	AuctionUser findUserByItemAndPrice(Integer itemId , Double price);
}
