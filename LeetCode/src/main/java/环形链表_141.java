import javafx.scene.web.HTMLEditor;

public class 环形链表_141 {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
