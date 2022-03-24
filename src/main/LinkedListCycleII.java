import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表 II：https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {

    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (!nodes.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

}
