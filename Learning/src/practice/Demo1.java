package practice;

import lesson01.function.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
//        test1();
//        test2();
//        teat3();
//        test4();
        test5();
    }

    private static void test5() {
//定义ConcurrentHashMap
        Map map = new HashMap();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
//多线程下的put可以放心使用
                    map.put(UUID.randomUUID().toString(),
                            "1");
                }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(map);
        System.out.println(map.size());
    }

    private static void test4() {
        List<String> receivers = new ArrayList<>();
        receivers.add("1");
        receivers.add("1");
        receivers.add("2");
        receivers.add("1");
        receivers = receivers.stream().distinct().collect(Collectors.toList());
        System.out.println(receivers);

    }

    private static void teat3() {
        practice.domain.Student student = new practice.domain.Student();
        System.out.println(student);
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
