package com.model;

import java.util.*;

import javax.persistence.*;


@Entity
@Table(name="auction_user")
public class AuctionUser
{
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String username;

	private String userpass;
	
	private String email;


	@OneToMany(targetEntity=Item.class ,
		mappedBy="owner")
	private Set<Item> itemsByOwner = new HashSet<Item>();

	@OneToMany(targetEntity=Item.class ,
		mappedBy="winer")
	private Set<Item> itemsByWiner = new HashSet<Item>();

	@OneToMany(targetEntity=Bid.class ,
		mappedBy="bidUser")
	private Set<Bid> bids = new HashSet<Bid>();

	
	public AuctionUser()
	{
	}
	
	public AuctionUser(Integer id , String username
		, String userpass , String email)
	{
		this.id = id;
		this.username = username;
		this.userpass = userpass;
		this.email = email;
	}

	// id��setter��getter����
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// username��setter��getter����
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUsername()
	{
		return this.username;
	}

	// userpass��setter��getter����
	public void setUserpass(String userpass)
	{
		this.userpass = userpass;
	}
	public String getUserpass()
	{
		return this.userpass;
	}

	// email��setter��getter����
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return this.email;
	}

	// itemsByOwner��setter��getter����
	public void setItemsByOwner(Set<Item> itemsByOwner)
	{
		this.itemsByOwner = itemsByOwner;
	}
	public Set<Item> getItemsByOwner()
	{
		return this.itemsByOwner;
	}

	// itemsByWiner��setter��getter����
	public void setItemsByWiner(Set<Item> itemsByWiner)
	{
		this.itemsByWiner = itemsByWiner;
	}
	public Set<Item> getItemsByWiner()
	{
		return this.itemsByWiner;
	}

	// bids��setter��getter����
	public void setBids(Set<Bid> bids)
	{
		this.bids = bids;
	}
	public Set<Bid> getBids()
	{
		return this.bids;
	}
}