public class SchoolTest {
    public static void main(String[] args) {
       
       
        Student student = new Student("Kert", 01, "3rd Year");
        Teacher teacher = new Teacher("Sim", 02, "Object Oriented Programming");
        Staff staff = new Staff("Jhovan", 03, "Discipline Office");
 
       
        System.out.println("Student Info:");
        student.displayInfo();
        System.out.println("\nTeacher Info:");
        teacher.displayInfo();
        System.out.println("\nStaff Info:");
        staff.displayInfo();
    }
}
 
 