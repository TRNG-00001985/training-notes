# Lecture/ Guided  coding example

1. Servlets

---

### MVC Architecure

### Introduction

**Java EE**: Java Platform, Enterprise Edition (Java EE) provides a set of specifications for enterprise features such as web applications, distributed computing, and web services.

**Apache Tomcat**: Apache Tomcat is a free, open source web server and servlet container that implements the Java Servlet, JavaServer Pages (JSP), and Java Expression Language (EL) specifications. It allows you to run Java EE web applications on a server.

### **2. Servlet Container**

**Servlet Container**: servlet engine. this component manages the lifecycle of servlets, handles request and response interactions, and provides various services to servlets such as session management and resource handling.

**Web.xml**: The `web.xml` file, located in the `WEB-INF` directory of a web application, is used to configure servlets and servlet mappings. It defines how requests are mapped to servlets and other configuration settings.

**Dispatcher Servlet**: A servlet responsible for handling requests and forwarding them to appropriate resources (JSP pages, other servlets). It is a key part of the MVC (Model-View-Controller) architecture.

### **3. Servlet Lifecycle**

The servlet lifecycle consists of the following phases:

- **init**: The servlet container calls the `init` method to initialize the servlet. This is called once during the servlet's lifecycle, typically when the servlet is first requested.

- **service**: After initialization, the servlet container calls the `service` method to handle requests. This method processes each request and generates a response. It is called for each request to the servlet.

  - **doGet**: Handles HTTP GET requests. Used when a client requests data from the server.
  - **doPost**: Handles HTTP POST requests. Used when a client submits data to the server.
  - **doPut**: Handles HTTP PUT requests. Used to update resources on the server.
  - **doDelete**: Handles HTTP DELETE requests. Used to delete resources from the server.

- **destroy**: When the servlet needs to be destroyed (e.g., server shutdown), the container calls the `destroy` method. This method allows the servlet to release resources and perform cleanup tasks.

### **4. Servlet Mapping**

**Servlet Mapping**: Configures how requests are mapped to servlets. This is specified in the `web.xml` file using `<servlet>` and `<servlet-mapping>` elements. For instance, you map a URL pattern to a specific servlet class so that the servlet can handle requests for that URL pattern.

### **5. Request & Response**

- **HttpServletRequest**: Represents the client’s request to the server. It contains information such as request parameters, HTTP headers, and session information.

- **HttpServletResponse**: Represents the server’s response to the client. It allows the servlet to send data back to the client, set response headers, and control response status codes.

- **Request Dispatcher**: Used to forward a request from one servlet to another resource (such as a JSP or another servlet) within the same web application. It is done using the `RequestDispatcher` interface.

- **Redirect**: The `sendRedirect` method of `HttpServletResponse` can be used to redirect the client to a different URL. This results in a new request from the client to the specified URL.

### **6. Session Management**

**Session**: A session is a mechanism to maintain state and track user interactions over multiple requests. Each user session is identified by a unique session ID, which is typically stored in a cookie or URL parameter. Servlets use the `HttpSession` object to manage session data.

### **7. Path Variables and Query Parameters**

- **Path Variables**: Used in RESTful web services to pass values in the URL path. In traditional servlets, path variables are usually handled by extracting parts of the URL path.

- **Query Parameters**: Used in the URL query string to pass data to the server. They are accessed in servlets using methods such as `request.getParameter("name")`.

### **8. Handling Controller Exceptions & Errors**

**Exception Handling**: Servlets can handle exceptions using try-catch blocks. For global error handling, you can use error pages defined in `web.xml` or implement `ErrorPage` configurations. This allows for centralized error management and user-friendly error messages.

**Error Pages**: Configured in `web.xml` to specify which pages should be displayed for different types of errors ( 404 Not Found, 500 Internal Server Error).



