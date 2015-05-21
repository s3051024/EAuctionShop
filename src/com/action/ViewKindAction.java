package com.action;

import java.util.*;

import com.baseaction.BaseAction;
import com.busniess.KindBean;
import com.opensymphony.xwork2.ActionContext;



public class ViewKindAction extends BaseAction
{
	private List<KindBean> kinds;
	private String errMsg;

	public String execute()throws Exception
	{
		setKinds(mgr.getAllKind());
		return SUCCESS;
	}

	
	public void setKinds(List<KindBean> kinds)
	{
		this.kinds = kinds;
	}
	public List<KindBean> getKinds()
	{
		 return this.kinds;
	}

	
	public void setErrMsg(String errMsg)
	{
		this.errMsg = errMsg;
	}
	public String getErrMsg()
	{
		 return this.errMsg;
	}
}