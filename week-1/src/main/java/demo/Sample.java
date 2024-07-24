package demo;

import code.Access;

public class Sample extends Access{
	
	public Sample(){
		System.out.println("A sample class from demo package");
	}
	
	public static void main(String[] args) {
		Access a = new Access();
		
		System.out.println(a.publicVar);
		a.publicMethod();
	}

}
