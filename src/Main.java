import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EducationalPlatform platform = new EducationalPlatform();
        Instructor instructor1 = new Instructor("Marcin", "Gortat");
        Instructor instructor2 = new Instructor("Kacper", "Prokop");
        Instructor instructor3 = new Instructor("Piotr", "Gryf");
        platform.addInstructor(instructor1);
        platform.addInstructor(instructor2);
        platform.addInstructor(instructor3);

        User user1 = new User("Vernon", "Roche", "roche2137@gmail.com");
        User user2 = new User("Pan", "Tadeusz", "tadek@gmail.com.com");
        User user3 = new User("Wojciech", "Szczęsny", "wojtek@op.com");
        platform.registerUser(user1);
        platform.registerUser(user2);
        platform.registerUser(user3);

        Course course1 = new Course("Podstawy programowania", "Kurs wprowadzający do programowania", instructor1);
        Course course2 = new Course("Obsługa Excela", "Nauka obsługi programu Excel", instructor2);
        Course course3 = new Course("Bezpieczeństwo w sieci", "Podstawy cyberbezpieczeństwa", instructor3);
        platform.addCourse(course1);
        platform.addCourse(course2);
        platform.addCourse(course3);

        Module module1 = new Module("Wprowadzenie");
        Test test1 = new Test("Jakie jest główne przeznaczenie języka Java?",
                Arrays.asList("Tworzenie stron internetowych", "Tworzenie aplikacji mobilnych", "Tworzenie aplikacji wieloplatformowych", "Obsługa baz danych"), 3);
        module1.addTest(test1);
        course1.addModule(module1);


        while (true) {
            System.out.println("\nWybierz opcję:");
            System.out.println("1. Dodaj kurs");
            System.out.println("2. Zarejestruj użytkownika");
            System.out.println("3. Podejdź do testu");
            System.out.println("4. Dodaj instruktora");
            System.out.println("5. Zapisz użytkownika na kurs");
            System.out.println("6. Wyjście");
            System.out.print("Wybór: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Podaj tytuł kursu: ");
                    String courseTitle = scanner.nextLine();
                    System.out.print("Podaj opis kursu: ");
                    String courseDescription = scanner.nextLine();
                    System.out.print("Podaj imię instruktora: ");
                    String instructorFirstName = scanner.nextLine();
                    System.out.print("Podaj nazwisko instruktora: ");
                    String instructorLastName = scanner.nextLine();
                    Instructor instructor = new Instructor(instructorFirstName, instructorLastName);
                    Course newCourse = new Course(courseTitle, courseDescription, instructor);
                    platform.addCourse(newCourse);
                    System.out.println("Dodano kurs: " + courseTitle);
                    break;
                case 2:
                    System.out.print("Podaj imię użytkownika: ");
                    String name = scanner.nextLine();
                    System.out.print("Podaj nazwisko użytkownika: ");
                    String surname = scanner.nextLine();
                    System.out.print("Podaj email użytkownika: ");
                    String email = scanner.nextLine();
                    User newUser = new User(name, surname, email);
                    platform.registerUser(newUser);
                    System.out.println("Zarejestrowano użytkownika: " + name + " " + surname);
                    break;
                case 3:
                    System.out.println("Wybierz kurs do testu:");
                    for (int i = 0; i < platform.courses.size(); i++) {
                        System.out.println((i + 1) + ". " + platform.courses.get(i).title);
                    }
                    int courseIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (courseIndex >= 0 && courseIndex < platform.courses.size()) {
                        Course selectedCourse = platform.courses.get(courseIndex);
                        boolean hasTest = false;
                        for (Module module : selectedCourse.modules) {
                            for (Test test : module.tests) {
                                hasTest = true;
                                System.out.println(test.question);
                                for (int i = 0; i < test.answers.size(); i++) {
                                    System.out.println((i + 1) + ". " + test.answers.get(i));
                                }
                                System.out.print("Wybierz odpowiedź: ");
                                int answer = scanner.nextInt();
                                if (answer - 1 == test.correctAnswer) {
                                    System.out.println("Poprawna odpowiedź!");
                                } else {
                                    System.out.println("Niepoprawna odpowiedź.");
                                }
                            }
                        }
                        if (!hasTest) {
                            System.out.println("Ten kurs nie zawiera testu.");
                        }
                    } else {
                        System.out.println("Niepoprawny wybór kursu.");
                    }
                    break;
                case 4:
                    System.out.print("Podaj imię instruktora: ");
                    String newInstructorFirstName = scanner.nextLine();
                    System.out.print("Podaj nazwisko instruktora: ");
                    String newInstructorLastName = scanner.nextLine();
                    Instructor newInstructor = new Instructor(newInstructorFirstName, newInstructorLastName);
                    platform.addInstructor(newInstructor);
                    System.out.println("Dodano instruktora: " + newInstructorFirstName + " " + newInstructorLastName);
                    break;
                case 5:
                    System.out.print("Podaj imię użytkownika: ");
                    String userFirstName = scanner.nextLine();
                    System.out.print("Podaj nazwisko użytkownika: ");
                    String userLastName = scanner.nextLine();
                    System.out.print("Podaj tytuł kursu: ");
                    String userCourseTitle = scanner.nextLine();
                    Optional<User> userOpt = platform.users.stream().filter(u -> u.name.equals(userFirstName) && u.surname.equals(userLastName)).findFirst();
                    Optional<Course> courseOpt = platform.courses.stream().filter(c -> c.title.equals(userCourseTitle)).findFirst();
                    if (userOpt.isPresent() && courseOpt.isPresent()) {
                        courseOpt.get().enrollUser(userOpt.get());
                    } else {
                        System.out.println("Nie znaleziono użytkownika lub kursu.");
                    }
                    break;
                case 6:
                    System.out.println("Zakończono program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Nieprawidłowa opcja, spróbuj ponownie.");
                    break;
            }
        }

    }
}