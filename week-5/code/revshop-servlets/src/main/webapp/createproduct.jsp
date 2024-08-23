<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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