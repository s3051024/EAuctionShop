package com.model;

import java.util.*;

import javax.persistence.*;


@Entity
@Table(name="state")
public class State
{

	@Id
	@Column(name="state_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="state_name")
	private String stateName;

	@OneToMany(targetEntity=Item.class ,
		mappedBy="itemState")
	private Set<Item> items = new HashSet<Item>();


	public State()
	{
	}

	public State(Integer id , String stateName)
	{
		this.id = id;
		this.stateName = stateName;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}


	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}
	public String getStateName()
	{
		return this.stateName;
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