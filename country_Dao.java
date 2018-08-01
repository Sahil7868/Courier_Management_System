package ARMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import ARMS.util.Dbconnection;

public class country_Dao {

	public static void state_display()
	{
		Connection conn=Dbconnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		int country_id;
		String country_name=new String();
		
		
		
		if(conn!=null)
		{
			try 
			{
				
				pstmt=conn.prepareStatement("select * from public.country");
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					country_id=rs.getInt("country_id");
					country_name=rs.getString("country_name");
					
					System.out.println("id::"+country_id+ "  "+ "name::" + country_name);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}//display
	
	
	public static boolean state_insert()
	{
		Connection conn=Dbconnection.getDbConnection();
		ResultSet rs=null;
		int result;
		PreparedStatement pstmt=null;
		int country_id;
		String country_name=new String();
		boolean status=false;
		Scanner sc=new Scanner(System.in);
		
		
		
		
		if(conn!=null)
		{
			try 
			{	
				System.out.print("Enter Country Name::");
				country_name=sc.next();
				
				
				pstmt=conn.prepareStatement("insert into country(country_name) values(?)");
				
				pstmt.setString(1,country_name);
				
				result=pstmt.executeUpdate();
				
				if(result>0)
				{
					System.out.println("-----------Inserted ---------");
					status=true;
				}
				else
				{
					System.out.println("-----------Insertion Fail ---------");
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return status;
	}//insert
	
	
	
	public static void main(String[] args) {
		//state_display();
		state_insert();
	}
	
}
