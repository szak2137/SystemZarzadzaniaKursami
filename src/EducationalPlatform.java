import java.util.List;
import java.util.ArrayList;
public class EducationalPlatform {
    List<Course> courses = new ArrayList<>();
    List<User> users = new ArrayList<>();
    List<Instructor> instructors = new ArrayList<>();

    void addCourse(Course Course) {
        courses.add(Course);
    }

    void registerUser(User User) {
        users.add(User);
    }
    void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }
}