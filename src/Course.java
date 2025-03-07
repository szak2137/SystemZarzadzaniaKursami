import java.util.ArrayList;
import java.util.List;

public class Course {
    String title;
    String opis;
    Instructor Instructor;
    List<Module> moduly = new ArrayList<>();
    CourseStatus status;
    List<User> zapisaniUzytkownicy = new ArrayList<>();

    public Course(String title, String opis, Instructor Instructor) {
        this.title = title;
        this.opis = opis;
        this.Instructor = Instructor;
        this.status = CourseStatus.NEW;
    }

    void dodajModul(Module Module) {
        moduly.add(Module);
    }
    void zapiszUsera(User User) {
        zapisaniUzytkownicy.add(User);
        System.out.println(User.name + " " + User.surname + " zapisał(a) się na Course: " + title);
    }
}
