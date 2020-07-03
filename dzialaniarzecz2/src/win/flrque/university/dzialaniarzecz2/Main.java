package win.flrque.university.dzialaniarzecz2;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        final int liczba1 = 55, liczba2 = 335;
        final DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);

        System.out.println("Liczba1 = " + liczba1);
        System.out.println("Liczba2 = " + liczba2);
        System.out.println("=== ==== ==== ==== ===");

        float wynik = liczba1 + liczba2;
        System.out.println("Ich suma: " + df.format(wynik));

        wynik = liczba1 - liczba2;
        System.out.println("Ich roznica: " + df.format(wynik));

        wynik = liczba1 * liczba2;
        System.out.println("Ich iloczyn: " + df.format(wynik));

        if(liczba2 != 0) {

            wynik = (float) liczba1 / (float) liczba2;
            System.out.println("Ich iloraz: " + df.format(wynik));
        } else {
            System.out.println("Ich ilorazu nie mozna policzyc, poniewaz liczba2 = 0");
        }

    }

}