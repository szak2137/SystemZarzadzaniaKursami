import java.util.List;
import java.util.ArrayList;
public class PlatformaEdukacyjna {
    List<Kurs> kursy = new ArrayList<>();
    List<Uzytkownik> uzytkownicy = new ArrayList<>();

    void dodajKurs(Kurs kurs) {
        kursy.add(kurs);
    }

    void zarejestrujUzytkownika(Uzytkownik uzytkownik) {
        uzytkownicy.add(uzytkownik);
    }
}