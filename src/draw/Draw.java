package draw;

import game.GM;
import gui.Gui;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel { // Auf einem JLabel zeichnen
    protected void paintComponent(Graphics g) { // Die Eigenschaften von Graphics g (neu) definieren (überschreiben)
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; // Als 2D-Objekt casten

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF); // Antialiasing ausschalten, um Pixel scharf zu sehen

        g.setColor(Color.RED); // Rahmen des Objekts: Farbe
        g.drawRect(9, 9, Gui.WIDTH + 2, Gui.HEIGHT + 2); // Form des Rahmens: Rechteck; Genau um Spielfeld herum (x: 9, y: 9); So breit und hoch wie Spielfeld + 2

        for (int x = 0; x < GM.CELLCOUNT; x++) {
            for (int y = 0; y < GM.CELLCOUNT; y++) {
                if (GM.cells[x][y]) { // Wenn Zelle lebt, färbe den Pixel an genau der Stelle schwarz
                    g.setColor(Color.BLACK);
                    g.drawRect(x + Gui.XOFF, y + Gui.YOFF, 1, 1);
                    // GGf. g.fillRect() ergänzen, falls Zellen größer werden

                } else { // Wenn Zelle tot, färbe den Pixel an genau der Stelle weiß
                    g.setColor(Color.WHITE);
                    g.drawRect(x + Gui.XOFF, y + Gui.YOFF, 1, 1);
                }
            }
        }

        repaint(); // Spielfeld wird „neu“ gezeichnet
    }
}
