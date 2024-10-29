public class MyThreadRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("Le thread runnable " + Thread.currentThread().threadId() + " est en cours d'exécution.");
        }
       
    }
}