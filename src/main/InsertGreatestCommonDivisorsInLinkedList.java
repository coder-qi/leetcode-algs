/**
 * 2807. 在链表中插入最大公约数：https://leetcode.cn/problems/insert-greatest-common-divisors-in-linked-list/description/
 */
public class InsertGreatestCommonDivisorsInLinkedList {

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            ListNode newNode = new ListNode(gcd(cur.val, next.val));
            cur.next = newNode;
            newNode.next = next;
            cur = next;
        }
        return head;
    }

    private static int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

}
