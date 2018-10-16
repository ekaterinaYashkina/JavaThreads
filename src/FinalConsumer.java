public class FinalConsumer implements Consumer, Reporter {

    private volatile Long value = null;

    public FinalConsumer(){
    }
    public void consume(long number){
            this.value = number;
    }

    public void describe(){
        String desc = String.format("%s :: %d", toString(), value);
    }
}
