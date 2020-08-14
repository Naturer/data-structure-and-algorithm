public class Demo1 {
    public static void main(String[] args) {
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
