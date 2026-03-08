import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {

    private static void initializeData(EducationalPlatform platform) {
        Instructor kowalski    = new Instructor("Jan",     "Kowalski");
        Instructor nowak       = new Instructor("Anna",    "Nowak");
        Instructor wisniewski  = new Instructor("Piotr",   "Wisniewski");
        Instructor wojcik      = new Instructor("Katarzyna","Wojcik");
        Instructor kaminski    = new Instructor("Michal",  "Kaminski");
        platform.addInstructor(kowalski);
        platform.addInstructor(nowak);
        platform.addInstructor(wisniewski);
        platform.addInstructor(wojcik);
        platform.addInstructor(kaminski);
        User marek   = new User("Marek",   "Zielinski",   "marek@example.com");
        User ewa     = new User("Ewa",     "Dabrowska",   "ewa@example.com");
        User tomasz  = new User("Tomasz",  "Lewandowski", "tomasz@example.com");
        User kasia   = new User("Katarzyna","Wozniak",    "kasia@example.com");
        User adam    = new User("Adam",    "Nowicki",     "adam@example.com");
        User julia   = new User("Julia",   "Kowalczyk",  "julia@example.com");
        User rafal   = new User("Rafal",   "Majewski",   "rafal@example.com");
        platform.registerUser(marek);
        platform.registerUser(ewa);
        platform.registerUser(tomasz);
        platform.registerUser(kasia);
        platform.registerUser(adam);
        platform.registerUser(julia);
        platform.registerUser(rafal);
        Course javaPodstawy = new Course(
                "Podstawy programowania w Javie",
                "Wprowadzenie do programowania obiektowego w Javie",
                kowalski,
                LocalDate.of(2025, 1, 15), LocalDate.of(2025, 3, 15)
        );
        Course excel = new Course(
                "Obsluga Excela",
                "Nauka obslugi programu Excel od podstaw do poziomu zaawansowanego",
                nowak,
                LocalDate.of(2025, 2, 1), LocalDate.of(2025, 4, 1)
        );
        Course cybersec = new Course(
                "Bezpieczenstwo w sieci",
                "Podstawy cyberbezpieczenstwa i ochrony danych osobowych",
                wisniewski,
                LocalDate.of(2025, 3, 10), LocalDate.of(2025, 5, 10)
        );
        Course python = new Course(
                "Python dla poczatkujacych",
                "Kurs jezyka Python z elementami analizy danych",
                wojcik,
                LocalDate.of(2025, 4, 1), LocalDate.of(2025, 6, 30)
        );
        Course bazy = new Course(
                "Bazy danych SQL",
                "Projektowanie i zarzadzanie relacyjnymi bazami danych",
                kaminski,
                LocalDate.of(2025, 2, 15), LocalDate.of(2025, 4, 15)
        );
        Course webdev = new Course(
                "Tworzenie stron WWW",
                "HTML, CSS i podstawy JavaScript w praktyce",
                kowalski,
                LocalDate.of(2025, 5, 1), LocalDate.of(2025, 7, 31)
        );
        platform.addCourse(javaPodstawy);
        platform.addCourse(excel);
        platform.addCourse(cybersec);
        platform.addCourse(python);
        platform.addCourse(bazy);
        platform.addCourse(webdev);
        Module javaWprow = new Module("Wprowadzenie do Javy");
        javaWprow.addTest(new Test(
                "Jakie jest glowne przeznaczenie jezyka Java?",
                Arrays.asList(
                        "Tworzenie stron internetowych",
                        "Tworzenie aplikacji mobilnych",
                        "Tworzenie aplikacji wieloplatformowych",
                        "Obsluga baz danych"
                ), 2
        ));
        javaWprow.addTest(new Test(
                "Ktore slowo kluczowe sluzy do dziedziczenia w Javie?",
                Arrays.asList("implements", "extends", "inherits", "super"),
                1
        ));
        javaPodstawy.addModule(javaWprow);

        Module javaOop = new Module("Programowanie obiektowe");
        javaOop.addTest(new Test(
                "Czym jest enkapsulacja?",
                Arrays.asList(
                        "Ukrywanie szczegolów implementacji",
                        "Dziedziczenie po klasie bazowej",
                        "Przeciazanie metod",
                        "Tworzenie interfejsow"
                ), 0
        ));
        javaPodstawy.addModule(javaOop);

        Module excelWprow = new Module("Podstawy Excela");
        excelWprow.addTest(new Test(
                "Jakiej formuly uzywamy do sumowania zakresu komorek?",
                Arrays.asList("=ADD()", "=SUM()", "=TOTAL()", "=PLUS()"),
                1
        ));
        excel.addModule(excelWprow);

        Module cybersecWprow = new Module("Zagrozenia w sieci");
        cybersecWprow.addTest(new Test(
                "Co to jest phishing?",
                Arrays.asList(
                        "Technika szyfrowania danych",
                        "Rodzaj wirusa komputerowego",
                        "Metoda wyludzania poufnych informacji",
                        "Protokol sieciowy"
                ), 2
        ));
        cybersec.addModule(cybersecWprow);

        Module pythonWprow = new Module("Podstawy Pythona");
        pythonWprow.addTest(new Test(
                "Jak wypisac tekst na ekran w Pythonie?",
                Arrays.asList("echo()", "print()", "console.log()", "System.out.println()"),
                1
        ));
        python.addModule(pythonWprow);

        Module sqlWprow = new Module("Podstawy SQL");
        sqlWprow.addTest(new Test(
                "Ktore polecenie SQL sluzy do pobierania danych?",
                Arrays.asList("INSERT", "UPDATE", "SELECT", "DELETE"),
                2
        ));
        bazy.addModule(sqlWprow);
        marek.enrollInCourse(javaPodstawy);
        marek.enrollInCourse(bazy);
        ewa.enrollInCourse(excel);
        ewa.enrollInCourse(python);
        tomasz.enrollInCourse(cybersec);
        tomasz.enrollInCourse(javaPodstawy);
        kasia.enrollInCourse(python);
        kasia.enrollInCourse(webdev);
        adam.enrollInCourse(bazy);
        adam.enrollInCourse(cybersec);
        julia.enrollInCourse(webdev);
        julia.enrollInCourse(excel);
        rafal.enrollInCourse(javaPodstawy);
        marek.completeCourse("Podstawy programowania w Javie");
        ewa.completeCourse("Obsluga Excela");
        tomasz.completeCourse("Bezpieczenstwo w sieci");
        kasia.completeCourse("Python dla poczatkujacych");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EducationalPlatform platform = new EducationalPlatform();

        initializeData(platform);

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
            System.out.println("9.  Kursy ukonczne przez uzytkownika");
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
                        LocalDate startDate = null, endDate = null;
                        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        while (startDate == null) {
                            System.out.print("Data rozpoczecia (dd-MM-yyyy): ");
                            try { startDate = LocalDate.parse(scanner.nextLine(), fmt); }
                            catch (DateTimeParseException e) { System.out.println("Niepoprawny format daty. Uzyj dd-MM-yyyy."); }
                        }
                        while (endDate == null) {
                            System.out.print("Data zakonczenia (dd-MM-yyyy): ");
                            try {
                                LocalDate parsed = LocalDate.parse(scanner.nextLine(), fmt);
                                if (!parsed.isAfter(startDate)) { System.out.println("Data zakonczenia musi byc pozniejsza niz rozpoczecia."); }
                                else endDate = parsed;
                            } catch (DateTimeParseException e) { System.out.println("Niepoprawny format daty. Uzyj dd-MM-yyyy."); }
                        }
                        platform.addCourse(new Course(title, desc, instructors.get(idx), startDate, endDate));
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
                    System.out.println("Okres: " + selected.getStartDateFormatted() + " - " + selected.getEndDateFormatted());
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
                        System.out.println("Ukonczne kursy (" + completed.size() + "):");
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
