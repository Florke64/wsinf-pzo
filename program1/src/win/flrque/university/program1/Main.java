package win.flrque.university.program1;

public class Main {

    private static final String prefix = "To jest pierwszy program";
    private static final String myName = "Daniel Wasiak";

    public static void main(String[] args) {
        final StringBuilder message = new StringBuilder();

        message.append(prefix).append(" - ").append(myName);

	    System.out.println(message.toString());
    }
}
