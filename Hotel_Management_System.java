package Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

interface HotelOperation
{
	void createAccount();
	boolean login();
	void addRoom();
	void viewRooms();
	void searchRoom();
	void bookRoom();
	void cancelBooking();
	void updateRoom();
	void deleteRoom();
	void checkIn();
	void checkOut();
	void generateBill();
	void payment();
	void viewCustomerDetails();
	void viewAllBookings();
	void logout();
	void exit();
}

class VipinGupta implements HotelOperation
{
	@Override
	public void createAccount()
	{
	    Scanner sc = new Scanner(System.in);

	    try
	    {
	        FileWriter fw = new FileWriter("Account.txt", true);
	        BufferedWriter bw = new BufferedWriter(fw);

	        System.out.println("\n========== CREATE ACCOUNT ==========");

	        System.out.print("Enter Name : ");
	        String name = sc.nextLine();

	        System.out.print("Enter Mobile Number : ");
	        String mobileNumber = sc.nextLine();

	        System.out.print("Enter Address : ");
	        String address = sc.nextLine();
	        
	        System.out.print("Enter Password : ");
	        String password = sc.nextLine();

	        bw.write("Name : "+name + "\n"+"Mobile Number :  " + mobileNumber + "\n"+"Address : " + address +"\n"+"Password : " + password);
	        bw.newLine();
	        bw.write("--------------------------------");
	        bw.newLine();

	        bw.close();
	        fw.close();

	        System.out.println("\nAccount Created Successfully...");
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error : " + e.getMessage());
	    }
	}
	@Override
	public boolean login()
	{
	    Scanner sc = new Scanner(System.in);

	    System.out.println("\n========== LOGIN ==========");

	    // Fixed Admin name & Password
	    String adminName = "Vipin kumar";
	    String adminPassword = "1234";

	    System.out.print("Enter Name : ");
	    String name = sc.nextLine();

	    System.out.print("Enter Password : ");
	    String password = sc.nextLine();

	    if(name.equals(adminName) && password.equals(adminPassword))
	    {
	        System.out.println("\nLogin Successfully...");
	        return true;
	    }
	    else
	    {
	        System.out.println("\nInvalid Username or Password...");
	        return false;
	    }
	}
	
	@Override
	public void addRoom()
	{
	    Scanner sc = new Scanner(System.in);

	    try
	    {
	        FileWriter fw = new FileWriter("Room.txt", true);
	        BufferedWriter bw = new BufferedWriter(fw);

	        System.out.println("\n========== ADD ROOM ==========");

	        System.out.print("Enter Room Number : ");
	        String roomNumber = sc.nextLine();

	        System.out.print("Enter Room Type : ");
	        String roomType = sc.nextLine();

	        System.out.print("Enter Category : ");
	        String category = sc.nextLine();

	        System.out.print("Enter Price Per Day : ");
	        String price = sc.nextLine();

	        System.out.print("Enter Bed Type : ");
	        String bedType = sc.nextLine();

	        System.out.println("BooKing ID : ");
	        String bookingid=sc.nextLine();
	        
	        bw.write("Room Number : " + roomNumber);
	        bw.newLine();

	        bw.write("Room Type : " + roomType);
	        bw.newLine();

	        bw.write("Category : " + category);
	        bw.newLine();

	        bw.write("Price Per Day : " + price);
	        bw.newLine();

	        bw.write("Bed Type : " + bedType);
	        bw.newLine();

	        bw.write("Status : Available");
	        bw.newLine();
	        
	        bw.write("Booking ID : "+bookingid);
	        bw.newLine();

	        bw.write("--------------------------------");
	        bw.newLine();

	        bw.close();
	        fw.close();

	        System.out.println("\nRoom Added Successfully...");
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error : " + e.getMessage());
	    }
	}

