package game;

import java.util.concurrent.ThreadLocalRandom;

public class GM { // GameMaster

    public static final int CELLCOUNT = 512; // Länge einer Seite des Spielfelds
    public static boolean[][] cells = new boolean[CELLCOUNT][CELLCOUNT]; // Spielfeld mit 512*512 Zellen; wahr = lebendig, false = tot

    int startCells = 10000; // Menge an Anfangszellen
    static int gen = 0; // Nummer der Generation: 0. Generation

    public void setup() { // Belegt zufällig Zellen mit true (lebendig)
        for (int i = 0; i < startCells; i++) {
            int x = r(0, CELLCOUNT);
            int y = r(0, CELLCOUNT);

            cells[x][y] = true;
        }

    }

    public static void nextGen() {
        gen++; // Erhöht Nummer der Generation um 1
        System.out.println("Generation: " + gen); // Druckt Nummer der aktuellen Generation

        for (int x = 0; x < CELLCOUNT; x++) {
            for (int y = 0; y < CELLCOUNT; y++) {
                int n = neighbours(x, y); // Ruft neighbours

                // Regel 1: Wiederbeleben, wenn genau drei lebendige Nachbarn
                if (n == 3 && !cells[x][y]) {
                    cells[x][y] = true;
                }

                // Regel 2: Unterbevölkerung, wenn weniger als zwei lebendige Nachbarn
                if (n < 2) {
                    cells[x][y] = false;
                }

                // Regel 3: Am Leben bleiben, wenn genau zwei oder drei lebendige Nachbarn
                if (n == 2 || n == 3) {
                    // Zelle bleibt unverändert; der Vollständigkeit halber trotzdem aufgeführt
                }

                // Regel 4: Überbevölkerung, wenn mehr als drei lebendige Nachbarn
                if (n > 3) {
                    cells[x][y] = false;
                }
            }

        }

    }

    public static int neighbours(int x, int y) { // Zählt die Anzahl an lebendigen Nachbarn einer Zelle
        int count = 0;

        //Start: Mitte Rechts, Uhrzeigersinn
        int[] xoff = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] yoff = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 0; i < 8; i++) {
            try {
                if (cells[x + xoff[i]][y + yoff[i]]) { // Geht Nachbarn im Uhrzeigersinn (Start: Mitte Rechts) durch
                    count++; // Wenn Nachbarzelle lebt, wird counter um 1 erhöht
                }
            } catch (Exception e) { // Fängt Spielfeldrand-Randfälle ab
                // ignorieren
            }
        }

        return count;
    }

    public static int r(int min, int max) { // Berechnet Zufallswert zwischen [min und max[
        return ThreadLocalRandom.current().nextInt(min, max); // Ggf. max + 1; http://www.tutego.de/blog/javainsel/2013/06/threadlocalrandom-als-schneller-paralleler-zufallszahlengenerator/
    }
}
