import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
class EducationalPlatform {
    private List<Course>     courses     = new ArrayList<>();
    private List<User>       users       = new ArrayList<>();
    private List<Instructor> instructors = new ArrayList<>();

    public void addCourse(Course course)         { courses.add(course); }
    public boolean registerUser(User user) {
        boolean emailTaken = users.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(user.getEmail()));
        if (emailTaken) {
            System.out.println("Użytkownik z emailem " + user.getEmail() + " już istnieje w systemie.");
            return false;
        }
        users.add(user);
        return true;
    }
    public void addInstructor(Instructor instr)  { instructors.add(instr); }

    public List<Course>     getCourses()     { return Collections.unmodifiableList(courses); }
    public List<User>       getUsers()       { return Collections.unmodifiableList(users); }
    public List<Instructor> getInstructors() { return Collections.unmodifiableList(instructors); }
}
