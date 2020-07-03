package win.flrque.university.rownanie;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    final Scanner scanner = new Scanner(System.in);

        final double a, b, c;
        System.out.println("Podaj A: ");
        a = scanner.nextDouble();
        System.out.println("Podaj B: ");
        b = scanner.nextDouble();
        System.out.println("Podaj C: ");
        c = scanner.nextDouble();

        final double delta = Math.pow(b, 2) - (4*a*c);

        if(delta > 0) {
            double x1 = (-b - Math.sqrt(delta)) / (2*a);
            double x2 = (-b + Math.sqrt(delta)) / (2*a);

            System.out.println("x1: " + x1 + "; x2: " + x2);
        } else if(delta == 0) {
            double x0 = (-b)/(2*a);

            System.out.println("x0: " + x0);
        } else {
            System.out.println("Delta < 0: Brak wyniku");
        }
    }
}
