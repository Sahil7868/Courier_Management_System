package courier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class area {

	public static void area_display()
	{
		Connection conn=Dbconnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		int area_id;
		int pincode;
		String area_name=new String();
		
		String c_name=new String();
		
		if(conn!=null)
		{
			try 
			{
				
				pstmt=conn.prepareStatement("select * from public.city c,public.area a where a.city_id=c.city_id");
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					area_id=rs.getInt("area_id");
					pincode=rs.getInt("pincode");
					area_name=rs.getString("area_name");
					c_name=rs.getString("city_name");
					
					System.out.println("id::"+area_id+ "  "+ "Area::" + area_name+ " "+ "Pincode::" + pincode + " " + "City name::"+ c_name);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}//display
	
	public static boolean area_insert()
	{
		Connection conn=Dbconnection.getDbConnection();
		ResultSet rs=null;
		int result;
		PreparedStatement pstmt=null;
		int city_id=0;
		int flag=0;
		int pincode=0;
		String city_name=new String();
		String area_name1=new String();
		String area_name=new String();
		boolean status=false;
		Scanner sc=new Scanner(System.in);
		
		
		
		
		if(conn!=null)
		{
			try 
			{	
				System.out.print("Enter Area Name::");
				area_name=sc.next();
				
				System.out.print("Enter City Name::");
				city_name=sc.next();
				
									
						pstmt=conn.prepareStatement("select city_id from public.city where city_name="+"'"+city_name+"'");
						rs=pstmt.executeQuery();
					
						while(rs.next())
						{
							//country_id=rs.getInt("country_id");
							city_id=rs.getInt("city_id");
						
						}
						pstmt=conn.prepareStatement("insert into area(area_name,pincode,city_id) values(?,?,?)");
						
						pstmt.setString(1,area_name);
						pstmt.setInt(2,pincode);
						
						pstmt.setInt(3,city_id);
					
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
					
				
				//else
				//{
					//System.out.println(area_name+ " already exist");
				//}
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return status;
	}//insert
	
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println("1 for area display");
		System.out.println("2 for Area Insert");
		
	
		
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
			area_display();
			break;
		case 2:
			area_insert();
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
	



