/**
 * 旋转链表：https://leetcode-cn.com/problems/rotate-list/
 */
public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int n = 0;
        ListNode cur = head;
        while (cur.next != null) {
            n++;
            cur = cur.next;
        }
        ListNode foot = cur;
        n++;

        k = k % n;
        if (k == 0) {
            return head;
        }

        int index = 0;
        cur = head;
        while (cur.next != null && (n - index) > k + 1) {
            cur = cur.next;
            index++;
        }
        ListNode ans = cur.next;
        cur.next = null;
        foot.next = head;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(rotateRight(ListNode.of(1,2,3,4,5), 2));
        System.out.println(rotateRight(ListNode.of(0,1,2), 4));
        System.out.println(rotateRight(ListNode.of(1,2), 2));
    }

}
