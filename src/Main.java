import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EducationalPlatform platform = new EducationalPlatform();

        // Domyślni instruktorzy
        Instructor instructor1 = new Instructor("Jan", "Kowalski");
        Instructor instructor2 = new Instructor("Anna", "Nowak");
        Instructor instructor3 = new Instructor("Piotr", "Wiśniewski");
        platform.addInstructor(instructor1);
        platform.addInstructor(instructor2);
        platform.addInstructor(instructor3);

        // Domyślni użytkownicy
        User user1 = new User("Marek", "Zieliński",  "marek@example.com");
        User user2 = new User("Ewa",   "Dąbrowska",  "ewa@example.com");
        User user3 = new User("Tomasz","Lewandowski", "tomasz@example.com");
        platform.registerUser(user1);
        platform.registerUser(user2);
        platform.registerUser(user3);

        // Domyślne kursy
        Course course1 = new Course("Podstawy programowania", "Kurs wprowadzający do programowania", instructor1);
        Course course2 = new Course("Obsługa Excela",          "Nauka obsługi programu Excel",        instructor2);
        Course course3 = new Course("Bezpieczeństwo w sieci", "Podstawy cyberbezpieczeństwa",        instructor3);
        platform.addCourse(course1);
        platform.addCourse(course2);
        platform.addCourse(course3);

        // Moduł i test dla kursu 1
        Module module1 = new Module("Wprowadzenie");
        Test test1 = new Test(
                "Jakie jest główne przeznaczenie języka Java?",
                Arrays.asList(
                        "Tworzenie stron internetowych",
                        "Tworzenie aplikacji mobilnych",
                        "Tworzenie aplikacji wieloplatformowych",
                        "Obsługa baz danych"
                ),
                2
        );
        module1.addTest(test1);
        course1.addModule(module1);

        // Pętla główna
        while (true) {
            System.out.println("\nWybierz opcję:");
            System.out.println("1. Dodaj kurs");
            System.out.println("2. Zarejestruj użytkownika");
            System.out.println("3. Podejdź do testu");
            System.out.println("4. Dodaj instruktora");
            System.out.println("5. Zapisz użytkownika na kurs");
            System.out.println("6. Sprawdź zapisanych użytkowników kursu");
            System.out.println("7. Wyjście");
            System.out.print("Wybór: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Tytuł kursu: ");
                    String title = scanner.nextLine();
                    System.out.print("Opis kursu: ");
                    String desc = scanner.nextLine();

                    List<Instructor> instructors = platform.getInstructors();
                    System.out.println("Wybierz instruktora:");
                    for (int i = 0; i < instructors.size(); i++) {
                        System.out.println((i + 1) + ". " + instructors.get(i).getFullName());
                    }
                    int idx = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (idx >= 0 && idx < instructors.size()) {
                        platform.addCourse(new Course(title, desc, instructors.get(idx)));
                        System.out.println("Kurs \"" + title + "\" został dodany.");
                    } else {
                        System.out.println("Niepoprawny wybór instruktora.");
                    }
                    break;
                }
                case 2: {
                    System.out.print("Imię: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Nazwisko: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    if (platform.registerUser(new User(firstName, lastName, email))) {
                        System.out.println("Użytkownik " + firstName + " " + lastName + " został zarejestrowany.");
                    }
                    break;
                }
                case 3: {
                    List<Course> courses = platform.getCourses();
                    System.out.println("Wybierz kurs do testu:");
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println((i + 1) + ". " + courses.get(i).getTitle());
                    }
                    int courseIdx = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (courseIdx < 0 || courseIdx >= courses.size()) {
                        System.out.println("Niepoprawny wybór kursu.");
                        break;
                    }

                    Course selectedCourse = courses.get(courseIdx);
                    boolean hasTest = false;

                    for (Module module : selectedCourse.getModules()) {
                        for (Test test : module.getTests()) {
                            hasTest = true;
                            System.out.println("\n" + test.getQuestion());
                            List<String> answers = test.getAnswers();
                            for (int i = 0; i < answers.size(); i++) {
                                System.out.println((i + 1) + ". " + answers.get(i));
                            }
                            System.out.print("Wybierz odpowiedź (1-" + answers.size() + "): ");
                            int answer = scanner.nextInt() - 1;
                            scanner.nextLine();

                            if (test.checkAnswer(answer)) {
                                System.out.println("Poprawna odpowiedź!");
                            } else {
                                System.out.println("Niepoprawna odpowiedź. Prawidłowa: "
                                        + answers.get(test.getCorrectAnswer()));
                            }
                        }
                    }

                    if (!hasTest) {
                        System.out.println("Ten kurs nie zawiera testu.");
                    }
                    break;
                }
                case 4: {
                    System.out.print("Imię instruktora: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Nazwisko instruktora: ");
                    String lastName = scanner.nextLine();
                    platform.addInstructor(new Instructor(firstName, lastName));
                    System.out.println("Instruktor " + firstName + " " + lastName + " został dodany.");
                    break;
                }
                case 5: {
                    List<User> users = platform.getUsers();
                    System.out.println("Wybierz użytkownika:");
                    for (int i = 0; i < users.size(); i++) {
                        System.out.println((i + 1) + ". " + users.get(i).getFullName()
                                + " (" + users.get(i).getEmail() + ")");
                    }
                    int userIdx = scanner.nextInt() - 1;
                    scanner.nextLine();

                    List<Course> courses = platform.getCourses();
                    System.out.println("Wybierz kurs:");
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println((i + 1) + ". " + courses.get(i).getTitle());
                    }
                    int courseIdx = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (userIdx >= 0 && userIdx < users.size()
                            && courseIdx >= 0 && courseIdx < courses.size()) {
                        users.get(userIdx).enrollInCourse(courses.get(courseIdx));
                    } else {
                        System.out.println("Niepoprawny wybór.");
                    }
                    break;
                }
                case 6: {
                    List<Course> courses = platform.getCourses();
                    System.out.println("Wybierz kurs:");
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println((i + 1) + ". " + courses.get(i).getTitle());
                    }
                    int courseIdx = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (courseIdx < 0 || courseIdx >= courses.size()) {
                        System.out.println("Niepoprawny wybór kursu.");
                        break;
                    }

                    Course selected = courses.get(courseIdx);
                    List<User> enrolled = selected.getEnrolledUsers();

                    System.out.println("\nKurs: " + selected.getTitle());
                    System.out.println("Instruktor: " + selected.getInstructor().getFullName());
                    if (enrolled.isEmpty()) {
                        System.out.println("Brak zapisanych użytkowników.");
                    } else {
                        System.out.println("Zapisani użytkownicy (" + enrolled.size() + "):");
                        for (int i = 0; i < enrolled.size(); i++) {
                            User u = enrolled.get(i);
                            System.out.println("  " + (i + 1) + ". "
                                    + u.getFullName() + " – " + u.getEmail());
                        }
                    }
                    break;
                }
                case 7:
                    System.out.println("Zakończono program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Nieprawidłowa opcja, spróbuj ponownie.");
            }
        }
    }
}