package courier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class login {

	public static void admin_login()
	{
		Connection conn=Dbconnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		int flag=0;
		String email_id=new String();
		
		String pass=new String();
		String nameji=new String();
String email_id1=new String();
		
		String pass1=new String();
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter Your Email::");
		email_id1=sc.next();
		
		System.out.print("Enter Your Password::");
		pass1=sc.next();
		
		if(conn!=null)
		{
			try 
			{
				
				pstmt=conn.prepareStatement("select * from public.admin");
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					email_id=rs.getString("email_id");
					pass=rs.getString("password1");
					nameji=rs.getString("name1");
										
					if(email_id.equals(email_id1) && pass.equals(pass1))
					{
						System.out.println("Welcome "+nameji);
						flag=1;
					}
					
				}
			if(flag==0)
			{
				System.out.println("Check your Email or Password");
			}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}//display
	
	public static void emp_login()
	{
		Connection conn=Dbconnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		int flag=0;
		String email_id=new String();
		
		String pass=new String();
		String nameji=new String();
String email_id1=new String();
		
		String pass1=new String();
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter Your Email::");
		email_id1=sc.next();
		
		System.out.print("Enter Your Password::");
		pass1=sc.next();
		
		if(conn!=null)
		{
			try 
			{
				
				pstmt=conn.prepareStatement("select * from public.employee");
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					email_id=rs.getString("email_id");
					pass=rs.getString("password1");
					nameji=rs.getString("name1");
										
					if(email_id.equals(email_id1) && pass.equals(pass1))
					{
						System.out.println("Welcome "+nameji);
						flag=1;
					}
					
				}
			if(flag==0)
			{
				System.out.println("Check your email or Password");
			}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}//display
	
	
	
	public static void cust_login()
	{
		Connection conn=Dbconnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		int flag=0;
		String email_id=new String();
		
		String pass=new String();
		String nameji=new String();
String email_id1=new String();
		
		String pass1=new String();
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter Your Email::");
		email_id1=sc.next();
		
		System.out.print("Enter Your Password::");
		pass1=sc.next();
		
		if(conn!=null)
		{
			try 
			{
				
				pstmt=conn.prepareStatement("select * from public.customer");
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					email_id=rs.getString("email_id");
					pass=rs.getString("password1");
					nameji=rs.getString("name1");
										
					if(email_id.equals(email_id1) && pass.equals(pass1))
					{
						System.out.println("Welcome "+nameji);
						flag=1;
					}
					
				}
			if(flag==0)
			{
				System.out.println("Check your Email or Password");
			}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}//display
	
	
	
	public static void main(String[] args) {
		
		System.out.println("1 for login as Admin");
		System.out.println("2 for login as Employee");
		System.out.println("3 for login as Customer");
		
	
		
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
			admin_login();
			break;
		case 2:
			emp_login();
			break;
		case 3:
			cust_login();
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
	



