/**
 * Created by upupgogogo on 2018/4/25.下午8:50
 */
public interface Stack<E> {


    void push(E e);  //入栈

    E pop(); //出栈

    E peek();  //取出栈顶元素

    int getSize(); //栈的元素大小

    boolean isEmpty(); //栈的元素是否为空
}
