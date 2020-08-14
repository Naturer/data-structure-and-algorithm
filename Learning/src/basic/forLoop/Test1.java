package basic.forLoop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
//        List<Integer> list = new LinkedList<>();
        int[] arr = new int[500000000];
        for (int i = 0; i < 5000000; i++) {
            arr[i] = 3;
        }

        int size = arr.length;
        int c1 = 1;
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            c1 = arr[i];
        }
        System.out.println("for + get(i)方法: " + (System.currentTimeMillis() - start));

        long start2 = System.currentTimeMillis();
        for (int c2 : arr) {
            c1 = c2;
        }
        System.out.println("Iterator(foreach)方法:" + (System.currentTimeMillis() - start2));
    }

}
