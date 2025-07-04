package BuilderDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class EngineeringStudentBuilder extends StudentBuilder{

    @Override
    public StudentBuilder setSubjects() {
        List<String> subs = new ArrayList<>();
        subs.add("Computer Architecture");
        subs.add("OS");
        subs.add("DSA");
        this.subjects = subs;

        return this;
    }
}
