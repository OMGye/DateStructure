/**
 * Created by upupgogogo on 2018/4/26.下午12:43
 */
public interface Queue<E> {

     void enqueue(E e);  //入队

     E dequeue();   //出队并返回

     E getFront();  //查看队首元素

     int getSize();

     boolean isEmpty();

}
