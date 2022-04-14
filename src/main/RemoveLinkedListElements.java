/**
 * 移除链表元素：https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head), prev = dummy;
        while (head != null) {
            if (head.val == val) {
                head = prev.next = head.next;
            } else {
                prev = head;
                head = head.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(removeElements(ListNode.of(1,2,6,3,4,5,6), 6));
        System.out.println(removeElements(null, 1));
        System.out.println(removeElements(ListNode.of(7,7,7,7), 7));
    }

}
