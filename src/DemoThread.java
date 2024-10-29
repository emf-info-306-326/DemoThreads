public class DemoThread {
    public static void main(String[] args) {
        /* 
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThreadRunnable runnable = new MyThreadRunnable();
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        */


        Compteur compteur = new Compteur();

        Thread t1 = new CompteurThread(compteur);
        Thread t2 = new CompteurThread(compteur);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join(); // Attend que le thread t2 termine
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // Attend que le thread t1 termine
        
        // Vider la mémoire
        System.gc();

        System.out.println("Valeur finale du compteur : " + compteur.getCount());
        
    }
}