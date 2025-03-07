import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EducationalPlatform platform = new EducationalPlatform();
//
//        Instructor Instructor = new Instructor("Patrick", "Bateman");
//
//        Course Course = new Course("Course na wózek widłowy", "Course uczący obsługi wózków widłowych", Instructor);
//        Module Module = new Module("Jazda wózkiem");
//
//        List<String> answers = new ArrayList<>();
//        answers.add("Typ danych");
//        answers.add("Przechowywana wartość");
//        answers.add("Klasa");
//
//        Test test = new Test("Co to jest zmienna w Javie?", answers, 1);
//
//        Module.addTest(test);
//        Course.addModule(Module);
//        platform.addCourse(Course);
//
//        System.out.println("Dodano Course: " + Course.title);
        Scanner scanner = new Scanner(System.in);


        List<Instructor> instructors = new ArrayList<>();
        instructors.add(new Instructor("Andrzej", "Kmicic"));
        instructors.add(new Instructor("Patrick", "Bateman"));
        instructors.add(new Instructor("Kacper", "Prokop"));
        instructors.add(new Instructor("John", "Johny"));
        instructors.add(new Instructor("Marcin", "Gortat"));

        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Course javy", "Podstawowy Course Javy", instructors.get(0)));
        courses.add(new Course("Course obsługi wózka widłowego", "Course dla operatorów wózków widłowych", instructors.get(1)));
        courses.add(new Course("Course podstaw Excela", "Course pracy z arkuszami kalkulacyjnymi", instructors.get(2)));
        courses.add(new Course("Course Cyberbzezpieczeństwa", "Ochrona danych i cyberbezpieczeństwo", instructors.get(3)));
        courses.add(new Course("Course pierwszej pomocy", "Podstawy udzielania pierwszej pomocy", instructors.get(4)));

        courses.forEach(platform::addCourse);

        Course courseForklift = courses.get(1);
        Module moduleForklift = new Module("Bezpieczeństwo i obsługa");
        List<Test> testsForklift = new ArrayList<>();
        testsForklift.add(new Test("Jakie jest maksymalne obciążenie wózka?", new ArrayList<>(List.of("500 kg", "1000 kg", "Zależy od modelu")), 2));
        testsForklift.add(new Test("Co zrobić przed rozpoczęciem pracy?", new ArrayList<>(List.of("Sprawdzić poziom paliwa", "Przeczyścić wózek", "Skontrolować stan techniczny")), 2));
        testsForklift.add(new Test("Jakie są główne zagrożenia przy obsłudze wózka?", new ArrayList<>(List.of("Upadek ładunku", "Przebicie opony", "Zmęczenie kierowcy")), 0));
        testsForklift.forEach(moduleForklift::addTest);
        courseForklift.addModule(moduleForklift);

        System.out.println("Dostępne tests kursu 'Obsługa wózka widłowego':");
        for (int i = 0; i < testsForklift.size(); i++) {
            System.out.println((i + 1) + ". " + testsForklift.get(i).question);
        }

        System.out.print("Wybierz numer pytania do rozwiązania: ");
        int choice = scanner.nextInt() - 1;

        if (choice >= 0 && choice < testsForklift.size()) {
            Test chosenTest = testsForklift.get(choice);
            System.out.println(chosenTest.question);
            for (int i = 0; i < chosenTest.answers.size(); i++) {
                System.out.println((i + 1) + ". " + chosenTest.answers.get(i));
            }

            System.out.print("Wybierz numer answers: ");
            int answer = scanner.nextInt() - 1;

            if (answer == chosenTest.correctAnswer) {
                System.out.println("Poprawna odpowiedź!");
            } else {
                System.out.println("Błędna odpowiedź. Poprawna to: " + (chosenTest.correctAnswer + 1));
            }
        } else {
            System.out.println("Niepoprawny wybór pytania.");
        }


    }
}