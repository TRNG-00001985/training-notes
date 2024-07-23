### Wrapper Classes

- An Object or Wrapper for primitives with additional functionalities.

- BYTE
- SHORT
- INTEGER
- LONG
- CHARACTER
- FLOAT
- DOUBLE
- BOOLEAN

**methods**

- valueOf : primitive to wrapper class
- parse : string to wrapper class
- equals : compare two objects

### Casting (Auto Boxing and Unboxing)

**Auto Boxing:** Converting primitives to Wrapper Classes

**Unboxing:** Coverting Wrapper classes to Primitives

### Strings

- Sequence if characters
- immutable

```java
// string literal
String sLiteral = "value";

// String objects
String sObj = new "value"

```
### String pool

- Stirngs are stored in String pool which is part of heap memory.
- interning: storing one copy for each string literal.
- the JVM searches for the string value in the string pool and if its found a reference is returned without allocating the additional memory
- for strings created using `new` operator, jvm allocates the memory.

#### String Methods

- length
- concact
- substring
- subSequence
- split
- trim
- toLowerCase
- toUpperCase
- indexOf
- lastIndexOf
- replace
- replaceAll
- replaceFirst
- endsWith
- startsWith
- compareTo
- compareToIgnoreCase
- equals
- equalsIgnoreCase
- matches


### StringBuilder and StringBuffer

- mutable sequence of characters
- internally treated as variable lenth arrays


**java.lang.StringBuilder**
- not thread safe or not synchronized
- better performace


**java.lang.StringBuffer** 
- thread safe ot synchronized
- slow when compared to StringBuilder

**methods:**

- append
- insert
- length
- replace
- reverse
- setLength
- ensureCapacity


### Arrays

- object that contains a fixed number of values of the same type.

#### `java.util.Arrays` class

- copyOff : copy of array by padding or truncating based on specified length
- copyOfRange: copy of array of a specific range
- fill : assign a value to all elemets of an array
- equals: checks in two arraysa are equal
- deepEquals: equality check for multi deimensional array
- sort: sort elements
- binarySearch: search elements
- toString : arr to string
- deeopToString: multi dimensional array to string
- setAll :used to initilize of modify array elemets based on index

### Control Flow

#### Conditionals

- if
- else
- switch

#### Loops

- for 
- while
- do while


#### Control flow statements  

- break
- continue
- return

### Debugging in Eclipse

[eclipse debugging guide](https://www.eclipse.org/community/eclipse_newsletter/2017/june/article1.php)
----

### Coding Activity

1. CombineStrings
2. GreaterOrLesser
3. HardcodedLogin
4. ArraySum
5. Average
6. GetMax and GetMin
7. Contains
8. DoesNotContain
9. ArraysAreEqual
10. MaxMinusMin
11. IndexOf
12. IsSorted
13. Pyramid
14. ContainsDuplicates
15. Search2dArray
16. CombineArrays
17. WordCount
18. ReverseAString
19. MostCommonCharacter
20. Fibonacci
21. StringIsPalindrome
22. Factorial
23. SubArray
24. Matrix Addition
25. Matrix Multiplication
26. Transpose of a Matrix