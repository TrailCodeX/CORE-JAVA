import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


interface StudentService {
    void addStudent(int var1, String var2, String var3, int var4) throws OverFlowException;

    int deleteStudent(int var1) throws UnderFlowException;

    Student getStudentById(int var1) throws UnderFlowException;

    void updateStudent(int var1, String var2, String var3, int var4) throws UnderFlowException;

    void displayStudent() throws UnderFlowException;
}




class StudentServiceImp implements StudentService {
    List<Student> list = new ArrayList();

    public void addStudent(int id, String name, String course, int age) throws OverFlowException {
        if (this.list.size() >= 5) {
            throw new OverFlowException("Array OverFlow Exception!...Cannot have more than 5 students.");
        } else {
            this.list.add(new Student(id, name, course, age));
            System.out.println("Student added Successfully");
        }
    }

    public int deleteStudent(int id) throws UnderFlowException {
        if (this.list.isEmpty()) {
            throw new UnderFlowException("List is Empty.Cannot delete.");
        } else {
            boolean removed = this.list.removeIf((s) -> s.getId() == id);
            if (!removed) {
                throw new UnderFlowException("Student ID " + id + " not found.");
            } else {
                System.out.println("Student deleted Successfully");
                return 0;
            }
        }
    }

    public void displayStudent() throws UnderFlowException {
        if (this.list.isEmpty()) {
            throw new UnderFlowException("List is Empty!..");
        } else {
            for(Student s : this.list) {
                PrintStream var10000 = System.out;
                int var10001 = s.getId();
                var10000.println("ID:" + var10001 + "\tName:" + s.getName() + "\tCourse:" + s.getCourse() + "\tAge:" + s.getAge());
            }

        }
    }

    public void updateStudent(int id, String name, String course, int age) throws UnderFlowException {
        if (this.list.isEmpty()) {
            throw new UnderFlowException("Array is empty, cannot update.");
        } else {
            for(Student s : this.list) {
                boolean found = false;
                if (s.getId() == id) {
                    found = true;
                    s.setName(name);
                    s.setCourse(course);
                    s.setAge(age);
                    System.out.println("Student updated successfully!");
                    return;
                }

                System.out.println("Student with ID " + id + " not found.");
            }

        }
    }

    public Student getStudentById(int id) throws UnderFlowException {
        if (this.list.isEmpty()) {
            throw new UnderFlowException("Array is empty. Cannot search.");
        } else {
            boolean found = false;

            for(Student s : this.list) {
                if (s.getId() == id) {
                    found = true;
                    return s;
                }
            }

            System.out.println("Student with ID " + id + " not found.");
            return null;
        }
    }
}
