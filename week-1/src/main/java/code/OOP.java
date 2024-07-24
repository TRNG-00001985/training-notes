package code;

public class OOP {
	
	static final int DEMO_CONSTANT = 4;
	
	int count = 0;
	
	public void increseCount(int value) {
		count+=value;
	}
	
	public void increseCount() {
		count++;
	}
	
	
	public static void main(String[] args) {
		
		OOP oop = new OOP();
		
		System.out.println(OOP.DEMO_CONSTANT);
		
		oop.increseCount(3);
		oop.increseCount();
		System.out.println(oop.count);
		
		
	}
	
	

}
