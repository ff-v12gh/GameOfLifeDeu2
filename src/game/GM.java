package game;

import java.util.concurrent.ThreadLocalRandom;

public class GM {

    public static final int CELLCOUNT = 512;
    public static boolean[][] cells = new boolean[CELLCOUNT][CELLCOUNT];

    int startCells = 10000;
    static int gen = 0;

    public void setup(){
        for(int i = 0; i<startCells;i++){
            int x = r(0, CELLCOUNT);
            int y = r(0, CELLCOUNT);

            cells[x][y] = true;
        }

    }

    public static void nextGen(){

    }

    public static int neighbours(int x, int y){
        int count = 0;

        //Anfang mitte rechts, Uhrzeigersinn
        int[] xoff = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] yoff = {0, 1, 1, 1, 0, -1, -1, -1};

        for(int i = 0; i<8; i++){
            try {
                if(cells[x+xoff[i]][y+yoff[i]]){
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return count;
    }

    public static int r(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max); // Ggf. max + 1
    }
}
