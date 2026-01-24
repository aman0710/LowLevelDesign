package BuilderPattern;

import java.util.List;

public class Student {
    int rollNumber;
    int age;
    String name;
    String branch;
    String fatherName;
    String motherName;
    List<String> subjects;
    String mobileNumber;
    String emailId;

    Student(StudentBuilder studentBuilder) {
        this.rollNumber = studentBuilder.rollNumber;
        this.age = studentBuilder.age;
        this.branch = studentBuilder.branch;
        this.name = studentBuilder.name;
        this.fatherName = studentBuilder.fatherName;
        this.motherName = studentBuilder.motherName;
        this.mobileNumber = studentBuilder.mobileNumber;
        this.emailId = studentBuilder.emailId;
        this.subjects = studentBuilder.subjects;
    }

    public String toString() {

        StringBuilder subjects = new StringBuilder();
        subjects.append(" Subjects: ");
        for(String subject: this.subjects) {
            subjects.append(subject);
            subjects.append(" ");
        }
        String subs = subjects.toString();

        System.out.println("Student details:");

        return "Roll Number: " + this.rollNumber
                + " Name: " + this.name
                + " Age: " + this.age
                + " Branch: " + this.branch
                + " Father's Name: " + this.fatherName
                + " Mother's Name: " + this.motherName
                + " Mobile Number: " + this.mobileNumber
                + " Email ID: " + this.emailId
                + subs;
    }
}
