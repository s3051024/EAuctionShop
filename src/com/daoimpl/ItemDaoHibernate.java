package com.daoimpl;

import java.util.*;

import com.basedao.BaseDaoHibernate;
import com.dao.ItemDao;
import com.model.*;



public class ItemDaoHibernate
	extends BaseDaoHibernate<Item> implements ItemDao
{
	
	public List<Item> findItemByKind(Integer kindId)
	{
		return find(
			"from Item as i where i.kind.id=?0 and i.itemState.id=1"
			, kindId);
	}

	
	public List<Item> findItemByOwner(Integer userId)
	{
		return (List<Item>)find(
			"from Item as i where i.owner.id=?0 and i.itemState.id=1"
			, userId);
	}

		public List<Item> findItemByWiner(Integer userId)
	{
		return find("from Item as i where i.winer.id =?0 and i.itemState.id=2"
			,userId);
	}

	
	public List<Item> findItemByState(Integer stateId)
	{
		return find("from Item as i where i.itemState.id = ?0" , stateId);
	}
}