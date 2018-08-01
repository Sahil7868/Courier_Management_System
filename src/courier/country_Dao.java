package courier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class country_Dao {

	public static void country_display()
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
	
	
	public static boolean country_insert()
	{
		Connection conn=Dbconnection.getDbConnection();
		ResultSet rs=null;
		int result;
		PreparedStatement pstmt=null;
		int country_id;
		int flag=0;
		String country_name=new String();
		String country_name1=new String();
		boolean status=false;
		Scanner sc=new Scanner(System.in);
		
		
		
		
		if(conn!=null)
		{
			try 
			{	
				System.out.print("Enter Country Name::");
				country_name=sc.next();
				
				pstmt=conn.prepareStatement("select country_name from public.country");
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					//country_id=rs.getInt("country_id");
					country_name1=rs.getString("country_name");
					
					//System.out.println("id::"+country_id+ "  "+ "name::" + country_name);
				
				if(country_name1.equals(country_name))
				{
					
					flag=1;
					
				}
				
				
				
				}
				if(flag==0)
				{
					
					
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
					
				}
				else
				{
					System.out.println(country_name+ " already exist");
				}
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return status;
	}//insert
	
	
	
	public static void main(String[] args) {
		
		System.out.println("1 for country display");
		System.out.println("2 for country Insert");
		
	
		
		Scanner sc=new Scanner(System.in);
		int a;
		String c="yes";
		do
		{
		 //String c;	
		System.out.println("Enter your choice");
		a=Integer.parseInt(sc.next());
		
		switch(a)
		{
		
		
		case 1:
			country_display();
			break;
		case 2:
			country_insert();
			break;
		default :
			System.out.println("Invalid operation");
		
		
		
		
		}
		System.out.println("for continue yes");
		c=sc.next();
		//c=sc.nextLine();
		//ch=c;
		}while(c.equals("yes"));
		
		//state_display();

	}
}
	


