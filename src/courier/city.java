package courier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class city {

	public static void city_display()
	{
		Connection conn=Dbconnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		int city_id;
		String city_name=new String();
		
		String s_name=new String();
		
		if(conn!=null)
		{
			try 
			{
				
				pstmt=conn.prepareStatement("select * from public.state s,public.city c where s.state_id=c.state_id");
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					city_id=rs.getInt("state_id");
					city_name=rs.getString("city_name");
					s_name=rs.getString("state_name");
					
					System.out.println("id::"+city_id+ "  "+ "City name::" + city_name+ " "+ "State name::"+ s_name);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}//display
	
	public static boolean city_insert()
	{
		Connection conn=Dbconnection.getDbConnection();
		ResultSet rs=null;
		int result;
		PreparedStatement pstmt=null;
		int state_id=0;
		int flag=0;
		
		String state_name=new String();
		String city_name1=new String();
		String city_name=new String();
		boolean status=false;
		Scanner sc=new Scanner(System.in);
		
		
		
		
		if(conn!=null)
		{
			try 
			{	
				System.out.print("Enter City Name::");
				city_name=sc.next();
				
				System.out.print("Enter State Name::");
				state_name=sc.next();
				
				pstmt=conn.prepareStatement("select city_name from public.city");
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					//country_id=rs.getInt("country_id");
					city_name1=rs.getString("city_name");
					
					//System.out.println("id::"+country_id+ "  "+ "name::" + country_name);
				
				if(city_name1.equals(city_name))
				{
					
					flag=1;
					
				}
				
				
				
				}
				if(flag==0)
				{
					
						pstmt=conn.prepareStatement("select state_id from public.state where state_name="+"'"+state_name+"'");
						rs=pstmt.executeQuery();
					
						while(rs.next())
						{
							//country_id=rs.getInt("country_id");
							state_id=rs.getInt("state_id");
						
						}
						pstmt=conn.prepareStatement("insert into city(city_name,state_id) values(?,?)");
						
						pstmt.setString(1,city_name);
						pstmt.setInt(2,state_id);
					
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
					System.out.println(city_name+ " already exist");
				}
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return status;
	}//insert
	
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println("1 for City display");
		System.out.println("2 for City Insert");
		
	
		
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
			city_display();
			break;
		case 2:
			city_insert();
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
	


