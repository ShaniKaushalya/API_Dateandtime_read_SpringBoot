package APIDateTimeReader;

import java.time.LocalDate;
import java.time.LocalTime;

public class SystemDateAndTime {
	
	public String GetCurrentSystemDate() {
		String currentDate;
		//Get Current System Date
		LocalDate LDate = LocalDate.now();
		currentDate = LDate.toString();
		//System.out.println("Current date is " +currentDate);
		
		return currentDate;
	}
	public String GetCurrentSystemTime() {
		
		String replaceLTime;
		//Get Current System Time
		 LocalTime LTime = LocalTime.now();
		 String currentTime = LTime.toString();
		 replaceLTime = currentTime.substring(0, currentTime.length()-10);
		
		 
		 return replaceLTime;
	} 

}
