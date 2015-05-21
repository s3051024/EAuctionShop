package com.daoimpl;

import java.util.*;

import com.basedao.BaseDaoHibernate;
import com.dao.AuctionUserDao;
import com.model.AuctionUser;




public class AuctionUserDaoHibernate
	extends BaseDaoHibernate<AuctionUser> implements AuctionUserDao
{

	
	public AuctionUser findUserByNameAndPass(String username , String pass)
	{
		
		List<AuctionUser> ul = (List<AuctionUser>)find(
			"from AuctionUser au where au.username=?0 and au.userpass=?1" ,
			username , pass);
		
		if (ul.size() == 1)
		{
			return (AuctionUser)ul.get(0);
		}
		return null;
	}
}