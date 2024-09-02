<%@page import="service.ProductService"%>
<%@page import="dto.ProductResponse"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<%!
private ProductService productService;

@Override
public void init() throws ServletException {
	// TODO Auto-generated method stub		
	System.out.println("init");
	
	this.productService = new ProductService(); 
}
%>


<%

try {
	List<ProductResponse> products = productService.getAllProducts();
	
	pageContext.getSession().setAttribute("products", products); 
	
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

%>
<body>
<div class="container">
  <div class="row">
    <c:forEach items="${products}" var="product">
      <div class="col-lg-3 col-md-6 col-sm-6 d-flex">
        <div class="card w-100 my-2 shadow-2-strong">
          <img src="https://st4.depositphotos.com/13324256/24475/i/450/depositphotos_244751462-stock-photo-top-view-product-lettering-made.jpg" class="card-img-top" style="aspect-ratio: 1 / 1" />
          <div class="card-body d-flex flex-column">
            <h5 class="card-title">${product.name}</h5>
            <p class="card-text">${product.skuCode}</p>
            <p class="card-text">${product.price}</p>
            <div class="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">
              <!-- Button trigger modal -->
              <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal${product.id}">
                Update
              </button>
              <a href="#!" class="btn btn-primary shadow-0 me-1" onclick="deleteProduct(${product.id})">Delete</a>

              <!-- Modal -->
              <div class="modal fade" id="exampleModal${product.id}" tabindex="-1" aria-labelledby="exampleModalLabel${product.id}" aria-hidden="true">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h1 class="modal-title fs-5" id="exampleModalLabel${product.id}">Update Product</h1>
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                      <!-- Form inputs for updating product -->
                      <div class="mb-3">
                        <label for="productName${product.id}" class="form-label">Name</label>
                        <input type="text" class="form-control" id="productName${product.id}" value="${product.name}">
                      </div>
                      <div class="mb-3">
                        <label for="productSkuCode${product.id}" class="form-label">SKU Code</label>
                        <input type="text" class="form-control" id="productSkuCode${product.id}" value="${product.skuCode}">
                      </div>
                      <div class="mb-3">
                        <label for="productPrice${product.id}" class="form-label">Price</label>
                        <input type="number" class="form-control" id="productPrice${product.id}" value="${product.price}">
                      </div>
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                      <button type="button" class="btn btn-primary" onclick="updateProduct(${product.id})">Save changes</button>
                    </div>
                  </div>
                </div>
              </div>

              <a href="#!" class="btn btn-light border icon-hover px-2 pt-2"><i class="fas fa-heart fa-lg text-secondary px-1"></i></a>
            </div>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>

</body>
<script>
function updateProduct(id) {
	
	console.log(id);
    // Wait for the modal to be fully shown
    
        // Retrieve the updated values from the input fields using the correct ID
        const productName = document.getElementById("productName"+id).value;
        const productSkuCode = document.getElementById("productSkuCode"+id).value;
        const productPrice = document.getElementById("productPrice"+id).value;

        console.log(id);
        console.log(productName);

        // Construct the query parameters for the update request
        const queryParams = new URLSearchParams({
            id: id,
            name: productName,
            skuCode: productSkuCode,
            price: parseFloat(productPrice)  // Ensure the price is a float
        }).toString();

        // Send the PUT request with query parameters
        fetch("/revshop-servlets/products/?" + queryParams, {
            method: 'PUT'
        })
        .then(response => {
            if (response.ok) {
                alert('Product updated successfully!');
                location.reload(); // Reload the page to see the updated product
            } else {
                alert('Failed to update product');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('An error occurred while updating the product');
        });

}

function deleteProduct(id) {
    
    if (!confirm('Are you sure you want to delete this product?')) {
        return; // If the user cancels the confirmation, don't proceed with deletion
    }
    
    console.log(`/revshop-servlets/products/?id=${id}`);

    // Send the DELETE request with the ID as a query parameter
    fetch("/revshop-servlets/products/?id="+id , {
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
            alert('Product deleted successfully!');
            location.reload();
            
        } else {
            alert('Failed to delete product');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('An error occurred while deleting the product');
    });
}


</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>