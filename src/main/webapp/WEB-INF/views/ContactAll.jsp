<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact</title>

</head>
<body>
<h1>All Contact here..</h1><br>
<font color="green">${succmsg}</font><br>
<a href="/add">+AddContact</a>
<br>
<br>
<table border="1">
<tr>
<th>ID</th>
<th>NAME</th>
<th>NUMBER</th>
<th>EMAIL</th>
<th>ACTION</th>
</tr>
<c:forEach items="${list}" var="contact">
<tr>
<td>${contact.cid}</td>
<td>${contact.cname}</td>
<td>${contact.cnum}</td>
<td>${contact.email}</td>
<td>
<a href="/edit?cid=${contact.cid}">EDIT</a>
<a href="/delete?cid=${contact.cid}" onclick="return confirm('Are you sure you want to Remove?');">DELETE</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>