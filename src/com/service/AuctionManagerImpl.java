package com.service;

import org.apache.log4j.Logger;
import com.busniess.*;
import java.util.*;
import com.dao.*;
import com.model.*;
import com.daoimpl.*;
import com.exception.*;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.dao.AuctionUserDao;


public class AuctionManagerImpl implements AuctionManager
{
	static Logger log = Logger.getLogger(
		AuctionManagerImpl.class.getName());
	
	private AuctionUserDao userDao;
	private BidDao bidDao;
	private ItemDao itemDao;
	private KindDao kindDao;
	private StateDao stateDao;
	
	private MailSender mailSender;
	private SimpleMailMessage message;
	
	public void setUserDao(AuctionUserDao userDao)
	{
		this.userDao = userDao;
	}
	public void setBidDao(BidDao bidDao)
	{
		this.bidDao = bidDao;
	}
	public void setItemDao(ItemDao itemDao)
	{
		this.itemDao = itemDao;
	}
	public void setKindDao(KindDao kindDao)
	{
		this.kindDao = kindDao;
	}
	public void setStateDao(StateDao stateDao)
	{
		this.stateDao = stateDao;
	}
	
	public void setMailSender(MailSender mailSender)
	{
		this.mailSender = mailSender;
	}
	public void setMessage(SimpleMailMessage message)
	{
		this.message = message;
	}

	
	public List<ItemBean> getItemByWiner(Integer winerId) throws AuctionException
	{
		try
		{
			List<Item> items = itemDao.findItemByWiner(winerId);
			List<ItemBean> result = new ArrayList<>();
			for (Iterator<Item> it = items.iterator() ; it.hasNext() ; )
			{
				ItemBean ib = new ItemBean();
				initItem(ib , it.next());
				result.add(ib);
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("查询用户所赢取的物品出现异常,请重试");
		}
	}

	
	public List<ItemBean> getFailItems() throws AuctionException
	{
		try
		{
			List<Item> items = itemDao.findItemByState(3);
			List<ItemBean> result = new ArrayList<>();
			for (Iterator<Item> it = items.iterator() ; it.hasNext() ; )
			{
				ItemBean ib = new ItemBean();
				initItem(ib , it.next());
				result.add(ib);
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("查询流拍物品出现异常,请重试");
		}
	}

	
	public int validLogin(String username , String pass) throws AuctionException
	{
		try
		{
			AuctionUser u = userDao.findUserByNameAndPass(username , pass);
			if (u != null)
			{
				return u.getId();
			}
			return -1;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("处理用户登录出现异常,请重试");
		}
	}


	public List<BidBean> getBidByUser(Integer userId) throws AuctionException
	{
		try
		{
			List<Bid> l = bidDao.findByUser(userId);
			List<BidBean> result = new ArrayList<>();
			for ( int i = 0 ; i < l.size() ; i++ )
			{
				Bid bid = l.get(i);
				BidBean bb = new BidBean();
				initBid(bb, bid);
				result.add(bb);
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("浏览用户的全部竞价出现异常,请重试");
		}
	}

	
	public List<ItemBean> getItemsByOwner(Integer userId) throws AuctionException
	{
		try
		{
			List<ItemBean> result = new ArrayList<>();
			List<Item> items = itemDao.findItemByOwner(userId);
			for (Iterator<Item> it = items.iterator() ; it.hasNext() ; )
			{
				ItemBean ib = new ItemBean();
				initItem( ib ,it.next());
				result.add(ib);
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("查询用户所有的物品出现异常,请重新");
		}
	}


	public List<KindBean> getAllKind() throws AuctionException
	{
		List<KindBean> result = new ArrayList<>();
		try
		{
			List<Kind> kl = kindDao.findAll(Kind.class);
			for (Kind k : kl )
			{
				result.add(new KindBean(k.getId(),
					k.getKindName(), k.getKindDesc()));
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("查询全部种类出现异常,请重试");
		}
	}

	
	public int addItem(Item item , int avail , int kind , Integer userId)
		throws AuctionException
	{
		try
		{
			Kind k = kindDao.get(Kind.class , kind);
			AuctionUser owner = userDao.get(AuctionUser.class , userId);
			
			item.setAddtime(new Date());
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE , avail);
			item.setEndtime(c.getTime());
			item.setMaxPrice(item.getInitPrice());
			item.setItemState(stateDao.get(State.class , 1));
			item.setKind(k);
			item.setOwner(owner);
			
			itemDao.save(item);
			return item.getId();
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("添加物品出现异常,请重试");
		}
	}

	
	public int addKind(Kind kind)
		throws AuctionException
	{
		try
		{
			kindDao.save(kind);
			return kind.getId();
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("添加种类出现异常,请重试");
		}
	}

	
	public List<ItemBean> getItemsByKind(int kindId) throws AuctionException
	{
		List<ItemBean> result = new ArrayList<>();
		try
		{
			List<Item> items = itemDao.findItemByKind(kindId);
			for (Iterator<Item> it = items.iterator() ; it.hasNext() ; )
			{
				ItemBean ib = new ItemBean();
				initItem(ib , it.next());
				result.add(ib);
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("根据种类获取物品出现异常,请重试");
		}
	}


	public String getKind(int kindId) throws AuctionException
	{
		try
		{
			Kind  k = kindDao.get(Kind.class , kindId);
			if (k != null)
			{
				return k.getKindName();
			}
			return null;
		}
		catch (Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("根据种类id获取种类名称出现异常,请重试");
		}
	}

	
	public ItemBean getItem(int itemId)
		throws AuctionException
	{
		try
		{
			Item item = itemDao.get(Item.class , itemId);
			ItemBean ib = new ItemBean();
			initItem(ib , item);
			return ib;
		}
		catch (Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("根据物品id获取物品详细信息出现异常,请重试");
		}
	}


	public int addBid(int itemId , Bid bid , Integer userId)
		throws AuctionException
	{
		try
		{
			AuctionUser au = userDao.get(AuctionUser.class , userId);
			Item item = itemDao.get(Item.class , itemId);
			if (bid.getBidPrice() > item.getMaxPrice())
			{
				item.setMaxPrice(bid.getBidPrice());
				itemDao.save(item);
			}
			
			bid.setBidItem(item);
			bid.setBidUser(au);
			bid.setBidDate(new Date());
			
			bidDao.save(bid);
	
			SimpleMailMessage msg = new SimpleMailMessage(this.message);
			msg.setTo(au.getEmail());
			msg.setText("Dear "
				+ au.getUsername()
				+ ", 谢谢你参与竞价，你的竞价的物品的是: "
				+ item.getItemName());
			mailSender.send(msg);
			return bid.getId();
		}
		catch(Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("处理用户竞价出现异常,请重试");
		}
	}


	public void updateWiner()throws AuctionException
	{
		try
		{
			List itemList = itemDao.findItemByState(1);
			for (int i = 0 ; i < itemList.size() ; i++ )
			{
				Item item = (Item)itemList.get(i);
				if (!item.getEndtime().after(new Date()))
				{
					
					AuctionUser au = bidDao.findUserByItemAndPrice(
						item.getId() , item.getMaxPrice());
					
					if (au != null)
					{
						
						item.setWiner(au);
						
						item.setItemState(stateDao.get(State.class , 2));
						itemDao.save(item);
					}
					else
					{
						
						item.setItemState(stateDao.get(State.class , 3));
						itemDao.save(item);
					}
				}
			}
		}
		catch (Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("根据时间来修改物品的状态、赢取者出现异常,请重试");
		}
	}


	private void initBid(BidBean bb , Bid bid)
	{
		bb.setId(bid.getId().intValue());
		if (bid.getBidUser() != null )
			bb.setUser(bid.getBidUser().getUsername());
		if (bid.getBidItem() != null )
			bb.setItem(bid.getBidItem().getItemName());
		bb.setPrice(bid.getBidPrice());
		bb.setBidDate(bid.getBidDate());
	}

	
	private void initItem(ItemBean ib , Item item)
	{
		ib.setId(item.getId());
		ib.setName(item.getItemName());
		ib.setDesc(item.getItemDesc());
		ib.setRemark(item.getItemRemark());
		if (item.getKind() != null)
			ib.setKind(item.getKind().getKindName());
		if (item.getOwner() != null)
			ib.setOwner(item.getOwner().getUsername());
		if (item.getWiner() != null)
			ib.setWiner(item.getWiner().getUsername());
		ib.setAddTime(item.getAddtime());
		ib.setEndTime(item.getEndtime());
		if (item.getItemState() != null)
			ib.setState(item.getItemState().getStateName());
		ib.setInitPrice(item.getInitPrice());
		ib.setMaxPrice(item.getMaxPrice());
	}
}