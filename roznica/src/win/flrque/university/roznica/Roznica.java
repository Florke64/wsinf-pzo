package win.flrque.university.roznica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.util.Random;

public class Roznica extends Frame implements ActionListener {

    private final WindowListener windowListener;

    private final Label baseNumber1Label, baseNumber2Label, resultDesctiptionLabel, resultLabel;
    private final TextField baseNumber1Field, baseNumber2Field;
    private final Button submitButton, exitButton;

    private final Random random = new Random();

    private final DecimalFormat df = new DecimalFormat("0.00");

    public Roznica() {
        super("Suma Liczb");
        this.setLayout(null);
        this.setSize(430, 250);
        this.setVisible(true);

        baseNumber1Label = new Label("Liczba 1 = ");
        baseNumber1Label.setBounds(100, 50, 80, 25);
        baseNumber1Field = new TextField(Integer.toString(random.nextInt(100)));
        baseNumber1Field.setBounds(200, 50, 180, 25);
        add(baseNumber1Label);
        add(baseNumber1Field);

        baseNumber2Label = new Label("Liczba 2 = ");
        baseNumber2Label.setBounds(100, 80, 80, 25);
        baseNumber2Field = new TextField(Integer.toString(random.nextInt(100)));
        baseNumber2Field.setBounds(200, 80, 180, 25);
        add(baseNumber2Label);
        add(baseNumber2Field);

        resultDesctiptionLabel = new Label("Wynik = ");
        resultDesctiptionLabel.setBounds(100, 120, 80, 25);
        add(resultDesctiptionLabel);

        resultLabel = new Label("");
        resultLabel.setBounds(200, 120, 80, 25);
        add(resultLabel);

        submitButton = new Button("Oblicz");
        submitButton.setBounds(50, 160, 120, 25);
        add(submitButton);

        exitButton = new Button("Zamknij");
        exitButton.setBounds(260, 160, 120, 25);
        add(exitButton);

        windowListener = new RoznicaWindowListener();
        addWindowListener(windowListener);

        submitButton.addActionListener(this);
        exitButton.addActionListener(this);

        repaint();
    }

    private static Roznica instance;

    public static void main(String[] args) {
        instance = new Roznica();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(!(event.getSource() instanceof Button)) {
            return;
        }

        final Button source = (Button) event.getSource();

        if(source.equals(submitButton)) {
            showResults();
        } else if(source.equals(exitButton)) {
            System.exit(0);
        }
    }

    private void showResults() {
        Double a = null;
        Double b = null;

        try {
            a = Double.parseDouble(baseNumber1Field.getText());
            b = Double.parseDouble(baseNumber2Field.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            errorMessage("Nie udało się odczytać liczb!");
        }

        if(a == null || b == null) {
            return;
        }

        final double diff = subtract(a, b);

        resultLabel.setText(df.format(diff));

    }

    private Double subtract(Double a, Double b) {
        return a.doubleValue() - b.doubleValue();
    }

    private void errorMessage(String msg) {
        final StringBuilder message = new StringBuilder();
        message.append("Error: ").append(msg);

        JOptionPane.showMessageDialog(this, message.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public WindowListener getWindowListener() {
        return windowListener;
    }
}
