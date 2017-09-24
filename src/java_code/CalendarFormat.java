package java_code;

import java.util.Calendar;

public class CalendarFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		String year = "2015";
		String month = "08";
		String day = "05";
		
		System.out.println(Integer.parseInt(year));
		System.out.println(Integer.parseInt(month));
		System.out.println(Integer.parseInt(day));
		
		cal.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		
		System.out.println(cal);
		String d = null;
		switch(cal.get(Calendar.DAY_OF_WEEK)){
	        case Calendar.MONDAY: d = "MONDAY";
	            break;
	        case Calendar.TUESDAY: d = "TUESDAY";
	            break;
	        case Calendar.WEDNESDAY: d = "WEDNESDAY";
	            break;
	        case Calendar.THURSDAY: d = "THURSDAY";
	            break;
	        case Calendar.FRIDAY: d = "FRIDAY";
	            break;
	        case Calendar.SATURDAY: d = "SATURDAY";
	            break;
	        case Calendar.SUNDAY: d = "SUNDAY";
	            break;                
		}
		
		System.out.println(d);
	}
}
