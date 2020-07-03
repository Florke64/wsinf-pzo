package win.flrque.university.imieinazwisko;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    final Scanner scanner = new Scanner(System.in);

	    System.out.println("Podaj a: ");
	    final int a = scanner.nextInt();
        System.out.println("Podaj b: ");
	    final int b = scanner.nextInt();

        System.out.println("Obwód prostokąta= " + ((2*a)+(2*b)));
        System.out.println("Pole prostokąta= " + (a*b));
    }
}
