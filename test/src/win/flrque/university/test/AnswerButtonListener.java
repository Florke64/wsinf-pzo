package win.flrque.university.test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerButtonListener implements ActionListener {

    private final Test quiz;
    private final QuizWindow window;

    public AnswerButtonListener(QuizWindow quizWindow) {
        this.window = quizWindow;
        this.quiz = quizWindow.getQuiz();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        final Button clickedButton = (Button) actionEvent.getSource();
        final Answer selectedAnswer;
        if(clickedButton.getName().contentEquals("A")) {
            selectedAnswer = Answer.ANSWER_A;
        } else {
            selectedAnswer = Answer.ANSWER_B;
        }
        if(quiz.getCurrentQuestion().isCorrect(selectedAnswer)) {
            quiz.addPoint();
        }

        window.displayQuestion(quiz.nextQuestion());
    }

}
