package detailedoption;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import projectphase1.*; 

public class Detailedoption extends Welcomescreen {
	static Welcomescreen w=new Welcomescreen(); 
	public static void menu() throws Exception
	 {
		System.out.println("\n1. Add a File");
		System.out.println("2. Delete a File");
		System.out.println("3. Search a File");
		System.out.println("4. Go Back To Main Menu");
		try {
		Scanner s1=new Scanner(System.in);
		int ch=s1.nextInt();
		
		switch(ch) {
		
		case 1: addfile();
				menu();
		       break;
		case 2: deletefile();
				menu();
				break;      
		case 3: searchfile();
				menu();
				break;
		case 4:	w.mainmenu();
				break;
		default: System.out.println("Kindly enter valid option....Try Again!");
				menu();
				
		}
		}
		catch(Exception e)
		{
			System.out.println("Kindly enter valid option....Try Again!");
			menu();
		}
		
	 }


	//code for adding file
	public static void addfile()
	{
		
		System.out.println("Enter The File Name You Want To Add with appropriate File extension like .txt,.docx,.word etc");
		Scanner s1=new Scanner(System.in);
		 
		String filename=s1.nextLine().translateEscapes();
		
		//filename=filename+".txt"; //this can be used if you want to add .txt format file without entering the extension.
		String fileLocation="src\\files\\"+filename;
		File f=new File(fileLocation);
		
		try {
			if(f.createNewFile())
			{
				System.out.println("File "+f.getName()+" created successfully");
			}
			else
			{
				System.out.println("File Already Exist");
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
	}
	
	// block for deletion of file
	public static void deletefile() throws IOException {
		File path=new File("src\\files");
	    String file[]=path.list();
	    for(String f:file)
	    {
	    	System.out.println(f);
	    }
		
	    System.out.println("\nEnter the File Name that you want to Delete from the Aforementioned files");
	    
	    Scanner s1=new Scanner(System.in);
	    String filename=s1.nextLine().translateEscapes();
	    String fileLocation="src\\files\\"+filename;
	    File f=new File(fileLocation);
	    
	    if(f.exists() && f.getCanonicalFile().getName().equals(filename))   //checking case senstivity & spaces
	    {
	    	f.delete();
	    	System.out.println(f.getName()+" is deleted Successfully!");
	    }
	    else
	    {
	    	System.out.println("File Not Found..!");
	    	System.out.println("Kindly enter correct file name also Check The Case Sensitivity To Delete The File!!");
	    }
	    
	}
	
	//code for searching file
	public static void searchfile() throws Exception
	{
		
		System.out.println("Enter the File Name you want to search with appropriate File extension like .txt,.docx,.word etc");
	    
	    Scanner s1=new Scanner(System.in);
	    String filename=s1.nextLine().translateEscapes();
	  
	    String fileLocation="src\\files\\"+filename;
	    File f=new File(fileLocation);
	    
	    if(f.exists() && f.getCanonicalFile().getName().equals(f.getName()))  //checking case senstivity & spaces
	    {	
	    	System.out.println("\nSearch completed");
	    	System.out.println(f.getName()+" is available in the directory.\n");
	    	
	    }

	    else
	    {
	    	System.out.println("File not found.");
	    	System.out.println("Kindly Enter Correct File Name & Check The Case Senstivity");
	    }
	   
	   
	}
}
