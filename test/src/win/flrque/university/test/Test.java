package win.flrque.university.test;

import java.util.LinkedList;
import java.util.List;

public class Test {

    private final List<Question> questionList = new LinkedList<>();

    private int score = 0;
    private int questionIndex = -1;

    private QuizWindow window;

    public Test() {
        this.window = new QuizWindow(this);
    }

    private void init() {
        testInstance.questionList.add(new Question("Czym jest skrót \"RAM\"?", "Range Attack Master", "Random Access Memory", Answer.ANSWER_B));
        testInstance.questionList.add(new Question("Do jakich języków programowania zaliczmy język Java?", "Zorientowanych Obiektowo", "Do wszystkich na raz!", Answer.ANSWER_A));
        testInstance.questionList.add(new Question("Bez jakiego akcesorium nie obsłużysz komputera?", "Słuchawki Razer Electra V2 USB", "Klawiatura", Answer.ANSWER_B));
        testInstance.questionList.add(new Question("Do jakich urządzeń zaliczamy monitor(Wyświetlacz)?", "Urządzenia wyjścia", "Urządzenia wejścia", Answer.ANSWER_A));
        testInstance.questionList.add(new Question("W jakim urządzeniu najczęściej pojawiają się procesory typu x86?", "Komputer stacjonarny", "Telefon komórkowy z lat 90'", Answer.ANSWER_A));

        this.window.init();
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public Question getCurrentQuestion() {
        return questionList.get(questionIndex);
    }

    public Question nextQuestion() {
        if(questionIndex == questionList.size()-1) {
            questionIndex = -1;
            return null;
        }

        questionIndex++;
        return questionList.get(questionIndex);
    }

    public int getQuestionIndex() {
        return questionIndex;
    }

    public void addPoint() {
        score++;
    }

    public void resetScoreboard() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    private static Test testInstance;

    public static void main(String[] args) {
        testInstance = new Test();
        testInstance.init();
    }

}
