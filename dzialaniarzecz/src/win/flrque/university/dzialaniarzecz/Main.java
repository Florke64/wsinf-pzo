package win.flrque.university.dzialaniarzecz;

public class Main {

    public static void main(String[] args) {
        final int liczba1 = 55, liczba2 = 335;

        System.out.println("Liczba1 = " + liczba1);
        System.out.println("Liczba2 = " + liczba2);

        float wynik = liczba1 + liczba2;
        System.out.println("Ich suma: " +wynik);

        wynik = liczba1 - liczba2;
        System.out.println("Ich roznica: " +wynik);

        wynik = liczba1 * liczba2;
        System.out.println("Ich iloczyn: " +wynik);

        if(liczba2 != 0) {
            wynik = (float) liczba1 / (float) liczba2;
            System.out.println("Ich iloraz: " + wynik);
        } else {
            System.out.println("Ich ilorazu nie mozna policzyc, poniewaz liczba2 = 0");
        }

    }

}