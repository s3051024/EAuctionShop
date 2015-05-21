package com.action;

import java.util.*;

import com.baseaction.BaseAction;
import com.model.Kind;
import com.opensymphony.xwork2.ActionContext;




public class AddKindAction extends BaseAction
{
	private Kind kind;
	private String vercode;

	public String execute()throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		String ver2 = (String)session.get("rand");
		session.put("rand" , null);
		if (vercode.equals(ver2))
		{
			mgr.addKind(kind);
			return SUCCESS;
		}
		else
		{
			addActionError("验证码不匹配,请重新输入");
			return INPUT;
		}
	}

	
	public void setKind(Kind kind)
	{
		this.kind = kind;
	}
	public Kind getKind()
	{
		return this.kind;
	}


	public void setVercode(String vercode)
	{
		this.vercode = vercode;
	}
	public String getVercode()
	{
		return this.vercode;
	}
}