public class 合并两个有序链表_21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        l1.add(2);
        l1.add(4);
        l1.add(6);
        ListNode l2 = new ListNode(1);
        l2.add(3);
        l2.add(5);
        l2.add(7);
        ListNode listNode = mergeTwoLists(l1, l2);
        listNode.print();
    }
}
