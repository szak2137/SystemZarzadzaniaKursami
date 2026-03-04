import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EducationalPlatform platform = new EducationalPlatform();

        Instructor instructor1 = new Instructor("Jan", "Kowalski");
        Instructor instructor2 = new Instructor("Anna", "Nowak");
        Instructor instructor3 = new Instructor("Piotr", "Wisniewski");
        platform.addInstructor(instructor1);
        platform.addInstructor(instructor2);
        platform.addInstructor(instructor3);

        User user1 = new User("Marek", "Zielinski",  "marek@example.com");
        User user2 = new User("Ewa",   "Dabrowska",  "ewa@example.com");
        User user3 = new User("Tomasz","Lewandowski", "tomasz@example.com");
        platform.registerUser(user1);
        platform.registerUser(user2);
        platform.registerUser(user3);

        Course course1 = new Course("Podstawy programowania", "Kurs wprowadzajacy do programowania", instructor1);
        Course course2 = new Course("Obsluga Excela",          "Nauka obslugi programu Excel",        instructor2);
        Course course3 = new Course("Bezpieczenstwo w sieci", "Podstawy cyberbezpieczenstwa",        instructor3);
        platform.addCourse(course1);
        platform.addCourse(course2);
        platform.addCourse(course3);

        Module module1 = new Module("Wprowadzenie");
        Test test1 = new Test(
                "Jakie jest glowne przeznaczenie jezyka Java?",
                Arrays.asList(
                        "Tworzenie stron internetowych",
                        "Tworzenie aplikacji mobilnych",
                        "Tworzenie aplikacji wieloplatformowych",
                        "Obsluga baz danych"
                ),
                2
        );
        module1.addTest(test1);
        course1.addModule(module1);

        while (true) {
            System.out.println("\nWybierz opcje:");
            System.out.println("1.  Dodaj kurs");
            System.out.println("2.  Zarejestruj uzytkownika");
            System.out.println("3.  Podejdz do testu");
            System.out.println("4.  Dodaj instruktora");
            System.out.println("5.  Zapisz uzytkownika na kurs");
            System.out.println("6.  Sprawdz zapisanych uzytkownikow kursu");
            System.out.println("7.  Lista wszystkich uczestnikow");
            System.out.println("8.  Lista wszystkich instruktorow");
            System.out.println("9.  Kursy ukonczOne przez uzytkownika");
            System.out.println("10. Wyjscie");
            System.out.print("Wybor: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Tytul kursu: ");
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
                        System.out.println("Kurs \"" + title + "\" zostal dodany.");
                    } else {
                        System.out.println("Niepoprawny wybor instruktora.");
                    }
                    break;
                }
                case 2: {
                    System.out.print("Imie: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Nazwisko: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    if (platform.registerUser(new User(firstName, lastName, email))) {
                        System.out.println("Uzytkownik " + firstName + " " + lastName + " zostal zarejestrowany.");
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
                        System.out.println("Niepoprawny wybor kursu.");
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
                            System.out.print("Wybierz odpowiedz (1-" + answers.size() + "): ");
                            int answer = scanner.nextInt() - 1;
                            scanner.nextLine();
                            if (test.checkAnswer(answer)) {
                                System.out.println("Poprawna odpowiedz!");
                            } else {
                                System.out.println("Niepoprawna odpowiedz. Prawidlowa: "
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
                    System.out.print("Imie instruktora: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Nazwisko instruktora: ");
                    String lastName = scanner.nextLine();
                    platform.addInstructor(new Instructor(firstName, lastName));
                    System.out.println("Instruktor " + firstName + " " + lastName + " zostal dodany.");
                    break;
                }
                case 5: {
                    List<User> users = platform.getUsers();
                    System.out.println("Wybierz uzytkownika:");
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
                        System.out.println("Niepoprawny wybor.");
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
                        System.out.println("Niepoprawny wybor kursu.");
                        break;
                    }
                    Course selected = courses.get(courseIdx);
                    List<User> enrolled = selected.getEnrolledUsers();
                    System.out.println("\nKurs: " + selected.getTitle());
                    System.out.println("Instruktor: " + selected.getInstructor().getFullName());
                    if (enrolled.isEmpty()) {
                        System.out.println("Brak zapisanych uzytkownikow.");
                    } else {
                        System.out.println("Zapisani uzytkownicy (" + enrolled.size() + "):");
                        for (int i = 0; i < enrolled.size(); i++) {
                            User u = enrolled.get(i);
                            System.out.println("  " + (i + 1) + ". " + u.getFullName() + " - " + u.getEmail());
                        }
                    }
                    break;
                }
                case 7: {
                    List<User> users = platform.getUsers();
                    System.out.println("\n=== Lista uczestnikow (" + users.size() + ") ===");
                    if (users.isEmpty()) {
                        System.out.println("Brak zarejestrowanych uzytkownikow.");
                    } else {
                        for (int i = 0; i < users.size(); i++) {
                            User u = users.get(i);
                            System.out.println((i + 1) + ". " + u.getFullName() + " - " + u.getEmail());
                        }
                    }
                    break;
                }
                case 8: {
                    List<Instructor> instructors = platform.getInstructors();
                    System.out.println("\n=== Lista instruktorow (" + instructors.size() + ") ===");
                    if (instructors.isEmpty()) {
                        System.out.println("Brak instruktorow.");
                    } else {
                        for (int i = 0; i < instructors.size(); i++) {
                            Instructor ins = instructors.get(i);
                            int courseCount = ins.getTaughtCourses().size();
                            System.out.println((i + 1) + ". " + ins.getFullName()
                                    + " (prowadzi kursow: " + courseCount + ")");
                        }
                    }
                    break;
                }
                case 9: {
                    List<User> users = platform.getUsers();
                    System.out.println("Wybierz uzytkownika:");
                    for (int i = 0; i < users.size(); i++) {
                        System.out.println((i + 1) + ". " + users.get(i).getFullName()
                                + " (" + users.get(i).getEmail() + ")");
                    }
                    int userIdx = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (userIdx < 0 || userIdx >= users.size()) {
                        System.out.println("Niepoprawny wybor uzytkownika.");
                        break;
                    }
                    User selectedUser = users.get(userIdx);
                    List<String> completed = selectedUser.getCompletedCourses();
                    System.out.println("\nUzytkownik: " + selectedUser.getFullName());
                    if (completed.isEmpty()) {
                        System.out.println("Brak ukonczonych kursow.");
                    } else {
                        System.out.println("Ukonczyne kursy (" + completed.size() + "):");
                        for (int i = 0; i < completed.size(); i++) {
                            System.out.println("  " + (i + 1) + ". " + completed.get(i));
                        }
                    }
                    break;
                }
                case 10:
                    System.out.println("Zakonczono program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Nieprawidlowa opcja, sprobuj ponownie.");
            }
        }
    }
}
