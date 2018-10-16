public class StoreConsumer implements Consumer, Reporter {
    private volatile long value = 0;
    private String name;

    public StoreConsumer(String name){
        this.name = name;
    }

    public synchronized void consume(long number){
        value +=number;
    }

    public void describe(){
        String description = String.format("%s :: %d", toString(), value);
        System.out.println(description);
    }
}
