package Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.Scanner;

abstract class Person
{
	private String name;
	private String mobilenumber;
	private String emailid;
	private String gender;
	private String dob;
	private String address;
	public Person(String name,String mobilenumber,String emailid,String gender,String dob,String address)
	{
		this.name=name;
		this.mobilenumber=mobilenumber;
		this.emailid=emailid;
		this.gender=gender;
		this.dob=dob;
		this.address=address;
	}
	public Person()
	{
		
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public String getname()
	{
		return name;
	}
	public void setmobilenumber(String mobilenumber)
	{
		this.mobilenumber=mobilenumber;	
	}
	public String getmobilenumber()
	{
		return mobilenumber;
	}
	public void setemailid(String emailid)
	{
		this.emailid=emailid;
	}
	public String getemailid()
	{
		return emailid;
	}
	public void setgender(String gender)
	{
		this.gender=gender;
	}
	public String getgender()
	{
		return gender;
	}
	public void setdob(String dob)
	{
		this.dob=dob;
	}
	public String getdob()
	{
		return dob;
	}
	public void setaddress(String address)
	{
		this.address=address;	
	}
	public String getaddress()
	{
		return address;
	}
	public abstract void display();
}
class Student extends Person
{
	private String id;
	private String rollnumber;
	private String fathername;
	private String mothername;
	private String course;
	private String branch;
	public Student(String name,String mobilenumber,String emailid,String gender,String dob,String address ,String id,String rollnumber,String fathername,String mothername,String course,String branch)
	{
		super(name,mobilenumber,emailid,gender,dob,address);
		this.id=id;
		this.rollnumber=rollnumber;
		this.fathername=fathername;
		this.mothername=mothername;
		this.course=course;
		this.branch=branch;
	}
	public Student()
	{
		super();
	}
	public void setid(String id)
	{
		this.id=id;
	}
	public String getid()
	{
		return id;
	}
	public void setrollnumber(String rollnumber)
	{
		this.rollnumber=rollnumber;
	}
	public String getrollnumber()
	{
		return rollnumber;
	}
	public void setfathername(String fathername)
	{
		this.fathername=fathername;
	}
	public String getfathername()
	{
		return fathername;
	}
	public void setmothername(String mothername)
	{
		this.mothername=mothername;
	}
	public String getmothername()
	{
		return mothername;
	}
	public void setcourse(String course)
	{
		this.course=course;
	}
	public String getcourse()
	{
		return course;
	}
	public void setbranch(String branch)
	{
		this.branch=branch;
	}
	public String getbranch()
	{
		return branch;
	}
	
	public void display()
	{
		System.out.println("==========================STUDENT DETAILES=========================");
		System.out.println("");
		System.out.println("Name : "+getname());
		System.out.println("Gender : "+getgender());
		System.out.println("DOB : "+getdob());
		System.out.println("ID : "+getid());
		System.out.println("Address : "+getaddress());
		System.out.println("Roll Number : "+getrollnumber());
		System.out.println("Mobile Number : "+getmobilenumber());
		System.out.println("Email ID : "+getemailid());
		System.out.println("Course : "+getcourse());
		System.out.println("Branch : "+getbranch());
		System.out.println("Father Name : "+getfathername());
		System.out.println("Mother Name : "+getmothername());
		System.out.println("");
		System.out.println("====================================================================");
	}
	
}
interface Management
{
	void createaccount();
	void login();
	void addstudent();
	void viewstudent();
	void searchstudent();
	void updatestudent();
	void deletestudent();
	void markattendance();
	void viewattendance();
	void updateattendance();
	void addmarks();
	void viewmarks();
	void updatemarks();
	void generaterresult();
	void logout();
	void exit();
}
abstract class StudentManager implements Management
{
	
