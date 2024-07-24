package code;

import java.util.*;

public class ControlFlow {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();
		char [] s = {'d','l','k'};
		
		if(i==1) {
			System.out.println(" one");
			
		}
		else {
			if(i==2) {
				System.out.println(" two");
			}
			else {
				System.out.println("default");
			}
		}
		
		switch (i) {
		case 1: System.out.println(" one");break;
		case 2: System.out.println("two"); break;
		default: System.out.println("default");
		}
		
		while(i>0) {
			System.out.println(i);
			i--;
		}
		do {
			System.out.println(i);
			i--;
		}
		while(i>0);
		
		for(int j=0;j<10;j++) {
			if((j&1)==0) {
				continue;
			}
			if(j==5) {
				break;
			}
			System.out.println(j);
		}
		
		for (char c : s) {
			System.out.println(c);
		}
		
		
	}

}
