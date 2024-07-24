package code;

public class JavaBasics {
	
	public static void main(String[] args) {
		
		//Byte
		//Short
		//Integer
		//Long
		//Character
		//Float
		//Double
		
		int i = 4;
		
		//auto boxing
		Integer j = i;
		//un-boxing
		int k = j;
		
		Integer x = Integer.parseInt("4");
		x = Integer.valueOf(i);
		System.out.println(x.equals(Integer.valueOf(8)));
		
		// Strings
		
		String stringLiteral = "Hello";
		String stringLiteral2 = "Hello";
		String stringObj = new String("Hello");
		
		System.out.println(stringLiteral==stringLiteral2);
		System.out.println(stringLiteral==stringObj);
		
		System.out.println(stringLiteral.length());
		System.out.println(stringLiteral.concat(" World!"));
		System.out.println(stringLiteral.substring(2));
		System.out.println(stringLiteral.subSequence(2, 5));
		System.out.println(stringLiteral.split("e"));
	}

}
