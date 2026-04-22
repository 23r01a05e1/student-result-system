public class Student {
    private int id;
    private String name;
    private String rollNumber;
    private String email;
    private String password;

    public Student(int id, String name, String rollNumber, String email, String password) {
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
        this.email = email;
        this.password = password;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getRollNumber() { return rollNumber; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + 
               ", rollNumber=" + rollNumber + ", email=" + email + "]";
    }
}