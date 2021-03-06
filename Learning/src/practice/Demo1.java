package practice;

import lesson01.function.Student;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import sun.security.provider.MD5;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
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

    public static void main(String[] args) throws Exception {
//        test0();
//        test1();
//        test2();
//        teat3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
//        int[] a = {1, 2,3,4};
//        test9(a, 4, 4);
//        test10();
//        test11();
        test12();

    }

    private static void test12() {
        List<Integer> list = new LinkedList<>();
        list.add(null);
//        list.add("3");
        list.add(1);
        list.add(null);
        System.out.println(list);

        Map<String, Integer> map = new HashMap<>();
        map.put(null,null);
        map.put(null,55);
        map.put("23",null);
//        System.out.println(map);

        Set<Integer> set = new HashSet<>();
        set.add(null);
        set.add(null);
//        System.out.println(set);

    }

    private static void test0() throws InterruptedException {

// 10是初始大小，0.75是装载因子，true是表示按照访问时间排序
        HashMap<Integer, Integer> m = new LinkedHashMap<>(3, 0.75f, true);
        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);

        m.put(3, 26);
        m.get(5);

        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey());
        }
    }

    private static void test11() {
        String repFileRelaId = "";
        List<String> strings = Collections.singletonList(repFileRelaId);

        System.out.println(CollectionUtils.isEmpty(strings));
        System.out.println(CollectionUtils.isEmpty(new ArrayList<>()));

    }

    private static void test10() {
        TreeMap map = new TreeMap();
        map.put(1, "yyh");
        map.put(2, "yyh2");
        map.put(3, "yyh3");
        map.put(4, "yyh4");

        SortedMap sortedMap = map.tailMap(2);
        System.out.println("map" + map);
        System.out.println("sortedMap" + sortedMap);

//        map.remove(4);
        map.put(1, "yyh5");
        System.out.println("map" + map);
        System.out.println("sortedMap" + sortedMap);

    }

    private static void test9(int[] data, int n, int k) {

// 调用方式：
// int[] a = {1, 2, 3, 4}; printPermutations(a, 4, 4);
// k表示要处理的子数组的数据个数
        if (k == 1) {
            for (int i = 0; i < n; ++i) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < k; ++i) {
            int tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;

            test9(data, n, k - 1);

            tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;
        }
    }

    private static void test8() {
        HashMap<Integer, Integer> m = new LinkedHashMap<>(10, 0.75f, true);
        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);
        m.put(3, 26);
        m.get(5);
        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey());
        }
    }

    private static void test7() {
        HashMap<String, Integer> m = new HashMap<>();
        m.put("你是谁呀", 11);
        m.put("呵呵哒", 11);
        m.put("9", 11);
        m.put("nihao", 11);
        m.put("1", 12);
        m.put("500", 23);
        m.put("6", 23);
        m.put("2", 22);
        System.out.println(m);
        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey());
        }
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
