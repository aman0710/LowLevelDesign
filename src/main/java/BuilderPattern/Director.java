package BuilderPattern;

public class Director {

    StudentBuilder studentBuilder;

    public Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent() {
        if(studentBuilder instanceof EngineeringStudentBuilder) {
            return createEngineeringStudent();
        } else if(studentBuilder instanceof MBAStudentBuilder) {
            return createMBAStudent();
        }
        return null;
    }

    private Student createEngineeringStudent() {
        return studentBuilder.setAge(18).setRollNumber(24).setName("Aman").setSubjects().setBranch("Computer Science").setFatherName("Dad").setMotherName("Mom").build();
    }

    private Student createMBAStudent() {
        return studentBuilder.setAge(19).setRollNumber(12).setName("Anonymous").setFatherName("Mr.Dad").setMotherName("Mrs.Mom").setSubjects().setMobileNumber("XXXXXXX123").setEmailId("anonymous@gmail.com").setBranch("Finance").build();
    }
}
