package leetcode.array;

import java.util.Arrays;
import java.util.List;

/**
 * 自己实现ArrayList
 */
public class ArrayList<E>{
    Object[] elements;

    int size;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList(){
        elements = EMPTY_ELEMENTDATA;
    }

    public ArrayList(int initCapacity) {
        if(initCapacity < 0){
            throw new RuntimeException();
        } else if(initCapacity == 0 ){
            elements = EMPTY_ELEMENTDATA;
        } else {
            elements = new Object[initCapacity];
        }
    }

    public void add(E e){
        ensureCapacity(size + 1);
        elements[size++] = e;
    }

    public E remove(int index) {
        if(index>=size || index <0 ){
            throw new RuntimeException();
        }
        E oldValue = (E) elements[index];
        int numMoved = elements.length - index -1;
        if(numMoved > 0){
            System.arraycopy(elements, index+1, elements, index, numMoved);
        }
        elements[--size] = null;
        return oldValue;
    }

//    public E remove(int index) {
//        if(index>=size || index <0 ){
//            throw new RuntimeException();
//        }
//        E oldValue = (E) elements[index];
//        int numMoved = elements.length - index -1;
//        if(numMoved > 0){
//            System.arraycopy(elements, index+1, elements, index, numMoved);
//        }
//        elements[--size] = null;
//        return oldValue;
//    }

    private void ensureCapacity(int minCapacity) {
        if(elements == EMPTY_ELEMENTDATA){
            minCapacity = Math.max(minCapacity,DEFAULT_CAPACITY);
        }
        if(elements.length - minCapacity >0){
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if(newCapacity - minCapacity>0) {
            newCapacity = minCapacity;
        }
        if(newCapacity - MAX_ARRAY_SIZE >0){
            newCapacity = Integer.MAX_VALUE;
        }
        elements = Arrays.copyOf(elements, newCapacity);
    }


}
