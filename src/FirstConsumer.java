public class FirstConsumer implements Consumer, Reporter {
    private volatile Long value = null;
    private String name;

    public FirstConsumer(String name){
        this.name = name;
    }
    public synchronized void consume(long number){
        if (value == null) {
            this.value = number;
        }
    }

    public void describe(){
        String description = String.format("%s :: %d", toString(), value);
            System.out.println(description);
    }

}
