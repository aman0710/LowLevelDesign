package BuilderPattern;

import java.util.ArrayList;

public class EngineeringStudentBuilder extends StudentBuilder{
    @Override
    public StudentBuilder setSubjects() {
        this.subjects = new ArrayList<>();
        this.subjects.add("OOP");
        this.subjects.add("Computer Networks");
        this.subjects.add("System Design");
        return this;
    }
}
