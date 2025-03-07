import java.util.ArrayList;
import java.util.List;

public class Course {
    String title;
    String description;
    Instructor Instructor;
    List<Module> modules = new ArrayList<>();
    CourseStatus status;
    List<User> signedUsers = new ArrayList<>();
    List<User> enrolledUsers = new ArrayList<>();

    public Course(String title, String description, Instructor Instructor) {
        this.title = title;
        this.description = description;
        this.Instructor = Instructor;
        this.status = CourseStatus.NEW;
    }

    void addModule(Module Module) {
        modules.add(Module);
    }
    void signUser(User User) {
        signedUsers.add(User);
        System.out.println(User.name + " " + User.surname + " zapisał(a) się na Course: " + title);
    }
    void enrollUser(User user) {
        enrolledUsers.add(user);
        System.out.println(user.name + " " + user.surname + " zapisał się na kurs: " + title);
    }
}
