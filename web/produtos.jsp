<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>
<head>
</head>
<body>
  	<html:form action="/login">
  	  	<table width="80%" border="0">
  	  	  	<tr>
  	  	  	  	<td>Name:</td>
  	  	  	  	<td><html:text property="name" /></td>
  	  	  	</tr>
  	  	  	<tr>
  	  	  	  	<td><html:submit /></td>
  	  	  	</tr>
  	  	</table>
  	</html:form>
</body>
</html> 
