package Algorithms;

import java.util.Arrays;
import java.util.Comparator;

class Thing{
	
	int weight;
	int value;
	
	Thing(int weight, int value){
		this.weight = weight;
		this.value = value;
	}
	
}

public class FractionalKanpsack {
	
	static double getMaxValue(Thing[] t, int capacity) {
		
		Arrays.sort(t, new Comparator<Thing>() {
			@Override
			public int compare(Thing t1, Thing t2) {
				double r1 = t1.value/t1.weight;
				double r2 = t2.value/t2.weight;
				return Double.compare(r2, r1);
			}
		} );
		
		double totalValue = 0.0;
		
		for(Thing thing: t) {
			int weight = thing.weight;
			int value = thing.value;
			
			if(capacity - weight>=0) {
				capacity -=weight;
				totalValue+=value;
			}
			else {
				double fraction = ((double) capacity/weight);
				totalValue += value * fraction;
				break;
				
			}
		}
		
		return totalValue;
	}
	
	// t1 = 10 4, t2 3 20, t3 5 5
	// 10
	
	//7  - 20
	//2 - 25
	//0 25.8
	
	public static void main(String[] args) {
		
		Thing [] things = {new Thing(10,4), new Thing(3,20), new Thing(5,5)};
		int capacity = 10;
		
		System.out.println("Max Value: " + getMaxValue(things, capacity));
		
	}
	

}
