import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Module extends CourseElement {
    private List<Test> tests = new ArrayList<>();

    public Module(String title) {
        super(title);
    }

    public void addTest(Test test) {
        tests.add(test);
    }

    public List<Test> getTests() {
        return Collections.unmodifiableList(tests);
    }

    @Override
    public String describe() {
        return "Moduł: " + getTitle() + " (testów: " + tests.size() + ")";
    }
}