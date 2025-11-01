import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 3217. 从链表中移除在数组中存在的节点：https://leetcode.cn/problems/delete-nodes-from-linked-list-present-in-array
 */
public class DeleteNodesFromLinkedListPresentInArray {

    public ListNode modifiedList(int[] nums, ListNode head) {
        Arrays.sort(nums);
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        while (prev.next != null) {
            if (Arrays.binarySearch(nums, prev.next.val) >= 0) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }

}