	Scanner sc=new Scanner(System.in);
	private String username;
	public void setusername(String username)
	{
		this.username=username;
	}
	public String getusername()
	{
		return username;
	}
	private String password;
	public void setpassword(String password)
	{
		this.password=password;
	}
	public String getpassword()
	{
		return password;
	}
	public void createaccount()
	{
		System.out.print("Enter UserName : ");
		String username=sc.next();
		
		setusername(username);
		
		System.out.print("Enter Password : ");
		String password=sc.next();
		
		setpassword(password);
		
		System.out.print("Confirm Password :");
		String confirmpassword=sc.next();
		
		if(!password.equals(confirmpassword))
		{
			System.out.println("Password Does Not Match...!!");
			return;
		}
		
		try
		{
			FileReader f=new FileReader("Account.txt");
			BufferedReader fw=new BufferedReader(f);
			boolean found=false;
			String line;
			while((line=fw.readLine())!=null)
			{
				if(line.equals("User Name : "+username))
				{
					String pass=fw.readLine();
					if(pass.equals("Password : "+password))
					{
						found=true;
						break;
					}
				}
			}
			fw.close();
			if(found)
			{
				System.out.println("Already Account Exist..!!");
				return;
			}
			
			System.out.print("Mobile Number : ");
			String mobilenumber=sc.next();
			
			System.out.print("Email ID : ");
			String emailid=sc.next();
			
			System.out.println("Account Created Successfully...");
			
			FileWriter file=new FileWriter("Account.txt",true);
			BufferedWriter bw=new BufferedWriter(file);
			bw.write("============================CREATE ACCOOUNT==========================="+"\n");
			bw.write("User Name : "+username+"\n");
			bw.write("Password : "+password+"\n");
			bw.write("Mobile Number : "+mobilenumber+"\n");
			bw.write("Email ID : "+emailid+"\n");
			bw.close();
		}
		catch(Exception ex)
		{
			
		}
	}
	public void login()
	{
		System.out.println("Enter Name : ");
		String name=sc.next();
		
		System.out.println("Password : ");
		String password=sc.next();
		
		try
		{
			FileReader f=new FileReader("Account.txt");
			BufferedReader fw=new BufferedReader(f);
			boolean found=false;
			String line;
			while((line=fw.readLine())!=null)
			{
				if(line.equals("User Name : "+name))
				{
					String pass=fw.readLine();
					if(pass.equals("Password : "+password))
					{
						found=true;
						break;
					}
				}
			}
			fw.close();
			if(found)
			{
				System.out.println("Login Successfully...");
				return;
			}
			else
			{
				System.out.println("Login Not Successfully...!!");
			}
		}
		catch(Exception ex)
		{
			
		}
	}
	
