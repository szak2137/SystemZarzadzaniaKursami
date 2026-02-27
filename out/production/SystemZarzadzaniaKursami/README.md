# System zarządzania kursami online

### Opis projektu

System zarząrzania kursami online to aplikacja konsolowa, która pozwala na dodawanie kursów, rejestrację użytkowników, przypisywanie instruktorów oraz przeprowadzanie testów sprawdzających wiedzę kursantów.
### Główne funkcjonalności

- **Dodawanie kursów** – możliwość dodawania nowych kursów do systemu.

- **Rejestrowanie użytkowników** – użytkownicy mogą się rejestrować, aby uczestniczyć w kursach.

- **Dodawanie instruktorów** – instruktorzy mogą być przypisywani do kursów.

- **Zapisywanie użytkowników na kursy** – użytkownicy mogą zapisywać się na kursy.

- **Rozwiązywanie testów** – użytkownicy mogą przystępować do testów sprawdzających ich wiedzę.

- **Historia ukończonych kursów** – system przechowuje informacje o zakończonych przez użytkownika kursach .

### Struktura aplikacji

- **EducationalPlatform** – klasa główna przechowująca listy kursów, użytkowników i instruktorów.

- **Course** – klasa reprezentująca kurs, zawiera informacje o instruktorze i modułach.

- **User** – klasa reprezentująca użytkownika systemu.

- **Instructor** – klasa reprezentująca instruktora prowadzącego kursy.

- **Module** – klasa reprezentująca moduł w kursie.

- **Test** – klasa reprezentująca test składający się z pytania i odpowiedzi.

- **Main** – klasa zawierająca logikę aplikacji oraz interfejs użytkownika w konsoli.

- **CourseStatus** - Enum przechowujący poziom postępu kursu. 


### Obsługa aplikacji

Po uruchomieniu aplikacji użytkownik zobaczy menu z następującymi opcjami:

**1. Dodaj kurs** – dodanie nowego kursu do systemu.

**2. Zarejestruj użytkownika** – rejestracja nowego użytkownika.

**3. Podejdź do testu** – wybranie kursu i podejście do testu (jeśli kurs posiada test).

**4. Dodaj instruktora** – dodanie nowego instruktora do systemu.

**5. Zapisz użytkownika na kurs** – zapisanie zarejestrowanego użytkownika na wybrany kurs.

**6. Wyjście** – zakończenie programu.

### Przykładowe dane

Aplikacja zawiera kilka domyślnych kursów, instruktorów i użytkowników, co pozwala na szybkie przetestowanie funkcjonalności bez konieczności ręcznego wprowadzania danych.

### Autor: Szymon Żak

