import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class User extends Person {
    private String email;
    private List<String> completedCourses = new ArrayList<>();
    private List<Course> enrolledCourses   = new ArrayList<>();

    public User(String firstName, String lastName, String email) {
        super(firstName, lastName);
        this.email = email;
    }

    @Override
    public String getRole() { return "Użytkownik"; }

    public String getEmail() { return email; }

    public void completeCourse(String courseTitle) {
        completedCourses.add(courseTitle);
        System.out.println(getFullName() + " ukończył kurs: " + courseTitle);
    }

    public void enrollInCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.enrollUser(this);
        } else {
            System.out.println(getFullName() + " jest już zapisany na kurs: " + course.getTitle());
        }
    }

    public List<String> getCompletedCourses() {
        return Collections.unmodifiableList(completedCourses);
    }

    public List<Course> getEnrolledCourses() {
        return Collections.unmodifiableList(enrolledCourses);
    }
}
