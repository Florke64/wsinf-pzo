package win.flrque.university.test;

public class Question {

    private final String questionContent;

    private final String answer_a, answer_b;
    private final Answer correctAnswer;

    public Question(String question, String answerA, String answerB, Answer correctAnswer) {
        this.questionContent = question;
        this.answer_a = answerA;
        this.answer_b = answerB;

        this.correctAnswer = correctAnswer;
    }

    public boolean isCorrect(Answer answer) {
        return answer.equals(this.correctAnswer);
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public String getAnswerA() {
        return answer_a;
    }

    public String getAnswerB() {
        return answer_b;
    }

}
