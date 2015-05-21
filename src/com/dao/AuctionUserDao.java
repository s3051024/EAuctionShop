package com.dao;

import java.util.List;

import com.basedao.BaseDao;
import com.model.AuctionUser;




public interface AuctionUserDao extends BaseDao<AuctionUser>
{
	
	AuctionUser findUserByNameAndPass(String username , String pass);
}