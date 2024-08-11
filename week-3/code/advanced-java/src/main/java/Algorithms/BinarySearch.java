package Algorithms;

public class BinarySearch {
	
	static int binarySearch(int[] arr, int key) {
		
		int low = 0;
		int high = arr.length-1;
		
		while(low<=high) {
			int mid = low + (high-low)/2;
			
			if( key==arr[mid]) {
				return  mid;
			}
			
			if(key>arr[mid]) {
				low = mid+1;
			}
			else {
				high = mid -1;
			}
		}
		
		return -1;
		// 1 2 3 5 6
		
	}
	
	public static void main(String[] args) {
		
		int arr[] = {1,2,3,5,6};
		int result = binarySearch(arr, 4);
		
		System.out.println(result!=-1?result:"Not present");
		
	}

}
