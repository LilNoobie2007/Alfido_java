import java.util.Scanner;

public class Stundent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System Constraints
        final int MAX_STUDENTS = 10;
        String[] studentNames = new String[MAX_STUDENTS];
        int[] studentMarks = new int[MAX_STUDENTS];
        int currentCount = 0;

        System.out.println("==============================================");
        System.out.println("     ACADEMIC RECORD MANAGEMENT SYSTEM        ");
        System.out.println("==============================================");

        while (true) {
            System.out.println("\nMAIN MENU:");
            System.out.println("1. Register New Student");
            System.out.println("2. View All Academic Records");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Terminate System");
            System.out.print("Please select an option: ");

            int action = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            if (action == 1) {
                if (currentCount < MAX_STUDENTS) {
                    System.out.print("Enter Official Name: ");
                    studentNames[currentCount] = scanner.nextLine();

                    System.out.print("Enter Examination Marks (0-100): ");
                    studentMarks[currentCount] = scanner.nextInt();
                    
                    currentCount++;
                    System.out.println("SUCCESS: Record synchronized.");
                } else {
                    System.out.println("ERROR: Database capacity reached.");
                }
            } 
            else if (action == 2) {
                if (currentCount == 0) {
                    System.out.println("NOTICE: No data currently available.");
                } else {
                    System.out.println("\n--- COMPREHENSIVE STUDENT RECORDS ---");
                    for (int i = 0; i < currentCount; i++) {
                        String grade;
                        // Formal grading logic
                        if (studentMarks[i] >= 90) grade = "A+";
                        else if (studentMarks[i] >= 75) grade = "A";
                        else if (studentMarks[i] >= 50) grade = "B";
                        else if (studentMarks[i] >= 35) grade = "C (Pass)";
                        else grade = "F (Fail)";

                        System.out.println("ID: " + (i + 1) + " | Name: " + studentNames[i] + 
                                           " | Marks: " + studentMarks[i] + " | Grade: " + grade);
                    }
                }
            } 
            else if (action == 3) {
                System.out.print("Enter name to search: ");
                String query = scanner.nextLine();
                boolean found = false;

                for (int i = 0; i < currentCount; i++) {
                    if (studentNames[i].equalsIgnoreCase(query)) {
                        System.out.println("MATCH FOUND: " + studentNames[i] + " | Marks: " + studentMarks[i]);
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("ERROR: Record not found.");
            } 
            else if (action == 4) {
                System.out.println("System shutting down. Secure logout complete.");
                break;
            } 
            else {
                System.out.println("WARNING: Invalid selection. Please try again.");
            }
        }
        scanner.close();
    }
}
