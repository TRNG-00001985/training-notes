package code;

public class Casting {
	
	public static void main(String[] args) {
		
		Casting c = new Casting();
		
		//data types

		byte b = 10;
		
		// widening
		int i = (int) b;
		
		//narrowing
		byte n = (byte) i;
		
		//upcasting
		Animal a = new Cat();
		
		//downcasting
		Cat cat = (Cat) a;
		
		c.callAniaml(cat);
	}
	
	public void callAniaml(Cat cat) {
		
		System.out.println(cat.getClass());
		cat.eat();
		cat.speak();
		
		
	}

}

class Animal {
	void speak() {
		
	}
}

class Dog extends Animal{
	
	void speak() {
		System.out.println("Rolf");
	}
	
}

class Cat extends Animal{
	void speak() {
		System.out.println("Meow");
	}
	
	void eat() {
		
		System.out.println("drniks milk");
		
	}
}
