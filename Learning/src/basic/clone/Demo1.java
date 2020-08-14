package basic.clone;

import java.util.Arrays;

public class Demo1 {

    /**
     * 测试一个对象里面含有对象属性时的克隆情况
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        //    Address address = new Address();
        Person p1 = new Person();
        p1.setName("yyh");
        p1.setAddress(new Address("henan"));
        p1.ints = new int[]{3, 5, 7};
        Person clone = (Person) p1.clone();
        System.out.println(p1 == clone);
        System.out.println(p1.getAddress() == clone.getAddress());
        System.out.println(p1.ints == clone.ints);

        System.out.println("-----------");
        p1.setName("hhhh");
        clone.setAddress(new Address("beijing"));
        System.out.println( p1.getName() == clone.getName());
        System.out.println(p1);
        System.out.println(clone);
        System.out.println("==================");


//        int[] a = {1,2,3};
//
////        int[] aClone = a.clone();
//
//        int[] copy = Arrays.copyOf(a, a.length);
//        a[0] = 3;
//        System.out.println(a == copy);
//        System.out.println(copy[0]);
//        System.out.println(a == aClone);
    }
}