	@Override
	public void viewRooms()
	{
	    System.out.println("\n========== VIEW ALL ROOMS ==========");

	    boolean found = false;

	    try
	    {
	        FileReader fr = new FileReader("Room.txt");
	        BufferedReader br = new BufferedReader(fr);

	        String line;

	        while((line = br.readLine()) != null)
	        {
	            found = true;
	            System.out.println(line);
	        }

	        br.close();
	        fr.close();

	        if(found == false)
	        {
	            System.out.println("\nNo Room Available...");
	        }
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error : " + e.getMessage());
	    }
	}
	@Override
	public void searchRoom()
	{
	    Scanner sc = new Scanner(System.in);

	    System.out.print("Enter Room Number : ");
	    String roomNumber = sc.nextLine();

	    boolean found = false;

	    try
	    {
	        FileReader fr = new FileReader("Room.txt");
	        BufferedReader br = new BufferedReader(fr);

	        String line;

	        while((line = br.readLine()) != null)
	        {
	            if(line.equals("Room Number : " + roomNumber))
	            {
	                found = true;

	                System.out.println("\n========== ROOM FOUND ==========");
	               System.out.println(line);
	                for(int i = 1; i <= 6; i++)
	                {
	                    line = br.readLine();
	                    System.out.println(line);
	                    
	                }

	                break;
	            }
	        }

	        br.close();
	        fr.close();

	        if(!found)
	        {
	            System.out.println("\nRoom Not Found...");
	        }
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error : " + e.getMessage());
	    }
	}
	@Override
	public void bookRoom()
	{
	    Scanner sc = new Scanner(System.in);

	    System.out.println("\n========== BOOK ROOM ==========");

	    System.out.print("Enter Room Number : ");
	    String roomNumber = sc.nextLine();

	    boolean found = false;
	    boolean available = false;

	    try
	    {
	        FileReader fr = new FileReader("Room.txt");
	        BufferedReader br = new BufferedReader(fr);

	        String line;

	        while((line = br.readLine()) != null)
	        {
	            if(line.equals("Room Number : " + roomNumber))
	            {
	                found = true;

	                for(int i=1;i<=6;i++)
	                {
	                    line = br.readLine();

	                    if(line.equals("Status : Available"))
	                    {
	                        available = true;
	                    }
	                }

	                break;
	            }
	        }

	        br.close();
	        fr.close();

	        if(!found)
	        {
	            System.out.println("\nRoom Not Found...");
	            return;
	        }

	        if(!available)
	        {
	            System.out.println("\nRoom Already Booked...");
	            return;
	        }

	        System.out.print("Enter Booking ID : ");
	        String bookingId = sc.nextLine();

	        System.out.print("Enter Customer Name : ");
	        String customerName = sc.nextLine();

	        System.out.print("Enter Mobile Number : ");
	        String mobileNumber = sc.nextLine();

	        System.out.print("Enter Address : ");
	        String address = sc.nextLine();

	        System.out.print("Enter Check In Date (dd/MM/yyyy) : ");
	        String checkIn = sc.nextLine();

	        System.out.print("Enter Check Out Date (dd/MM/yyyy) : ");
	        String checkOut = sc.nextLine();

	        FileWriter fw = new FileWriter("Booking.txt",true);
	        BufferedWriter bw = new BufferedWriter(fw);

	        bw.write("Booking ID : " + bookingId);
	        bw.newLine();
	        bw.write("Customer Name : " + customerName);
	        bw.newLine();
	        bw.write("Mobile Number : " + mobileNumber);
	        bw.newLine();
	        bw.write("Address : " + address);
	        bw.newLine();
	        bw.write("Room Number : " + roomNumber);
	        bw.newLine();
	        bw.write("Check In Date : " + checkIn);
	        bw.newLine();
	        bw.write("Check Out Date : " + checkOut);
	        bw.newLine();
	        bw.write("Booking Status : Booked");
	        bw.newLine();
	        bw.write("--------------------------------");
	        bw.newLine();

	        bw.close();
	        fw.close();

	        FileReader fr1 = new FileReader("Room.txt");
	        BufferedReader br1 = new BufferedReader(fr1);

	        FileWriter fw1 = new FileWriter("TempRoom.txt");
	        BufferedWriter bw1 = new BufferedWriter(fw1);

	        while((line = br1.readLine()) != null)
	        {
	            if(line.equals("Room Number : " + roomNumber))
	            {
	                bw1.write(line);
	                bw1.newLine();

	                line = br1.readLine();
	                bw1.write(line);
	                bw1.newLine();

	                line = br1.readLine();
	                bw1.write(line);
	                bw1.newLine();

	                line = br1.readLine();
	                bw1.write(line);
	                bw1.newLine();

	                line = br1.readLine();
	                bw1.write(line);
	                bw1.newLine();

	                br1.readLine();

	                bw1.write("Status : Booked");
	                bw1.newLine();

	                line = br1.readLine();
	                bw1.write(line);
	                bw1.newLine();
	            }
	            else
	            {
	                bw1.write(line);
	                bw1.newLine();
	            }
	        }

	        br1.close();
	        bw1.close();
	        fr1.close();
	        fw1.close();

	        File file1 = new File("Room.txt");
	        File file2 = new File("TempRoom.txt");

	        file1.delete();
	        file2.renameTo(file1);

	        System.out.println("\nRoom Booked Successfully...");
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error : " + e.getMessage());
	    }
	}
	@Override
	public void cancelBooking()
	{
	    Scanner sc = new Scanner(System.in);

	    System.out.println("\n========== CANCEL BOOKING ==========");

	    System.out.print("Enter Booking ID : ");
	    String bookingId = sc.nextLine();

	    boolean found = false;
	    String roomNumber = "";

	    try
	    {
	        FileReader fr = new FileReader("Booking.txt");
	        BufferedReader br = new BufferedReader(fr);

	        String line;

	        while((line = br.readLine()) != null)
	        {
	            if(line.equals("Booking ID : " + bookingId))
	            {
	                found = true;

	                System.out.println("\n========== BOOKING FOUND ==========");

	                System.out.println(line);

	                for(int i = 1; i <= 8; i++)
	                {
	                    line = br.readLine();

	                    System.out.println(line);

	                    if(line != null && line.contains("Room Number : "))
	                    {
	                        roomNumber = line.replace("Room Number : ", "");
	                    }
	                }

	                break;
	            }
	        }

	        br.close();
	        fr.close();

	        if(!found)
	        {
	            System.out.println("\nBooking Not Found...");
	            return;
	        }
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error : " + e.getMessage());
	        return;
	    }

	
	    try
	    {
	        FileReader fr = new FileReader("Booking.txt");
	        BufferedReader br = new BufferedReader(fr);

	        FileWriter fw = new FileWriter("TempBooking.txt");
	        BufferedWriter bw = new BufferedWriter(fw);

	        String line;
	        boolean skip = false;

	        while((line = br.readLine()) != null)
	        {
	            if(line.equals("Booking ID : " + bookingId))
	            {
	                skip = true;
	                continue;
	            }

	            if(skip)
	            {
	                if(line.equals("--------------------------------"))
	                {
	                    skip = false;
	                }

	                continue;
	            }

	            bw.write(line);
	            bw.newLine();
	        }

	        br.close();
	        bw.close();
	        fr.close();
	        fw.close();

	        File file1 = new File("Booking.txt");
	        File file2 = new File("TempBooking.txt");

	        file1.delete();
	        file2.renameTo(file1);
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error : " + e.getMessage());
	        return;
	    }

	 
	    try
	    {
	        FileReader fr = new FileReader("Room.txt");
	        BufferedReader br = new BufferedReader(fr);

	        FileWriter fw = new FileWriter("TempRoom.txt");
	        BufferedWriter bw = new BufferedWriter(fw);

	        String line;

	        while((line = br.readLine()) != null)
	        {
	            if(line.equals("Room Number : " + roomNumber))
	            {
	                bw.write(line);
	                bw.newLine();

	                for(int i = 1; i <= 4; i++)
	                {
	                    line = br.readLine();
	                    bw.write(line);
	                    bw.newLine();
	                }

	                br.readLine();

	                bw.write("Status : Available");
	                bw.newLine();

	                line = br.readLine();
	                bw.write(line);
	                bw.newLine();
	            }
	            else
	            {
	                bw.write(line);
	                bw.newLine();
	            }
	        }

	        br.close();
	        bw.close();
	        fr.close();
	        fw.close();

	        File file1 = new File("Room.txt");
	        File file2 = new File("TempRoom.txt");

	        file1.delete();
	        file2.renameTo(file1);

	        System.out.println("\nBooking Cancelled Successfully...");
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error : " + e.getMessage());
	    }
	}
	@Override
	public void updateRoom()
	{
	    Scanner sc = new Scanner(System.in);

	    System.out.println("\n========== UPDATE ROOM ==========");

	    System.out.print("Enter Room Number : ");
	    String roomNumber = sc.nextLine();

	    boolean found = false;

	    try
	    {
	        FileReader fr = new FileReader("Room.txt");
	        BufferedReader br = new BufferedReader(fr);

	        FileWriter fw = new FileWriter("TempRoom.txt");
	        BufferedWriter bw = new BufferedWriter(fw);

	        String line;

	        while((line = br.readLine()) != null)
	        {
	            if(line.equals("Room Number : " + roomNumber))
	            {
	                found = true;

	                bw.write(line);
	                bw.newLine();

	                System.out.print("Enter New Room Type : ");
	                String roomType = sc.nextLine();

	                System.out.print("Enter New Category : ");
	                String category = sc.nextLine();

	                System.out.print("Enter New Price Per Day : ");
	                String price = sc.nextLine();

	                System.out.print("Enter New Bed Type : ");
	                String bedType = sc.nextLine();

	                br.readLine();   // Old Room Type
	                br.readLine();   // Old Category
	                br.readLine();   // Old Price
	                br.readLine();   // Old Bed Type
	                String status = br.readLine(); // Old Status

	                bw.write("Room Type : " + roomType);
	                bw.newLine();

	                bw.write("Category : " + category);
	                bw.newLine();

	                bw.write("Price Per Day : " + price);
	                bw.newLine();

	                bw.write("Bed Type : " + bedType);
	                bw.newLine();

	                bw.write(status);
	                bw.newLine();

	                line = br.readLine(); // -------------------
	                bw.write(line);
	                bw.newLine();
	            }
	            else
	            {
	                bw.write(line);
	                bw.newLine();
	            }
	        }

	        br.close();
	        bw.close();
	        fr.close();
	        fw.close();
	        
	        if(found)
	        {
	            File file1 = new File("Room.txt");
	            File file2 = new File("TempRoom.txt");

	            file1.delete();
	            file2.renameTo(file1);

	            System.out.println("\nRoom Updated Successfully...");
	        }
	        else
	        {
	            File file = new File("TempRoom.txt");

	            if(file.exists())
	            {
	                file.delete();
	            }

	            System.out.println("\nRoom Not Found...");
	        }
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error : " + e.getMessage());
	    }
	    }
	@Override
	public void deleteRoom()
	{
	    Scanner sc = new Scanner(System.in);

	    System.out.println("\n========== DELETE ROOM ==========");

	    System.out.print("Enter Room Number : ");
	    String roomNumber = sc.nextLine();

	    boolean found = false;

	    try
	    {
	        FileReader fr = new FileReader("Room.txt");
	        BufferedReader br = new BufferedReader(fr);

	        FileWriter fw = new FileWriter("TempRoom.txt");
	        BufferedWriter bw = new BufferedWriter(fw);

	        String line;
	        boolean skip = false;

	        while((line = br.readLine()) != null)
	        {
	            if(line.equals("Room Number : " + roomNumber))
	            {
	                found = true;
	                skip = true;
	                continue;
	            }

	            if(skip)
	            {
	                if(line.equals("--------------------------------"))
	                {
	                    skip = false;
	                }

	                continue;
	            }

	            bw.write(line);
	            bw.newLine();
	        }

	        br.close();
	        bw.close();
	        fr.close();
	        fw.close();
	        
	        if(found)
	        {
	            File file1 = new File("Room.txt");
	            File file2 = new File("TempRoom.txt");

	            file1.delete();
	            file2.renameTo(file1);

	            System.out.println("\nRoom Deleted Successfully...");
	        }
	        else
	        {
	            File file = new File("TempRoom.txt");

	            if(file.exists())
	            {
	                file.delete();
	            }

	            System.out.println("\nRoom Not Found...");
	        }
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error : " + e.getMessage());
	    }
	}
	@Override
	public void checkIn()
	{
	    Scanner sc = new Scanner(System.in);

	    System.out.println("\n========== CHECK IN ==========");

	    System.out.print("Enter Booking ID : ");
	    String bookingId = sc.nextLine();

	    boolean found = false;
	    boolean alreadyCheckIn = false;

	    try
	    {
	        FileReader fr = new FileReader("Booking.txt");
	        BufferedReader br = new BufferedReader(fr);

	        FileWriter fw = new FileWriter("TempBooking.txt");
	        BufferedWriter bw = new BufferedWriter(fw);

	        String line;

	        while((line = br.readLine()) != null)
	        {
	            if(line.equals("Booking ID : " + bookingId))
	            {
	                found = true;

	                bw.write(line);
	                bw.newLine();

	                // Customer Name
	                line = br.readLine();
	                bw.write(line);
	                bw.newLine();

	                // Mobile Number
	                line = br.readLine();
	                bw.write(line);
	                bw.newLine();

	                // Address
	                line = br.readLine();
	                bw.write(line);
	                bw.newLine();

	                // Room Number
	                line = br.readLine();
	                bw.write(line);
	                bw.newLine();

	                // Check In Date
	                line = br.readLine();
	                bw.write(line);
	                bw.newLine();

	                // Check Out Date
	                line = br.readLine();
	                bw.write(line);
	                bw.newLine();

	                // Booking Status
	                line = br.readLine();

	                if(line.equals("Booking Status : Booked"))
	                {
	                    bw.write("Booking Status : Check In");
	                    bw.newLine();
	                }
	                else
	                {
	                    alreadyCheckIn = true;

	                    bw.write(line);
	                    bw.newLine();
	                }

	                
	                line = br.readLine();
	                bw.write(line);
	                bw.newLine();
	            }
	            else
	            {
	                bw.write(line);
	                bw.newLine();
	            }
	        }

	        br.close();
	        bw.close();
	        fr.close();
	        fw.close();
	        
	        if(found)
	        {
	            File file1 = new File("Booking.txt");
	            File file2 = new File("TempBooking.txt");

	            file1.delete();
	            file2.renameTo(file1);

	            if(alreadyCheckIn)
	            {
	                System.out.println("\nCustomer Already Checked In...");
	            }
	            else
	            {
	                System.out.println("\nCheck In Successfully...");
	            }
	        }
	        else
	        {
	            File file = new File("TempBooking.txt");

	            if(file.exists())
	            {
	                file.delete();
	            }

	            System.out.println("\nBooking Not Found...");
	        }
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error : " + e.getMessage());
	    }
	}
	@Override
	public void checkOut()
	{
	    Scanner sc = new Scanner(System.in);

	    System.out.println("\n========== CHECK OUT ==========");

	    System.out.print("Enter Booking ID : ");
	    String bookingId = sc.nextLine();

	    boolean found = false;
	    boolean alreadyCheckOut = false;
	    boolean notCheckIn = false;

	    String roomNumber = "";

	    try
	    {
	        FileReader fr = new FileReader("Booking.txt");
	        BufferedReader br = new BufferedReader(fr);

	        FileWriter fw = new FileWriter("TempBooking.txt");
	        BufferedWriter bw = new BufferedWriter(fw);

	        String line;

	        while((line = br.readLine()) != null)
	        {
	            if(line.equals("Booking ID : " + bookingId))
	            {
	                found = true;

	                bw.write(line);
	                bw.newLine();

	                // Customer Name
	                line = br.readLine();
	                bw.write(line);
	                bw.newLine();

	                // Mobile Number
	                line = br.readLine();
	                bw.write(line);
	                bw.newLine();

	                // Address
	                line = br.readLine();
	                bw.write(line);
	                bw.newLine();

	                // Room Number
	                line = br.readLine();
	                roomNumber = line.replace("Room Number : ", "");

	                bw.write(line);
	                bw.newLine();

	                // Check In Date
	                line = br.readLine();
	                bw.write(line);
	                bw.newLine();

	                // Check Out Date
	                line = br.readLine();
	                bw.write(line);
	                bw.newLine();

	                // Booking Status
	                line = br.readLine();

	                if(line.equals("Booking Status : Check In"))
	                {
	                    bw.write("Booking Status : Check Out");
	                    bw.newLine();
	                }
	                else if(line.equals("Booking Status : Check Out"))
	                {
	                    alreadyCheckOut = true;

	                    bw.write(line);
	                    bw.newLine();
	                }
	                else
	                {
	                    notCheckIn = true;

	                    bw.write(line);
	                    bw.newLine();
	                }

	                // Separator
	                line = br.readLine();
	                bw.write(line);
	                bw.newLine();
	            }
	            else
	            {
	                bw.write(line);
	                bw.newLine();
	            }
	        }

	        br.close();
	        bw.close();
	        fr.close();
	        fw.close();

	        // ===== FINAL PART 11B START =====
	        if(found == false)
	        {
	            File file = new File("TempBooking.txt");

	            if(file.exists())
	            {
	                file.delete();
	            }

	            System.out.println("\nBooking Not Found...");
	            return;
	        }

	        if(alreadyCheckOut == true)
	        {
	            File file1 = new File("Booking.txt");
	            File file2 = new File("TempBooking.txt");

	            file1.delete();
	            file2.renameTo(file1);

	            System.out.println("\nCustomer Already Checked Out...");
	            return;
	        }

	        if(notCheckIn == true)
	        {
	            File file1 = new File("Booking.txt");
	            File file2 = new File("TempBooking.txt");

	            file1.delete();
	            file2.renameTo(file1);

	            System.out.println("\nCustomer Not Checked In...");
	            return;
	        }

	        File file1 = new File("Booking.txt");
	        File file2 = new File("TempBooking.txt");

	        file1.delete();
	        file2.renameTo(file1);

	        FileReader fr1 = new FileReader("Room.txt");
	        BufferedReader br1 = new BufferedReader(fr1);

	        FileWriter fw1 = new FileWriter("TempRoom.txt");
	        BufferedWriter bw1 = new BufferedWriter(fw1);

	        String line1;


	        while((line1 = br1.readLine()) != null)
	        {
	            if(line1.equals("Room Number : " + roomNumber))
	            {
	                bw1.write(line1);
	                bw1.newLine();

	                // Room Type
	                line1 = br1.readLine();
	                bw1.write(line1);
	                bw1.newLine();

	                // Category
	                line1 = br1.readLine();
	                bw1.write(line1);
	                bw1.newLine();

	                // Price Per Day
	                line1 = br1.readLine();
	                bw1.write(line1);
	                bw1.newLine();

	                // Bed Type
	                line1 = br1.readLine();
	                bw1.write(line1);
	                bw1.newLine();

	                // Status (Booked -> Available)
	                br1.readLine();
	                bw1.write("Status : Available");
	                bw1.newLine();

	                // Separator
	                line1 = br1.readLine();
	                bw1.write(line1);
	                bw1.newLine();
	            }
	            else
	            {
	                bw1.write(line1);
	                bw1.newLine();
	            }
	        }

	        br1.close();
	        bw1.close();
	        fr1.close();
	        fw1.close();

	        File file3 = new File("Room.txt");
	        File file4 = new File("TempRoom.txt");

	        file3.delete();
	        file4.renameTo(file3);

	        System.out.println("\nCheck Out Successfully...");
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error : " + e.getMessage());
	    }
	}
	@Override
	public void generateBill()
	{
	    Scanner sc = new Scanner(System.in);

	    System.out.println("\n========== GENERATE BILL ==========");

	    System.out.print("Enter Booking ID : ");
	    String bookingId = sc.nextLine();

	    boolean found = false;

	    String customerName = "";
	    String mobileNumber = "";
	    String roomNumber = "";
	    String checkInDate = "";
	    String checkOutDate = "";

	    int pricePerDay = 0;

	    try
	    {
	        FileReader fr = new FileReader("Booking.txt");
	        BufferedReader br = new BufferedReader(fr);

	        String line;

	        while((line = br.readLine()) != null)
	        {
	            if(line.equals("Booking ID : " + bookingId))
	            {
	                found = true;

	                line = br.readLine();
	                customerName = line.replace("Customer Name : ", "");

	                line = br.readLine();
	                mobileNumber = line.replace("Mobile Number : ", "");

	                br.readLine(); // Address

	                line = br.readLine();
	                roomNumber = line.replace("Room Number : ", "");

	                line = br.readLine();
	                checkInDate = line.replace("Check In Date : ", "");

	                line = br.readLine();
	                checkOutDate = line.replace("Check Out Date : ", "");

	                break;
	            }
	        }

	        br.close();
	        fr.close();

	        if(found == false)
	        {
	            System.out.println("\nBooking Not Found...");
	            return;
	        }

	        FileReader fr1 = new FileReader("Room.txt");
	        BufferedReader br1 = new BufferedReader(fr1);

	        while((line = br1.readLine()) != null)
	        {
	            if(line.equals("Room Number : " + roomNumber))
	            {
	                br1.readLine(); // Room Type
	                br1.readLine(); // Category

	                line = br1.readLine();
	                pricePerDay = Integer.parseInt(line.replace("Price Per Day : ", ""));

	                break;
	            }
	        }

	        br1.close();
	        fr1.close();

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	        LocalDate inDate = LocalDate.parse(checkInDate, formatter);
	        LocalDate outDate = LocalDate.parse(checkOutDate, formatter);

	        long totalDays = ChronoUnit.DAYS.between(inDate, outDate);

	        if(totalDays <= 0)
	        {
	            totalDays = 1;
	        }

	        double roomBill = totalDays * pricePerDay;
	        double gst = roomBill * 0.18;
	        double totalBill = roomBill + gst;

	        System.out.println("\n==========================================");
	        System.out.println("             HOTEL BILL");
	        System.out.println("==========================================");
	        System.out.println("Booking ID      : " + bookingId);
	        System.out.println("Customer Name   : " + customerName);
	        System.out.println("Mobile Number   : " + mobileNumber);
	        System.out.println("Room Number     : " + roomNumber);
	        System.out.println("Check In Date   : " + checkInDate);
	        System.out.println("Check Out Date  : " + checkOutDate);
	        System.out.println("Total Days      : " + totalDays);
	        System.out.println("Price Per Day   : " + pricePerDay);
	        System.out.println("------------------------------------------");
	        System.out.println("Room Bill       : " + roomBill);
	        System.out.println("GST (18%)       : " + gst);
	        System.out.println("------------------------------------------");
	        System.out.println("Total Bill      : " + totalBill);
	        System.out.println("==========================================");
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error : " + e.getMessage());
	    }
	}
	@Override
	public void payment()
	{
	    Scanner sc = new Scanner(System.in);

	    System.out.println("\n========== PAYMENT ==========");

	    System.out.print("Enter Booking ID : ");
	    String bookingId = sc.nextLine();

	    boolean bookingFound = false;
	    boolean paymentAlreadyDone = false;

	    String customerName = "";
	    String mobileNumber = "";
	    String roomNumber = "";
	    String checkInDate = "";
	    String checkOutDate = "";

	    int pricePerDay = 0;

	    try
	    {
	        // ==========================
	        // CHECK PAYMENT ALREADY DONE
	        // ==========================

	        File paymentFile = new File("Payment.txt");

	        if(paymentFile.exists())
	        {
	            FileReader pfr = new FileReader(paymentFile);
	            BufferedReader pbr = new BufferedReader(pfr);

	            String line;

	            while((line = pbr.readLine()) != null)
	            {
	                if(line.equals("Booking ID : " + bookingId))
	                {
	                    paymentAlreadyDone = true;
	                    break;
	                }
	            }

	            pbr.close();
	            pfr.close();
	        }

	        if(paymentAlreadyDone)
	        {
	            System.out.println("\nPayment Already Completed...");
	            return;
	        }

	        // ==========================
	        // SEARCH BOOKING
	        // ==========================

	        FileReader fr = new FileReader("Booking.txt");
	        BufferedReader br = new BufferedReader(fr);

	        String line;

	        while((line = br.readLine()) != null)
	        {
	            if(line.equals("Booking ID : " + bookingId))
	            {
	                bookingFound = true;

	                line = br.readLine();
	                customerName = line.replace("Customer Name : ", "");

	                line = br.readLine();
	                mobileNumber = line.replace("Mobile Number : ", "");

	                br.readLine(); // Address

	                line = br.readLine();
	                roomNumber = line.replace("Room Number : ", "");

	                line = br.readLine();
	                checkInDate = line.replace("Check In Date : ", "");

	                line = br.readLine();
	                checkOutDate = line.replace("Check Out Date : ", "");

	                break;
	            }
	        }

	        br.close();
	        fr.close();

	        if(bookingFound == false)
	        {
	            System.out.println("\nBooking Not Found...");
	            return;
	        }
	        // ==========================
	        // GET ROOM PRICE
	        // ==========================

	        FileReader fr1 = new FileReader("Room.txt");
	        BufferedReader br1 = new BufferedReader(fr1);

	        while((line = br1.readLine()) != null)
	        {
	            if(line.equals("Room Number : " + roomNumber))
	            {
	                br1.readLine(); // Room Type
	                br1.readLine(); // Category

	                line = br1.readLine();

	                pricePerDay = Integer.parseInt(line.replace("Price Per Day : ", ""));

	                break;
	            }
	        }

	        br1.close();
	        fr1.close();

	        // ==========================
	        // CALCULATE BILL
	        // ==========================

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	        LocalDate inDate = LocalDate.parse(checkInDate, formatter);
	        LocalDate outDate = LocalDate.parse(checkOutDate, formatter);

	        long totalDays = ChronoUnit.DAYS.between(inDate, outDate);

	        if(totalDays <= 0)
	        {
	            totalDays = 1;
	        }

	        double roomBill = totalDays * pricePerDay;
	        double gst = roomBill * 0.18;
	        double totalBill = roomBill + gst;

	        System.out.println("\n========== PAYMENT ==========");
	        System.out.println("Room Bill : " + roomBill);
	        System.out.println("GST (18%) : " + gst);
	        System.out.println("Total Bill : " + totalBill);

	        // ==========================
	        // PAYMENT METHOD
	        // ==========================

	        System.out.println("\nSelect Payment Method");
	        System.out.println("1. Cash");
	        System.out.println("2. UPI");
	        System.out.println("3. Card");

	        System.out.print("Enter Choice : ");
	        int choice = sc.nextInt();
	        sc.nextLine();

	        String paymentMethod = "";

	        switch(choice)
	        {
	            case 1:

	                paymentMethod = "Cash";
	                break;

	            case 2:

	                paymentMethod = "UPI";

	                System.out.print("Enter UPI ID : ");
	                sc.nextLine();

	                break;

	            case 3:

	                paymentMethod = "Card";

	                System.out.print("Enter Card Number : ");
	                sc.nextLine();

	                System.out.print("Enter Card Holder Name : ");
	                sc.nextLine();

	                System.out.print("Enter CVV : ");
	                sc.nextLine();

	                break;

	            default:

	                System.out.println("Invalid Payment Method...");
	                return;
	        }

	        System.out.print("Enter Payment Amount : ");
	        double paymentAmount = sc.nextDouble();

	        if(paymentAmount < totalBill)
	        {
	            System.out.println("\nInsufficient Payment...");
	            return;
	        }

	        double returnAmount = paymentAmount - totalBill;
	        // ==========================
	        // SAVE PAYMENT
	        // ==========================

	        FileWriter fw = new FileWriter("Payment.txt", true);
	        BufferedWriter bw = new BufferedWriter(fw);

	        bw.write("Booking ID : " + bookingId);
	        bw.newLine();

	        bw.write("Customer Name : " + customerName);
	        bw.newLine();

	        bw.write("Mobile Number : " + mobileNumber);
	        bw.newLine();

	        bw.write("Room Number : " + roomNumber);
	        bw.newLine();

	        bw.write("Check In Date : " + checkInDate);
	        bw.newLine();

	        bw.write("Check Out Date : " + checkOutDate);
	        bw.newLine();

	        bw.write("Total Days : " + totalDays);
	        bw.newLine();

	        bw.write("Price Per Day : " + pricePerDay);
	        bw.newLine();

	        bw.write("Room Bill : " + roomBill);
	        bw.newLine();

	        bw.write("GST (18%) : " + gst);
	        bw.newLine();

	        bw.write("Total Bill : " + totalBill);
	        bw.newLine();

	        bw.write("Payment Method : " + paymentMethod);
	        bw.newLine();

	        bw.write("Paid Amount : " + paymentAmount);
	        bw.newLine();

	        bw.write("Return Amount : " + returnAmount);
	        bw.newLine();

	        bw.write("--------------------------------");
	        bw.newLine();

	        bw.close();
	        fw.close();

	        System.out.println("\n====================================");
	        System.out.println("      PAYMENT SUCCESSFUL");
	        System.out.println("====================================");
	        System.out.println("Payment Method : " + paymentMethod);
	        System.out.println("Paid Amount    : " + paymentAmount);
	        System.out.println("Return Amount  : " + returnAmount);
	        System.out.println("====================================");
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error : " + e.getMessage());
	    }
	}
	@Override
	public void viewCustomerDetails()
	{
	    Scanner sc = new Scanner(System.in);

	    System.out.println("\n========== VIEW CUSTOMER DETAILS ==========");

	    System.out.print("Enter Booking ID : ");
	    String bookingId = sc.nextLine();

	    boolean found = false;

	    try
	    {
	        FileReader fr = new FileReader("Booking.txt");
	        BufferedReader br = new BufferedReader(fr);

	        String line;

	        while((line = br.readLine()) != null)
	        {
	            if(line.equals("Booking ID : " + bookingId))
	            {
	                found = true;

	                System.out.println("\n========== CUSTOMER DETAILS ==========");

	                System.out.println(line);

	                for(int i = 1; i <= 7; i++)
	                {
	                    line = br.readLine();

	                    if(line != null)
	                    {
	                        System.out.println(line);
	                    }
	                }

	                break;
	            }
	        }

	        br.close();
	        fr.close();

	        if(found == false)
	        {
	            System.out.println("\nCustomer Not Found...");
	        }
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error : " + e.getMessage());
	    }
	}
	@Override
	public void viewAllBookings()
	{
	    System.out.println("\n========== ALL BOOKINGS ==========");

	    boolean found = false;

	    try
	    {
	        FileReader fr = new FileReader("Booking.txt");
	        BufferedReader br = new BufferedReader(fr);

	        String line;

	        while((line = br.readLine()) != null)
	        {
	            found = true;
	            System.out.println(line);
	        }

	        br.close();
	        fr.close();

	        if(found == false)
	        {
	            System.out.println("\nNo Booking Available...");
	        }
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error : " + e.getMessage());
	    }
	}
	@Override
	public void logout()
	{
	    System.out.println("\n==================================");
	    System.out.println("        LOGOUT SUCCESSFULLY");
	    System.out.println("==================================");

	    System.out.println("Thank You For Using Hotel Management System.");
	    System.out.println("Redirecting To Main Menu...");
	}
	@Override
	public void exit()
	{
	    System.out.println("\n==================================");
	    System.out.println("   THANK YOU FOR VISITING");
	    System.out.println(" HOTEL MANAGEMENT SYSTEM");
	    System.out.println("==================================");

	    System.out.println("Program Closed Successfully...");
	    System.exit(0);
	}
}
public class Hotel_Management_System
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        VipinGupta obj = new VipinGupta();

        while(true)
        {
            System.out.println("\n==================================");
            System.out.println("      HOTEL MANAGEMENT SYSTEM");
            System.out.println("==================================");

            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();
            sc.nextLine();

            boolean openMenu = false;

            switch(choice)
            {
                case 1:

                    obj.createAccount();

                    // Create Account ke baad bhi menu open hoga
                    openMenu = true;
                    break;

                case 2:

                    // Login successful hua tabhi menu open hoga
                    if(obj.login())
                    {
                        openMenu = true;
                    }
                    break;

                case 3:

                    obj.exit();
                    break;

                default:

                    System.out.println("Invalid Choice...");
            }

            if(openMenu)
            {
                boolean logout = false;

                while(!logout)
                {
                    System.out.println("\n==================================");
                    System.out.println("          HOTEL MENU");
                    System.out.println("==================================");

                    System.out.println("1. Add Room");
                    System.out.println("2. View Rooms");
                    System.out.println("3. Search Room");
                    System.out.println("4. Book Room");
                    System.out.println("5. Cancel Booking");
                    System.out.println("6. Update Room");
                    System.out.println("7. Delete Room");
                    System.out.println("8. Check In");
                    System.out.println("9. Check Out");
                    System.out.println("10. Generate Bill");
                    System.out.println("11. Payment");
                    System.out.println("12. View Customer Details");
                    System.out.println("13. View All Bookings");
                    System.out.println("14. Logout");
                    System.out.println("15. Exit");

                    System.out.print("Enter Choice : ");
                    int ch = sc.nextInt();
                    sc.nextLine();

                    switch(ch)
                    {
                    case 1:
                        obj.addRoom();
                        break;

                    case 2:
                        obj.viewRooms();
                        break;

                    case 3:
                        obj.searchRoom();
                        break;

                    case 4:
                        obj.bookRoom();
                        break;

                    case 5:
                        obj.cancelBooking();
                        break;

                    case 6:
                        obj.updateRoom();
                        break;

                    case 7:
                        obj.deleteRoom();
                        break;

                    case 8:
                        obj.checkIn();
                        break;

                    case 9:
                        obj.checkOut();
                        break;

                    case 10:
                        obj.generateBill();
                        break;

                    case 11:
                        obj.payment();
                        break;

                    case 12:
                        obj.viewCustomerDetails();
                        break;

                    case 13:
                        obj.viewAllBookings();
                        break;

                    case 14:
                        obj.logout();
                        logout = true;
                        break;

                    case 15:
                        obj.exit();
                        break;

                    default:
                        System.out.println("Invalid Choice...");
                }
            }
        }       
        }   
    }       
}           
                    