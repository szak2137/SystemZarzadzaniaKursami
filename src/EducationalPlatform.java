import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
class EducationalPlatform {
    private List<Course>     courses     = new ArrayList<>();
    private List<User>       users       = new ArrayList<>();
    private List<Instructor> instructors = new ArrayList<>();

    public void addCourse(Course course)         { courses.add(course); }
    public void registerUser(User user)          { users.add(user); }
    public void addInstructor(Instructor instr)  { instructors.add(instr); }

    public List<Course>     getCourses()     { return Collections.unmodifiableList(courses); }
    public List<User>       getUsers()       { return Collections.unmodifiableList(users); }
    public List<Instructor> getInstructors() { return Collections.unmodifiableList(instructors); }
}
