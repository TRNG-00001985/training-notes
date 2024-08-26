<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href=”bootstrap/css/bootstrap.min.css” rel=”stylesheet” type=”text/css” />
<script type=”text/javascript” src=”bootstrap/js/bootstrap.min.js”></script>
</head>
<body>

<%
 int i = 10;
String name = "krishna";

pageContext.setAttribute("name", name, PageContext.REQUEST_SCOPE);
%>

<p>Hello ${name}</p>

<c:out value="hello world" />

<form action="products/", method="post">

<label for="name" >Name</label>
<input type="text" name="name">
<br>
<label for="skuCode" >skuCode</label>
<input type="text" name="skuCode">
<br>
<label for="price" >Price</label>
<input type="number" name="price">

<button type="submit"> Save</button>
</form>

</body>
</html>