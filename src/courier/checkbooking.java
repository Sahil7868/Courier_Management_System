package courier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Date;




public class checkbooking {

	
	public static boolean c_update()
	{
		Connection conn=Dbconnection.getDbConnection();
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		ResultSet rs3=null;
		ResultSet rs4=null;
		ResultSet rs5=null;
		ResultSet rs6=null;
		int result;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		PreparedStatement pstmt4=null;
		PreparedStatement pstmt5=null;
		PreparedStatement pstmt6=null;
		PreparedStatement pstmt7=null;
		PreparedStatement pstmt8=null;
		PreparedStatement pstmt9=null;
		
	
		int state_id=0;
		int flag=0;
		int pincode1;
	  String mob=new String();;
		String email_id=new String();
		String email_id1=new String();
		String status1=new String();

		String pass=new String();
		String pass1=new String();
		String gen=new String();
		String ad=new String();
		String area=new String();
		int area_id1=0;
		int ad_id1=0;
		int eq=0;
		int eq1=0;
		int eq2=0;
		int eq3=0;
		Date date1=new Date();
		String d="delivered";
		String b="booked";
		String desi=new String();
		String state_name=new String();
		String c_name=new String();
		boolean status=false;
		Scanner sc=new Scanner(System.in);
		
		
	
		
		
		
		if(conn!=null)
		{
			try 
			{	
				
				
				System.out.print("Enter Couirer Id You want to update::");
				eq3=Integer.parseInt(sc.nextLine());
				
				System.out.print("Enter The Status You Want to update::");
				status1=sc.nextLine();
				
			
			
		
				
				
				
				
					if(status1.equals(d))
					{
						pstmt2=conn.prepareStatement("update courier set status="+"'"+b+"' where courier_id="+eq3);
						pstmt2.executeUpdate();
						
						pstmt3=conn.prepareStatement("update shippment set status="+"'"+status1+"' where courier_id="+eq3);
						int results=pstmt3.executeUpdate();
						
						if(results>0)
						{
							System.out.println("Updated");
						}
						else
						{
							System.out.println("Not Updated");
						}
					}
					else
					{
						pstmt3=conn.prepareStatement("update shippment set status="+"'"+status1+"' where courier_id="+eq3);
						int results=pstmt3.executeUpdate();
						
						if(results>0)
						{
							System.out.println("Updated");
						}
						else
						{
							System.out.println("Not Updated");
						}
					}
				
						
						
						
						
								} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return status;
	}//insert
	
	public static void display()
	{
		Connection conn=Dbconnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		int courier_id;
		String city_name=new String();
		
		String address=new String();
		String Email=new String();
		String weight=new String();
		String date1=new String();
		String s=new String();
		
		if(conn!=null)
		{
			try 
			{
				
				pstmt=conn.prepareStatement("select * from public.courier s, public.address a,public.customer cs where s.address=a.address_id and s.cust_id=cs.cust_id and s.status='pending'");
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					courier_id=rs.getInt("courier_id");
					city_name=rs.getString("name1");
					Email=rs.getString("Email_id");
					weight=rs.getString("weight");
					date1=rs.getString("date1");
					s=rs.getString("status");
					
					System.out.println(" "+ "id::"+courier_id+"\t");
					System.out.println("  "+ "Receiver Name::" + city_name+"\t");
					System.out.println("  "+ "Sender Email::" + Email+"\t");
					System.out.println(" "+ "Weight::"+ weight+"\t");
					System.out.println(" "+ "date::"+ date1+"\t");
					System.out.println(" "+ "Status::"+ s+"\t");
				
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}//display
	
	
	
	public static void main(String[] args) {
		
		System.out.println("1 for Status Updating");
		System.out.println("2 for Display Booking");
		
	//	System.out.println("2 for Employee Insert");
		
	
		
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
			c_update();
			break;
		case 2:
			display();
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

