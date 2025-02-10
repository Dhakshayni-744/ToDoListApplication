import java.util.*;
import java.io.*;
import java.sql.*;
class TaskModule
{

    public static void addTask(Scanner scanner, int userId) throws SQLException {
        Connection conn = Main.connectDB();
        System.out.print("Enter task description: ");
        scanner.nextLine();
        String description = scanner.nextLine();
        System.out.print("Enter priority (Low, Medium, High): ");
        String priority = scanner.nextLine();
        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dueDate = scanner.nextLine();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO tasks (user_id, description, priority, due_date) VALUES (?, ?, ?, ?)");
        stmt.setInt(1, userId);
        stmt.setString(2, description);
        stmt.setString(3, priority);
        stmt.setString(4, dueDate);
        stmt.executeUpdate();
        System.out.println("Task added successfully!");
    }
}
