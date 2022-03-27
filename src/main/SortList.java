/**
 * 排序链表：https://leetcode-cn.com/problems/sort-list/
 */
public class SortList {

    public static ListNode sortList(ListNode head) {
        var dummy = new ListNode(0, head);
        var len = 0;
        var p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        for (var step = 1; step < len; step <<= 1) {
            var cur = dummy.next;
            var first = dummy;
            while (cur != null) {
                var left = cur;

                var slow = left;
                var fast = left.next;
                for (int i = 0; i < step - 1; i++) {
                    if (slow != null) {
                        slow = slow.next;
                    }
                    if (fast != null && fast.next != null) {
                        fast = fast.next.next;
                    }
                }
                var right = slow != null ? slow.next : null;
                if (slow != null) {
                    slow.next = null;
                }
                if (fast == null || fast.next == null) {
                    cur = null;
                } else {
                    cur = fast.next;
                    fast.next = null;
                }

                first.next = merge(left, right);
                while (first.next != null) {
                    first = first.next;
                }
            }
        }
        return dummy.next;
    }

    private static ListNode merge(ListNode left, ListNode right) {
        var dummy = new ListNode();
        var p = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        p.next = left != null ? left : right;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(sortList(ListNode.of(4,2,1,3)));
        System.out.println(sortList(ListNode.of(-1,5,3,4,0)));
    }

}
