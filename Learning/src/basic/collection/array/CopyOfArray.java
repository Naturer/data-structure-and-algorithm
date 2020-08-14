package basic.collection.array;

import java.util.Arrays;

public class CopyOfArray {

    public static void main(String[] args) {
        int[] a = {3,5,6};
        int[] clone = a.clone();
        a[0] = 1;
        System.out.println(Arrays.toString(clone));
        System.out.println(Arrays.toString(a));

        a = null;
        System.out.println(Arrays.toString(clone));
        System.out.println(Arrays.toString(a));

    }
}
