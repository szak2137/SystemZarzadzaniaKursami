import java.util.ArrayList;
import java.util.List;

public class Module {
    String title;
    List<Test> tests = new ArrayList<>();

    public Module(String title) {
        this.title = title;
    }

    void addTest(Test test) {
        tests.add(test);
    }
}
