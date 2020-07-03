package win.flrque.university.imieinazwisko;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    final Scanner scanner = new Scanner(System.in);

	    System.out.println("Podaj x: ");
	    final double x = scanner.nextDouble();

        System.out.println("Wynik: " + funkcja_y(x));
    }

    private static double funkcja_y(double x) {
        if(x <= 0) {
            return (2*x) + 5;
        } else {
            return Math.sqrt(x);
        }
    }
}
