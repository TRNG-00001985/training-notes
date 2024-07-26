package code;

public enum Day {
	
	MONDAY("Weekday"), TUESDAY("Weekday"), WEDNESDAY("Weekday"), THURSDAY("Weekday"), FRIDAY("Weekend"), SATURDAY("Weekend");
	
    private String type;
	
	Day(String type){
		
		this.type=type;
		
	}
	
	String getType() {
		return this.type;
	}

}
