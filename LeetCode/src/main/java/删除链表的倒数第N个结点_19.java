

public class 删除链表的倒数第N个结点_19 {
    /**
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        // 获得长度
        int length = getLength(head);
        ListNode cur = dummy;
        // length=5 n=2
        // 倒数第二个就是正数第四
        // 从第一个节点开始
        for (int i = 1; i < length - n + 1; ++i) {
            //寻找到需要删除节点的前一个节点
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
}