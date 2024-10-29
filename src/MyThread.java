/**
 * MyThread class
 */
public class MyThread extends Thread {

    private boolean running = true;

    /**
     * Run method
     */
    @Override
    public void run() {
        while (running) {
            System.out.println("Le thread " + Thread.currentThread().threadId() + " est en cours d'exécution.");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
