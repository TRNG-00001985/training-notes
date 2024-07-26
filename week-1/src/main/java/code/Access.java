package code;

public class Access {
	
	static int staticVar = 5;
	
	int defaultVar = 2;
	
	public int publicVar = 0;
	private int privateVar = 1;
	protected int protectedvar = -1;
	
	public void publicMethod() {
		System.out.println("Public Method");
	}
	
	private void privateMethod() {
		System.out.println("Private Method");
	}
	
	protected void protectedMethod() {
		System.out.println("Protected Method");
	}
	
	static void staticMethod() {
		System.out.println("Static Method");
	}
	
	public static void main(String[] args) {
		
		Access a = new Access();
		
		System.out.println(a.privateVar);
		System.out.println(a.protectedvar);
		System.out.println(a.publicVar);
		
		staticMethod();
		System.out.println(Access.staticVar);

//		enum
		Day d = Day.MONDAY;
		
		System.out.println(d.getType());
		
//		Direction north = new Direction("NORTH");
//		Direction south = new Direction("SOUTH");
//		
//		System.out.println(north.getDirection());
//		System.out.println(south.getDirection());
		
	}
	

}

class ChildAccess extends Access{
	public static void main(String[] args) {
		
		Access a = new Access();
		
		System.out.println(a.protectedvar);
		System.out.println(a.publicVar);
		a.protectedMethod();
		a.publicMethod();
		System.out.println(a.defaultVar);
		
		
		
	}
}

class Direction{
	
	private final String direction;
	
	Direction (String direction){
		this.direction = direction;
	}
	
	String getDirection() {
		return this.direction;
	}
	
	
}
