package com.dao;

import java.util.List;
import com.basedao.BaseDao;
import com.model.Item;




public interface ItemDao extends BaseDao<Item>
{
	
	List<Item> findItemByKind(Integer kindId);

	
	List<Item> findItemByOwner(Integer userId);

	
	List<Item> findItemByWiner(Integer userId);

	
	List<Item> findItemByState(Integer stateId);
}