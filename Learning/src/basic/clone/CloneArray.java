package basic.clone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二维数组直接克隆是浅克隆：int[][] clone = arr.clone();
 */
public class CloneArray {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] arr = {1,32,4};
        int[] temp = arr.clone();
        arr[0] = 90;
        System.out.println(Arrays.toString(temp));
//        cloneIntArr();
//        cloneRefArr();
//        cloneRefOneDimentionArr();
//        cloneRefList();
        ArraysCopyOf();
    }

    /**
     * 一维对象数组克隆，即使重写了clone方法，也不是深克隆。
     */
    public static void cloneRefOneDimentionArr() throws CloneNotSupportedException {
        Person[] arr = {new Person(new Address("p1Addr"),"p1Name"),
                new Person(new Address("p2Addr"),"p2Name"),
        };
//        Person[] clone = arr.clone();//浅克隆
        Person[] clone = new Person[arr.length];
        for (int i = 0; i < arr.length; i++) {
            clone[i] = (Person) arr[i].clone();
        }
        arr[0].getAddress().setAddr("0000");
        System.out.println(Arrays.toString(clone));
    }

    /**
     * list对象集合克隆，重写了clone方法，也不是深克隆
     */
    public static void cloneRefList() throws CloneNotSupportedException {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(new Address("p1Addr"),"p1Name"));
        list.add(new Person(new Address("p2Addr"),"p2Name"));
        ArrayList<Person> clone = new ArrayList(list.size());
        for (Person p : list) {
            clone.add((Person) p.clone());//深克隆
        }
//        List clone = (List) list.clone();//浅克隆，不安全
        list.get(0).getAddress().setAddr("0000");
        System.out.println(clone);
    }

    /**
     * Arrays.copyOf();
     */
    public static void ArraysCopyOf() {
        Person[] arr = {new Person(new Address("p1Addr"),"p1Name"),
                new Person(new Address("p2Addr"),"p2Name"),
        };
//        Person[] clone = arr.clone();
        Person[] clone = Arrays.copyOf(arr, arr.length);
        arr[0].getAddress().setAddr("0000");
        System.out.println(Arrays.toString(clone));
    }

    private static void cloneRefArr() {
        int n1 = 3;
        int n2 = 2;
        Person[][] arr = new Person[n1][n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                arr[i][j] = new Person(new Address("henan"), "yyh");
            }
        }

        for (int i = 0; i < n1; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

//        Person[][] clone = arr.clone();
        Person[][] clone = new Person[n1][n2];
        for (int i = 0; i < n1; i++) {
            clone[i] = arr[i].clone();
        }
        System.out.println(clone == arr);
        System.out.println(clone[0] == arr[0]);//地址是一样的。。。。
        arr[0][0].getAddress().setAddr("luoyang");
        for (int i = 0; i < n1; i++) {
            System.out.println(Arrays.toString(clone[i]));
        }
    }

    //克隆int数组
    private static void cloneIntArr() {
        int n1 = 3;
        int n2 = 2;
        int[][] arr = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                arr[i][j] = (int) (Math.random() * 100);
            }
        }

        for (int i = 0; i < n1; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

//        int[][] clone = arr.clone();
        int[][] clone = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            clone[i] = arr[i].clone();
        }
        System.out.println(clone == arr);
        System.out.println(clone[0] == arr[0]);//地址是一样的。。。。
        arr[0][0] = 2333;
        for (int i = 0; i < n1; i++) {
            System.out.println(Arrays.toString(clone[i]));
        }
    }
}
