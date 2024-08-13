# Lecture/Guided Coding Example Plan

- RESTful API

---


# REST API or RESTfulAPI

Representational State Transfer (REST) is a software architecture that imposes conditions on how an API should work. REST was initially created as a guideline to manage communication on a complex network like the internet. You can use REST-based architecture to support high-performing and reliable communication at scale. You can easily implement and modify it, bringing visibility and cross-platform portability to any API system.

## API

An application programming interface (API) defines the rules that you must follow to communicate with other software systems. Developers expose or create APIs so that other applications can communicate with their applications programmatically. 

## Uniform Interface

The uniform interface is fundamental to the design of any RESTful webservice. It indicates that the server transfers information in a standard format. The formatted resource is called a representation in REST. This format can be different from the internal representation of the resource on the server application.

Uniform interface imposes four architectural constraints:

1. <i><b>Requests should identify resources</b></i>. They do so by using a uniform resource identifier.
2. <i><b>Clients have enough information</b></i> in the resource representation to modify or delete the resource if they want to. The server meets this condition by sending metadata that describes the resource further.
3. <i><b>Clients receive information about how to process the representation further</b></i>. The server achieves this by sending self-descriptive messages that contain metadata about how the client can best use them.
4. <i><b>Clients receive information about all other related resources they need to complete a task</b></i>. The server achieves this by sending hyperlinks in the representation so that clients can dynamically discover more resources.

## Stateless

In REST architecture, statelessness refers to a communication method in which the server completes every client request independently of all previous requests. Clients can request resources in any order, and every request is stateless or isolated from other requests. This REST API design constraint implies that the server can completely understand and fulfill the request every time. 

- Application state(Client State) information is not stored in the server.

## Layered Application

In a layered system architecture, the client can connect to other authorized intermediaries between the client and server, and it will still receive responses from the server. Servers can also pass on requests to other servers. You can design your RESTful web service to run on several servers with multiple layers such as security, application, and business logic, working together to fulfill client requests. These layers remain invisible to the client.

## Cachability

RESTful web services support caching, which is the process of storing some responses on the client or on an intermediary to improve server response time. For example, suppose that you visit a website that has common header and footer images on every page. Every time you visit a new website page, the server must resend the same images. To avoid this, the client caches or stores these images after the first response and then uses the images directly from the cache. RESTful web services control caching by using API responses that define themselves as cacheable or noncacheable.

## Code on Demand

In REST architectural style, servers can temporarily extend or customize client functionality by transferring software programming code to the client. For example, when you fill a registration form on any website, your browser immediately highlights any mistakes you make, such as incorrect phone numbers. It can do this because of the code sent by the server.

# HTTP

- HyperText Transfer Protocol is used to exchnage the information over the internet.

## HTTP Methods or Verbs

HTTP request verbs or methods indicate the action that a client hopes to perform.


**GET**
   - Used to retrieve data
   - NO request body
   - safe
   - idempotent
   - cacheable
   - allowed in HTML forms

**POST**

- "sends data to the server"
- will often be used to create or update data
- it is NOT idempotent
- technically there are ways it can be cacheable, but typically isn't thought of as
-  cacheable
- NOT safe
- allowed in HTML forms
- request has a body
- response has a body

**DELETE**
- used to delete a resource
- might have a request and/or response body
- Not safe
- Not cacheable
- Not allowed in HTML forms
- is idempotent

**PUT**

- updates a target resource such that it replaces the current representations with the one included in the PUT request
- it is idempotent
- Not safe
- Not cacheable
- Not allowed in HTML forms
- response does NOT have a body
- request does have a body
- not supported by HTML forms

**PATCH**

- similar to update
- changes partial aspects of a resource
- request and response have a body
- not safe, idempotent, allowed in HTML forms, or cacheable

**HEAD**

- Essentially the same as GET, but the server's response should not include a body.
- Let's say you are planning to request a large amount of info and you want to test out the response without the risk of wasting bandwidth resources--> HEAD
- Used to retrieve data
- NO request body
- safe
- idempotent
- cacheable
- NOT allowed in HTML forms
- NO response body


  
**OPTIONS**

- Get the options for communication with a particular resource
- safe, idempotent
- request has no body
- response has a body
- Not cacheable or available in HTML forms


## HTTP Status Codes

- HTTP response status codes indicate whether a specific HTTP request has been successfully completed. 
- Status codes are issued by a server in response to a client's request made to the server.
Responses are grouped in five classes
- 1xx informational response (100–199) –  the request was received, continuing process
- 2xx successful (200–299) – the request was successfully received, understood, and accepted 
- 3xx redirection (300–399)  – further action needs to be taken in order to complete the request
- 4xx client error (400–499) – the request contains bad syntax or cannot be fulfilled
- 5xx server error (500–599)  – the server failed to fulfil an apparently valid request

