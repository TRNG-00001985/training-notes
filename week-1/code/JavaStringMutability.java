package code;

public class JavaStringMutability {
	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder("Revature");
		
		StringBuffer stringBuffer = new StringBuffer("Revature");
		
		String postfix = " sample text";
		
		long start = System.nanoTime();
		for(int i =0;i<10000;i++) {
			
			stringBuilder.append(postfix);
			
		}
		
		System.out.println("String builder execution time: " + (System.nanoTime()-start));
		
		start = System.nanoTime();
		for(int i =0;i<10000;i++) {
			
			stringBuffer.append(postfix);
			
		}
		
		System.out.println("String buffer execution time: " + (System.nanoTime()-start));
		StringBuilder stringB = new StringBuilder("Revature");

		
		stringBuilder.insert(1, "jsdksa");
		stringB.setLength(2);
		System.out.println(stringB);
		
	}

}
