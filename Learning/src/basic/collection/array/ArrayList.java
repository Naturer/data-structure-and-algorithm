package basic.collection.array;

import java.util.Arrays;

public class ArrayList<E> {
    E[] elements;

    int capacity = 10;
    
    int size = 0;
    
    
    
    public ArrayList() {
        super();
        this.elements = (E[]) new Object[capacity];    
    }
    public ArrayList(E[] elements) {
        super();
        this.elements = elements;
    }
    public ArrayList(E[] elements, int capacity, int size) {
        this.elements = elements;
        this.capacity = capacity;
        this.size = size;
    }
    void remove(int index) throws Throwable{
        elements[index] = null;
        finalize();
    }
    void add(E element) {
        elements[size] = element;
        size ++;
    }
    
    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        System.out.println("元素死亡");
        super.finalize();
    }
    
    @Override
    public String toString() {
        return "ArrayList [elements=" + Arrays.toString(elements) + ", capacity=" + capacity + "]";
    }
    
}
