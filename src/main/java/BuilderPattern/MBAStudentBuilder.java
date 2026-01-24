package BuilderPattern;

import java.util.ArrayList;
import java.util.List;

public class MBAStudentBuilder extends StudentBuilder{
    @Override
    public StudentBuilder setSubjects() {
        this.subjects = new ArrayList<>();
        this.subjects.add("Economics");
        this.subjects.add("Finances");
        this.subjects.add("Strategy Planning");
        return this;
    }
}
