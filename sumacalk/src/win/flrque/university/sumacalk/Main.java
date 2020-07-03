package win.flrque.university.sumacalk;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number[] = new int[2];

        final Scanner scanner = new Scanner(System.in);
        for(int i=0; i<number.length; i++) {
            System.out.println("Podaj liczbe [" + (i+1) + "]:");
            number[i] = scanner.nextInt();
        }

        int sum = 0;
        final StringBuilder result = new StringBuilder();

        for(int i=0; i<number.length; i++) {
            result.append(i<1 ? number[i] : " + " + number[i]);
            sum += number[i];

        }

        result.append(" = ").append(sum);

        System.out.println(result.toString());
    }
}
