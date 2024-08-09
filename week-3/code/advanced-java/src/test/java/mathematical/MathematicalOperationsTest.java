package mathematical;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Mathematical.MathematicalOperations;

 

public class MathematicalOperationsTest {
//	
	@BeforeAll
	static void printBeforeAllTests() {
		System.out.println("Started the testing");
	}
	
	@AfterAll
	static void printAfterAllTests() {
		System.out.println("End");
	}
	
	@BeforeEach
	void printBeforeEachTest() {
		System.out.println("test case");
	}
	
	@Test
	void addTwoAndTwoEqualsFour() {
		
		MathematicalOperations m = new MathematicalOperations();
		
		assertEquals(4, m.addNum(2, 2));
				
	}
	
	@Test
	void divideByZero() {
		
		MathematicalOperations m = new MathematicalOperations();
		
		assertThrows(ArithmeticException.class, () -> {m.divideNumbers(4, 0);});

		
		
	}
	
	@Test
	void twoDividedByTwoIsOne() {
		MathematicalOperations m = new MathematicalOperations();
		
		assertEquals(1, m.divideNumbers(2, 2));
	}
	
	
	

}
