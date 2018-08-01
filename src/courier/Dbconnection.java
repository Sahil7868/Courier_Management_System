package courier;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection {

	private static String connectionUrl="jdbc:postgresql://localhost:5432/courier";
	
	private static String driverClassName="org.postgresql.Driver";
	private static String userName="postgres";
	private static String password="sahil@@786";
	
	public static Connection getDbConnection()
	{
		Connection conn=null;
		
		try {
			Class.forName(driverClassName);
			conn=DriverManager.getConnection(connectionUrl, userName, password);
			
			if(conn!=null)
				System.out.println("Connection With Database");
			else 
				System.out.println("Connection Failed");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		getDbConnection();
	}
}

