/**
 * Created by upupgogogo on 2018/4/26.下午12:47
 */
public class ArrayQueue<E> implements Queue<E> {

     private Array<E> array;

    @Override
    public int getSize(){
        return array.getSize();
     }
    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e){
        array.addLast(e);
    }

    @Override
    public E dequeue(){
       return array.removeFirst();
    }

    @Override
    public E getFront(){
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue front: ");
        stringBuilder.append("【");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuilder.append(array.get(i));
            if (i != array.getSize() - 1)
                stringBuilder.append(",");
        }
        stringBuilder.append("】");
        return stringBuilder.toString();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }
}
