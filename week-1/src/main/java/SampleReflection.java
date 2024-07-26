import java.lang.reflect.Field;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jdk.jfr.snippets.Snippets.Example;

public class SampleReflection {
	
	private int value = 1;
	private void printSomething() {
		System.out.println("something");
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		SampleReflection sr = new SampleReflection();
		
		Field [] fields = SampleReflection.class.getDeclaredFields();
				
		for (Field field : fields) {
		
			//Field field = SampleReflection.class.getDeclaredField("value");
			System.out.println(field.getName());
			field.setAccessible(true);
			field.set(sr, 4);
			
			System.out.println(sr.value);
		}
		
		LocalDateTime ld = LocalDateTime.now();
		
		Instant i = Instant.now();
		
		System.out.println(ld.minusDays(3));
		
		System.out.println(i);
		
	}

}
