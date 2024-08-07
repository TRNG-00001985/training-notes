package functionalprogramming;

@FunctionalInterface
interface Functional{
	void printSomething(String s);
	default void defaultPrintSomething() {
		System.out.println("Default");
		
	}
}


public class FunctionalProgrammingDemo{
	
	
	public void declareLocalClass() {
		
		class LocalClass {
			
			void printSomething() {
				System.out.println("Something");
			}
		}
		
		LocalClass lc = new LocalClass();
		
		lc.printSomething();
		
		
	}
	
	public static void main(String[] args) {
		
		FunctionalProgrammingDemo fpd = new FunctionalProgrammingDemo();
		
		//fpd.declareLocalClass();
		
		//anonymous class
		Functional f = new Functional() {

			@Override
			public void printSomething(String s) {
				System.out.println(s);
				
			}
			
		};	
		
		//f.printSomething("Something");
		
		// Lambda
		
		Functional fl = (s) -> System.out.println(s);
		//fl.printSomething("Something");
		
		
		// Method Reference
		
		Functional fm = System.out::println;
		fm.printSomething("Something");
		
		
	}

}
