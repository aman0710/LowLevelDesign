package BuilderPattern;

import java.util.List;

public abstract class StudentBuilder {
    int rollNumber;
    int age;
    String name;
    String branch;
    String fatherName;
    String motherName;
    List<String> subjects;
    String mobileNumber;
    String emailId;

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
        return this;
    }

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder setBranch(String branch) {
        this.branch = branch;
        return this;
    }

    public StudentBuilder setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public StudentBuilder setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }

    abstract public StudentBuilder setSubjects();

    public StudentBuilder setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public StudentBuilder setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public Student build() {
        return new Student(this);
    }
}
