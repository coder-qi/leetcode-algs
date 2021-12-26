/**
 * 合并两个有序链表：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list2 == null) {
            return list1;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (true) {
            if (list1 == null && list2 == null) {
                break;
            }
            int v1 = list1 != null ? list1.val : Integer.MAX_VALUE;
            int v2 = list2 != null ? list2.val : Integer.MAX_VALUE;
            if (v1 < v2) {
                prev = prev.next = new ListNode(v1);
                list1 = list1.next;
            } else {
                prev = prev.next = new ListNode(v2);
                list2 = list2.next;
            }
        }
        ListNode ans = dummy.next;
        dummy.next = null;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mergeTwoLists(ListNode.of(1,2,4), ListNode.of(1,3,4))); // [1,1,2,3,4,4]
        System.out.println(mergeTwoLists(ListNode.of(), ListNode.of())); // []
        System.out.println(mergeTwoLists(ListNode.of(), ListNode.of(0))); // [0]
    }

}
