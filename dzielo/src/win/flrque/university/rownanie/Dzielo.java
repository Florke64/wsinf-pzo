package win.flrque.university.rownanie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class Dzielo extends JFrame {

    private static Dzielo instance;

    public static void main(String[] args) {
        instance = new Dzielo();
    }

    private static final Map<String, JTextField> components = new LinkedHashMap<>();

    public Dzielo() {
        super("Umowa o dzie?o");
        instance = this;

        //Ustawiam parametry okna (JFrame)
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        //Dodaje dwa panele do ktorych pozniej dodam komponenty
        JPanel panel_top = new JPanel();
        JPanel panel_bot = new JPanel();

        //Tworze komponenty do wprowadzania danych (Pola tekstowe i przyczisk "Oblicz")
        components.put("Imie", new JTextField(10));
        components.put("Nazwisko", new JTextField(10));
        components.put("Przepracowane godziny", new JTextField(10));
        components.put("Stawka godzinowa", new JTextField(10));

        //Tworze przyciski wyboru kosztu przychodu (20% / 50%)
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton koszt20 = new JRadioButton("Koszt przychodu 20%");
        koszt20.setSelected(true);
        buttonGroup.add(koszt20);
        JRadioButton koszt50 = new JRadioButton("Koszt przychodu 50%");
        buttonGroup.add(koszt50);

        //Dodaje wczesniej utworzone komponenty do panelu
        int panel_rows = components.size();
        panel_top.setLayout(new GridLayout(panel_rows+10,1));
        for(Map.Entry entry : components.entrySet()) {
            addToPanel(panel_top, entry);
        }

        panel_top.add(koszt50);
        panel_top.add(koszt20);

        //Tworze przycisk "Oblicz" i nadaje mu nas?uch na akcje uzytkownika
        JButton oblicz_button = new JButton("Oblicz");
        panel_top.add(oblicz_button);

        final JLabel WynWysokoscBrutto = new JLabel("");
        panel_top.add(WynWysokoscBrutto);

        final JLabel WynWysokoscPodatek = new JLabel("");
        panel_top.add(WynWysokoscPodatek);

        final JLabel WynWysokoscNetto = new JLabel("");
        panel_top.add(WynWysokoscNetto);

        oblicz_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Pobieram dane niezb?dne do oblicze?
                final double podatek = 0.18;
                final double koszt = koszt20.isSelected()? 0.20 : 0.50;
                final double stawkaGodzinowa = Double.parseDouble(components.get("Stawka godzinowa").getText());
                final double godziny = Double.parseDouble(components.get("Przepracowane godziny").getText());

                //obliczenia
                final double brutto = stawkaGodzinowa * godziny;
                final double wysokoscPodatku = brutto * podatek * (1.0-koszt);
                final double netto = brutto - wysokoscPodatku;

                final NumberFormat nf = new DecimalFormat("#0.00");
                WynWysokoscBrutto.setText("Wysokość płacy brutto: " + nf.format(brutto) + "z?\n");
                WynWysokoscPodatek.setText("Wysokość podatku: " + nf.format(wysokoscPodatku) + "z?\n");
                WynWysokoscNetto.setText("Wysokość płacy netto: " + nf.format(netto) + "z?\n");
            }
        });

        //Dodaje roboczy panel do panelu "matki"
        panel_bot.add(panel_top);

        //dodaje panel roboczy do okna i wyznaczam Layout
        add(panel_bot, BorderLayout.NORTH);

        setSize(400, 400);
    }

    private void addToPanel(JPanel panel, Map.Entry<String, JTextField> component) {
        panel.add(new JLabel(component.getKey()));
        panel.add(component.getValue());
    }
}