import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {

    // Add a new student
    public void addStudent(String name, String rollNumber, String email, String password) {
        String sql = "INSERT INTO students (name, roll_number, email, password) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, rollNumber);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.executeUpdate();
            System.out.println("Student added successfully!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Add result for a student
    public void addResult(int studentId, String subject, int marks, String grade) {
        String sql = "INSERT INTO results (student_id, subject, marks, grade) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, studentId);
            stmt.setString(2, subject);
            stmt.setInt(3, marks);
            stmt.setString(4, grade);
            stmt.executeUpdate();
            System.out.println("Result added successfully!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // View all students
    public void viewAllStudents() {
        String sql = "SELECT * FROM students";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("\n--- All Students ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                    " | Name: " + rs.getString("name") +
                    " | Roll: " + rs.getString("roll_number") +
                    " | Email: " + rs.getString("email"));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}