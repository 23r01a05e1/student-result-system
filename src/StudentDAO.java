import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // Student login
    public int login(String email, String password) {
        String sql = "SELECT * FROM students WHERE email = ? AND password = ?";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Login successful! Welcome " + rs.getString("name"));
                return rs.getInt("id");
            } else {
                System.out.println("Invalid email or password!");
                return -1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }

    // View results of a student
    public void viewResults(int studentId) {
        String sql = "SELECT * FROM results WHERE student_id = ?";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            System.out.println("\n--- Your Results ---");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("Subject: " + rs.getString("subject") +
                    " | Marks: " + rs.getInt("marks") +
                    " | Grade: " + rs.getString("grade"));
            }
            if (!found) {
                System.out.println("No results found yet!");
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}