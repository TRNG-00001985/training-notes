package demo;

import code.Access;
import entity.User;

public class Sample extends Access{
	
	public Sample(){
		System.out.println("A sample class from demo package");
	}
	
	public static void main(String[] args) {
//		Access a = new Access();
//		
//		System.out.println(a.publicVar);
//		a.publicMethod();
		
		User u = new User(1,"krishna", "krishna@gmail.com", "dksadhksa");
		
		System.out.println(u.getName());
		
		u.setName("Gopika");
		
		System.out.println(u.getName());
	}

}
