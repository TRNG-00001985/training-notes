# Lecture/Guided Coding Example

1. JSP Introduction revision
2. JSP

---

### JSP Lifecycle
- **Request Processing:** JSPs are compiled into servlets and processed by the servlet engine.
  1. **Translation:** The JSP is translated into a servlet.
  2. **Compilation:** The servlet is compiled into bytecode.
  3. **Initialization:** The servlet is initialized.
  4. **Request Handling:** Requests are handled, and responses are generated.
  5. **Destroying:** The servlet is destroyed, and resources are released.


[jsp lifecycle](https://docs.oracle.com/javaee/5/tutorial/doc/bnahe.html)

### Implict Objects in JSP

- builtin objects that can be used in scriplets and expressions

#### Request

- HTTPServletRequest

#### Response

- HTTPServletResponse

#### Out

- used to send content to client. uses PspWriter
- similar to PrintWriter object

#### Page and Page Context

- page represents the current jsp page

- **`pageContext`:** Provides access to various scope objects (request, session, application) and attributes. Useful for managing the state across different scopes.
  - **Example:**
    ```jsp
    <%= pageContext.getRequest().getAttribute("attributeName") %>
    ```
    ```jsp
    <%= pageContext.setAttribute("Name","value", PageContext.SCOPE_TYPE) %>
    ```

#### Application

- **`application`:** Refers to the ServletContext object for the application. Useful for setting and getting application-wide attributes.
- ServLetContext is an object that contains metadata about the web application. it defines a set of methods tat a servlet used to comunicate with servlet container.
- 
  - **Example:**
    ```jsp
    <%= application.getAttribute("name") %>
    ```

#### Config
- **`config`:** Refers to the ServletConfig object for the JSP. 
- it contains initialization parameters from the `web.xml` configuration file.

#### Exception handiling in JSP


```jsp
<%@ page errorPage = "error.jsp" %>
```
and
```jsp
<%@ page isErrorPage = "true" %>

<%= exception.getMessage() %>
```


### JSTL (JSP Standard Tag Library)

#### Expression Language (EL)
- **EL Syntax:** Simplifies access to data in JSP pages.

```jsp
${attributeName}
```

### JSP Tags

- add jsp.jstl dependency

#### Core Tags Commonly used tags for basic operations.

##### Out
- **`<c:out>`:** Outputs data to the page.
```jsp
<%@ taglib prefic="c" uri="" %>
```  
    
```jsp
    <c:out value="${user.name}" />
```

##### Conditional Tags (If, If Else, and Choose)
- **`<c:if>`:** Evaluates a condition and includes content if true.
  - **Example:**
    ```jsp
    <c:if test="${user.loggedIn}">
        Welcome, ${user.name}!
    </c:if>
    ```

- **`<c:choose>`, `<c:when>`, and `<c:otherwise>`:** Used for complex conditional logic.
  - **Example:**
    ```jsp
    <c:choose>
        <c:when test="${user.role == 'buyer'}">
            Buyer Dashboard
        </c:when>
        <c:otherwise>
            Seller Dashboard
        </c:otherwise>
    </c:choose>
    ```

##### Iteration Tags (For Each)


- **`<c:forEach>`:** Iterates over collections or arrays.
  - **Example:**
    ```jsp
    <c:forEach items="${productList}" var="product">
        <p>${product.name}</p>
        <p>${product.description}</p>
        <p>${product.price}</p>
    </c:forEach>
    ```

- set a property value

```jsp
    <c:set var="userid" value="id" scope="request"></c:set>
```

##### Actions
- **Tag Actions:** Perform various actions such as including other resources, forwarding requests, set property, get property, and use bean.

- Includes another JSP or resource.
    ```jsp
    <jsp:include page="header.jsp" />
    ```




##### Validation
- **Tag Libraries:** Use JSTL tags for validating user input and handling errors.
  - **Example:** Custom validation tags can be used to handle form inputs and validation like weblogic in jsp 2.3.

[referene](https://docs.oracle.com/cd/E24329_01/web.1211/e21049/validation_tags.htm#WBAPP459)






### Processing XML

The Extensible Markup Language (XML)

```xml

```

```jsp

```

[jsp-xml](https://www.oracle.com/technical-resources/articles/javase/webappdev2.html)

### Sending Email

- **JavaMail API:** Use the JavaMail API to send emails from JSP.

### Internationalization & Localization
