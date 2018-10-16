import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chronometer implements  Runnable {
    private final Object lock;

    public Chronometer(Object lock){
        this.lock = lock;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            synchronized (lock){
                lock.notifyAll();
            }

        }

    }
}
