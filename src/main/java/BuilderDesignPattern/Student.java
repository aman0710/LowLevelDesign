package BuilderDesignPattern;

import java.util.List;

public class Student {
    int rollNumber;
    int age;
    String name;
    String fatherName;
    String motherName;
    List<String> subjects;

    public Student (StudentBuilder studentBuilder) {
        this.rollNumber = studentBuilder.rollNumber;
        this.age = studentBuilder.age;
        this.name = studentBuilder.name;
        this.fatherName = studentBuilder.fatherName;
        this.motherName = studentBuilder.motherName;
        this.subjects = studentBuilder.subjects;
    }

    public String toString() {
        String result = "";
        result += "Roll no: " + this.rollNumber;
        result += " Age: " + this.age;
        result += " Name: " + this.name;
        result += " Father's Name: " + this.fatherName;
        result += " Mother's Name: " + this.motherName;
        result += " Subjects: ";
        for(String subject: this.subjects)
            result += subject + " ";
        return result;
    }
}
