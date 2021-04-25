import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMeOption {
	
	String Directory = System.getProperty("user.dir");
	File folder_name = new File(Directory);
	
	//Primary Option for user
	private static final String Primary_Option =
            "\nSelect option from following: \n"+
                    "Choose 1 => To Show files name in directory in ascending order\n"+
                    "Choose 2 => To Add, Delete or Search file\n"+
                    "Choose 3 => To Exit Program";

	//Secondary Option for user
    private static final String Secondary_Option =
            "   \nSelect option from following: \n"+
                    "Choose 1 => To Add a file\n"+
                    "Choose 2 => To Delete a file\n"+
                    "Choose 3 => To Search a file\n"+
                    "Choose 4 => To GoBack";
    
    //Primary Option UserInput and Operations
    void PrimaryOption() {
    	System.out.println(Primary_Option);
    	System.out.print("Please enter your option: ");
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
    	int PriInput = sc.nextInt();
    	switch(PriInput) {
    	case 1:
    		ListFile();
    		PrimaryOption();    		
    		break;
    		
    	case 2:
    		SecondaryOption();
    		break;
    		
    	case 3:
    		System.out.println("Exiting Application..." + "\nThank You!");
    		System.exit(0);
    		 break;
    		 
    	default:
    		System.out.println("Please select option 1, 2 or 3");
    		PrimaryOption();
    	}
    	
    }
    
    //Secondary Option UserInput and Operation
    void SecondaryOption() {
    	System.out.println(Secondary_Option);
    	System.out.print("Please enter your option: ");
    	try {
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
    	int SecInput = sc.nextInt();
    	switch(SecInput) {
    	case 1:
    		System.out.print("Please enter file name to add: ");
    		String filename = sc.next();
    		AddFile(filename);
    		break;
    		
    	case 2:
    		System.out.print("Please enter file name to delete: ");
    	    filename = sc.next();
    	    DeleteFile(filename);
    		break;
    		
    	case 3:
    		System.out.print("Please enter file name to search: ");
    		filename = sc.next();
    		SearchFile(filename);
    		break;
    		
    	case 4:
    		System.out.println("\nBack to main Options");
    		PrimaryOption();
    		break;
    		
    	default:
    		System.out.println("Please enter 1, 2, 3 or 4");
    		SecondaryOption();
    	}
    	
    	SecondaryOption();
    	}
    	
    	catch(IOException e) {
    		System.out.println("Please select option 1, 2 or 3");
    		PrimaryOption();
    	}
    }
    
    //List files in ascending order
    void ListFile() {
    	String[] list;
    	File f = new File(Directory);
    	if(f.list().length==0) {
    		System.out.println("The Folder is empty");
    	}
    	else {
    		list = f.list();
    		Arrays.sort(list);
    		System.out.println("The File in " + f + " are: ");
    		for(String str:list) {
    			System.out.println(str);
    		}
    		
    	}
    }
    
    //Adding file provided by user
    void AddFile(String filename) throws IOException {
    	File f = new File(folder_name+"/"+filename);
    	String[] list = folder_name.list();
    	for(String str:list) {
    		if(filename.equalsIgnoreCase(str)) {
    			System.out.println("File " + filename + " is already exist at " +folder_name);
    			return;
    		}
    	}
    	f.createNewFile();
    	System.out.println("File " + filename + " is craeted successfully in " +folder_name);  	
    
    }
    
    //Deleting file selected by user
    void DeleteFile(String filename) {
    	File f = new File(folder_name+"/"+filename);
    	String[] list = folder_name.list();
    	for(String str:list) {
    		if(filename.equals(str) && f.delete()) {
    			System.out.println("File " + filename + " deleted successfully from " + folder_name);
    			return;
    		}
    	}
    	System.out.println("Delete failed file not found");
    }
    //Search File enter by user
    void SearchFile(String filename) {
    	String[] list = folder_name.list();
    	for(String str:list) {
    		if(filename.equals(str)) {
    			System.out.println("File " + filename + " found at: " + folder_name);
    			return;
    		}
    	}
    	System.out.println("File not found");
    }
}

