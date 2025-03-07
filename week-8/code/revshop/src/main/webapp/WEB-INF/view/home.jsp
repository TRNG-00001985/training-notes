<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ page errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>


<%-- <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="messages"/> --%>
<!DOCTYPE html>
<html lang="${language}">
<head>
<meta charset="UTF-8">
<title>Login page</title>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script type="text/javascript">

</script>

</head>
<body>



<%

String title ="ecom";

request.setAttribute("email", "demo@gmail.com");


%>

<%= pageContext.getRequest().getAttribute("email")%>


<%

pageContext.setAttribute("name", "Krishna", PageContext.SESSION_SCOPE);



%>

<c:out value="Welcome ${name}"></c:out>

<br>

<%= pageContext.getSession().getAttribute("name")%>

<br>

<%=title %>

<%
    String selectedLanguage = request.getParameter("language");
    if (selectedLanguage != null && !selectedLanguage.isEmpty()) {
        session.setAttribute("language", selectedLanguage);
    } else if (session.getAttribute("language") == null) {
        session.setAttribute("language", request.getLocale().getLanguage());
    }
%>

<form method="get">
    <select name="language" onchange="this.form.submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        <option value="de" ${language == 'de' ? 'selected' : ''}>German</option>
        <option value="fr" ${language == 'fr' ? 'selected' : ''}>French</option>
        
        <!-- Add more languages as needed -->
    </select>
</form>


<div class=container>

<form class="row g-3" action="user/" method="post">
  <%-- <div class="col-md-6">
    <label for="email" class="form-label" ><fmt:message key="login.label.email"/></label>
    <input type="email" class="form-control" id="inputEmail4" name="email">
  </div>
  <div class="col-md-6">
    <label for="inputPassword4" class="form-label"><fmt:message key="login.label.password"/></label>
    <input type="password" class="form-control" id="inputPassword4">
  </div> --%>
  <div class="col-12">
    <label for="inputAddress" class="form-label">Address</label>
    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
  </div>
  <div class="col-12">
    <label for="inputAddress2" class="form-label">Address 2</label>
    <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
  </div>
  <div class="col-md-6">
    <label for="inputCity" class="form-label">City</label>
    <input type="text" class="form-control" id="inputCity">
  </div>
  <div class="col-md-4">
    <label for="inputState" class="form-label">State</label>
    <select id="inputState" class="form-select">
      <option selected>Choose...</option>
      <option>...</option>
    </select>
  </div>
  <div class="col-md-2">
    <label for="inputZip" class="form-label">Zip</label>
    <input type="text" class="form-control" id="inputZip">
  </div>
  <div class="col-12">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" id="gridCheck">
      <label class="form-check-label" for="gridCheck">
        Check me out
      </label>
    </div>
  </div>
  <%-- <div class="col-12">
    <button type="submit" class="btn btn-primary"><fmt:message key="login.button.submit"/></button>
  </div> --%>
</form>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>