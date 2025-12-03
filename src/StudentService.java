import java.util.ArrayList;
import java.util.List;

interface StudentService{
    void addStudent(int id,String name,String course,int age) throws OverFlowException;
    int deleteStudent(int id) throws UnderFlowException;
    Student getStudentById(int id) throws UnderFlowException;
    void updateStudent(int id,String name,String course,int age) throws UnderFlowException;
      void displayStudent() throws UnderFlowException;

}


class StudentServiceImp implements StudentService{
    List<Student> list=new ArrayList<>();

    @Override
    public void addStudent(int id,String name,String course,int age) throws OverFlowException {
        if (list.size() >= 5) {
            throw new OverFlowException("Array OverFlow Exception!...Cannot have more than 5 students.");

        } else {
            list.add(new Student(id, name, course, age));
            System.out.println("Student added Successfully");
        }
    }

    @Override
    public int deleteStudent(int id) throws UnderFlowException{
        if(list.isEmpty()){
            throw new UnderFlowException("List is Empty.Cannot delete.");
        }
        boolean removed=list.removeIf(s->s.getId()==id);

        if(!removed){
            throw new UnderFlowException("Student ID " + id + " not found.");
        }else{
            System.out.println("Student deleted Successfully");
        }
        return 0;
    }
    public void displayStudent() throws UnderFlowException {
        if(list.isEmpty()){
            throw new UnderFlowException("List is Empty!..");
        }
        for(Student s: list){
            System.out.println("ID:"+s.getId()+"\tName:"+s.getName()+"\tCourse:"+s.getCourse()+"\tAge:"+s.getAge());
        }

    }

    public void updateStudent(int id, String name, String course, int age) throws UnderFlowException {
            if (list.isEmpty()) {
                throw new UnderFlowException("Array is empty, cannot update.");
            }

            for (Student s:list) {
                boolean found=false;
                if (s.getId() == id) {
                    found=true;
                    s.setName(name);
                    s.setCourse(course);
                    s.setAge(age);

                    System.out.println("Student updated successfully!");
                    return;
                }
                System.out.println("Student with ID " + id + " not found.");
            }
    }

    public Student getStudentById(int id) throws UnderFlowException {

            if (list.isEmpty()) {
                throw new UnderFlowException("Array is empty.");
            }
            boolean found=false;
            for (Student s:list) {
                if (s.getId() == id) {
                    found=true;
                    return s;
                }
            }

            System.out.println("Student with ID " + id + " not found.");

            return null;
    }


}

