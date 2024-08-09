package Mathematical;

public class MathematicalOperations {
	
	public int addNum(int a, int b) {
		return a+b;
	}
	
	public float divideNumbers(int a, int b) {
		
		if (b!=0) {
			return a/b; 
		}
		throw new ArithmeticException("denominator can not be zero");
		
	}

}
