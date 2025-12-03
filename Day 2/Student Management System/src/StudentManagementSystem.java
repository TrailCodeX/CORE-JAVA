import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) throws UnderFlowException, OverFlowException {
        int id = 0;
        Student s = null;
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentServiceImp();

        int ch;
        do {
            System.out.println("------STUDENT MANAGEMENT SYSTEM------\n1. Add\n2. Display\n3. Delete\n4. Update\n5. Select by Id \n6. Exit");
            System.out.println("Enter the choice");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter student ID:");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter name:");
                    String name = sc.nextLine();
                    System.out.println("Enter course");
                    String course = sc.nextLine();
                    System.out.println("Enter age:");
                    int age = sc.nextInt();
                    service.addStudent(id, name, course, age);
                    break;
                case 2:
                    service.displayStudent();
                    break;
                case 3:
                    System.out.println("Enter the id you want to delete?");
                    id = sc.nextInt();
                    service.deleteStudent(id);
                    break;
                case 4:
                    System.out.println("Enter the id you want to update?");
                    id = sc.nextInt();
                    sc.nextLine();

                    try {
                        s = service.getStudentById(id);
                    } catch (UnderFlowException e) {
                        System.out.println(e.getMessage());
                    }

                    if (s != null) {
                        System.out.println("Enter new name:");
                        name = sc.nextLine();
                        System.out.println("Enter new course:");
                        course = sc.nextLine();
                        System.out.println("Enter new age:");
                        age = sc.nextInt();
                        service.updateStudent(id, name, course, age);
                    }
                    break;
                case 5:
                    System.out.println("Enter the student id to search:");
                    id = sc.nextInt();
                    service.getStudentById(id);
                    break;
                case 6:
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Invalid Choice! Enter a valid one");
            }
        } while(ch != 6);

    }
}
