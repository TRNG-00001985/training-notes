<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<jsp:include page="products.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<br>
<%

String name = "John doe";


String[] users = {"john", "jane"};


%>

<% pageContext.getSession().setAttribute("isLoggedIn",true); %>
<% pageContext.getSession().setAttribute("role","admin"); %>

<% pageContext.getSession().setAttribute("users", users); %>



    <c:choose>
        <c:when test="${role == 'buyer'}">
            Buyer Dashboard
        </c:when>
         <c:when test="${role == 'admin'}">
            Admin Dashboard
        </c:when>
        <c:otherwise>
            Seller Dashboard
        </c:otherwise>
    </c:choose>




<c:if  test="${isLoggedIn}">

Welcome ${user}

</c:if>

<div class="d-flex bd-highlight">

<c:forEach items="${users}" var="user">



  <div class="p-2 bd-highlight">
  
  <p>${user}</p>
  
  
  </div>



</c:forEach>
</div>



<c:set var="name" value="John Doe" scope="session"></c:set>


<c:out value="${name}"></c:out>

<!-- <wl:form name="FirstForm" method="POST" action="thisJSP.jsp">

<wl:validator 
 errorMessage="Field_1 is required" expression=""
 fieldToValidate="field_1"   
 validatorClass=
  "weblogicx.jsp.tags.validators.RequiredFieldValidator" 
>
  <img src="images/warning.gif">
  <font color=red>Field 1 is a required field</font>
</wl:validator>
<p> <input type="text" name = "field_1">  </p>
<p> <input type="text" name = "field_2">  </p>
<p> <input type="submit" value="Submit FirstForm">  </p>
</wl:form>


-->






<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>