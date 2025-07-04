package BuilderDesignPattern;

public class Director {

    StudentBuilder studentBuilder;

    public Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent() {
        if(studentBuilder instanceof EngineeringStudentBuilder)
            return createEngineeringStudent();
        else if(studentBuilder instanceof MBAStudentBuilder)
            return createMBAStudent();
        return null;
    }

    public Student createEngineeringStudent() {
        return studentBuilder.setRollNumber(12).setAge(24).setName("Aman").setSubjects().build();
    }

    public Student createMBAStudent() {
        return studentBuilder.setRollNumber(15).setAge(25).setName("AK").setFatherName("ABCD").setMotherName("XYZ").setSubjects().build();
    }
}
