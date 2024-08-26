<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String name = "sample";
%>

<jsp:useBean id="product" scope="page" class="entity.Product"></jsp:useBean>
<jsp:setProperty name="product" property="name" value="Phone" />

<b>Name:</b> <jsp:getProperty name="product" property="name" />
</body>
</html>