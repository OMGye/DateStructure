import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by upupgogogo on 2018/4/24.下午1:31
 */
public class Array<T> {

    private T[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (T[])new Object[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array() {
        this(10);
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向所有元素后添加一个新元素
    public void addLast(T e) {
        add(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(T e) {
        add(0, e);
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, T e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        if (size == data.length){
            resize(data.length * 2);
        }


        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = e;

        size++;
    }

    private void resize(int newCapacity){
        T temp[] = data;
        data = (T[])new Object[newCapacity];
        for (int i = 0; i < size; i++){
            data[i] = temp[i];
        }

        /**
         T newData = (T[])new Object[newCapacity];
         for (int i = 0; i < size; i++){
         newData[i] = data[i];
         }
         date = newDate;
         */
    }

    // 获取index索引位置的元素
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, T e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    //查询数组中是否包含e
    public boolean contain(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    //查询数组中e所在的索引，若干不存在则返回-1
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    //查询数组中所有e所在的索引，若干不存在则返回null
    public Array findAll(T e) {
        Array res = new Array();
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                res.addLast(i);
        }
        if (res.size == 0)
            return null;
        return res;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("remove failed. Index is illegal.");
        T res = data[index];
        for (int i = index; i < size - 1; i++)
            data[i] = data[i + 1];
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return res;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public T removeFirst() {
        return remove(0);
    }

    //从数组中删除最后一个元素, 返回删除的元素
    public T removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素e,并返回其所在索引
    public int removeElement(T e) {
        int res = find(e);
        if (res != -1)
            remove(res);
        return res;
    }

    // 从数组中删除元素所有e,并返回其所在索引
    public Array removeAllElement(T e) {
        Array<Integer> array = new Array<Integer>();
        recursionRemove(e, array);
        if (array.size == 0)
            return null;
        return array;
    }

    public void recursionRemove(T e, Array array) {

        int res = find(e);
        if (res != -1) {
            array.addLast(res);
            remove(res);
            recursionRemove(e, array);
        }

    }

    public Array removeAllElementOther(T e){
        Array<Integer> array = new Array<Integer>();
        for (int i = 0; i < size; i++){
            if (data[i].equals(e)) {
                remove(i);
                array.addLast(i);
            }
        }
        if (array.size == 0)
            return null;
        return array;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(i+"");
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            String str = (String) iterator.next();
            if (str.equals("1"))
                list.remove("1");
            System.out.println(str);
        }
    }

}
