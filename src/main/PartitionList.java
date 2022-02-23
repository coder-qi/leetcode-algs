/**
 * 分隔链表：https://leetcode-cn.com/problems/partition-list/
 */
public class PartitionList {

    public static ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode prev = dummy, prevTail = dummy, cur = dummy.next;
        prev.next = null;
        while (cur != null) {
            if (cur.val < x) {
                ListNode next = prev.next;
                prev.next = cur;
                cur = cur.next;
                prev.next.next = next;

                prev = prev.next;
                if (prevTail.val < x) {
                    prevTail = prev;
                }
            } else {
                prevTail = prevTail.next = cur;
                cur = cur.next;
                prevTail.next = null;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(partition(ListNode.of(1,4,3,2,5,2), 3)); // [1,2,2,4,3,5]
        System.out.println(partition(ListNode.of(2,1), 2)); // [1,2]
    }

}
