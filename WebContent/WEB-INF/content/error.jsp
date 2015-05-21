
<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>出错提示页</title>
</head>
<body>
<table width="780" align="center" cellspacing="0"
	background="images/bodybg.jpg">
<tr> 
	<td height="39" valign="top">
		<div align="center" style="font-size:11pt;color:red;font-weight:bold">
			系统处理过程中发生了一个错误，信息如下：</div>
	</td>
</tr>
<tr>
	<td height="100">
		<center>
		<div class="error"><br /><br />
			<s:property value="errMsg"/>
		</div>
		</center>
	</td>
</tr>
<tr>
<td><div align="center" style="font:10pt">请您先核对输入，
	如果再次出现该错误，请登录<a href="http://www.crazyit.org">疯狂Java联盟</a>提交错误信息</div><br></td>
</tr>
</table>
</body>
</html>