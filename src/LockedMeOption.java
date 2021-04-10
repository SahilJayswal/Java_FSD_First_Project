import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMeOption {
	
	//Fetching directory properties
	String Directory = System.getProperty("user.dir");
	File folder_name = new File(Directory);
	
	//Primary Option for user
	private static final String Primary_Option =
            "\nSelect any of the following: \n"+
                    "1 -> List files in directory\n"+
                    "2 -> Add, Delete or Search\n"+
                    "3 -> Exit Program";

	//Secondry Option for user
    private static final String Secondary_Option =
            "   \nSelect any of the following: \n"+
                    "   1 -> Add a file\n"+
                    "   2 -> Delete a file\n"+
                    "   3 -> Search a file\n"+
                    "   4 -> GoBack";
    
    //Primary Option UserInput and Operations
    void PrimaryOption() {
    	System.out.println(Primary_Option);
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
    	try {
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
    	int SecInput = sc.nextInt();
    	switch(SecInput) {
    	case 1:
    		System.out.println("Please enter file name to Add: ");
    		String filename = sc.next();
    		AddFile(filename);
    		break;
    		
    	case 2:
    		System.out.println("Please enter file name to delete: ");
    	    filename = sc.next();
    	    DeleteFile(filename);
    		break;
    		
    	case 3:
    		System.out.println("Please enter file name to search: ");
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
    	//Call secondary options
    	SecondaryOption();
    	}
    	
    	catch(IOException e) {
    		System.out.println("Please select option 1, 2 or 3");
    		PrimaryOption();
    	}
    }
    
    //List files Operation
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
    //Search File
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

