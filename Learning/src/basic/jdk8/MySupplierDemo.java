package basic.jdk8;

import java.util.function.Supplier;

public class MySupplierDemo {

    public static Integer getMin(Supplier<Integer> supplier){

        return supplier.get();
    }

    public static void main(String[] args) {

        int[] arr = {100,20,50,30,99,101,-50};

//        m1(arr);

        Supplier supplier2 = ()->"111";
        Supplier supplier = ()->{
            int min = arr[0];

            for (int i : arr) {
                if (i < min) {
                    min = i;
                }
            }

            return min;
        };
        System.out.println(supplier.get());
    }

    private static void m1(int[] arr) {
        Integer result = getMin(() -> {
            int min = arr[0];

            for (int i : arr) {
                if (i < min) {
                    min = i;
                }
            }

            return min;
        });

        System.out.println(result);
    }
}
