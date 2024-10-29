public class Compteur {
    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println("Thread " + Thread.currentThread().threadId() + " : " + count);
    }

    public int getCount() {
        return count;
    }
}
