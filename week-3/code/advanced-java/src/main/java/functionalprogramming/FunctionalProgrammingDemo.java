package functionalprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

import Entity.Product;

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
		
		Product [] sampleArray = {new Product(1, "apple", "APL", 100.89F), new Product(2, "bat", "BL", 90.78F)};
		
		//static method
		Arrays.sort(sampleArray, Product::compareByPrice);
		
		//instance method
		ProductComparator pc = new ProductComparator();
		Arrays.sort(sampleArray, pc::compareByName);
		
		for(Product p :sampleArray) {
			System.out.println(p.toString());
		}
		
		String [] names = {"Choclates", "pikachu", "Desk", "pikachu"};
		
		//instance method with arbitry values
		Arrays.sort(names, String::compareToIgnoreCase);
		
		
		for(String s: names) {
			System.out.println(s);
		}
		
		HashSet<String> uniqueNames = new HashSet();
		
		//constructor
		
		Supplier<Set<String>> setSupplier = HashSet<String>::new;
		
		Set<String> unames = setSupplier.get();
		
		
		
		
		
		
	}

}
