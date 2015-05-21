package com.model;

import java.util.*;

import javax.persistence.*;


@Entity
@Table(name="bid")
public class Bid
{
	
	@Id
	@Column(name="bid_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="bid_price")
	private double bidPrice;

	@Column(name="bid_date")
	private Date bidDate;
	
	@ManyToOne(targetEntity=Item.class)
	@JoinColumn(name="item_id", nullable=false)
	private Item bidItem;

	@ManyToOne(targetEntity=AuctionUser.class)
	@JoinColumn(name="user_id", nullable=false)
	private AuctionUser bidUser;


	public Bid()
	{
	}
	
	public Bid(Integer id , double bidPrice , Date bidDate)
	{
		this.id = id;
		this.bidPrice = bidPrice;
		this.bidDate = bidDate;
	}

	
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	
	public void setBidPrice(double bidPrice)
	{
		this.bidPrice = bidPrice;
	}
	public double getBidPrice()
	{
		return this.bidPrice;
	}

	
	public void setBidDate(Date bidDate)
	{
		this.bidDate = bidDate;
	}
	public Date getBidDate()
	{
		return this.bidDate;
	}


	public void setBidItem(Item bidItem)
	{
		this.bidItem = bidItem;
	}
	public Item getBidItem()
	{
		return this.bidItem;
	}


	public void setBidUser(AuctionUser bidUser)
	{
		this.bidUser = bidUser;
	}
	public AuctionUser getBidUser()
	{
		return this.bidUser;
	}

	public int hashCode()
	{
		return bidUser.getUsername().hashCode()
			+ bidItem.hashCode() * 13 + (int)bidPrice * 19;
	}

	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj != null && obj.getClass() == Bid.class)
		{
			Bid bid = (Bid)obj;
			if (bid.getBidUser().getUsername().equals(bidUser.getUsername())
				&& bid.getBidItem().equals(this.getBidItem())
				&& bid.getBidPrice() == this.getBidPrice())
			{
				return true;
			}
		}
		return false;
	}
}