package practice;

import lesson01.function.Student;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Demo1 {

    static LinkedList<Integer> lru = new LinkedList<Integer>();

    static {
        lru.add(1);
        lru.add(2);
        lru.add(3);
    }

    public static void main(String[] args) {
//        test1();
//        test2();
//        teat3();
//        test4();
//        test5();
        test6();
    }

    private static void test6() {


//        LinkedList<Integer> lru = new LinkedList<Integer>();
//        lru.add(1);
//        lru.add(2);
//        lru.add(3);
        Iterator<Integer> lit = lru.iterator();
        while (lit.hasNext()) {
            int s = lit.next();
            if (s == 1) {
                lru.add(5);
                return;
            }
        }
//        LinkedList<Integer> lru = new LinkedList<Integer>();
//        lru.add(1);
//        lru.add(2);
//        lru.add(3);
//
//        Iterator<Integer> iterator = lru.iterator();
//        int index = 0;
//        while (iterator.hasNext()){
//            int j = iterator.next();
//            if (2 == j){
//                System.out.println("find it!");
//                lru.remove(index);
//                lru.addFirst(j);
//                return ;
//            }
//            index++;
//        }
    }

    //验证hashmap的put不安全
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
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
