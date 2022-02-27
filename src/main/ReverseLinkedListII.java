/**
 * 反转链表 II：https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        head = dummy;

        int pos = 1;
        while (pos < left) {
            head = head.next;
            pos++;
        }

        ListNode reverseHead = new ListNode();
        ListNode cur = head.next;
        while (pos <= right) {
            ListNode t = cur;
            cur = cur.next;
            t.next = reverseHead;
            reverseHead = t;

            pos++;
        }
        head.next.next = cur;
        head.next = reverseHead;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(reverseBetween(ListNode.of(1,2,3,4,5), 2, 4));
        System.out.println(reverseBetween(ListNode.of(5), 1, 1));
    }

}
