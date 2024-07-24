package code;

import demo.Sample;

class Parent {
	
	int i =4;
	
	Parent() {
		
		System.out.println("No args ctr parent");
	}
	
	Parent(int a){
		
		this();
		
		System.out.println("Parameterised ctr parent" + a);
		
	}

}

public class Child extends Parent{
	int i = 3;
	Child(){
		
		super();
		System.out.println("No args ctr child");
		
	}
	
	Child(int a){
		super(5);
		System.out.println("Parameterised ctr child" + this.i);
		
	}
	
	
	public static void main(String[] args) {
		
		Sample s = new Sample();
		Parent cdp = new Parent(4);
		Child c = new Child();
		Child cp = new Child(6);
		
		
	}
}
