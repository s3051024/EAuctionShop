

<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>浏览赢取的全部物品</title>
</head>
<body>
<table width="780" align="center" cellspacing="0"
	background="images/bodybg.jpg">
<tr>
<td>
<br />
<table width="80%" align="center" cellpadding="0"
	cellspacing="1" style="border:1px solid black">
<tr>
<td colspan="4" ><div class="mytitle">您所赢取的物品：</div></td> 
</tr>
<tr  height="30">
<th>物品名</th>
<th>物品种类</th>
<th>赢取价格</th>
<th>物品备注</th>
</tr>
<s:iterator value="items" id="item" status="st">
<tr  height="24" <s:if test="#st.odd">
	style="background-color:#dddddd"</s:if>
<s:else>style="background-color:#eeeeee"</s:else>>
<td><s:property value="name"/></td>
<td><s:property value="kind"/></td>
<td><s:property value="maxPrice"/></td>
<td><s:property value="remark"/></td>
</tr>
</s:iterator>
</table>
</td>
</tr>
</table>
</body>
</html>