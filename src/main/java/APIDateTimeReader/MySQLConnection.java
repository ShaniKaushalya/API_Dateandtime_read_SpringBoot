package APIDateTimeReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MySQLConnection {


	public static Connection con = null;
	public static Statement stmt = null;
	public static ResultSet rs = null;

	public static Connection DBConnection() {

		String url1 = "jdbc:mysql://localhost:3300/dbdatetimestore";
		String user = "root";
		String password = "G/k9huqxc=uN";

		try {
			// Connect to the Database
			con = DriverManager.getConnection(url1, user, password);

			if (con != null) {
				System.out.println("Connected to the database DateAndTimeStore");

			}
		} catch (SQLException ex) {

			System.out.println("An error occurred. Maybe user/password is invalid");
			ex.printStackTrace();
		}

		return con;
	}

	public static void DatabaseDatawriter() {

		SystemDateAndTime CurrentDateTime = new SystemDateAndTime();
		String CDate = CurrentDateTime.GetCurrentSystemDate();
		String CTime = CurrentDateTime.GetCurrentSystemTime();

		// String getcurrentdaCTimete = SystemDateTime.currentDate;
		// String getcurrentTime = SystemDateTime.replaceLTime;
		// update DateAndTimeStore SET DT_Date ='2023-01-07' ,DT_Time= '02:29:01.00'
		// where DT_ID = 1 ;
		// String query1 = " update DateAndTimeStore SET DT_Date = '" + getcurrentdate +
		// "',DT_Time= '" + getcurrentTime+ "' where DT_ID = 1; ";
		
		
		String DeleteQuery = "delete from dateandtimestore";
		String query1 = "INSERT INTO DateAndTimeStore VALUES('" + CTime + "','" + CDate + "','0')";

		if (CTime == "00:00:00.00") {
			try {
				stmt = con.createStatement();
				stmt.executeUpdate(DeleteQuery);
				stmt.executeUpdate(query1);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			try {

				stmt = con.createStatement();
				stmt.executeUpdate(query1);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
