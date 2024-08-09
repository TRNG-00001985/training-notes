# Lecture/Guided Coding Example

1. Testinging Intro
   - TDD
   - Unit Tests and Intergation Tests
2. Junit
    - annotations
    - assertions
3. Mockito

---

**TDD**

- Test-Driven Development is a software development process where tests are written before writing the actual code. 
- It follows a repetitive cycle of writing a test for a small piece of functionality, writing the minimum code necessary to pass the test, and then refactoring the code while keeping all tests passing.


### Unit Testing and Integration Testing

**Unit Tests**
- Unit testing involves testing individual components or units of a software application to ensure they work as expected. 
- Each test case is independent and focuses on a single function, method, or class. 

**Integration Tests**

- Integration testing examines the interaction between different components or modules of an application. 
- It ensures that integrated units work together correctly.

### Unit Testing Line vs Branch Coverage

**Line Coverage**
- Line coverage also known as statement coverage, measures the percentage of executed lines of code during testing. 
- It ensures that each line of the source code is executed at least once. 
- higher line coverage means more lines of code are tested.

**Branch Coverage:**
- Branch coverage also known as decision coverage, goes a step further by ensuring that each possible branch (decision) in the code is tested.
- It measures whether each possible path (true/false outcomes of conditional statements) has been executed. 
- Branch coverage ensures that all logical branches in the code are tested.

## Junit

### Annotations

- Test
- BeforeAll
- AfterAll
- BeforeEach
- AfterEach


### Assertions

- assertEquals
- aseertNotEquals
- assertTrue
- assertFalse
- assertNotNull
- assertThrows

**Mockito**
- Mockito is a popular mocking framework for Java that allows you to create mock objects for unit testing. It helps in isolating the behavior of the unit under test by simulating the interactions with dependencies.

**Key Features of Mockito**

- Creating Mocks: Generate mock objects that can simulate the behavior of real objects.
- Stubbing: Define how mock objects should respond to method calls.
- Verifying Interactions: Check if certain methods were called or not called on mocks.
- Spy Objects: Create partial mocks where some methods are real and others are stubbed.
- Argument Matchers: Specify conditions for method arguments when stubbing or verifying interactions.


**Basic Annotations**
- @Mock: Used to create and inject mock objects.
- @InjectMocks: Creates an instance of the class under test and injects mocks into it.


**Stubs**
- Stubbing in Mockito refers to specifying the behavior of a mock object when certain methods are called. This allows you to define how a mock should behave without needing to interact with actual implementations.