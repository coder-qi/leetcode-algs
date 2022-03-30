import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLinkedLists {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodes = new HashSet<>();
        while (headA != null) {
            nodes.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (!nodes.add(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        // 4 -> 1
        ListNode headA = new ListNode(4);
        ListNode headANext = headA;
        headANext.next = new ListNode(1);
        headANext = headANext.next;

        // 5 -> 6 -> 1
        ListNode headB = new ListNode(5);
        ListNode headBNext = headB;
        headBNext.next = new ListNode(6);
        headBNext = headBNext.next;
        headBNext.next = new ListNode(1);
        headBNext = headBNext.next;

        // -> 8 -> 4 -> 5
        headANext.next = ListNode.of(8,4,5);
        headBNext.next = headANext.next;

        System.out.println(getIntersectionNode(headA, headB));
    }

}
