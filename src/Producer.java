import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    private final Consumer[] consumers;

    public Producer(Consumer[] consumers){
        this.consumers = consumers;

    }

    public void run(){
        while(!Thread.currentThread().isInterrupted()){
        long val = ThreadLocalRandom.current().nextLong();
        for (Consumer c:consumers){
            c.consume(val);
        }
    }
    }

}
