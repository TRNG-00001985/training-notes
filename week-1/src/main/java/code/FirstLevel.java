package code;

public class FirstLevel {
	
	String name = "Outer Class Instance Variable";
	static String staticVar = "outer Class Static Variable ";
	//inner class
	class SecondLevel{
		
		String name = "inner class instance variable";
		
		void getVar() {
			String name = "inner class method instance variable";
			System.out.println(name);
		}
		
	}
	//static nested class
	static class StaticSecondLevel{
		
		void getVar() {
			System.out.println(staticVar);
		}
		
	}
	//block
	{
		name = "Block value";
	}
	//static block
	static {
		staticVar = "Static Block";
	}
	
	public static void main(String[] args) {
		
		FirstLevel fl = new FirstLevel();
		SecondLevel sl = fl.new SecondLevel();
		
		System.out.println(fl.name);
		System.out.println(sl.name);
		sl.getVar();
		
		StaticSecondLevel ssl = new StaticSecondLevel();
		
		//method scope
		int a = 10;
	}

}
