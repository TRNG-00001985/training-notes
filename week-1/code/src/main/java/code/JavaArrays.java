package code;
import java.util.*;

public class JavaArrays {
	public static void main(String[] args) {
		
		int [] a = {1,3,4,5,5};
		String [][] m = {{"row", "one"},{"rwo", "two"}};
		int [] arr = new int[6];
		
		Arrays.fill(arr, 4);
	    // {4,4,4,4,4,4}
		
		int [] arrCopy = Arrays.copyOf(arr, arr.length);
		Arrays.setAll(arrCopy, index -> index *2);
		
	}

}
