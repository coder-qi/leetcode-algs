/**
 * 2095. 删除链表的中间节点：https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list
 */
public class DeleteTheMiddleNodeOfALinkedList {

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = next.next;
        next.next = null;
        return head;
    }

}
