package functionalprogramming;

import java.util.Comparator;

import Entity.Product;

public class ProductComparator{

	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getPrice()-o2.getPrice());
	}
	
	public  int compareByName (Product o1, Product o2) {
			return o1.getName().compareTo(o2.getName());
		
	}
	
}