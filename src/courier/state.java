package courier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class state {

	public static void state_display()
	{
		Connection conn=Dbconnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		int state_id;
		String state_name=new String();
		
		String c_name=new String();
		
		if(conn!=null)
		{
			try 
			{
				
				pstmt=conn.prepareStatement("select * from public.state s,public.country c where s.country_id=c.country_id");
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					state_id=rs.getInt("state_id");
					state_name=rs.getString("state_name");
					c_name=rs.getString("country_name");
					
					System.out.println("id::"+state_id+ "  "+ "State name::" + state_name+ " "+ "country name::"+ c_name);
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
		int country_id=0;
		int flag=0;
		
		String country_name=new String();
		String state_name1=new String();
		String state_name=new String();
		boolean status=false;
		Scanner sc=new Scanner(System.in);
		
		
		
		
		if(conn!=null)
		{
			try 
			{	
				System.out.print("Enter state Name::");
				state_name=sc.next();
				
				System.out.print("Enter country Name::");
				country_name=sc.next();
				
				pstmt=conn.prepareStatement("select state_name from public.state");
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					//country_id=rs.getInt("country_id");
					state_name1=rs.getString("state_name");
					
					//System.out.println("id::"+country_id+ "  "+ "name::" + country_name);
				
				if(state_name1.equals(state_name))
				{
					
					flag=1;
					
				}
				
				
				
				}
				if(flag==0)
				{
					
						pstmt=conn.prepareStatement("select country_id from public.country where country_name="+"'"+country_name+"'");
						rs=pstmt.executeQuery();
					
						while(rs.next())
						{
							//country_id=rs.getInt("country_id");
							country_id=rs.getInt("country_id");
						
						}
						pstmt=conn.prepareStatement("insert into state(state_name,country_id) values(?,?)");
						
						pstmt.setString(1,state_name);
						pstmt.setInt(2,country_id);
					
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
					System.out.println(state_name+ " already exist");
				}
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return status;
	}//insert
	
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println("1 for State display");
		System.out.println("2 for State Insert");
		
	
		
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
			state_display();
			break;
		case 2:
			state_insert();
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
	


