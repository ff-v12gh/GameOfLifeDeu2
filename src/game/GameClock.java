package game;

public class GameClock extends Thread {

    public static boolean running = true; // Läuft, bis er pausiert wird

    public void run(){
        while(running) {
            try {
                sleep(50); // Thread wartet 50ms
                GM.nextGen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
