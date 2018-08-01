package courier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class emp {

	public static void emp_display()
	{
		Connection conn=Dbconnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		int cust_id;
		int pincode;
		String mob=new String();
		String email_id=new String();
		String custname=new String();
		String desi=new String();
		String gen=new String();
		String ad=new String();
		String area=new String();
		String city_name=new String();
		String state_name=new String();
		
		String c_name=new String();
		
		if(conn!=null)
		{
			try 
			{
				
				pstmt=conn.prepareStatement("select * from public.employee v,public.state s,public.city c,public.area a,public.address ad,public.country cs where v.address_id=ad.address_id and ad.area_id=a.area_id and a.city_id=c.city_id and c.state_id=s.state_id and s.country_id=cs.country_id");
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					custname=rs.getString("name1");
					email_id=rs.getString("email_id");
					gen=rs.getString("gender");
					ad=rs.getString("address");
					desi=rs.getString("designation");
					area=rs.getString("area_name");
					pincode=rs.getInt("pincode");
					mob=rs.getString("mobile_num");
					cust_id=rs.getInt("emp_id");
					city_name=rs.getString("city_name");
					state_name=rs.getString("state_name");
					c_name=rs.getString("country_name");
					
					System.out.println("id::"+cust_id+"\t");
					System.out.println("  "+ "Employee name::" + custname+"\t");
					System.out.println(" "+ "Gender::"+ gen+"\t");
					System.out.println(" "+ "Designation::"+ desi+"\t");
					System.out.println(" "+ "Address::"+ ad+"\t");
					System.out.println(" "+ "Area::"+ area+"\t");
					System.out.println(" "+ "Pincode::"+ pincode+"\t");
					System.out.println(" "+ "City::"+ city_name+"\t");
					System.out.println(" "+ "State::"+ state_name+"\t");
					System.out.println(" "+ "country::"+ c_name+"\t");
					System.out.println(" "+ "Mobile_num::"+ mob+"\t");
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}//display
	
	public static boolean emp_insert()
	{
		Connection conn=Dbconnection.getDbConnection();
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
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
		String custname=new String();

		String pass=new String();
		String pass1=new String();
		String gen=new String();
		String ad=new String();
		String area=new String();
		int area_id1=0;
		int ad_id1=0;
		String city_name=new String();
		String desi=new String();
		String state_name=new String();
		String c_name=new String();
		boolean status=false;
		Scanner sc=new Scanner(System.in);
		
		
		
		
		if(conn!=null)
		{
			try 
			{	
				System.out.print("Enter Name::");
				custname=sc.nextLine();
				
				System.out.print("Enter Email_id::");
				email_id=sc.nextLine();
				
				System.out.print("Enter Password::");
				pass=sc.nextLine();
				
				System.out.print("ReEnter Password::");
				pass1=sc.nextLine();
				
				System.out.print("Enter mobile number::");
				mob=sc.nextLine();
				
				System.out.print("Enter gender::");
				gen=sc.nextLine();
				
				System.out.print("Enter Employees Designation ::");
				desi=sc.nextLine();
				
				System.out.print("Enter Your Address::");
				ad=sc.nextLine();
				
				System.out.print("Enter Area Name::");
				area=sc.nextLine();
			
				pstmt=conn.prepareStatement("select email_id from public.employee");
				rs=pstmt.executeQuery();
				while(rs.next())
				{

					email_id1=rs.getString("email_id");
					

				
				if(email_id1.equals(email_id))
				{
					
					flag=1;
					
				}
				
				
				
				}
				if(flag==0)
				{
					if(pass.equals(pass1))
					{
					pstmt1=conn.prepareStatement("select area_id from public.area where area_name="+"'"+area+"'");
					rs=pstmt1.executeQuery();
					
					
						while(rs.next())
						{
							
							area_id1=rs.getInt("area_id");
						
						}
						
						
						pstmt2=conn.prepareStatement("insert into address(address,area_id) values(?,?)");
						
						pstmt2.setString(1,ad);
						//pstmt.setInt(2,pincode1);
						pstmt2.setInt(2,area_id1);
						int results=pstmt2.executeUpdate();
						
						pstmt2=conn.prepareStatement("select address_id from public.address where address="+"'"+ad+"'");
						rs1=pstmt2.executeQuery();
						
							while(rs1.next())
							{
								
								ad_id1=rs1.getInt("address_id");
							
							}
					
						pstmt3=conn.prepareStatement("insert into employee(name1,mobile_num,email_id,gender,password1,designation,address_id,foffice_id,roffice_id) values(?,?,?,?,?,?,?,?,?)");
						
						pstmt3.setString(1,custname);
						pstmt3.setString(2,mob);
						pstmt3.setString(3,email_id);
						pstmt3.setString(4,gen);
						pstmt3.setString(5,pass);
						pstmt3.setString(6,desi);
						pstmt3.setInt(7,ad_id1);
						pstmt3.setInt(8,1);
						pstmt3.setInt(9,1);
						
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
					}
					else
					{
						System.out.println("Your Password does not match");
					}
				}
				else
				{
					System.out.println(email_id+ " already exist");
				}
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return status;
	}//insert
	
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println("1 for Employee display");
		System.out.println("2 for Employee Insert");
		
	
		
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
			emp_display();
			break;
		case 2:
			emp_insert();
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

