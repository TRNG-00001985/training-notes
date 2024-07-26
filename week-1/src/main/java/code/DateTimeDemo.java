package code;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimeDemo {
	
	public static void main(String[] args) {
		
		LocalDate localDate = LocalDate.now();
		
		System.out.println(localDate.getDayOfWeek()+" "+localDate.getDayOfMonth() + " "+ localDate.getMonth() + " "+ localDate.getYear());
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		System.out.println(localDateTime.getHour()+" "+localDateTime.getMinute()+" "+localDateTime.getSecond()+ " "+localDateTime.getNano());
		
		Instant orderTime = Instant.now();
		
		System.out.println(orderTime);
		
		System.out.println(localDate.minusDays(5).getDayOfMonth());
		
	}

}
