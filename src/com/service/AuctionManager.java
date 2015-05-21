package com.service;

import java.util.List;

import com.model.*;
import com.exception.AuctionException;
import com.model.Bid;
import com.busniess.*;



public interface AuctionManager
{
	
	List<ItemBean> getItemByWiner(Integer winerId)
		throws AuctionException;

	
	List<ItemBean> getFailItems()throws AuctionException;

	
	int validLogin(String username , String pass)
		throws AuctionException;


	List<BidBean> getBidByUser(Integer userId)
		throws AuctionException;

	
	List<ItemBean> getItemsByOwner(Integer userId)
		throws AuctionException;


	List<KindBean> getAllKind() throws AuctionException;

	int addItem(Item item, int avail , int kindId , Integer userId)
		throws AuctionException;

	int addKind(Kind kind) throws AuctionException;

	
	List<ItemBean> getItemsByKind(int kindId) throws AuctionException;

	
	String getKind(int kindId) throws AuctionException;

	
	ItemBean getItem(int itemId) throws AuctionException;

	
	int addBid(int itemId , Bid bid ,Integer userId)
		throws AuctionException;

	
	void updateWiner()throws AuctionException;
}