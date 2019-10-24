package JavaKnowledege.deepCopy;


    class Course implements Cloneable
    {
        String subject1;
        String subject2;
        public Course(String subject1, String subject2){
            this.subject1 = subject1;
            this.subject2 = subject2;
        }

        protected Object clone() throws CloneNotSupportedException{ return super.clone();}
    }

    class Student implements Cloneable
    {
        String name;
        Course course;
        public Student(String name, Course course){
            this.name = name;
            this.course = course;
        }

        protected Object clone() throws CloneNotSupportedException{
            Student  student= (Student) super.clone();
            student.course = (Course) course.clone();
            return student;
        }
    }
public class deepCopy {
    public static void main(String[] args){
            Course science = new Course("CS", "Math");
            Student studentHung = new Student("Hung",science);
            Student student = null;

            try{
                student = (Student) studentHung.clone();
            }catch (CloneNotSupportedException e){ e.printStackTrace();}
        studentHung.course.subject1 = "CS310";
            System.out.println("Student " + studentHung.name + " has " + studentHung.course.subject1);
         student.name = "David";
         System.out.println("Other Student named "+ student.name + " has " + student.course.subject1);

    }
}


