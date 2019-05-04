package gui;

import draw.Draw;

import javax.swing.*;

public class Gui {

    JFrame jf; // Aus Swing-Klasse; Anti-Alialising kann deaktiviert werden

    public static Draw d; // Draw-Objekt zeichnet im GUI

    public static final int WIDTH = 512, HEIGHT = 512, XOFF = 10, YOFF = 10; // Spielfeld im Fenster definieren; Offset ist Abstand zum Rand des Fensters

    public void create() { // Erstellt das Fenster
        jf = new JFrame("Game of Life"); // Titel des Fensters
        jf.setSize(550, 570); // Größe des Fensters; ggf. abhänging von Nutzereingaben machen
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Schließbar machen
        jf.setLocationRelativeTo(null); // In der Mitte des Hauptbildschirms positionieren
        jf.setResizable(false); // Feste Fenstergröße

        d = new Draw();
        d.setBounds(0, 0, 550, 570); // Größe des Draw-Objekts innerhalb des Fensters (JFrame), genau gleich
        d.setVisible(true); // Sichtbar
        jf.add(d); // Draw-Objekt dem Fenster hinzufügen (JFrame)

        jf.setVisible(true);
    }
}
