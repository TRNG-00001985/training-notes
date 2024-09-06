# Lecture / Guided coding example

1. SpringBoot Testing

---

# Testing a Spring Application

##@Testing Services using Mockito

Mockito is a popular mocking framework used for unit testing in Java applications. When testing services in a Spring application:

- Use `@MockBean` to create and inject mocks for dependencies.
- Use `Mockito.when()` to define behavior for mock methods.
- Verify method calls using `Mockito.verify()`.


## 2. Integration Testing

Integration tests ensure that different components of your application work together correctly. In Spring:

- Use `@SpringBootTest` to load the entire application context.
- Use `@AutoConfigureMockMvc` for testing with MockMvc.
- Use `@Transactional` to rollback database changes after each test.

## 3. Configuring Profiles and H2 Database

For testing, it's common to use an in-memory database like H2:

- Create an `application-test.properties` file in `src/test/resources`.
- Use `@ActiveProfiles("test")` in your test classes.

application-test.properties:
```properties
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop

spring.jpa.properties.hibernate.globally_quoted_identifiers=true
```

## 4. Testing Controllers using MockMvc

MockMvc allows you to test your controllers without starting a full HTTP server:

- Use `@WebMvcTest` for focused controller tests.
- Inject `MockMvc` to perform requests.
- Use `@MockBean` to mock service dependencies.

Example:
```java
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testCreateUser() throws Exception {
        UserRequest userRequest = new UserRequest("test@example.com", "password");
        when(userService.createUser(any(UserRequest.class))).thenReturn(true);

        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(userRequest)))
                .andExpect(status().isCreated());

        verify(userService).createUser(any(UserRequest.class));
    }
}
```

## Key Points to Remember:

1. Use appropriate annotations: `@SpringBootTest` for integration tests, `@WebMvcTest` for controller tests.
2. Mock dependencies when unit testing services or controllers.
3. Use `@Transactional` for database tests to ensure test isolation.
4. Configure a separate test profile with H2 for faster, isolated tests.
5. When using H2, be aware of SQL syntax differences and use `spring.jpa.properties.hibernate.globally_quoted_identifiers=true` to avoid issues with reserved words.
6. Always clean and rebuild your project after making changes to configuration or entity classes.
7. Use meaningful test names and follow the Arrange-Act-Assert pattern in your tests.
