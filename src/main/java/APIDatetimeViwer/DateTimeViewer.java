package APIDatetimeViwer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DateTimeViewer {
	public static  Connection con = null;
	public static Statement stmt = null;
	public static ResultSet rs = null;
	
	public static void main(String[] args) {
		
		
		 DBConnection();
		 DatabaseDataViewer();
	}
	
	public static Connection DBConnection() {
		
		String url1 = "jdbc:mysql://localhost:3300/dbdatetimestore";
		String user = "root";
		String password = "G/k9huqxc=uN";
		
		try {
			//Connect to the Database
			con = DriverManager.getConnection(url1, user, password);
			
			
				if (con != null) {
					System.out.println("Connected to the database DateAndTimeStore");

			}
		} 
		catch (SQLException ex) {

			System.out.println("An error occurred. Maybe user/password is invalid");
			ex.printStackTrace();
		}
	
		return con;
	}
	
	
	public static void DatabaseDataViewer() {
		
		try {
			stmt  =con.createStatement();
	
		//Return data from database 
			rs= stmt.executeQuery("select * from DateAndTimeStore;");
			
	    if (stmt.execute("select * from DateAndTimeStore;")) {
	    	
	    	rs = stmt.getResultSet();
			
	    
	    	System.out.println(rs);
	    	
	    	while (rs.next()) {
	    		  
	    		  
	    		  String ShowTime = rs.getString("DT_Time".toString());
	    		  String Showdate = rs.getString("DT_Date".toString());
	    		  System.out.println("DB result date = "+Showdate+"   DB result time = "+ShowTime );
	    		  				
	    		  
	    		  
	    		}
	    }
	
	} catch (SQLException ex) {

		
		ex.printStackTrace();
	}
		
	}
	

}
