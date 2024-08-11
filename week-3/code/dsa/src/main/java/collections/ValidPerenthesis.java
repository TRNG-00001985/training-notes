package collections;

import java.util.Stack;

public class ValidPerenthesis {
	
	public static boolean isValid(String p) {
		
		char[] values = p.toCharArray();
		
		Stack<Character> s = new Stack();
		
		for(char c:values) {
			
				
				if ((c=='}' && s.pop()=='{') || (c==']' && s.pop()=='[') || (c==')' && s.pop()=='(')) {
					continue;
				}
				
			}
			
//			 {
//			s.push(c);
//			}
			
		//}
		
		if(s.isEmpty()) {
			return true;
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		
		String s1 = "{{[]}}";
		String s2 = "{]}";
		
	}

}
