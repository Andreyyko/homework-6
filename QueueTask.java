import java.util.LinkedList;

public class QueueTask<Q> extends LinkedList<Q> {

    public Q enqueue(Q add){
        super.addLast(add);
        return super.getFirst();
    }

    public Q dequeue(){
        return super.removeLast();
    }
}
