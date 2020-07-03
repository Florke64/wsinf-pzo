package win.flrque.university.sumaliczb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.Random;

public class SumaLiczb extends Frame implements ActionListener {

    private final WindowListener windowListener;

    private TextField baseNumber1Field, baseNumber2Field, resultField;
    private Button submitButton, exitButton;

    private Random random = new Random();

    public SumaLiczb() {
        super("Suma Liczb");
        this.setLayout(null);
        this.setSize(430, 200);
        this.setVisible(true);

        baseNumber1Field = new TextField(Integer.toString(random.nextInt(100)));
        baseNumber1Field.setBounds(50, 50, 180, 25);
        add(baseNumber1Field);

        baseNumber2Field = new TextField(Integer.toString(random.nextInt(100)));
        baseNumber2Field.setBounds(50, 80, 180, 25);
        add(baseNumber2Field);

        resultField = new TextField("");
        resultField.setBounds(50, 110, 180, 25);
        resultField.setEditable(false);
        add(resultField);

        exitButton = new Button("Zamknij");
        exitButton.setBounds(260, 50, 120, 25);
        add(exitButton);

        submitButton = new Button("Oblicz");
        submitButton.setBounds(260, 80, 120, 55);
        add(submitButton);

        windowListener = new SumaLiczbWindowListener();
        addWindowListener(windowListener);

        submitButton.addActionListener(this);
        exitButton.addActionListener(this);

        repaint();
    }

    private static SumaLiczb instance;

    public static void main(String[] args) {
	    instance = new SumaLiczb();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(!(event.getSource() instanceof Button)) {
            return;
        }

        final Button source = (Button) event.getSource();

        if(source.equals(submitButton)) {
            showSumResult();
        } else if(source.equals(exitButton)) {
            System.exit(0);
        }
    }

    private void errorMessage(String msg) {
        final StringBuilder message = new StringBuilder();
        message.append("Error: ").append(msg);

        JOptionPane.showMessageDialog(this, message.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    private void showSumResult() {
        Integer a = null;
        Integer b = null;

        try {
            a = Integer.parseInt(baseNumber1Field.getText());
            b = Integer.parseInt(baseNumber2Field.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            errorMessage("Nie udało się odczytać liczb!");
        }

        if(a == null || b == null) {
            return;
        }

        final int sum = sum(a, b);

        resultField.setText(Integer.toString(sum));

    }

    private int sum(Integer a, Integer b) {
        return a.intValue() + b.intValue();
    }

    public WindowListener getWindowListener() {
        return windowListener;
    }
}
