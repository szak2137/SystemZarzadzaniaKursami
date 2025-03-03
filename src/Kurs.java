import java.util.ArrayList;
import java.util.List;

public class Kurs {
    String tytul;
    String opis;
    Instruktor instruktor;
    List<Modul> moduly = new ArrayList<>();
    StatusKursu status;

    public Kurs(String tytul, String opis, Instruktor instruktor) {
        this.tytul = tytul;
        this.opis = opis;
        this.instruktor = instruktor;
        this.status = StatusKursu.NOWY;
    }

    void dodajModul(Modul modul) {
        moduly.add(modul);
    }
}
