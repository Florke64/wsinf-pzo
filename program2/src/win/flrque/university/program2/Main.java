package win.flrque.university.program2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<String> text = new ArrayList<>();

    public static void main(String[] args) {
        text.add("To jest pierwszy program");
        text.add("Daniela Wasiaka");

        for(String line : text)
            System.out.println(line);
    }
}

