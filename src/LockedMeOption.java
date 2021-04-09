import java.util.Scanner;

public class LockedMeOption {
	private static final String Primary_Option =
            "\nSelect any of the following: \n"+
                    "1 -> List files in directory\n"+
                    "2 -> Add, Delete or Search\n"+
                    "3 -> Exit Program";

    private static final String Secondary_Option =
            "   \nSelect any of the following: \n"+
                    "   1 -> Add a file\n"+
                    "   2 -> Delete a file\n"+
                    "   3 -> Search a file\n"+
                    "   4 -> GoBack";
    void PrimaryOption() {
    	System.out.println(Primary_Option);
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
    	int PriInput = sc.nextInt();
    	switch(PriInput) {
    	case 1:
    		
    		break;
    		
    	case 2:
    		SecondaryOption();
    		break;
    		
    	case 3:
    		
    		 break;
    		 
    	default:
    		System.out.println("Please select option 1, 2 or 3");
    		PrimaryOption();
    	}
    	
    }
    
    void SecondaryOption() {
    	System.out.println(Secondary_Option);
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
    	int SecInput = sc.nextInt();
    	switch(SecInput) {
    	case 1:
    		
    		break;
    		
    	case 2:
    		
    		break;
    		
    	case 3:
    		
    		break;
    		
    	case 4:
    		System.out.println("\nBack to main Options");
    		PrimaryOption();
    		break;
    		
    	default:
    		System.out.println("Please enter 1, 2, 3 or 4");
    		SecondaryOption();
    	}
    	
    	
    }

}
