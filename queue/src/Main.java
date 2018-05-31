
/**
 * Created by upupgogogo on 2018/4/27.下午6:38
 */
public class Main {


    public static double testQueue(Queue queue, int opCount){
        long start = System.nanoTime();

        for (int i = 0; i < opCount; i++)
            queue.enqueue(i);
        for (int i = 0; i < opCount; i++)
            queue.dequeue();
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }


    public static void main(String[] args) {
        int opCount = 500000;
        ArrayQueue arrayQueue = new ArrayQueue();
        System.out.println(testQueue(arrayQueue,opCount));
        LoopQueue loopQueue = new LoopQueue();
        System.out.println(testQueue(loopQueue,opCount));

    }
}
