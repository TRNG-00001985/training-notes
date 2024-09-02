<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<form action="products/" method="post">

<label for="name" >Name</label>
<input type="text" name="name" id="name">
<br>
<label for="skuCode" >skuCode</label>
<input type="text" name="skuCode" id="skuCode">
<br>
<label for="price" >Price</label>
<input type="number" name="price" id="price">

<button type="submit"> Save</button>
</form>

<script>
		
        function sendGetRequest(id) {
            const productId = document.getElementById('getProductId').value;
            fetch('products/' + productId)
            .then(data => {
                    document.getElementById('name').value = data.name || '';
                    document.getElementById('skuCode').value = data.skuCode || '';
                    document.getElementById('price').value = data.price || '';
                })
            .then(result => alert(result))
            .catch(error => console.error('Error:', error));
            
            document.queryParamater("")

        function sendPutRequest() {
            const productId = document.getElementById('putProductId').value;
            const data = document.getElementById('putData').value;
            fetch('products/' + productId, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: new URLSearchParams({ 'data': data })
            })
            .then(response => response.text())
            .then(result => alert(result))
            .catch(error => console.error('Error:', error));
        }

        function sendDeleteRequest() {
            const productId = document.getElementById('deleteProductId').value;
            fetch('products/' + productId, {
                method: 'DELETE'
            })
            .then(response => response.text())
            .then(result => alert(result))
            .catch(error => console.error('Error:', error));
        }
    </script>
</body>
</html>