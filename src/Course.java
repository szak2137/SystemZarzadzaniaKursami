import java.util.*;
class Course {
    private String title;
    private String description;
    private Instructor instructor;
    private List<Module> modules       = new ArrayList<>();
    private List<User>   enrolledUsers = new ArrayList<>();

    public Course(String title, String description, Instructor instructor) {
        this.title       = title;
        this.description = description;
        this.instructor  = instructor;
        instructor.addTaughtCourse(this);
    }

    public String     getTitle()       { return title; }
    public String     getDescription() { return description; }
    public Instructor getInstructor()  { return instructor; }

    public void addModule(Module module) {
        modules.add(module);
    }

    public List<Module> getModules() {
        return Collections.unmodifiableList(modules);
    }

    public List<User> getEnrolledUsers() {
        return Collections.unmodifiableList(enrolledUsers);
    }

    // Pakietowy dostęp – wywołuje User.enrollInCourse(), nie bezpośrednio
    void enrollUser(User user) {
        boolean alreadyEnrolled = enrolledUsers.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(user.getEmail()));

        if (alreadyEnrolled) {
            System.out.println("Użytkownik z emailem " + user.getEmail()
                    + " jest już zapisany na kurs: " + title);
            return;
        }

        enrolledUsers.add(user);
        System.out.println(user.getFullName() + " zapisał się na kurs: " + title);
    }

    @Override
    public String toString() {
        return title + " (instruktor: " + instructor.getFullName() + ")";
    }
}