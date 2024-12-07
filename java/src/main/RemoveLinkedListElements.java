/**
 * 移除链表元素：https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return removeElements(head.next, val);
        }
        head.next = removeElements(head.next, val);
        return head;
    }

    public static void main(String[] args) {
        System.out.println(removeElements(ListNode.of(1,2,6,3,4,5,6), 6));
        System.out.println(removeElements(null, 1));
        System.out.println(removeElements(ListNode.of(7,7,7,7), 7));
    }

}
