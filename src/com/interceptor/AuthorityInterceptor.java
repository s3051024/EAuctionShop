package com.interceptor;

import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.*;
import java.util.Map;


public class AuthorityInterceptor extends AbstractInterceptor
{
	
	public String intercept(ActionInvocation invocation)
		throws Exception
	{
		
		Map session = ActionContext.getContext().getSession();
		Object userId = session.get("userId");
		
		if (userId == null)
		{
			return "login";
		}
		
		else
		{
			return invocation.invoke();
		}
	}
}