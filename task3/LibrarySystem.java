import java.util.*;

// Custom Exception (Basic Level)
class InvalidBookException extends Exception {
    public InvalidBookException(String message) {
        super(message);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        // Collections initialization with simple names
        List<String> bookList = new ArrayList<>();
        Map<Integer, String> bookMap = new HashMap<>();
        Set<String> sections = new HashSet<>();

        Scanner scan = new Scanner(System.in);

        // Pre-populating some database records
        bookList.add("Java Basics");
        bookList.add("Data Networks");
        bookList.add("Web Tech");

        bookMap.put(101, "Java Basics");
        bookMap.put(102, "Data Networks");
        bookMap.put(103, "Web Tech");

        // Unique library categories
        sections.add("Computing");
        sections.add("Engineering");
        sections.add("Computing"); // Duplicate entry (will be auto-filtered)

        System.out.println("==============================================");
        System.out.println("     CENTRAL LIBRARY MANAGEMENT SYSTEM        ");
        System.out.println("==============================================");
        
        System.out.println("Active Categories: " + sections);
        System.out.println("Catalog Baseline: " + bookList);

        // Exception handling block for active operations
        try {
            System.out.println("\nOPERATIONS MENU:");
            System.out.println("1. Query Catalog by Book ID");
            System.out.println("2. Insert New Book to System");
            System.out.print("Select operational code: ");
            int action = scan.nextInt();
            scan.nextLine(); // Clear input buffer

            if (action == 1) {
                System.out.print("Enter 3-Digit Book ID: ");
                int id = scan.nextInt();

                // Validating ID existence via Exception
                if (!bookMap.containsKey(id)) {
                    throw new InvalidBookException("CRITICAL ERROR: Resource ID " + id + " not registered in catalog.");
                } else {
                    System.out.println("RECORD LOCATED: Title -> " + bookMap.get(id));
                }
            } 
            else if (action == 2) {
                System.out.print("Enter New Book ID: ");
                int newId = scan.nextInt();
                scan.nextLine(); // Clear buffer

                // Check if ID is already taken
                if (bookMap.containsKey(newId)) {
                    throw new InvalidBookException("ABORT EXECUTION: Resource ID " + newId + " is already assigned.");
                }

                System.out.print("Enter Book Title: ");
                String title = scan.nextLine();

                // Dynamic updates across multiple collections
                bookMap.put(newId, title);
                bookList.add(title);
                
                System.out.println("SUCCESS: Catalog arrays updated synchronized.");
                System.out.println("Updated Catalog: " + bookList);
            } 
            else {
                System.out.println("WARNING: Operation code unrecognized.");
            }
        } 
        catch (InvalidBookException e) {
            System.out.println(e.getMessage());
        } 
        catch (InputMismatchException e) {
            System.out.println("SYSTEM ERROR: Invalid alphanumeric format parsed. Session locked.");
        } 
        finally {
            System.out.println("\n==============================================");
            System.out.println("  TERMINAL SESSION REFRESHED / DISCONNECTED   ");
            System.out.println("==============================================");
            scan.close();
        }
    }
}
