import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
class Course {
    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private String title;
    private String description;
    private Instructor instructor;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Module> modules       = new ArrayList<>();
    private List<User>   enrolledUsers = new ArrayList<>();

    public Course(String title, String description, Instructor instructor,
                  LocalDate startDate, LocalDate endDate) {
        this.title       = title;
        this.description = description;
        this.instructor  = instructor;
        this.startDate   = startDate;
        this.endDate     = endDate;
        instructor.addTaughtCourse(this);
    }

    public String     getTitle()       { return title; }
    public String     getDescription() { return description; }
    public Instructor getInstructor()  { return instructor; }
    public LocalDate  getStartDate()   { return startDate; }
    public LocalDate  getEndDate()     { return endDate; }

    public String getStartDateFormatted() { return startDate != null ? startDate.format(DATE_FMT) : "brak"; }
    public String getEndDateFormatted()   { return endDate   != null ? endDate.format(DATE_FMT)   : "brak"; }

    public void addModule(Module module) {
        modules.add(module);
    }

    public List<Module> getModules() {
        return Collections.unmodifiableList(modules);
    }

    public List<User> getEnrolledUsers() {
        return Collections.unmodifiableList(enrolledUsers);
    }

    void enrollUser(User user) {
        boolean alreadyEnrolled = enrolledUsers.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(user.getEmail()));

        if (alreadyEnrolled) {
            System.out.println("Uzytkownik z emailem " + user.getEmail()
                    + " jest juz zapisany na kurs: " + title);
            return;
        }

        enrolledUsers.add(user);
        System.out.println(user.getFullName() + " zapisal sie na kurs: " + title);
    }

    @Override
    public String toString() {
        return title + " (instruktor: " + instructor.getFullName() + ", " + getStartDateFormatted() + " - " + getEndDateFormatted() + ")";
    }
}