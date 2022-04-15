import java.util.List;

/**
 * 反转链表：https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode x = head.next;
            head.next = result;
            result = head;
            head = x;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseList(ListNode.of(1,2,3,4,5)));
        System.out.println(reverseList(ListNode.of(2,1)));
        System.out.println(reverseList(null));
    }

}
