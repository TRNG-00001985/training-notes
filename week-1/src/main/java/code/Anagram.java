package code;

import java.util.HashMap;

public class Anagram {
	
	public boolean isAnagram(String s1, String s2) {
		
		char[] stringOne = s1.toCharArray();
		char[] stringTwo = s2.toCharArray();
		
		HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hm2 = new HashMap<Character, Integer>();

		
		for (char s: stringOne){
			if(hm1.containsKey(s)) {
				int count = hm1.get(s) +1;
				hm1.put(s, count);
			}
			else
				hm1.put(s, 1);
		}
		
		for (char s: stringTwo){
			if(hm2.containsKey(s)) {
				int count = hm2.get(s) +1;
				hm2.put(s, count);
			}
			else
				hm2.put(s, 1);
		}
		
		for (char c: stringOne) {
			
			if(hm1.get(c)!=hm2.get(c))
				return false;
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		Anagram a = new Anagram();
		
		System.out.println(a.isAnagram("aac", "cca"));
		
	}

}
