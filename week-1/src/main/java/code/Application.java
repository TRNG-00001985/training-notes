package code;

public class Application {
	
	public static void main(String [] args) {
		
		// single line
		
		/* multi line
		 * 
		 */
		
		int a = 3;
		int b = 4;
		int hexa = 0X1F;
		int octa = 011;
		
		System.out.println();
		
		// 100 - 4
		// 010 - 2 << 
		// 100 - 4 >>
		// 010
		
		// 1F  1 X 16^1 + 15 X 16^0 = 31
		// 11 1 X 8^1 + 1 X 8^0 = 9
		
		// even 
		//100
		//001
		//000
		// 010
		//1000
		//110

		
		//011 & 001 = 001
		
		// even or odd
		if ((a & 1) ==0) {
			
			System.out.println("Even");
			
		}
		
		else {
			System.out.println("odd");
		}
		
		// 011
		//100
		// swap numbers
		a = a ^ b;
		
		// a = 111
		
		b = a ^ b;
		
		// b = 011
		
		a= a ^ b;
		
		//a = 100
		
		System.out.println("value of a,b: " +a +" "+b);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
