package dataStructure;

//top k 问题求解
public class HeapTest {

    private final int capacity;

    //堆
    private static int[] a;

    private int size = 0; //下标为0的位置一般空着

    public HeapTest(int capacity) {
        this.capacity = capacity;
        a = new int[capacity + 1];
    }

    //从上向下的堆化
    private void heapfy(int[] a, int size, int i) {
        while (true) {
            int maxPos = i;
            if (2 * i <= size && a[2 * i] > a[i]) maxPos = 2 * i;
            if (2 * i + 1 <= size && a[2 * i + 1] > a[maxPos]) maxPos = 2 * i + 1;
            if (i == maxPos) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    //堆中插入元素（从下向上的堆化）
    private void insert(int e) {
        a[++size] = e;
        int i = size;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    private void insertAfter(int e) {
        //删除堆顶元素，把新加的元素补到堆顶，然后从上往下堆化
        a[1] = e;
        heapfy(a, size, 1);
    }

    private void swap(int[] a, int x, int y) {
        int temp = a[y];
        a[y] = a[x];
        a[x] = temp;
    }

    private int getTop() {
        return a[1];
    }

    public static void main(String[] args) {
        //假设数组 array 存了初始数据
        int[] array = new int [10000000];
        HeapTest heap = new HeapTest(10);
        for (int i = 0; i < 10; i++) {
            heap.insert(array[i]);
        }
        for (int i = 10; i < array.length ; i++) {
            if (array[i] <= heap.getTop())
                heap.insertAfter(array[i]);
        }
    }
}
