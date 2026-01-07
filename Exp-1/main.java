public class Main {
    
    // Main method - entry point of the program
    public static void main(String[] args) {
        System.out.println("Welcome to Git Version Control Lab!");
        System.out.println("=====================================");
        
        // Display project information
        displayProjectInfo();
        
        // Demonstrate basic functionality
        performCalculation(10, 5);
    }
    
    // Method to display project information
    public static void displayProjectInfo() {
        System.out.println("\nProject: FSAD Workbook");
        System.out.println("Purpose: Learning Git Version Control");
        System.out.println("Author: Your Name");
        System.out.println("Date: " + java.time.LocalDate.now());
    }
    
    // Method to perform a simple calculation
    public static void performCalculation(int a, int b) {
        System.out.println("\n--- Calculation Demo ---");
        System.out.println("Addition: " + a + " + " + b + " = " + (a + b));
        System.out.println("Subtraction: " + a + " - " + b + " = " + (a - b));
        System.out.println("Multiplication: " + a + " * " + b + " = " + (a * b));
        if (b != 0) {
            System.out.println("Division: " + a + " / " + b + " = " + (a / b));
        }
    }
}