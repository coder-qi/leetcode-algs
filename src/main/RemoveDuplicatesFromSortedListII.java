/**
 * 删除排序链表中的重复元素 II：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesFromSortedListII {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);

        ListNode cur = head;
        ListNode prev = dummy;
        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                prev = cur;
                cur = cur.next;
            } else {
                int v = cur.val;
                while (cur != null && cur.val == v) {
                    cur = cur.next;
                }
                prev.next = cur;
            }
        }

        head = dummy.next;
        dummy.next = null;
        return head;
    }

    public static void main(String[] args) {
        System.out.println(deleteDuplicates(ListNode.of(1,2,3,3,4,4,5,5)));
        System.out.println(deleteDuplicates(ListNode.of(1,1,1,2,3)));
    }

}
