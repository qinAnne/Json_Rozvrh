package cz.uhk.jsonrozvrh;

import cz.uhk.jsonrozvrh.gui.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{new MainWindow().setVisible(true);});
    }
}
