# Lecture/ Guided coding example

1. Spring with JSP

---

1. add dependencies

```xml
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
    <scope>provided</scope>
</dependency>
```
2. configiration forweb resolver

```properties
spring.mvc.view.prefix=/WEB-INF/view/
spring.mvc.view.suffix=.jsp
```

3. controller configuration

```java
@Controller
public class ViewController {
	@GetMapping("/home")
	 public String homeJsp(){
	        return "home";
	    }
	 @GetMapping("/login")
	 public String loginJsp(){
	        return "login";
	    }
	 @GetMapping("/dashboard")
	 public String dashboardJsp(){
	        return "dashboard";
	    }

}
```

user controller
```java

@Controller
@RequestMapping("/api/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	
	public UserResponse getUserById(@PathVariable long id) {
		
		return userService.getUserById(id);
		
		
	}
	
	@PostMapping
	@ResponseBody
	public boolean createUser(@RequestBody UserRequest userRequest) {
		
		try {
			
			return userService.createUser(userRequest);
			
		}
		catch(Exception e) {
			return false;
		}
	}
	@PostMapping("/login")
	public String login(@RequestParam String email,@RequestParam String password, HttpSession session) {
		
		UserResponse userResponse =  userService.login(email, password);
		
		if(userResponse!=null) {
			
			session.setAttribute("user", userResponse);
			System.out.println(userResponse);
			
			 return "redirect:/dashboard";
			
		}
		else {
			return "login";
		}
		
		
	}
}


```
