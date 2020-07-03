package win.flrque.university.czterydzialania;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.util.Random;

public class CzteryDzialania extends Frame implements ActionListener {

    private final WindowListener windowListener;

    private final TextField baseNumber1Field, baseNumber2Field, resultFieldSuma, resultFieldRoznica, resultFieldIloczyn, resultFieldIloraz;
    private final Button submitButton, exitButton;

    private final Random random = new Random();

    private final DecimalFormat df = new DecimalFormat("0.00");

    public CzteryDzialania() {
        super("Suma Liczb");
        this.setLayout(null);
        this.setSize(430, 250);
        this.setVisible(true);

        baseNumber1Field = new TextField(Integer.toString(random.nextInt(100)));
        baseNumber1Field.setBounds(50, 50, 180, 25);
        add(baseNumber1Field);

        baseNumber2Field = new TextField(Integer.toString(random.nextInt(100)));
        baseNumber2Field.setBounds(50, 80, 180, 25);
        add(baseNumber2Field);

        resultFieldSuma = new TextField("");
        resultFieldSuma.setBounds(50, 110, 120+30+180, 25);
        resultFieldSuma.setEditable(false);
        add(resultFieldSuma);

        resultFieldRoznica = new TextField("");
        resultFieldRoznica.setBounds(50, 140, 120+30+180, 25);
        resultFieldRoznica.setEditable(false);
        add(resultFieldRoznica);

        resultFieldIloczyn = new TextField("");
        resultFieldIloczyn.setBounds(50, 170, 120+30+180, 25);
        resultFieldIloczyn.setEditable(false);
        add(resultFieldIloczyn);

        resultFieldIloraz = new TextField("");
        resultFieldIloraz.setBounds(50, 200, 120+30+180, 25);
        resultFieldIloraz.setEditable(false);
        add(resultFieldIloraz);

        exitButton = new Button("Zamknij");
        exitButton.setBounds(260, 50, 120, 25);
        add(exitButton);

        submitButton = new Button("Oblicz");
        submitButton.setBounds(260, 80, 120, 25);
        add(submitButton);

        windowListener = new CzteryDzialaniaWindowListener();
        addWindowListener(windowListener);

        submitButton.addActionListener(this);
        exitButton.addActionListener(this);

        repaint();
    }

    private static CzteryDzialania instance;

    public static void main(String[] args) {
        instance = new CzteryDzialania();
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

    private void errorMessage(String msg) {
        final StringBuilder message = new StringBuilder();
        message.append("Error: ").append(msg);

        JOptionPane.showMessageDialog(this, message.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
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

        final double sum = sum(a, b);
        final double diff = subtract(a, b);
        final double prod = multiply(a, b);
        final double quo = divide(a, b);

        resultFieldSuma.setText(a + " + " + b + " = " + sum);
        resultFieldRoznica.setText(a + " - " + b + " = " + diff);
        resultFieldIloczyn.setText(a + " * " + b + " = " + prod);
        resultFieldIloraz.setText(a + " / " + b + " = " + df.format(quo));

        if(b.doubleValue() == 0.0d && quo == Double.POSITIVE_INFINITY) {
            errorMessage("Nie mozna podzielic przez zero!");
        }

    }

    private Double sum(Double a, Double b) {
        return a.doubleValue() + b.doubleValue();
    }

    private Double subtract(Double a, Double b) {
        return a.doubleValue() - b.doubleValue();
    }

    private Double multiply(Double a, Double b) {
        return a.doubleValue() * b.doubleValue();
    }

    private Double divide(Double a, Double b) {
        if(b.doubleValue() == 0.0d) {
            return Double.POSITIVE_INFINITY;
        }

        return a.doubleValue() / b.doubleValue();
    }

    public WindowListener getWindowListener() {
        return windowListener;
    }
}
