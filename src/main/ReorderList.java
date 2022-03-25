/**
 * 重排链表：https://leetcode-cn.com/problems/reorder-list/
 */
public class ReorderList {

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        slow = head2.next;
        head2.next = null;
        while (slow != null) {
            ListNode t = slow;
            slow = slow.next;
            t.next = head2;
            head2 = t;
        }

        while (head != null && head2 != null) {
            ListNode t = head2.next;
            head2.next = head.next;
            head.next = head2;

            head = head2.next;
            head2 = t;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 4);
        reorderList(head);
        System.out.println(head);

        head = ListNode.of(1,2,3,4,5);
        reorderList(head);
        System.out.println(head);

        head = ListNode.of(1);
        reorderList(head);
        System.out.println(head);

        head = ListNode.of(1,2,3,4,5,6,7);
        reorderList(head);
        System.out.println(head);
    }

}
