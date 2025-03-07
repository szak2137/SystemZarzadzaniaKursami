import java.util.ArrayList;
import java.util.List;

public class Test {
    String question;
    List<String> answers = new ArrayList<>();
    int correctAnswer;

    public Test(String question, List<String> answers, int correctAnswer) {
        this.question = question;
        this.answers.addAll(answers);
        this.correctAnswer = correctAnswer;
    }
}
