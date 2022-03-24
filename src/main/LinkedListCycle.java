/**
 * 环形链表：https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            if (head.next == dummy) {
                return true;
            }
            ListNode node = head;
            head = head.next;
            node.next = dummy;
        }
        return false;
    }

}
