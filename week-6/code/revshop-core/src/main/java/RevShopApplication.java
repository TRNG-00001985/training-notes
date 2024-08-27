import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDAOImpl;
import service.UserService;

public class RevShopApplication {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserService userService = (UserService) context.getBean("userService");
		UserService userService2 = (UserService) context.getBean("userService");

		System.out.println(userService.getUserById(1));
		
//		if( userService == userService2) {
//			
//			System.out.println("singleton");
//		}
//		else {
//			System.out.println("prototype");
//		}
		
//		UserDAOImpl userDao1 = userService.userDao();
//		UserDAOImpl userDao2 = userService.userDao();
//		
//		System.out.println(userDao1);
//		System.out.println(userDao2);

		
		//((AbstractApplicationContext) context).close();
	}

}
