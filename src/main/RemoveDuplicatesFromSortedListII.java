import java.util.List;

/**
 * 删除排序链表中的重复元素 II：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesFromSortedListII {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);

        head = dummy.next;
        dummy.next = null;
        return head;
    }

    public static void main(String[] args) {

    }

}
