import java.util.List;

/**
 * 反转链表：https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }

    public static void main(String[] args) {
        System.out.println(reverseList(ListNode.of(1,2,3,4,5)));
        System.out.println(reverseList(ListNode.of(2,1)));
        System.out.println(reverseList(null));
    }

}
