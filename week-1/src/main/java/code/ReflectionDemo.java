package code;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import entity.Product;

public class ReflectionDemo {
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		Product p = new Product();
		
		
		//Reflection API
		//accessing fields
		Field [] fields = Product.class.getDeclaredFields();
		
		for(Field field: fields) {
			
			System.out.println(field.getName());
			
		}
		
		Field productId = Product.class.getDeclaredField("productId");
		Field productName = Product.class.getDeclaredField("productName");

		
		productId.setAccessible(true);
		System.out.println(productId.get(p));
		productId.set(p, 4);
		System.out.println(productId.get(p));
		
		productName.setAccessible(true);
		productName.set(p, "Samsung Phone");
		
		System.out.println(productId.getType());
		
		//invoke methods
		Method [] methods = Product.class.getDeclaredMethods();
		
		for(Method method: methods) {
			System.out.println(method.getName());
		}
		
		Method getProductName = Product.class.getDeclaredMethod("getProductName");
		
		getProductName.setAccessible(true);
		System.out.println(getProductName.invoke(p));
		
		
		
		
	}

}
