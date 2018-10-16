import java.util.HashMap;
import java.util.Map;

public class ModuloConsumer implements Consumer, Reporter{
    private final Map<Integer, Integer> values;

    public ModuloConsumer(){
        values = new HashMap<>();
    }
    public synchronized void consume(long number){
        int modulo = (int) (number%10);
        //long amount = values.getOrDefault(modulo, -1);

        values.merge(modulo, 1, (integer, integer2) -> integer+integer2);

    }

    public synchronized void describe(){
        System.out.println(values);
    }
}
