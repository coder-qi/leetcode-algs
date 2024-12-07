/**
 * 分隔链表：https://leetcode-cn.com/problems/partition-list/
 */
public class PartitionList {

    public static ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(), small = smallHead;
        ListNode largeHead = new ListNode(), large = largeHead;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = head;
            } else {
                large.next = head;
                large = head;
            }
            head = head.next;
        }
        small.next = largeHead.next;
        large.next = null;
        return smallHead.next;
    }

    public static void main(String[] args) {
        System.out.println(partition(ListNode.of(1,4,3,2,5,2), 3)); // [1,2,2,4,3,5]
        System.out.println(partition(ListNode.of(2,1), 2)); // [1,2]
    }

}
