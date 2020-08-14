package basic.collection.linkedlist;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.

        当删除了倒数第二个节点后，链表变为 1->2->3->5.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _19_Solution {

    static class ListNode {
        int      val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] intArray = { 2, 1, 45, 84, 5234, 6, 1, 0 };
        ListNode head = initData(intArray);
        System.out.println(toString(removeNthFromEnd(head, 7)));
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int j = 0; j < n; j++) {
            fast = fast.next;
        }
        if (fast == null) {//此时删除的是第一个节点
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;//删除slow.next
        return head;
    }

    /*我的思路：用快指针来计算长度。有点傻。。。。。。。
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = new ListNode(0);
        ListNode slow = new ListNode(0);
        fast.next = head;
        slow.next = head;
        int lenght = 0;
        int num = 0;
        int target = 0;
        while (slow.next != null) {
            if (fast == null) {
                lenght = num * 2 - 1;
                target = lenght - n + 1;
            }
            if (lenght == 0) {
                if (fast.next == null) {
                    lenght = num * 2;
                    target = lenght - n + 1;
                }
            }
            if (target == num +1) {
                break;
            }
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
            }
            slow = slow.next;
            num++;
        }
        slow.next = slow.next.next;
        return head;
    }*/

    //初始化int类型单链表
    private static ListNode initData(int[] intArray) {
        ListNode first = null;
        ListNode node = null;
        for (int i = 0; i < intArray.length; i++) {
            if (i == 0) {
                first = new ListNode(intArray[i]);
                node = first;
            }
            if (i + 1 < intArray.length) {
                node.next = new ListNode(intArray[i + 1]);
            } else {
                node.next = null;
            }
            node = node.next;
        }

        return first;
    }

    //打印链表
    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode node;
        if ((node = head) != null) {
            do {
                sb.append(node.val).append(",");
            } while ((node = node.next) != null);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