	public void addstudent()
	{
		
		
		System.out.print("Enter Roll Number : ");
		String rollnumber=sc.next();
		
		System.out.print("Enter  ID : ");
		String id=sc.next();
		
		try
		{
			FileReader fw=new FileReader("Student.txt");
			BufferedReader br=new BufferedReader(fw);
			String line;
			boolean found=false;
			while((line=br.readLine())!=null)
			{
				if(line.equals("Roll Number : "+rollnumber))
				{
					String id1=br.readLine();
					if(id1.equals("ID : "+id))
					{
						found=true;
						break;
					}
				}
			}
			br.close();
			if(found)
			{
				System.out.println("Student Already Exist...");
				return;
			}
			System.out.print("Enter Name : ");
			String name=sc.next();
			
			System.out.print("Enter Gender : ");
			String gender=sc.next();
			
			System.out.print("Enter DOB : ");
			String dob=sc.next();
			
			System.out.print("Enter Address : ");
			String address=sc.next();
			
			System.out.print("Enter Mobile Number : ");
			String mobilenumber=sc.next();
			
			System.out.print("Enter Email ID : ");
			String emailid=sc.next();
			
			System.out.print("Enter Father Name : ");
			String fathername=sc.next();
			
			System.out.print("Enter Mother Name : ");
			String mothername=sc.next();
			
			System.out.print("Enter Course : ");
			String course=sc.next();
			
			System.out.print("Enter Branch : ");
			String branch=sc.next();
			
			Student pro = new Student(name,mobilenumber,emailid,gender,dob,address,id,rollnumber,fathername,mothername,course,branch);
			pro.display();
			
			FileWriter file=new FileWriter("Student.txt",true);
			BufferedWriter gr=new BufferedWriter(file);
			gr.write("===============================STUDENT DETAILS========================"+"\n");
			pro.setname(name);
			gr.write("Name : "+pro.getname()+"\n");
			pro.setgender(gender);
			gr.write("Gender : "+pro.getgender()+"\n");
			pro.setdob(dob);
			gr.write("DOB : "+pro.getdob()+"\n");
			pro.setmobilenumber(mobilenumber);
			gr.write("Mobile Number : "+pro.getmobilenumber()+"\n");
			pro.setaddress(address);
			gr.write("Address : "+pro.getaddress()+"\n");
			pro.setrollnumber(rollnumber);
			gr.write("Roll Number : "+pro.getrollnumber()+"\n");
			pro.setemailid(emailid);
			gr.write("Email ID : "+pro.getemailid()+"\n");
			pro.setid(id);
			gr.write("ID : "+pro.getid()+"\n");
			pro.setcourse(course);
			gr.write("Course : "+pro.getcourse()+"\n");
			pro.setbranch(branch);
			gr.write("Branch : "+pro.getbranch()+"\n");
			pro.setfathername(fathername);
			gr.write("Father Name : "+pro.getfathername()+"\n");
			pro.setmothername(mothername);
			gr.write("Mother Name : "+pro.getmothername()+"\n");
			gr.write("=====================================================================");
			gr.close();
		}
		catch(Exception ex)
		{
			
		}
	}
	public void viewstudent()
	{
		try
		{
			FileReader file=new FileReader("Student.txt");
			BufferedReader br=new BufferedReader(file);
			String line=br.readLine();
			if(line==null)
			{
				System.out.println("File is Empty...!");
				return;
			}
			String line1;
			System.out.println("======================VIEW STUDENTS========================");
			System.out.println(line);
			while((line1=br.readLine())!=null)
			{
				System.out.println(line1);
			}
			br.close();
		}
		catch(Exception ex)
		{
			
		}
	}
	public void searchstudent()
	{
		Student pr=new Student();
		System.out.print("Enter Roll Number : ");
		String rollnumber1=sc.next();
		
		System.out.print("Enter  ID : ");
		String id1=sc.next();
		
		try
		{
			FileReader fw=new FileReader("Student.txt");
			BufferedReader br=new BufferedReader(fw);
			boolean found =false;
			String name;
			while((name=br.readLine())!=null)
			{
				String gender=br.readLine();
				String dob=br.readLine();
				String mobilenumber=br.readLine();
				String address=br.readLine();
				String rollnumber=br.readLine();
				String emailid=br.readLine();
				String id=br.readLine();
				String course=br.readLine();
				String branch=br.readLine();
				String fathername=br.readLine();
				String mothername=br.readLine();
				br.readLine();
				if(rollnumber.equals("Roll Number : "+rollnumber1) && id.equals("ID : "+id1))
				{
					found=true;
					System.out.println("==================STUDENT DETAILS==================");
					System.out.println(name);
					System.out.println(gender);
					System.out.println(dob);
					System.out.println(mobilenumber);
					System.out.println(address);
					System.out.println(rollnumber);
					System.out.println(emailid);
					System.out.println(id);
					System.out.println(course);
					System.out.println(branch);
					System.out.println(fathername);
					System.out.println(mothername);
					System.out.println("");
				}
				if(!false)
				{
					System.out.println("Student not found...!!");
				}
			}
			
		}
		catch(Exception ex)
		{
			
		}
	}
	public void updatestudent()
	{
	    System.out.print("Enter Roll Number : ");
	    String rollnumber = sc.next();

	    System.out.print("Enter ID : ");
	    String id = sc.next();

	    try
	    {
	        FileReader fr = new FileReader("Student.txt");
	        BufferedReader br = new BufferedReader(fr);

	        FileWriter fw = new FileWriter("TempStudent.txt");
	        BufferedWriter bw = new BufferedWriter(fw);

	        boolean found = false;

	        String heading;

	        while((heading = br.readLine()) != null)
	        {
	            String name = br.readLine();
	            String gender = br.readLine();
	            String dob = br.readLine();
	            String mobile = br.readLine();
	            String address = br.readLine();
	            String roll = br.readLine();
	            String email = br.readLine();
	            String id1 = br.readLine();
	            String course = br.readLine();
	            String branch = br.readLine();
	            String father = br.readLine();
	            String mother = br.readLine();
	            String last = br.readLine();

	            if(roll.equals("Roll Number : " + rollnumber)
	                    && id1.equals("ID : " + id))
	            {
	                found = true;

	                Student pro = new Student();

	                System.out.println("=========== UPDATE STUDENT ===========");

	                System.out.print("Enter Name : ");
	                pro.setname(sc.next());

	                System.out.print("Enter Gender : ");
	                pro.setgender(sc.next());

	                System.out.print("Enter DOB : ");
	                pro.setdob(sc.next());

	                System.out.print("Enter Mobile Number : ");
	                pro.setmobilenumber(sc.next());

	                System.out.print("Enter Address : ");
	                pro.setaddress(sc.next());

	                System.out.print("Enter Roll Number : ");
	                pro.setrollnumber(sc.next());

	                System.out.print("Enter Email ID : ");
	                pro.setemailid(sc.next());

	                System.out.print("Enter ID : ");
	                pro.setid(sc.next());

	                System.out.print("Enter Course : ");
	                pro.setcourse(sc.next());

	                System.out.print("Enter Branch : ");
	                pro.setbranch(sc.next());

	                System.out.print("Enter Father Name : ");
	                pro.setfathername(sc.next());

	                System.out.print("Enter Mother Name : ");
	                pro.setmothername(sc.next());

	                bw.write(heading + "\n");
	                bw.write("Name : " + pro.getname() + "\n");
	                bw.write("Gender : " + pro.getgender() + "\n");
	                bw.write("DOB : " + pro.getdob() + "\n");
	                bw.write("Mobile Number : " + pro.getmobilenumber() + "\n");
	                bw.write("Address : " + pro.getaddress() + "\n");
	                bw.write("Roll Number : " + pro.getrollnumber() + "\n");
	                bw.write("Email ID : " + pro.getemailid() + "\n");
	                bw.write("ID : " + pro.getid() + "\n");
	                bw.write("Course : " + pro.getcourse() + "\n");
	                bw.write("Branch : " + pro.getbranch() + "\n");
	                bw.write("Father Name : " + pro.getfathername() + "\n");
	                bw.write("Mother Name : " + pro.getmothername() + "\n");
	                bw.write(last + "\n");
	            }
	            else
	            {
	                bw.write(heading + "\n");
	                bw.write(name + "\n");
	                bw.write(gender + "\n");
	                bw.write(dob + "\n");
	                bw.write(mobile + "\n");
	                bw.write(address + "\n");
	                bw.write(roll + "\n");
	                bw.write(email + "\n");
	                bw.write(id1 + "\n");
	                bw.write(course + "\n");
	                bw.write(branch + "\n");
	                bw.write(father + "\n");
	                bw.write(mother + "\n");
	                bw.write(last + "\n");
	            }
	        }

	        br.close();
	        bw.close();

	        File oldFile = new File("Student.txt");
	        File newFile = new File("TempStudent.txt");

	        if(oldFile.delete())
	        {
	            newFile.renameTo(oldFile);
	        }

	        if(found)
	        {
	            System.out.println("Student Updated Successfully...");
	        }
	        else
	        {
	            System.out.println("Student Not Found...!!");
	        }
	    }
	    catch(Exception ex)
	    {
	        ex.printStackTrace();
	    }
	}
	
