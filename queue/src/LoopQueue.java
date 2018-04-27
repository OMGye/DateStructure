/**
 * Created by upupgogogo on 2018/4/26.下午6:02
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int size;

    private int front;

    private int tail;

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
        front = 0;
        tail = 0;
    }

    public LoopQueue(){
        this(10);
    }

    @Override
    public int getSize(){
        return this.size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void enqueue(E e){
        if (size == getCapacity() ){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue(){
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public E getFront(){
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        E ret = data[front];
        return ret;

    }

    public int getCapacity(){
        return data.length ;
    }


    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[(i+front) % data.length];
        data = newData;
        front = 0;
        tail = size;

    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = 0; i < size; i++){
            res.append(data[(i+front) % data.length]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){

        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

        }
        for (int i = 0; i < 5; i++){
            queue.dequeue();
            System.out.println(queue);
        }
        for (int i = 1; i < 5; i++){
            queue.enqueue(i);
            System.out.println(queue);
        }
        for (int i = 0; i < 5; i++){
            queue.dequeue();
            System.out.println(queue);
        }
    }
}
