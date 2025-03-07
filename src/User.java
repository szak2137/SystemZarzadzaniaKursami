import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    String surname;
    String email;
    List<String> completedCourses = new ArrayList<>();

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    void completeCourse(String courseTitle) {
        completedCourses.add(courseTitle);
        System.out.println(name + " " + surname + " ukończył kurs: " + courseTitle);
    }
}
