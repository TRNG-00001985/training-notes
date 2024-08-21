# Lecture/Guided Coding Example

1. JavaScript DOM
2. JavaScript HTTP

---

### JavaScript DOM

- Document Object Model is a programming interface for web docments.
- used to modify the document structure, style and content.


**Window:** window that contains the document. (browser window)

**Document:** the webpage. entry point to DOM tree.

**Node:** objects within the document. In HTML doc, element, text and attributes are nodes.

**Element:**  Node of type element. HTMLElement

**NodeList:** array of elements

**Attr:** attribute node

**NamedNodeMap:** list of Attr objs. Not in any particular order but can be indexed.



#### Selecting Elements

`getElementsByTagName()` :  returns array Elements based on tag name

`getElementById()`: returns first macthing element based on ID

`getElementsByClassName()` : returns macthing elements based on Class

##### CSS Selectors: 

`querySelector()` : returns first matching Element 

`querySelectorAll()` :returns NodeList containing all matching Element nodes.


#### Traversing the DOM

- Root Node
- Child Node
- Decendenct Node
- Parent Node
- Sibling Nodes

#### DOM Manipulations

##### Text

- innerHTML
- innerText
- textContent

##### style

```js
Element.style.property
```
##### elements

```js
createElement
appendChild
replaceChild
removeChild
remove
```
##### Attributes

```js
Element.attrName

creteAttribute()
setAttributeNode()
```

#### Events and Listeners

- an event that takes place on the EventTarget(objects that recive events and may have listers for them).
- listener object recives a nofication when a event of specific type occurs.

```js
addEventListener()
removeEventListener()
```

#### Bubbling & Capturing

Bubbling: event propogation starts from the target elemnt and then bubbels up the root element window

Capturing: event propogation starts from the root elemnt and then travels down to the target element

---

### JavaScript HTTP


#### JSON

**JavaScript Object Notation**

- **Definition**: JSON is a text based format used for representing structured data.
- **Purpose**: Primarily used for transmitting data between a server and a web application.
- **Format**: Data is organized in key-value pairs, similar to objects in JavaScript.

**Example:**

```json
{
  "name": "John Doe",
  "age": 30,
  "isStudent": false,
  "courses": ["Math", "Science", "History"],
  "address": {
    "street": "123 Main St",
    "city": "Anytown",
    "state": "CA"
  }
}
```

- **Key Points**:
  - JSON supports data types like strings, numbers, arrays, objects, booleans, and `null`.
  - It is language-independent.

---

#### **Promises**

**Asynchronous Operations**

- **Definition**: Promises in JavaScript represent the eventual completion (or failure) of an asynchronous operation and its resulting value.
- **States**:
  - **Pending**: Initial state, neither fulfilled nor rejected.
  - **Fulfilled**: Operation completed successfully.
  - **Rejected**: Operation failed.
- **Methods**:
  - `.then()`: Executes a function when the promise is fulfilled.
  - `.catch()`: Executes a function when the promise is rejected.
  - `.finally()`: Executes a function when the promise is settled (fulfilled or rejected).

- **Key Points**:
  - Promises help in handling asynchronous code in a more manageable way compared to callbacks.
  - They make the code cleaner and more readable.

#### **Fetch API**

**Fetching Resources Asynchronously**

- **Definition**: The Fetch API provides a modern, promise-based method to make network requests.
- **Basic Usage**:
  - Used for making HTTP requests and handling responses.
  - Returns a `Promise` that resolves to the `Response` object.

- **Key Points**:
  - Supports promises, allowing easier chaining of asynchronous operations.
  - Can handle a variety of request and response types, including JSON, text, and blobs.

---

#### **Async & Await**

**Simplifying Asynchronous Code**

-  `async` and `await` are syntactic features in JavaScript that simplify working with promises and asynchronous code.
  - **`async`**: Declares a function as asynchronous and automatically wraps the function's return value in a `Promise`.
  - **`await`**: Pauses the execution of an `async` function and waits for the `Promise` to resolve before continuing.

- **Key Points**:
  - `async`/`await` makes asynchronous code look and behave more like synchronous code.
  - Helps in reducing the complexity of chaining `.then()` and `.catch()` methods with promises.
  - Allows for easier error handling using `try` and `catch`.