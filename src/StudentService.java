interface StudentService{
    void addStudent(int id,String name,String course,int age);
    int deleteStudent(int id);
    Student getStudentById(int id);
    void updateStudent(int id,String name,String course,int age);
      void displayStudent();

}


class StudentServiceImp implements StudentService{
    Student[] arr=new Student[5];
    int count=0;

    public void addStudent(int id,String name,String course,int age){
        try{
            if(count>=arr.length){
                throw new OverFlowException("Array OverFlow Exception!...Cannot have more than 5 students.");

            }else{
                arr[count]=new Student(id,name,course,age);
                count++;
            }
        }catch (OverFlowException e){
            e.printStackTrace();
        }
    }

    public int deleteStudent(int id){
        try{
            if(count==0){
                throw new UnderFlowException("Array is Empty.Cannot delete.");
            }
            for(int i=0;i<count;i++){
                if(arr[i].getId()==id){
                    arr[i]=arr[count-1];
                    arr[count-1]=null;
                    count--;
                    System.out.println("Student Deleted Successfully");
                    return 1;
                }
            }
            throw new UnderFlowException("Student ID " + id + " not found.");
        }catch(UnderFlowException e){
            e.printStackTrace();
        }
        return 0;
    }
    public void displayStudent(){
        try{
            if(count==0){
                throw new UnderFlowException("Array is Empty!..");
            }
            for(int i=0;i<count;i++){
                System.out.println(arr[i]);
            }

        }catch(UnderFlowException e){
            e.printStackTrace();
        }
    }

    public void updateStudent(int id, String name, String course, int age) {
        try {
            if (count == 0) {
                throw new UnderFlowException("Array is empty, cannot update.");
            }

            for (int i = 0; i < count; i++) {
                if (arr[i].getId() == id) {

                    arr[i].setName(name);
                    arr[i].setCourse(course);
                    arr[i].setAge(age);

                    System.out.println("Student updated successfully!");
                    return;
                }
            }

            System.out.println("Student with ID " + id + " not found.");

        } catch (UnderFlowException e) {
            e.printStackTrace();
        }
    }

    public Student getStudentById(int id) {
        try {
            if (count == 0) {
                throw new UnderFlowException("Array is empty. Cannot search.");
            }

            for (int i = 0; i < count; i++) {
                if (arr[i].getId() == id) {
                    return arr[i];
                }
            }

            System.out.println("Student with ID " + id + " not found.");
            return null;

        } catch (UnderFlowException e) {
            e.printStackTrace();
        }
        return null;
    }


}

