import java.util.HashSet;
import java.util.Set;

/**
 * 3217. 从链表中移除在数组中存在的节点：https://leetcode.cn/problems/delete-nodes-from-linked-list-present-in-array
 */
public class DeleteNodesFromLinkedListPresentInArray {

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numSet = new HashSet<>(nums.length);
        for (int num : nums) {
            numSet.add(num);
        }
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        while (prev.next != null) {
            if (numSet.contains(prev.next.val)) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }

}
