import java.util.HashSet;
import java.util.Set;

public class 相交链表_160 {
    // 双指针
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        // A!=B
        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        //相等
        return pA;
    }
}
