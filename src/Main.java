import java.util.ArrayList;

public class Main {
    public static Object lock = new Object();
    public static void main(String[] args) {
        Monitor m = new Monitor();
        Chronometer c = new Chronometer(m);
        ArrayList consumers = new ArrayList<>();
        consumers.add(new FirstConsumer("cons1"));
        consumers.add(new FinalConsumer("cons2"));
        consumers.add(new ModuloConsumer("cons3"));
        consumers.add(new StoreConsumer("cons4"));
        Planner p = new Planner(consumers, 5, m);

        Thread thread1 = new Thread(c);
        Thread thread2 = new Thread(p);
        thread1.start();
        thread2.start();
    }


}
