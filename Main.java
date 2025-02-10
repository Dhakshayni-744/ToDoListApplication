import java.util.*;
import java.io.*;
import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/ToDoListDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Dhakshayni@744";

    public static Connection connectDB() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskModule task = new TaskModule();
        
        while (true) {
            System.out.println("\n1. Add a Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Show All Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            int userId = 1; 
            try {
                switch (choice) {
                    case 1:
                        task.addTask(scanner, userId);
                        break;
                    case 2:
                        //task.markTaskCompleted(scanner, userId);
                        break;
                    case 3:
                        //task.showAllTasks(userId);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
            }
        }
    }
}

