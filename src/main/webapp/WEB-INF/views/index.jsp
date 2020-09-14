<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>contact</title>

</head>
<body>
<h1>Welcome to Contact Application</h1>
<i>Fill the contact details. Asterisk (*) is required.</i><br>
<font color="green">${succmsg}</font>
<font color="red">${errmsg}</font>
<pre>
<form:form action="save" method="post" modelAttribute="contactDTO">
ContactName(*)  :<form:input path="cname"/>
                 <form:hidden path="cid"/>
ContactNumber(*):<form:input  path="cnum"/>
               
ContactMail     :<form:input  path="email"/>
              <input type="submit" value="Save Contact">
</form:form>
</pre>

<br>
<a href="/all">Display All Contact</a>
</body>
</html>