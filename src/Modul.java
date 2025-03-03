import java.util.ArrayList;
import java.util.List;

public class Modul {
    String tytul;
    List<Test> testy = new ArrayList<>();

    public Modul(String tytul) {
        this.tytul = tytul;
    }

    void dodajTest(Test test) {
        testy.add(test);
    }
}