	public void deletestudent()
	{
		System.out.print("Enter Roll Number : ");
	    String rollnumber = sc.next();

	    System.out.print("Enter ID : ");
	    String id = sc.next();

	    try
	    {
	        FileReader fr = new FileReader("Student.txt");
	        BufferedReader br = new BufferedReader(fr);

	        FileWriter fw = new FileWriter("TempStudent.txt");
	        BufferedWriter bw = new BufferedWriter(fw);

	        boolean found = false;

	        String line;

	        while((line= br.readLine()) != null)
	        {
	            String name = br.readLine();
	            String gender = br.readLine();
	            String dob = br.readLine();
	            String mobile = br.readLine();
	            String address = br.readLine();
	            String roll = br.readLine();
	            String email = br.readLine();
	            String id1 = br.readLine();
	            String course = br.readLine();
	            String branch = br.readLine();
	            String father = br.readLine();
	            String mother = br.readLine();
	            String last = br.readLine();

	            if(roll.equals("Roll Number : " + rollnumber)
	                    && id1.equals("ID : " + id))
	            {
	                found = true;
	                continue;
	            }

	            bw.write(line + "\n");
	            bw.write(name + "\n");
	            bw.write(gender + "\n");
	            bw.write(dob + "\n");
	            bw.write(mobile + "\n");
	            bw.write(address + "\n");
	            bw.write(roll + "\n");
	            bw.write(email + "\n");
	            bw.write(id1 + "\n");
	            bw.write(course + "\n");
	            bw.write(branch + "\n");
	            bw.write(father + "\n");
	            bw.write(mother + "\n");
	            bw.write(last + "\n");
	        }

	        br.close();
	        bw.close();

	        File oldFile = new File("Student.txt");
	        File newFile = new File("TempStudent.txt");

	        oldFile.delete();
	        newFile.renameTo(oldFile);

	        if(found)
	            System.out.println("Student Deleted Successfully...");
	        else
	            System.out.println("Student Not Found...!!");
	    }
	    catch(Exception ex)
	    {
	        
	    }
	}
	public void markattendance()
	{
	    System.out.print("Enter Roll Number : ");
	    String rollnumber = sc.next();

	    System.out.print("Enter ID : ");
	    String id = sc.next();

	    try
	    {
	        FileReader fr = new FileReader("Student.txt");
	        BufferedReader br = new BufferedReader(fr);

	        boolean found = false;

	        String line;

	        while((line = br.readLine()) != null)
	        {
	            String name = br.readLine();
	            String gender = br.readLine();
	            String dob = br.readLine();
	            String mobile = br.readLine();
	            String address = br.readLine();
	            String roll = br.readLine();
	            String email = br.readLine();
	            String id1 = br.readLine();

	            if(roll.equals("Roll Number : " + rollnumber)
	                    && id1.equals("ID : " + id))
	            {
	                found = true;

	                System.out.print("Enter Date (dd/mm/yyyy) : ");
	                String date = sc.next();

	                System.out.print("Enter Status (Present/Absent) : ");
	                String status = sc.next();

	                FileWriter fw = new FileWriter("Attendance.txt", true);
	                BufferedWriter bw = new BufferedWriter(fw);

	                bw.write("=====================ATTENDANCE=====================\n");
	                bw.write("Roll Number : "+roll + "\n");
	                bw.write("ID : "+id1 + "\n");
	                bw.write(name + "\n");
	                bw.write("Date : " + date + "\n");
	                bw.write("Status : " + status + "\n");
	                bw.write("===================================================\n");

	                bw.close();

	                System.out.println("Attendance Marked Successfully...");
	                break;
	            }
	        }

	        br.close();

	        if(!found)
	        {
	            System.out.println("Student Not Found...!!");
	        }
	    }
	    catch(Exception ex)
	    {
	        ex.printStackTrace();
	    }
	}
}
public class Student_Management_System 
{
	public static void main(String[]args)
	{
		
	}
}
