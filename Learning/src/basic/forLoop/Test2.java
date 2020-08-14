package basic.forLoop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 50000; i++) {
            list.add(11);
        }

        int size = list.size();
        int c1 = 1;
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            c1 = list.get(i);
        }
        System.out.println("for + get(i)方法: " + (System.currentTimeMillis() - start));

        long start2 = System.currentTimeMillis();
        for (int c2 : list) {
            c1 = c2;
        }
        System.out.println("Iterator(foreach)方法:" + (System.currentTimeMillis() - start2));
    }

}
