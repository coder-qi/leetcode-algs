import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表：https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (!nodes.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

}
