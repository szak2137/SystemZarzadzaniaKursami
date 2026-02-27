import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Instructor extends Person {
    private List<Course> taughtCourses = new ArrayList<>();

    public Instructor(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String getRole() { return "Instruktor"; }

    public void addTaughtCourse(Course course) {
        taughtCourses.add(course);
    }

    public List<Course> getTaughtCourses() {
        return Collections.unmodifiableList(taughtCourses);
    }
}