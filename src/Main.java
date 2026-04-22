import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdminDAO adminDAO = new AdminDAO();
        StudentDAO studentDAO = new StudentDAO();

        while (true) {
            System.out.println("\n=============================");
            System.out.println("  Student Result System");
            System.out.println("=============================");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                // Admin menu
                System.out.print("Enter Admin Password: ");
                String adminPass = sc.next();
                if (adminPass.equals("admin123")) {
                    System.out.println("Admin logged in!");
                    while (true) {
                        System.out.println("\n--- Admin Menu ---");
                        System.out.println("1. Add Student");
                        System.out.println("2. Add Result");
                        System.out.println("3. View All Students");
                        System.out.println("4. Logout");
                        System.out.print("Enter choice: ");
                        int adminChoice = sc.nextInt();

                        if (adminChoice == 1) {
                            System.out.print("Enter Name: ");
                            String name = sc.next();
                            System.out.print("Enter Roll Number: ");
                            String roll = sc.next();
                            System.out.print("Enter Email: ");
                            String email = sc.next();
                            System.out.print("Enter Password: ");
                            String pass = sc.next();
                            adminDAO.addStudent(name, roll, email, pass);

                        } else if (adminChoice == 2) {
                            System.out.print("Enter Student ID: ");
                            int sid = sc.nextInt();
                            System.out.print("Enter Subject: ");
                            String subject = sc.next();
                            System.out.print("Enter Marks: ");
                            int marks = sc.nextInt();
                            System.out.print("Enter Grade: ");
                            String grade = sc.next();
                            adminDAO.addResult(sid, subject, marks, grade);

                        } else if (adminChoice == 3) {
                            adminDAO.viewAllStudents();

                        } else if (adminChoice == 4) {
                            System.out.println("Admin logged out!");
                            break;
                        }
                    }
                } else {
                    System.out.println("Wrong admin password!");
                }

            } else if (choice == 2) {
                // Student login
                System.out.print("Enter Email: ");
                String email = sc.next();
                System.out.print("Enter Password: ");
                String pass = sc.next();
                int studentId = studentDAO.login(email, pass);
                if (studentId != -1) {
                    studentDAO.viewResults(studentId);
                }

            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            }
        }
        sc.close();
    }
}