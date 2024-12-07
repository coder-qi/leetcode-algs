/**
 * 删除排序链表中的重复元素：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(deleteDuplicates(ListNode.of(1,1,2)));
        System.out.println(deleteDuplicates(ListNode.of(1,1,2,3,3)));
    }

}
