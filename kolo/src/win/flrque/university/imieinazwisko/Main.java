package win.flrque.university.imieinazwisko;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    final Scanner scanner = new Scanner(System.in);

	    System.out.println("Podaj promien kola: ");
	    final double r = scanner.nextDouble();

        System.out.println("Pole = " + ((Math.PI)*Math.pow(r, 2)));
        System.out.println("Obwód = " + ((Math.PI)*r*2));
    }
}
