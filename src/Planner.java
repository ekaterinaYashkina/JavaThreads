import java.util.List;

public class Planner implements Runnable {

    private final Reporter[] reporters;
    private final int timeout;
    private final Object lock;
    private int count;
    private long millies;

    public Planner(Reporter[] reports, int timeout, Object lock){
        this.reporters = reports;
        this.timeout = timeout;
        this.lock = lock;
        this.millies = 0;
    }

    public void run(){
        while (!Thread.currentThread().isInterrupted()){
//            try{
//                Thread.sleep(timeout);
//            }
//            catch (InterruptedException e){
//                Thread.currentThread().interrupt();
//            }

            synchronized (lock) {
                while (millies<timeout && !Thread.currentThread().isInterrupted()) {
                    try {
                        long currentMillies = System.currentTimeMillis();
                        lock.wait();
                        millies += System.currentTimeMillis()-currentMillies;
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

                    for (Reporter r:reporters){
                        r.describe();
                    }
                    millies = 0;

            }
        }
}
