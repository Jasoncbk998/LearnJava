
public class 反转链表_206 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        // 1,2,3,4,5
        while (curr != null) {
            // 2,3,4,5
            ListNode next = curr.next;
            // 1
            curr.next = prev;
            // 1,null
            prev = curr;
            // 2,3,4,5
            curr = next;
        }
        return prev;
    }
}
