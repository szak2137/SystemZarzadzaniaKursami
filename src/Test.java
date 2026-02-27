import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Test extends CourseElement {
    private String question;
    private List<String> answers;
    private int correctAnswer;

    public Test(String question, List<String> answers, int correctAnswer) {
        super("Test: " + question);
        this.question      = question;
        this.answers       = new ArrayList<>(answers);
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion()         { return question; }
    public List<String> getAnswers()    { return Collections.unmodifiableList(answers); }
    public int getCorrectAnswer()       { return correctAnswer; }

    @Override
    public String describe() {
        return "Pytanie: " + question + " (liczba odpowiedzi: " + answers.size() + ")";
    }

    public boolean checkAnswer(int userAnswer) {
        return userAnswer == correctAnswer;
    }
}
