import java.util.ArrayList;
import java.util.List;

public class Test {
    String pytanie;
    List<String> odpowiedzi = new ArrayList<>();
    int poprawnaOdpowiedz;

    public Test(String pytanie, List<String> odpowiedzi, int poprawnaOdpowiedz) {
        this.pytanie = pytanie;
        this.odpowiedzi = odpowiedzi;
        this.poprawnaOdpowiedz = poprawnaOdpowiedz;
    }
}
