package win.flrque.university.okienko;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Okienko extends Frame implements WindowListener {

    public Okienko() {
        super("Pierwszy program okienkowy");
        setSize(700, 400);
        setVisible(true);
        repaint();

        this.addWindowListener(this);
    }

    private static Okienko instance;

    public static void main(String[] args) {
        instance = new Okienko();
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }
}
