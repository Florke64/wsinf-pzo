package win.flrque.university.wizytowka;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final Wizytowka personal = new Wizytowka();
        personal.addLine("Daniel Wasiak");
        personal.addLine("93-300 Łódź");
        personal.addLine("ul. Przedświt 4/4");
        personal.addLine("tel. 7300 760 24");

        final Wizytowka professional = new Wizytowka();
        professional.addLine("Daniel Wasiak");
        professional.addLine("Student kierunku Informatyka");
        professional.addLine("WSiNF - Semestr 2");
        professional.addLine("93-300 Łódź");
        professional.addLine("ul. Rzgowska 17a");
        professional.addLine("tel. 42 27 50 159");

        personal.draw();
        professional.draw();
    }

    private static class Wizytowka {

        private final List<String> information = new LinkedList<>();

        private static final char DECORATIVE_CHARACTER = '*';
        private static final int SPACE_BACKUP = 5;

        private static int longestTextLine = 0;

        protected void addLine(String text) {
            information.add(text);

            if(text.length() > longestTextLine)
                longestTextLine = text.length();
        }

        protected void draw() {
            drawDecorativeLine(true);
            for(String info : information) {
                final StringBuilder textLine = new StringBuilder();
                textLine.append(DECORATIVE_CHARACTER).append(info);

                for(int i=info.length(); i<longestTextLine+SPACE_BACKUP-2; i++)
                    textLine.append(" ");

                textLine.append(DECORATIVE_CHARACTER);

                System.out.println(textLine.toString());
            }

            drawDecorativeLine(false);
        }

        private void drawDecorativeLine(boolean header) {
            if(header) System.out.println();

            for(int i=0; i<longestTextLine+SPACE_BACKUP; i++) {
                System.out.print(DECORATIVE_CHARACTER);
            }

            System.out.println();

            if(!header) System.out.println();
        }

    }

}

