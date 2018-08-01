package courier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Date;




public class tracking {

	
	public static boolean c_update()
	{
		Connection conn=Dbconnection.getDbConnection();
		ResultSet rs=null;
		ResultSet rs1=null;
	
		int result;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
	
		
	
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
		String s=new String();
		String c_name=new String();
		boolean status=false;
		Scanner sc=new Scanner(System.in);
		
		
	
		
		
		
		if(conn!=null)
		{
			try 
			{	
				
				
				System.out.print("Enter Booking Id to check status::");
				eq3=Integer.parseInt(sc.nextLine());
				
			
				pstmt=conn.prepareStatement("select * from public.shippment where courier_id="+eq3);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					s=rs.getString("status");
					
		
					System.out.println(" "+ "Status::"+ s+"\t");
				
				}
	
			
			
		
				
				
				
				
							
						
						
						
								} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return status;
	}//insert
	
	
	
	public static void main(String[] args) {
		
		System.out.println("1 for Check Status");
		
		
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


