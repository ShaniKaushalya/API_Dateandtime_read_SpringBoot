package APIDateTimeReader;

import APIDateTimeReader.MySQLConnection;
import APIDateTimeReader.SystemDateAndTime;

public class DateTimeReaderMain {

	public static void main(String[] args) {
		SystemDateAndTime													 CurrentDateTime = new  SystemDateAndTime();
		MySQLConnection ConnectAndWrite =  new MySQLConnection();
		
		
		MySQLConnection.DBConnection();
		
		while(true) {
			try {
		String CDate = CurrentDateTime.GetCurrentSystemDate();
		String CTime = CurrentDateTime.GetCurrentSystemTime();

		MySQLConnection.DatabaseDatawriter();
		
	
			Thread.sleep(60000);
		} 
			catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
	
		
	}

}
