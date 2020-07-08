package win.flrque.university.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class QuizWindow extends Frame implements ActionListener {

    private final Test quiz;

    private final WindowListener windowListener;
    private final ActionListener answerButtonListener;

    private TextField firstName, surName, indexNumber;
    private Label firstNameLabel, surNameLabel, indexNumberLabel;

    private Button startTestButton;

    private Label messageContent, footerLabel;
    private Button answerAButton, answerBButton;

    public QuizWindow(Test testInstance) {
        super("Quiz - Test!");

        this.quiz = testInstance;
        this.windowListener = new QuizWindowListener();
        addWindowListener(this.windowListener);

        this.answerButtonListener = new AnswerButtonListener(this);
    }

    public void init() {
        this.setLayout(null);
        this.setSize(420, 250);
        this.setResizable(false);
        this.setVisible(true);

        initWelcomeElements();
        intiQuizElements();

        this.repaint();
    }

    private void startQuiz() {
        this.quiz.resetScoreboard();

        this.answerAButton.setVisible(true);
        this.answerBButton.setVisible(true);
        this.startTestButton.setVisible(false);

        this.firstName.setEditable(false);
        this.surName.setEditable(false);
        this.indexNumber.setEditable(false);

        displayQuestion(quiz.nextQuestion());
    }

    private void displayResults() {
        this.answerAButton.setVisible(false);
        this.answerBButton.setVisible(false);
        this.startTestButton.setVisible(true);

        this.firstName.setEditable(true);
        this.surName.setEditable(true);
        this.indexNumber.setEditable(true);

        final StringBuilder message = new StringBuilder();
        message.append("Zdobyto ").append(quiz.getScore())
                .append(" punktów na ")
                .append(quiz.getQuestionList().size()).append("!");

        if(quiz.getScore() == quiz.getQuestionList().size()) {
            this.footerLabel.setText("Gratulacje!");
        } else {
            this.footerLabel.setText("Możesz spróbować raz jeszcze!");
        }

        this.messageContent.setText(message.toString());
    }

    public void displayQuestion(Question question) {
        if(question == null) {
            displayResults();
            return;
        }

        this.messageContent.setText(question.getQuestionContent());
        this.footerLabel.setText("Pytanie " + (quiz.getQuestionIndex() + 1) + " z " + quiz.getQuestionList().size());

        this.answerAButton.setLabel(question.getAnswerA());
        this.answerAButton.setVisible(true);

        this.answerBButton.setLabel(question.getAnswerB());
        this.answerBButton.setVisible(true);
    }

    private void initWelcomeElements() {
        firstNameLabel = new Label("Imię");
        firstNameLabel.setBounds(10, 50, 150, 25);
        this.add(firstNameLabel);

        surNameLabel = new Label("Nazwisko");
        surNameLabel.setBounds(170, 50, 150, 25);
        this.add(surNameLabel);

        indexNumberLabel = new Label("Nr Indeksu");
        indexNumberLabel.setBounds(330, 50, 80, 25);
        this.add(indexNumberLabel);

        firstName = new TextField();
        firstName.setBounds(10, 75, 150, 25);
        firstName.setEditable(true);
        this.add(firstName);

        surName = new TextField();
        surName.setBounds(170, 75, 150, 25);
        surName.setEditable(true);
        this.add(surName);

        indexNumber = new TextField();
        indexNumber.setBounds(330, 75, 80, 25);
        indexNumber.setEditable(true);
        this.add(indexNumber);

        startTestButton = new Button("Rozpocznij Test!");
        startTestButton.setBounds(10, 105, 400, 25);
        startTestButton.addActionListener(this);
        this.add(startTestButton);

        footerLabel = new Label("Przed rozpoczęciem testu, wypełnij pola ze swoimi danymi.");
        footerLabel.setBounds(10, 225, 400, 25);
        this.add(footerLabel);
    }

    private void intiQuizElements() {
        messageContent = new Label("");
        messageContent.setBounds(10, 130, 400, 50);
        this.add(messageContent);

        answerAButton = new Button("Odpowieź A");
        answerAButton.setBounds(10, 180, 190, 25);
        answerAButton.addActionListener(answerButtonListener);
        answerAButton.setName("A");
        answerAButton.setVisible(false);
        this.add(answerAButton);

        answerBButton = new Button("Odpowieź B");
        answerBButton.setBounds(220, 180, 190, 25);
        answerBButton.addActionListener(answerButtonListener);
        answerBButton.setName("B");
        answerBButton.setVisible(false);
        this.add(answerBButton);
    }

    public Test getQuiz() {
        return quiz;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Integer indexNumber;
        try {
            indexNumber = Integer.parseInt(this.indexNumber.getText());
        } catch (NumberFormatException e) {
            indexNumber = null;
        }

        final String error_message = "Przed rozpoczęciem, popraw wprowadzone dane";

        if(indexNumber == null) {
            footerLabel.setText(error_message + " (Numer indeksu)");
            return;
        }

        if(firstName.getText() == null || firstName.getText().isEmpty()) {
            footerLabel.setText(error_message + " (Imię)");
            return;
        }

        if(surName.getText() == null || surName.getText().isEmpty()) {
            footerLabel.setText(error_message + " (Nazwisko)");
            return;
        }

        startQuiz();
    }

}
