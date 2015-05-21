package com.model;

import java.util.*;

import javax.persistence.*;


@Entity
@Table(name="kind")
public class Kind
{

	@Id
	@Column(name="kind_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="kind_name")
	private String kindName;
	
	@Column(name="kind_desc")
	private String kindDesc;

	@OneToMany(targetEntity=Item.class ,
		mappedBy="kind")
	private Set<Item> items = new HashSet<Item>();


	public Kind()
	{
	}

	public Kind(Integer id , String kindName , String kindDesc)
	{
		this.id = id;
		this.kindName = kindName;
		this.kindDesc = kindDesc;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}


	public void setKindName(String kindName)
	{
		this.kindName = kindName;
	}
	public String getKindName()
	{
		return this.kindName;
	}


	public void setKindDesc(String kindDesc)
	{
		this.kindDesc = kindDesc;
	}
	public String getKindDesc()
	{
		return this.kindDesc;
	}

	public void setItems(Set<Item> items)
	{
		this.items = items;
	}
	public Set<Item> getItems()
	{
		return this.items;
	}
}