package BuilderDesignPattern;

public class Main {
    public static void main(String[] args) {
        Director director1 = new Director(new EngineeringStudentBuilder());
        Director director2 = new Director(new MBAStudentBuilder());

        Student enggStudent = director1.createStudent();
        Student mbaStudent = director2.createStudent();

        System.out.println("Engineering Student Details: ");
        System.out.println(enggStudent.toString());
        System.out.println("MBA Student Details: ");
        System.out.println(mbaStudent.toString());
    }
}
