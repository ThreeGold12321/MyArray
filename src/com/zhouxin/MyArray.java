package com.zhouxin;

import java.util.ArrayList;

/**
 * 自定义数组
 *
 * @param <E>
 */
public class MyArray<E> {
    private E[] data;
    private int size;//数组长度

    public MyArray() {
       this(10);
    }

    public MyArray(int capacity) {
        data = (E[]) new Object[capacity];
    }

    /**
     * 获取数组的长度
     *
     * @return 数组的元素长度
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return 数组的容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return data.length == 0;
    }

    /**
     * 向数组末尾添加元素
     *
     * @param element 元素
     */
    public void addLast(E element) {
        addElement(size, element);
    }

    /**
     * 向数组开头添加元素
     *
     * @param element 元素
     */
    public void addFirst(E element) {
        addElement(0, element);
    }

    /**
     * 向指定位置添加元素
     *
     * @param index   指点位置
     * @param element 元素
     */
    public void addElement(int index, E element) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("AddElement failed! index < 0 || index > size");
        if (size == data.length)
            resize(data.length * 3 / 2);
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    /**
     * 修改某个索引的元素
     *
     * @param index   索引
     * @param element 新元素
     */
    public void set(int index, E element) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed! index < 0 || index >= size");
        data[index] = element;
    }

    /**
     * 获取某个索引的元素
     *
     * @param index 索引
     * @return 元素
     */
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed! index < 0 || index >= size");
        return data[index];
    }

    /**
     * 获取数组的第一个元素
     *
     * @return 元素
     */
    public E getFirst() {
        return data[0];
    }

    /**
     * 获取数组的最后一个元素
     *
     * @return 元素
     */
    public E getLast() {
        return data[size - 1];
    }

    /**
     * 是否包含某个元素
     *
     * @param element 元素
     * @return boolean
     */
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element))
                return true;
        }
        return false;
    }

    /**
     * 查找元素
     *
     * @param element 元素
     * @return 返回元素索引，没有查询到就返回-1
     */
    public int find(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element))
                return i;
        }
        return -1;
    }


    /**
     * 查询所有的元素索引
     *
     * @param element 元素
     * @return 索引
     */
    public int[] findAll(E element) {
        ArrayList<Integer> findLists = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element))
                findLists.add(i);
        }
        if (findLists.size() > 0) {
            int[] finds = new int[findLists.size()];
            for (int i = 0; i < findLists.size(); i++) {
                finds[i] = findLists.get(i);
            }
            return finds;
        } else {
            return null;
        }
    }

    /**
     * 删除指定位置的元素
     *
     * @param index 索引
     * @return E
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed! index < 0 || index >= size");
        if (size == data.length / 2 && data.length * 2 / 3 != 0)
            resize(data.length * 2 / 3);
        E element = data[index];
        for (int i = index; i < size - 1; i++)
            data[i] = data[i + 1];
        data[size - 1] = null;
        size--;
        return element;
    }

    /**
     * 删除第一个元素
     *
     * @return E
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return E
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除某个元素（从左到右第一次出现）
     *
     * @param element 元素
     * @return 是否删除成功
     */
    public boolean removeElement(E element) {
        if (find(element) == -1)
            return false;
        return remove(find(element)).equals(element);
    }

    /**
     * 删除某个元素的所有元素
     *
     * @param element 元素
     * @return 是否删除成功
     */
    public boolean removeAllElement(E element) {
        if (findAll(element) == null)
            return false;
        int[] finds = findAll(element);
        int times = 0; //删除一次该元素则加1，因为数组长度变短了1个单位，但是记录的下标没有跟着变短
        for (int index : finds) {
            remove(index - times);
            times++;
        }
        return true;
    }

    /**
     * 重新定义数组长度（动态数组）
     *
     * @param newCapacity 新的数组长度
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1)
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
