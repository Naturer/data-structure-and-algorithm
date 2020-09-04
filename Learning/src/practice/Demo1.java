package practice;

import lesson01.function.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Demo1 {
    public static void main(String[] args) {
//        test1();
//        test2();
        teat3();
    }

    private static void teat3() {
        String a = "hel";
        System.out.println(a.substring(3, a.length()));
    }

    private static void test2() {
        Supplier<Student> su = Student::new;
        su.get();
        IntSupplier swim = Student::swim;
        swim.getAsInt();
    }

    private static void test1() {
        ListNode head = null;
        boolean isOpen = false;

        // 如果开启了断言，会将isOpen的值改为true
        assert isOpen = true;

        // 打印是否开启了断言，如果为false，则没有启用断言
        System.out.println(isOpen);


//        System.out.println(removeNthFromEnd(head, 7));
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        assert head != null;
        return head.next;
    }
    
    static class ListNode {
        int      val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
