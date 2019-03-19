<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags" prefix="springcore" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>vendor Login</title>
</head>
<body>
<div style="margin-top:200PX; margin-left:400PX;">
<springform:form modelAttribute="vendor" method="post" action="loginvendor.htm">
<table>
<tr>
<td><springform:label path="vendorId">vendor Id:</springform:label>
<td><springform:input path="vendorId"/>
</td>
</tr>
<tr>
<td><springform:label path="vendorPassword">vendor password:</springform:label>
<td><springform:password path="vendorPassword"/></td>
</tr>
<tr>
<td><input type="submit" value="login"></td>
</tr>
</table>
</springform:form>

</body>
</html>