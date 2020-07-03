package win.flrque.university.imieinazwisko;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj swoje imie: ");
        final String imie = scanner.nextLine();

        System.out.println("Podaj swoje nazwisko: ");
        final String nazwisko = scanner.nextLine();

        System.out.println("");
        System.out.println("Twoje imie: " + imie);
        System.out.println("Twoje nazwisko: " + nazwisko);
    }
}
