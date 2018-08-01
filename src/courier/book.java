package courier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Date;



public class book {

	
	public static boolean c_insert()
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
		String custname=new String();

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
		String city_name=new String();
		String desi=new String();
		String state_name=new String();
		String c_name=new String();
		boolean status=false;
		Scanner sc=new Scanner(System.in);
		
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localdate=LocalDate.now();
		
		
		
		if(conn!=null)
		{
			try 
			{	
				System.out.print("Enter Name Whom you want to deliver::");
				custname=sc.nextLine();
				
				System.out.print("Enter your Email_id::");
				email_id=sc.nextLine();
				
				System.out.print("Enter Weight of your courier::");
				pass=sc.nextLine();
				
				
				System.out.print("Enter mobile number::");
				mob=sc.nextLine();
				
			
				
				System.out.print("Enter Your Address::");
				ad=sc.nextLine();
				
				System.out.print("Enter Area Name::");
				area=sc.nextLine();
			
				
		
				
				
				
				
					
					pstmt1=conn.prepareStatement("select area_id from public.area where area_name="+"'"+area+"'");
					rs=pstmt1.executeQuery();
					
					
						while(rs.next())
						{
							
							area_id1=rs.getInt("area_id");
						
						}
						
						
						pstmt2=conn.prepareStatement("insert into address(address,area_id) values(?,?)");
						
						pstmt2.setString(1,ad);
						
						pstmt2.setInt(2,area_id1);
						int results=pstmt2.executeUpdate();
						
						pstmt2=conn.prepareStatement("select address_id from public.address where address="+"'"+ad+"'");
						rs1=pstmt2.executeQuery();
						
							while(rs1.next())
							{
								
								ad_id1=rs1.getInt("address_id");
							
							}
							pstmt4=conn.prepareStatement("select cust_id from public.customer where email_id="+"'"+email_id+"'");
							rs2=pstmt4.executeQuery();
							
								while(rs2.next())
								{
									
									eq=rs2.getInt("cust_id");
								
								}
					
						pstmt3=conn.prepareStatement("insert into courier(name1,address,mobile_num,weight,cust_id,date1,status) values(?,?,?,?,?,?,?)");
						
						pstmt3.setString(1,custname);
						pstmt3.setInt(2,ad_id1);
						pstmt3.setString(3,mob);
						pstmt3.setString(4,pass);
						pstmt3.setInt(5,eq);
						pstmt3.setString(6,dtf.format(localdate).toString());
						pstmt3.setString(7,"pending");
						
						
						result=pstmt3.executeUpdate();
						if(result>0)
						{
							System.out.println("-----------Inserted ---------");
							status=true;
						}
						else
						{
							System.out.println("-----------Insertion Fail ---------");
						}
					
					
					
							pstmt8=conn.prepareStatement("select courier_id from public.courier where address="+ad_id1);
							rs5=pstmt8.executeQuery();
							
								while(rs5.next())
								{
									
									eq2=rs5.getInt("courier_id");
								
								}
							
							pstmt6=conn.prepareStatement("insert into shippment(courier_id,address_id,weight,cust_id,status) values(?,?,?,?,?)");
							
						
							pstmt6.setInt(1,eq2);
							pstmt6.setInt(2,ad_id1);
							pstmt6.setString(3,pass);
							pstmt6.setInt(4,eq);
							pstmt6.setString(5,"Booking confirm");
							pstmt6.executeUpdate();
							
							System.out.println("Your Booking Id is:: "+eq2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return status;
	}//insert
	
	public static boolean cancel()
	{
		Connection conn=Dbconnection.getDbConnection();
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		int id;
		int id1=0;
		int flag=0;
		int status1;
		boolean status=false;
		
		Scanner sc1=new Scanner(System.in);
		
	
		
		if(conn!=null)
		{
			try 
			{	
				System.out.println("Enter Your Booking Id");
				id=sc1.nextInt();
				pstmt1=conn.prepareStatement("select courier_id from public.courier where courier_id="+id);
				rs1=pstmt1.executeQuery();
				
					while(rs1.next())
					{
						
						id1=rs1.getInt("courier_id");
					
					}
				if(id1==id)
				{
				pstmt2=conn.prepareStatement("Delete from public.courier where courier_id="+id);
				pstmt2.executeUpdate();
				
				pstmt3=conn.prepareStatement("Delete from public.shippment where courier_id="+id);
				status1=pstmt3.executeUpdate();
				if(status1>0)
				{
					System.out.println("Booking cancel successfully");
					status=true;
				}
				else
				{
					System.out.println("Check Your Connection");
				}
				flag=1;
				}
				if(flag==0)
				{
					System.out.println("You have Entered Wrong Booking Id");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return status;
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println("1 for Booking");
		System.out.println("2 for Cancelling");
		
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
			c_insert();
			break;
		case 2:
			cancel();
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

