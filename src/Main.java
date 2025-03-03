import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlatformaEdukacyjna platforma = new PlatformaEdukacyjna();
//
//        Instruktor instruktor = new Instruktor("Patrick", "Bateman");
//
//        Kurs kurs = new Kurs("Kurs na wózek widłowy", "Kurs uczący obsługi wózków widłowych", instruktor);
//        Modul modul = new Modul("Jazda wózkiem");
//
//        List<String> odpowiedzi = new ArrayList<>();
//        odpowiedzi.add("Typ danych");
//        odpowiedzi.add("Przechowywana wartość");
//        odpowiedzi.add("Klasa");
//
//        Test test = new Test("Co to jest zmienna w Javie?", odpowiedzi, 1);
//
//        modul.dodajTest(test);
//        kurs.dodajModul(modul);
//        platforma.dodajKurs(kurs);
//
//        System.out.println("Dodano kurs: " + kurs.tytul);
        Scanner scanner = new Scanner(System.in);


        List<Instruktor> instruktorzy = new ArrayList<>();
        instruktorzy.add(new Instruktor("Andrzej", "Kmicic"));
        instruktorzy.add(new Instruktor("Patrick", "Bateman"));
        instruktorzy.add(new Instruktor("Kacper", "Prokop"));
        instruktorzy.add(new Instruktor("John", "Johny"));
        instruktorzy.add(new Instruktor("Marcin", "Gortat"));

        List<Kurs> kursy = new ArrayList<>();
        kursy.add(new Kurs("Kurs javy", "Podstawowy kurs Javy", instruktorzy.get(0)));
        kursy.add(new Kurs("Kurs obsługi wózka widłowego", "Kurs dla operatorów wózków widłowych", instruktorzy.get(1)));
        kursy.add(new Kurs("Kurs podstaw Excela", "Kurs pracy z arkuszami kalkulacyjnymi", instruktorzy.get(2)));
        kursy.add(new Kurs("Kurs Cyberbzezpieczeństwa", "Ochrona danych i cyberbezpieczeństwo", instruktorzy.get(3)));
        kursy.add(new Kurs("Kurs pierwszej pomocy", "Podstawy udzielania pierwszej pomocy", instruktorzy.get(4)));

        kursy.forEach(platforma::dodajKurs);

        Kurs kursWozek = kursy.get(1);
        Modul modulWozek = new Modul("Bezpieczeństwo i obsługa");
        List<Test> testyWozek = new ArrayList<>();
        testyWozek.add(new Test("Jakie jest maksymalne obciążenie wózka?", new ArrayList<>(List.of("500 kg", "1000 kg", "Zależy od modelu")), 2));
        testyWozek.add(new Test("Co zrobić przed rozpoczęciem pracy?", new ArrayList<>(List.of("Sprawdzić poziom paliwa", "Przeczyścić wózek", "Skontrolować stan techniczny")), 2));
        testyWozek.add(new Test("Jakie są główne zagrożenia przy obsłudze wózka?", new ArrayList<>(List.of("Upadek ładunku", "Przebicie opony", "Zmęczenie kierowcy")), 0));
        testyWozek.forEach(modulWozek::dodajTest);
        kursWozek.dodajModul(modulWozek);

        System.out.println("Dostępne testy kursu 'Obsługa wózka widłowego':");
        for (int i = 0; i < testyWozek.size(); i++) {
            System.out.println((i + 1) + ". " + testyWozek.get(i).pytanie);
        }

        System.out.print("Wybierz numer pytania do rozwiązania: ");
        int wybor = scanner.nextInt() - 1;

        if (wybor >= 0 && wybor < testyWozek.size()) {
            Test wybranyTest = testyWozek.get(wybor);
            System.out.println(wybranyTest.pytanie);
            for (int i = 0; i < wybranyTest.odpowiedzi.size(); i++) {
                System.out.println((i + 1) + ". " + wybranyTest.odpowiedzi.get(i));
            }

            System.out.print("Wybierz numer odpowiedzi: ");
            int odpowiedz = scanner.nextInt() - 1;

            if (odpowiedz == wybranyTest.poprawnaOdpowiedz) {
                System.out.println("Poprawna odpowiedź!");
            } else {
                System.out.println("Błędna odpowiedź. Poprawna to: " + (wybranyTest.poprawnaOdpowiedz + 1));
            }
        } else {
            System.out.println("Niepoprawny wybór pytania.");
        }


    }
}