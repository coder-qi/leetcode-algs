/**
 * 环形链表 II：https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            } else {
                fast = fast.next.next;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode node = detectCycle(ListNode.ofCycle(new int[] {3, 2, 0, -4}, 1));
        System.out.println(node.val);

        node = detectCycle(ListNode.ofCycle(new int[] {1, 2}, 0));
        System.out.println(node.val);

        node = detectCycle(ListNode.of(1));
        System.out.println(node);

        node = detectCycle(ListNode.ofCycle(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3));
        System.out.println(node.val);
    }

}
