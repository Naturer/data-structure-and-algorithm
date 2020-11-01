package dataStructure;

import java.util.Arrays;

//堆是一种完全二叉树，完全二叉树，很适合用数组来实现（下标为0的位置一般空着）。下面代码以最小堆为例
public class Heap {

    private int capacity;

    //堆
    private static int[] a;

    private int size = 0; //下标为0的位置一般空着

    public Heap(int capacity) {
        this.capacity = capacity;
        a = new int[capacity + 1];
    }

    //堆中插入元素（从下向上的堆化）
    void insert(int e) {
        if (size >= capacity)
            return;
        a[++size] = e;
        int i = size;
        while (i / 2 > 0 && a[i] < a[i / 2]) {
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    //删除堆顶元素
    void removeMax() {
        if (size == 0) return;
        a[1] = a[size];
        size--;
        heapfy(a, size, 1);
    }

    //堆排序
    static void sort(int[] a) {
        int size = a.length - 1;
        if (size <= 1) return;
        //先建堆
        for (int i = size / 2; i > 0; i--) {
            heapfy(a, size, i);
        }
        System.out.println(Arrays.toString(a));
        //再排序
        for (int i = size; i >= 2; i--) {
            swap(a, 1, i);
            System.out.println(Arrays.toString(a) + ", i = " + i);
            heapfy(a, i - 1, 1);
            System.out.println(Arrays.toString(a) + ", i = " + i);
        }
        System.out.println(Arrays.toString(a));
    }

    //从上向下的堆化
    private static void heapfy(int[] a, int size, int i) {
        while (true) {
            int minPos = i;
            if (2 * i <= size && a[2 * i] < a[i]) minPos = 2 * i;
            if (2 * i + 1 <= size && a[2 * i + 1] < a[minPos]) minPos = 2 * i + 1;
            if (i == minPos) break;
            swap(a, i, minPos);
            i = minPos;
        }
    }

    private static void swap(int[] a, int x, int y) {
        int temp = a[y];
        a[y] = a[x];
        a[x] = temp;
    }

    @Override
    public String toString() {
        return "HEAP{" +
                "array=" + Arrays.toString(a) +
                '}';
    }

    public static void main(String[] args) {
        Heap heap = new Heap(5);
        heap.insert(3);
        heap.insert(5);
        heap.insert(1);
        heap.insert(8);
        heap.insert(7);
        heap.insert(12);
        heap.insert(5);
        System.out.println(heap);
        System.out.println(heap.size);
        heap.removeMax();
        System.out.println(heap);
        System.out.println(heap.size);
        System.out.println("======");
        sort(new int[]{0, 3, 5, 6, 10, 1, 9, 6});
    }

}