**Examples:** 
2xx- success
- 200: OK, the request is successful and provided the requested reponse
- 201:Created
- 202: Accepted
- 204:No Content

3xx redirection 
- 301: Moved Permnenntly
- 302: Found
- 304: Not Modified

4xx: client error
- 400: Bad Request
- 401: Unauthorized
- 404: Not Found

5xx: server errors
- 500: Interbal server error
- 503:  Server Unavilabe

## HTTP Request

**Verb**
Indicates the executing HTTP method.

**URI**
Specifies the endpoint where the resource is located.

**HTTP Version**

**Request Header**
META-DATA (information) of the Request as key-value pairs such as format supported by the client, browser type, etc.

**Request Body**
Message content or resource representation.

![HTTP Request](./images/HTTP%20Request.PNG)


## HTTP Response

**Response Code**
200 (OK), 403 (Forbidden), 404 (Not Found), 500 (Internal Error), etc.

**HTTP Version.**

**Response Header**
META-DATA for the Response such as: content length, content type, date, etc.

**Response Body**
Some kind of payload in the case where HTTP is used in the context of a RESTful service then the body is a resource representation.

![HTTP Response](./images/HTTP%20Response.PNG)


## URL

A URL is a very frequently used form of resource identifier in a RESTful service. 
Ideally resource identifiers should change as little as possible over time (even as the state of the resource they identify changes).
URL stands for uniform resource locator and forms an address on the web.

**It follows a particular format:** protocol domain name port path(path parameters) query-parameters anchor

**Example:**

https://app.revature.com/myActivities
protocol: http
fully qualified domain name: app.revature.com
path: myActivities 

**Example:**

https://www.youtube.com/watch?v=w5j2KwzzB-0
protocol: https
domain name: www.youtube.com
path: watch
parameter: v
value of the parameter: w5j2KwzzB-0


## HTTP Headers:

HTTP headers are additional pieces of information sent along with an HTTP request or response. They provide instructions or metadata about the request or response, allowing the client and server to communicate effectively. Headers consist of a name-value pair and are included in the HTTP message's header section.

Some common HTTP headers include:

- **Content-Type:** Specifies the media type of the resource being sent or requested.
- **User-Agent:** Identifies the software and version used by the client making the request.
- **Authorization:** Contains credentials to authenticate the client with the server.
- **Cookie:** Contains information about previously stored cookies.

## HTTP Cookies:

HTTP cookies, often referred to as web cookies or browser cookies, are small pieces of data stored on a client's computer by a web server. Cookies are primarily used to track and maintain stateful information across multiple requests and sessions.


Cookies can be used for various purposes, including **session management**, **user authentication**, **personalization**, and **tracking user behavior**. They can store information such as user **preferences**, **login credentials**, **shopping cart items**, and more.

## HTTP Lifecycle:

The HTTP lifecycle refers to the series of steps involved in the communication between a client (such as a web browser) and a server over the Hypertext Transfer Protocol (HTTP). The lifecycle typically consists of the following steps:

1. **Client sends an HTTP request:** The client initiates the communication by sending an HTTP request to the server. The request includes information like the HTTP method (GET, POST, etc.), the requested resource's URL, headers, and optional request body.

2. **Server processes the request:** Upon receiving the request, the server processes it based on the specified HTTP method, requested resource, and any additional information provided in the headers or request body.

3. **Server generates an HTTP response:** After processing the request, the server generates an HTTP response. The response includes headers, a response status code (indicating the success or failure of the request), and an optional response body containing the requested resource or other relevant data.

4. **Server sends the response:** The server sends the HTTP response back to the client, which includes the headers, status code, and response body.

5. **Client receives the response:** The client receives the HTTP response and processes it based on the status code and content received.

6. **Client renders/display the response:** If the response includes HTML, CSS, or other content that can be rendered by the client (e.g., a web browser), it will be displayed or rendered to the user. This step is specific to clients capable of rendering the received content.


## Exposing and consuming the REST API

The server exposes the REST API endpoints and the client consumes the Exposed REST API Endpoints.

**JSON**

- JavaScript Object Notation.
- Used to trasmit data between server and web client. 
- It is language-agnostic(can be parsed and used by various languages).


**JSON Server**

```
npm install json-server
 ```
```
json-server --watch <filepath-- filename.json> --port 8081
 ```
- you can change the port number.
```
json-server --watch db.json
```
```
npx json-server -w db.json -p 8081
```